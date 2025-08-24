package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import page_elements.App_Elements;

public class LoginPage extends App_Elements {

	private WebDriverWait wait;
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void check_validation() {
		driver.navigate().refresh();
		System.out.println("bingo.");
		wait.until(ExpectedConditions.elementToBeClickable(loginbutton)).click();

		boolean validationsVisible = email_validation.isDisplayed() && password_validation.isDisplayed();

		// Test will fail if validations are visible
		Assert.assertFalse(validationsVisible, "❌ Email and password validation messages are visible!");
	}

	public void enter_email_only(String user_email) {
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOf(email));
		email.clear();
		password.clear();
		email.sendKeys(user_email);
		loginbutton.click();
		wait.until(ExpectedConditions.visibilityOf(password_validation));
		if (password_validation.isDisplayed()) {
			System.out.println("password_validation is displayed.");
		} else {
			System.out.println("password_validation isn't displayed.");
		}

	}

	public void enter_password_only(String user_password) {
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOf(password));
		password.clear();
		password.sendKeys(user_password);
		loginbutton.click();
		wait.until(ExpectedConditions.visibilityOf(email_validation));
		if (email_validation.isDisplayed()) {
			System.out.println("email_validation is displayed.");
		} else {
			System.out.println("email_validation isn't displayed.");
		}

	}

	public void enter_emailpassword_wrong(String user_email, String user_password) {
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOf(email));
		email.clear();
		email.sendKeys(user_email);
		password.clear();
		password.sendKeys(user_password);
		loginbutton.click();
		wait.until(ExpectedConditions.visibilityOf(invalid_credentails));
		if (invalid_credentails.isDisplayed()) {
			System.out.println("email and password validation alert is visible.");
		} else {
			System.out.println("email and password validation is NOT visible");
		}
	}

	public void enter_email_wrong_password_correct(String user_email, String user_password) {
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOf(email));
		email.clear();
		email.sendKeys(user_email);
		password.clear();
		password.sendKeys(user_password);
		loginbutton.click();
		wait.until(ExpectedConditions.visibilityOf(invalid_email));
		if (invalid_email.isDisplayed()) {
			System.out.println("email validation is visible.");
		} else {
			System.out.println("email validation is NOT visible");
		}
	}

	public void enter_email_correct_password_wrong(String user_email, String user_password) {
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOf(email));
		email.clear();
		email.sendKeys(user_email);
		password.clear();
		password.sendKeys(user_password);
		loginbutton.click();
		wait.until(ExpectedConditions.visibilityOf(invalid_password));
		if (invalid_password.isDisplayed()) {
			System.out.println("password validation is visible.");
		} else {
			System.out.println("password validation is NOT visible");
		}
	}

	public void enter_email_password_correct(String user_email, String user_password) {
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOf(email));
		email.clear();
		email.sendKeys(user_email);
		password.clear();
		password.sendKeys(user_password);
		loginbutton.click();
	}

	public void checkLogin() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(brand_Products));
		Thread.sleep(5000);
		if (brand_Products.isDisplayed()) {
			System.out.println("Login Successfully and redirected to Dashboard.");
		} else {
			System.out.println("Login Failed.");
		}
	}
}