package com.arc.testcases.MyBuildings.None;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class ClickSearchedProgramTest extends BaseClass {

	@Test(dependsOnMethods = { "com.arc.testcases.MyBuildings.None.LoginCaseTest.loginCase"})
	@Parameters({"rowNum" ,"buildingSheet" ,"loginSheet"})
	public void clickSearchedProgram(int rowNum, String buildingSheet, String loginSheet) throws IOException {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("SearchNavigationTest-BNone", "Verifies if Search functionality is working fine").assignCategory("CheckSearch");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();	
		try {
			
			reuse.LoginToArc(rowNum, "My Projects", loginSheet);
			reuseSearch.VerifySearchedProgram("1000137695");

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("clickSearchedProgram-BNone");
			throw e1;
		}
	}

	

}
