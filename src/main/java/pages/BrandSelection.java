package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrandSelection {

	private WebDriverWait wait;
	private WebDriver driver;

	@FindBy(xpath = "//label[@for='logo1']")
	WebElement brandHc2U;

	@FindBy(xpath = "//label[@for='logo2']")
	WebElement brandPcgS;

	@FindBy(xpath = "//button[text()='Continue']")
	WebElement continueButton;

	public BrandSelection(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	public void brandMtSelect() {
	    wait.until(ExpectedConditions.elementToBeClickable(brandHc2U)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(brandPcgS)).click();
	}

	public void hc2UbrandSelect() {
	    wait.until(ExpectedConditions.elementToBeClickable(brandHc2U)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
	}

	public void pcgSbrandSelect() {
	    wait.until(ExpectedConditions.elementToBeClickable(brandPcgS)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
	}
}