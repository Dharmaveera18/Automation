package testNg_Listeners;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


//@Listeners(testNg_Listeners.My_Listeners.class)   
//If we dont have xml file still we can use testNG listeners, but it is preferred to use in xml file because 
//if we use in class level then we have to use for all the classes it will become complex.
public class OrangeHrm_Test {  

	
	
WebDriver driver;
	
	@BeforeClass
	void setUp() throws InterruptedException
	{
		 driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
	}
	
	@Test(priority = 1)
	void test_Title() 
	{
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@Test(priority = 2)
	void test_Url() 
	{
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test(priority = 3, dependsOnMethods = {"test_Url"})
	void test_Logo() 
	{
		boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
	
	    Assert.assertEquals(status, true);
	}
	
	@AfterClass
	void tearDown() 
	{
		driver.quit();
	}
}
	
	
	
	
	
	
	
	
	

