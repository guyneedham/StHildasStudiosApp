package com.bgcompute.StHildasStudios.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.bgcompute.StHildasStudios.controller.DClassController;
import com.bgcompute.StHildasStudios.model.DClass;

public class ModifyClassView {

	private DClassController dc;
	
	private JTextField inputBox;
	private JTextField name;
	private JTextField day;
	private JTextField time;
	private JTextField duration;
	private JPanel panel;
	private int ID;
	private DClass in;
	
	public ModifyClassView(DClassController dc){
		this.dc=dc;
	}
	
	public JPanel modClass(){
		panel = new JPanel();
		
		inputBox = new JTextField();
		inputBox.setText("Input the class ID here.");
		inputBox.setVisible(true);
		inputBox.setBounds(150,425,200,30);
		panel.add(inputBox);
		
		JButton getStudent = new JButton();
		getStudent.setText("Get Class");
		getStudent.setBounds(425, 425, 100, 30);

		getStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ID = Integer.parseInt(inputBox.getText());
				in = dc.getSpecificClass(ID);
				addClassDetails();
			}
		});
		panel.add(getStudent);
		
		JLabel nameLabel = new JLabel();
		nameLabel.setText("Name");
		nameLabel.setBounds(5, 10, 100, 30);
		panel.add(nameLabel);
		
		name = new JTextField(50);
		name.setBounds(110,10,100,30);
		panel.add(name);
		
		JLabel dayLabel = new JLabel();
		dayLabel.setText("Day");
		dayLabel.setBounds(5, 45, 100, 30);
		panel.add(dayLabel);
		
		day = new JTextField(10);
		day.setBounds(110, 45, 100, 30);
		panel.add(day);
		
		JLabel timeLabel = new JLabel();
		timeLabel.setText("Time (HH:MM:SS)");
		timeLabel.setBounds(5, 75, 100, 30);
		panel.add(timeLabel);
		
		time = new JTextField(10);
		time.setBounds(110,75,100,30);
		panel.add(time);
		
		JLabel durationLabel =  new JLabel();
		durationLabel.setText("Duration (decimal)");
		durationLabel.setBounds(220,10,200,30);
		panel.add(durationLabel);
		
		duration = new JTextField(10);
		duration.setBounds(425,10,100,30);
		panel.add(duration);
		
		panel.setLayout(null);
		
		panel.validate();
		
		return panel;
	}
	
	public void addClassDetails(){
		
		name.setText(in.getName());
		day.setText(in.getDay());
		time.setText(in.getTime().toString());
		duration.setText(String.valueOf(in.getDuration()));
		
		JButton submitButton = new JButton();
		submitButton.setText("Submit");
		submitButton.setBounds(140, 110, 100, 30);
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				DClass out = new DClass();
				String nameText = name.getText();
				String dayText = day.getText();
				String timeIn = time.getText();
				Time t;
				
				if(timeIn.equals("")){
					t = Time.valueOf("00:00:00");
				} else {
					t = Time.valueOf(timeIn);
				}
				
				String durationIn = duration.getText();
				double dur = Double.parseDouble(durationIn);
				out.setID(ID);
				out.setName(nameText);
				out.setDuration(dur);
				out.setTime(t);
				out.setDay(dayText);
				dc.modifyClass(out);;;;
			}
		});	
		panel.add(submitButton);
		panel.revalidate();
		panel.repaint();
	}
	
}
