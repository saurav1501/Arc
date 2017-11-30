package com.arc.testcases.MyBuildings.LEED;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsManage;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class UnistallAllAppsTest extends BaseClass {

	
	@Test//(dependsOnMethods = { "com.arc.testcases.MyBuildings.LEED.LoginCaseTest.loginCase","com.arc.testcases.MyBuildings.LEED.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.MyBuildings.LEED.PaymentbyCCTest.paymentbyCC" })
	@Parameters({"rowNum" ,"buildingSheet","loginSheet" })
	public void uninstallAllApps(int rowNum, String buildingSheet, String loginSheet) throws IOException {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("UnistallAppsTest-BLEED", "Verifies if Apps functionality is working fine").assignCategory("CheckApps");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsManage reuseManage = new ReusableMethodsManage();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			
			reuse.LoginToArc(rowNum, "My Projects",loginSheet);
			reuseSearch.SearchProgram( data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseSearch.VerifySearchedProgram( data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseManage.UninstallApps();

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot( "installAllAppsTest-LEED");
			throw e1;
		}
	}
}
