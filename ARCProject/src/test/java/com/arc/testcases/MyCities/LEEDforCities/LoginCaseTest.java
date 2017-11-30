package com.arc.testcases.MyCities.LEEDforCities;
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
		
		CommonMethod.test = CommonMethod.extent.startTest("Login Test-MyCities.LEEDforCities", "Verifies if Login functionality is working fine").assignCategory("CheckLogin");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();

		
		try {
			
			
			reuse.LoginWithCities(rowNum, "My Cities", loginSheet);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.takeScreenshot("loginCaseTest-city");
			throw e1;
		}
	}
}
