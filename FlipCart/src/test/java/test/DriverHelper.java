package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverHelper {

	WebDriver driver;
	Properties properties;
	String  driverPath;
	
	public DriverHelper() {
		
	}
	
	public void setConfigProperties() throws IOException {

		try (InputStream input = DriverHelper.class.getClassLoader()
				.getResourceAsStream("config.properties")) {
			properties = new Properties();
			if (input == null) {
				System.out.println("Sorry, unable to find config.properties");
				return;
			}
			// load a properties file from class path, inside static method
			properties.load(input);
			// get the property value and print it out
			driverPath = properties.getProperty("driverPath");
		}

	}
	
    public Properties getConfigProperties() {
    	try {
    	 setConfigProperties();
    	}
    	catch(Exception ex) {
    		
    	}
    	return properties;
    }
	
	public WebDriver getChromeDriver() {
		
		WebDriverManager.chromedriver().version(properties.getProperty("chromeDriverVersion")).setup();
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options); 
		//System.setProperty("webdriver.chrome.driver","c:\\java\\chromedriver.exe");   
	    //driver = (WebDriver) new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

}
