package pages;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import test.AmazonFlipkartTestCase;

public class HomePage {
	
	public  Properties propdata;
	public  String driverPathdata;
	
	public HomePage() throws IOException {

		
		try (InputStream input = AmazonFlipkartTestCase.class.getClassLoader()
				.getResourceAsStream("config.properties")) {
			propdata = new Properties();
			if (input == null) {
				System.out.println("Sorry, unable to find config.properties");
				return;
			}
			// load a properties file from class path, inside static method
			propdata.load(input);
			// get the property value and print it out
			driverPathdata = propdata.getProperty("driverPath");
		}

	}

}
