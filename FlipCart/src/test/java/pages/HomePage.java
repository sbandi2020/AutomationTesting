package pages;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import test.AmazonFlipkartTestCase;
import test.DriverHelper;

public class HomePage {
	
	public  Properties configData;
	public  String driverPathdata;
	
	public HomePage() throws IOException {

		configData = new DriverHelper().getConfigProperties();

	}

}
