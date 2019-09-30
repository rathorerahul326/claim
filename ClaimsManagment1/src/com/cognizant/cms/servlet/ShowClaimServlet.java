 package com.cognizant.cms.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.cognizant.cms.dao.ConnectionHandler;
import com.cognizant.cms.util.DateUtil;


@WebServlet(name = "ShowClaim", urlPatterns = { "/ShowClaim" })
@MultipartConfig(maxFileSize = 99999999) 
public class ShowClaimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowClaimServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn=ConnectionHandler.getConnection();
		java.sql.Date sqldoa = null;
		String id=request.getParameter("id");
		String cid=request.getParameter("claimid");
		String doa=request.getParameter("doA");
		System.out.println(doa);
		try {

			java.util.Date date1=DateUtil.convertToDate(doa);
			 sqldoa= convertDateToSQLDate(date1);
			 //System.out.println(date);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.setContentType("multipart/mixed");
		response.setHeader("multipart/form-data", "multipart/mixed");
		String work_acc=request.getParameter("work_acc");
		String amount=request.getParameter("amount");
		String auto_acc=request.getParameter("auto_acc");
		InputStream input1=null,input2=null;
		Part file1=request.getPart("adhar");
		Part file2=request.getPart("file2");
		if(file1!=null)
		{
			  System.out.println(file1.getName());
	            System.out.println(file1.getSize());
	            System.out.println(file1.getContentType());
			input1=file1.getInputStream();
		}
		else
			System.out.println("NULL");
		if(file2!=null)
		input2=file2.getInputStream();
		try {
			PreparedStatement ps=conn.prepareStatement("insert into claim(claim_id,mem_id,work_accident,auto_accident,date_of_accident,claim_amount,claim_status,approve_status,adhaar,bills) values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,cid);
			ps.setString(2, id);
			ps.setString(3, work_acc);
			ps.setString(4, auto_acc);
			ps.setDate(5, sqldoa);
			ps.setString(6, amount);
			ps.setString(7, "open");
            ps.setString(8, "null");
			if(input1!=null)
			ps.setBlob(9,input1);
			if(input2!=null)
			ps.setBlob(10, input2);
            
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//doGet(request, response);
		 getServletContext().getRequestDispatcher("/member-raise-claim-notification.jsp").forward(request, response);
	}
	java.sql.Date convertDateToSQLDate(java.util.Date date) {

		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;

	}

}
