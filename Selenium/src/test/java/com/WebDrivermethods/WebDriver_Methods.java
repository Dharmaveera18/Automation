package com.WebDrivermethods;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriver_Methods {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		/* findElement()
		 * findElements()
		 * manage()
		 * swichTo()
		 * navigate()
		 *  
		 *
		 */
		
		
		//get()
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

		/*
		//getTitle
		System.out.println(driver.getTitle());
		
		//getCurrentUrl
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		System.out.println(driver.getCurrentUrl());
		
		//getPageSource
		System.out.println(driver.getPageSource());
		
		//getWindowHandle = getting window id
		String windowid = driver.getWindowHandle();
		System.out.println(windowid);
		
		//getWindowHandles = getting window ids
		driver.findElement(By.xpath("//a[normalize-space()='Facebook']")).click();
		Set<String> window_ids = driver.getWindowHandles();
		System.out.println(window_ids);
		*/
	//
		//isdisplayed and isEnabled 
		WebElement  search = driver.findElement(By.xpath("//button[text()='Search']"));
		System.out.println("Search button is displayed:  "+search.isDisplayed());
		System.out.println("search button is enabled :  "+search.isEnabled());
		
		
		//isSelected
		WebElement  excellent_rd = driver.findElement(By.id("pollanswers-1"));
		System.out.println("Excellnt rd button is selected :  "+excellent_rd.isSelected());
		excellent_rd.click();
		System.out.println("Excellnt rd button is selected :  "+excellent_rd.isSelected());
		
		//driver.close();  //-->Closes only one window(tab)
		
		//driver.quit();   //--->Closes entire browser(All tabs)
	}

}
