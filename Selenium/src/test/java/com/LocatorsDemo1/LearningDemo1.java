/*
 * test case
 * //Open Browser
 * //Enter Url
 * //Validate the page title
 * //Close the Browser
 */

package com.LocatorsDemo1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
public class LearningDemo1 {

	public static void main(String[] args) {
		
		//Open Browser
		WebDriver driver = new ChromeDriver();
		
		//Enter Url
		driver.get("https://demo.opencart.com/");
		
		//Validate the page title
		String act_title = driver.getTitle();
		if(act_title.equals("Your Store"))
		{
			System.out.println("Test Passed");
		}
		
		//Close the Browser
		driver.close();

	}

}
