package com.cognizant.cms.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cognizant.cms.dao.AdminDaoSql;
import com.cognizant.cms.dao.ConnectionHandler;
import com.cognizant.cms.dao.MemberDaoSql;
import com.cognizant.cms.model.Admin;
import com.cognizant.cms.model.Member;

@WebServlet("/MemberRegistration")
public class MemberRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  // doGet(request, response);
		   String fname = request.getParameter("fname");
	       String lname=request.getParameter("lname");
	       String agee=request.getParameter("age");
	       int age=Integer.parseInt(agee);
	       String gender=request.getParameter("gender");
	       String contactnumberr=request.getParameter("contactnumber");
	       long contactnumber=Long.parseLong(contactnumberr);
	       String memberid=request.getParameter("member");
	       String password=request.getParameter("password");
	       String email=request.getParameter("email");
           Member member=new Member(fname,lname,age,gender,contactnumberr,memberid,password,email);
           MemberDaoSql memberDaoSql=new MemberDaoSql();
           int i= memberDaoSql.verifysignup(member);
           if(i==1){
  			 
    	     memberDaoSql.addMember(member);
  			 String succes= "you have to wait for approval "+member.getFname();
  			 request.setAttribute("registered", succes);
  			 request.getRequestDispatcher("memberlogin.jsp").forward(request, response);
  			 
  		 }
           if(i==2)
    		 {
    			 String str= "Your Request is already send for approval";
    			 request.setAttribute("errormsg1", str);
    			 request.getRequestDispatcher("memberlogin.jsp").forward(request, response);
    		 }
  		  if(i==3)
  		 {
  			 String str= "Your Request has been approvrd You can Login";
  			 request.setAttribute("errormsg1", str);
  			 request.getRequestDispatcher("memberlogin.jsp").include(request, response);
  		 }
	       
	       
	}

}
