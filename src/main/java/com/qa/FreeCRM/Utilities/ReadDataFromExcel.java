package com.qa.FreeCRM.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel 
{

	public static Object[][] ReadContactsData() throws IOException
	//public static void main(String[] args) throws IOException
	{
		Object[][] td1=null;
		
		FileInputStream fil=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\FreeCRM_Project\\TestData\\NewContacts.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fil);
		XSSFSheet sh=wb.getSheet("NewContacts");
		
		int rowCount=sh.getPhysicalNumberOfRows();
		int colCount=sh.getRow(0).getPhysicalNumberOfCells();
		
		System.out.println("Total number of row Counts: "+rowCount);
		System.out.println("Total number of column Counts: "+colCount);
		

		String TestData[][]=new String[rowCount-1][colCount];
		
		XSSFCell Cl=null;
		String CellValue=null;
		
		
		for(int i=1;i<rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				Cl=sh.getRow(i).getCell(j);
				CellValue=Cl.getStringCellValue();
				TestData[i-1][j]=CellValue;
				System.out.print(CellValue);
				System.out.println(" ");
				
			}
			System.out.println("");
		}
		
		 td1=TestData;
		 wb.close();
		 return td1;
		

	}
	
	
		


}