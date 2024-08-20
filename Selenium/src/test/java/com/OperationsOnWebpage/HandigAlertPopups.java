package com.OperationsOnWebpage;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandigAlertPopups {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		//driver.get("https://mypage.rediff.com/login/dologin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//1)Normal Alert
		/*driver.findElement(By.xpath("//button[normalize-space()='Alert']")).click(); 
		Alert myalert = driver.switchTo().alert();
		System.out.println(myalert.getText());
		myalert.accept();*/
		
		
		//2)Confirmation Alert
		/*
		driver.findElement(By.xpath("//button[normalize-space()='Confirm Box']")).click(); 
		Alert myalert = driver.switchTo().alert();
		//myalert.accept();
		System.out.println(myalert.getText()); //Press a button!
		myalert.dismiss();
		*/
		
		
		//3)prompt Alert
		/*driver.findElement(By.xpath("//button[normalize-space()='Prompt']")).click(); 
		Alert myalert = driver.switchTo().alert();
		//myalert.accept();
		System.out.println(myalert.getText()); //Press a button!
		myalert.sendKeys("Dharma");
		//myalert.accept();
		myalert.dismiss();*/
		
		// How to Handle alert without using SwichTo.alert() method
		
		//Window popup
	
		/*
		driver.get("https://mypage.rediff.com/login/dologin");
		driver.findElement(By.xpath("//input[@value='Login']")).click(); 
		Alert myalert = driver.switchTo().alert();
		System.out.println(myalert.getText());
		myalert.accept();
		*/
		
	}

}
