package com.bgcompute.StHildasStudios.controller;

import java.sql.Time;
import java.util.ArrayList;

import com.bgcompute.StHildasStudios.model.DClass;
import com.bgcompute.StHildasStudios.model.DClassFactory;
import com.bgcompute.StHildasStudios.model.SortStudents;
import com.bgcompute.StHildasStudios.model.Storage;
import com.bgcompute.StHildasStudios.model.Student;

public class DClassController {


	private Storage db;
	private SortStudents sort;
	private DClassFactory cf;
	
	public DClassController (Storage datab, SortStudents sorts, DClassFactory dcf){
		db = datab;
		sort = sorts;
		cf = dcf;
	}
	
	public ArrayList<Student> getStudentsAgeAsc(int classID){
		return db.ageSortClassAsc(classID);
	}
	
	public ArrayList<Student> getStudentsAgeDesc(int classID){
		return db.ageSortClassDesc(classID);
	}
	
	public ArrayList<Student> locationSortStudents(ArrayList<Student> students, String location){
		return sort.locationSort(students, location);
	}
	
	public void newClass(String name, String day, double duration, Time time){
		DClass dclass = cf.newDClass();
		dclass.setName(name);
		dclass.setDay(day);
		dclass.setDuration(duration);
		dclass.setTime(time);
		db.newClass(dclass);
	}
	
	public void deleteClass(int classID){
		db.deleteClass(classID);
	}
	
	public void migrateClass(int oldClass, int newClass){
		db.migrateStudentsToClass(oldClass, newClass);
	}
	
	public void addStudent(DClass dclass, Student student){
		db.addStudentToClass(dclass.getID(), student.getID());
	}
	
	public void removeStudent(DClass dclass, Student student){
		db.removeStudentFromClass(dclass.getID(), student.getID());
	}
	
}
