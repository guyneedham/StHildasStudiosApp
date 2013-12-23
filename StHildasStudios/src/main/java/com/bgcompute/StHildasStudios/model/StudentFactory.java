package com.bgcompute.StHildasStudios.model;

public class StudentFactory {

	private static StudentFactory instance;
	
	public static StudentFactory getInstance(){
		if(instance != null){
			return instance;
		} else {
			instance = new StudentFactory();
			return instance;
		}
	}
	
	private StudentFactory(){
		
	}
	
	public Student newStudent(){
		return new Student();
	}
	
}
