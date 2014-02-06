package com.bgcompute.StHildasStudios.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.bgcompute.StHildasStudios.controller.DClassController;
import com.bgcompute.StHildasStudios.controller.TermController;

public class StudentClassControllView {

	private DClassController dc;
	private TermController tc;
	
	private JTextField studentInputBox;
	private JTextField classInputBox;
	private JTextField termInputBox;
	
	public StudentClassControllView (DClassController dc, TermController tc){
		this.dc=dc;
		this.tc=tc;
	}
	
	public JPanel addStudentToClass(){
		JPanel panel = new JPanel();
		
		classInputBox = new JTextField();
		classInputBox.setText("Class ID here");
		classInputBox.setVisible(true);
		classInputBox.setBounds(5,5,100,30);
		panel.add(classInputBox);
		
		studentInputBox = new JTextField();
		studentInputBox.setText("Student ID here");
		studentInputBox.setVisible(true);
		studentInputBox.setBounds(120,5,100,30);
		panel.add(studentInputBox);
		
		termInputBox = new JTextField();
		termInputBox.setText("Term ID here");
		termInputBox.setVisible(true);
		termInputBox.setBounds(5,40,100,30);
		panel.add(termInputBox);

		JButton delStudent = new JButton();
		delStudent.setText("Add Student");
		delStudent.setBounds(5, 75, 150, 30);

		delStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int classID = Integer.parseInt(classInputBox.getText());
				int termID = Integer.parseInt(termInputBox.getText());
				int studentID = Integer.parseInt(studentInputBox.getText());
				dc.addStudent(classID, studentID);
				tc.addStudent(studentID, termID);
			}
		});

		panel.add(delStudent);
		panel.setLayout(null);
		panel.validate();
		
		return panel;
	}
	
	public JPanel removeStudentFromClass(){
		JPanel panel = new JPanel();
		
		classInputBox = new JTextField();
		classInputBox.setText("Class ID here");
		classInputBox.setVisible(true);
		classInputBox.setBounds(5,5,100,30);
		panel.add(classInputBox);
		
		studentInputBox = new JTextField();
		studentInputBox.setText("Student ID here");
		studentInputBox.setVisible(true);
		studentInputBox.setBounds(120,5,100,30);
		panel.add(studentInputBox);

		JButton delStudent = new JButton();
		delStudent.setText("Remove Student");
		delStudent.setBounds(5, 75, 150, 30);

		delStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int classID = Integer.parseInt(classInputBox.getText());
				int studentID = Integer.parseInt(studentInputBox.getText());
				dc.removeStudent(classID, studentID);
			}
		});

		panel.add(delStudent);
		panel.setLayout(null);
		panel.validate();
		
		return panel;
	}
	
}
