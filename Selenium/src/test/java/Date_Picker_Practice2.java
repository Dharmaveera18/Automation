import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Date_Picker_Practice2 {

	public static void main(String[] args) {
		
		// Launch Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		
		//Switch to frame
		driver.switchTo().frame("frame-one796456169");
		
		//Method 1 :enter using sendkeys
		//driver.findElement(By.xpath("//input[@id='RESULT_TextField-2']")).sendKeys("03/03/2023");
		
		
		//Method 2: Using date picker
		driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();
		
		
		//input to DOB
		String ExpectedYear = "2027";
		String ExpectedMonth = "April";
		String Expecteddate = "15";
		
		selectdates(driver,ExpectedYear,ExpectedMonth,Expecteddate);
	
	}
	
	
	
	public static Month convertMonth(String month)
	{
		HashMap<String, Month> mapMonth = new HashMap<String, Month>();
		
		mapMonth.put("January", Month.JANUARY);
		mapMonth.put("February", Month.FEBRUARY);
		mapMonth.put("March", Month.MARCH);
		mapMonth.put("April", Month.APRIL);
		mapMonth.put("May", Month.MAY);
		mapMonth.put("June", Month.JUNE);
		mapMonth.put("July", Month.JULY);
		mapMonth.put("August", Month.AUGUST);
		mapMonth.put("September", Month.SEPTEMBER);
		mapMonth.put("October", Month.OCTOBER);
		mapMonth.put("November", Month.NOVEMBER);
		mapMonth.put("December", Month.DECEMBER);
		
		Month vmonth = mapMonth.get(month);
		
		if(vmonth == null)
		{
			System.out.println("Invalid month");
		}
		return vmonth;
	}
	
	
	
	public static void selectdates(WebDriver driver, String ExpectedYear, String ExpectedMonth, String Expecteddate)
	{
		//Select year
		
				WebElement yearDropdown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
				Select year = new Select(yearDropdown);
				year.selectByVisibleText(ExpectedYear);
				
				//Select Month
				
				while(true)
				{
					//Select month
					String Current_Month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
					
					//Convert currentmonth and expected month into month objects
					
					Month expectedMonth = convertMonth(ExpectedMonth);
					Month currentMonth = convertMonth(Current_Month);
					
					//compare months
					
					int result = expectedMonth.compareTo(currentMonth);
					
					if(result<0)
					{
						driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
					}
					else if(result>0)
					{
						driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
					}
					else
					{
						break;
					}
				}
				
				//Select date
				
				List<WebElement> AllDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));

			    for(WebElement dt:AllDates) {
			    	if(dt.getText().equals(Expecteddate)) {
			    		dt.click();
			    		break;
			    	}
			    }
			
	}

}
