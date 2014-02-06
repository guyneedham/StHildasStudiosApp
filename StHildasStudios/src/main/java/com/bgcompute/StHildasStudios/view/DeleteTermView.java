package com.bgcompute.StHildasStudios.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.bgcompute.StHildasStudios.controller.TermController;

public class DeleteTermView {

	private TermController tc;
	private JTextField inputBox;
	private int ID;

	public DeleteTermView(TermController tc){
		this.tc=tc;
	}

	public JPanel delTerm(){
		JPanel panel = new JPanel();

		panel = new JPanel();
		inputBox = new JTextField();
		inputBox.setText("Input the term ID here.");
		inputBox.setVisible(true);
		inputBox.setBounds(150,425,200,30);
		panel.add(inputBox);

		JButton delStudent = new JButton();
		delStudent.setText("Delete Term");
		delStudent.setBounds(425, 425, 100, 30);

		delStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ID = Integer.parseInt(inputBox.getText());
				tc.deleteTerm(ID);
			}
		});

		panel.add(delStudent);
		panel.validate();
		return panel;
	}

}
