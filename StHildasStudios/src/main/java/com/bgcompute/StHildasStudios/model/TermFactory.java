package com.bgcompute.StHildasStudios.model;

public class TermFactory {

	private static TermFactory instance;
	
	public static TermFactory getInstance(){
		if(instance != null){
			return instance;
		} else {
			instance = new TermFactory();
			return instance;
		}
	}
	
	private TermFactory(){
		
	}
	
	public Term newTerm(){
		return new Term();
	}
	
}
