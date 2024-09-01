/*
1.Open the application
2.Login to application
3.Logout from the application


*/
package com.testNG;

import org.testng.annotations.Test;

public class FirstTestCase {

	
	@Test(priority = -1)
	public void openApp()
	{
		System.out.println("Open the application...");
	}
	
	@Test(priority = 0)
	public void Login()
	{
		System.out.println("Login to application.....");
	}
	
	@Test(priority = 1)
	public void Logout()
	{
		System.out.println("Logaout from the application....");
	}
	
	
	
}
