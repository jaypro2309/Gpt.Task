package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
    private WebDriverWait wait;
	private WebDriver driver;
	private By usernameTextBox = By.id("username");
	private By passwordTextBox = By.id("password");
	private By loginButton = By.id("submit");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void enterUsername(String username) {
		driver.findElement(usernameTextBox).clear();
		driver.findElement(usernameTextBox).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordTextBox).clear();
		driver.findElement(passwordTextBox).sendKeys(password);	
	}
	
	public void submitButton() {
		driver.findElement(loginButton).click();
		wait.until(ExpectedConditions.titleContains("Logged In Successfully | Practice Test Automation"));
	}
}
