package com.uiautomation.utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public WebDriver driver;

	@BeforeClass
	public void beforeTest() throws Exception {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\MYWORKSPAC\\practice\\property.properties");
		prop.load(fis);
		if (prop.get("browser").equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (prop.get("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.ie.driver", "C:\\selenium\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.get(prop.getProperty("url"));
	}

	@AfterMethod
	
	public void afterTest(ITestResult results) throws Throwable {
		driver.close();
		if (ITestResult.FAILURE == results.getStatus()) {
			Screenshots.getscreenshot(driver, results.getName());
		}
		
	
	}
//@AfterTest
//public void after_test()
//{
//	driver.close();
//}
}
