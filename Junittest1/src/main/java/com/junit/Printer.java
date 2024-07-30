package com.junit;

public class Printer {
	
	//private static Printer instance = new Printer();
	private static Printer instance;
	private Printer() {
	}
	
	public static Printer getInstance() {
		return instance;
	}

}
