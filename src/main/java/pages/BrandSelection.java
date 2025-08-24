package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page_elements.App_Elements;

public class BrandSelection extends App_Elements {

	private WebDriverWait wait;
	private WebDriver driver;

	public BrandSelection(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	public void brandMtSelect() {
		for(int i=0 ; i<=2; i++){
	    wait.until(ExpectedConditions.elementToBeClickable(brandHc2U)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(brandPcgS)).click();
		}
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