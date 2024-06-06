package AutomationTestCases;

import java.awt.AWTException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BasePKG.BaseClass;
import PageObjectsOfAutomation.ContactUsPage;
@Listeners(Listenerss.MyListener.class)
public class ContactUsForm_TestCasespage_ValidateProductsPage extends BaseClass{

	ContactUsPage cup;
	RegisterUser hm;
	LoginTestCase LgTest=new LoginTestCase();
	RegisterUser dt;
	public  FileReader reader;

	public  Properties p;
	public static String path="./src/main/TestData.properties";
	@BeforeClass
	public void StartUp() throws IOException
	{
		MainRun();
		p=new Properties();
		reader=new FileReader(path);
		p.load(reader);
		hm=new RegisterUser();

	}

	@Test(priority=1)
	public void ValidateContact()
	{
		cup=new ContactUsPage();
		log.info("click on contact us page");
		cup.ClickOnContactsUsPage();
		log.info("validate contact us page");
		cup.ValidateContactUsPage("Get In Touch");
		log.info("entering user name"+p.getProperty("fname"));
		cup.EnterName(p.getProperty("fname"));
		log.info("entering user gmail"+p.getProperty("usedemail"));
		cup.EnterEmail(p.getProperty("usedemail"));
		log.info("entering subject"+p.getProperty("Subject"));
		cup.EnterSubject(p.getProperty("Subject"));
		log.info("entering messages"+p.getProperty("Message"));
		cup.EnterMessage(p.getProperty("Message"));
		log.info("uploading image from local"+p.getProperty("UploadFile"));
		cup.UploadFile(p.getProperty("UploadFile"));
		log.info("clicking on submoit button");
		cup.ClickOnSubmitButton();
		log.info("clicking on pop up notification");
		cup.AcceptPopNotification();
		log.info("validating contactus us submission"+p.getProperty("ContactUsSubmission"));
		cup.ValidateContactUsSubmission(p.getProperty("ContactUsSubmission"));
		log.info("click on home button");
		cup.ClickOnHome();
		log.info("validating home page"+p.getProperty("homepageurl"));
		cup.ValidateBackToHome(p.getProperty("homepageurl"));

	}

	@Test(priority=2)
	public void ValidateTestCasePage()
	{
		log.info("click test case section");
		cup.ClickOnTestCase();
		log.info("validating test cases page"+p.getProperty("testcaseurl"));
		cup.ValidateTestCasesPage(p.getProperty("testcaseurl"));
	}

	@Test(priority=3)
	public void ValidateProductsPage()
	{
		log.info("click on product");
		cup.ClickOnProducts();
		log.info("click on product 1");
		cup.ClickOnProduct_1();
		log.info("validate on product info");
		cup.ValidateProductInfo();
	}

	@Test(priority=4)
	public void AddProductToCart()
	{
		log.info("navigating to previous page");
		driver.navigate().back();
		log.info("add to cart 1");
		cup.HoverToElement();
		log.info("validating product added to cart"+p.getProperty("CardValidationmsg"));
		cup.ValidateAddedtoCart(p.getProperty("CardValidationmsg"));
		log.info("clicking on continue shopping button");
		cup.ClickOnContinueShopping();
		log.info("add to cart 2");
		cup.HoverToElement2();
		log.info("click on view cart button");
		cup.ClickOnViewCart();
		log.info("validate items added in cart");
		cup.ValidateItemsAddedToCart(1);
		log.info("validating product info");
		cup.ValidateProductInfo();

	}

	@Test(priority=5)
	public void ValidateSearchedPrductFution()
	{
		log.info("clicking in product section");
		cup.ClickOnProducts();
		log.info("search a product from search bar");
		cup.EnterProductNameForSearch(p.getProperty("searchiteam"));
		log.info("click on search button");
		cup.ClickOnSearchPrdt();
		log.info("validate searched items ");
		cup.ValidateSearchedPrudctItems(p.getProperty("Serchedvalidaton"));	
	}

