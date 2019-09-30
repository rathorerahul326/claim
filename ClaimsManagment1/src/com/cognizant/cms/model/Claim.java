package com.cognizant.cms.model;

import java.util.Date;

public class Claim 
{
private String claimid;
private String memid;
private byte[] adhaar;
private byte[] bills;
private String claim_status;
private String approve_status;
private Date doa;
private String work_acc;
private String auto_acc;
private int claim_amount;

public Claim()
{
	
}
public Date getDoa() {
	return doa;
}
public void setDoa(Date doa) {
	System.out.println(doa);
	this.doa = doa;
}
public String getWork_acc() {
	return work_acc;
}
public void setWork_acc(String work_acc) {
	this.work_acc = work_acc;
}
public String getAuto_acc() {
	return auto_acc;
}
public void setAuto_acc(String auto_acc) {
	this.auto_acc = auto_acc;
}
public int getClaim_amount() {
	return claim_amount;
}
public void setClaim_amount(int claim_amount) {
	this.claim_amount = claim_amount;
}
public String getClaim_status() {
	return claim_status;
}
public void setClaim_status(String claim_status) {
	this.claim_status = claim_status;
}
public String getApprove_status() {
	return approve_status;
}
public void setApprove_status(String approve_status) {
	this.approve_status = approve_status;
}
public Claim(String string, String string2) {
	// TODO Auto-generated constructor stub
	 claimid=string;
	 memid=string2;
}
public String getClaimid() {
	return claimid;
}
public void setClaimid(String claimid) {
	this.claimid = claimid;
}
public String getMemid() {
	return memid;
}
public void setMemid(String memid) {
	this.memid = memid;
}

public byte[] getAdhaar() {
    return adhaar;
}

public void setAdhaar(byte[] adhaar) {
    this.adhaar = adhaar;
}

public byte[] getBills() {
    return bills;
}

public void setBills(byte[] bills) {
    this.bills = bills;
}
}
