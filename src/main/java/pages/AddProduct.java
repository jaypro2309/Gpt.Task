package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import page_elements.App_Elements;
import utils.ExcelUtils;

public class AddProduct extends App_Elements {
	private WebDriverWait wait;
	private WebDriver driver;
	
	@DataProvider(name = "productdata")
	public Object[][] getproductData() throws IOException {
		String path = System.getProperty("user.dir") + "/TestData/ProductData.xlsx";
		ExcelUtils.setExcelFile(path, "Sheet1");
		int rowcount = ExcelUtils.getRowCount();
		Object[][] productdata = new Object[rowcount - 1][2];
		for (int i = 1; i < rowcount; i++) {

			productdata[i - 1][0] = ExcelUtils.getCellData(i, 0); //product name

			productdata[i - 1][1] = ExcelUtils.getCellData(i, 1); //product code	
		}
		ExcelUtils.closeExcel();
		return productdata;
	}
	
	public AddProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void add_product(String pname, String pcode) {
		wait.until(ExpectedConditions.elementToBeClickable(Add_Products));
		Add_Products.click();
		wait.until(ExpectedConditions.visibilityOf(Save_button));
		Product_Name.sendKeys(pname);
		Product_Code.sendKeys(pcode);
		Save_button.click();
	}

}
