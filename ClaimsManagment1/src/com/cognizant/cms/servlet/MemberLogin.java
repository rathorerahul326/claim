package com.cognizant.cms.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cognizant.cms.dao.ConnectionHandler;
import com.cognizant.cms.dao.MemberDaoSql;
import com.cognizant.cms.model.Member;

@WebServlet("/MemberLogin")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String password = request.getParameter("password");
		String memberid = request.getParameter("memberid");

		MemberDaoSql memberDaoSql = new MemberDaoSql();
		   int i=memberDaoSql.loginMember(memberid,password);
		      if(i==1){
		  			
		  			 String succes= "You are successfully Login";
		  			request.setAttribute("x", memberid);
		  			RequestDispatcher rd = request.getRequestDispatcher("memberHome.jsp");
		  			rd.forward(request, response);
		  			
		  			 
		  		 }
		           if(i==2)
		    		 {
		    			 String str= "Your Request is already send for approval";
		    			 request.setAttribute("errormsg1", str);
		    			 request.getRequestDispatcher("memberlogin.jsp").include(request, response);
		    		 }
		  		  if(i==3)
		  		 {
		  			 String str= "MemberID and Password Does Not Match";
		  			 request.setAttribute("errormsg1", str);
		  			 request.getRequestDispatcher("memberlogin.jsp").include(request, response);
		  		 }
	
	}
}
