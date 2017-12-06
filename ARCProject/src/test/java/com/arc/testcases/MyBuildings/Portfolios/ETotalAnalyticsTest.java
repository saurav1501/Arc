package com.arc.testcases.MyBuildings.Portfolios;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsDataInput;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsMyPortfolios;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class  ETotalAnalyticsTest extends BaseClass {
	
	@Test//(dependsOnMethods = { "com.arc.testcases.MyBuildings.LEED.LoginCaseTest.loginCase","com.arc.testcases.MyBuildings.LEED.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.MyBuildings.LEED.PaymentbyCCTest.paymentbyCC" })
	@Parameters({"rowNum" ,"buildingSheet" ,"loginSheet"})
	public void energyTotalAnalytics(int rowNum, String buildingSheet, String loginSheet) throws IOException {
		
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("AEnergyCalculatioonTest-BLEED", "Verifies Total Analytics Tool Tip successfully").assignCategory("CheckAnalytics");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsMyPortfolios reusePF = new ReusableMethodsMyPortfolios();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			
			reuse.LoginToArc(rowNum, "My Projects", loginSheet);
		    reuseSearch.SearchProgram( "70000601");
		//	reuseSearch.SearchProgram( data.getCellData(buildingSheet, "Project Name", rowNum));
		 //   reuseSearch.VerifySearchedProgram( data.getCellData(buildingSheet, "Project Name", rowNum));
		    reusePF.verifyEDailiyMTCO2e("PTotal");		

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			//CommonMethod.testlogError(  "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot( "aenergyCalculatioonTest-BLEED");
			throw e1;
		}
	}
}
