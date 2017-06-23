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
import resources.myLocks;
import resources.myaccount;
import resources.mycontacts;
import resources.mydevices;
import resources.testBase;

public class LandingpageNavigationsTest extends testBase{
	
	

	
	
	@Test
	public void Landingpagevalidaton() throws IOException
	{
		//Need to login into Mercury Application
		
		//To Access the methods present in any class
		//You need to first create object for that class and then call
		//the methods of that class with the object
		
//Creating object means ivoking constructor method of class
		setup();
		Landingpage lp=new Landingpage(driver);
		
		Assert.assertTrue(lp.mmyaccount().isDisplayed());
		Assert.assertTrue(lp.mmycontacts().isDisplayed());
		Assert.assertTrue(lp.mmydevices().isDisplayed());
		lp.mmydevices().click();
		mydevices md=new mydevices(driver);
	Assert.assertEquals("my devices", md.mheadertitle().getText());
		driver.navigate().back();
	/*	lp.mlocks().click();
		myLocks ml=new myLocks(driver);
		Assert.assertEquals("My Locks",ml.mheadertitle().getText());
		driver.navigate().back();*/
		lp.mmyaccount().click();
		myaccount ac=new myaccount(driver);
		Assert.assertEquals("my account", ac.mheadertitle().getText());
		driver.navigate().back();
		lp.mmycontacts().click();
		mycontacts mt=new mycontacts(driver);
		Assert.assertEquals("my contacts", mt.mheadertitle().getText());
		logout();
		
		}
	

}
