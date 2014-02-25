package com.bgcompute.StHildasStudios.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.bgcompute.StHildasStudios.controller.DClassController;
import com.bgcompute.StHildasStudios.controller.SchoolController;
import com.bgcompute.StHildasStudios.model.Student;

public class LocationSortView {

	private DClassController dc;
	private SchoolController sc;
	
	private JPanel panel;
	
	private JTextField classInputBox;
	private JTextField locationInputBox;
	
	private ArrayList<Student> students;
	
	public LocationSortView(DClassController dc, SchoolController sc){
		this.dc=dc;
		this.sc=sc;
	}
	
	public JPanel sortSchool(){
		panel = new JPanel();
		
		locationInputBox = new JTextField();
		locationInputBox.setText("Location here");
		locationInputBox.setVisible(true);
		locationInputBox.setBounds(5,5,100,30);
		panel.add(locationInputBox);
		
		JButton getStudents = new JButton();
		getStudents.setText("Get Students");
		getStudents.setBounds(5, 75, 150, 30);

		getStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String location = locationInputBox.getText();
				students = sc.getAllStudentsAgeAsc();
				students = sc.locationSort(students, location);
				addTable();
			}
		});

		panel.add(getStudents);
		panel.setLayout(null);
		panel.validate();
		
		return panel;
	}
	
	public JPanel sortClass(){
		panel = new JPanel();
		
		classInputBox = new JTextField();
		classInputBox.setText("Class ID here");
		classInputBox.setVisible(true);
		classInputBox.setBounds(5,5,100,30);
		panel.add(classInputBox);
		
		locationInputBox = new JTextField();
		locationInputBox.setText("Location here");
		locationInputBox.setVisible(true);
		locationInputBox.setBounds(110,5,100,30);
		panel.add(locationInputBox);
		
		JButton getStudents = new JButton();
		getStudents.setText("Get Students");
		getStudents.setBounds(5, 75, 150, 30);

		getStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int classID = Integer.parseInt(classInputBox.getText());
				students = dc.getStudentsAgeDesc(classID);
				String location = locationInputBox.getText();
				students = dc.locationSortStudents(students, location);
				addTable();
			}
		});

		panel.add(getStudents);
		panel.setLayout(null);
		panel.validate();
		
		return panel;
	}
	
	private void addTable(){
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
