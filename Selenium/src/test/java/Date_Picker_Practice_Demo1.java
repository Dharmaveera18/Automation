import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Date_Picker_Practice_Demo1 {

	public static void main(String[] args) {
		
		
		// Launch Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		
		//Click on radio button
		driver.findElement(By.xpath("//input[@id='product_551']")).click();	

		
		//Enter details
		driver.findElement(By.id("travname")).sendKeys("Dharmaveera");
		driver.findElement(By.id("travlastname")).sendKeys("H");
		//Click DOB
		driver.findElement(By.id("dob")).click();
		
		//Select month
		WebElement monthDrp = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
	    Select month = new Select(monthDrp);
	    month.selectByVisibleText("Mar");
	    
	    //Select Year
	    WebElement yearDrp = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']//select[2]"));
	    Select year = new Select(yearDrp);
	    year.selectByVisibleText("2022");
	    
	    //Select date
	    
	   List<WebElement> AllDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
	    
	   for(WebElement dt:AllDates)
	   {
		   if(dt.getText().equals("15"))
		   {
			   dt.click();
			   break;
		   }
	   }
	   
	   //Select radio button
	   WebElement radiobtn =  driver.findElement(By.xpath("//input[@id='sex_1']"));
	   JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", radiobtn);
	   
	   WebElement checkbox = driver.findElement(By.xpath("//input[@id='addmorepax']"));
	   if(!(checkbox.isSelected())){
		  
		   JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		   executor1.executeScript("arguments[0].click();", checkbox);
		   //checkbox.click();
	   }
	   
	  /* WebElement dropdown1 = driver.findElement(By.id("addpaxno"));
	   JavascriptExecutor executor1 = (JavascriptExecutor)driver;
	   executor1.executeScript("arguments[0].click();", dropdown1);
	   
	   
	   
	   List<WebElement> dropsuggestion = driver.findElements(By.xpath("//ul[@id='select2-addpaxno-results']//li"));
	   for(WebElement ds:dropsuggestion)
	   {
		   System.out.println("The dropdown options are :"+ds.getText());
	   }
	   */
	   WebElement dropdown = driver.findElement(By.id("addpaxno"));
	   Select drpdown = new Select(dropdown);
	   drpdown.selectByIndex(2);
	   
	   
	   
	   
	   
	   driver.findElement(By.xpath("//span[@id='select2-addpaxno-container']")).click();
	   
	   driver.findElement(By.xpath("(//ul[@id='select2-addpaxno-results']//li)[1]")).click();
	   
	   
	   
	   
	   
	}

}
