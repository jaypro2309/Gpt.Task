package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.BrandSelection;
import pages.LoginPage;
import pages.Dashboard;

public class TestDashboard extends BaseTest {
	Dashboard dashboard;
	LoginPage login_test;
	BrandSelection select;
	
	@BeforeClass
	public void setupCases() {
		select = new BrandSelection(driver);
		login_test = new LoginPage(driver);
		dashboard = new Dashboard(driver);
	}
	
	@Test(priority = 1)
	public void move_to_dahboard() {
		select.hc2UbrandSelect();
		login_test.enter_email_password_correct("admin@healthcare2U.com", "Admin@Hc2U");
	}
	
	@Test(priority = 2)
	public void validateElements() {
		dashboard.validateAllDashboardElements();
	}
}