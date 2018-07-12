package com.qa.FreeCRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.FreeCRM.TestBase.TestBaseParent;

public class HomePage extends TestBaseParent
{

	@FindBy(xpath="//td[contains(text(),'CRMPRO')]")
	WebElement HO_CRMPROLable;
	
	@FindBy(xpath="//td[@class='headertext' and contains(text(),'Sonal')]")
	WebElement HO_UserNameLable;
	
	@FindBy(xpath="//a[contains(@title,'Home')]")
	WebElement HO_HomePageLink;
	
	
	public HomePage()
	{
		PageFactory.initElements(Driver, this);
	}
	
	
	//Action & Methods of HomePage
	
	public String VerifyHomePageTitle()
	{
		return Driver.getTitle();
		
	}
	
	public boolean VerifyCRMPROLabel()
	{
		return HO_CRMPROLable.isDisplayed();
		
	}
	
	public boolean VerifyUsernameOfHomePage()
	{
		return HO_UserNameLable.isDisplayed();
		
	}
	
	public boolean VerifyHomePageLink()
	{
		return HO_HomePageLink.isEnabled();
	}
	
	
}
