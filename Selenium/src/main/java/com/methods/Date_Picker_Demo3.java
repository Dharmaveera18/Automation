package com.methods;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Date_Picker_Demo3 {

	public static void main(String[] args) throws InterruptedException {

		// Launch Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		Thread.sleep(5000);
		driver.switchTo().frame("frame-one796456169");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();

		String expectedMonth = "May";
		String ExpectedYear = "1998";
		String ExpectedDate = "30";
		
		selectdate(driver, ExpectedYear,expectedMonth,ExpectedDate);

	}

	static void selectdate(WebDriver driver, String ExpectedYear, String expectedMonth, String ExpectedDate)
	{
		while(true)
		{
			
			// Select year

			WebElement yeardrodown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
			Select yeardropdown = new Select(yeardrodown);
			yeardropdown.selectByVisibleText(ExpectedYear);

		
		// Select month
		String current_month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

		Month ExpectedMonth = convertMonth(expectedMonth);
		Month Current_month = convertMonth(current_month);
		
		//compare
		
		int result = ExpectedMonth.compareTo(Current_month);
		//<month ==>past month
		//>month ==>Future month
		//0 ==>current month
		
		if(result<0)
		{
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		}
		else if(result>0)
		{
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		else
		{
			break;
		}
     }
		//Select date
		 List<WebElement> AllDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		    
	        for(WebElement dt:AllDates)
	        {
	        	
	        	if(dt.getText().equals(ExpectedDate))
	        	{
	        		dt.click();
	        	}
	        }
	}

	// User defined method for converting month from string to month object
	public static Month convertMonth(String month) {

		HashMap<String, Month> monthMap = new HashMap<String, Month>();

		monthMap.put("January", Month.JANUARY);
		monthMap.put("February", Month.FEBRUARY);
		monthMap.put("March", Month.MARCH);
		monthMap.put("April", Month.APRIL);
		monthMap.put("May", Month.MAY);
		monthMap.put("June", Month.JUNE);
		monthMap.put("July", Month.JULY);
		monthMap.put("August", Month.AUGUST);
		monthMap.put("September", Month.SEPTEMBER);
		monthMap.put("October", Month.OCTOBER);
		monthMap.put("November", Month.NOVEMBER);
		monthMap.put("December", Month.DECEMBER);

		Month vmonth = monthMap.get(month);

		if (vmonth == null) {
			System.out.println("Invalid Month...");
		}

		return vmonth;

	}

}
