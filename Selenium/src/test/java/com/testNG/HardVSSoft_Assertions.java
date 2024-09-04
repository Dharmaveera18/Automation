package com.testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVSSoft_Assertions {

	
	//@Test
	void test_hardAssertions()
	{
		System.out.println("Testing.....");
		System.out.println("Testing.....");
		
		Assert.assertEquals(1, 2);
		System.out.println("Testing.....");
		System.out.println("Testing.....");
		
	}
	
	
	@Test
	void test_Assertions()
	{
		System.out.println("Testing.....");
		System.out.println("Testing.....");
		
		SoftAssert sa = new SoftAssert();
		
		
		sa.assertEquals(1, 2);
		System.out.println("Testing.....");
		System.out.println("Testing.....");
		
		sa.assertAll();
	}
	
}
