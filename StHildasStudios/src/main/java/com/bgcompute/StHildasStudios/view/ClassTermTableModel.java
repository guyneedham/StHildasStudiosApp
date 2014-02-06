package com.bgcompute.StHildasStudios.view;

import java.sql.Time;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.bgcompute.StHildasStudios.model.DClass;

public class ClassTermTableModel  extends AbstractTableModel{

	private String[] columnNames;
	private ArrayList<DClass> classes;

	public ClassTermTableModel(String[] columns, ArrayList<DClass> classes){
		this.columnNames=columns;
		this.classes=classes;
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
		return classes.size();
	}

	public Object getValueAt(int row, int column) {
		DClass c = classes.get(row);
		return getObjectFromClasses(c, column);

	}

	public Object getObjectFromClasses(DClass c, int column){
		Object o = null;
		int ID = c.getID();
		String name = c.getName();
		String day = c.getDay();
		String time = c.getTime().toString();
		double duration = c.getDuration();
		double cost = c.getCost();
		int term = c.getTermID();

		switch(column){
		case 0:
			o = ID;
			break;
		case 1:
			o = name;
			break;
		case 2:
			o = day;
			break;
		case 3:
			o = time;
			break;
		case 4:
			o = duration;
			break;
		case 5:
			o = cost;
			break;	
		case 6:
			o = term;
			break;
		}
		return o;

	}	
}
