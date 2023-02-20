package com.hrmProject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldata {
	
	
	
	public static String getData(int i,int j) throws IOException
	{
		
		File file = new File("/Users/amitparate/Desktop/Second Workspace/Admin_Project_123/excelsheet/For_testing.xlsx");;
		
		FileInputStream inputstream = new FileInputStream(file);
		
		
		XSSFWorkbook wb = new XSSFWorkbook(inputstream);
				
		XSSFSheet sheet =  wb.getSheet("Sheet1");
		
		XSSFRow row =  sheet.getRow(i);
		
		XSSFCell column =  row.getCell(j);
		
		String data = column.getStringCellValue();
		
		return data;	
	}

}
