package com.testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * 
 * 
 * 
 * 
 * 
 */

public class Annotations {

	@BeforeMethod
	void login()
	{
		System.out.println("This is login ...");
	}
	
	@Test(priority = 1)
	void search()
	{
		System.out.println("This is search ...");
	}
	
	@Test(priority = 2)
	void advanceSearch()
	{
		System.out.println("This is AdvanceSearch ...");
	}
	
	@AfterMethod
	void logout()
	{
		System.out.println("This is logout ...");
	}
	
	
	
	
}
