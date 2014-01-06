package com.bgcompute.StHildasStudios.view;

import java.awt.Dimension;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.bgcompute.StHildasStudios.controller.DClassController;
import com.bgcompute.StHildasStudios.controller.SchoolController;
import com.bgcompute.StHildasStudios.controller.StudentController;
import com.bgcompute.StHildasStudios.controller.TermController;
import com.bgcompute.StHildasStudios.model.Student;

public class DisplayStudents {

	private SchoolController shc;
	private DClassController dc;
	private StudentController stc;
	private TermController tc;
	
	public DisplayStudents(SchoolController shc, DClassController dc, StudentController stc, TermController tc){
		this.shc = shc;
		this.dc = dc;
		this.stc = stc;
		this.tc = tc;
	}
	
	public JPanel ageSortSchoolDesc(){
		JPanel gui = new JPanel();
		
		ArrayList<Student> students = shc.getAllStudentsAgeDesc();
		JTable table = getTable(students);
		
		JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 150));
        gui.add(scrollPane);
        gui.setOpaque(true);
		
        return gui;
	}
	
	private JTable getTable(ArrayList<Student> students){
		String[] title = {"ID", "First Name", "Last Name", "Address Line 1", "Address Line 2", "Address Line 3",
							"Postcode", "DOB", "RAD Number", "Email", "Phone Number", "Mobile Number", "Location", "Comment"};
		
		
		JTable jtable = new JTable(new StudentTableModel(title, students));
		return jtable;
	}
	
}
