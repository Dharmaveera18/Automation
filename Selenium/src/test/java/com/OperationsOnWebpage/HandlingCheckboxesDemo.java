package com.OperationsOnWebpage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCheckboxesDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		
		System.out.println(checkboxes.size());
       
		/*////Select and Deselect all checkboxes using normal for loop
		for(int i = 0; i<checkboxes.size(); i++)
		{
			checkboxes.get(i).click();
		}
		
		for(int i = 0; i<checkboxes.size(); i++)
		{
			checkboxes.get(i).click();
		}*/
		
		
		//Select and deselect all checkboxes using enahenced for loop
		
		/*for(WebElement checkbox:checkboxes)
		{
			checkbox.click();
		}
		
		for(WebElement checkbox:checkboxes)
		{
			checkbox.click();
		}*/
		
		
		//To select only first 3 checkboxes and last 3
		/*for(int i = 0; i<3; i++)
		{
			checkboxes.get(i).click();
		}
		
		for(int i = 4; i<checkboxes.size(); i++)
		{
			checkboxes.get(i).click();
		}*/
		
		//Select only even checkboxes.
		for(int i =0; i<checkboxes.size(); i++)
		{
			if(i%2==0)
				checkboxes.get(i).click();
		}
		
		//unselect if already selected checkboxes
		
		for(int i =0; i<checkboxes.size(); i++)
		{
			if(checkboxes.get(i).isSelected())
				checkboxes.get(i).click();
		}
	}

}
