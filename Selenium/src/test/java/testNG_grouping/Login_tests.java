package testNG_grouping;

import org.testng.annotations.Test;

public class Login_tests {

	@Test(priority  =1, groups = {"sanity"})
	void logniByEmail()
	{
		System.out.println("Login by Email...");
	}
	
	
	@Test(priority  =2, groups = {"sanity"})
	void loginByfacebook()
	{
		System.out.println("Login by facebook...");
	}
	
	@Test(priority  =3, groups = {"sanity"})
	void loginBytwitter()
	{
		System.out.println("Login by twitter...");
	}
	
}
