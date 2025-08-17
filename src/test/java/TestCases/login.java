package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class login extends BaseTest {
	LoginPage login_test;

	@BeforeClass
	public void setupLoginCases() {
		login_test = new LoginPage(driver);
		Log.info("Starting login Test..");
		test = ExtentReportManager.createTest("Login Test");
	}

	/*
	 * @Test(priority = 5) public void login_case_1() throws InterruptedException {
	 * System.out.println("test stops hear"); login_test.check_validation();
	 * System.out.println("test stops hear too");
	 * test.pass("validation are displayed."); }
	 */

	@Test(priority = 6)
	public void login_case_2() {
		login_test.enter_email_only("jay@yopmail.com");
		test.pass("email address worng.");
	}

	@Test(priority = 7)
	public void login_case_3() {
		login_test.enter_password_only("123123123");
		test.pass("email address worng.");
	}

	@Test(priority = 8)
	public void login_case_4() {
		login_test.enter_email_correct_password_wrong("admin@healthcare2U.com", "123123123");
		test.pass("password worng.");
	}

	@Test(priority = 9)
	public void login_case_5() {
		login_test.enter_email_wrong_password_correct("jay.p@yopmail.com", "admin@heal");
		test.pass("email address worng.");
	}

	@Test(priority = 10)
	public void login_case_6() {
		login_test.enter_email_password_correct("admin@healthcare2U.com", "Admin@Hc2U");
		test.pass("Login successfully.");
	}

	@Test(priority = 11)
	public void redirection_dashboard() {
		login_test.checkLogin();
	}
}
