package com.bgcompute.StHildasStudios.view;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.bgcompute.StHildasStudios.controller.SchoolController;
import com.bgcompute.StHildasStudios.controller.StudentController;

public class NewStudentView implements ActionListener  {

	private StudentController stc;
	private String firstName;
	private String lastName;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String postcode;
	private Date DOB;
	private int RAD;
	private String email;
	private int phone;
	private int mobile;
	private String location;
	private String comment;

	private JTextField first;
	private JTextField last;
	private JTextField addr1;
	private JTextField addr2;
	private JTextField addr3;
	private JTextField postcodeIn;
	private JTextField dob;
	private JTextField rad;
	private JTextField emailIn;
	private JTextField tel;
	private JTextField mob;
	private JTextField locationIn;
	private JTextField commentIn;

	public NewStudentView(StudentController stc) {
		this.stc = stc;
	}

	public JPanel newStudent() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		

		first = new JTextField(50);
		first.setActionCommand("first");
		first.addActionListener(this);
		first.setVisible(true);
		
		//c.fill = GridBagConstraints.VERTICAL;
		//c.gridx = 0;
		//c.gridy = 0;
		
		panel.add(first,c);		

		last = new JTextField(50);
		last.setActionCommand("last");
		last.addActionListener(this);
		panel.add(last);	

		addr1 = new JTextField(50);
		addr1.setActionCommand("addr1");
		addr1.addActionListener(this);
		panel.add(addr1);

		addr2 = new JTextField(50);
		addr2.setActionCommand("addr2");
		addr2.addActionListener(this);
		panel.add(addr2);

		addr3 = new JTextField(50);
		addr3.setActionCommand("addr3");
		addr3.addActionListener(this);
		panel.add(addr3);

		postcodeIn = new JTextField(10);
		postcodeIn.setActionCommand("postcode");
		postcodeIn.addActionListener(this);
		panel.add(postcodeIn);

		dob = new JTextField(10);
		dob.setActionCommand("dob");
		dob.addActionListener(this);
		dob.setToolTipText("DOB in format dd/mm/yyyy");
		panel.add(dob);

		rad = new JTextField(50);
		rad.setActionCommand("rad");
		rad.addActionListener(this);
		panel.add(rad);

		emailIn = new JTextField(100);
		emailIn.setActionCommand("email");
		emailIn.addActionListener(this);
		panel.add(emailIn);

		tel = new JTextField(13);
		tel.setActionCommand("tel");
		tel.addActionListener(this);
		panel.add(tel);

		mob = new JTextField(13);
		mob.setActionCommand("mob");
		mob.addActionListener(this);
		panel.add(mob);

		locationIn = new JTextField(50);
		locationIn.setActionCommand("location");
		locationIn.addActionListener(this);
		panel.add(locationIn);

		commentIn = new JTextField(250);		
		commentIn.setActionCommand("comment");
		commentIn.addActionListener(this);
		panel.add(commentIn);

		panel.setLayout(null);
		panel.setToolTipText("Create a new student");

		JButton submitButton = new JButton("Submit");
		//submitButton.setBounds(50, 10, 80, 30);

		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				/*if(comment == null || comment.isEmpty()){
	        		   comment = "";
	        	   }*/
				stc.newStudent(firstName, lastName, addressLine1, addressLine2, addressLine3, postcode, email, phone, mobile, location, RAD, comment, DOB);;
			}
		});
		
		//c.fill = GridBagConstraints.VERTICAL;
		//c.weightx = 0.5;
		//c.gridx = 10;
		//c.gridy = 10;
		//panel.add(submitButton,c);

		panel.validate();
		return panel;
	}

	public void actionPerformed(ActionEvent e) {
		if("first".equals(e.getActionCommand())){
			this.firstName = first.getText();
		} else if("last".equals(e.getActionCommand())) {
			this.lastName = last.getText();
		} else if("addr1".equals(e.getActionCommand())){
			this.addressLine1 = addr1.getText();
		} else if("addr2".equals(e.getActionCommand())){
			this.addressLine2 = addr2.getText();			
		} else if("addr3".equals(e.getActionCommand())){
			this.addressLine3 = addr3.getText();
		} else if("postcodeIn".equals(e.getActionCommand())){
			this.postcode = postcodeIn.getText();
		} else if("dob".equals(e.getActionCommand())){
			this.DOB = Date.valueOf(dob.getText());
		} else if("rad".equals(e.getActionCommand())){
			this.RAD = Integer.parseInt(rad.getText());
		} else if("emailIn".equals(e.getActionCommand())){
			this.email = emailIn.getText();
		} else if("tel".equals(e.getActionCommand())){
			this.phone = Integer.parseInt(tel.getText());
		} else if("mob".equals(e.getActionCommand())){
			this.mobile = Integer.parseInt(mob.getText());
		} else if("locationIn".equals(e.getActionCommand())){
			this.location = locationIn.getText();
		} else if ("commentIn".equals(e.getActionCommand())){
			this.comment = commentIn.getText();
		}

	}


}
