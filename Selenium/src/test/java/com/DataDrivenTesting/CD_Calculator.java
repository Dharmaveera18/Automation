package com.DataDrivenTesting;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utilities.ExcelUtils;

public class CD_Calculator {

	public static void main(String[] args) throws IOException, InterruptedException {

		// Lanch Browser
		WebDriver driver = new ChromeDriver();
		// ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		driver.manage().window().maximize();

		// Store xl file path in variable
		String filepath = System.getProperty("user.dir") + "\\testdata\\CDcaldata.xlsx";

		// Get row count
		int rows = ExcelUtils.getRowCount(filepath, "Sheet1");

		for (int i = 1; i <= rows; i++) {

            //read data from excel sheet
			String IniDepAmt = ExcelUtils.getCellData(filepath, "Sheet1", i, 0);
			String length = ExcelUtils.getCellData(filepath, "Sheet1", i, 1);
			String interestrate = ExcelUtils.getCellData(filepath, "Sheet1", i, 2);
			String compounding = ExcelUtils.getCellData(filepath, "Sheet1", i, 3);
			String Exp_Total = ExcelUtils.getCellData(filepath, "Sheet1", i, 4);

			//String Exp_Result = ExcelUtils.getCellData(filepath, "Sheet1", i, 5);

			// Clear the text field data and enter the data
			
			//WebElements
			/*
			Thread.sleep(5000);
			WebElement InDepAmt = driver.findElement(By.xpath("//div[@class='mat-form-field-infix ng-tns-c102-0']"));
			WebElement lent = driver.findElement(By.xpath("//div[@class='mat-form-field-infix ng-tns-c102-1']"));
			WebElement RateOfInterest = driver
					.findElement(By.xpath("//div[@class='mat-form-field-infix ng-tns-c102-2']"));
			WebElement compound = driver.findElement(By.xpath("//mat-select[@id='mat-select-0']"));
			
			*/
			  Actions action1 = new Actions(driver);

			
			  Thread.sleep(3000);
			  WebElement InDepAmt =  driver.findElement(By.xpath("//input[@id='mat-input-0']"));
		      action1.moveToElement(InDepAmt).click().perform();
		      driver.findElement(By.xpath("//input[@id='mat-input-0']")).clear();
		      System.out.println("Clicked");
		      
		      JavascriptExecutor js = (JavascriptExecutor) driver;
		      js.executeScript("arguments[0].value = arguments[1];", InDepAmt, IniDepAmt);
		      
		      
		      
		      
		      Thread.sleep(3000);
			  WebElement lent =  driver.findElement(By.xpath("//input[@id='mat-input-1']"));
		      action1.moveToElement(lent).click().perform();
		      driver.findElement(By.xpath("//input[@id='mat-input-1']")).clear();
		      System.out.println("Clicked");
		      
		      
		      js.executeScript("arguments[0].value = arguments[1];", lent, length);
		      Thread.sleep(3000);
		      //System.out.println(driver.findElement(By.xpath("//input[@id='mat-input-0']")).getText());  
			
		      
		      
		      Thread.sleep(3000);
			  WebElement RateOfInterest =  driver.findElement(By.xpath("//input[@id='mat-input-2']"));
		      action1.moveToElement(RateOfInterest).click().perform();
		      driver.findElement(By.xpath("//input[@id='mat-input-2']")).clear();
		      System.out.println("Clicked");
		      
		     
		      js.executeScript("arguments[0].value = arguments[1];", RateOfInterest, interestrate);
		      Thread.sleep(3000);
		      
		      WebElement compound = driver.findElement(By.xpath("//mat-select[@id='mat-select-0']"));
		      action1.moveToElement(compound).click().perform();
		      
		      List<WebElement> options = driver.findElements(By.xpath("//div[@id='mat-select-0-panel']//span"));

				System.out.println("No of options are :" + options.size());

				// capturing options

				for (WebElement op : options) {
					//System.out.println(op.getText());
					if (op.getText().equals(compounding)) {
						 action1.moveToElement(op).click().perform();
					}
				}
				
				driver.navigate().refresh();
				//WebElement button = driver.findElement(By.xpath("//button[@id='CIT-chart-submit']//div[@class='mdc-button__ripple']"));
				//action1.moveToElement(button).click().perform();
				try
				{
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='mdc-button__ripple'])[8]")));
				//WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='mdc-button__ripple'])[8]")));
				// Perform actions on the element
				
				js.executeScript("arguments[0].click();", button);
				
				//button.click();
				}
				catch(StaleElementReferenceException e)
				{
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				    WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='mdc-button__ripple'])[8]")));
					//WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='mdc-button__ripple'])[8]")));
					// Perform actions on the element
					
					js.executeScript("arguments[0].click();", button);
					
				}
				
				Thread.sleep(3000);
				String act_Total = driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
				System.out.println(act_Total);
				if(Exp_Total.equals(act_Total))
				{
					System.out.println("Test Passed");
					ExcelUtils.setCellData(filepath, "Sheet1", i, 6, "Passed");
					ExcelUtils.fillGreenColor(filepath, "Sheet1", i, 6);
				
				
				}
				else
				{
					System.out.println("Test Failed");
					ExcelUtils.setCellData(filepath, "Sheet1", i, 6, "Failed");
					ExcelUtils.fillRedColor(filepath, "Sheet1", i, 6);
				}
				
				
				
			
			/*
			System.out.println("Cleared");

			lent.click();
			driver.findElement(By.xpath("//input[@id='mat-input-1']")).clear();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(length);
			
			
			RateOfInterest.click();
			driver.findElement(By.xpath("//input[@id='mat-input-2']")).clear();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='mat-input-2']")).sendKeys(interestrate);
			
			
			

			//driver.findElement(By.xpath("//mat-select[@id='mat-select-0']")).click();
			compound.click();
			List<WebElement> options = driver.findElements(By.xpath("//div[@id='mat-select-0-panel']//span"));

			System.out.println("No of options are :" + options.size());

			// capturing options

			for (WebElement op : options) {
				//System.out.println(op.getText());
				if (op.getText().equals(compounding)) {
					op.click();
				}
			}
			
			
			driver.findElement(By.xpath("//button[@id='CIT-chart-submit']//div[@class='mdc-button__ripple']")).click();

			Thread.sleep(3000);
			String act_Total = driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
			
			if(Exp_Total.equals(act_Total))
			{
				System.out.println("Test Passed");
				ExcelUtils.setCellData(filepath, "Sheet1", i, 6, "Passed");
				ExcelUtils.fillGreenColor(filepath, "Sheet1", i, 6);
			
			
			}
			else
			{
				System.out.println("Test Failed");
				ExcelUtils.setCellData(filepath, "Sheet1", i, 6, "Failed");
				ExcelUtils.fillRedColor(filepath, "Sheet1", i, 6);
			}*/
		}

	}

}
