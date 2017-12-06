package com.arc.testcases.MyBuildings.Parksmart;



import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsPrerequisites;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class AllMeasuresFileUploadTest extends BaseClass {

	
	@Test  //(dependsOnMethods = { "com.arc.testcases.MyBuildings.Parksmart.LoginCaseTest.loginCaseTest","com.arc.testcases.MyBuildings.Parksmart.SearchProgramTest.searchProgramTest","com.arc.testcases.MyBuildings.Parksmart.PaymentbyCCTest.paymentbyCCTest" })
	@Parameters({"rowNum" ,"parkingSheet","loginSheet"})
	public void allMeasuresFileUploadTest(int rowNum, String parkingSheet, String loginSheet) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.test = CommonMethod.extent.startTest("AllMeasuresFileUpload_48Credits-parking", "Verifies if all measures file upload functionality is working fine").assignCategory("FileUpload");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsPrerequisites reusePrereq = new ReusableMethodsPrerequisites();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			reuse.LoginWithparking(rowNum, "My Parking", loginSheet);
			
			//reuse.LoginToArc(rowNum, "My Projects",loginSheet);
			reuseSearch.SearchProgram( data.getCellData(parkingSheet, "Project Name", rowNum));
			reuseSearch.VerifySearchedProgram( data.getCellData(parkingSheet, "Project Name", rowNum));
			reusePrereq.AllMeasureFileUpload("MA1Parking",47);
		
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.takeScreenshot( "allMeasuresFileUpload_48Credits-parking");
			throw e1;
		}
	}
}
