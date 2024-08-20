package com.OperationsOnWebpage;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAuthenticatedPopup {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		// Handling authenticted popup
		// https://username:password@URL

		
		////Approach 1
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		/*ring URL = "http://" + "admin" + ":" + "admin" + "@" + "the-internet.herokuapp.com/basic_auth"; 
		 driver.get(URL); 
         Alert alert =driver.switchTo().alert(); 
		 alert.accept();     */   
		
		
		
		

		/*
		 * //Approach 1
		 * String URL = "http://" + rajkumar + ":" + myPassword + "@" +
		 * www.softwaretestingmaterial.com; driver.get(URL); Alert alert =
		 * driver.switchTo().alert(); 
		 * alert.accept();
		 * 
		 * 
		 * 
		 * Approach 2
		 * 
		 * driver.switchTo().alert(); //Selenium-WebDriver Java Code for entering
		 * Username & Password as below:
		 * driver.findElement(By.id("userID")).sendKeys("userName");
		 * driver.findElement(By.id("password")).sendKeys("myPassword");
		 * driver.switchTo().alert().accept(); 
		 * driver.switchTo().defaultContent();
		 * 
		 */
	}

}
