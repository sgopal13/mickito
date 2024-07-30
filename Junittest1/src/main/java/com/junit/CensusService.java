package com.junit;

public class CensusService {
	

	public String exportData() {
		return "data exported";
	}
	
	public boolean isOdd(int no) {
		return no%2==0 ? false : true;
	}
	
	public String sayHello(String user) {
		return "Hello : "+ user;
	}
	
	public boolean isEmpty(String name) {
		return name.isBlank();
	}
}
