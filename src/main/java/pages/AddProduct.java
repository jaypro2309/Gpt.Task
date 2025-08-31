package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page_elements.App_Elements;

public class AddProduct extends App_Elements {
	private WebDriverWait wait;
	private WebDriver driver;

	public AddProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void add_product(String pname, String pcode) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(Add_Products)).click();
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOf(Save_button));
		System.out.println("Adding product: " + pname + " with code: " + pcode);
		Product_Name.sendKeys(pname);
		Product_Code.sendKeys(pcode);
		Save_button.click();
	}

}
