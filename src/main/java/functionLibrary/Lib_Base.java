package functionLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lib_Base {
	
	public WebDriver driver;
	public Properties prop;
	public FileInputStream fis;
	
	public Properties initializeProperty() {
		
		Properties prop = new Properties();
		return prop;
	}
	
	public FileInputStream initializeFileInputStream(String envpropfilepath) throws FileNotFoundException {
		 FileInputStream fis = new FileInputStream(envpropfilepath);
		 return fis;
	}
	
	public WebDriver initializeDriver(String browserName, String envpropfilepath) throws IOException {
		
		prop = initializeProperty();
		fis = initializeFileInputStream(envpropfilepath);
		prop.load(fis);
		String chromedriverpath = prop.getProperty("chromedriverpath");
		String firefoxdriverpath = prop.getProperty("firefoxdriverpath");
		String iedriverpath = prop.getProperty("iedriverpath");
		
		
		if (browserName.equals("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", chromedriverpath);
			driver = new ChromeDriver();
			
		}
		
		if (browserName.equals("Firefox")) {
			
			System.setProperty("webdriver.chrome.driver", firefoxdriverpath);
			driver = new ChromeDriver();
			
		}
		
		if (browserName.equals("InternetExplorer")) {
			
			System.setProperty("webdriver.ie.driver", iedriverpath);
			driver = new ChromeDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	


}
