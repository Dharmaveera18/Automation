package com.DataDrivenTesting;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcelPractice {

	public static void main(String[] args) throws IOException {
		
		//Create Workbook object
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("data1");
		
		XSSFRow row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("English");
		row1.createCell(1).setCellValue(8);
		row1.createCell(2).setCellValue("Rating");
		
		XSSFRow row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue("Hindi");
		row2.createCell(1).setCellValue(4);
		row2.createCell(2).setCellValue("Rating");
		
		XSSFRow row3 = sheet.createRow(2);
		row3.createCell(0).setCellValue("Kannada");
		row3.createCell(1).setCellValue(9.5);
		row3.createCell(2).setCellValue("Rating");
		
		XSSFRow row4 = sheet.createRow(3);
		row4.createCell(0).setCellValue("Telugu");
		row4.createCell(1).setCellValue(9);
		row4.createCell(2).setCellValue("Rating");
		
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myfile1.xlsx");
	    workbook.write(file);
	
	   
	    workbook.close();
	    file.close();
	
	    System.out.println("myfile1.xlsx is created ...");
	}

}
