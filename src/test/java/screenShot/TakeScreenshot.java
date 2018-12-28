package screenShot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class TakeScreenshot {
	
	public void takeScreenshot(WebDriver driver) throws Exception{
		String timeStamp;
		File screenShotName;
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		screenShotName = new File("F:\\Eclipse Projects\\Eclipse-Workspace\\Project1\\test-output"+timeStamp+".png");
		FileUtils.copyFile(srcFile,screenShotName);
		
		String filePath = screenShotName.toString();
		String path = "<img src='"+ filePath + "'/ >";
		Reporter.log(path);
	}

}
