package com.bgcompute.StHildasStudios.model;

import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public interface Storage {

	public HashSet<Term> getTermDetails();
	public void newTerm(Term term);
	public void rolloverTerm(int oldID, int newID);
	public void newStudent(Student student);
	public void addComment(int ID, String comment);
	public void addClassToTerm(int termID, int classID, double cost);
	public void addStudentToClass(int classID, int studentID);
	public HashSet<Student> ageSortClassDesc(int classID);
	public HashSet<Student> ageSortClassAsc(int classID);
	public HashSet<Student> ageSortSchoolDesc();
	public HashSet<Student> ageSortSchoolAsc();
	public void changeCurrentTerm(int term);
	public int countTable(String table, String column);
	public void deleteClass(int ID);
	public void deleteTerm(int ID);
	public Student getStudentDetailsFromName(String first, String last);
	public Student getStudentDetailsFromID(int ID);
	public void markAsPaid(int studentID, int termID);
	public void migrateStudentsToClass(int oldClass, int newClass);
	public void migrateTerm(int oldTerm, int newTerm);
	public void newClass(DClass dclass);
	public void removeStudentFromClass(int classID, int studentID);
	public void removeStudentFromSchool(int studentID);
	public HashSet<Student> getStudentsNotPaid(int termID);
	public HashSet<DClass> getClassDetailsForTerm(int termID);
	
	
}
