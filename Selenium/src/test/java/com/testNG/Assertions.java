package com.testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertions {

	
	@Test
	void testAssert()
	{
		
		String exp_title = "OpenCart";
		String act_title = "OpenCar";
		
		if(exp_title.equals(act_title)) 
		{
			//System.out.println("Passed");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
			//System.out.println("failed");
		}
		
		
		//Assert.assertEquals(act_title, exp_title);
	}
	
	
	
}
