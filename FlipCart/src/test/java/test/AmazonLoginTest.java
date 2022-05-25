package test;

import test.DriverHelper;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AmazonHomePage;
import pages.FlipkartHomePage;

public class AmazonLoginTest {
	
	WebDriver driver;
	AmazonHomePage amazonHomePage;
	String driverPath;
	WebElement elements;
	Properties properties;
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	@BeforeTest
	public void createResources() {
		DriverHelper helper = new DriverHelper();
		properties = helper.getConfigProperties();
		driver = helper.getChromeDriver(); 
	}
	
	@Test()
	public void amazonUserLogin() throws IOException {
		amazonHomePage = new AmazonHomePage();
		amazonHomePage.getAmazonHomePage(driver);
		driver.manage().window().maximize();
		amazonHomePage.getSigninSpan(driver).click();
		amazonHomePage.getUserButton(driver).sendKeys("sridharbandi@yahoo.co.in");
		amazonHomePage.getContinueButton(driver).click();
		String email = amazonHomePage.getOtpEmailSpan(driver).getText();
		String mobile = amazonHomePage.getOtpMobileSpan(driver).getText();
		LOGGER.info("emailis:" + email);
		LOGGER.info("moile is:" + mobile);
		Assert.assertEquals(email,properties.get("userEmail"), "email displayed is correct:");
		Assert.assertEquals(mobile,properties.get("userMobile"),"mobile number displayed is correct:");
		String expectedEmail = (String)properties.get("userEmail");
		String expectedMobbile = (String)properties.get("userMobile");
		Assert.assertTrue(email.contains(expectedEmail),"email displayed is correct:");
		Assert.assertTrue(mobile.contains(expectedMobbile),"mobile number displayed is correct:");
	}
	
  /* @Test(priority=1)
	public void dummyTest1() throws IOException{
		//Assertion assertion = new Assertion();
		//assertion.assertEquals("1234", "12345","dummy test1");
		//assertion.assertEquals("1234", "1234", "dunny test1");
		
		//Assert.assertEquals("1234", "12345","dummy test1");
		//Assert.assertEquals("1234", "1234", "dunny test1");
		
		SoftAssert assert1 = new SoftAssert();
		assert1.assertEquals("1234","12345","A1:strings equal");
		assert1.assertEquals("1234", "1234","A2:strings equal");
		assert1.assertAll();
		
	}
	@Test(priority=2)
	public void dummyTest2() throws IOException{
		//Assertion assertion = new Assertion();
		//assertion.assertEquals("1234", "12345","dummy test2");
		//assertion.assertEquals("1234", "1234","dummy test2");
		
		//Assert.assertEquals("1234", "12345","dummy test2");
		//Assert.assertEquals("1234", "1234", "dunny test2");
		
		SoftAssert assert1 = new SoftAssert();
		assert1.assertEquals("1234","12345","B1:strings equal");
		assert1.assertEquals("1234", "1234","B2:strings equal");
		assert1.assertAll();
		
		
	} */
	
	
	@AfterTest
	public void closeResources() {
		driver.quit();
	}

}
