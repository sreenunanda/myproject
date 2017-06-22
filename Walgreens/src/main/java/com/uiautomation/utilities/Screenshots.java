package com.uiautomation.utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots  {
public WebDriver driver;
	public static String getscreenshot(WebDriver driver, String filename) throws Exception {

		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcfile, new File("./screenshot/" + filename + ".jpg"));
	return filename;
	
		
//		TakesScreenshot ts = (TakesScreenshot)driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		String dest = ".screenshots/"+filename+".png";
//			FileUtils.copyFile(source, new File(dest));
//		
//		return dest;
		
	}

	// testing

	// public static void main(String[] args) throws Exception {
	// getscreenshot(driver, "screenshot");
	// driver.findElement(By.id("search")).sendKeys(Keys.ENTER);
	// driver.quit();
	// }
}
