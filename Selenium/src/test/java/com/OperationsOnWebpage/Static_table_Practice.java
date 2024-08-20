package com.OperationsOnWebpage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Static_table_Practice {

	public static void main(String[] args) {

		// Launch Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
		//1) Find No of rows
		
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
        System.out.println("No of rows are :"+rows);
        
        //2) Find No of cols  
        int cols = driver.findElements(By.xpath("//table[@name='BookTable']//tr[1]//th")).size();
        System.out.println("No of columns are :"+cols);
        
        //3)To find/get data from specific row and column
        
        String  bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[6]//td[1]")).getText();
        System.out.println(bookName);
        
        
        //To print headers
        for(int r=1; r<2; r++)
        {
        	for(int c=1; c<=cols; c++)
        	{
        		String HeaderText = driver.findElement(By.xpath("//table[@name='BookTable']//tr[1]//th["+c+"]")).getText();
            	System.out.print(HeaderText);
        	}
        	
        }
        
        
        //4) To get data from all rows and columns
        //System.out.println("BookName"+"\t"+"Author"+"\t"+"Subject"+"\t"+"Price");
        for(int r=2; r<=rows; r++)
        {
        	for(int c = 1; c<=cols; c++)
        	{
        		String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
        		System.out.print(value+"\t");
        	}
        	System.out.println();
        }
        
        //5)To print the booknames whoose author is Mukesh
        
        for(int r = 2; r<=rows; r++)
        {
        	String Authorname = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
        	//System.out.println(Authorname);
        	if(Authorname.equals("Mukesh"))
        	{
        		String BookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
        		System.out.println(BookName);
        	}
        }
        
        //To find total price of the books
        int total =0;
        for(int r = 2; r<=rows; r++)
        {
        	String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
        	//System.out.println(Authorname);
        	total = total +Integer.parseInt(price);
        }
        
        System.out.println("Total price of the book is :"+total);
	}

}
