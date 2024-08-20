package com.fileupload;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException {


		WebDriver driver = new ChromeDriver();
		//ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		//Single file upload
		/*driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("C:\\Users\\User\\Desktop\\Dharma\\fileUpload.txt");
		Thread.sleep(5000);
		//System.out.println(driver.findElement(By.xpath("//input[@id='filesToUpload']")).getText());
       
		
		WebElement choosefile = driver.findElement(By.xpath("//ul[@id='fileList']//li"));
		if(choosefile.getText().equals("fileUpload.txt"))
		{
			System.out.println("File uploaded successfully");
		}
		else
		{
			System.out.println("File not uploaded");
		}
	
		*/
		
		
	
		//Multiple file upload
		
		String file1 ="C:\\Users\\User\\Desktop\\Dharma\\fileUpload.txt";
		String file2 ="C:\\Users\\User\\Desktop\\Dharma\\introd.txt";
		
		
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+"\n"+file2);
	
		int noOfFilesUploaded = driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
	
		//Validation 1 - by count
		if(noOfFilesUploaded == 2)
		{
			System.out.println("All files are uploaded");
		}
		else
		{
			System.out.println("Files are not uploaded");
		}
	
		
		//Validation 2 - by text
		
		if(driver.findElement(By.xpath("//ul[@id='fileList']//li[1]")).getText().equals("fileUpload.txt") && driver.findElement(By.xpath("//ul[@id='fileList']//li[2]")).getText().equals("introd.txt"))
		{
			System.out.println("File names are matching");
		}
		else
		{
			System.out.println("File names are not matching ....");
		}
	}
	
	

}
