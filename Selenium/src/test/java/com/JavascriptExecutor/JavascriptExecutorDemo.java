package com.JavascriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorDemo {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		//ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement Inputbox = driver.findElement(By.xpath("//input[@id='name']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//JavascriptExecutor js = driver;
		
		js.executeScript("arguments[0].setAttribute('value','John')", Inputbox);
		//the inputbox element will be storred in argumets[0] prdefined array, from there using setAttribut mentod we set the value of elemet

		WebElement radiobtn = driver.findElement(By.xpath("//input[@id='male']"));
		js.executeScript("arguments[0].click()", radiobtn);
		
		
		
		/*Practice
		WebElement emali_field = driver.findElement(By.id("email"));
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    
	    js.executeScript("arguments[0].setAttribute('value','Dharma')", emali_field);
	
	
	    WebElement Checkbox = driver.findElement(By.xpath("//input[@id='sunday']"));
	    
	    js.executeScript("arguments[0].click()", Checkbox);
	     */
	
	}

}
