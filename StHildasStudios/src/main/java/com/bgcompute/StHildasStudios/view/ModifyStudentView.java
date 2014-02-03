package com.bgcompute.StHildasStudios.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.bgcompute.StHildasStudios.controller.StudentController;
import com.bgcompute.StHildasStudios.model.Student;

import javax.swing.JLabel;

public class ModifyStudentView {

	private StudentController stc;
	
	private JTextField inputBox;
	private int ID;
	private Student in;
	private JPanel panel;
	
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
	
	public ModifyStudentView(StudentController stc){
		this.stc = stc;
	}
	
	public JPanel modStudent() {
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
				ID = Integer.parseInt(inputBox.getText());
				in = stc.getStudentFromID(ID);
				addStudentDetails();
			}
		});
		panel.add(getStudent);
		
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
		
		panel.validate();
		
		return panel;
	}

	public void addStudentDetails(){
		//get student attributes
		first.setText(in.getFirstName());
		last.setText(in.getLastName());
		addr1.setText(in.getAddr1());
		addr2.setText(in.getAddr2());
		addr3.setText(in.getAddr3());
		postcodeIn.setText(in.getPostcode());
		dob.setText(String.valueOf(in.getDOB()));
		rad.setText(in.getRAD());
		emailIn.setText(in.getEmail());
		tel.setText(in.getPhone());
		mob.setText(in.getMobile());
		locationIn.setText(in.getLocation());
		commentIn.setText(in.getComment());
		
		JButton updateStudent = new JButton();
		updateStudent.setText("Submit Changes");
		updateStudent.setBounds(375, 475, 150, 30);

		updateStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Student out = new Student();
				
				out.setID(ID);
				
				firstName = first.getText();
				out.setFirstName(firstName);
				
				lastName = last.getText();
				out.setLastName(lastName);
				
				addressLine1 = addr1.getText();
				out.setAddr1(addressLine1);
				
				addressLine2 = addr2.getText();
				out.setAddr2(addressLine2);
				
				addressLine3 = addr3.getText();
				out.setAddr3(addressLine3);
				
				postcode = postcodeIn.getText();
				out.setPostcode(postcode);
				
				email = emailIn.getText();
				out.setEmail(email);
				
				phone = tel.getText();
				out.setPhone(phone);				
				
				mobile = mob.getText();
				out.setMobile(mobile);
				
				location = locationIn.getText();
				out.setLocation(location);
				
				comment = commentIn.getText();
				out.setLocation(comment);
				
				if(dob.getText().equals("")){
					DOB = Date.valueOf("1900-01-01");
					out.setDOB(DOB);
				} else {
					DOB = Date.valueOf(dob.getText());
					out.setDOB(DOB);
				}
				
				RAD = rad.getText();
				out.setRAD(RAD);				
				
				stc.modifyStudent(out);
			}
		});
		panel.add(updateStudent);
		
		//button to update student with changed attributes
		panel.revalidate();
		panel.repaint();
	}
	
}
