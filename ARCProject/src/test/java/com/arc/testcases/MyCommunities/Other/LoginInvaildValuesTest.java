package com.arc.testcases.MyCommunities.Other;



import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class LoginInvaildValuesTest extends BaseClass {

	@Test
	@Parameters({"rowNum" ,"loginSheet"})
	public void loginInvaildValues(int rowNum, String loginSheet) throws IOException {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("Invalid Login Test-CommunitiesOther", "Verifies if Login functionality is working fine with invalid values").assignCategory("CheckLogin");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();

		
		try {
			
			reuse.LoginIncorrectData(rowNum,"Error message", loginSheet);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.takeScreenshot("loginInvaildValuesTest-communitiesOther");
			throw e1;
		}
	}
}
