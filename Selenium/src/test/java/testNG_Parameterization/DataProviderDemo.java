package testNG_Parameterization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

	WebDriver driver;
	
	
	@BeforeClass
	void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider = "dp")
	void test_Login(String email, String pswd) throws InterruptedException
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pswd);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(5000);
		boolean status = driver.findElement(By.xpath("//img[@alt='client brand banner']")).isDisplayed();
		if(status == true)
		{
			//driver.navigate().back();
			driver.findElement(By.xpath("//img[@class='oxd-userdropdown-img']")).click();
			driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("Failed");
			Assert.fail();
		}
	}
	
	
	@AfterClass
	void tearDown()
	{
		driver.close();
	}
	
	
	@DataProvider(name="dp", indices = {0,1,3})
	Object[][] logindata()
	{
		Object[][] data = {
				
				{"Admin","123456"},
				{"Admin","123456"},
				{"123456","123456"},
				{"Admin","admin123"},
				{"123456","123456"}
		};
		
		return data;
	}
	
}
