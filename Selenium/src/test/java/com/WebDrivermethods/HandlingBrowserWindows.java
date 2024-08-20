package com.WebDrivermethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingBrowserWindows {

	public static void main(String[] args) {

		
		WebDriver driver = new ChromeDriver();
		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.navigate().to("https://demo.nopcommerce.com/");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		Set<String> windowids = driver.getWindowHandles();
		
		//Approach 1
		/*List<String> windowList = new ArrayList(windowids);
		
		String parentid = windowList.get(0);
		String childid = windowList.get(1);
		//System.out.println(driver.getTitle());
		
		//Switch to child window
		driver.switchTo().window(childid);
		System.out.println(driver.getTitle());
		
		//Switch to parent window
		driver.switchTo().window(parentid);
		System.out.println(driver.getTitle());
		*/
		//Approach 2
		
		for(String winid:windowids)
		{
			String title = driver.switchTo().window(winid).getTitle();
			if(title.equals("Human Resources Management Software | OrangeHRM"))
			{
				System.out.println(driver.getCurrentUrl());
			}
				
		}
	}

}
