package BasePKG;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {


	public static WebDriver driver;

	public static WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	public static JavascriptExecutor js;
	public static Logger log = LogManager.getLogger();
	public static Properties p=new Properties();  ;
	
	

	public void MainRun()
	{
		log.info("opening chrome");
		driver=new ChromeDriver();
		
		log.info("navigating to autiomation.com");
		driver.get("https://automationexercise.com/");
		
		log.info("maximixe chrome window");
		driver.manage().window().maximize();
		
		log.info("page load time out waiting window");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	public String RandomEmail(String Unique)
	{
		Random rd=new Random();
		String Email=rd.nextInt(10000)+Unique;
		return Email;
		
	}
	public void JS(String script)
	{
		String src=script;
		js=(JavascriptExecutor)driver;
		js.executeScript(src, " ");
		
	}
	
	public void Acts(WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).click().perform();
		
	}
	public void RB() throws AWTException
	{
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_TAB);
		
	}
	
	public static String TakeScreenShot() throws IOException
	{
		Date date=new Date();
		System.out.println(date);
		String scrdate=date.toString().replace(":","_").replace(" ","_");
		String screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		return screenshotFile;
		
	}

	
	public void Closedriver()
	{
		driver.close();
	}
	



}
