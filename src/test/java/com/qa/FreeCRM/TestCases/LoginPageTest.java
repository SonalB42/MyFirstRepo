package com.qa.FreeCRM.TestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.FreeCRM.Pages.HomePage;
import com.qa.FreeCRM.Pages.LoginPage;
import com.qa.FreeCRM.TestBase.TestBaseParent;
import com.qa.FreeCRM.Utilities.JavaScriptFunctions;
import com.qa.FreeCRM.Utilities.ReadDataFromExcel;
import com.qa.FreeCRM.Utilities.ReadLoginData;

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

	//@Test(priority=1)
	public void LoginPageTitleTest()
	{
		String title=loginPage.ValidatePageTitle();
		Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
	}
	
	//@Test(priority=2)
	public void LoginPageLogoTest()
	{
		boolean flag=loginPage.VerifyFreeCRMLogo();
		Assert.assertTrue(flag);
	}
	
	//@Test
	public void LoginVerifyForgotLinkTest()
	{
		boolean flag=loginPage.VerifyForgotPasswordLink();
		Assert.assertTrue(flag);
	}
	
	//@Test
	public void LoginVerifySingUpBtnTest()
	{
		boolean flag=loginPage.VerifySingUpBtn();
		Assert.assertTrue(flag);
	}
	
	/*@Test(priority=3)
	public void ValidLoginTest()
	{
		homePage=loginPage.ValidateLogin(prop.getProperty("username"), prop.getProperty("password"));	
	}
	*/
	
	@DataProvider(name="LoginDataProvider")
	public Object[][] LoginData() throws IOException
	{
		Object[][] lgnData=ReadLoginData.readLoginData();
		return lgnData;
		
	}
	
	
	@Test(dataProvider="LoginDataProvider")
	public void VerifyLoginMultipleTestData(String uname,String Pass)
	{
		Driver.findElement(By.xpath("//input[@type='text' and @name='username']")).sendKeys(uname);
		Driver.findElement(By.xpath("//input[@type='password' and @name='password']")).sendKeys(Pass);
		Driver.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();	
		
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		Driver.quit();
		
	}
	
}

