package LoginTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class login {

	public class Login extends BaseTest{
		
		@Test
		public void tesLogin() {
			LoginPage loginPage = new LoginPage(driver);
			loginPage.enterUsername("student");
			loginPage.enterPassword("Password123");
			loginPage.submitButton();
			
			System.out.println("title:   "+ driver.getTitle());
			Assert.assertEquals(driver.getTitle(), "Logged In Successfully | Practice Test Automation");
		}
	}
}
