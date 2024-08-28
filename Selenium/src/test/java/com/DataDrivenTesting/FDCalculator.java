package com.DataDrivenTesting;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.Utilities.ExcelUtils;

public class FDCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {


		//Lanch Browser
		WebDriver driver = new ChromeDriver();
		//ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		driver.manage().window().maximize();
		
		//Store xl file path in variable
		String filepath = System.getProperty("user.dir")+"\\testdata\\caldata.xlsx";
		
		//Get row count
		int rows = ExcelUtils.getRowCount(filepath, "Sheet1");
		
		for(int i =1; i<=rows; i++) 
		{
			//read data from excel sheet
			
			String prince = ExcelUtils.getCellData(filepath, "Sheet1", i, 0);
			String rateofinterest = ExcelUtils.getCellData(filepath, "Sheet1", i, 1);
			String per1 = ExcelUtils.getCellData(filepath, "Sheet1", i, 2);
			String per2 = ExcelUtils.getCellData(filepath, "Sheet1", i, 3);
			String fre = ExcelUtils.getCellData(filepath, "Sheet1", i, 4);
			
			String mvalue = ExcelUtils.getCellData(filepath, "Sheet1", i, 5);
			
			
			//pass above data into application
			
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(prince);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateofinterest);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(per1);
			
			Select pdrop = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			pdrop.selectByVisibleText(per2);
			
			Select fredrop = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			fredrop.selectByVisibleText(fre);
			
			driver.findElement(By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']")).click();
			
			String act_mvalue = driver.findElement(By.xpath("//span[@id='resp_matval']")).getText();
			
			//Validation
			
			//we cannot 2 string formats thats numbers inside those strings
			if(Double.parseDouble(mvalue) == Double.parseDouble(act_mvalue))
			{
				System.out.println("Test Passed");
				ExcelUtils.setCellData(filepath, "Sheet1", i, 7, "Passed");
				ExcelUtils.fillGreenColor(filepath, "Sheet1", i, 7);
			
			
			}
			else
			{
				System.out.println("Test Failed");
				ExcelUtils.setCellData(filepath, "Sheet1", i, 7, "Failed");
				ExcelUtils.fillRedColor(filepath, "Sheet1", i, 7);
			}
			Thread.sleep(3000);
			driver.findElement(By.xpath("//img[@class='PL5']")).click();
			
		}//end of for loop

		driver.close();
	}

}
