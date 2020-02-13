package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

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
		return (String) propdata.get("homePageAmazon") ;
	}

	public String getSearchPage() {
		return (String) propdata.get("searchPage");
	}

	public String getCostValuefromAmazon() {
		return (String) propdata.get("costValuefromAmazon");
	}
	
	public String getamazonLoginTest() {
		return (String) propdata.get("amazonLoginTest");
	}

}
