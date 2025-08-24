package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentReportManager;
import utils.Log;

public class BaseTest {
	protected static WebDriver driver;
	protected static ExtentReports extent;
	protected ExtentTest test;

	@BeforeSuite

	public void setUp() {
		Log.info("Starting webdriver.");
		if (driver == null) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			Log.info("Nevagating to URL.");
			driver.get("https://healthcare2u-refactor.theintellify.net");
			extent = ExtentReportManager.getReportInstance();
		}
	}

	@AfterSuite
	public void tearDown(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = ExtentReportManager.caputureScreenshot(driver, result.getName());
			System.out.println("screenshotPath: "+screenshotPath);
			try {
				test.fail("Test Failed", 
						com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			

		if (driver != null) {
			Log.info("Closing Browser.");
			driver.quit();
			driver = null;
		}
		if (extent != null) {
			extent.flush();
		}
	

	}
}