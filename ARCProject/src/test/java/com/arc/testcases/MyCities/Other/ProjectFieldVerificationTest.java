package com.arc.testcases.MyCities.Other;



import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsManage;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class ProjectFieldVerificationTest extends BaseClass {


	@Test(dependsOnMethods = { "com.arc.testcases.MyCities.Other.LoginCaseTest.loginCase","com.arc.testcases.MyCities.Other.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.MyCities.Other.PaymentbyCCTest.paymentbyCC" })
	@Parameters({"rowNum" ,"loginSheet","citySheet"})
	public void projectFieldVerification(int rowNum, String loginSheet, String citySheet) throws IOException {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("ProjectField Test-cityOther", "Verifies if Project Field is displayed correct").assignCategory("CheckProject");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsManage reuseManage = new ReusableMethodsManage();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			
			reuse.LoginWithCities(rowNum, "My Cities", loginSheet);
			reuseSearch.SearchProgram(data.getCellData(citySheet, "ProjectName", rowNum));
			reuseSearch.VerifySearchedProgram(data.getCellData(citySheet, "ProjectName", rowNum));
			reuseManage.projectFieldDisplayed();

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.takeScreenshot("projectFieldVerificationTest-cityOther");
			throw e1;
		}
	}
}
