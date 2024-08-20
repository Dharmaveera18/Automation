package com.mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SlidersDemo {

	public static void main(String[] args) throws InterruptedException {

		// Launch Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/slider/");	
		//	driver.get("https://refreshless.com/nouislider/examples/#section-styling");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		Actions act = new Actions(driver);
		
		//farward
		WebElement min_Slider = driver.findElement(By.xpath("//div[@id='slider']//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
	    System.out.println("Default location of the min_Slider"+min_Slider.getLocation());//(0, 4)
	    act.dragAndDropBy(min_Slider, 200, 4).perform();
	    System.out.println("location of the min_Slider after moving"+min_Slider.getLocation());
	
	    //Thread.sleep(5000);
		// backward
		WebElement max_Slider = driver.findElement(By.xpath("//div[@id='slider']//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		System.out.println("Default location of the min_Slider" + max_Slider.getLocation());// (0, 4)
		act.dragAndDropBy(max_Slider, -100, 4).perform();
		System.out.println("location of the max_Slider after moving" + max_Slider.getLocation());

	}

}
