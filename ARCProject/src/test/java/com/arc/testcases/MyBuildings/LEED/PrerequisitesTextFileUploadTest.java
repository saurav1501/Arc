package com.arc.testcases.MyBuildings.LEED;



import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsPrerequisites;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class PrerequisitesTextFileUploadTest extends BaseClass {

	
	@Test//(dependsOnMethods = { "com.arc.testcases.MyBuildings.LEED.LoginCaseTest.loginCase","com.arc.testcases.MyBuildings.LEED.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.MyBuildings.LEED.PaymentbyCCTest.paymentbyCC" })
	@Parameters({"rowNum" ,"buildingSheet", "loginSheet"})
	public void prerequisitesTextFileUpload(int rowNum, String buildingSheet, String loginSheet) throws IOException {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("PrerequisitesTxtFileUploadTest-BLEED", "Verifies if Prerequisites functionality is working fine").assignCategory("CheckPrerequisites");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsPrerequisites reusePrereq = new ReusableMethodsPrerequisites();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			
			reuse.LoginToArc(rowNum, "My Projects", loginSheet);
			//reuseSearch.VerifySearchedProgram("1000137535");
			reuseSearch.SearchProgram(data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseSearch.VerifySearchedProgram(data.getCellData(buildingSheet, "Project Name", rowNum));
			reusePrereq.PrereqTextFileUpload("sitemanagement",9);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError( "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("prerequisitestxtFileUpload-BLEED");
			throw e1;
		}
	}
}
