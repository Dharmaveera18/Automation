package com.OperationsOnWebpage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bjs_Auto_Suggestion_Dropdown {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.bjs.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("search")).sendKeys("tv");
		
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='list list-group']"));
		
        System.out.println(options.size());
        
        /*for(WebElement op:options)
        {
        	System.out.println(op.getText());
        }*/
        
        for(int i=0; i<options.size(); i++)
        {
        	System.out.println(options.get(i).getText());
        }
		
	}

}
