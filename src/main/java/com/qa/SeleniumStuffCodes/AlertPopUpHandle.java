package com.qa.SeleniumStuffCodes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopUpHandle {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\FreeCRM_Project\\BrowsersExe\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.name("proceed")).click();
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		String text=alert.getText();
		if(text.equals("please enter a valid user name")) //case sensitive
		{
			System.out.println("Alert Popup text is correct");
		}
		else
		{
			System.out.println("Alert PopUp text is incorrect");
		}
		
		alert.accept();
		//alert.dismiss();
		
		
		
	}

}
