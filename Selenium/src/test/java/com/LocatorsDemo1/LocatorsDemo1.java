package com.LocatorsDemo1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo1 {

	public static void main(String[] args) {
		//Open Browser
				WebDriver driver = new ChromeDriver();
				
				//Enter Url
				driver.get("https://demo.opencart.com/");
				driver.manage().window().maximize();
				
				//name
				//driver.findElement(By.name("search")).sendKeys("Mobile");
				
				//id
				System.out.println(driver.findElement(By.id("logo")).isDisplayed());
				
				//LinkText and PartialLinkText
				//driver.findElement(By.linkText("Tablets")).click();
				//driver.findElement(By.partialLinkText("Tab")).click();
				
				//ClassName
				
				//List<WebElement> headerLinks = driver.findElements(By.className("list-inline-item"));
				//System.out.println(headerLinks.size());
				
				//Tagname /links
				//List<WebElement> links = driver.findElements(By.tagName("a"));
				//System.out.println(links.size());
				
				//images
				List<WebElement> links = driver.findElements(By.tagName("img"));
				System.out.println(links.size());
	}

}
