package com.arc.testcases.MyCommunities.Other;



import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsManage;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class VerifyAgreementFileDownloadTest extends BaseClass {

	
	@Test(dependsOnMethods = { "com.arc.testcases.MyCommunities.Other.LoginCaseTest.loginCase","com.arc.testcases.MyCommunities.Other.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.MyCommunities.Other.PaymentbyCCTest.paymentbyCC" })
	@Parameters({"rowNum" ,"loginSheet","communitySheet"})
	public void verifyAgreementFileDownload(int rowNum, String loginSheet, String communitySheet) throws IOException {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("Verify Agreement file download TestCommOther", "Verifies if Login functionality is working fine").assignCategory("CheckLogin");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsManage reuseManage = new ReusableMethodsManage();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			
			
			reuse.LoginWithCommunities(rowNum, "My Communities", loginSheet);
			reuseSearch.SearchProgram(data.getCellData(communitySheet, "ProjectName", rowNum));
			reuseSearch.VerifySearchedProgram(data.getCellData(communitySheet, "ProjectName", rowNum));
			reuseManage.VerifyFileDownload("Agreement.pdf");

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.takeScreenshot("verifyAgreementFileDownloadTest-communitiesOther");
			throw e1;
		}
	}
}
