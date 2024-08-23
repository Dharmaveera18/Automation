package com.SVGElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleSVGElements {

	public static void main(String[] args) throws InterruptedException {
        
		
		WebDriver driver =  new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		
		//Absolute Xpath - working
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[4]/a[1]/*[name()='svg'][1]")).click();

		//rel xpath - not working
		//driver.findElement(By.xpath("//a[class='oxd-main-menu-item']//*[name()='svg'][1]")).click();
		
		
		
		
		
	}

}
