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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AmazonHomePage;
import pages.FlipkartHomePage;

public class AmazonTestCases {

	WebDriver driver;
	AmazonHomePage amazonHomePage;
	String driverPath;
	WebElement elements;
	Properties prop;
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	
	@BeforeTest
	public void createResources() {
		DriverHelper helper = new DriverHelper();
		prop = helper.getConfigProperties();
		driver = helper.getChromeDriver(); 
	}

	/**
	 * 
	 * Login in https://www.amazon.in/
	 * 
	 *search for product and  select the matching product once list appears return the price of the selected product
	 * 
	 */
	@Test(priority=1)
	public void getProductFromAmazon() throws IOException {
		
		// creating object for amazon page
		amazonHomePage = new AmazonHomePage(driver);

		// Login home page for amazon
		String homePageUrl = amazonHomePage.getHomePage();
		driver.get(homePageUrl);
		driver.manage().window().maximize();
		assertTrue(driver.findElement(By.xpath(amazonHomePage.getamazonLoginTest())).isDisplayed(),"Amazon page logged in successfully");
		LOGGER.info("Amazon page logged in successfully");
		
		String searchPage = amazonHomePage.getSearchPage();
		// searching data product in amazon
		driver.findElement(By.id((String) prop.get("amazonSearchbox"))).sendKeys((String) prop.get("product"));
		driver.findElement(By.xpath(searchPage)).click();

		// Product value getting from amazon
		String valueOfProductFromAmazonValue = driver.findElement(By.xpath(amazonHomePage.getProductPrice()))
				.getText();
		LOGGER.info("Found "+(String) prop.get("product") +" successfully in Amazon");
		//Assertion for Product found
		assertTrue( driver.findElement(By.xpath(amazonHomePage.getProductPrice())).isDisplayed());
		String[] split = valueOfProductFromAmazonValue.split(",");
		String valueOfProductFromAmazonSplit = split[0] + "" + split[1];
		driver.close();
		LOGGER.info("**********Value of product:" + valueOfProductFromAmazonSplit);
		LOGGER.info("Amazon page logged out");
		//return Integer.parseInt(valueOfProductFromAmazonSplit);
		
	}

	/**
	 * 
	 * This test case will login in https://www.amazon.in/
	 * 
	 * search for iPhone XR (64GB) - Yellow
	 * 
	 * Select the matching iPhone once list appears.
	 * 
	 * Get the price of the selected iPhone
	 * 
	 * Now, login to https://www.flipkart.com/.
	 * 
	 * Compare the price on both the website and determine which website. has
	 * lesser value for the iPhone and print the final result on the console
	 * 
	 */
		
/*	@Test(priority = 0)
	public void testHomePageAppearCorrect() throws IOException {

		// login to amazon and get the price value
		int valueOfProductFromAmazon = valueOfProductFromAmazon();
		//amazon data for not null 
		assertNotNull(Integer.valueOf(valueOfProductFromAmazon));
		// login to flipkart and get the price value
		int valueOfProductFromFlipkart = valueOfProductFromFlipkart();
		//flipkart data for not null 		
		assertNotNull(Integer.valueOf(valueOfProductFromFlipkart));
		if (valueOfProductFromAmazon < valueOfProductFromFlipkart) {
			LOGGER.info("********************************************************************************");
			LOGGER.info("As Amazon cost: " + valueOfProductFromAmazon);
			LOGGER.info("As Flipkart cost: " + valueOfProductFromFlipkart);
			LOGGER.info("Prefering to purchase prodcut from amazon:-------> " + valueOfProductFromAmazon);

		} else if (valueOfProductFromAmazon > valueOfProductFromFlipkart) {

			LOGGER.info("Prefering to purchase prodcut from flipkart:------->");
			LOGGER.info("As Amazon cost: " + valueOfProductFromAmazon);
			LOGGER.info("As Flipkart cost: " + valueOfProductFromFlipkart);
			LOGGER.info("Prefering to purchase prodcut from flipkart:-------> " + valueOfProductFromAmazon);

		} else {

			LOGGER.info("Both price in Amazon and flipkart same------->");
			LOGGER.info("Amazon cost: " + valueOfProductFromAmazon);
			LOGGER.info("Flipkart cost: " + valueOfProductFromFlipkart);
		}
		LOGGER.info("********************************************************************************");
	}  */

	@AfterTest
	public void closeResources() {
		driver.quit();
	}
	
}
