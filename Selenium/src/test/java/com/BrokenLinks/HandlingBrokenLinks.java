package com.BrokenLinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingBrokenLinks {

	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://deadlinkcity.com/");
		driver.manage().window().maximize();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("The No of links are :"+links.size());
		
		int noOfBrokenLinks = 0;
		for(WebElement linkElement: links)
		{
			String hrefattValue = linkElement.getAttribute("href");
			
			if(hrefattValue == null || hrefattValue.isEmpty())
			{
				System.out.println("href attribute value is null or empty, So not possible to check");
				continue;
			}
			
			try {
				URL linkURL = new URL(hrefattValue);  //Converting link from string to URL, we cannot send request using string url
				HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection(); //Open connection to server
				conn.connect(); //Connect to server and sent request to server.
				
				if(conn.getResponseCode()>=400)
				{
					System.out.println(hrefattValue + "=====> BrokenLink");
					noOfBrokenLinks++;
				}
				else
				{
					System.out.println(hrefattValue + "=====> Not a BrokenLink");
				}
			}
			catch(Exception e)
			{
				
			}
            
		}

		System.out.println("The No of Broken links are :"+ noOfBrokenLinks);
	}

}
