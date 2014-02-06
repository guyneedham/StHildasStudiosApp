package com.bgcompute.StHildasStudios.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.bgcompute.StHildasStudios.controller.DClassController;

public class DeleteClassView {

	private DClassController dc;
	private JTextField inputBox;
	
	public DeleteClassView(DClassController dc){
		this.dc=dc;
	}
	
	public JPanel delClass(){
		JPanel panel = new JPanel();

		panel = new JPanel();
		inputBox = new JTextField();
		inputBox.setText("Input the class ID here.");
		inputBox.setVisible(true);
		inputBox.setBounds(150,425,200,30);
		panel.add(inputBox);

		JButton delStudent = new JButton();
		delStudent.setText("Delete Class");
		delStudent.setBounds(425, 425, 100, 30);

		delStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int ID = Integer.parseInt(inputBox.getText());
				dc.deleteClass(ID);;
			}
		});

		panel.add(delStudent);
		panel.validate();
		return panel;
	}
	
}
