package com.OperationsOnWebpage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingHiddenDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		//Launching browser
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		//Login with valid credentials
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(5000);
		//Click on PIM link
		
		WebElement element = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		//driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item active'])[1]")).click();
		
		//Click on dropdown
		driver.findElement(By.xpath("//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='oxd-table-filter']/div[@class='oxd-table-filter-area']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[6]/div[1]/div[2]/div[1]/div[1]")).click();
		
		Thread.sleep(5000);
		
		//Select single option
		//driver.findElement(By.xpath("//span[normalize-space()='Account Assistant']")).click();
		
		
		//No of options
		List<WebElement> options = driver.findElements(By.xpath("//div[@role='listbox' and @class='oxd-select-dropdown --positon-bottom']/div"));
		
		System.out.println("No of options are :"+options.size());
		
		//capturing options
		
		for(WebElement op:options)
		{
			System.out.println(op.getText());
		}
		 
		
		
		
	}

}
