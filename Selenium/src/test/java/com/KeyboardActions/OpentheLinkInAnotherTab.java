package com.KeyboardActions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpentheLinkInAnotherTab {

	public static void main(String[] args) throws InterruptedException {

		// Launch Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();

		WebElement regLink = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));

		Actions act = new Actions(driver);
		
		
		//Cntlr + click on link
		act.keyDown(Keys.CONTROL).click(regLink).keyUp(Keys.CONTROL).perform();
        // Click(regLink) is a actions class method
		
		Thread.sleep(5000);
		List<String> ids = new ArrayList(driver.getWindowHandles());
				
	    driver.switchTo().window(ids.get(1));
	    
	    driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Tshirts");
	  
	    driver.switchTo().window(ids.get(0));
	    
	    driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Mobiles");
	    
		
		
	}

}
