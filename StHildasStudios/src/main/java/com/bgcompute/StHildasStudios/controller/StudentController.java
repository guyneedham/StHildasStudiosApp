package com.bgcompute.StHildasStudios.controller;

import java.sql.Date;
import java.util.ArrayList;

import com.bgcompute.StHildasStudios.model.DClass;
import com.bgcompute.StHildasStudios.model.SortStudents;
import com.bgcompute.StHildasStudios.model.Storage;
import com.bgcompute.StHildasStudios.model.Student;
import com.bgcompute.StHildasStudios.model.StudentFactory;

public class StudentController {


	private Storage db;
	private StudentFactory sf;
	
	public StudentController (Storage datab, StudentFactory ssf){
		db = datab;
		sf = ssf;
	}
	
	public void newStudent(String first, String last, String addr1, String addr2, String addr3, String postcode, 
			String email, String phone, String mobile, String location, String RAD, String comment, Date DOB
			){
		Student student = sf.newStudent();
		student.setFirstName(first);
		student.setLastName(last);
		student.setAddr1(addr1);
		student.setAddr2(addr2);
		student.setAddr3(addr3);
		student.setPostcode(postcode);
		student.setEmail(email);
		student.setPhone(phone);
		student.setMobile(mobile);
		student.setRAD(RAD);
		student.setLocation(location);
		student.setComment(comment);
		student.setDOB(DOB);
		db.newStudent(studentClean(student));
	}
	
	private Student studentClean(Student in){
		Student out = sf.newStudent();
		out.setID(in.getID());
		for(int i=1;i<14;i++){
			switch(i){
			//String first, String last, String addr1, String addr2, String addr3, String postcode, 
			//String email, int phone, int mobile, String location, int RAD, String comment, Date DOB
				case 1:
					String first = in.getFirstName();
					if(first == null||first.isEmpty()||first.length() == 0){
						String firstEmpty = "";
						out.setFirstName(firstEmpty);
					} else {
						out.setFirstName(first);
					}
					break;
				case 2:
					String last = in.getLastName();
					if(last == null||last.isEmpty()||last.length() == 0){
						String lastEmpty = "";
						out.setLastName(lastEmpty);
					} else {
						out.setLastName(last);
					}
					break;
				case 3:
					String addr1 = in.getAddr1();
					if(addr1 == null||addr1.isEmpty()||addr1.length() == 0){
						String addr1Empty = "";
						out.setAddr1(addr1Empty);
					} else {
						out.setAddr1(addr1);
					}
					break;
				case 4:
					String addr2 = in.getAddr2();
					if(addr2 == null||addr2.isEmpty()||addr2.length() == 0){
						String addr2Empty = "";
						out.setAddr2(addr2Empty);
					} else {
						out.setAddr2(addr2);
					}
					break;
				case 5:
					String addr3 = in.getAddr3();
					if(addr3 == null||addr3.isEmpty()||addr3.length() == 0){
						String addr3Empty = "";
						out.setAddr3(addr3Empty);
					} else {
						out.setAddr3(addr3);
					}
					break;
				case 6:
					String postcode = in.getPostcode();
					if(postcode == null||postcode.isEmpty()||postcode.length() == 0){
						String postcodeEmpty = "";
						out.setPostcode(postcodeEmpty);
					} else {
						out.setPostcode(postcode);
					}
					break;
				case 7:
					String email = in.getEmail();
					if(email == null||email.isEmpty()||email.length() == 0){
						String emailEmpty = "";
						out.setEmail(emailEmpty);
					} else {
						out.setEmail(email);
					}
					break;
				case 8:
					String phone = in.getPhone();
					if(phone == null||phone.equals(null)||phone.isEmpty() ){
						String phoneEmpty = "";
						out.setPhone(phoneEmpty);
					} else {
						out.setPhone(phone);
					}
					break;
				case 9:
					String mobile = in.getMobile();
					if(mobile == null||mobile.equals(null)||mobile.isEmpty() ){
						String phoneEmpty = "";
						out.setMobile(phoneEmpty);
					} else {
						out.setMobile(mobile);
					}
					break;
				case 10:
					String location = in.getLocation();
					if(location == null||location.isEmpty()||location.length() == 0){
						String locationEmpty = "";
						out.setLocation(locationEmpty);
					} else {
						out.setLocation(location);
					}
					break;
				case 11:
					String RAD = in.getRAD();
					if(RAD == null||RAD.equals(null)||RAD.isEmpty() ){
						String RADEmpty = "";
						out.setRAD(RADEmpty);
					} else {
						out.setRAD(RAD);
					}
					break;
				case 12:
					String comment = in.getComment();
					if(comment == null||comment.isEmpty()||comment.length() == 0){
						String commentEmpty = "";
						out.setComment(commentEmpty);
					} else {
						out.setComment(comment);
					}
					break;
				case 13:
					Date DOB = in.getDOB();
					if(DOB == null||DOB.equals(null)||DOB.toString().isEmpty()||DOB.toString() == null){
						Date emptyDOB = Date.valueOf("1900-01-01");
						out.setDOB(emptyDOB);
					} else {
						out.setDOB(DOB);
					}
					break;
			}
		}
		
		return out;
	}
	
	public void modifyStudent(Student in){
		db.modifyStudent(studentClean(in));
	}
	
	public Student getStudentFromID(int ID){
		return db.getStudentDetailsFromID(ID);
	}
	
	public ArrayList<Student> getStudentFromName(String first, String last){
		return db.getStudentDetailsFromName(first, last);
	}
	
	public void addComment(Student student, String comment){
		db.addComment(student.getID(), comment);
	}
	
	public ArrayList<DClass> getClassesForStudent(Student student){
		return db.getClassesForStudent(student.getID());
	}
	
	public void deleteStudent(int ID){
		db.removeStudentFromSchool(ID);
	}

}
