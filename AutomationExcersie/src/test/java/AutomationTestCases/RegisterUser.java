package AutomationTestCases;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BasePKG.BaseClass;
import PageObjectsOfAutomation.HomePageObjects;
import RoughPKG.TestCase;
@Listeners(Listenerss.MyListener.class)

public class RegisterUser extends BaseClass 
{
	public HomePageObjects hm;
	public  FileReader reader;

	public  Properties p;

	@BeforeClass(alwaysRun=true)
	public void Start() throws IOException 
	{
		MainRun();
		p=new Properties();
		p=new Properties();
		reader=new FileReader(ContactUsForm_TestCasespage_ValidateProductsPage.path);
		p.load(reader);
	}
	
	@Test(priority=0)
	public void ClickOnSignuplink()
	{
		hm=new 	HomePageObjects();
		log.info("clicking on signup button");

		hm.clickOnSignUp();
	}

	@Test(priority=1)
	public void SignUp()
	{
		hm=new 	HomePageObjects();
		log.info("entering name "+p.getProperty("fname"));

		hm.EnterName(p.getProperty("fname"));
		log.info("entering email "+p.getProperty("email"));

		hm.EnterGmail(p.getProperty("email"));
		log.info("clicking on Signup button");

		hm.ClcikOnSignUpBtn();
		log.info("selecting Saluation for user");

		hm.SelectSaluation();
		log.info("Enter password "+p.getProperty("pwd"));

		hm.EnterPassword(p.getProperty("pwd"));
		log.info("selecting Date from drop down"+p.getProperty("date"));

		hm.SelectDate(p.getProperty("date"));
		log.info("select  the Month "+p.getProperty("month"));

		hm.SelectMonth(p.getProperty("month"));
		log.info("Enter Year"+p.getProperty("dobyear"));

		hm.SelectYear(p.getProperty("dobyear"));
		log.info("selecting check box signup letter");

		hm.SelectCheckBoxSignupnewsletter();
		log.info("selecting check box to receive spcl offer");

		hm.SelectCheckBoxReceiveSpecialOffers11();
		log.info("Entering Frist Name "+p.getProperty("fname"));

		hm.EnterFristName(p.getProperty("fname"));
		log.info("Entering Last Name "+p.getProperty("lname"));

		hm.EnterLastame(p.getProperty("lname"));
		log.info("Entering Company Name "+p.getProperty("company"));

		hm.EnterCompany(p.getProperty("company"));
		log.info("Entering Address "+p.getProperty("address1"));

		hm.EnterAddress(p.getProperty("address1"));
		log.info("Entering City Name "+p.getProperty("address2"));

		hm.EnterAddress2(p.getProperty("address2"));
		log.info("Entering Country Name "+p.getProperty("country"));

		hm.SelectCountry(p.getProperty("country"));
		log.info("Entering State Name"+p.getProperty("state"));

		hm.EnterState(p.getProperty("state"));
		log.info("Entering State Name");

		hm.EnterCity(p.getProperty("address2"));
		log.info("Entering Pincode"+p.getProperty("pincode"));

		hm.EnterZipcode(p.getProperty("pincode"));
		log.info("Entering Phone number");

		hm.EnterMobileNumber(p.getProperty("phonenumber"));
		log.info("Clicking on create accounting button");

		hm.ClickOnCreateAccount();
		log.info("Validating create account text validating test"+p.getProperty("Accountcreatintext"));

		hm.ValidatecreateAccountValidationText(p.getProperty("Accountcreatintext"));
		log.info("clicking on contiune button");

		hm.ClickONContinueButton();
	}

	@Test(priority=2)
	public void DeleteAccount()
	{
		hm=new 	HomePageObjects();
		log.info("Clicking on delete account button");

		hm.ClickOnDeleteAccountButton();
		log.info("Validating  Delete account"+p.getProperty("Accountdeletedmsg"));

		hm.ValidateDeleteAccount(p.getProperty("Accountdeletedmsg"));
	}
	
	@Test(priority=3)
	public void RegiesterWithSameEamil()
	{
		log.info("Clicking on Signup Button");
		hm.clickOnSignUp();
		log.info("Entering Name"+p.getProperty("fname"));

		hm.EnterName(p.getProperty("fname"));
		log.info("Entering Email"+p.getProperty("eamil"));

		hm.EnterGmail1(p.getProperty("eamil"));
		log.info("Entering Clicking SignupButton");
		
		hm.ClcikOnSignUpBtn();
		log.info("Validating Register with same email address"+p.getProperty("EmailAddressexists"));

		hm.ValidateRegisterWithSameEamil(p.getProperty("EmailAddressexists"));
		
	}
	
	@AfterClass
	public void TearDown()
	{
		Closedriver();
	}

}
