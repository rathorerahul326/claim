package com.cognizant.cms.servlet;

import java.io.*;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.cognizant.cms.dao.ClaimDaoSql;
import com.cognizant.cms.dao.ConnectionHandler;
import com.cognizant.cms.model.Member;

/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/FileUpload")
@MultipartConfig
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ArrayList<Member> memberList=new ArrayList<Member>();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String id=request.getParameter("memberid");
		System.out.println("smn");
		
		Part filePart = request.getPart("photo");
		ClaimDaoSql claimDaoSql=new ClaimDaoSql();
		claimDaoSql.fileUpload(filePart);
	    InputStream fileContent = filePart.getInputStream();
		try {
	 		    Connection con=ConnectionHandler.getConnection();
	 		     int idd=1;
	 			PreparedStatement stmt=con.prepareStatement("update  member set file= ? where mem_id='"+idd+"'");
	 			stmt.setBlob(1, fileContent);

	 			System.out.println("Admin Saved Succeessfully");
	 			stmt.executeUpdate();
	 			} catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}  
	}
	

}
