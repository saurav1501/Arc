package com.arc.testcases.MyBuildings.LEEDfortransit;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsAddProject;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class PaymentbyCCTest extends BaseClass {

	
	@Test(dependsOnMethods = { "com.arc.testcases.MyBuildings.LEEDfortransit.LoginCaseTest.loginCase","com.arc.testcases.MyBuildings.LEEDfortransit.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.MyBuildings.LEEDfortransit.UnderGroundAddNewProjectTest.addNewProject" })
	@Parameters({"rowNum" ,"buildingSheet","loginSheet","paymentSheet"})
	public void paymentbyCC(int rowNum, String buildingSheet, String loginSheet, String paymentSheet) throws IOException {
		
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
	    CommonMethod.test = CommonMethod.extent.startTest("PaymentByCreditcardTest-TransitU", "Verifies if Payment done through creditcard is successful").assignCategory("CheckPayment");
        ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsAddProject reuseAddProject = new ReusableMethodsAddProject();
		ReusableMethodsSearch reusePublicSearch = new ReusableMethodsSearch();
		try {
			reuse.LoginToArc(rowNum,"My Projects", loginSheet);
			reusePublicSearch.SearchProgram(data.getCellData(buildingSheet, "Project Name", rowNum));
			reusePublicSearch.VerifySearchedProgram( data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseAddProject.PaymentbyCC("paymentsuccessvalidation","Congratulations!", paymentSheet, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot( "paymentbyCCTest-TransitU");
			throw e1;
		}
	}
}
