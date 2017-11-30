package com.arc.testcases.MyBuildings.None;
import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.arc.ReusableMethods.ReusableMethodsAddProject;
import com.arc.ReusableMethods.ReusableMethodsLogin;
import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;

public class AddNewProjectTest extends BaseClass {
	
	@Test
	//(dependsOnMethods={"com.arc.testcases.MyBuildings.None.LoginCaseTest.loginCaseTest"})
	@Parameters({"rowNum" ,"loginSheet", "buildingSheet"})
	public void addNewProject(int rowNum, String loginSheet, String buildingSheet) throws IOException {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		
		CommonMethod.test = CommonMethod.extent.startTest("Add NewProjectUSTest-BNone", "Verifies if New Project is added successfully").assignCategory("CheckAddProject");
    
		ReusableMethodsLogin reuse = new ReusableMethodsLogin();
		ReusableMethodsAddProject reuseAddProject = new ReusableMethodsAddProject();
		
		try {
			
			reuse.LoginWithBuildings(rowNum, "My Buildings", loginSheet);
			reuseAddProject.AddProjectNoneUS(rowNum, buildingSheet);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.testlogError( "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("addNewProjectTest-BNone");
			throw e1;
		}
	}
}
