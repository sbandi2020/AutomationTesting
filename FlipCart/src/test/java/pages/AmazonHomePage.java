package pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test.DriverHelper;

public class AmazonHomePage extends HomePage{

	WebDriver driver;
	
	public AmazonHomePage()throws IOException {
		
	}
	public AmazonHomePage(WebDriver driver)throws IOException{
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	// Get the User name from Home Page

	public WebDriver getDriver() {
		return driver;
	}

	public String getHomePage() {
		return (String) configData.get("homePageAmazon") ;
	}

	public String getSearchPage() {
		return (String) configData.get("searchPage");
	}

	public String getProductPrice() {
		return (String) configData.get("productPriceAmazon");
	}
	
	public String getamazonLoginTest() {
		return (String) configData.get("amazonLoginTest");
	}
	
	public void getAmazonHomePage(WebDriver  driver) {
		String amazonUrl = (String)configData.get("homePageAmazon");
		driver.get(amazonUrl);
		
	}
	
	public WebElement getSigninSpan(WebDriver  driver) {
		String spanXpath = (String)configData.get("amazonSigninSpan");
		WebElement element = driver.findElement(By.xpath(spanXpath));
		return element;
	}
	
	public WebElement getUserButton(WebDriver  driver) {
		String userButtonName = (String)configData.get("userButtonName");
		WebElement element = driver.findElement(By.name(userButtonName));
		return element;
	}
	
	public WebElement getContinueButton(WebDriver  driver) {
		String continueButtonId= (String)configData.get("continueButtonId");
		WebElement element = driver.findElement(By.id(continueButtonId));
		return element;
	}
	
	public WebElement getOtpEmailSpan(WebDriver  driver) {
		String otpEmailXpath= (String)configData.get("otpEmailXpath");
		WebElement element = driver.findElement(By.xpath(otpEmailXpath));
		return element;
	}
	
	public WebElement getOtpMobileSpan(WebDriver  driver) {
		String otpMobileXpath= (String)configData.get("otpMobileXpath");
		WebElement element = driver.findElement(By.xpath(otpMobileXpath));
		return element;
	}

}
