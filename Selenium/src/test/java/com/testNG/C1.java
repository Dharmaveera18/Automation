package com.testNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C1 {

	
	
	@BeforeTest
	void bt()
	{
		System.out.println("This is BeforeTest ...");
	}
	
	@AfterTest
	void at()
	{
		System.out.println("This is AfterTest ...");
	}
	
	@Test
	void abc()
	{
		System.out.println("This is Test ...");
	}
	
}
