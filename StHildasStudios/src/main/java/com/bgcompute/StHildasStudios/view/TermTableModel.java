package com.bgcompute.StHildasStudios.view;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.bgcompute.StHildasStudios.model.Student;
import com.bgcompute.StHildasStudios.model.Term;

public class TermTableModel extends AbstractTableModel {

	private String[] columnNames;
	private ArrayList<Term> terms;
	
	public TermTableModel(String[] title, ArrayList<Term> terms){
		this.columnNames = title;
		this.terms = terms;
	}
	
	public String getColumnName(int column){
		return columnNames[column];		
	}
	
	public Class<?> getColumnClass(int column){
		return getValueAt(0, column).getClass();
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {		
		return terms.size();
	}
	
	public Object getValueAt(int row, int column) {
		//System.out.println("Row is "+row+" column is "+column);
		Term t = terms.get(row);
		return getObjectFromTerms(t, column);
		
	}

	public Object getObjectFromTerms(Term t, int column){
		Object o = null;
		int ID = t.getID();
		String title = t.getTitle();
		Date from = t.getStartDate();
		Date to = t.getEndDate();
		
		switch(column){
		case 0:
			o = ID;
			break;
		case 1:
			o = title;
			break;
		case 2:
			o = from;
			break;
		case 3:
			o = to;
			break;
		}
		return o;
		
	}	
	
}
