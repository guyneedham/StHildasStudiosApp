package com.bgcompute.StHildasStudios.view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SaveBillView {

	private JComponent input;
	private JPanel output;
	private JTextField path;

	final static Logger logger = LoggerFactory.getLogger(SaveBillView.class);

	public SaveBillView(JComponent input){
		this.input=input;
	}

	public JPanel saveBox(){
		output = new JPanel();

		path = new JTextField();
		path.setText("Path here e.g. C:/My Documents/Bills/studentNameBill.jpeg");
		path.setBounds(5,5,500,30);
		output.add(path);

		JButton saveButton = new JButton();
		saveButton.setText("Save JPEG");
		saveButton.setBounds(140, 110, 150, 30);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				BufferedImage bi = new BufferedImage(input.getSize().width, input.getSize().height, BufferedImage.TYPE_INT_ARGB); 
				Graphics g = bi.createGraphics();
				input.paint(g);
				g.dispose();
				String filePath = path.getText();
				try{
					ImageIO.write(bi,"png",new File( filePath ) );
				}
				catch (IOException e) {
					logger.error("Error saving bill image");

				}
				output.remove(path);
				JLabel doneMessage = new JLabel("Image saved to "+filePath);
				doneMessage.setBounds(5,5,500,30);
				output.add(doneMessage);
				output.revalidate();
				output.getParent().revalidate();
			}
		});		
		output.add(saveButton);
		output.setLayout(null);
		output.validate();

		return output;
	}

}
