package com.OperationsOnWebpage;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingAlertWithExplicitWait {

	public static void main(String[] args) {
		
		//Handling alert without using SwitchTo.alert() method
		
		WebDriver driver = new ChromeDriver(); //https://www.browserstack.com/users/sign_up
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[normalize-space()='Alert']")).click(); 
		
		Alert myalert = mywait.until(ExpectedConditions.alertIsPresent());
		
		myalert.accept();

	}

}
