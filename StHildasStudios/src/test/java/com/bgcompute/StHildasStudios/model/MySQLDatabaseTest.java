package com.bgcompute.StHildasStudios.model;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class MySQLDatabaseTest {

	private MySQLConnectionPool pool;
	private ConnectionSettings settings;
	private MySQLDatabase db;
	private TermFactory tf;
	private DClassFactory cf;
	private StudentFactory sf;
	
	@Before
	public void setUp(){
		settings = new ConnectionSettings();
		pool = MySQLConnectionPool.getInstance(settings.getServ(), settings.getName(), settings.getPass(), 5, 1);
		tf = TermFactory.getInstance();
		cf = DClassFactory.getInstance();
		sf = StudentFactory.getInstance();
		db = new MySQLDatabase(pool, tf, cf, sf);
	}
	
	@Test
	public void testDBGetTermDetailsGetsCorrectNumberOfTerms() {
		ArrayList<Term> terms = db.getTermDetails();
		Term t = terms.get(0);
		assertEquals(terms.size(),db.countTerm());
	}
	
	@Test
	public void testDBnewTermMakesANewTerm(){
		int startSize = db.countTerm();
		Term testTerm = tf.newTerm();
		testTerm.setStartDate(Date.valueOf("2014-01-06"));
		testTerm.setEndDate(Date.valueOf("2013-04-01"));
		testTerm.setTitle("TestTerm2");
		db.newTerm(testTerm);
		assertEquals(startSize+1,db.countTerm());
	}
	
	@Test
	public void testDBnewClassMakesANewClass(){
		int startSize = db.countClasses();
		DClass testClass = cf.newDClass();
		testClass.setDay("Friday");
		testClass.setDuration(1.0);
		testClass.setName("TestClass2");
		testClass.setTime(Time.valueOf("12:00:00"));
		db.newClass(testClass);
		assertEquals(startSize+1,db.countClasses());
	}
	
	@Test
	public void testDBnewStudentMakesANewStudent(){
		int startSize = db.countStudents();
		Student testStudent = sf.newStudent();
		testStudent.setFirstName("first");
		testStudent.setLastName("last");
		testStudent.setAddr1("line1");
		testStudent.setAddr2("line2");
		testStudent.setAddr3("line3");
		testStudent.setPostcode("postcode");
		testStudent.setDOB(Date.valueOf("2012-01-01"));
		testStudent.setRAD(1234);
		testStudent.setEmail("email");
		testStudent.setPhone(2345);
		testStudent.setMobile(5678);
		testStudent.setLocation("Teeside");
		db.newStudent(testStudent);
		assertEquals(startSize+1,db.countStudents());
	}

}
