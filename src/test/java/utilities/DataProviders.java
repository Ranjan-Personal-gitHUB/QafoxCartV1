package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviders {

	// DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		
		String fileName = ".\\testData\\LoginData.xlsx";
		
		FileInputStream fis = new FileInputStream(fileName);
        @SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        XSSFRow row = sheet.getRow(0);
        int noOfRows = sheet.getPhysicalNumberOfRows();
        int noOfCols = row.getLastCellNum();
        Cell cell;
        String loginData[][] = new String[noOfRows - 1][noOfCols];

        for (int i = 1; i < noOfRows; i++) {
            for (int j = 0; j < noOfCols; j++) {
                row = sheet.getRow(i);
                cell = row.getCell(j);
                loginData[i - 1][j] = cell.getStringCellValue();
            }
        }

		return loginData;
	}
	
	// DataProvider 2
	
	// DataProvider 3
	
	
}
