package com.arc.testcases.MyBuildings.None;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsDataInput;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class  CTotalAnalyticsTest extends BaseClass {
	
	@Test(dependsOnMethods = { "com.arc.testcases.MyBuildings.None.LoginCaseTest.loginCase","com.arc.testcases.MyBuildings.None.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.MyBuildings.None.PaymentbyCCTest.paymentbyCC" })
	@Parameters({"rowNum" ,"buildingSheet" ,"loginSheet"})
	public void carbonTotal(int rowNum, String buildingSheet, String loginSheet ) throws IOException {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("ACarbonCalculationTest-BNone", "Verifies TOTAL ANNUAL CARBON EMISSIONS None Successfully").assignCategory("CheckAnalytics");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsDataInput reuseDI = new ReusableMethodsDataInput();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			
			reuse.LoginToArc(rowNum, "My Projects",loginSheet);
		  //  reuseSearch.VerifySearchedProgram(driver, "1000137787");
		 	reuseSearch.SearchProgram(data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseSearch.VerifySearchedProgram(data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseDI.verifyCTotalProjectAnalytics("Atotal");
			reuseDI.verifyCTotalPerSQFTAnalytics("Atotal");
			reuseDI.verifyCTotalPerOCCAnalytics("Atotal");
			

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(driver,  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("analyticTotalCarbonTest-BNone");
			throw e1;
		}
	}
}
