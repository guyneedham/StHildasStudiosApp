package com.bgcompute.StHildasStudios.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.jdbc.PreparedStatement;

public class MySQLDatabase implements Storage {

	private MySQLConnectionPool connPool;
	private TermFactory tf;
	private DClassFactory cf;
	private StudentFactory sf;
	
	final static Logger logger = LoggerFactory.getLogger(MySQLDatabase.class);
	
	public MySQLDatabase(MySQLConnectionPool pool, TermFactory termf, DClassFactory classf, StudentFactory stuf){
		connPool = pool;
		tf = termf;
		cf = classf;
		sf = stuf;
	}

	public ArrayList<Term> getTermDetails() {
		logger.debug("Getting term HashSet.");
		ArrayList<Term> terms = new ArrayList<Term>();
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call getTerms()}");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Term term = tf.newTerm();
				term.setID(rs.getInt("term_id"));
				term.setStartDate(rs.getDate("strt_dt"));
				term.setEndDate(rs.getDate("end_dt"));
				term.setCurrent(rs.getInt("curr"));
				term.setTitle(rs.getString("title"));
				terms.add(term);
			}
			
		} catch (SQLException e) {
			logger.error("SQL exception getting term hashset.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		
		return terms;
	}

	public void newTerm(Term term) {
		logger.debug("Making new term {}.",term.getTitle());
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call newTerm(?,?,?)}");
			stmt.setDate(1, term.getStartDate());
			stmt.setDate(2, term.getEndDate());
			stmt.setString(3, term.getTitle());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			logger.error("SQL exception making new term.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		
	}

	public void rolloverTerm(int oldID, int newID) {
		logger.debug("Rolling over term {} to term.",oldID,newID);
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call migrateTerm(?,?)}");
			stmt.setInt(1,oldID);
			stmt.setInt(2, newID);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			logger.error("SQL exception rolling over term.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		
	}

	public void newStudent(Student student) {
		logger.debug("Making new student {} {}.",student.getFirstName(),student.getLastName());
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call newStudent(?,?,?,?,?,?,?,?,?,?,?,?)}");
			stmt.setString(1,student.getFirstName());
			stmt.setString(2, student.getLastName());
			stmt.setString(3, student.getAddr1());
			stmt.setString(4, student.getAddr2());
			stmt.setString(5, student.getAddr3());
			stmt.setString(6, student.getPostcode());
			stmt.setDate(7, student.getDOB());
			stmt.setInt(8, student.getRAD());
			stmt.setString(9, student.getEmail());
			stmt.setInt(10, student.getPhone());
			stmt.setInt(11, student.getMobile());
			stmt.setString(12, student.getLocation());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			logger.error("SQL exception making new student.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		
	}

	public void addComment(int ID, String comment) {
		logger.debug("Adding comment {} to student {}.",comment,ID);
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call addStudentComment(?,?)}");
			stmt.setInt(1,ID);
			stmt.setString(2, comment);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			logger.error("SQL deleting class.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		
	}

	public void addClassToTerm(int termID, int classID, double cost) {
		logger.debug("Adding class {} to term {} with cost {}.",classID,termID,cost);
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call addClassToTerm(?,?,?)}");
			stmt.setInt(1,classID);
			stmt.setInt(2, termID);
			stmt.setDouble(3, cost);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			logger.error("SQL exception adding class to term.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		
	}
	
	public void deleteClassFromTerm(int termID, int classID) {
		logger.debug("Removing class {} from term {}.",classID,termID);
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call deleteClassFromTerm(?,?)}");
			stmt.setInt(1,classID);
			stmt.setInt(2, termID);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			logger.error("SQL exception deleting class from term.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		
	}
	
	public void deleteStudentFromTerm(int termID, int studentID) {
		logger.debug("Removing student {} from term {}.",studentID,termID);
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call removeStudentFromTerm(?,?)}");
			stmt.setInt(1,studentID);
			stmt.setInt(2, termID);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			logger.error("SQL exception deleting student from term.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		
	}
	
	public void addStudentToTerm(int termID, int studentID) {
		logger.debug("Adding student {} to term {}.",studentID,termID);
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call addStudentToTerm(?,?)}");
			stmt.setInt(1,studentID);
			stmt.setInt(2, termID);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			logger.error("SQL exception adding student to term.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		
	}

	public void addStudentToClass(int classID, int studentID) {
		logger.debug("Adding student {} to class {}.",studentID,classID);
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call addStudentToClass(?,?)}");
			stmt.setInt(1,studentID);
			stmt.setInt(2, classID);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			logger.error("SQL exception adding student to class.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		
	}

	public ArrayList<Student> ageSortClassDesc(int classID) {
		ArrayList<Student> students = new ArrayList<Student>();
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call ageSortClassDesc(?)}");
			stmt.setInt(1, classID);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Student student = sf.newStudent();
				student.setFirstName(rs.getString(1));
				student.setLastName(rs.getString(2));
				student.setAddr1(rs.getString(3));
				student.setAddr2(rs.getString(4));
				student.setAddr3(rs.getString(5));
				student.setPostcode(rs.getString(6));
				student.setDOB(rs.getDate(7));
				student.setRAD(rs.getInt(8));
				student.setEmail(rs.getString(9));
				student.setPhone(rs.getInt(10));
				student.setMobile(rs.getInt(11));
				student.setLocation(rs.getString(12));
				student.setComment(rs.getString(13));
				student.setID(rs.getInt(14));
				students.add(student);
			}
			
		} catch (SQLException e) {
			logger.error("SQL exception getting students.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		return students;
	}

	public ArrayList<Student> ageSortClassAsc(int classID) {
		ArrayList<Student> students = new ArrayList<Student>();
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call ageSortClassAsc(?)}");
			stmt.setInt(1, classID);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Student student = sf.newStudent();
				student.setFirstName(rs.getString(1));
				student.setLastName(rs.getString(2));
				student.setAddr1(rs.getString(3));
				student.setAddr2(rs.getString(4));
				student.setAddr3(rs.getString(5));
				student.setPostcode(rs.getString(6));
				student.setDOB(rs.getDate(7));
				student.setRAD(rs.getInt(8));
				student.setEmail(rs.getString(9));
				student.setPhone(rs.getInt(10));
				student.setMobile(rs.getInt(11));
				student.setLocation(rs.getString(12));
				student.setComment(rs.getString(13));
				student.setID(rs.getInt(14));
				students.add(student);
			}
			
		} catch (SQLException e) {
			logger.error("SQL exception getting students.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		return students;
	}

	public ArrayList<Student> ageSortSchoolDesc() {
		ArrayList<Student> students = new ArrayList<Student>();
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call ageSortSchoolDesc()}");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Student student = sf.newStudent();
				student.setFirstName(rs.getString(1));
				student.setLastName(rs.getString(2));
				student.setAddr1(rs.getString(3));
				student.setAddr2(rs.getString(4));
				student.setAddr3(rs.getString(5));
				student.setPostcode(rs.getString(6));
				student.setDOB(rs.getDate(7));
				student.setRAD(rs.getInt(8));
				student.setEmail(rs.getString(9));
				student.setPhone(rs.getInt(10));
				student.setMobile(rs.getInt(11));
				student.setLocation(rs.getString(12));
				student.setComment(rs.getString(13));
				student.setID(rs.getInt(14));
				students.add(student);
			}
			
		} catch (SQLException e) {
			logger.error("SQL exception getting students.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		return students;
	}

	public ArrayList<Student> ageSortSchoolAsc() {
		ArrayList<Student> students = new ArrayList<Student>();
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call ageSortSchoolAsc()}");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Student student = sf.newStudent();
				student.setFirstName(rs.getString(1));
				student.setLastName(rs.getString(2));
				student.setAddr1(rs.getString(3));
				student.setAddr2(rs.getString(4));
				student.setAddr3(rs.getString(5));
				student.setPostcode(rs.getString(6));
				student.setDOB(rs.getDate(7));
				student.setRAD(rs.getInt(8));
				student.setEmail(rs.getString(9));
				student.setPhone(rs.getInt(10));
				student.setMobile(rs.getInt(11));
				student.setLocation(rs.getString(12));
				student.setComment(rs.getString(13));
				student.setID(rs.getInt(14));
				students.add(student);
			}
			
		} catch (SQLException e) {
			logger.error("SQL exception getting students.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		return students;
	}

	public void changeCurrentTerm(int term) {
		logger.debug("Making term {} current.",term);
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call changeCurrentTerm(?)}");
			stmt.setInt(1,term);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			logger.error("SQL exception changing current term.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		
	}

	public int countTerm() {
		int count = 0;
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call countTerm()}");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				count = rs.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			logger.error("SQL exception counting table term.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		return count;
	}
	
	public int countStudents() {
		int count = 0;
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call countStudents()}");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				count = rs.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			logger.error("SQL exception counting table students.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		return count;
	}

	public void deleteClass(int ID) {
		logger.debug("Deleting class {}.",ID);
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call deleteClass(?)}");
			stmt.setInt(1,ID);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			logger.error("SQL deleting class.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		
	}

	public void deleteTerm(int ID) {
		logger.debug("Deleting term {}.",ID);
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call deleteTerm(?)}");
			stmt.setInt(1,ID);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			logger.error("SQL deleting term.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		
	}

	public ArrayList<Student> getStudentDetailsFromName(String first, String last) {

		ArrayList<Student> students = new ArrayList<Student>();
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call getStudentDetailsFromName(?,?)}");
			stmt.setString(1, first);
			stmt.setString(2, last);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Student student = sf.newStudent();
				student.setFirstName(rs.getString(1));
				student.setLastName(rs.getString(2));
				student.setAddr1(rs.getString(3));
				student.setAddr2(rs.getString(4));
				student.setAddr3(rs.getString(5));
				student.setPostcode(rs.getString(6));
				student.setDOB(rs.getDate(7));
				student.setRAD(rs.getInt(8));
				student.setEmail(rs.getString(9));
				student.setPhone(rs.getInt(10));
				student.setMobile(rs.getInt(11));
				student.setLocation(rs.getString(12));
				student.setComment(rs.getString(13));
				student.setID(rs.getInt(14));
				students.add(student);
			}
			
		} catch (SQLException e) {
			logger.error("SQL exception getting student.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		return students;
	}

	public Student getStudentDetailsFromID(int ID) {
		Student student = sf.newStudent();
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call getStudentDetailsFromID(?)}");
			stmt.setInt(1, ID);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){				
				student.setFirstName(rs.getString(1));
				student.setLastName(rs.getString(2));
				student.setAddr1(rs.getString(3));
				student.setAddr2(rs.getString(4));
				student.setAddr3(rs.getString(5));
				student.setPostcode(rs.getString(6));
				student.setDOB(rs.getDate(7));
				student.setRAD(rs.getInt(8));
				student.setEmail(rs.getString(9));
				student.setPhone(rs.getInt(10));
				student.setMobile(rs.getInt(11));
				student.setLocation(rs.getString(12));
				student.setComment(rs.getString(13));
				student.setID(rs.getInt(14));
			}
			
		} catch (SQLException e) {
			logger.error("SQL exception getting student.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		return student;
	}

	public void markAsPaid(int studentID, int termID) {
		logger.debug("Marking student {} as paid for term {}.",studentID,termID);
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call markAsPaid(?,?)}");
			stmt.setInt(1, termID);
			stmt.setInt(2, studentID);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			logger.error("SQL exception marking student as paid.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		
	}

	public void migrateStudentsToClass(int oldClass, int newClass) {
		logger.debug("Migrating students from class {} to class {}.",oldClass, newClass);
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call migrateStudentsToClass(?,?)}");
			stmt.setInt(1, oldClass);
			stmt.setInt(2, newClass);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			logger.error("SQL exception migrating students between classes.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		
	}

	public void migrateTerm(int oldTerm, int newTerm) {
		logger.debug("Migrating students and classes from term {} to term {}.",oldTerm, newTerm);
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call migrateTerm(?,?)}");
			stmt.setInt(1, oldTerm);
			stmt.setInt(2, newTerm);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			logger.error("SQL exception migrating terms.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		
	}

	public void newClass(DClass dclass) {
		logger.debug("Making new class {}.",dclass.getName());
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call newClass(?,?,?,?)}");
			stmt.setString(1, dclass.getName());
			stmt.setString(2, dclass.getDay());
			stmt.setTime(3, dclass.getTime());
			stmt.setDouble(4, dclass.getDuration());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			logger.error("SQL exception making new class.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		
	}
	
	public int countClasses(){
		int count = 0;
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call countClasses()}");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				count = rs.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			logger.error("SQL exception counting table classes.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		return count;
	}

	public void removeStudentFromClass(int classID, int studentID) {
		logger.debug("Removing student {} from class {}.",studentID,classID);
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call removeStudentFromClass(?,?)}");
			stmt.setInt(1, studentID);
			stmt.setInt(2, classID);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			logger.error("SQL exception removing student from class.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		
		
	}

	public void removeStudentFromSchool(int studentID) {
		logger.debug("Removing student {} from school.",studentID);
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call removeStudentFromSchool(?)}");
			stmt.setInt(1, studentID);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			logger.error("SQL exception removing student from class.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		
	}

	public ArrayList<Student> getStudentsNotPaid(int termID) {
		ArrayList<Student> students = new ArrayList<Student>();
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call studentNotPaid(?)}");
			stmt.setInt(1,termID);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Student student = sf.newStudent();
				student.setFirstName(rs.getString(1));
				student.setLastName(rs.getString(2));
				student.setAddr1(rs.getString(3));
				student.setAddr2(rs.getString(4));
				student.setAddr3(rs.getString(5));
				student.setPostcode(rs.getString(6));
				student.setDOB(rs.getDate(7));
				student.setRAD(rs.getInt(8));
				student.setEmail(rs.getString(9));
				student.setPhone(rs.getInt(10));
				student.setMobile(rs.getInt(11));
				student.setLocation(rs.getString(12));
				student.setComment(rs.getString(13));
				student.setID(rs.getInt(14));
				students.add(student);
			}
			
		} catch (SQLException e) {
			logger.error("SQL exception getting students who haven't paid.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		return students;
	}

	public ArrayList<DClass> getClassDetailsForTerm(int termID) {
		ArrayList<DClass> classes = new ArrayList<DClass>();
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call getClassesForTerm(?)}");
			stmt.setInt(1,termID);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				DClass dclass = cf.newDClass();
				dclass.setID(rs.getInt(1));
				dclass.setName(rs.getString(2));
				dclass.setDay(rs.getString(3));
				dclass.setTime(rs.getTime(4));
				dclass.setDuration(rs.getDouble(5));
				dclass.setCost(rs.getDouble(6));
				classes.add(dclass);
			}
			
		} catch (SQLException e) {
			logger.error("SQL exception getting classes for term.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		return classes;
	}	
	
	public ArrayList<Student> getStudentsForTerm(int termID) {
		ArrayList<Student> students = new ArrayList<Student>();
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call studentsByTerm(?)}");
			stmt.setInt(1,termID);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Student student = sf.newStudent();
				student.setFirstName(rs.getString(1));
				student.setLastName(rs.getString(2));
				student.setAddr1(rs.getString(3));
				student.setAddr2(rs.getString(4));
				student.setAddr3(rs.getString(5));
				student.setPostcode(rs.getString(6));
				student.setDOB(rs.getDate(7));
				student.setRAD(rs.getInt(8));
				student.setEmail(rs.getString(9));
				student.setPhone(rs.getInt(10));
				student.setMobile(rs.getInt(11));
				student.setLocation(rs.getString(12));
				student.setComment(rs.getString(13));
				student.setID(rs.getInt(14));
				students.add(student);
			}
			
		} catch (SQLException e) {
			logger.error("SQL exception getting students for term.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		return students;
	}

	public ArrayList<DClass> getClassesForStudent(int id) {
		ArrayList<DClass> classes = new ArrayList<DClass>();
		Connection conn = connPool.checkOut();
		try {
			CallableStatement stmt = conn.prepareCall("{call showClassesForStudent(?)}");
			stmt.setInt(1,id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				DClass dclass = cf.newDClass();
				dclass.setID(rs.getInt(1));
				dclass.setName(rs.getString(2));
				dclass.setDay(rs.getString(3));
				dclass.setTime(rs.getTime(4));
				dclass.setDuration(rs.getDouble(5));
				classes.add(dclass);
			}
			
		} catch (SQLException e) {
			logger.error("SQL exception getting classes for student.");
			e.printStackTrace();
		} finally {
			connPool.checkIn(conn);
		}
		return classes;
	}
	
}
