package com.junit;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class PrinterTest {

	@Test
	public void testSingletom() {
		Printer printer1 = Printer.getInstance();
		Printer printer2 = Printer.getInstance();
		
		//check null or not
		//assertNull(printer1);
		//assertNotNull(printer2);
		//if we want print failed message then use fail() method
		if(printer1 == null || printer2 == null) {
			fail("printer1 or printer2 must not be null ");
		}
		
		assertSame(printer1, printer2);
		
	}
}
