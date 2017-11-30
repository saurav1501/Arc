package com.arc.testcases.MyCities.None;



import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class SearchProgramTest extends BaseClass {

	@Test(dependsOnMethods = { "com.arc.testcases.MyCities.None.LoginCaseTest.loginCase"})
	@Parameters({"rowNum" ,"loginSheet","citySheet"})
	public void searchProgram(int rowNum, String loginSheet, String citySheet) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("SearchProgram Test-Cities None", "Verifies if Search functionality is working fine").assignCategory("CheckSearch");
        
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();

		
		try {
			
			reuse.LoginWithCities(rowNum, "My Cities", loginSheet);
			reuseSearch.SearchProgram(data.getCellData(citySheet, "ProjectName", rowNum));

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.takeScreenshot("searchProgramTest-city None");
			throw e1;
		}
	}
}
