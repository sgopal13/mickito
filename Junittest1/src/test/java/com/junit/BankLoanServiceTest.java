package com.junit;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrderer.Random;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayName("BankLoanServiceTestclass")
// @TestMethodOrder(value = OrderAnnotation.class)
//@TestMethodOrder(value=MethodName.class)
//@TestMethodOrder(value=MethodOrderer.DisplayName.class)
@TestMethodOrder(value = Random.class) //default
class BankLoanServiceTest {

	private static BankLoanService loanService;

	@BeforeAll
	public static void setUpOnce() {
		System.out.println("In Setup method..");
		loanService = new BankLoanService();
	}
	
	/*
	 * @BeforeEach public void setUp() { System.out.println("In Setup method..");
	 * loanService = new BankLoanService(); }
	 */

	@Test
	@DisplayName("testwithsmallnumber")
	//@Order(10)
	@Tag("Dev")
	@Tag("UAT")
	void testCalcInterestAmountWithSmallNumber(TestInfo info) {
		System.out.println(info.getTags()+" "+info.getTestMethod().get().getName());
		float actualAmt = loanService.calcInterestAmount(100000, 2, 12);
		float expectedAmount = 24000.0f;
		assertEquals(expectedAmount, actualAmt, "Result not matching");
	}

	@Test
	//@Order(2)
	@Tag("UAT")
	void testCalcInterestAmountWithBigNumbers() {
		float actualAmt = loanService.calcInterestAmount(10000000, 2, 12);
		float expectedAmount = 2400000.12f;
		// 0.5 is delta value ==> 0.12 difference is less than 0.5 so no failure
		assertEquals(expectedAmount, actualAmt, 0.5, "Result not matching");
	}

	@Test
	//@Order(-6)
	@Tag("prod")
	void testCalcInterestAmountWithInvalidInput() {
		assertThrows(IllegalArgumentException.class, () -> {
			loanService.calcInterestAmount(0, 0, 0);
		}, "Exception not matching");
	}

	// wrong exception match test
	/*
	 * @Test void testCalcInterestAmountWithWrongException() {
	 * assertThrows(ArithmeticException.class, () -> {
	 * loanService.calcInterestAmount(0, 0, 0); }); }
	 */

	// exception not handled and leads to Error not failure
	
	@Test
	//@Disabled // skip this test
	void testCalcInterestAmountWithoutHandlingException() {
		float actualAmt = loanService.calcInterestAmount(0, 2, 12);
		float expectedAmount = 24000.0f;
		assertEquals(expectedAmount, actualAmt, "Result not matching");
	}

	// TestTimeout
	@Test
	//@Order(5)
	void testCalcInterestAmountWithTimeout() {
		assertTimeout(Duration.ofMillis(20000), () -> {
			loanService.calcInterestAmount(100000, 2, 12);
		}, "taken more time to execute");
	}

	// Test case for no exception...if exception came test case should failed
	@Test
	//@Order(1)
	void testCalcInterestAmountForNoException() {
		assertDoesNotThrow(() -> {
			loanService.calcInterestAmount(100000, 2, 12);
		});
	}

	/*
	 * @AfterEach public void clear() { System.out.println("in clear method...");
	 * loanService=null; }
	 */
	
	@AfterAll
	public static void clearOnce() {
		System.out.println("in clear method...");
		loanService=null;
	}
}
