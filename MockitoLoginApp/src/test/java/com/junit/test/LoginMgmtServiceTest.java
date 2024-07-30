package com.junit.test;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.junit.dao.ILoginDao;
import com.junit.service.ILoginServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class LoginMgmtServiceTest {

	private static ILoginServiceImpl iLoginServiceImpl;
	private static ILoginDao iLoginDaoMock;

	@BeforeAll
	public static void setupOnce() {
		// crate Mock or fake or dummy object
		iLoginDaoMock = Mockito.mock(ILoginDao.class); // mock(-) generate inMemory class implementing
														// ILoginDao(i) having null method definitions for
														// authenticate(-,-) method
		System.out.println(iLoginDaoMock.getClass()+"  "+Arrays.toString(iLoginDaoMock.getClass().getInterfaces()));
		
		// Create Service class object
		iLoginServiceImpl = new ILoginServiceImpl(iLoginDaoMock);

	}

	@Test
	public void testLoginWithValidCredentials() {
		//provide Stub(temporary functionality) for authentication method
		Mockito.when(iLoginDaoMock.authenticate("raja", "rani")).thenReturn(1);
		//unit testing
		assertTrue(iLoginServiceImpl.login("raja", "rani"));
	}
	
	@Test
	public void testLoginWithInValidCredentials() {
		//provide Stub(temporary functionality) for authentication method
		Mockito.when(iLoginDaoMock.authenticate("raja1", "rani")).thenReturn(0);
		//unit testing
		assertFalse(iLoginServiceImpl.login("raja1", "rani1"));
	}

	@Test
	public void testLoginWithInValidNoCredentials() {
		//unit testing
		assertThrows(IllegalArgumentException.class, ()->iLoginServiceImpl.login("", ""));
	}
	
	@AfterAll
	public static void clearOnce() {
		iLoginDaoMock = null;
		iLoginServiceImpl=null;
	}c

}
