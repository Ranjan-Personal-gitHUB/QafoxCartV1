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
		//String fileName = "C:\\Users\\Admin\\OneDrive\\Desktop\\LoginData.xlsx";
		
		//String fileName = "D:\\OIT\\BackendWorkspace\\QafoxCartV1\\testData\\LoginData.xlsx";
		
		String fileName = ".\\testData\\LoginData.xlsx";
		
		FileInputStream fis = new FileInputStream(fileName);
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
		
		/*
		 *
		ExcelUtility xlUtil = new ExcelUtility(path);
		int totalRows = xlUtil.getRowCount("Sheet1");
		int totalCols = xlUtil.getCellCount("Sheet1", 1);
		
		String loginData[][]=new String[totalRows][totalCols];
		
		for(int i=1;i<=totalRows;i++) // Rows start from 1 , ignore Header
		{
			for(int j=0;j<=totalCols;j++)  // Column start from 0
			{
				loginData[i-1][j]= xlUtil.getCellData("Sheet1", i, j);
			}			
		}
		*/

		return loginData;
	}
	
	// DataProvider 2
	
	// DataProvider 3
	
	
}
