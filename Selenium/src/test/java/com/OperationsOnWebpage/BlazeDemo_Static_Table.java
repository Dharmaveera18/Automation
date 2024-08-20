package com.OperationsOnWebpage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BlazeDemo_Static_Table {

	public static void main(String[] args) throws InterruptedException {

		// Launch Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();

		// Choose departure city
		WebElement drop1 = driver.findElement(By.name("fromPort"));

		Select dropdown1 = new Select(drop1);
		dropdown1.selectByValue("Boston");

		// Choose destination city
		WebElement drop2 = driver.findElement(By.xpath("//select[@name='toPort']"));

		Select dropdown2 = new Select(drop2);
		dropdown2.selectByVisibleText("Berlin");

		// Click on the find flights button
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();

		// Find no of rows
		int rows = driver.findElements(By.xpath("//table[@class='table']//tr")).size();
		System.out.println("No of rows :"+rows);

		// Find no of columns
		int cols = driver.findElements(By.xpath("//table[@class='table']//th")).size();
		System.out.println("No of columns :"+cols);
		
		//to print all the data from rows and columns
		
		for(int r=1; r<rows; r++)
		{
			for(int c=1; c<=cols; c++)
			{
				String textValue = driver.findElement(By.xpath("//table[@class='table']//tr["+r+"]//td["+c+"]")).getText();
				
				System.out.print(textValue+"\t");
				
			}
			System.out.println();
		}
		Thread.sleep(5000);
		
		
		//To print only price
		
		for(int r=1; r<rows; r++)
		{
			
			try {
				String price = driver.findElement(By.xpath("//table[@class='table']//tr["+r+"]//td[6]")).getText();
				if(price.equals("$200.98"))
				{
					driver.findElement(By.xpath("//table[@class='table']//tr[3]//td[1]//input")).click();
					
				}
			}
			catch(Exception e)
			{
				System.out.println("=================Exception occurs====================");
			}
			
		
			//System.out.println(price);
			/*char []array = price.toCharArray();
			
			for(int i=0; i<array.length; i++)
			{
				System.out.println(array[i]);
			}*/
	
		}
		
		
		
		
		
		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Dharma");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("ravihal");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Siruguppa");
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Karnataka");
		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("123456");
		WebElement cardtypes = driver.findElement(By.xpath("//select[@id='cardType']"));
		Select cardtype = new Select(cardtypes);
		cardtype.selectByIndex(0);
		driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("12345678");
		driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("Dharmaveera");
		driver.findElement(By.xpath("//input[@id='rememberMe']")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		
		
		String text = driver.findElement(By.xpath("//h1[normalize-space()='Thank you for your purchase today!']")).getText();
		if(text.equals("Thank you for your purchase today!"))
		{
			System.out.println("================= TEST PASSED =============");
		}
		
	}

}
