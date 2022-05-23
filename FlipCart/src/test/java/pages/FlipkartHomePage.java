package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class FlipkartHomePage extends HomePage{

	WebDriver driver;

	public String getProductPrice() {
		return (String) configData.get("productPriceFlipkart");
	}

	public String getSearchBar() {
		return (String) configData.get("searchBarFlipkart");
	}


	public String getSubmitButton() {
		return (String) configData.get("submitButtonFlipkart");
	}

	public WebDriver getDriver() {
		return driver;
	}

	public String getSearchPage() {
		return (String) configData.get("searchPageFlipkart");
	}

	public String getHomePageUserName() {
		return (String) configData.get("homePageFlipkart");
	}

	public String getLoginPopUp() {
		return (String) configData.get("loginPopUpFlipkart");
	}

	public FlipkartHomePage(WebDriver driver) throws IOException {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	// Get the User name from Home Page

	public String homePageUserName() {

		return (String) configData.get("homePageFlipkart");

	}
	
	public String getflipkartLoginTest() {

		return (String) configData.get("flipkartLoginTest");

	}
	

	// Get the User name from Home Page

}
