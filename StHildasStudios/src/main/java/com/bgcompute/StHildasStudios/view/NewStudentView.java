package com.bgcompute.StHildasStudios.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.bgcompute.StHildasStudios.controller.StudentController;

public class NewStudentView  {

	private StudentController stc;
	private String firstName;
	private String lastName;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String postcode;
	private Date DOB;
	private String RAD;
	private String email;
	private String phone;
	private String mobile;
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
		

		JLabel firstLabel = new JLabel();
		firstLabel.setText("First Name");
		firstLabel.setBounds(5, 10, 100, 30);
		panel.add(firstLabel);
		
		first = new JTextField(50);
		first.setActionCommand("first");
		first.setVisible(true);		
		first.setToolTipText("Enter the first name.");
		first.setBounds(110,10,100,30);
		panel.add(first);		

		JLabel lastLabel = new JLabel();
		lastLabel.setText("Last Name");
		lastLabel.setBounds(5, 45, 100, 30);
		panel.add(lastLabel);
		
		last = new JTextField(50);
		last.setActionCommand("last");
		//last.addActionListener(this);
		last.setBounds(110, 45, 100, 30);
		panel.add(last);	
		
		JLabel line1Label = new JLabel();
		line1Label.setText("Address Line 1");
		line1Label.setBounds(5, 75, 100, 30);
		panel.add(line1Label);

		addr1 = new JTextField(50);
		addr1.setActionCommand("addr1");
		//addr1.addActionListener(this);
		addr1.setBounds(110,75,100,30);
		panel.add(addr1);

		JLabel line2Label = new JLabel();
		line2Label.setText("Address Line 2");
		line2Label.setBounds(5,110,100,30);
		panel.add(line2Label);
		
		addr2 = new JTextField(50);
		addr2.setActionCommand("addr2");
	//	addr2.addActionListener(this);
		addr2.setBounds(110,110,100,30);
		panel.add(addr2);

		JLabel line3Label = new JLabel();
		line3Label.setText("Address Line 3");
		line3Label.setBounds(5,145,100,30);
		panel.add(line3Label);
		
		addr3 = new JTextField(50);
		addr3.setActionCommand("addr3");
		//addr3.addActionListener(this);
		addr3.setBounds(110,145,100,30);
		panel.add(addr3);

		JLabel postcodeLabel = new JLabel();
		postcodeLabel.setText("Postcode");
		postcodeLabel.setBounds(5,180,100,30);
		panel.add(postcodeLabel);
		
		postcodeIn = new JTextField(10);
		postcodeIn.setActionCommand("postcode");
		//postcodeIn.addActionListener(this);
		postcodeIn.setBounds(110,180,100,30);
		panel.add(postcodeIn);

		JLabel dobLabel =  new JLabel();
		dobLabel.setText("DOB in format yyyy-mm-dd");
		dobLabel.setBounds(220,10,200,30);
		panel.add(dobLabel);
		
		dob = new JTextField(10);
		dob.setActionCommand("dob");
		//dob.addActionListener(this);
		dob.setToolTipText("DOB in format yyyy-mm-dd");
		dob.setBounds(425,10,100,30);
		panel.add(dob);

		JLabel RADLabel = new JLabel();
		RADLabel.setText("RAD Number");
		RADLabel.setBounds(220,45,100,30);
		panel.add(RADLabel);
		
		rad = new JTextField(50);
		rad.setActionCommand("rad");
		//rad.addActionListener(this);
		rad.setBounds(425,45,100,30);
		panel.add(rad);

		JLabel emailLabel = new JLabel();
		emailLabel.setText("Email address");
		emailLabel.setBounds(220,75,100,30);
		panel.add(emailLabel);
		
		emailIn = new JTextField(100);
		emailIn.setActionCommand("email");
		//emailIn.addActionListener(this);
		emailIn.setBounds(425,75,100,30);
		panel.add(emailIn);

		JLabel phoneLabel = new JLabel();
		phoneLabel.setText("Telephone Number");
		phoneLabel.setBounds(220,110,200,30);
		panel.add(phoneLabel);
		
		tel = new JTextField(13);
		tel.setActionCommand("tel");
	//	tel.addActionListener(this);
		tel.setBounds(425,110,100,30);
		panel.add(tel);

		JLabel mobLabel = new JLabel();
		mobLabel.setText("Mobile Number");
		mobLabel.setBounds(220,145,100,30);
		panel.add(mobLabel);
		
		mob = new JTextField(13);
		mob.setActionCommand("mob");
	//	mob.addActionListener(this);
		mob.setBounds(425,145,100,30);
		panel.add(mob);

		JLabel locLabel = new JLabel();
		locLabel.setText("Location");
		locLabel.setBounds(220,180,100,30);
		panel.add(locLabel);
		
		locationIn = new JTextField(50);
		locationIn.setActionCommand("location");
	//	locationIn.addActionListener(this);
		locationIn.setBounds(425,180,100,30);
		panel.add(locationIn);

		JLabel commentLabel = new JLabel();
		commentLabel.setText("Comment");
		commentLabel.setBounds(5,210,100,30);
		panel.add(commentLabel);
		
		commentIn = new JTextField(250);		
		commentIn.setActionCommand("comment");
		//commentIn.addActionListener(this);
		commentIn.setBounds(110,210,415,30);
		panel.add(commentIn);

		panel.setLayout(null);
		//panel.setToolTipText("Create a new student");

		JButton submitButton = new JButton("Submit");
		submitButton.setBounds(425, 245, 100, 30);

		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				/*if(comment == null || comment.isEmpty()){
	        		   comment = "";
	        	   }*/
				firstName = first.getText();
				lastName = last.getText();
				addressLine1 = addr1.getText();
				addressLine2 = addr2.getText();
				addressLine3 = addr3.getText();
				postcode = postcodeIn.getText();
				email = emailIn.getText();
				phone = tel.getText();				
				mobile = mob.getText();
				location = locationIn.getText();
				comment = commentIn.getText();
				if(dob.getText().equals("")){
					DOB = Date.valueOf("1900-01-01");
				} else {
					DOB = Date.valueOf(dob.getText());
				}
				RAD = rad.getText();
				
				stc.newStudent(firstName, lastName, addressLine1, addressLine2, addressLine3, postcode, email, phone, mobile, location, RAD, comment, DOB);;
			}
		});
		
		
		panel.add(submitButton);

		panel.validate();
		return panel;
	}
/*
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
*/

}
