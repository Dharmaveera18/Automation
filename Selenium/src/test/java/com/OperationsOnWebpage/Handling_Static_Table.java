package com.OperationsOnWebpage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_Static_Table {

	public static void main(String[] args) {
		
		
		//Launch Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//1) No of rows
		List<WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));    //if multiple table present
		//List<WebElement> rows = driver.findElements(By.tagName("tr")); // if only one table present
		System.out.println("No of rows are"+rows.size());
		
		
		//2) No of columns
		List<WebElement> cols = driver.findElements(By.xpath("//table[@name='BookTable']//th"));    //if multiple table presen
		//List<WebElement> rows = driver.findElements(By.tagName("th")); // if only one table present
		System.out.println("No of cols are"+cols.size());
		
		
		//3)if we want get data from specific row and column
		String BookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
		System.out.println(BookName);     //Master in Selenium
		
		
		//4)Read data from all the rows and columns
		
		System.out.println("BookName"+"\t\t"+"Author"+"\t\t"+"Subject"+"\t\t"+"Price");
		
		for(int r = 2; r<=rows.size(); r++)
		{
			for(int c = 1; c<=cols.size(); c++)
			{
				String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText(); //to pass parameter in xpath we have to follow the follwing syntex
				
				System.out.print(value+"\t\t");
			}
			System.out.println();
		}
		
		
		//5)Print bookName whoose author is Mukesh
		
		for(int r = 2; r<=rows.size(); r++)
		{
			String AuthorName =  driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			//System.out.println(AuthorName); // All author name
			if(AuthorName.equals("Mukesh"))
			{
				String BookName1 =  driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
				System.out.println(BookName1+"\t"+AuthorName);
			}
		}
		
		
		
		//6) Find total price of all the books
		
		int total= 0;
		for(int r = 2; r<=rows.size(); r++)
		{
			String price =  driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
			//System.out.println(price); // All prices name
			
			total = total+Integer.parseInt(price);
		
		}
		
		System.out.println("Total Price of the books :"+total);
	}

}
