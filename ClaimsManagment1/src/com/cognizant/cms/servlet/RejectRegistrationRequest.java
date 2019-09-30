package com.cognizant.cms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.cms.dao.AdminDaoSql;

/**
 * Servlet implementation class RejectRegistrationRequest
 */
@WebServlet("/RejectRegistrationRequest")
public class RejectRegistrationRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RejectRegistrationRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String memidd=request.getParameter("id");
		int memid=Integer.parseInt(memidd);
		AdminDaoSql adminDaoSql=new AdminDaoSql();
		adminDaoSql.rejectMemberStatus(memid);
		RequestDispatcher rd=request.getRequestDispatcher("adminHome.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
