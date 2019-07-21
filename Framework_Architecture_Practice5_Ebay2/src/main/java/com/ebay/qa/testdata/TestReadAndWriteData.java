package com.ebay.qa.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ebay.qa.util.TestUtil;

public class TestReadAndWriteData extends TestUtil{
	
	public static void ReadAndWriteData(By selector) throws Exception
	{
		File src = new File("./ExcelData/Stocks.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet excelsheet = wb.getSheetAt(0);
		int rowcount = excelsheet.getLastRowNum();
		rowcount = rowcount +1;
		
		for (int i = 1; i<rowcount; i++)
		{
			String data = excelsheet.getRow(i).getCell(0).getStringCellValue();
			WebElement element = driver.findElement(selector);
			element.sendKeys(data);
			
			ClearField(selector);
		}
		wb.close();
	}
	

}