	@Test(priority=6)
	public void AddMoreItemsToCart()
	{
		log.info("clicking on home button ");

		cup.ClickONHomeButton();
		
		log.info("click on product 1");

		cup.ClickOnProduct_1();
		log.info("Entering Quantity of Products");

		cup.EnterQuantity("4");
		log.info("clicking on add to cart button ");

		cup.ClickOnAddtoCartButton();
		
		log.info("click on view cart button");

		cup.ClickOnViewCart();
		
		log.info("Validating count products added in cart");

		cup.VerifyAddedQunatity("5");
	}

	@Test(priority=7)
	public void ValidateCheckOutItems()
	{
		log.info("clicking on home button ");

		cup.ClickONHomeButton();
		log.info("adding product 1 to cart ");

		cup.HoverToElement();
		log.info("adding product 2 to cart ");

		cup.HoverToElement2();
		log.info("click on view cart button");

		cup.ClickOnViewCart();
		log.info("clicking on check out buttion");
		cup.ClickProceedToCheckout();
		log.info("clicking on Regisster or signin Button");

		cup.ClickOnReg_signinButton();
		log.info("calling signup method from other class");
		hm.SignUp();
		log.info("clicking cart section");

		cup.ClickOnCartButton();
		log.info("clicking on proceed to check out button");

		cup.ClickProceedToCheckout();
		log.info("validating address details");

		cup.VerifyAddressDetailstext(p.getProperty("addresss"));
		log.info("validating order details"+p.getProperty("revieworder"));

		cup.VerifyReviewYourOrdertxt(p.getProperty("revieworder"));
		log.info("entering comment in comment secrtion"+p.getProperty("Message"));

		cup.EnterComment(p.getProperty("Message"));
		log.info("clicking on place order  button");

		cup.ClickONPlaceOrder();
		log.info("Entering card Name"+p.getProperty("username"));
		cup.EnterCardName(p.getProperty("username"));
		log.info("Entering card Number"+p.getProperty("CardNumber"));

		cup.EnterCardNumber(p.getProperty("CardNumber"));
		log.info("Entering card CVC"+p.getProperty("CVV"));

		cup.EnterCardCVC(p.getProperty("CVV"));
		log.info("Entering card Month");

		cup.EnterCardMonth(p.getProperty("Expiraydate"));
		log.info("Entering card Year"+p.getProperty("Year"));

		cup.EnterExpiryYear(p.getProperty("Year"));
		log.info("Clicking on pay and confrim order  button");

		cup.ClickOnPayAndConfrimOrder();
		log.info("Validating  order placed"+p.getProperty("orderplacedtext"));

		cup.VerifyOrderConfrimation(p.getProperty("orderplacedtext"));
		log.info("clicking on continue button");

		cup.ClickOnContinueButtom();
		log.info("deleting created account after order confrimation");

		dt=new RegisterUser();
		dt.DeleteAccount();

	}

	@Test(priority=8)
	public void LoginbeforeCheckout() throws AWTException
	{

		log.info("calling  login function from  login test method");
		LgTest.LoginAutomationFuntion();
		log.info("added product 1 in cart");

		cup.HoverToElement();
		log.info("added product 1 in cart");

		cup.HoverToElement2();
		log.info("click on continue shopping button");

		
		cup.ClickOnContinueShopping();
		log.info("click on  cart section button");

		cup.ClickOnCartButton();
		log.info("click on proceed to checout button");

		cup.ClickProceedToCheckout();
		log.info("validating address details");

		cup.VerifyAddressDetailstext("Address Details");
		log.info("validating order content");

		cup.VerifyReviewYourOrdertxt("Review Your Order");
		log.info("Entering Comment in comment section");
		
		cup.EnterComment("Testing purpose");
		log.info("click on Place order button");

		cup.ClickONPlaceOrder();
		log.info("Entering card name");

		cup.EnterCardName("RamagiriRahul");
		log.info("Entering card Number");

		cup.EnterCardNumber("1000000000000");
		log.info("Entering card cvc");

		cup.EnterCardCVC("334");
		log.info("Entering card Month");

		cup.EnterCardMonth("05");
		log.info("Entering card Year");

		cup.EnterExpiryYear("2028");
		log.info("cliking on pay and confrim order button");

		cup.ClickOnPayAndConfrimOrder();
		log.info("Validating order placed");

		cup.VerifyOrderConfrimation("Order Placed!");
		


	}
	
