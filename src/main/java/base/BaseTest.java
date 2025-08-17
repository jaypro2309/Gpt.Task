package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentReportManager;
import utils.Log;

public class BaseTest {
	protected WebDriver driver;
	protected static ExtentReports extent;
	protected ExtentTest test;

	@BeforeSuite(alwaysRun = true)

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

	@AfterTest
	public void tearDown() {
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