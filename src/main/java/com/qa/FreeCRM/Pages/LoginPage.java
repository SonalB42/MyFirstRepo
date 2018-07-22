package com.qa.FreeCRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.FreeCRM.TestBase.TestBaseParent;
import com.qa.FreeCRM.Utilities.JavaScriptFunctions;

public class LoginPage extends TestBaseParent
{

 
	//Page factory--Object Repository
	@FindBy(xpath="//input[@type='text' and @name='username']")
	WebElement Username;
	
	@FindBy(xpath="//input[@type='password' and @name='password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@type='submit' and @value='Login']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//img[@class='img-responsive' and @alt='free crm logo']")
	WebElement FreeCRMLogo;
	
	@FindBy(xpath="//small[contains(text(),'Forgot Password?')]")
	WebElement ForgotBtn;
	
	@FindBy(xpath="//button[@type='button' and text()='Sign Up']")
	WebElement SignUpBtn;
	
	@FindBy(xpath="//a[contains(text(),'Features')]")
	WebElement FeaturesLinkBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement SignUpLinkBtn;
	
	@FindBy(xpath="//a[contains(text(),'Pricing')]")
	WebElement PricingLinkBtn;
	
	@FindBy(xpath="//a[contains(text(),'Customers')]")
	WebElement CustomersLinkBtn;
	
	@FindBy(xpath="//a[contains(text(),'Contact')]")
	WebElement ContactLinkBtn;
	
	
	@FindBy(xpath="//div[@id='slide_1']//h1[contains(text(),'Free CRM software in the cloud powers')]")
	WebElement FreeCRMCustomerService_Text;
	

	
	//Initializing the Page object we have to use constructor
	public LoginPage()
	{
		PageFactory.initElements(Driver, this); //PageFacorty initElements is used to initialize the object and this keyword is used for current class objects
		
	}
	
	//Actions and Methods:
	
	public String ValidatePageTitle()
	{
		return Driver.getTitle();
		
	}
	
	public boolean VerifyFreeCRMLogo()
	{
		return FreeCRMLogo.isDisplayed();
		
	}
	
	public boolean VerifyForgotPasswordLink()
	{
		return ForgotBtn.isDisplayed();
		
	}
	
	public boolean VerifySingUpBtn()
	{
		return SignUpBtn.isDisplayed();
		
	}
	
	
	public boolean VerifyFeatureLinkBtn()
	{
		return FeaturesLinkBtn.isDisplayed();
		
	}
	
	public boolean VerifySignUpLinkBtn()
	{
		return SignUpLinkBtn.isDisplayed();
		
	}
	
	public boolean VerifyPricingLinkBtn()
	{
		return PricingLinkBtn.isDisplayed();
		
	}
	
	public boolean VerifyCustomersLinkBtn()
	{
		return CustomersLinkBtn.isDisplayed();
		
	}
	
	public boolean VerifyFreeCRMCustomerService_Text()
	{
		return FreeCRMCustomerService_Text.isDisplayed();
		
	}
	
	public boolean VerifyContactLinkBtn()
	{
		return ContactLinkBtn.isDisplayed();
		
	}
	
	public void VerifyLoginFunctionality()
	{
		System.out.println("Verify Login Functionality");
	}
	
	public HomePage ValidateLogin(String uname,String Pass)
	{
		Username.sendKeys(uname);
		Password.sendKeys(Pass);
		return new HomePage();
	}
}