	@Test(priority=9)
	public void DownloadInvoice()
	{
		log.info("Validate Downloading Invoice");

		cup.ValidateClickOnDownlaodInvoice();
		log.info("Validating Downloaded Invoice");
		cup.ValidateDownloadInvoice("C:\\Users\\Rahul\\Downloads","invoice");
		log.info("clicking on continue button");
		cup.ClickOnContinueButtom();
		log.info("Validate LogoutFunction");
		LgTest.ValidateLogoutFuntion();
		
	}

	@Test(priority=10)
	public void RemoveProductsFromCart()
	{
		log.info("click on product section");

		cup.ClickOnProducts();
		log.info("addeding product 1 to cart");

		cup.HoverToElement();
		

		log.info("Validating items added to cart");

		cup.ValidateAddedtoCart("Added!");
		log.info("Validating clicking on shopping button");

		cup.ClickOnContinueShopping();
		log.info("addeding product 2 to cart");

		cup.HoverToElement2();
		log.info("Validating clicking on view cart button");

		cup.ClickOnViewCart();
		log.info("clicking removal button of items from cart");

		cup.ClickONDeleFromCartButton();
		log.info("Validate removal of items from Cart");

		cup.ValidateRemovedFromCart("Cart is empty!");	
		log.info("clicking on home section");

		cup.ClickONHomeButton();
	}
	@Test(priority=11)
	public void ViewCategoryProducts() 
	{
		log.info("clicking on Women section");

		cup.ClickOnWomen();
		log.info("clicking on Dress button section");

		cup.ClickOnDress();
		log.info("clicking on women dress section");

		cup.ValidateWomenDress("Women - Dress Products");
		log.info("clicking on men section");

		cup.ClickOnmen();
		log.info("clicking on Men T shirt section");

		cup.ClickOnTshirts();
		log.info("Validating men dress section");

		cup.ValidatemenDress("MEN - TSHIRTS PRODUCTS");
		
		log.info("verifying catgory page ");

		cup.VerifyCatgorypage("https://automationexercise.com/category_products/3");
	}

	@Test(priority=12)
	public void ViewCartBrandProducts()
	{
		log.info("clicking on Product section");

		cup.ClickOnProducts();
		log.info("validating brand section");

		cup.ValidateBrand("Brands");
		log.info("validating Polo Brand section");

		cup.ClickOnPoloBrand();
		log.info("validating Polo Brand page section");

		cup.ValidatePOLOBrandPage("Brand - Polo Products");
		log.info("validating H&M Brand section");

		cup.ClickOnHandM();
		log.info("validating H&M Brand section");

		cup.ValidateHMBrandPage("BRAND - H&M PRODUCTS");

	}

	@Test(priority=13)
	public void SearchProductsandVerifyCartAfterLogin()
	{
		log.info("Clicking on  products section");

		cup.ClickOnProducts();
		log.info("validating search products");

		ValidateSearchedPrductFution();
		log.info("Adding all product to cart");

		cup.AddALLprdsTOcart();
		log.info("click on cart button");

		cup.ClickOnCartButton();
		log.info("validating product info section");

		cup.ValidateProductInfo();	
		log.info("calling login method from login class");

		LgTest.LoginAutomationFuntion();
		log.info("clicking on cart button");

		cup.ClickOnCartButton();
		log.info("validating product info section");

		cup.ValidateProductInfo();	
	}
	
	@Test(priority=14)
	public void Addreviewonproduct()
	{
		log.info("clicking  on home button");

		cup.ClickONHomeButton();
		log.info("clicking  on product 1");

		cup.ClickOnProduct_1();
		log.info("Entering name in review section");

		cup.EnterNameofreview("Rahul");
		log.info("Entering email in review section");

		cup.EnterEmailofreview("rahul@gamil.com");
		log.info("Entering review comment in review section");

		cup.Enterofreview("very good");
		log.info("clicking on submit reviw button  in review section");

		cup.ClickSubmitReview();
		log.info("validating subimtted reiview, in review section");

		cup.ValidateReview();
	}


	@AfterClass
	public void TearDown()
	{
		Closedriver();
	}


}
