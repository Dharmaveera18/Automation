package testNG_grouping;

import org.testng.annotations.Test;

public class SignUp_tests {

	
	
	@Test(priority  =1, groups = {"regression"})
	void signupByEmail()
	{
		System.out.println("signup by Email...");
	}
	
	
	@Test(priority  =2, groups = {"regression"})
	void signupByfacebook()
	{
		System.out.println("signup by facebook...");
	}
	
	@Test(priority  =3, groups = {"regression"})
	void signupBytwitter()
	{
		System.out.println("signup by twitter...");
	}
	
	
	
	
	
	
	
}
