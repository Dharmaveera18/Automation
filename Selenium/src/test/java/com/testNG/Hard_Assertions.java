package com.testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Hard_Assertions {
	
	
	//Hard Assertions
	
	//All the annotation we put in the test methods
	@Test
	void testAssert()
	{
		
		//Assert.assertEquals
		//Assert.assertEquals("abc", "abc"); //It will compare 2 values
		//Assert.assertEquals("123", "435");
		//Assert.assertEquals("123", 123);
		//Assert.assertEquals(123, 123);
		//Assert.assertEquals("true", "true");
		
		//Assert.NotassertEquals
		//Assert.assertNotEquals("123", "435");
		//Assert.assertNotEquals("123", "123");
		
		//Assert.assertTrue(false);
		
		//Assert.assertTrue(true);
		
		//Assert.assertTrue(1==1);
		
		//Assert.assertTrue(1==2);
		
		
		//Assert.assertFalse(1==2);
		//Assert.assertFalse(2==2);
		
		
		Assert.fail();
		
	}
	
	
	

}
