package testNG_grouping;

import org.testng.annotations.Test;

public class Payment_tests {

	
	
	@Test(priority = 1, groups = {"sanity", "regression","functional"})
	void paymentInrupees()
	{
		System.out.println("paymentInrupees .....");
	}
	
	@Test(priority = 2, groups = {"sanity", "regression", "functional"})
	void paymentIndoller()
	{
		System.out.println("paymentIndoller .....");
	}
}
