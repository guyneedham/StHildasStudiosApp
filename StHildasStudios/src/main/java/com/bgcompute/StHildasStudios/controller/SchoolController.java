package com.bgcompute.StHildasStudios.controller;

import java.util.ArrayList;

import com.bgcompute.StHildasStudios.model.SortStudents;
import com.bgcompute.StHildasStudios.model.Storage;
import com.bgcompute.StHildasStudios.model.Student;
import com.bgcompute.StHildasStudios.model.StudentFactory;
import com.bgcompute.StHildasStudios.model.Term;

public class SchoolController {

	private Storage db;
	private SortStudents sort;
	private StudentFactory sf;
	
	public SchoolController (Storage datab, SortStudents sorts, StudentFactory ssf){
		db = datab;
		sort = sorts;
		sf = ssf;
	}
	
	public ArrayList<Term> getAllTerms(){
		return db.getTermDetails();
	}
	
	public ArrayList<Student> getAllStudentsAgeDesc(){
		return db.ageSortSchoolDesc();
	}
	
	public ArrayList<Student> getAllStudentsAgeAsc(){
		return db.ageSortSchoolAsc();
	}
	
	public ArrayList<Student> locationSort(ArrayList<Student> students, String location){
		return sort.locationSort(students, location);
	}
	
	public void deleteStudent(Student student){
		db.removeStudentFromSchool(student.getID());
	}
	
}
