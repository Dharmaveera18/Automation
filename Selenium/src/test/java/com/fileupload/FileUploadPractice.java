package com.fileupload;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPractice {

	public static void main(String[] args) throws InterruptedException {


		
		WebDriver driver = new ChromeDriver();
		//ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		
          Thread.sleep(5000);
		
		//Single file upload
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("C:\\Users\\User\\Desktop\\Dharma\\fileUpload.txt");
		Thread.sleep(5000);
		//System.out.println(driver.findElement(By.xpath("//input[@id='filesToUpload']")).getText());
       
		String file1 = "C:\\Users\\User\\Desktop\\Dharma\\fileUpload.txt";
		String file2 = "C:\\Users\\User\\Desktop\\Dharma\\introd.txt";
		
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1 + "\n" + file2);
	}

}
