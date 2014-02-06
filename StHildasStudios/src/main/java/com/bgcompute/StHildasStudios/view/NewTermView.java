package com.bgcompute.StHildasStudios.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.bgcompute.StHildasStudios.controller.TermController;

public class NewTermView {

	private TermController tc;
	
	private JTextField title;
	private JTextField fromDate;
	private JTextField toDate;
	
	public NewTermView(TermController tc){
		this.tc = tc;
	}
	
	public JPanel newTerm(){
		JPanel panel = new JPanel();
		
		JLabel titleLabel = new JLabel();
		titleLabel.setText("Title");
		titleLabel.setBounds(5, 10, 100, 30);
		panel.add(titleLabel);
		
		title = new JTextField(50);
		title.setBounds(110,10,100,30);
		panel.add(title);
		
		JLabel fromDateLabel = new JLabel();
		fromDateLabel.setText("Date from");
		fromDateLabel.setBounds(5, 45, 100, 30);
		panel.add(fromDateLabel);
		
		fromDate = new JTextField(10);
		fromDate.setBounds(110, 45, 100, 30);
		panel.add(fromDate);
		
		JLabel toDateLabel = new JLabel();
		toDateLabel.setText("Date to");
		toDateLabel.setBounds(5, 75, 100, 30);
		panel.add(toDateLabel);
		
		toDate = new JTextField(10);
		toDate.setBounds(110,75,100,30);
		panel.add(toDate);
		
		JButton submitButton = new JButton();
		submitButton.setText("Submit");
		submitButton.setBounds(140, 110, 100, 30);
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				String titleText = title.getText();
				String fromText = fromDate.getText();
				Date from;
				
				if(fromText.equals("")){
					from = Date.valueOf("1900-01-01");
				} else {
					from = Date.valueOf(fromText);
				}
				String toText = toDate.getText();
				Date to;
				if(toText.equals("")){
					to = Date.valueOf("2999-01-01");
				} else {
					to = Date.valueOf(toText);
				}
				
				tc.newTerm(from, to, titleText);;;
			}
		});		
		
		panel.add(submitButton);
		panel.setLayout(null);
		panel.validate();
		
		return panel;
	}
	
}
