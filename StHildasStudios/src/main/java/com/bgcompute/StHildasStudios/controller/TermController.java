package com.bgcompute.StHildasStudios.controller;

import java.sql.Date;
import java.util.ArrayList;

import com.bgcompute.StHildasStudios.model.DClass;
import com.bgcompute.StHildasStudios.model.SortStudents;
import com.bgcompute.StHildasStudios.model.Storage;
import com.bgcompute.StHildasStudios.model.Student;
import com.bgcompute.StHildasStudios.model.Term;
import com.bgcompute.StHildasStudios.model.TermFactory;

public class TermController {

	private TermFactory tf;
	private Storage db;
	private SortStudents sort;

	public TermController (TermFactory termf, Storage datab, SortStudents sorts){
		tf = termf;
		db = datab;
		sort = sorts;
	}

	public ArrayList<Student> getStudents(int termID){
		ArrayList<Student> students = new ArrayList<Student>();
		students = db.getStudentsForTerm(termID);
		return students;
	}

	public ArrayList<Student> ageSortAsc(ArrayList<Student> students){		
		return sort.ageSortAsc(students);
	}
	
	public ArrayList<Student> ageSortDesc(ArrayList<Student> students){		
		return sort.ageSortDesc(students);
	}
	
	public ArrayList<DClass> getClasses(int termID){
		return db.getClassDetailsForTerm(termID);
	}
	
	public void newTerm(Date start, Date end, String title){
		Term term = tf.newTerm();
		term.setStartDate(start);
		term.setEndDate(end);
		term.setTitle(title);
		db.newTerm(term);
	}
	
	public void addClass(DClass dclass, Term term){
		db.addClassToTerm(term.getID(), dclass.getID(), dclass.getCost());
	}
	
	public void removeClass(DClass dclass, Term term){
		db.deleteClassFromTerm(term.getID(), dclass.getID());
	}
	
	public void removeStudent(Student student, Term term){
		db.deleteStudentFromTerm(term.getID(), student.getID());
	}
	
	public void addStudent(Student student, Term term){
		db.addStudentToTerm(student.getID(), term.getID());
	}
	
	public ArrayList<Student> locationSortStudents(ArrayList<Student> students, String location){
		return sort.locationSort(students,location);
	}
	
	public void migrateTerm(int oldID, int newID){
		db.rolloverTerm(oldID, newID);
	}
	
	public void changeCurrentTerm(Term term){
		db.changeCurrentTerm(term.getID());
	}
	
	public ArrayList<Student> showNotPaid(Term term){
		return db.getStudentsNotPaid(term.getID());
	}
	

}
