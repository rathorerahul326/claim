package com.cognizant.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import com.cognizant.cms.model.Admin;
import com.cognizant.cms.model.Member;

public class AdminDaoSql {
	public ArrayList<Member> memberList=new ArrayList<Member>();
public void addAdmin(Admin admin) {
	String fname=admin.getFname() ;
    String lname=admin.getLname();
    int age=admin.getAge();
    String gender=admin.getGender();
    long contactnumberr=admin.getContactnumber();
    String contactnumber=String.valueOf(contactnumberr);
    String adminid=admin.getAdminid();
    String password=admin.getPassword();
    String email=admin.getEmail();
	  try {
 		    Connection con=ConnectionHandler.getConnection();
 		
 			PreparedStatement stmt=con.prepareStatement("insert into admin (admin_id,fn,gender,ln,age,password,cnt_no,email) values('"+adminid+"','"+fname+"','"+gender+"','"+lname+"','"+age+"','"+password+"','"+contactnumber+"','"+email+"')");
 			System.out.println("Admin Saved Succeessfully");
 			stmt.executeUpdate();
 			} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}  
}

public int loginAdmin(String adminid,String password) {

    try {
		Connection con=ConnectionHandler.getConnection();
		
			PreparedStatement stmt=con.prepareStatement("select * from admin where admin_id='"+adminid+"'");
			ResultSet rs=stmt.executeQuery(); 
			String passwordtemp=null;
			while(rs.next()){
				passwordtemp=rs.getString("password");
				System.out.println(passwordtemp);
			}
			if(passwordtemp.equals(password)){
				System.out.println("Admin Login succeesfully");
				return 1;
			}
			else{
				System.out.println("Admin not Login");
			
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    return 2;
}
    public ArrayList<Member> pendingRegistration() {
    
	try {
   		Connection con=ConnectionHandler.getConnection();
   		    int id=0;
   			PreparedStatement stmt=con.prepareStatement("select * from member where status='"+id+"'");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            String fname=rs.getString(2);
        	String lname=rs.getString(4);
            int age=rs.getInt(5);
            String gender=rs.getString(3);
            String contactnumberr=rs.getString(7);
            long contactnumber=Long.parseLong(contactnumberr);
            String memberid=rs.getString(1);
            String password=rs.getString(9);
            String email=rs.getString(7);
 		
 		Member member=new Member(fname,lname,age,gender,contactnumberr,memberid,password,email);
 		System.out.println(member);
 		memberList.add(member);
 		
            }
            
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
	return memberList;
	
}
    
    
    public void AcceptMemberStatus(String memidd,String adminidd) {
   	 ArrayList<Member> memberList=null;
	try {
  		Connection con=ConnectionHandler.getConnection();
  		memberList=new ArrayList<Member>();
  		    int id=1;
  		    String mem_id=memidd;
  		    String admin_id=adminidd;
  		    System.out.println("MemberId "+mem_id );
  			PreparedStatement stmt=con.prepareStatement("update member set status='"+id+"' where mem_id='"+mem_id+"'");
  			System.out.println("menber Status accepted Succeessfully");
 			stmt.executeUpdate();
 			//stmt=con.prepareStatement();
 			PreparedStatement stmtt=con.prepareStatement("select email,password from admin where admin_id='"+adminidd+"'");
            ResultSet rs = stmtt.executeQuery();
            String from=null;
            String adminpassword=null;
            String to=null;
            String sub=null;
            String msg=null;
            while(rs.next()){
            from=rs.getString("email");
            adminpassword=rs.getString("password");
            }
            stmtt=con.prepareStatement("select email from member where mem_id='"+mem_id+"'");
            rs=stmtt.executeQuery();
            while(rs.next()){
            to=rs.getString("email");
            sub="Accept Registration";
            msg="Your Registration has been accepted sSuccesssfully";
           
            }
            System.out.println(to);
            System.out.println(sub);
            System.out.println(msg);
            System.out.println(from);
            System.out.println(adminpassword);
            //sendMail(to,sub,msg,from,adminpassword);
           
		} catch (SQLException e) {
			e.printStackTrace();
		}

	
}
public static void sendMail(String to, String sub, 
            String msgg, final String user,final String pass)
{ 
//create an instance of Properties Class   
Properties properties = new Properties();

/*  Specifies the IP address of your default mail server
  for e.g if you are using gmail server as an email sever
you will pass smtp.gmail.com as value of mail.smtp host. 
As shown here in the code. 
Change accordingly, if your email id is not a gmail id
*/
properties.put("mail.smtp.host","smtp.gmail.com");
properties.put("mail.smtp.port","587");
properties.put("mail.smtp.auth", "true");
properties.put("mail.smtp.starttls.enable", "true");


/* Pass Properties object(props) and Authenticator object   
for authentication to Session instance 
*/

Authenticator auth = new Authenticator() {
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(user, pass);
    }
};

Session session = Session.getInstance(properties, auth);

// creates a new e-mail message
Message msg = new MimeMessage(session);

try {
	msg.setFrom(new InternetAddress(user));
	InternetAddress[] toAddresses = { new InternetAddress(to) };
	msg.setRecipients(Message.RecipientType.TO, toAddresses);
	msg.setSubject(sub);
	msg.setSentDate(new Date());
	// set plain text message
	msg.setText(msgg);

	// sends the e-mail
	Transport.send(msg);
} catch (AddressException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (MessagingException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

}
  
    public void rejectMemberStatus(int memid) {
      	 ArrayList<Member> memberList=null;
   	try {
     		Connection con=ConnectionHandler.getConnection();
     		memberList=new ArrayList<Member>();
     		    int id=3;
     			PreparedStatement stmt=con.prepareStatement("delete from member where mem_id='"+memid+"'");
     			System.out.println("member Status Rejected Succeessfully");
    			stmt.executeUpdate();
              
   		} catch (SQLException e) {
   			e.printStackTrace();
   		}

   	
   }
public static int verifysignup(Admin ld) {
		

		String id = ld.getAdminid();
		String password= ld.getPassword();
		
		   Connection con=ConnectionHandler.getConnection();
		

		try {
			Statement s = con.createStatement();
			int status_id=0;
			ResultSet rs = s.executeQuery("select password= '" +  password + "'from admin where admin_id='" + id  + "'");

			if (rs.next()) {
				return 3;

			} 
			
			con.close();
		}
		catch (Exception e) {

			System.out.println(e);

		}
			return 1;
		
	}
}
