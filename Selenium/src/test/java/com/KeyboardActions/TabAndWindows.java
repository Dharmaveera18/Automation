package com.KeyboardActions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabAndWindows {

	public static void main(String[] args) {

		// Launch Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/");
		//driver.manage().window().maximize();
		
		//driver.switchTo().newWindow(WindowType.TAB);//Opens new Tab
		driver.switchTo().newWindow(WindowType.WINDOW);//Opens new browser window
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

}
