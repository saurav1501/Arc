package com.arc.testcases.MyCities.Other;



import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsDataInput;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class WasteMeterCreateTest extends BaseClass {


    
	@Test(dependsOnMethods = { "com.arc.testcases.MyCities.Other.LoginCaseTest.loginCase","com.arc.testcases.MyCities.Other.ClickSearchedProgramTest.clickSearchedProgram","com.arc.testcases.MyCities.Other.PaymentbyCCTest.paymentbyCC" })
	@Parameters({"rowNum" ,"loginSheet","citySheet","wasteSheet"})
	public void wasteMeterCreate(int rowNum, String loginSheet, String citySheet, String wasteSheet) throws IOException {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("Waste Meter Create Test City Other", "Verifies if Login functionality is working fine").assignCategory("CheckLogin");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsDataInput reuseDI = new ReusableMethodsDataInput();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			
			
			reuse.LoginWithCities(rowNum, "My Cities", loginSheet);
			reuseSearch.SearchProgram(data.getCellData(citySheet, "ProjectName", rowNum));
			reuseSearch.VerifySearchedProgram(data.getCellData(citySheet, "ProjectName", rowNum));
			reuseDI.CreateWasteMeter("Waste", wasteSheet, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.takeScreenshot("wasteMeterCreateTest-cityOther");
			throw e1;
		}
	}
}
