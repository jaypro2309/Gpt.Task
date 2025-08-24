package pages;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page_elements.App_Elements;

public class Dashboard extends App_Elements {
	private WebDriverWait wait;
	private WebDriver driver;
	// Initialize WebDriver and WebDriverWait
	
	public Dashboard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void validateAllDashboardElements() {
		
        // Add all dashboard elements here
        List<WebElement> dashboardElements = Arrays.asList(
                Add_Products,
                Products_at_Menu,
                Users_at_Menu,
                Groups_at_Menu,
                Notifications_at_Menu,
                EmailTemplate_at_Menu,
                Logout_at_Menu,
                Change_Brnad_button
        );

        for (WebElement element : dashboardElements) {
            try {
                wait.until(ExpectedConditions.visibilityOf(element));
                System.out.println("✅ Element displayed: " + element);
            } catch (Exception e) {
                System.out.println("❌ Element NOT displayed: " + element);
            }
        }
    }
}
