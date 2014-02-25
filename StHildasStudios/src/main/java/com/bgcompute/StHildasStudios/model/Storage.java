package com.bgcompute.StHildasStudios.model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public interface Storage {

	public ArrayList<Term> getTermDetails();
	public void newTerm(Term term);
	public void rolloverTerm(int oldID, int newID);
	public void newStudent(Student student);
	public void addComment(int ID, String comment);
	public void addClassToTerm(int termID, int classID, double cost);
	public void addStudentToClass(int classID, int studentID);
	public ArrayList<Student> ageSortClassDesc(int classID);
	public ArrayList<Student> ageSortClassAsc(int classID);
	public ArrayList<Student> ageSortSchoolDesc();
	public ArrayList<Student> ageSortSchoolAsc();
	public void changeCurrentTerm(int term);
	public int countTerm();
	public int countClasses();
	public void deleteClass(int ID);
	public void deleteTerm(int ID);
	public ArrayList<Student> getStudentDetailsFromName(String first, String last);
	public Student getStudentDetailsFromID(int ID);
	public void markAsPaid(int studentID, int termID);
	public void migrateStudentsToClass(int oldClass, int newClass);
	public void migrateTerm(int oldTerm, int newTerm);
	public void newClass(DClass dclass);
	public void removeStudentFromClass(int classID, int studentID);
	public void removeStudentFromSchool(int studentID);
	public ArrayList<Student> getStudentsNotPaid(int termID);
	public ArrayList<DClass> getClassDetailsForTerm(int termID);
	public ArrayList<Student> getStudentsForTerm(int termID);
	public void deleteClassFromTerm(int id, int id2);
	public void deleteStudentFromTerm(int id, int id2);
	public void addStudentToTerm(int id, int id2);
	public ArrayList<DClass> getClassesForStudent(int id);
	public void modifyStudent(Student student);
	public void modifyTerm(Term term);
	public ArrayList<DClass> getClasses();
	public void modifyClass(DClass c);
	public void addToBilling(int termID,int classID,int studentID, double cost);
	public void removeFromBilling(int termID,int classID,int studentID);
	public ArrayList<DClass> generateBill(int termID, int studentID);
	public void removeClassFromBilling(int termID, int classID);
}
