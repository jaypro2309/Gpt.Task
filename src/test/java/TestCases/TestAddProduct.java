package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AddProduct;
import pages.BrandSelection;
import pages.Dashboard;
import pages.LoginPage;
import utils.DataProviders;

public class TestAddProduct extends BaseTest {
	BrandSelection select;
	LoginPage login_test;
	Dashboard dashboard;
	AddProduct addproduct;
	

	@BeforeClass
	public void setupCases() {
		select = new BrandSelection(driver);
		login_test = new LoginPage(driver);
		dashboard = new Dashboard(driver);
		addproduct = new AddProduct(driver);
		
	}

	@Test(priority = 1)
	public void move_to_dahboard() {
		select.hc2UbrandSelect();
		login_test.enter_email_password_correct("admin@healthcare2U.com", "Admin@Hc2U");
		test.pass("Login successfully.");
}
	@Test(priority = 2, dataProvider = "ProductData", dataProviderClass = DataProviders.class)
	public void add_product(String pname, String pcode ) throws InterruptedException {
		dashboard.validateAllDashboardElements();
		addproduct.add_product(pname , pcode);
		test.pass("Product added successfully." + pname + " with code: " + pcode);
	}
}
