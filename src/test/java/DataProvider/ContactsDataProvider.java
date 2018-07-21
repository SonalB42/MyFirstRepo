package DataProvider;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.FreeCRM.Pages.ContactsPage;
import com.qa.FreeCRM.Pages.HomePage;
import com.qa.FreeCRM.Pages.LoginPage;
import com.qa.FreeCRM.TestBase.TestBaseParent;
import com.qa.FreeCRM.Utilities.ReadDataFromExcel;
import com.qa.FreeCRM.Utilities.TestUtil;

public class ContactsDataProvider extends TestBaseParent
{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	TestUtil testUtil;
	
	public ContactsDataProvider()
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
	
	@DataProvider(name="ContactDetails")
	public Object[][] ContactsData() throws IOException
	{
		Object[][] contactsData=ReadDataFromExcel.ReadContactsData();
		return contactsData;
	}
	
	@Test(priority=2,dataProvider="ContactDetails")
	public void ValidateContactInformationTest(String Title,String fname, String lname, String Position, String MobNo, String email)
	{
		
		Select TitleDrp=new Select(Driver.findElement(By.xpath("//select[@name='title']")));
		TitleDrp.selectByVisibleText(Title);
		Driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(fname);
		Driver.findElement(By.xpath("//input[@id='surname']")).sendKeys(lname);
		Driver.findElement(By.xpath("//input[@id='company_position']")).sendKeys(Position);
		Driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys(MobNo);
		Driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		Driver.findElement(By.xpath("//form[@name='contactForm']//input[@type='submit' and @value='Save']")).click();
	}

	@AfterMethod
	public void TearDown()
	{
		Driver.quit();
	}
	
}
