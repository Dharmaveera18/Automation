package com.LocatorsDemo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSS_selectorDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		//Enter Url   https://demo.nopcommerce.com/
		driver.get("https://google.com/");
		driver.manage().window().maximize();
		
		//Tag#id
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-Shirts");
		//driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("T-Shirts");              //tag optional
		
		//Tag.className
	    // driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("T-Shirts");
        //driver.findElement(By.cssSelector(".search-box-text")).sendKeys("T-Shirts");              //tag optional
				
        //tag[AN =AV]
		//driver.findElement(By.cssSelector("input[name=\"q\"]")).sendKeys("T-Shirts"); 
		
		
		//tag.className[AN=AV]
		//driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("T-Shirts"); 
		driver.findElement(By.cssSelector(".MV3Tnb[href='https://store.google.com/IN?utm_source=hp_header&utm_medium=google_ooo&utm_campaign=GS100042&hl=en-IN']")).click();
		//System.out.println(img);
	}

}
