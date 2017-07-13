package Prescriptions.Walgreens;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAsrt {
	
@Test
public void soft()
{
	SoftAssert ast = new SoftAssert();
	ast.assertTrue(true, null);
	ast.assertAll();
	System.out.println("qwerty");
}

}
