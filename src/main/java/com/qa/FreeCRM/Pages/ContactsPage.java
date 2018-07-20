package com.qa.FreeCRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.FreeCRM.TestBase.TestBaseParent;

public class ContactsPage extends TestBaseParent
{
	
	@FindBy(xpath="//a[contains(@title,'Contacts')]")
	WebElement Contacts_linkBtn;
	
	@FindBy(xpath="//a[contains(@title,'New Contact')]")
	WebElement Con_NewContact_linkBtn;
	
	@FindBy(xpath="//a[contains(@title,'Full Search')]//parent::li//parent::ul//parent::li//a[contains(@title,'Contacts')]")
	WebElement Con_CombinedForm_linkBtn;
	
	@FindBy(xpath="//a[contains(@title,'Full Search')]//parent::li//parent::ul//parent::li//a[contains(@title,'Contacts')]")
	WebElement Con_FullSearch_linkBtn;
	
	@FindBy(xpath="//select[@name='title']")
	WebElement NewContacts_TitleDrpBtn;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement NewContacts_FnameTextBox;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement NewContacts_LnameTextBox;
	
	@FindBy(xpath="//input[@id='company_position']")
	WebElement NewContacts_Position_TextBox;

	@FindBy(xpath="//input[@id='department']")
	WebElement NewContacts_Department_TextBox;
	
	@FindBy(xpath="//input[@id='mobile']")
	WebElement NewContacts_Mobile_TextBox;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement NewContacts_email_TextBox;
	
	@FindBy(xpath="//form[@name='contactForm']//input[@type='submit' and @value='Save']")
	WebElement NewContacts_Save_Btn;
	
	
	public ContactsPage()
	{
		PageFactory.initElements(Driver, this);
	}
	
	public ContactsPage VerifyClickonNewContanct()
	{
		Actions action=new Actions(Driver);
		action.moveToElement(Contacts_linkBtn).build().perform();
		Con_NewContact_linkBtn.click();
		return new ContactsPage();
		
	}
	
	public String VerifyContactPageTitle()
	{
		return Driver.getTitle();
	}
	
	public void ValidateContactInformation()
	{
		Select TitleDrp=new Select(NewContacts_TitleDrpBtn);
		TitleDrp.selectByVisibleText("Mrs.");
		NewContacts_FnameTextBox.sendKeys("Reeta");
		NewContacts_LnameTextBox.sendKeys("Nikhar");
		NewContacts_Position_TextBox.sendKeys("Accountant");
		NewContacts_Mobile_TextBox.sendKeys("8982394181");
		NewContacts_email_TextBox.sendKeys("ReetaNikhar@gmail.com");
		NewContacts_Save_Btn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
