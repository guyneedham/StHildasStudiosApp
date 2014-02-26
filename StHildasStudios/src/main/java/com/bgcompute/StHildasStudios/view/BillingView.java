package com.bgcompute.StHildasStudios.view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.bgcompute.StHildasStudios.controller.StudentController;
import com.bgcompute.StHildasStudios.controller.TermController;
import com.bgcompute.StHildasStudios.model.DClass;
import com.bgcompute.StHildasStudios.model.Student;

public class BillingView {

	private TermController tc;
	private StudentController sc;
	
	private int studentID;
	private JTextField studentInputBox;
	private JTextField termInputBox;
	private JPanel panel;
	private Student s;
	private ArrayList<DClass> classes;
	private double total;
	
	public BillingView(TermController tc, StudentController sc){
		this.tc=tc;
		this.sc=sc;
	}
	
	public JPanel makeBill(){
		panel = new JPanel();
		
		studentInputBox = new JTextField();
		studentInputBox.setText("Student ID here");
		studentInputBox.setBounds(5,5,150,30);
		panel.add(studentInputBox);
		
		termInputBox = new JTextField();
		termInputBox.setText("Term ID here");
		termInputBox.setBounds(160,5,100,30);
		panel.add(termInputBox);
		
		JButton genBill = new JButton();
		genBill.setText("Generate Bill");
		genBill.setBounds(5, 40, 100, 30);

		genBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int studentID = Integer.parseInt(studentInputBox.getText());
				int termID = Integer.parseInt(termInputBox.getText());
				s = sc.getStudentFromID(studentID);
				classes = tc.billDetails(termID, studentID);
				total = tc.getTotal(classes);
				showBill();
			}
		});
		panel.add(genBill);
		
		panel.setLayout(null);
		panel.setVisible(true);
		panel.validate();
		return panel;
	}
	
	private void showBill(){
		Container c = panel.getParent();
		c.remove(panel);
		c.add(writeBill(s,classes));
		panel.revalidate();
		c.revalidate();
	}
	
	private BufferedImage resizeImage(BufferedImage originalImage, int imageType, int newHeight, int newWidth){
		BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, imageType);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
		g.dispose();
	 
		return resizedImage;
	}
	
	private BufferedImage setTransparency(BufferedImage originalImage, float transparency){
		BufferedImage altered = new BufferedImage(originalImage.getWidth(),originalImage.getHeight(),originalImage.getType());
		
		Graphics2D g = altered.createGraphics();
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency));
		g.drawImage(originalImage, 0, 0, originalImage.getWidth(), originalImage.getHeight(), null);
		g.dispose();
		
		return altered;
	}
	
	private JPanel writeBill(Student s, ArrayList<DClass> classes){
		JPanel bill = new JPanel();
		bill.setOpaque(true);
		bill.setBackground(Color.white);
		//GridLayout gridLayout = new GridLayout(4,2,5,5);
		GridBagLayout gridBagLayout = new GridBagLayout();
		GridBagConstraints cons = new GridBagConstraints();
		bill.setLayout(gridBagLayout);
		try {
			BufferedImage logo = ImageIO.read(new File("src/main/resources/StHildasLogo.png"));
			int imageType = logo.getType() == 0? BufferedImage.TYPE_INT_ARGB : logo.getType();
			int newHeight = logo.getHeight()/5;
			int newWidth = logo.getWidth()/5;
			logo = resizeImage(logo, imageType, newHeight, newWidth);
			float transparency = 0.1f;
			//logo = setTransparency(logo,transparency);
			JLabel logoLabel  = new JLabel(new ImageIcon(logo));
			cons.weightx = 0.5;
			cons.fill = GridBagConstraints.NONE;
			cons.insets = new Insets(0,0,0,20);
			cons.gridx = 1;
			cons.gridy = 0;
			//logoLabel.setBounds(2,2,250,200);
			bill.add(logoLabel,cons);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		String newLine = "<P>";
		JLabel header = new JLabel("<html>Frances Lavington-Evans"+newLine+
				"St Hilda's"+newLine+"55 Coach Road" + newLine +"Sleights"+newLine+"Whitby"+newLine+"North Yorkshire"+newLine+"YO22 5BT"+newLine+
				"Telephone: 01947 810801"+newLine+"frances@sthildas.fsnet.co.uk"
				);
		cons.fill = GridBagConstraints.NONE;
		cons.insets.right = 50;
		cons.gridx = 3;
		cons.gridy = 0;
		
		//header.setBounds(280,2,220,300);
		//header.setHorizontalAlignment(SwingConstants.RIGHT);
		bill.add(header,cons);
		
		JLabel studio = new JLabel();
		studio.setText("St Hilda's Studio");
		cons.insets = new Insets(50,0,0,0);
		cons.gridx=2;
		cons.gridy=1;
		//studio.setBounds(200,250,200,30);
		bill.add(studio,cons);
		
		JLabel name = new JLabel();
		name.setText(s.getFirstName()+" "+s.getLastName());
		cons.insets = new Insets(10,0,0,0);
		cons.gridx=2;
		cons.gridy=2;
		//name.setBounds(200,300,500,30);
		bill.add(name,cons);
		
		JLabel termMessage = new JLabel();
		termMessage.setText("Due for term");
		cons.insets = new Insets(10,0,0,0);
		cons.gridx=2;
		cons.gridy=3;
		//termMessage.setBounds(200,350,500,30);
		bill.add(termMessage,cons);
		/*
		int classwidth = 100;
		int classheight = 30;
		int costwidth = 50;
		int costheight = 30;
		int classx = 175;
		int costx = classx+5+classwidth;
		int starty = 400;
		int endy = 0;
		*/
		
		JLabel poundSign = new JLabel("£");
		cons.insets = new Insets(10,0,0,0);
		cons.gridx=2;
		cons.gridy=4;
		//poundSign.setBounds(costx,starty-20,30,30);
		bill.add(poundSign,cons);
		
		int startx = 1;
		int starty = 5;
		cons.insets= new Insets(0,0,0,0);
		for(DClass c : classes){
			JLabel className = new JLabel();
			className.setText(c.getName());
			cons.gridx=startx;
			cons.gridy=starty;
			//className.setBounds(classx,starty,classwidth,classheight);
			bill.add(className,cons);
			
			JLabel classCost = new JLabel();
			classCost.setText(doubleDisplay(c.getCost()));
			cons.gridx=startx+1;
			cons.gridy=starty;
			//classCost.setBounds(costx,starty,costwidth,costheight);
			bill.add(classCost,cons);
			
			starty = starty+1;
		}
		int width = cons.gridwidth;
		int fill = cons.fill;
		double weight = cons.weightx;
		starty=starty+1;
		
		JSeparator line = new JSeparator(SwingConstants.HORIZONTAL);
		//line.setSize(50, 3);
		//line.setPreferredSize(new Dimension(5,1));
		line.setForeground(Color.black);
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.gridy=starty;
		/*cons.weightx = 1.0;
		cons.gridx = startx;
		cons.gridwidth = GridBagConstraints.REMAINDER;
		cons.gridy=starty;*/
		bill.add(line,cons);
		
		cons.fill = fill;
		cons.weightx = weight;
		cons.gridwidth = width;
		starty = starty+1;
		
		JLabel totalLabel = new JLabel();
		totalLabel.setText("Total");
		//cons.insets = new Insets(10,0,0,0);
		cons.gridx = startx;
		cons.gridy = starty;
		//totalLabel.setBounds(classx,starty,classwidth,classheight);
		bill.add(totalLabel,cons);
		
		JLabel totalCost = new JLabel();
		totalCost.setText(doubleDisplay(total));
		cons.gridx = startx+1;
		cons.gridy = starty;
		//totalCost.setBounds(costx,starty,costwidth,costheight);
		bill.add(totalCost,cons);
		
		int endy = starty+2;
		
		JLabel billingMessage = new JLabel("<html>(BACS to 20-75-92 F.M.Lavington-Evans 80560332. Cheques payable to F.M.Lavington-Evans; <P>"
			                                    );
		//billingMessage.setBounds(100,endy,500,60);
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.weightx = 1.0;
		cons.gridwidth=3;
		cons.insets = new Insets(50,10,0,10);
		cons.gridx=1;
		cons.gridy=endy;
		bill.add(billingMessage,cons);
		JLabel billingMessage2 = new JLabel("please, if it’s cash, put it in a named envelope)");
		cons.gridx=2;
		cons.insets = new Insets(0,0,0,0);
		cons.gridy=endy+1;
		bill.add(billingMessage2,cons);
		
		//bill.setLayout(gridLayout);
		
		
		bill.validate();
		return bill;
	}
	
	private String doubleDisplay(double cost){
		String c = String.valueOf(cost);
		int dot = c.indexOf(".");
		if(c.substring(dot).length() != 3){
			c = c+"0";
		}
		return c;
	}
	
	private int max(int first, int second){
		if(first > second){
			return first;
		} else {
			return second;
		}
	}
	
}
