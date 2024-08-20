package com.WebDrivermethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingBrowserWindows1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']"))
		.sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		List<WebElement> links = driver.findElements(By.xpath("//div[@id='wikipedia-search-result-link']/a"));
		int noOflinks = links.size();
		System.out.println("No of links are  :" +noOflinks);
		
		for(int i=0; i<noOflinks; i++)
		{
			System.out.println(links.get(i));
			links.get(i).click();
			Thread.sleep(5000);
		}
		//links.get(0).click();
		
		Set<String> windowIDs = driver.getWindowHandles();
		
		/*
		List<String> windowList = new ArrayList(windowIDs);
		
		String parentid = windowList.get(0);
		String child1_id = windowList.get(1);
		String child2_id = windowList.get(2);
		String child3_id = windowList.get(3);
		String child4_id = windowList.get(4);
		String child5_id = windowList.get(5);
		//System.out.println(driver.getTitle());
		
		//switch to child window
		driver.switchTo().window(parentid);
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		
		
		driver.switchTo().window(child1_id);
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		
		//switch to parent window
		driver.switchTo().window(child2_id);
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(child3_id);
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(child4_id);
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(child5_id);
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
		//driver.switchTo().window(parentid);
		//Thread.sleep(2000);
		//System.out.println(driver.getTitle());
		
		*/
		
		for(String winid:windowIDs)
		{
			String title = driver.switchTo().window(winid).getTitle();
			if(title.equals("Selenium - Wikipedia"))
			{
				System.out.println(title);
				System.out.println(driver.getCurrentUrl());
			}
			else if(title.equals("Automation Testing Practice"))
			{
				System.out.println(title);
				System.out.println(driver.getCurrentUrl());
			}
			else if(title.equals("Selenium dioxide - Wikipedia"))
			{
				System.out.println(title);
				System.out.println(driver.getCurrentUrl());
			}
			else if(title.equals("Selenium disulfide - Wikipedia"))
			{
				driver.close();
				//System.out.println(title);
				//System.out.println(driver.getCurrentUrl());
			}	
			else if(title.equals("Selenium (software) - Wikipedia"))
			{
				driver.close();
				//System.out.println(title);
				//System.out.println(driver.getCurrentUrl());
			}
			else if(title.equals("Selenium in biology - Wikipedia"))
			{
				System.out.println(title);
				System.out.println(driver.getCurrentUrl());
			}
		}
		
		
		
		
		
		
		
		
		
		/*
		for(int i=0; i<noOflinks; i++)
		{
			if(!(links.get(i).getText().isEmpty()))
			{
				links.get(i).click();
				driver.navigate().back();
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				links = driver.findElements(By.xpath("//div[@id='wikipedia-search-result-link']/a"));
			}
		}*/
      
	}

}
