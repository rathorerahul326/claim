package com.cognizant.cms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.cms.dao.ConnectionHandler;
import com.cognizant.cms.model.Member;

@WebServlet("/MemberHome")
public class MemberHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MemberHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Connection con = ConnectionHandler.getConnection();
			Member m = new Member();
		 String id=request.getParameter("member_id");
		 String QUERY = "select fn from member where mem_id="+id;
		 try {
				PreparedStatement stmt  = con.prepareStatement(QUERY);
				ResultSet rs = stmt.executeQuery();
				while(rs.next())
				{
					PrintWriter pw=response.getWriter();
					pw.print(rs.getString("fn"));
				}
		 }
		 catch(Exception e)
		 {
			 
		 }
		 request.setAttribute("x", m);
			RequestDispatcher rd = request.getRequestDispatcher("/memberHome.jsp");
			rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
