package com.DataDrivenTesting;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoSpecificRowandCell {

	public static void main(String[] args) throws IOException {


        XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("data1");
		
		
		
		
		
		XSSFRow row4 = sheet.createRow(3);
		row4.createCell(5).setCellValue("Telugu");
		
		
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myfile2.xlsx");
	    workbook.write(file);
	
	   
	    workbook.close();
	    file.close();
	
	    System.out.println("myfile2.xlsx is created ...");
		
		
		
		

	}

}
