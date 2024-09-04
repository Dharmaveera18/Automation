package com.testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class All_Annotations {

	
	@AfterSuite
	void as()
	{
		System.out.println("This is afterSuite....");
	}
	
	@BeforeSuite
	void bs()
	{
		System.out.println("This is BeforeSuite....");
	}
	
	
	@AfterTest
	void at()
	{
		System.out.println("This is AfterTest....");
	}
	
	@BeforeTest
	void bt()
	{
		System.out.println("This is BeforeTest....");
	}
	
	
	
	@AfterClass
	void ac()
	{
		System.out.println("This is AfterClass....");
	}
	
	@BeforeClass
	void bc()
	{
		System.out.println("This is BeforeClass....");
	}
	
	
	@AfterMethod
	void am()
	{
		System.out.println("This is AfterMethod....");
	}
	
	@BeforeMethod
	void bm()
	{
		System.out.println("This is BeforeMethod....");
	}
	
	@Test(priority = 1)
	void test1()
	{
		System.out.println("This is test1 ...");
	}
	
	@Test(priority = 2)
	void test2()
	{
		System.out.println("This is test2 ...");
	}
}
