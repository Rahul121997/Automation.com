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
@Listeners(Listenerss.MyListener.class)

public class LoginTestCase extends BaseClass{
	static HomePageObjects hm;
	public  FileReader reader;

	public  Properties p;

	@BeforeClass(alwaysRun=true)
	public void Start() throws IOException 
	{
		MainRun();
		p=new Properties();
		reader=new FileReader(ContactUsForm_TestCasespage_ValidateProductsPage.path);
		p.load(reader);
	}

	@Test(priority=1)
	public void LoginAutomationFuntion()
	{
		hm=new HomePageObjects();
		log.info("click on Signup Button");
		hm.clickOnSignUp();
		log.info("Enter EmailAddress"+p.getProperty("usedemail"));

		hm.EnterEmailAddress(p.getProperty("usedemail"));
		log.info("Enter Password"+p.getProperty("pwd"));

		hm.EnterPasswordLogin(p.getProperty("pwd"));
		log.info("Clicking on Login");

		hm.ClickOnLoginButton();
		log.info("Validating Login"+p.getProperty("username"));
		hm.ValidateLoginFuntion(p.getProperty("username"));
	}

	@Test(priority=2)
	public void ValidateLogoutFuntion()
	{
		log.info("click on logout button");
		hm.ClickOnLogoutButton();
		log.info("Validating logout");
		hm.ValidateLogoutFuntion(p.getProperty("validatelogout"));
	}

	@Test(priority=3)
	public void ValidateLoginWithInvalidaCreds()
	{
		log.info("Clicking on Signup Button");
		hm.clickOnSignUp();
		log.info("Entering email");

		hm.EnterEmailAddress(p.getProperty("usedemail"));
		log.info("Enter Password");

		hm.EnterPasswordLogin(p.getProperty("pwd"));
		log.info("clicking login button");

		hm.ClickOnLoginButton();
		log.info("validating login with invalid credentials");

		hm.ValidateLoginWithInvalidCred(p.getProperty("incorrect"));

	}
	@Test(priority=4)
	public void ValidateSubscrition()
	{
		log.info("Scrolling page hight");
		JS("window.scrollTo(0, document.body.scrollHeight);");
		log.info("Entering Email for subscrition"+p.getProperty("usedemail"));
		hm.EnterEmailForSub(p.getProperty("usedemail"));
		log.info("Clicking on SubScribe Button");
		hm.ClickOnSubScribe();
		log.info("Validating SubScribe section"+p.getProperty("subscribe"));
		hm.ValidateSubScribe(p.getProperty("subscribe"));
	}
	@Test(priority=5)
	public void ValidateSubscitionFromCart()
	{
		log.info("clicking on cart section");

		hm.ClickOnCart();
		log.info("Scrolling page hight");

		JS("window.scrollTo(0, document.body.scrollHeight);");
		log.info("Entering Email for subscrition");

		hm.EnterEmailForSub(p.getProperty("usedemail"));
		log.info("clicking on SubScribe");

		hm.ClickOnSubScribe();
		log.info("Validating SubScribe Section");

		hm.ValidateSubScribe(p.getProperty("subscribe"));
	}

	@AfterClass
	public void TearDown()
	{
		Closedriver();
	}

}
