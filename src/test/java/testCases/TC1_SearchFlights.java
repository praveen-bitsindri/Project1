package testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import functionLibrary.Lib_Base;
import objectRepository.OR_LandingPage;
import resourcesAndUtils.Utils_Excel;
import screenShot.TakeScreenshot;

public class TC1_SearchFlights extends Lib_Base {
	
	public String appUrl;
	public String fromLocation;
	public String toLocation;
	
	private static Logger log = LogManager.getLogger(TC1_SearchFlights.class.getName());
	
	@Parameters({"env","browser","envpropfilepath"})
	@BeforeTest
	public void initialize(String env, String browser, String envpropfilepath) throws IOException {
		
		 driver = initializeDriver(browser,envpropfilepath);
		 log.info("driver is initialized successfully");
		
	}
	

	@Test
	public void searchFlights() throws Exception {
		
		prop.load(fis);
		String ExcelPath= prop.getProperty("test_data_file_path");
		String ExcelSheetName= prop.getProperty("sheet_name");
		Utils_Excel.setExcelFile(ExcelPath, ExcelSheetName);
		
		fromLocation = Utils_Excel.getCellData(1,0);
		toLocation = Utils_Excel.getCellData(1,1);
		
		appUrl = prop.getProperty("url");
		
		driver.manage().window().maximize();		
		driver.get(appUrl);
		
		TakeScreenshot sc = new TakeScreenshot();
		sc.takeScreenshot(driver);
		
		OR_LandingPage lp = new OR_LandingPage(driver);
		WebElement searchFromBox = lp.getfromMenuText();
		searchFromBox.click();
		Thread.sleep(5000);
		WebElement searchFromItem = lp.getfromMenuItem(fromLocation);
		searchFromItem.click();
		WebElement searchToBox = lp.gettoMenuText();
		searchToBox.click();
		Thread.sleep(5000);
		WebElement searchToItem = lp.gettoMenuItem(toLocation);
		searchToItem.click();
		sc.takeScreenshot(driver);
		Thread.sleep(5000);
		WebElement searchButton = lp.getSearchButton();
		searchButton.click();
				
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		
		driver.quit();
		log.info("driver is closed successfully");
	}

}
