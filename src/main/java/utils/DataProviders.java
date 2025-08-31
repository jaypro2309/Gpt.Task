package utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	 @DataProvider(name = "ProductData")
	    public Object[][] getProductData() throws IOException {
	        String path = System.getProperty("user.dir") + "/TestData/ProductData.xlsx";
	        ExcelUtils excel = new ExcelUtils(path, "Sheet1");

	        int rows = excel.getRowCount();
	        int cols = excel.getColCount();

	        Object[][] data = new Object[rows][cols];

	        for (int i = 1; i <= rows; i++) { // skipping header row
	            for (int j = 0; j < cols; j++) {
	                data[i - 1][j] = excel.getCellDataString(i, j);
	            }
	        }
	        excel.close();
	        return data;
	    }
}
