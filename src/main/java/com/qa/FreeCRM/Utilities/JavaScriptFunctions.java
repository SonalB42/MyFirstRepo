package com.qa.FreeCRM.Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptFunctions 
{

	
	//Css Color---> Javascript Function
	public static void cssColor(String color, WebDriver Driver, WebElement element)
	{
		JavascriptExecutor js=((JavascriptExecutor)Driver);
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
				
	}
	
	//Flash--> Javascript Function
	public static void flash(WebDriver Driver, WebElement element)
	{
		JavascriptExecutor js=((JavascriptExecutor)Driver);
		String BgColor=element.getCssValue("backgroundColor");
		for(int i=1;i<50;i++)
		{
			cssColor("rgb(0,300,0)", Driver, element);
			cssColor(BgColor, Driver, element);
		}
			
	}
	
	//DrawBorder--Javascript Function
	public static void DrawBorder(WebDriver Driver, WebElement element)
	{
		JavascriptExecutor js=((JavascriptExecutor)Driver);
		js.executeScript("arguments[0].style.border='5px solid red'", element);
		
	}
	
	//ScrollDown --> Javascipt Function
	public static void ScrollDown(WebDriver Driver)
	{
	
		JavascriptExecutor js=((JavascriptExecutor)Driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
	
	//scrollIntoView Function
	public static void ScrollIntoView(WebDriver Driver,WebElement element)
	{
		JavascriptExecutor js=((JavascriptExecutor)Driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
	
	public static String GetTitle(WebDriver Driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)Driver);
		String Title=js.executeScript("return document.title;").toString();
		return Title;
			
				
	}
	
	public static void ClickByJS(WebDriver Driver, WebElement element)
	{
		JavascriptExecutor js=((JavascriptExecutor)Driver);
		js.executeScript("arguments[0].click();", element);
		
	}
	
	public static void Alert(String message, WebDriver Driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)Driver);
		js.executeScript("alert('"+message+"')");
	}
	
	public static void DatePickThroughJs(WebDriver Driver, WebElement element, String DateVal)
	{
		JavascriptExecutor js=((JavascriptExecutor)Driver);
		js.executeScript("arguments[0].setAttribute('value','"+DateVal+"');", element);
		
	}
	
}
