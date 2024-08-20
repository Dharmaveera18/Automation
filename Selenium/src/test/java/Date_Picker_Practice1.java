import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Date_Picker_Practice1 {

	
	public static void selectfuturedate(WebDriver driver, String expectedYear, String expectedmonth, String expecteddate)
	{
		while (true) {
			// Select/capture month and year
			String current_Month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String current_year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			
			if(current_Month.equals(expectedmonth) && (current_year.equals(expectedYear)))
			{
				break;
			}
			
			//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();//Next
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();//Previous
		}
		
		//Select date
		
		 List<WebElement> Alldates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
	
	    for(WebElement dt:Alldates)
	    {
	    	if(dt.getText().equals(expecteddate))
	    	{
	    		dt.click();
	    	}
	    }
	}
	
	public static void selectPastDates(WebDriver driver, String expectedYear, String expectedmonth, String expecteddate)
	{
		while (true) {
			// Select/capture month and year
			String current_Month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String current_year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			
			if(current_Month.equals(expectedmonth) && (current_year.equals(expectedYear)))
			{
				break;
			}
			
			//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();//Next
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();//Previous
		}
		
		//Select date
		
		 List<WebElement> Alldates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
	
	    for(WebElement dt:Alldates)
	    {
	    	if(dt.getText().equals(expecteddate))
	    	{
	    		dt.click();
	    	}
	    }
	}
	
	
	
	
	public static void main(String[] args) {

		// Launch Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();

		// Switch to frame
		driver.switchTo().frame(0);

		// MEthod 1 = enter date using sendkeys
		//driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("03/03/2024");

		
		
		// Method 2 : select date using date picker
		
		String expectedmonth = "May";
		String expectedYear = "2022";
		String expecteddate = "10";
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
        //Select future dates
		//selectfuturedate(driver,expectedYear,expectedmonth,expecteddate);
		selectPastDates(driver,expectedYear,expectedmonth,expecteddate);
	}

}
