package com.LocatorsDemo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {

	public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
		
		//Enter Url   https://demo.nopcommerce.com/
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
        
		
		//Xpath by single attribute
		
		//driver.findElement(By.xpath("//input[@name='search']")).sendKeys("TShirts");
		
		//Xpath by multple attribute
		//driver.findElement(By.xpath("//input[@name='search'][@placeholder='Search']")).sendKeys("TShirts");
		
		
		//Xpath by 'and' 'or' operator
		//driver.findElement(By.xpath("//input[@name='search' and @placeholder='Search']")).sendKeys("TShirts");
		//driver.findElement(By.xpath("//input[@name='search' or @placeholder='Search']")).sendKeys("TShirts");

		
		//Xpath by text()
		
		/*driver.findElement(By.xpath("//a[text()='Desktops']")).click();

		boolean DisplayStatus = driver.findElement(By.xpath("//h3[text()='Featured']")).isDisplayed();
		System.out.println(DisplayStatus);
		System.out.println(driver.findElement(By.xpath("//h3[text()='Featured']")).getText());
		*/
		
		//Xpath by contains
		
		//driver.findElement(By.xpath("//input[contains(@name,'sea')]")).sendKeys("Tshirts");
		
		//Xpath by starts-with
		//driver.findElement(By.xpath("//input[starts-with(@name,'sea')]")).sendKeys("Tshirts");
		
		//Xpath by chained xpath
		boolean DisplayStatus = driver.findElement(By.xpath("//div[@id='logo']/a/img")).isDisplayed();
		System.out.println(DisplayStatus);
		
		
	}

}
