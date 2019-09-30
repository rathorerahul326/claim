package com.cognizant.cms.model;

public class Member {
	private String fname ;
	private String lname;
    private int age;
    private String gender;
    private String contactnumber;
    private String memberid;
    private String password;
    private String email;
    public Member(String fname,String lname,int age,String gender,String contactnumber,String memberid,String password,String email) {
		// TODO Auto-generated constructor stub
		this.fname=fname ;
	    this.lname=lname;
	    this.age=age;
	    this.gender=gender;
	    this.contactnumber=contactnumber;
	    this.memberid=memberid;
	    this.password=password;
	    this.email=email;
	}
	public Member() {
		// TODO Auto-generated constructor stub
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
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String cno) {
		this.contactnumber = cno;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
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
