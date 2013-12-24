package com.bgcompute.StHildasStudios.model;

import java.util.ArrayList;

public class SortStudents {

	public ArrayList<Student> ageSortAsc(ArrayList<Student> students){
		int j;
		boolean flag = true;   // set flag to true to begin first pass
		Student temp;   //holding variable

		while ( flag )
		{
			flag= false;    //set flag to false awaiting a possible swap
			for( j=0;  j < students.size() -1;  j++ )
			{
				if ( students.get(j).getDOB().before(students.get(j+1).getDOB()) )   // if the DOB of student j is before j+1
				{
					temp =  students.get(j);                //swap elements
					students.set(j, students.get(j+1));
					students.set(j+1, temp);
					flag = true;              //shows a swap occurred  
				} 
			} 
		} 
		return students;
	}

	public ArrayList<Student> ageSortDesc(ArrayList<Student> students){
		int j;
		boolean flag = true;   // set flag to true to begin first pass
		Student temp;   //holding variable

		while ( flag )
		{
			flag= false;    //set flag to false awaiting a possible swap
			for( j=0;  j < students.size() -1;  j++ )
			{
				if ( students.get(j).getDOB().after(students.get(j+1).getDOB()) )   // if the DOB of student j is after j+1
				{
					temp =  students.get(j);                //swap elements
					students.set(j, students.get(j+1));
					students.set(j+1, temp);
					flag = true;              //shows a swap occurred  
				} 
			} 
		} 
		return students;
	}

	public ArrayList<Student> locationSort(ArrayList<Student> students, String location) {
		ArrayList<Student> toReturn = new ArrayList<Student>();
		for(Student s : students){
			if(s != null ){
				if(s.getLocation().equals(location)){
					toReturn.add(s);
				}
			}
		}
		return toReturn;
	}

}
