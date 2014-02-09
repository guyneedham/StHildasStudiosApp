package com.bgcompute.StHildasStudios.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.bgcompute.StHildasStudios.controller.DClassController;
import com.bgcompute.StHildasStudios.controller.TermController;

public class MigrateData {

	private DClassController dc;
	private TermController tc;
	private JTextField class1InputBox;
	private JTextField class2InputBox;
	
	public MigrateData(TermController tc, DClassController dc){
		this.dc=dc;
		this.tc=tc;
	}
	
	public JPanel migrateClass(){
		JPanel panel = new JPanel();

		class1InputBox = new JTextField();
		class1InputBox.setText("Input the subject class ID here.");
		class1InputBox.setVisible(true);
		class1InputBox.setBounds(5,5,200,30);
		panel.add(class1InputBox);
		
		class2InputBox = new JTextField();
		class2InputBox.setText("Input the target class ID here.");
		class2InputBox.setVisible(true);
		class2InputBox.setBounds(210,5,200,30);
		panel.add(class2InputBox);

		JButton delStudent = new JButton();
		delStudent.setText("Migrate");
		delStudent.setBounds(5, 40, 100, 30);

		delStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int class1ID = Integer.parseInt(class1InputBox.getText());
				int class2ID = Integer.parseInt(class2InputBox.getText());
				dc.migrateClass(class1ID, class2ID);;
			}
		});

		panel.add(delStudent);
		panel.validate();
		return panel;
	}
	
	public JPanel migrateTerm(){
		JPanel panel = new JPanel();

		class1InputBox = new JTextField();
		class1InputBox.setText("Input the subject term ID here.");
		class1InputBox.setVisible(true);
		class1InputBox.setBounds(5,5,200,30);
		panel.add(class1InputBox);
		
		class2InputBox = new JTextField();
		class2InputBox.setText("Input the target term ID here.");
		class2InputBox.setVisible(true);
		class2InputBox.setBounds(210,5,200,30);
		panel.add(class2InputBox);

		JButton delStudent = new JButton();
		delStudent.setText("Migrate");
		delStudent.setBounds(5, 40, 100, 30);

		delStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int class1ID = Integer.parseInt(class1InputBox.getText());
				int class2ID = Integer.parseInt(class2InputBox.getText());
				dc.migrateClass(class1ID, class2ID);;
			}
		});

		panel.add(delStudent);
		panel.validate();
		return panel;
	}
	
}
