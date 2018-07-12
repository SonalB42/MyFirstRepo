package com.qa.FreeCRM.TestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.FreeCRM.Pages.HomePage;
import com.qa.FreeCRM.Pages.LoginPage;
import com.qa.FreeCRM.TestBase.TestBaseParent;

public class LoginPageTest extends TestBaseParent 
{

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();  //super keyword is used to initialize the TestBase class constructor.
		
	}
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		loginPage=new LoginPage();
		
	}

	@Test(priority=1)
	public void LoginPageTitleTest()
	{
		String title=loginPage.ValidatePageTitle();
		Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
	}
	
	@Test(priority=2)
	public void LoginPageLogoTest()
	{
		boolean flag=loginPage.VerifyFreeCRMLogo();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void LoginVerifyForgotLinkTest()
	{
		boolean flag=loginPage.VerifyForgotPasswordLink();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void LoginVerifySingUpBtnTest()
	{
		boolean flag=loginPage.VerifySingUpBtn();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void ValidLoginTest()
	{
		homePage=loginPage.ValidateLogin(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	@AfterMethod
	public void tearDown()
	{
		Driver.quit();
		
	}
	
}

