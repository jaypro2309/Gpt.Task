package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static Workbook workbook;
	private static Sheet sheet;

//	public static void setExcelFile(String path, String sheetName) throws IOException {
//		FileInputStream file = new FileInputStream(path);
//		workbook = new XSSFWorkbook(file);
//		sheet = workbook.getSheet(sheetName);
//	}
//
//	public static String getCellData(int row, int col) {
//		Cell cell = sheet.getRow(row).getCell(col);
//		if (cell.getCellType() == CellType.STRING) {
//			return cell.getStringCellValue();
//		} else if (cell.getCellType() == CellType.NUMERIC) {
//			return String.valueOf((int) cell.getNumericCellValue());
//		} else {
//			return "";
//		}
//
//	}
//
//	public static int getRowCount() {
//		return sheet.getPhysicalNumberOfRows();
//
//	}
//
//	public static void closeExcel() throws IOException {
//		workbook.close();
//	}

//	public static void main(String[] args) throws IOException {
//		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\ProductData.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(file);
//		XSSFSheet sheet = workbook.getSheet("Sheet1");
//		
//		int totalRows = sheet.getLastRowNum();
//		int totalCols = sheet.getRow(1).getLastCellNum();
//		System.out.print("Total Rows: " + totalRows);
//		System.out.print("Total Columns: " + totalCols);
//		
//		for(int i=1; i<=totalRows; i++) {
//			XSSFRow currentRow = sheet.getRow(i);
//			
//			for(int j=0; j<totalCols; j++) {
//			XSSFCell cell = currentRow.getCell(j);
//			System.out.print(cell.toString()+ "\t");
//				
//			}
//			System.out.println();
//		}
//		workbook.close();
//		file.close();
//	}

    private static String path;

    public ExcelUtils(String excelPath, String sheetName) throws IOException {
        path = excelPath;
        FileInputStream fis = new FileInputStream(path);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
    }

    public int getRowCount() {
        return sheet.getLastRowNum();
    }

    public int getColCount() {
        return sheet.getRow(0).getLastCellNum();
    }

    public String getCellDataString(int row, int col) {
        return sheet.getRow(row).getCell(col).getStringCellValue();
    }

    public void close() throws IOException {
        workbook.close();
    }
}
