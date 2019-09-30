package com.cognizant.cms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cognizant.cms.dao.AdminDaoSql;

/**
 * Servlet implementation class AcceptRegistrationRequest
 */
@WebServlet("/AcceptRegistrationRequest")
public class AcceptRegistrationRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptRegistrationRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String memidd=request.getParameter("id");
		HttpSession session = request.getSession(false);
        Object adminidd=session.getAttribute("adminId");
        String adminId=(String)adminidd;
        System.out.println("sssssssssssssssssssssssssssssssssssssss "+adminId);
		AdminDaoSql adminDaoSql=new AdminDaoSql();
	
		adminDaoSql.AcceptMemberStatus(memidd,adminId);
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
