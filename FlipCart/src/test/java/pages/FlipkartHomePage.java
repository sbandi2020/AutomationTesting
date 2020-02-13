package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class FlipkartHomePage extends HomePage{

	WebDriver driver;

	public String getValueOfProductFromFlipkart() {
		return (String) propdata.get("valueOfProductFromFlipkart");
	}

	public String getSearchBar() {
		return (String) propdata.get("searchBarFlipkart");
	}


	public String getSubmitButton() {
		return (String) propdata.get("submitButtonFlipkart");
	}

	public WebDriver getDriver() {
		return driver;
	}

	public String getSearchPage() {
		return (String) propdata.get("searchPageFlipkart");
	}

	public String getHomePageUserName() {
		return (String) propdata.get("homePageFlipkart");
	}

	public String getLoginPopUp() {
		return (String) propdata.get("loginPopUpFlipkart");
	}

	public FlipkartHomePage(WebDriver driver) throws IOException {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	// Get the User name from Home Page

	public String homePageUserName() {

		return (String) propdata.get("homePageFlipkart");

	}
	
	public String getflipkartLoginTest() {

		return (String) propdata.get("flipkartLoginTest");

	}
	

	// Get the User name from Home Page

}
