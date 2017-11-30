package com.arc.testcases.MyBuildings.LEEDfortransit;



import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsBasescore;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class BasePointPdfFileUplaod extends BaseClass {
	@Test(dependsOnMethods = { "com.arc.testcases.MyBuildings.LEEDfortransit.LoginCaseTest.loginCase","com.arc.testcases.MyBuildings.LEEDfortransit.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.MyBuildings.LEEDfortransit.PaymentbyCCTest.paymentbyCC" })
	@Parameters({"rowNum" ,"buildingSheet" ,"loginSheet"})
	public void basePointFileUpload(int rowNum, String buildingSheet, String loginSheet) throws IOException {
		
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("BaseScorePdfUploadTest-TransitU", "Making credits Ready for review in Basescore Credits").assignCategory("CheckBasescore");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsBasescore reuseBS = new ReusableMethodsBasescore();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			reuse.LoginToArc(rowNum, "My Projects", loginSheet);
			reuseSearch.SearchProgram( data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseSearch.VerifySearchedProgram( data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseBS.TBasePointFileUplaod();

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.takeScreenshot( "baseScorePdfUploadTest-TransitU");
			throw e1;
		}
	}
}
