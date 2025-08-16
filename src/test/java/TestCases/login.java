package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class login extends BaseTest {
	LoginPage loginPage;

	@BeforeClass
	public void setupPage() throws InterruptedException {
		Thread.sleep(7000);
		Log.info("Starting login Test..");
		loginPage = new LoginPage(driver);
		test = ExtentReportManager.createTest("Login Test");

	}

	@Test(priority = 1)
	public void login_case_1() {
		loginPage.check_validation();
		test.pass("validation are displayed.");
	}

	@Test(priority = 2)
	public void login_case_2() {
		loginPage.enter_email_only("jay@yopmail.com");
		test.pass("email address worng.");
	}

	@Test(priority = 3)
	public void login_case_3() {
		loginPage.enter_password_only("123123123");
		test.pass("email address worng.");
	}

	@Test(priority = 4)
	public void login_case_4() {
		loginPage.enter_email_correct_password_wrong("admin@healthcare2U.com", "123123123");
		test.pass("password worng.");
	}

	@Test(priority = 5)
	public void login_case_5() {
		loginPage.enter_email_wrong_password_correct("jay.p@yopmail.com", "admin@heal");
		test.pass("email address worng.");
	}

	@Test(priority = 6)
	public void login_case_6() {
		loginPage.enter_email_password_correct("admin@healthcare2U.com", "Admin@Hc2U");
		test.pass("Login successfully.");
	}

	@Test(priority = 7)
	public void redirection_dashboard() {
		loginPage.checkLogin();
	}
}
