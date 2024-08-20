package com.OperationsOnWebpage;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Date_Picker_Practice {

	public static void main(String[] args) {

		// Launch Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://mui.com/x/react-date-pickers/date-picker/");
		driver.manage().window().maximize();

		//Method1: Select date using sendkeys method
		//driver.findElement(By.xpath("//input[@id=':R6lal9l6kud6:']")).sendKeys("7/30/2024");	
		
		
		//Select date using date picker
		driver.findElement(By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-slyssw'])[1]")).click();
		
		String Expected_MonthYear = "December 2025";
		String Expected_Date = "5";
		String Expected_Year = "2025";
		
		
		
		selectfuturedate(driver,Expected_MonthYear,Expected_Year,Expected_Date);
		//selectpastdate(driver,Expected_MonthYear,Expected_Year,Expected_Date);
		
	}
	
	static  void selectpastdate(WebDriver driver, String Expected_MonthYear, String Expected_Year, String Expected_Date)
	{
		//Select year
		
				WebElement current_yeardrp = driver.findElement(By.xpath("(//button[@aria-label='calendar view is open, switch to year view'])[4]"));
				current_yeardrp.click();
				
				List<WebElement> AllYears = driver.findElements(By.xpath("//div[@role='radiogroup']//div"));
				
				for(WebElement yr:AllYears)
				{
					if(yr.getText().equals(Expected_Year))
					{
						yr.click();
						break;
					}
				}
				
		
				//Select month
				//String current_monthyear = driver.findElement(By.xpath("(//div[@class='MuiPickersFadeTransitionGroup-root css-1bx5ylf']//div)[4]")).getText();
				
		
		
		while(true)
		{
			//Select month
			String current_monthyear1 = driver.findElement(By.xpath("(//div[@class='MuiPickersFadeTransitionGroup-root css-1bx5ylf']//div)[4]")).getText();
		
			if(current_monthyear1.equals(Expected_MonthYear))
			{
				break;
			}
			
			driver.findElement(By.xpath("(//button[@title='Previous month'])[4]")).click(); //Previous Button
			//driver.findElement(By.xpath("(//button[@title='Next month'])[4]")).click(); //Next Button
			   
	    }
		
		
		
		//Select date
		
		List<WebElement> AllDates = driver.findElements(By.xpath("(//div[@role='rowgroup'])[4]//div//button"));
    
		for(WebElement dt:AllDates)
		{
			if(dt.getText().equals(Expected_Date))
			{
				dt.click();
				break;
			}
		}
	}
	
	static  void selectfuturedate(WebDriver driver, String Expected_MonthYear, String Expected_Year, String Expected_Date)
	{
		//Select year
		
				WebElement current_yeardrp = driver.findElement(By.xpath("(//button[@aria-label='calendar view is open, switch to year view'])[4]"));
				current_yeardrp.click();
				
				List<WebElement> AllYears = driver.findElements(By.xpath("//div[@role='radiogroup']//div"));
				
				for(WebElement yr:AllYears)
				{
					if(yr.getText().equals(Expected_Year))
					{
						yr.click();
						break;
					}
				}
				
		
				//Select month
				//String current_monthyear = driver.findElement(By.xpath("(//div[@class='MuiPickersFadeTransitionGroup-root css-1bx5ylf']//div)[4]")).getText();
				
		
		
		while(true)
		{
			//Select month
			String current_monthyear1 = driver.findElement(By.xpath("(//div[@class='MuiPickersFadeTransitionGroup-root css-1bx5ylf']//div)[4]")).getText();
		
			if(current_monthyear1.equals(Expected_MonthYear))
			{
				break;
			}
			
			//driver.findElement(By.xpath("(//button[@title='Previous month'])[4]")).click(); //Previous Button
			driver.findElement(By.xpath("(//button[@title='Next month'])[4]")).click(); //Next Button
			   
	    }
		
		
		
		//Select date
		
		List<WebElement> AllDates = driver.findElements(By.xpath("(//div[@role='rowgroup'])[4]//div//button"));
    
		for(WebElement dt:AllDates)
		{
			if(dt.getText().equals(Expected_Date))
			{
				dt.click();
				break;
			}
		}
	}

	/*public static Month convertMonth(String month)
	{
		HashMap<String, Month> mapMonth = new HashMap<String, Month>();
		
		mapMonth.put("January", Month.JANUARY);
		mapMonth.put("February", Month.FEBRUARY);
		mapMonth.put("March", Month.MARCH);
		mapMonth.put("April", Month.APRIL);
		mapMonth.put("May", Month.MAY);
		mapMonth.put("June", Month.JUNE);
		mapMonth.put("July", Month.JULY);
		mapMonth.put("August", Month.AUGUST);
		mapMonth.put("September", Month.SEPTEMBER);
		mapMonth.put("October", Month.OCTOBER);
		mapMonth.put("November", Month.NOVEMBER);
		mapMonth.put("December", Month.DECEMBER);
		
		Month vmonth = mapMonth.get(month);
		
		if(vmonth == null)
		{
			System.out.println("Invalid month");
		}
		return vmonth;
	}*/

}
