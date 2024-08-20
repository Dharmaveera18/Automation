package com.OperationsOnWebpage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Date_Picker_Demo1 {

	public static void main(String[] args) {
		
		// Launch Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		//
		String expectedMonth = "August";
	    String expectedyear = "2026";
		String expectedDate = "10";
		//Switch to frame
		
		driver.switchTo().frame(0);
		//Method1 : date using sendkeys
		//driver.findElement(By.id("datepicker")).sendKeys("08/12/2024");
		
		//Method 2 :Using date picker
		driver.findElement(By.id("datepicker")).click();
		
		//selectFutureDate(driver,expectedyear,expectedMonth,expectedDate);
		selectPastDate(driver,expectedyear,expectedMonth,expectedDate);
	}

public static void selectFutureDate(WebDriver driver, String expectedyear, String expectedMonth,String expectedDate)
{
	while(true)
	{
	
	//Select month and year
	String Current_month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
	String Current_year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
	
	if(Current_month.equals(expectedMonth) && (Current_year.equals(expectedyear)))
	{
		break;
		
	}
	
	driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
	}
	
	//Select date
	
   List<WebElement> AllDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
	
	for(WebElement dt:AllDates)
	{
		if(dt.getText().equals(expectedDate))
		{
			dt.click();
			break;
		}
	}
}

public static void selectPastDate(WebDriver driver, String expectedyear, String expectedMonth,String expectedDate)
{
	while(true)
	{
	
	//Select month and year
	String Current_month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
	String Current_year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
	
	if(Current_month.equals(expectedMonth) && (Current_year.equals(expectedyear)))
	{
		break;
		
	}
	
	driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
	}
	
	//Select date
	
   List<WebElement> AllDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
	
	for(WebElement dt:AllDates)
	{
		if(dt.getText().equals(expectedDate))
		{
			dt.click();
			break;
		}
	}
}

}
