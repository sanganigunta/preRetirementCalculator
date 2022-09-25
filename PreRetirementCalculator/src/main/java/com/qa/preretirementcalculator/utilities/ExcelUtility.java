package com.qa.preretirementcalculator.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	private static Workbook book; 
	private static Sheet sheet;
	private static String EXCELUTIL_TEST_DAT_PATH =".\\src\\resources\\test\\ExcelUtility\\Savings.xlsx";
	
	
	
	public static Object[][] getExcelSheetData(String sheetName) {
		Object data[][] = null;
	try {
		
	FileInputStream ip = new FileInputStream(EXCELUTIL_TEST_DAT_PATH);
	book= WorkbookFactory.create(ip);
	sheet = book.getSheet(sheetName);
	data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
	for(int i=0;i<sheet.getLastRowNum();i++)
	{
		for(int j=0;j<sheet.getRow(i).getLastCellNum();j++)
		{
			data[i][j] = sheet.getRow(i+1).getCell(j).toString();
		}
	}
	
	}
	 catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (InvalidFormatException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return data;
	
	}
}
