package com.qa.FreeCRM.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.FreeCRM.Pages.ContactsPage;
import com.qa.FreeCRM.Pages.HomePage;
import com.qa.FreeCRM.Pages.LoginPage;
import com.qa.FreeCRM.TestBase.TestBaseParent;
import com.qa.FreeCRM.Utilities.TestUtil;

public class ContactsPageTest extends TestBaseParent
{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	TestUtil testUtil;
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setupContactPage() throws IOException, InterruptedException
	{
		initialization();
		homePage=new HomePage();
		loginPage=new LoginPage();
		contactPage=new ContactsPage();
		homePage=loginPage.ValidateLogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(5000);
		Driver.switchTo().frame("mainpanel");
		contactPage.VerifyClickonNewContanct();
		
	}
	
	@Test(priority=1)
	public void VerifyContactPageTitleTest()
	{
		String ContactPageTitle=contactPage.VerifyContactPageTitle();
		System.out.println("Contact Page Title is: "+ContactPageTitle);
		Assert.assertEquals(ContactPageTitle, "CRMPRO");
	}
	
	@Test(priority=2)
	public void ValidateContactPageInformationFormTest()
	{
		contactPage.ValidateContactInformation();
		System.out.println("Contact Information has been submitted successfully");
	}
	
}
