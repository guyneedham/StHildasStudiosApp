package com.bgcompute.StHildasStudios.controller;

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
			String email, int phone, int mobile, String location, int RAD
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
		db.newStudent(student);
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

}
