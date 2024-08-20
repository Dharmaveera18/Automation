package com.OperationsOnWebpage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pagination_Table_Practice {

	public static void main(String[] args) {

		// Launch Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		// Find Total no of pages
		int totalNoPages = driver.findElements(By.xpath("//ul[@class='pagination']//li")).size();
		System.out.println("Total no of Pages:" + totalNoPages);

		for (int p = 1; p <= totalNoPages; p++)
		{
			if (p > 1)
			{
				driver.findElement(By.xpath("//ul[@class='pagination']//li//*[text()=" + p + "]")).click();
			}

			// reading data

			int totalNoRows = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();
			// System.out.println("Total no of rows"+totalNoRows);

			for (int r = 1; r <= totalNoRows; r++)
			{
				String Sl_No = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr[" + r + "]//td[1]"))
						.getText();
				String ProdactName = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr[" + r + "]//td[2]")).getText();
				String Price = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr[" + r + "]//td[3]"))
						.getText();
				driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr[" + r + "]//td[4]//input")).click();

				System.out.println(Sl_No + "\t\t" + ProdactName + "\t\t" + Price);
			}
		}
	}

}
