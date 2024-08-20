package com.JavascriptExecutor;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomInZoomOut {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		//ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		
		/*
		driver.manage().window().minimize();
		Thread.sleep(5000);
		*/
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("document.body.style.zoom='50%'"); //Set the zoom level to 50%
		Thread.sleep(5000);
		js.executeScript("document.body.style.zoom='80%'"); //Set the zoom level to 80%
		
		

	}

}
