package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriverWait wait;
	private WebDriver driver;

	@FindBy(xpath = "//input[@placeholder='Enter your email']")
	WebElement email;

	@FindBy(xpath = "//div[text()='Please enter email address']")
	WebElement email_validation;

	@FindBy(xpath = "//input[@placeholder='Enter your password']")
	WebElement password;

	@FindBy(xpath = "//div[text()='Please enter password']")
	WebElement password_validation;

	@FindBy(xpath = "//button[normalize-space(text())='Login']")
	WebElement loginbutton;

	@FindBy(xpath = "//button[text()='Add']")
	WebElement brand_Products;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void check_validation() {
			driver.navigate().refresh();
			System.out.println("bingo.");
			wait.until(ExpectedConditions.elementToBeClickable(loginbutton)).click();
			
			if (email_validation.isDisplayed() && password_validation.isDisplayed()) {
				System.out.println("email and password validation is visible.");
			} else {
				System.out.println("email and password validation is NOT visible");
			}
	}

	public void enter_email_only(String user_email) {
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOf(email));
		email.clear();
		password.clear();
		email.sendKeys(user_email);
		loginbutton.click();
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
		if (email_validation.isDisplayed() & password_validation.isDisplayed()) {
			System.out.println("email and password validation is visible.");
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
		if (email_validation.isDisplayed()) {
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
		if (password_validation.isDisplayed()) {
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
		if (email_validation.isDisplayed() & password_validation.isDisplayed()) {
			System.out.println("email and password validation is visible.");
		} else {
			System.out.println("email and password validation is NOT visible");
		}
	}

	public void checkLogin() {
		wait.until(ExpectedConditions.visibilityOf(brand_Products));
	}
}