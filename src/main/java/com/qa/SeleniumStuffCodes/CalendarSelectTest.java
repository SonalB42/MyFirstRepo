package com.qa.SeleniumStuffCodes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalendarSelectTest {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\FreeCRM_Project\\BrowsersExe\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//for dynamic wait
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//for window maximize and deleteCookies
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.freecrm.com/");
		
		driver.findElement(By.name("username")).sendKeys("Sbarmaiya");
		driver.findElement(By.name("password")).sendKeys("Testing@123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).click(); //login button
		driver.switchTo().frame("mainpanel");
		
		String date="32-August-2019";
		String dateArr[]=date.split("-");
		String Day=dateArr[0];
		String Month=dateArr[1];
		String Year=dateArr[2];
		
		Select drpMonth=new Select(driver.findElement(By.xpath("//select[@name='slctMonth']")));
		drpMonth.selectByVisibleText(Month);
		
		Select drpYear=new Select(driver.findElement(By.xpath("//select[@name='slctYear']")));
		drpYear.selectByVisibleText(Year);
		
		//for row ------>
		
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[1]
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[4]/td[1]
		
		//for coloum ----->
		
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[3]
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[5]
		
		String beforeXpath="//*[@id=\"crmcalendar\"]/table/tbody/tr[2]/td/table/tbody/tr[";
		String AfterXpath="]/td[";
				
		final int totalWeekDays=7;
		String DayVal=null;
		boolean flag=false;
		
		for(int row=2;row<=7;row++)
		{
			for(int col=1;col<=totalWeekDays;col++)
			{
				try 
				{
				
					DayVal=driver.findElement(By.xpath(beforeXpath+row+AfterXpath+col+"]")).getText();
				
				}
				catch(NoSuchElementException e)
				{
					e.printStackTrace();
					System.out.println("Please enter a correct date");
					flag=false;
					break;			
				}
				
				if(DayVal.equals(Day))
				{
					driver.findElement(By.xpath(beforeXpath+row+AfterXpath+col+"]")).click();
				}
				
			}
			
		}
		
		
		
	}

}
