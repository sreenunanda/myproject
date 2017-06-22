package com.uiautomation.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class NewBrowser {
	 public WebDriver Mydriver;
@BeforeMethod
	public static void GetBrowser(WebDriver driver, String Browser, String Url) {

		if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		} else if (Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.ie.driver", "C:\\selenium\\IEDriverServer.exe");

			driver = new InternetExplorerDriver();
		}
		driver.get(Url);
	}
@AfterMethod
public void TearDown()
{
	Mydriver.quit();
}
}
