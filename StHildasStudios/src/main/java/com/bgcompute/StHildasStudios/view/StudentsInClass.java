package com.bgcompute.StHildasStudios.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.bgcompute.StHildasStudios.controller.DClassController;
import com.bgcompute.StHildasStudios.model.Student;

public class StudentsInClass {

	private DClassController dc;
	private JTextField classInputBox;
	private JPanel panel;
	private ArrayList<Student> students;
	
	public StudentsInClass(DClassController dc){
		this.dc=dc;
	}
	
	public JPanel ageAsc(){
		panel = new JPanel();
		classInputBox = new JTextField();
		classInputBox.setText("Class ID here");
		classInputBox.setVisible(true);
		classInputBox.setBounds(5,5,100,30);
		panel.add(classInputBox);
		
		JButton getStudents = new JButton();
		getStudents.setText("Get Students");
		getStudents.setBounds(5, 75, 150, 30);

		getStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int classID = Integer.parseInt(classInputBox.getText());
				students = dc.getStudentsAgeAsc(classID);
				addTable();
			}
		});

		panel.add(getStudents);
		panel.setLayout(null);
		panel.validate();
		
		return panel;
	}
	
	public JPanel ageDesc(){
		panel = new JPanel();
		
		classInputBox = new JTextField();
		classInputBox.setText("Class ID here");
		classInputBox.setVisible(true);
		classInputBox.setBounds(5,5,100,30);
		panel.add(classInputBox);
		
		JButton getStudents = new JButton();
		getStudents.setText("Get Students");
		getStudents.setBounds(5, 75, 150, 30);

		getStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int classID = Integer.parseInt(classInputBox.getText());
				students = dc.getStudentsAgeDesc(classID);
				addTable();
			}
		});

		panel.add(getStudents);
		panel.setLayout(null);
		panel.validate();
		
		return panel;
	}
	
	private void addTable(){
		System.out.println("Trying to add a table");
		Container i = panel.getParent();
		i.remove(panel);
		i.add(showTable(students));
		
		i.revalidate();
	}
	
	private JScrollPane showTable(ArrayList<Student> students){
		JTable table = getTable(students);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        table.setFillsViewportHeight(true);
        return scrollPane;
	}
	
	
	
	private JTable getTable(ArrayList<Student> students){
		String[] title = {"ID", "First Name", "Last Name", "Address Line 1", "Address Line 2", "Address Line 3",
							"Postcode", "DOB", "RAD Number", "Email", "Phone Number", "Mobile Number", "Location", "Comment"};		
		JTable jtable = new JTable(new StudentTableModel(title, students));
		return jtable;
	}
	
}
