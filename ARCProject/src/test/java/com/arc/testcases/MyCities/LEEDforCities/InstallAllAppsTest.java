package com.arc.testcases.MyCities.LEEDforCities;



import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsManage;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class InstallAllAppsTest extends BaseClass {

	
	@Test(dependsOnMethods = { "com.arc.testcases.MyCities.LEEDforCities.LoginCaseTest.loginCase","com.arc.testcases.MyCities.LEEDforCities.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.MyCities.LEEDforCities.PaymentbyCCTest.paymentbyCC" })
	@Parameters({"rowNum" ,"loginSheet", "citySheet"})
	public void installAllApps(int rowNum, String loginSheet, String citySheet) throws IOException {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("Install Apps-MyCities.LEEDforCities", "Verifies if Apps functionality is working fine").assignCategory("CheckApps");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsManage reuseManage = new ReusableMethodsManage();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			
			reuse.LoginToArc(rowNum, "My Projects", loginSheet);
			reuseSearch.SearchProgram(data.getCellData(citySheet, "ProjectName", rowNum));
			reuseSearch.VerifySearchedProgram(data.getCellData(citySheet, "ProjectName", rowNum));
			reuseManage.InstallAppsCustom();

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.takeScreenshot("installAllAppsTest-city");
			throw e1;
		}
	}
}
