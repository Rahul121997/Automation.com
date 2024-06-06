package RoughPKG;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import AutomationTestCases.ContactUsForm_TestCasespage_ValidateProductsPage;
import AutomationTestCases.LoginTestCase;
import AutomationTestCases.RegisterUser;
import BasePKG.BaseClass;
import PageObjectsOfAutomation.ContactUsPage;
import PageObjectsOfAutomation.HomePageObjects;

public class TestCase extends BaseClass {

	ContactUsPage cup;
	RegisterUser hm;
	HomePageObjects hmp;
	LoginTestCase ts =new LoginTestCase();

	ContactUsForm_TestCasespage_ValidateProductsPage tss;
	@BeforeClass(alwaysRun=true)
	public void Start() 
	{
		driver=new ChromeDriver();

		driver.get("https://streams.beta-wspbx.com/downloads");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	}

	@Test
	public  void SssignUp()
	{
		System.out.println(":::::::::::");
		List<WebElement>ls=driver.findElements(By.xpath("//a[text()='Download']"));

		List<WebElement>lss=wait.until(ExpectedConditions.visibilityOfAllElements(ls));
		
		for(WebElement l:lss)
		{
			wait.until(ExpectedConditions.elementToBeClickable(l)).click();
		}

	}


	@AfterClass
	public void TearDown()
	{
		Closedriver();
	}

}
