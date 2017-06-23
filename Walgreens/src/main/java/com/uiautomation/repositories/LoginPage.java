package com.uiautomation.repositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='userName-phoneNo']")
	private WebElement Username;
	@FindBy(xpath = "//button[@id='continueBtn']")
	private WebElement Continue;
	@FindBy(id = "password")
	private WebElement password;
	@FindBy(id = "passwordtabSignIn")
	private WebElement Signin;
	@FindBy(xpath = ".//*[@id='passwordless-username-validation-error']/span[2]")
	private WebElement Msg_alert;

	public void ValidLogin(String username, String Password) {
		Username.sendKeys(username);
		Continue.click();
		password.sendKeys(Password);
		Signin.click();
	}

	public void Invalidlogin() {
		Continue.click();
		String Actual_error = Msg_alert.getText();
//		 String Expected_error = "Please enter your username or phone number.";
		Assert.assertTrue(Actual_error.equals("Please enter your username or phone numbe"));

	}

}
