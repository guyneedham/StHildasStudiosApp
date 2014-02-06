package com.bgcompute.StHildasStudios.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.bgcompute.StHildasStudios.controller.TermController;

public class TermClassControlView {

	private TermController tc;
	private JTextField classInputBox;
	private JTextField termInputBox;
	private JTextField costInputBox;
	
	
	public TermClassControlView(TermController tc){
		this.tc=tc;
	}
	
	public JPanel remTerm(){
		JPanel panel = new JPanel();
		
		classInputBox = new JTextField();
		classInputBox.setText("Class ID here");
		classInputBox.setVisible(true);
		classInputBox.setBounds(5,5,100,30);
		panel.add(classInputBox);
		
		termInputBox = new JTextField();
		termInputBox.setText("Term ID here");
		termInputBox.setVisible(true);
		termInputBox.setBounds(120,5,100,30);
		panel.add(termInputBox);

		JButton delStudent = new JButton();
		delStudent.setText("Remove Class");
		delStudent.setBounds(5, 75, 150, 30);

		delStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int classID = Integer.parseInt(classInputBox.getText());
				int termID = Integer.parseInt(termInputBox.getText());
				tc.removeClass(classID, termID);;;
			}
		});

		panel.add(delStudent);
		panel.setLayout(null);
		panel.validate();
		
		return panel;
	}
	
	public JPanel addTerm(){
		JPanel panel = new JPanel();
		
		classInputBox = new JTextField();
		classInputBox.setText("Class ID here");
		classInputBox.setVisible(true);
		classInputBox.setBounds(5,5,100,30);
		panel.add(classInputBox);

		costInputBox = new JTextField();
		costInputBox.setText("Cost here");
		costInputBox.setVisible(true);
		costInputBox.setBounds(120,5,100,30);
		panel.add(costInputBox);
		

		termInputBox = new JTextField();
		termInputBox.setText("Term ID here");
		termInputBox.setVisible(true);
		termInputBox.setBounds(5,40,100,30);
		panel.add(termInputBox);
		
		JButton delStudent = new JButton();
		delStudent.setText("Add Class");
		delStudent.setBounds(5, 75, 100, 30);

		delStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int classID = Integer.parseInt(classInputBox.getText());
				int termID = Integer.parseInt(termInputBox.getText());
				double cost = Double.parseDouble(costInputBox.getText());
				tc.addClass(classID, termID, cost);;;
			}
		});

		panel.add(delStudent);
		panel.setLayout(null);
		panel.validate();
		
		return panel;
	}
	
}
