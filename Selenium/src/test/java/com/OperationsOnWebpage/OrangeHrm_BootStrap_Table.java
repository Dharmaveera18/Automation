package com.OperationsOnWebpage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHrm_BootStrap_Table {

	public static void main(String[] args) throws InterruptedException {
		// Launch Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		Thread.sleep(5000);
		WebElement AdminBtn = driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", AdminBtn);
		//click on admin link
		Thread.sleep(5000);
		//div[@role='table']//div[@class='oxd-table-body']//div[@role='row']
		int NoOfRows = driver.findElements(By.xpath("//div[@class='oxd-table-body' and @role = 'rowgroup']//div[@class='oxd-table-card']")).size();
		System.out.println(NoOfRows);
		
		int NoOfCols = driver.findElements(By.xpath("//div[@class='oxd-table-row oxd-table-row--with-border' and @role = 'row']//div[@role = 'columnheader']")).size();
		System.out.println(NoOfCols);
		
		/*for(int c=1; c<=NoOfRows; c++)
		{
			String value = driver.findElement(By.xpath("(//div[@class='oxd-table-row oxd-table-row--with-border']//div[@role='columnheader'])["+c+"])")).getText();
		    System.out.println(value);
		    System.out.println(" ");
		}*/
		
		
		
		for(int r=1; r<=NoOfRows; r++)
		{
			String Username = driver.findElement(By.xpath("//div[@class='oxd-table-body' and @role='rowgroup']//div["+r+"]//div[2]")).getText();
		    String Userrole = driver.findElement(By.xpath("//div[@class='oxd-table-body' and @role='rowgroup']//div["+r+"]//div[3]")).getText();

		    String EmpName = driver.findElement(By.xpath("//div[@class='oxd-table-body' and @role='rowgroup']//div["+r+"]//div[4]")).getText();
		    
		    String Status = driver.findElement(By.xpath("//div[@class='oxd-table-body' and @role='rowgroup']//div["+r+"]//div[5]")).getText();
		    
		   // driver.findElement(By.xpath("//div[@class='oxd-table-body' and @role='rowgroup']//div[1]//div[6]//button//i[@class='oxd-icon bi-trash']")).click();
		    
		    //driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
		  
		    System.out.println(Username+"\t"+Userrole+"\t"+EmpName+"\t"+Status);
		    //System.out.println(NoOfRows);
		    
		    
		}
		
		
	}

}
