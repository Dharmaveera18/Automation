package com.shadowDomElements;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleShadowDomElements1 {

	public static void main(String[] args) throws InterruptedException {


       WebDriver driver =  new ChromeDriver();
		
		driver.get("https://dev.automationtesting.in/shadow-dom/");
		
		driver.manage().window().maximize();
		
		/*
		//1.This Element is inside single shadow DOM.
		//
		SearchContext shadow = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(1000);
		String text = shadow.findElement(By.cssSelector("#shadow-element")).getText();
		
		System.out.println(text);
		*/
		
		//This Element is inside 2 nested shadow DOM.
		
		/*
		SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		Thread.sleep(1000);
		String text1 = shadow1.findElement(By.cssSelector("#nested-shadow-element")).getText();
		System.out.println(text1);
		
		*/
	
		SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadow2 = shadow1.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
		Thread.sleep(1000);
		String text3 = shadow2.findElement(By.cssSelector("#multi-nested-shadow-element")).getText();
	    System.out.println(text3);
	
	
	
	
	}

}
