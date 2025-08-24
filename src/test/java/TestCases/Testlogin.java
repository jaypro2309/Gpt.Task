package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.BrandSelection;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class Testlogin extends BaseTest {
	LoginPage login_test;
	BrandSelection select;
	
	@BeforeClass
	public void setupLoginCases() {
		select = new BrandSelection(driver);
		login_test = new LoginPage(driver);
		Log.info("Starting login Test..");
		test = ExtentReportManager.createTest("Login Test");
	}

	@Test(priority = 1)
	public void login_case_1() {
		select.hc2UbrandSelect();
		System.out.println("test stops hear");
		login_test.check_validation();
		System.out.println("test stops hear too");
		test.pass("validation are displayed.");
	}

	@Test(priority = 2)
	public void login_case_2() {
		login_test.enter_email_only("jay@yopmail.com");
		test.pass("email address wrong.");
	}

	@Test(priority = 3)
	public void login_case_3() {
		login_test.enter_password_only("123123123");
		test.pass("email address wrong.");
	}
	
	@Test(priority = 4)
	public void login_case_4() {
		login_test.enter_emailpassword_wrong("jay@yopmail.com","123123123");
		test.pass("email and password both are wrong.");
	}
	
	@Test(priority = 5)
	public void login_case_5() {
		login_test.enter_email_correct_password_wrong("admin@healthcare2U.com", "123123123");
		test.pass("password wrong.");
	}
	
	@Test(priority = 6)
	public void login_case_6() {
		login_test.enter_email_wrong_password_correct("jay.p@yopmail.com", "admin@heal");
		test.pass("email address wrong.");
	}

	@Test(priority = 7)
	public void login_case_7() {
		login_test.enter_email_password_correct("admin@healthcare2U.com", "Admin@Hc2U");
		test.pass("Login successfully.");
	}

	@Test(priority = 8)
	public void redirection_dashboard() throws InterruptedException {
		login_test.checkLogin();
	}
}
