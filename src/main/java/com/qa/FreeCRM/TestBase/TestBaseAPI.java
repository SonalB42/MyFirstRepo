package com.qa.FreeCRM.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBaseAPI 
{
	public Properties prop;
	
	public int Resonse_Status_Code_200=200;
	public int Reponse_Status_Code_500=500;
	public int Resonse_Status_Code_400=400;
	public int Reponse_Status_Code_401=401;
	public int Reponse_Status_Code_201=201;
	
	
	
	public TestBaseAPI()
	{
		try {
		prop=new Properties();
		FileInputStream fil=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\FreeCRM_Project\\ObjectRepository\\ConfigAPI.properties");
		prop.load(fil);	
		
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
}
