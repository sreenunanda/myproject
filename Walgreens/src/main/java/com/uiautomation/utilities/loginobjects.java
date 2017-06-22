package com.uiautomation.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginobjects extends TestBase {

	// WebDriver driver;
	public loginobjects(WebDriver driver) {
		TestBase.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "uid")
	WebElement userid;
	@FindBy(name = "password")
	WebElement Password;
	@FindBy(name = "btnLogin")
	WebElement login;

	public WebElement userid() {
		return userid;

	}

	public WebElement Password() {
		return Password;

	}

	public WebElement login() {
		return login;

	}

}
