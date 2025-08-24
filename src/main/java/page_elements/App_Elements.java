package page_elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class App_Elements {
	
	//brand selection page elements.
	@FindBy(xpath = "//label[@for='logo1']")
	public WebElement brandHc2U;

	@FindBy(xpath = "//label[@for='logo2']")
	public WebElement brandPcgS;

	@FindBy(xpath = "//button[text()='Continue']")
	public WebElement continueButton;
	

	// this are the elements of the Login page.
	
	@FindBy(xpath = "//input[@placeholder='Enter your email']")
	public WebElement email;

	@FindBy(xpath = "//div[text()='Please enter email address']")
	public WebElement email_validation;

	@FindBy(xpath = "//input[@placeholder='Enter your password']")
	public WebElement password;

	@FindBy(xpath = "//div[text()='Please enter password']")
	public WebElement password_validation;

	@FindBy(xpath = "//button[normalize-space(text())='Login']")
	public WebElement loginbutton;

	@FindBy(xpath = "//button[text()='Add']")
	public WebElement brand_Products;
	
	@FindBy(xpath = "//div[@class='ant-message-notice-content']")
	public WebElement invalid_credentails;
	
	@FindBy(className = "ant-message-notice-content")
	public WebElement invalid_password;
	
	@FindBy(xpath = "//span[text()='Admin not found with provided email']")
	public WebElement invalid_email;
	
	
	//this are the elements of the Dashboard page.
	@FindBy(xpath = "//button[text()='Add']") 
	public WebElement  Add_Products;
	
	@FindBy(xpath = "//span[text()='Products']")
	public WebElement Products_at_Menu;
	
	@FindBy(xpath = "//span[text()='Users']")
	public WebElement Users_at_Menu;
	
	@FindBy(xpath = "//span[text()='Groups']")
	public WebElement Groups_at_Menu;
	
	@FindBy(xpath = "//span[text()='Notifications']")
	public WebElement Notifications_at_Menu;
	
	@FindBy(xpath = "//span[text()='Email Template']")
	public WebElement EmailTemplate_at_Menu;
	
	@FindBy(xpath = "//span[text()='Logout']")
	public WebElement Logout_at_Menu;
	
	@FindBy(xpath = "//button[@data-toggle='button']")
	public WebElement Change_Brnad_button;
}
