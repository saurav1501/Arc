package com.arc.testcases.MyBuildings.LEEDfortransit;



import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class LoginCaseTest extends BaseClass {

	@Test
	@Parameters({"rowNum" ,"loginSheet"})
	public void loginCase(int rowNum, String loginSheet) throws IOException {
		
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("LoginTest-Transit", "Verifies if Login functionality is working fine").assignCategory("CheckLogin");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();

		
		try {
			
			reuse.LoginWithtransit(rowNum, "My Transit", loginSheet);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot( "loginTest-Transit");
			throw e1;
		}
	}
}
