package pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import test.DriverHelper;

public class AmazonHomePage extends HomePage{

	WebDriver driver;
	
	public AmazonHomePage(WebDriver driver)throws IOException  {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	// Get the User name from Home Page

	public WebDriver getDriver() {
		return driver;
	}

	public String getHomePageUserName() {
		return (String) configData.get("homePageAmazon") ;
	}

	public String getSearchPage() {
		return (String) configData.get("searchPage");
	}

	public String getCostValuefromAmazon() {
		return (String) configData.get("costValuefromAmazon");
	}
	
	public String getamazonLoginTest() {
		return (String) configData.get("amazonLoginTest");
	}

}
