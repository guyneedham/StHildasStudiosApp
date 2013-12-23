package com.bgcompute.StHildasStudios.model;

public class DClassFactory {

	private static DClassFactory instance;
	
	public static DClassFactory getInstance(){
		if(instance != null){
			return instance;
		} else {
			instance = new DClassFactory();
			return instance;
		}
	}
	
	private DClassFactory(){
		
	}
	
	public DClass newDClass(){
		return new DClass();
	}
	
}
