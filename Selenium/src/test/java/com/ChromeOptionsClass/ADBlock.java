package com.ChromeOptionsClass;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ADBlock {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		File file = new File("C:\\Automation\\Crx files\\uBlock-Origin-Chrome-Web-Store.crx");
		
		//file path copied from 
		//1.right click on the seletorshub plugin on chromewebstore
		//then copy the crx file
		//paste 
		options.addExtensions(file);
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.geoguessr.com/vgp/3006");
		driver.manage().window().maximize();

	}

}
