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
		String addr2 = s.getAddr2();
		String addr3 = s.getAddr3();
		String postcode = s.getPostcode();
		Date DOB = s.getDOB();
		String RAD = s.getRAD();
		String email = s.getEmail();
		String phone = s.getPhone();
		String mob = s.getMobile();
		String location = s.getLocation();
		String comment = s.getComment();
		
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
