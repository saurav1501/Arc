package com.arc.testcases.MyBuildings.Parksmart;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.ReusableMethods.ReusableMethodsManage;
import com.arc.ReusableMethods.ReusableMethodsSearch;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;


public class ProjectDetailsVerificationTest extends BaseClass {

	
	@Test(dependsOnMethods ={ "com.arc.testcases.MyBuildings.Parksmart.LoginCaseTest.loginCaseTest","com.arc.testcases.MyBuildings.Parksmart.SearchProgramTest.searchProgramTest","com.arc.testcases.MyBuildings.Parksmart.PaymentbyCCTest.paymentbyCCTest" })
	@Parameters({"rowNum" ,"parkingSheet", "loginSheet" })
	public void projectDetails(int rowNum, String parkingSheet, String loginSheet) throws IOException {
		
		CommonMethod.ExtentReportConfig();
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.test = CommonMethod.extent.startTest("ManageProjectDetailsTest-Parking", "Verifies if billing status is displaying correct in billing page").assignCategory("ProjectDeatils");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsManage reuseManage = new ReusableMethodsManage();
		ReusableMethodsSearch reuseSearch = new ReusableMethodsSearch();
		
		try {
			
			reuse.LoginToArc(rowNum, "My Projects", loginSheet);
			reuseSearch.SearchProgram( data.getCellData(parkingSheet, "Project Name", rowNum));
			reuseSearch.VerifySearchedProgram( data.getCellData(parkingSheet, "Project Name", rowNum));
			reuseManage.VerifyProjectDetailsParking();

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.takeScreenshot( "ProjectDetailVerificationTest-Park");
			throw e1;
		}
	}

	
}
