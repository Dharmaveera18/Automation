package com.takescreenshot;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FullPage_ScreenShot {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(10));

		// 1.Capturing full pagr screenshot
		/*
		 * TakesScreenshot ts = (TakesScreenshot)driver; File Sourcefile =
		 * ts.getScreenshotAs(OutputType.FILE); //The screenshot which we are taking
		 * should be in File format. //It stores screenshot in RAM memory we dont know
		 * exactly where it stored //Thats y we have to copy that screenshot in our own
		 * location
		 * 
		 * 
		 * File targetFile = new
		 * File(System.getProperty("user.dir")+"\\Screenshots\\fullpage.png");
		 * //System.getProperty("user.dir") ==>it referes our project directory. //It
		 * defines our own location to store screenshot Sourcefile.renameTo(targetFile);
		 * //It copy the screenshot from Sourcefile location to targetfile location.
		 */

		/*
		 * //2.Capturing screenshot of specific section WebElement fetured =
		 * driver.findElement(By.
		 * xpath("//div[@class='row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-xl-4']"
		 * )); Thread.sleep(5000); File sourcefile =
		 * fetured.getScreenshotAs(OutputType.FILE); File targetfile = new
		 * File(System.getProperty("user.dir")+"\\Screenshots\\fetured.png");
		 * 
		 * sourcefile.renameTo(targetfile);
		 */

		// 3.Capturing screenshot of WebElement
		WebElement OpencartLogo = driver
				.findElement(By.xpath("//img[@title='Your Store']"));
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@title='Your Store']")));
		File sourcefile = OpencartLogo.getScreenshotAs(OutputType.FILE);
		File targetfile = new File(System.getProperty("user.dir") + "\\Screenshots\\OpencartLogo1.png");

		sourcefile.renameTo(targetfile);

	}

}
