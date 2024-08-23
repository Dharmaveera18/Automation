package com.shadowDomElements;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleShadowDomElements {

	public static void main(String[] args) {


		WebDriver driver =  new ChromeDriver();
		
		driver.get("https://books-pwakit.appspot.com");
		
		driver.manage().window().maximize();
		
		//driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).sendKeys("WELCOME");
		//NoSuchElementException.
		
		
		SearchContext shadow = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
        
		shadow.findElement(By.cssSelector("#input")).sendKeys("WELCOME");
		
		
		
		
	}

}
