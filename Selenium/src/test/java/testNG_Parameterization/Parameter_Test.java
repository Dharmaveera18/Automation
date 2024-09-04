package testNG_Parameterization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Parameter_Test {

	WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser"})
	void setUp(String br) throws InterruptedException
	{
		switch(br.toLowerCase())  
		{
		
		case "chrome" : driver = new ChromeDriver();
		                  break;
		case "edge" : driver = new EdgeDriver();
		                  break;
		case "firefox" : driver = new FirefoxDriver();
		                  break;
		default : System.out.println("Invalid browser name...");
		                  return;
		 //if user enter the invalid then if we use return; it will completely exits from the method.
		                  //So it will not executes the remaining code.
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
	}
	
	@Test
	void test_Title() 
	{
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@Test
	void test_Url() 
	{
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test
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
