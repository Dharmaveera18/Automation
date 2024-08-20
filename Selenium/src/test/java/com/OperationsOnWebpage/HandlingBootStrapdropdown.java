package com.OperationsOnWebpage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingBootStrapdropdown {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
		

		//1)Select 1 option from the dropdown
		
		
		driver.findElement(By.xpath("//input[@value='Java']")).click();
		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
		System.out.println("total no o options :"+options.size());
		
		//printing the options
		
		for(WebElement op:options)
		{
			System.out.println(op.getText());
		}
		
       //To Select Multiple options
		for(WebElement op:options)
		{
			String option = op.getText();
			if(option.equals("Java") || option.equals("Angular") || option.equals("MySQL"))
			{
				op.click();
			}
		}
		
		
	}

}
