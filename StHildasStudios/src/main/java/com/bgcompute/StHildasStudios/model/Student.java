package com.bgcompute.StHildasStudios.model;

import java.sql.Date;

public class Student {

	//String first, String last, String addrLn1, String addrLn2, String addrLn3, String postcode, Date DOB, int RAD, String email, int tel, int mob, String location, String comment
	private int ID;
	private String firstName;
	private String lastName;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String postcode;
	private Date DOB;
	private String RAD;
	private String email;
	private String phone;
	private String mobile;
	private String location;
	private String comment;
	
	public int getID(){
		return this.ID;
	}
	
	public void setID(int ID){
		this.ID = ID;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public String getAddr1(){
		return addressLine1;
	}
	
	public void setAddr1(String addr1){
		this.addressLine1 = addr1;
	}
	
	public String getAddr2(){
		return this.addressLine2;
	}
	
	public void setAddr2(String addr2){
		this.addressLine2 = addr2;
	}
	
	public String getAddr3(){
		return this.addressLine3;
	}
	
	public void setAddr3(String addr3){
		this.addressLine3 = addr3;
	}
	
	public String getPostcode(){
		return this.postcode;
	}
	
	public void setPostcode(String postcode){
		this.postcode = postcode;
	}
	
	public Date getDOB(){
		return this.DOB;
	}
	
	public void setDOB(Date DOB){
		this.DOB = DOB;
	}
	
	public String getRAD(){
		return this.RAD;
	}
	
	public void setRAD(String RAD){
		this.RAD = RAD;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getPhone(){
		return this.phone;
	}
	
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	public String getMobile(){
		return this.mobile;
	}
	
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	
	public String getLocation(){
		return this.location;
	}
	
	public void setLocation(String location){
		this.location = location;
	}
	
	public String getComment(){
		return this.comment;
	}
	
	public void setComment(String comment){
		this.comment = comment;
	}
	
}
