package com.cognizant.cms.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.cms.dao.ClaimDaoSql;
import com.cognizant.cms.model.Claim;

/**
 * Servlet implementation class ShowClaimById
 */
@WebServlet("/SearchClaimById")
public class SearchClaimById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SearchClaimById() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String id=request.getParameter("searchidd");
		ClaimDaoSql claimDaoSql=new ClaimDaoSql();
		ArrayList<Claim> claimList=claimDaoSql.getClaim(id);
		System.out.println(claimList);
		if(claimList.isEmpty()){
			request.setAttribute("errormsg","claim with this id is not found");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("memberHome.jsp");
			requestDispatcher.forward(request, response);
		}
		else{
		request.setAttribute("claimIdObj", claimList);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("claimSearch.jsp");
        requestDispatcher.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
