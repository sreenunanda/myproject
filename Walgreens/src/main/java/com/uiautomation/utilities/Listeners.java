package com.uiautomation.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
public WebDriver driver;
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Testcases started details  " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Testcases success details" + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Testcases failure details" + result.getName());

			try {
				Screenshots.getscreenshot(driver, result.getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Testcases skipped details" + result.getName());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
