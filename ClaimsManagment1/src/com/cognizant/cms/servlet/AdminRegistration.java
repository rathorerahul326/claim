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
import com.cognizant.cms.model.Admin;


@WebServlet("/AdminRegistration")
public class AdminRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  //doGet(request, response);
		   String fname = request.getParameter("fname");
	       String lname=request.getParameter("lname");
	       String agee=request.getParameter("age");
	       int age=Integer.parseInt(agee);
	       String gender=request.getParameter("gender");
	       String contactnumberr=request.getParameter("contactnumber");
	       long contactnumber=Long.parseLong(contactnumberr);
	       String adminid=request.getParameter("adminid");
	       String password=request.getParameter("password");
	       String email=request.getParameter("email");
           Admin admin=new Admin(fname,lname,age,gender,contactnumber,adminid,password,email);
           AdminDaoSql adminDaoSql=new AdminDaoSql();
           int i= adminDaoSql.verifysignup(admin);
           if(i==1){
  			 
    	     adminDaoSql.addAdmin(admin);
  			 String succes= "You are successfully regitered  "+admin.getFname();
  			 request.setAttribute("registered", succes);
  			 request.getRequestDispatcher("adminlogin.jsp").include(request, response);
  			 
  		 }
  		  if(i==3)
  		 {
  			 String str= "admin Already registered with same information You can Login";
  			 request.setAttribute("errormsg1", str);
  			 request.getRequestDispatcher("adminlogin.jsp").include(request, response);
  		 }
	}

}
