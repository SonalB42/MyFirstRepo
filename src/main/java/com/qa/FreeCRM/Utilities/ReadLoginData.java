package com.qa.FreeCRM.Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadLoginData 
{

	public static Object[][] readLoginData() throws IOException
	{
		Object[][] td=null;
		FileInputStream LoginFile=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\FreeCRM_Project\\TestData\\LoginData.xlsx");
		XSSFWorkbook LoginWb= new XSSFWorkbook(LoginFile);
		XSSFSheet sh=LoginWb.getSheet("Login");
		
		int RowCount1=sh.getPhysicalNumberOfRows();
		int ColCount1=sh.getRow(0).getPhysicalNumberOfCells();
		
		XSSFCell cl1=null;
		String CellVal1=null;
		
		String[][] TestData1=new String[RowCount1-1][ColCount1];
		
		for(int k=1;k<RowCount1;k++)
		{
			for(int l=0;l<ColCount1;l++)
			{
				cl1=sh.getRow(k).getCell(l);
				CellVal1=cl1.getStringCellValue();
				TestData1[k-1][l]=CellVal1;
				System.out.print(CellVal1);
				System.out.println(" ");
				
			}
			System.out.println("");
		}
		

		td=TestData1;
		LoginWb.close();	
		return td;
		
		
	}
	

	
	
}
