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
	
	public void addStudent(int classID, int studentID){
		db.addStudentToClass(classID, studentID);
		ArrayList<DClass> classes = db.getClasses();
		DClass dclass = classes.get(classID);
		if(dclass.getTermID() != 0){
			double cost = dclass.getCost();
			db.addToBilling(dclass.getTermID(), classID, studentID, cost);
		}
	}
	
	public void removeStudent(int dclassID, int student){
		db.removeStudentFromClass(dclassID, student);
		ArrayList<DClass> classes = db.getClasses();
		//DClass dclass = classes.get(dclassID);
		DClass dclass = null;
		for(DClass dc : classes){
			if(dc.getID() == dclassID){
				db.removeFromBilling(dc.getTermID(), dclassID, student);
			}
		}
		
		
	}
	
	public ArrayList<DClass> getClasses(int termID){
		return db.getClassDetailsForTerm(termID);
	}
	
	public ArrayList<DClass> getAllClasses(){
		return db.getClasses();
	}
	
	public DClass getSpecificClass(int ID){
		ArrayList<DClass> classes = db.getClasses();
		DClass rc = null;
		for(DClass c : classes){
			if(c.getID() == ID){
				rc = c;
			}
		}
		return rc;
	}
	
	public void modifyClass(DClass c){
		db.modifyClass(c);
	}
	
}
