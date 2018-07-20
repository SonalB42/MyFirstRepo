package com.qa.FreeCRM.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.UnknownHostException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBaseParent 
{

	public static Properties prop;
	public static WebDriver Driver;
	
	public TestBaseParent()
	{
		try {
		prop=new Properties();
		FileInputStream fil=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\FreeCRM_Project\\ObjectRepository\\Config.properties");
		prop.load(fil);	
		
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() throws IOException	
	{
		
		String PgloadTimeOut=prop.getProperty("pageloadTimeOut");
		String PgImplicitlyWait=prop.getProperty("pageImplicityWait");
		String BrowseName=prop.getProperty("browser");
		String Url=prop.getProperty("url");
		
		/*System.out.println("Page Load timeOut is:"+PgloadTimeOut);
		System.out.println("Implicit wait is: "+PgImplicitlyWait);
		System.out.println("Browser name details is: "+BrowseName);
		System.out.println("Application url is :"+Url);
		*/
		
		if(BrowseName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\FreeCRM_Project\\BrowsersExe\\chromedriver.exe");
			Driver=new ChromeDriver();
		}
		else if(BrowseName.equals("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\eclipse-workspace\\FreeCRM_Project\\BrowsersExe\\geckodriver.exe");
			Driver= new FirefoxDriver();
			
		}
		else if(BrowseName.equals("InternetExplorer"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\user\\eclipse-workspace\\FreeCRM_Project\\BrowsersExe\\IEDriverServer.exe");
			Driver=new InternetExplorerDriver();
			
		}
		else if(BrowseName.equals("HtmlUnit"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\FreeCRM_Project\\BrowsersExe\\chromedriver.exe");
			Driver=new HtmlUnitDriver();
			
		}
		
		Driver.manage().deleteAllCookies();
		Driver.manage().window().maximize();
		Driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(PgloadTimeOut), TimeUnit.SECONDS);
		Driver.manage().timeouts().implicitlyWait(Integer.parseInt(PgImplicitlyWait), TimeUnit.SECONDS);
		
		Driver.get(Url);
		
		
	}
	
}
