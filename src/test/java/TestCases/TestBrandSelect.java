package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.BrandSelection;
import utils.ExtentReportManager;
import utils.Log;

public class TestBrandSelect extends BaseTest {
	BrandSelection select;
	
	@BeforeClass
	public void setupPage() {
		// initialize BrandSelection after driver is created in BaseTest
		Log.info("Starting brand selection Test..");
		select = new BrandSelection(driver);
		test = ExtentReportManager.createTest("Brand selection page opens.");
	}

	@Test(priority = 1)
	public void select_M() {
		Log.info("Start Testing..");
		test.pass("URL redirection successful.");
		select.brandMtSelect();
		test.pass("Multiple times brand select successfully.");
	}

	@Test(priority = 2)
	public void Hc2uSelect() {
		select.hc2UbrandSelect();
		driver.navigate().back();
		test.pass("Healthcare brand selected successfully.");
	}

	@Test(priority = 3)
	public void PcgsSelect() throws InterruptedException {
		select.pcgSbrandSelect();
		driver.navigate().back();
		test.pass("Primecare brand selected successfully.");
	}
}
