package com.bgcompute.StHildasStudios.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.bgcompute.StHildasStudios.controller.StudentController;

public class DeleteStudent {

	private StudentController stc;
	private JTextField inputBox;
	private int ID;
	
	public DeleteStudent(StudentController stc){
		this.stc=stc;
	}
	
	public JPanel delStudent(){
		JPanel panel = new JPanel();
		
		panel = new JPanel();
		inputBox = new JTextField();
		inputBox.setText("Input the student ID here.");
		inputBox.setVisible(true);
		inputBox.setBounds(150,425,200,30);
		panel.add(inputBox);
		
		JButton delStudent = new JButton();
		delStudent.setText("Delete Student");
		delStudent.setBounds(425, 425, 100, 30);

		delStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ID = Integer.parseInt(inputBox.getText());
				stc.deleteStudent(ID);
			}
		});
		
		panel.add(delStudent);
		panel.validate();
		return panel;
	}
	
}
