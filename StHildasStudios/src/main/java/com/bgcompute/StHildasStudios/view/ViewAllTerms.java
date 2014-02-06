package com.bgcompute.StHildasStudios.view;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.bgcompute.StHildasStudios.controller.SchoolController;
import com.bgcompute.StHildasStudios.model.Term;

public class ViewAllTerms {

	private SchoolController shc;
	
	public ViewAllTerms(SchoolController shc){
		this.shc = shc;
	}
	
	public JScrollPane viewTerms(){
		ArrayList<Term> terms = shc.getAllTerms();
		JTable table = getTable(terms);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        table.setFillsViewportHeight(true);
        return scrollPane;
	}
	
	private JTable getTable(ArrayList<Term> terms){
		String[] title = {"ID","Title", "Start Date", "End Date"};		
		JTable jtable = new JTable(new TermTableModel(title, terms));
		return jtable;
	}
	
}
