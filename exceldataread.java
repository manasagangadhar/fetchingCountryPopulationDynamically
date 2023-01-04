package com.datadriven.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class exceldataread {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream file = new FileInputStream("C:\\Users\\manas\\eclipse-workspace\\DataDrivenProject\\src\\com\\testdata\\Book1.xlsx");
		XSSFWorkbook workboox = new XSSFWorkbook(file);
		XSSFSheet sheet = workboox.getSheet("Sheet1");
		int rowcount = sheet.getLastRowNum(); //returns row count
		int colcount  = sheet.getRow(0).getLastCellNum(); //returns col/cell count
		
		for(int i=0;i<rowcount;i++)
		{
			XSSFRow currentrow = sheet.getRow(i);//focused on current row
			
			for(int j=0;j<colcount;j++) {
	
				String value = currentrow.getCell(j).toString(); //read the value from the cell
				System.out.print(" " + value);
			}
			System.out.println();
			
		}
	}

}
