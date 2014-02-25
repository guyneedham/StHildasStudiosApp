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

	public ArrayList<DClass> billDetails(int termID, int studentID){
		return db.generateBill(termID, studentID);
	}

	public double getTotal(ArrayList<DClass> classes){
		double total =0;
		for(DClass d : classes){
			double cost = d.getCost();
			total=total+cost;
		}
		return total;
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

	public void deleteTerm(int term){
		db.deleteTerm(term);
	}

	public void addClass(int classID, int termID, double classCost){
		db.addClassToTerm(termID, classID, classCost);
		ArrayList<Student> students = db.ageSortClassAsc(classID);
		for(Student s:students){
			int studentID = s.getID();
			db.addToBilling(termID, classID, studentID, classCost);
		}

	}

	public void removeClass(int classID, int termID){
		db.deleteClassFromTerm(termID, classID);
		db.removeClassFromBilling(termID, classID);
	}

	public void removeStudent(int studentID, int termID){
		db.deleteStudentFromTerm(termID, studentID);
	}

	public void addStudent(int studentID, int termID){
		ArrayList<Student> students = getStudents(termID);
		boolean flag = false;
		for(Student s : students){
			if(s.getID() == studentID){
				flag = true;
				break;
			}
		}
		if(!flag){
			db.addStudentToTerm(studentID,termID);
		}
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

	public ArrayList<Student> showNotPaid(int termID){
		return db.getStudentsNotPaid(termID);
	}
	
	public void markPaid(int termID, int studentID){
		db.markAsPaid(studentID, termID);
	}

	public void modifyTerm(Term term){
		db.modifyTerm(term);
	}

	public Term getTerm(int ID){
		ArrayList<Term> terms = db.getTermDetails();
		Term t=null;
		for(Term t1 : terms){
			if(t1.getID()==ID){
				t = t1;
			}
		}
		return t;
	}


}
