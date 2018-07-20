package com.qa.FreeCRM.Utilities;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Set;
import com.qa.FreeCRM.TestBase.TestBaseParent;

public class TestUtil extends TestBaseParent 
{
	
	public TestUtil() throws UnknownHostException
	{
		super();
	}
	
	
	public void SwitchToFrame()
	{
		Driver.switchTo().frame("mainpanel");
				
	}
	
	@Test
	public void VerifyBrokenLinksAndImages() throws IOException
	{
	
		
		initialization();
		List<WebElement>Link_lst=Driver.findElements(By.tagName("a"));
		Link_lst.addAll(Driver.findElements(By.tagName("img")));
		System.out.println("Total size of Links and images of this Page: "+Link_lst.size());
		System.out.println("******************************************************");
		for(int k=0;k<Link_lst.size();k++)
		{
		
			System.out.println(Link_lst.get(k).getAttribute("href"));
			
		}
		System.out.println("*******************************************");
		
	
		ArrayList<WebElement>activeLinks=new ArrayList<WebElement>();
		for(int i=0;i<Link_lst.size();i++)
		{
			if(Link_lst.get(i).getAttribute("href")!=null && (!Link_lst.get(i).getAttribute("href").contains("javascript")))
			{
				activeLinks.add(Link_lst.get(i));
				
			}
			
		}
		System.out.println("Total size of Active Links and images are: "+activeLinks.size());
		System.out.println("**********************************");
		
		for(int j=0;j<activeLinks.size();j++)
		{
			//System.out.println(activeLinks.get(j).getAttribute("href"));
			
			HttpURLConnection httpConn=(HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			httpConn.connect();
			String ResponseMessage=httpConn.getResponseMessage();
			int ResponseCode=httpConn.getResponseCode();
			httpConn.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href")+" "+ResponseCode+" "+ResponseMessage);
						
		}
			
	}
	
	public void DragAndDropMethod()
	{
		Actions action1=new Actions(Driver);
		action1.dragAndDrop(Driver.findElement(By.xpath(prop.getProperty("Drag_SrcElement_xpath"))), Driver.findElement(By.xpath(prop.getProperty("Drag_DestElement_xpath")))).build().perform();
			
	}
	public void RightClickMethod()
	{
		Actions action2=new Actions(Driver);
		action2.contextClick().perform();
	}
	
	public void DoubleClickMethod()
	{
		Actions action3=new Actions(Driver);
		action3.doubleClick().perform();
	}
	
	public void MouseMovementElementMethod()
	{
		Actions action4=new Actions(Driver);
		action4.moveToElement(Driver.findElement(By.xpath(prop.getProperty("MoveToElement_xpath")))).build().perform();
	
	}
		
	public void alertAccept()
	{
		Alert alertAcc=Driver.switchTo().alert();
		alertAcc.accept();
	}
	
	public void alertCancel()
	{
		Alert alertCan=Driver.switchTo().alert();
		alertCan.dismiss();
	}
	
	public void alertGetText()
	{
		Alert alertText=Driver.switchTo().alert();
		alertText.getText();
		
	}
	
	public void alertSendText()
	{
		Alert alertSendText=Driver.switchTo().alert();
		alertSendText.sendKeys(prop.getProperty("AlertTextEnter"));
	}
	
	
		
	
}
	
