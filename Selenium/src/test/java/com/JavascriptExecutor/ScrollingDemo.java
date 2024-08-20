package com.JavascriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		//ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		
		
		/*
		//1.Scroll the page by pixcel number
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,1500)", "");
		System.out.println(js.executeScript("return window.pageYOffset;", ""));
		

		//2.Scroll the page till the element is visible
		
		WebElement ele = driver.findElement(By.xpath("(//h2[@class='title'])[9]"));
		js.executeScript("arguments[0].scrollIntoView();", ele);
		System.out.println(js.executeScript("return window.pageYOffset;", ""));
		
		
		//3.Scroll the page till end of the page
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;", ""));
		
		
		//Scrolling upto initial position
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;", ""));
		
		*/
		
		//Practice
		
	   //1.Scroll by pixel number
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,1500)", "");
		System.out.println(js.executeScript("return window.pageYOffset;", ""));
		
	    //2.Scroll the page till the element visible
		
		WebElement dragAndDrop = driver.findElement(By.xpath("(//h2[@class='title'])[7]"));
		js.executeScript("arguments[0].scrollIntoView();", dragAndDrop);
		System.out.println(js.executeScript("return window.pageYOffset;", ""));
		
		Thread.sleep(5000);
		//3.Scroll the page till the end of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;", ""));
		
		
		//4.Scroll the pagr back to initial position
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;", ""));
		
		
	}

}
