package com.bgcompute.StHildasStudios.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.bgcompute.StHildasStudios.controller.TermController;

public class MarkPaidView {

	private TermController tc;
	private JTextField termInputBox;
	private JTextField studentInputBox;
	
	public MarkPaidView(TermController tc){
		this.tc=tc;
	}
	
	public JPanel markPaid(){
		JPanel panel = new JPanel();

		termInputBox = new JTextField();
		termInputBox.setText("Input the term ID here.");
		termInputBox.setVisible(true);
		termInputBox.setBounds(5,5,200,30);
		panel.add(termInputBox);
		
		studentInputBox = new JTextField();
		studentInputBox.setText("Input the student ID here.");
		studentInputBox.setVisible(true);
		studentInputBox.setBounds(210,5,200,30);
		panel.add(studentInputBox);

		JButton markPaid = new JButton();
		markPaid.setText("Mark as paid");
		markPaid.setBounds(5, 40, 100, 30);

		markPaid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int termID = Integer.parseInt(termInputBox.getText());
				int studentID = Integer.parseInt(studentInputBox.getText());
				tc.markPaid(termID, studentID);
			}
		});

		panel.add(markPaid);
		panel.validate();
		return panel;
	}
	
}
