package com.bgcompute.StHildasStudios.view;

import java.awt.Dimension;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.bgcompute.StHildasStudios.controller.DClassController;
import com.bgcompute.StHildasStudios.model.DClass;
public class ViewAllClasses {

	private DClassController dcc;
	
	public ViewAllClasses(DClassController dcc){
		this.dcc = dcc;
	}
	
	public JScrollPane viewAllClasses(){
		ArrayList<DClass> classes = dcc.getAllClasses();
		JTable table = getTable(classes);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        table.setFillsViewportHeight(true);
        return scrollPane;
	}
		
	private JTable getTable(ArrayList<DClass> classes){
		
		String[] title = {"ID","Name", "Day", "Time","Duration","Cost","Term"};		
		JTable jtable = new JTable(new ClassTermTableModel(title, classes));
		return jtable;
	}
	
}
