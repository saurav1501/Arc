package com.arc.testcases.MyCities.None;



import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsManage;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class BillingRegistrationAmountVerificationTest extends BaseClass {

	
	@Test(dependsOnMethods = { "com.arc.testcases.MyCities.None.LoginCaseTest.loginCase","com.arc.testcases.MyCities.None.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.MyCities.None.PaymentbyCCTest.paymentbyCC" })
	@Parameters({"rowNum" ,"loginSheet","citySheet"})
	public void billingRegistrationAmountVerification(int rowNum, String loginSheet, String citySheet) throws IOException {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("RegistrationAmount Test-CitiesNone", "Verifies if registration amount is displayed correct in billing page").assignCategory("CheckBilling");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsManage reuseManage = new ReusableMethodsManage();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			reuse.LoginWithCities(rowNum, "My Cities", loginSheet);
			reuseSearch.SearchProgram(data.getCellData(citySheet, "ProjectName", rowNum));
			reuseSearch.VerifySearchedProgram(data.getCellData(citySheet, "ProjectName", rowNum));
			reuseManage.verifyRegAmount(citySheet, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.takeScreenshot("billingRegistrationAmountVerificationTest-cityNone");
			throw e1;
		}
	}
}
