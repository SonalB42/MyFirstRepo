package com.qa.FreeCRM.TestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.FreeCRM.Pages.HomePage;
import com.qa.FreeCRM.Pages.LoginPage;
import com.qa.FreeCRM.TestBase.TestBaseParent;
import com.qa.FreeCRM.Utilities.TestUtil;

public class HomePageTest extends TestBaseParent  
{
		HomePage homePage;
		LoginPage loginPage;
		TestUtil testUtil;
		
		public HomePageTest()
		{
			super();  // super keyword is used to initialize the parent class consturctor
		}
		
		@BeforeMethod
		public void setupHomePage() throws IOException
		{
			initialization();
			homePage=new HomePage();
			loginPage=new LoginPage();
			homePage=loginPage.ValidateLogin(prop.getProperty("username"), prop.getProperty("password"));
		}
		
		@Test
		public void VerifyHomePageTitleTest()
		{
		
			String HomePagetitle=homePage.VerifyHomePageTitle();
			System.out.println("Home Page Title is: "+HomePagetitle);
			//Assert.assertEquals(HomePagetitle, "CRMPRO");
		}
	
		
		@Test
		public void VerifyHomePageUserName()
		{
			testUtil.SwitchToFrame();
			try {
			boolean flag2=homePage.VerifyUsernameOfHomePage();
			System.out.println("Print the HomePge Username boolean Value: "+flag2);
			Assert.assertTrue(flag2);
			}
			catch(NoSuchElementException e)
			{
				e.printStackTrace();
			}

		}
	
		@Test
		public void VerifyHomePageLinkBtn()
		{
			try {
			boolean flag1=homePage.VerifyHomePageLink();
			Assert.assertTrue(flag1);
			}
			catch(NoSuchElementException e)
			{
				e.printStackTrace();
			}
		}
				
		@AfterMethod
		public void TearDown()
		{
						
			Driver.quit();
		}
		

		
		
}
