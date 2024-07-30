package com.junit;

public class BankLoanService {
	
	public float calcInterestAmount(float pAmount, float rate, float time) {
		System.out.println("In BankLoanService.BankLoanService(-,-,-)");
		if(pAmount<=0 || rate<=0 || time<=0) 
			throw new IllegalArgumentException("Invalid Inputs");
		
		try {
			//Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pAmount*rate*time/100.0f;
	}
}
