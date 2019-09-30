package com.cognizant.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import com.cognizant.cms.model.Admin;
import com.cognizant.cms.model.Member;

public class MemberDaoSql {

	public void addMember(Member member) {
		String fname = member.getFname();
		String lname = member.getLname();
		int age = member.getAge();
		String gender = member.getGender();
		String contactnumberr = member.getContactnumber();
		System.out.println("MemberID " + member.getMemberid());
		String memberid = member.getMemberid();
		String password = member.getPassword();
		String email = member.getEmail();
		try {
			Connection con = ConnectionHandler.getConnection();
			int id = 0;
			PreparedStatement stmt = con.prepareStatement(
					"insert into member (mem_id,fn,gender,ln,age,password,cnt_no,email,status) values('"
							+ memberid + "','" + fname + "','" + gender + "','" + lname + "','" + age + "','" + password
							+ "','" + contactnumberr + "','" + email + "','" + id + "')");
			System.out.println("Member Saved Succeessfully");
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int loginMember(String memberId,String passwordd) {
		String memId=memberId;
	
		try {
	   		   Connection con=ConnectionHandler.getConnection();
	   		   System.out.println();
	   		   int status_id=0;
	   		   String password=passwordd;
	   			PreparedStatement stmt=con.prepareStatement("select * from member where mem_id='"+memId+"' and status='"+status_id+"'");
				ResultSet rs=stmt.executeQuery(); 
				String passwordtemp=null;
	   			while(rs.next()){
	   				return 2;
	   				
	   			}
	   			status_id=1;
	   			PreparedStatement stmtt=con.prepareStatement("select * from member where mem_id='"+memId+"' and status='"+status_id+"'");
				ResultSet rsr=stmtt.executeQuery(); 
	   			while(rsr.next()){
	   				passwordtemp=rsr.getString(9);
	   				if(passwordtemp.equals(password)){
		   				System.out.println("Member Login succeesfully");
		   				return 1;

	   				}
	   				
	   			}
	   			
	   			} catch (SQLException e) {
	   			// TODO Auto-generated catch block
	   			e.printStackTrace();
	   		}
		return 3;  
	}

	public static int verifysignup(Member ld) {

		String id = ld.getMemberid();
		String password = ld.getPassword();

		Connection con = ConnectionHandler.getConnection();

		try {
			Statement s = con.createStatement();
			int status_id = 0;
			ResultSet rs = s.executeQuery("select password= '" + password + "'from member where mem_id='" + id
					+ "' and status='" + status_id + "'");

			if (rs.next()) {
				return 2;

			}
			status_id = 1;
			rs = s.executeQuery("select password= '" + password + "'from member where mem_id='" + id + "'");

			if (rs.next()) {
				return 3;

			}
			con.close();
		} catch (Exception e) {

			System.out.println(e);

		}
		return 1;

	}
	public Member getMember(String memberId) {
		 Connection con = ConnectionHandler.getConnection();
		 String id=memberId;
		 Member m=null;
		try {
			PreparedStatement stmt  = con.prepareStatement("select * from member where mem_id=?");
			stmt.setString(1, id);
			 
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				String contactnumber=(rs.getString("cnt_no"));
				int age=Integer.parseInt(rs.getString("age"));
				m=new Member(rs.getString("fn"),rs.getString("ln"),age,rs.getString("gender"),contactnumber,rs.getString("mem_id"),rs.getString("password"),rs.getString("email"));
				
				
				
				return m;
			}		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return m;
		
	}
}
