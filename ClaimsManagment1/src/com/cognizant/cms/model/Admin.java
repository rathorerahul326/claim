package com.cognizant.cms.model;

public class Admin {
	private String fname ;
    private String lname;
    private int age;
    private String gender;
    private long contactnumber;
    private String adminid;
    private String password;
    private String email;
   
	public Admin(String fname,String lname,int age,String gender,long contactnumber,String adminid,String password,String email) {
		// TODO Auto-generated constructor stub
		this.fname=fname ;
	    this.lname=lname;
	    this.age=age;
	    this.gender=gender;
	    this.contactnumber=contactnumber;
	    this.adminid=adminid;
	    this.password=password;
	    this.email=email;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(long contactnumber) {
		this.contactnumber = contactnumber;
	}
	public String getAdminid() {
		return adminid;
	}
	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
