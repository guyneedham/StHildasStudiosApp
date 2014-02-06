package com.bgcompute.StHildasStudios.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.bgcompute.StHildasStudios.controller.TermController;
import com.bgcompute.StHildasStudios.model.Term;

public class ModifyTermView {

	private TermController tc;
	private JTextField ID;
	private JTextField title;
	private JTextField toDate;
	private JTextField fromDate;
	private JPanel panel;
	private JTextField inputBox;
	
	private int IDin;
	private String titleIn;
	private Date toDateIn;
	private Date fromDateIn;
	private Term in;
	
	public ModifyTermView(TermController tc){
		this.tc=tc;
	}
	
	public JPanel modifyTerm(){
		panel = new JPanel();
		
		inputBox = new JTextField();
		inputBox.setText("Input the student ID here.");
		inputBox.setVisible(true);
		inputBox.setBounds(150,425,200,30);
		panel.add(inputBox);
		
		JButton getStudent = new JButton();
		getStudent.setText("Get Student");
		getStudent.setBounds(425, 425, 100, 30);

		getStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				IDin = Integer.parseInt(inputBox.getText());
				in = tc.getTerm(IDin);
				addTermDetails();
			}
		});
		panel.add(getStudent);
		
		JLabel titleLabel = new JLabel();
		titleLabel.setText("Title");
		titleLabel.setBounds(5, 10, 100, 30);
		panel.add(titleLabel);
		
		title = new JTextField();
		title.setBounds(110,10,100,30);
		panel.add(title);
		
		JLabel lastLabel = new JLabel();
		lastLabel.setText("Start Date");
		lastLabel.setBounds(5, 45, 100, 30);
		panel.add(lastLabel);
		
		
		fromDate = new JTextField(50);
		fromDate.setBounds(110, 45, 100, 30);
		panel.add(fromDate);
		
		JLabel line1Label = new JLabel();
		line1Label.setText("End Date");
		line1Label.setBounds(5, 75, 100, 30);
		panel.add(line1Label);

		toDate = new JTextField(50);
		toDate.setBounds(110,75,100,30);
		panel.add(toDate);

		
		panel.setLayout(null);		
		
		panel.validate();
		
		return panel;
	}
	
	public void addTermDetails(){
		titleIn = in.getTitle();
		toDateIn = in.getEndDate();
		fromDateIn = in.getStartDate();
		
		title.setText(titleIn);
		toDate.setText(toDateIn.toString());
		fromDate.setText(fromDateIn.toString());
		
		JButton updateTerm = new JButton();
		updateTerm.setText("Submit Changes");
		updateTerm.setBounds(375, 475, 150, 30);

		updateTerm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Term out = new Term();
				out.setID(IDin);
				out.setTitle(title.getText());
				out.setStartDate(Date.valueOf(fromDate.getText()));
				out.setEndDate(Date.valueOf(toDate.getText()));
				tc.modifyTerm(out);
			}
		});
		
		panel.add(updateTerm);
		panel.revalidate();
		panel.repaint();
		
	}
	
}
