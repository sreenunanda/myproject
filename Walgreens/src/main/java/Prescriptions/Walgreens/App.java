package Prescriptions.Walgreens;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class App 
{
	public static ExtentReports report;
	public static ExtentTest logger;
   @Test
	public void test()
    {
    	SoftAssert ast = new SoftAssert();
    	ast.assertTrue(false, "failing the condition");
    	ast.assertAll();
        System.out.println( "Hello World!" );
    }
}
