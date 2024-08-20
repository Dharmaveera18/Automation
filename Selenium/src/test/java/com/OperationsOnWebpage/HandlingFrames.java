package com.OperationsOnWebpage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrames {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// 1)Frame 1
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1); // Switching into frame1
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Welcome");

		driver.switchTo().defaultContent(); // Switching to page

		// 2)Frame 2
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frame2); // Switching into frame2
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Selenium");

		driver.switchTo().defaultContent();

		// 3)Frame 3
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3); // Switching into frame2
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("GoodEvening");

		// Switching to inner frame

		driver.switchTo().frame(0);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='i8']//div[@class='AB7Lab Id5V1']")).click();

		driver.switchTo().defaultContent();

		// 4)Frame 4
		WebElement frame4 = driver.findElement(By.xpath("//frame[@src='frame_4.html']"));
		driver.switchTo().frame(frame4); // Switching into frame2
		driver.findElement(By.xpath("//input[@name='mytext4']")).sendKeys("Automation");
		
		driver.switchTo().defaultContent();
		
		// 5)Frame 5
		WebElement frame5 = driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		driver.switchTo().frame(frame5); // Switching into frame2
		driver.findElement(By.xpath("//input[@name='mytext5']")).sendKeys("WebAutomation");
		
		driver.findElement(By.xpath("//a[text()='https://a9t9.com']")).click(); //click on the link to go inside the inner frrame
		Thread.sleep(5000);
		WebElement frame6 = driver.findElement(By.xpath("//html[@class=' js flexbox flexboxlegacy canvas canvastext webgl no-touch geolocation postmessage no-websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers no-applicationcache svg inlinesvg smil svgclippaths']"));
		driver.switchTo().frame(frame6);
		
		WebElement frame6logo = driver.findElement(By.xpath("//a[@class='get-button']"));
		System.out.println(frame6logo.isDisplayed());
	}

}
