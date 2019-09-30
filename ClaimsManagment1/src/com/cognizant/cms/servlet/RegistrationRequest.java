package com.cognizant.cms.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.cms.dao.AdminDaoSql;
import com.cognizant.cms.model.Member;


@WebServlet("/RegistrationRequest")
public class RegistrationRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegistrationRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		AdminDaoSql adminDaoSql=new AdminDaoSql();
		ArrayList<Member> memberList=new ArrayList<Member>();
		memberList=adminDaoSql.pendingRegistration();
		System.out.println(memberList);
		request.setAttribute("memberListobj",memberList);
		RequestDispatcher rd=request.getRequestDispatcher("pending_approval.jsp");
		rd.include(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}
