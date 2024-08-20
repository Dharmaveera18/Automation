package com.OperationsOnWebpage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_Auto_Suggestion {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://google.com/");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Selenium");
		Thread.sleep(3000);
		
		
		List<WebElement> options = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@class='wM6W7d']"));
		System.out.println("The No of options are :"+options.size());
		
	
		for(int i=0; i<options.size(); i++)
		{
			System.out.println(options.get(i).getText());
		}
		
		for(WebElement op:options)
		{
			String text = op.getText();
			if(text.equals("selenium"))
			{
				op.click();
			}
		}
		
	}

}
