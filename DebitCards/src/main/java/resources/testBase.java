package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class testBase {
	
	
	
	public static WebDriver driver=null;
	public static Properties p=null;
	

	public void setup() throws IOException
	{
		
		 p=new Properties();
		FileInputStream fi=new FileInputStream("C:\\Apps\\DebitCards\\src\\main\\java\\resources\\global.properties");
		p.load(fi);
		//System.out.println(p.getProperty("browser"));
		
		if(p.getProperty("browser").contains("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if (p.getProperty("browser").contains("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", value);
			driver=new ChromeDriver();
			}
		else
		{
			//Internetexplorer
		}
		driver.get(p.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		login();
		
	}
	
	public void login()
	{
		driver.get(p.getProperty("url"));
		driver.findElement(By.xpath(".//*[@id='txtUsername']")).sendKeys(p.getProperty("username"));
		driver.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys(p.getProperty("password"));
		driver.findElement(By.xpath(".//*[@id='btnSignIn']")).click();
		driver.manage().window().maximize();
	}
	
	public void logout()
	{
		driver.findElement(By.xpath(".//*[@id='btnLogout']")).click();
		driver.quit();
		
		
	}
}
