package com.cognizant.cms.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.cms.dao.ConnectionHandler;
import com.cognizant.cms.model.Claim;

@WebServlet("/ShowEachClaim")
public class ShowEachClaim extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ShowEachClaim() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = ConnectionHandler.getConnection();
		Claim c = new Claim();
		String id=request.getParameter("id");
		System.out.println("Claimid "+id);
		String query = "select * from claim where claim_id=?";
		try
		{
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				String memid = rs.getString("mem_id");
				String work_acc = rs.getString("work_accident");
				String auto_acc = rs.getString("auto_accident");
				java.util.Date d = new java.util.Date(rs.getDate("date_of_accident").getTime());
				System.out.println(d);
				int amount = rs.getInt("claim_amount");
				String claimstat = rs.getString("claim_status");
				String approvestat = rs.getString("approve_status");
				Blob blob=null;
				blob=rs.getBlob("adhaar");
			   	InputStream inputStream = blob.getBinaryStream();
			   	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		        byte[] buffer = new byte[4096];
		        int bytesRead = -1;     
		                 while ((bytesRead = inputStream.read(buffer)) != -1) {
		                     outputStream.write(buffer, 0, bytesRead);                  
		                 }
		                  
		                 byte[] imageBytes = outputStream.toByteArray();
		                 String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		               
		                  request.setAttribute("imm", base64Image);
		              
		                  blob=rs.getBlob("bills");
		  			   	 inputStream = blob.getBinaryStream();
		  			   	 outputStream = new ByteArrayOutputStream();
		  		         buffer = new byte[4096];
		  		         bytesRead = -1;     
		  		                 while ((bytesRead = inputStream.read(buffer)) != -1) {
		  		                     outputStream.write(buffer, 0, bytesRead);                  
		  		                 }
		  		                  
		  		                 imageBytes = outputStream.toByteArray();
		  		                 base64Image = Base64.getEncoder().encodeToString(imageBytes);
		  		                 inputStream.close();
		  		                 outputStream.close();
		  		                  request.setAttribute("imm1", base64Image);
		                 
				c.setClaimid(id);
				c.setMemid(memid);
				c.setWork_acc(work_acc);
				c.setApprove_status(approvestat);
				c.setAuto_acc(auto_acc);
				c.setClaim_status(claimstat);
				c.setClaim_amount(amount);
				c.setDoa(d);
				c.setAdhaar(imageBytes);
				c.setBills(imageBytes);
				
			}
			
		   request.setAttribute("x", c);
			
			
		} 
		catch (SQLException e)
		{
		
			e.printStackTrace();
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewEachClaim.jsp");
        requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
