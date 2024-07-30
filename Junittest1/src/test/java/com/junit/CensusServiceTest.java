package com.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.NullString;

public class CensusServiceTest {
	
	//@Test
	@RepeatedTest(value=10,name="execution of {displayName}-{{currentRepetition}/{totalRepetitions}}")
	@DisplayName(value="testing data exportsss")
	public void testexportData() {
		CensusService service= new CensusService();
		assertEquals("data exported", service.exportData());
	}
	
	//parameterized method
	@ParameterizedTest
	@ValueSource(ints= {10,5,78,69,23,34})
	public void testIsOdd(int n) {
		CensusService service= new CensusService();
		assertTrue(service.isOdd(n));
	}
	
	@ParameterizedTest
	@ValueSource(strings= {"raja","rani"})
	public void testSayHello(String user) {
		CensusService service= new CensusService();
		assertEquals("Hello : "+user, service.sayHello(user));
	}

	@ParameterizedTest
	//@ValueSource(strings= {""," ","raja","rani"})
	@EmptySource
	@NullSource
	@NullAndEmptySource
	public void testIsEmpty(String name) {
		CensusService service= new CensusService();
		assertTrue(service.isEmpty(name));
	}
}
