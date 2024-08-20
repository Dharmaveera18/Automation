package com.OperationsOnWebpage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamic_Table_With_Pagination {

	public static void main(String[] args) throws InterruptedException {

		// Launch Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo-opencart.com/admin/index.php?route=common/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("demo");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("demo");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		if(driver.findElement(By.xpath("//button[@class='btn-close']")).isDisplayed())
		{
			 driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		}
		
		driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
		driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();
		
		//Get Showing 1 to 10 of 234 (24 Pages) text
		
		String text = driver.findElement(By.xpath("//div[contains(text(),'Showing')]")).getText();
		System.out.println(text);
		
		int totalNofPages = Integer.parseInt(text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1));
		System.out.println("Total no of pages :"+totalNofPages);
		
		for(int p=1; p<=totalNofPages; p++)
		{
			if(p>1)
			{
				WebElement activepage = driver.findElement(By.xpath("//ul[@class='pagination']//*[text()="+p+"]"));
				//WebElement element = driver.findElement(By.id("gbqfd"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", activepage);
				Thread.sleep(3000);
			}
			
			
			//reading data from particular page
			
			int NoOfRows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
			for(int r=1; r<=NoOfRows; r++)
			{
				String CustomerName = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[2]")).getText();
				String Email = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[3]")).getText();
				String DateAdded = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[5]")).getText();
				
				
				System.out.println(CustomerName+"  \t  "+Email+"  \t  "+DateAdded);
			}
			
			
		}
		
	}

}
