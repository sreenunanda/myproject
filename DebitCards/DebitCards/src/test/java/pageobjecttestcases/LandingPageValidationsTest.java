package pageobjecttestcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Landingpage;
import resources.testBase;

public class LandingPageValidationsTest extends testBase{
	
	
	
	
	
	@Test
	public void Landingpagenavigation() throws IOException
	{
		//Need to login into Mercury Application
		
		//To Access the methods present in any class
		//You need to first create object for that class and then call
		//the methods of that class with the object
		
//Creating object means ivoking constructor method of class
		setup();
		Landingpage lp=new Landingpage(driver);
		Assert.assertTrue(lp.maway().isDisplayed());
		Assert.assertTrue(lp.mhome().isDisplayed());
		Assert.assertTrue(lp.mlocks().isDisplayed());
		Assert.assertTrue(lp.mmyaccount().isDisplayed());
		Assert.assertTrue(lp.mmycontacts().isDisplayed());
		Assert.assertTrue(lp.mmydevices().isDisplayed());
		Assert.assertTrue(lp.mnight().isDisplayed());
		logout();
}
	

}
