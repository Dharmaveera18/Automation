package com.OperationsOnWebpage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePicker_Demo2 {

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
		String ExpectedYear = "2022";
		String ExpectedDate = "30";
		
        //Select month
   
        while(true)
        {
        	driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
        	String current_month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
        	
        	if(current_month.equals(expectedMonth))
        	{
        		System.out.println(current_month);
        		break;
        	}
        	
        }

		//Select year
        
		WebElement yeardrodown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select yeardropdown = new Select(yeardrodown);
        yeardropdown.selectByVisibleText(ExpectedYear);
       
        //Select date
              
        List<WebElement> AllDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
	    
        for(WebElement dt:AllDates)
        {
        	
        	if(dt.getText().equals(ExpectedDate))
        	{
        		dt.click();
        	}
        }
        
        String text = driver.findElement(By.id("RESULT_TextField-2")).getText();
	    System.out.println(text);
	}

}
