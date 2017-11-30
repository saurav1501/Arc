package com.arc.testcases.LandingPage;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class LoginTestBlankValuesTest extends BaseClass {

	@Test
	@Parameters({"rowNum" ,"loginSheet"})
	public void loginTestBlankValuesTest(int rowNum, String loginSheet) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("BlankValue LoginTest-ARC", "Verifies if Login functionality is working fine with blank values").assignCategory("CheckLogin");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();

		
		try {
			
			
			reuse.LoginIncorrectData(9,"Email field is required.", loginSheet);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("loginTestBlankValuesTest-ARC");
			throw e1;
		}
	}
}
