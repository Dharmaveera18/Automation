package testNg_Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener
{
	public ExtentSparkReporter sparkReporter; //UI of the report
	public ExtentReports extent; //populate common info on the report
	public ExtentTest test; //creating test acse entries in the report and update thestatus of the test methods
	
	public void onStart(ITestContext context)
	{
		System.out.println("Test execustion started ...");
		
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReport.html");
	    
		sparkReporter.config().setDocumentTitle("Automation Report"); //Title of the Report
		sparkReporter.config().setReportName("Functional Testing"); // Name of the Report
		sparkReporter.config().setTheme(Theme.DARK);
	
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Compter Name", "localHost");
		extent.setSystemInfo("EnvironMent", "QA");
		extent.setSystemInfo("Tester NAme", "Dharma");
		extent.setSystemInfo("os", "Windows10");
		extent.setSystemInfo("Browser Name", "chrome");
		
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("test started ...");
	  }
	
	public void onTestSuccess(ITestResult result)
	{  
		System.out.println("test passed ...");
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test Case PASSED is :" + result.getName());
	
	}
	
	
	public void onTestFailure(ITestResult result)
	{
		System.out.println("test failed ...");
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Case FAILED is :" + result.getName());
		test.log(Status.FAIL, "Test Case FAILED cause is :" + result.getThrowable());
	
	}
	
	
	public void onTestSkipped(ITestResult result)
	{  
		System.out.println("test skipped ...");
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Case SKIPPED is :" + result.getName());
	}
	
	public void onFinish(ITestContext context)
	{  
		System.out.println("Test execution completed ...");
		extent.flush();
	}

}
