package com.bgcompute.StHildasStudios.view;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.bgcompute.StHildasStudios.model.Student;

public class StudentTableModel extends AbstractTableModel {

	private String[] columnNames;
	private ArrayList<Student> students;
	
	public StudentTableModel(String[] title, ArrayList<Student> students) {
		this.columnNames = title;
		this.students = students;
	}
	
	public String getColumnName(int column){
		return columnNames[column];		
	}
	
	public Class<?> getColumnClass(int column){
		return getValueAt(0, column).getClass();
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {		
		return students.size();
	}
	
	public Object getValueAt(int row, int column) {
		//System.out.println("Row is "+row+" column is "+column);
		Student s = students.get(row);
		return getObjectFromStudents(s, column);
		
	}
	
	public Object getObjectFromStudents(Student s, int column){
		Object o = null;
		Integer ID = s.getID();
		String first = s.getFirstName();
		String last = s.getLastName();
		String addr1 = s.getAddr1();
		if(addr1 == null || addr1.isEmpty()){
			addr1 = "";
		}
		String addr2 = s.getAddr2();
		if(addr2 == null || addr2.isEmpty()){
			addr2 = "";
		}
		String addr3 = s.getAddr3();
		if(addr3 == null || addr3.isEmpty()){
			addr3 = "";
		}
		String postcode = s.getPostcode();
		if(postcode == null || postcode.isEmpty()){
			postcode = "";
		}
		Date DOB = s.getDOB();
		Integer RAD = s.getRAD();
		if(RAD == null){
			RAD = 0;
		}
		String email = s.getEmail();
		if(email == null || email.isEmpty()){
			email = "";
		}
		Integer phone = s.getPhone();
		if(phone == null){
			phone = 0;
		}
		Integer mob = s.getMobile();
		if(mob == null){
			mob = 0;
		}
		String location = s.getLocation();
		if(location == null || location.isEmpty()){
			location = "";
		}
		String comment = s.getComment();
		if(comment == null || comment.isEmpty()){
			comment = "";
		}
		switch(column){
		case 0:
			o = ID;
			break;
		case 1:
			o = first;
			break;
		case 2:
			o = last;
			break;
		case 3:
			o = addr1;
			break;
		case 4:
			o = addr2;
			break;
		case 5:
			o = addr3;
			break;
		case 6:
			o = postcode;
			break;
		case 7:
			o = DOB;
			break;
		case 8:
			o = RAD;
			break;
		case 9:
			o = email;
			break;
		case 10:
			o = phone;
			break;
		case 11:
			o = mob;
			break;
		case 12:
			o = location;
			break;
		case 13:
			o = comment;
			break;
		}
		return o;
		
	}

}