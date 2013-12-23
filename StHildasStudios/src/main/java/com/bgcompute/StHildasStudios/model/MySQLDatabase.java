package com.bgcompute.StHildasStudios.model;

import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySQLDatabase implements Storage {

	private MySQLConnectionPool connPool;
	
	final static Logger logger = LoggerFactory.getLogger(MySQLDatabase.class);
	
	public MySQLDatabase(MySQLConnectionPool pool){
		connPool = pool;
	}

	public HashSet<Term> getTermDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	public void newTerm(Term term) {
		// TODO Auto-generated method stub
		
	}

	public void rolloverTerm(int oldID, int newID) {
		// TODO Auto-generated method stub
		
	}

	public void newStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	public void addComment(int ID, String comment) {
		// TODO Auto-generated method stub
		
	}

	public void addClassToTerm(int termID, int classID, double cost) {
		// TODO Auto-generated method stub
		
	}

	public void addStudentToClass(int classID, int studentID) {
		// TODO Auto-generated method stub
		
	}

	public HashSet<Student> ageSortClassDesc(int classID) {
		// TODO Auto-generated method stub
		return null;
	}

	public HashSet<Student> ageSortClassAsc(int classID) {
		// TODO Auto-generated method stub
		return null;
	}

	public HashSet<Student> ageSortSchoolDesc() {
		// TODO Auto-generated method stub
		return null;
	}

	public HashSet<Student> ageSortSchoolAsc() {
		// TODO Auto-generated method stub
		return null;
	}

	public void changeCurrentTerm(int term) {
		// TODO Auto-generated method stub
		
	}

	public int countTable(String table, String column) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void deleteClass(int ID) {
		// TODO Auto-generated method stub
		
	}

	public void deleteTerm(int ID) {
		// TODO Auto-generated method stub
		
	}

	public Student getStudentDetailsFromName(String first, String last) {
		// TODO Auto-generated method stub
		return null;
	}

	public Student getStudentDetailsFromID(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public void markAsPaid(int studentID, int termID) {
		// TODO Auto-generated method stub
		
	}

	public void migrateStudentsToClass(int oldClass, int newClass) {
		// TODO Auto-generated method stub
		
	}

	public void migrateTerm(int oldTerm, int newTerm) {
		// TODO Auto-generated method stub
		
	}

	public void newClass(DClass dclass) {
		// TODO Auto-generated method stub
		
	}

	public void removeStudentFromClass(int classID, int studentID) {
		// TODO Auto-generated method stub
		
	}

	public void removeStudentFromSchool(int studentID) {
		// TODO Auto-generated method stub
		
	}

	public HashSet<Student> getStudentsNotPaid(int termID) {
		// TODO Auto-generated method stub
		return null;
	}

	public HashSet<DClass> getClassDetailsForTerm(int termID) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
