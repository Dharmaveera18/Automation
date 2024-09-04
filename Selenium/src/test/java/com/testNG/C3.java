package com.testNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class C3 {

	
	@BeforeSuite
	void bs()
	{
		System.out.println("This is @BeforeSuite ...");
	}
	
	@AfterSuite
	void as()
	{
		System.out.println("This is @BeforeSuite ...");
	}
	
	@Test
	void pqr()
	{
		System.out.println("This is @Test ...");
	}
	
}
