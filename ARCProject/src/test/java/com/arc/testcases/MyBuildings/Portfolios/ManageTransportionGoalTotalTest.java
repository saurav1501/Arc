package com.arc.testcases.MyBuildings.Portfolios;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsAddProject;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsManage;
import com.arc.ReusableMethods.ReusableMethodsMyPortfolios;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class  ManageTransportionGoalTotalTest extends BaseClass {
	
	@Test//(dependsOnMethods = { "com.arc.testcases.MyBuildings.LEEDfortransit.LoginCaseTest.loginCase","com.arc.testcases.MyBuildings.LEEDfortransit.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.MyBuildings.LEEDfortransit.PaymentbyCCTest.paymentbyCC" })
	@Parameters({"rowNum" ,"portfoliosSheet" ,"loginSheet"})
	public void goalCarbon(int rowNum, String portfoliosSheet , String loginSheet) throws IOException {
		
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("ManageCarbonGoalTotalTest-Portfolio", "Verifies TOTAL ANNUAL CARBON EMISSIONS LEEDfortransit Successfully").assignCategory("CheckAnalytics");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		ReusableMethodsMyPortfolios reuseManage = new ReusableMethodsMyPortfolios();
		
		try {
			
			reuse.LoginToArc(rowNum, "My Projects", loginSheet);
		//	String current=driver.getCurrentUrl();
		//	CommonMethod.verifyLinkActive(current);
	         reuseSearch.SearchProgram("70000527");
		 	//reuseSearch.SearchProgram( data.getCellData(buildingSheet, "Project Name", rowNum));
			//reuseSearch.VerifySearchedProgram( data.getCellData(buildingSheet, "Project Name", rowNum));
			reuseManage.goalCarbon(portfoliosSheet, rowNum);
			

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot( "ManageCarbonGoalTotalTest-Portfolio");
			throw e1;
		}
	}
}
