package com.bgcompute.StHildasStudios.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.bgcompute.StHildasStudios.controller.DClassController;

public class NewClassView {

	private DClassController dc;
	private JTextField name;
	private JTextField day;
	private JTextField time;
	private JTextField duration;
	private JTextField cost;
	
	public NewClassView(DClassController dc){
		this.dc=dc;
	}
	
	public JPanel makeNewClass(){
		JPanel panel = new JPanel();
		
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
		timeLabel.setText("Time (HH:MM)");
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

		/*
		JLabel costLabel = new JLabel();
		costLabel.setText("Cost (£,decimal)");
		costLabel.setBounds(220,45,100,30);
		panel.add(costLabel);
		
		cost = new JTextField(50);
		cost.setBounds(425,45,100,30);
		panel.add(cost);
*/
		JButton submitButton = new JButton();
		submitButton.setText("Submit");
		submitButton.setBounds(140, 110, 100, 30);
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//name, time, day, duration, cost
				String nameText = name.getText();
				String dayText = day.getText();
				String timeIn = time.getText()+":00";
				Time t;
				
				if(timeIn.equals(":00")){
					t = Time.valueOf("00:00:00");
				} else {
					t = Time.valueOf(timeIn);
				}
				
				String durationIn = duration.getText();
				double dur;
				if(durationIn.equals("")||durationIn.isEmpty()){
					dur = 0.0;
				} else {
					dur = Double.parseDouble(durationIn);
				}
				
				/*
				String costIn = cost.getText();
				double cos = Double.parseDouble(costIn);
				*/
				
				dc.newClass(nameText, dayText, dur, t);;;;
			}
		});		
		
		panel.add(submitButton);
		panel.setLayout(null);
		panel.validate();
		
		return panel;
	}
	
}
