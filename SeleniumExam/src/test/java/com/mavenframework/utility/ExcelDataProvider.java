package com.mavenframework.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	 static XSSFWorkbook wb;
	static XSSFCell  Cell;
	 static XSSFRow  Row;
	public ExcelDataProvider() {

		File src = new File("./TestData/TestData.xlsx");

		try {

			FileInputStream fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);
		}

		catch (Exception e) {
			System.out.println("Unable to read Excel File " + e.getMessage());
		}

	} 

	
	  public String GetStringData(int SheetIndex, int row, int column) {
	  
	  return wb.getSheetAt(SheetIndex).getRow(row).getCell(column).getStringCellValue();
	  
	  }
	 

	  public  String setCellsData(String SheetName, int row, int column) {
		  
		  try {
			 
			  Cell = wb.getSheet(SheetName).getRow(row).getCell(column);

    			String CellData = Cell.getStringCellValue();

    			return CellData;
		  }
		  catch(Exception e) {
			  
			  return "";
		  }
	  }
	  
		
		  public String GetStringDataName(String SheetName, int row, int column) {
		  
		  return wb.getSheet(SheetName).getRow(row).getCell(row).getStringCellValue();
		  
		  }
		 
	public XSSFCell GetNumericData(String SheetName, int row, int column) {

		return wb.getSheet(SheetName).getRow(row).getCell(column);

	}

}
