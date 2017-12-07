package com.arc.ReusableMethods;

import java.io.IOException;

import org.testng.Assert;

import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.ExtentTest;

public class ReusableMethodsSearch {

	public static ExtentTest test;
	
	 public void SearchProgram(String Leedid)throws IOException, InterruptedException {
		  CommonMethod.IsEnabled("SearchField", "Search field is not enabled");
		  CommonMethod.clear("SearchField");
		  CommonMethod.testlog("Pass", "Clearing values in search field");
		  CommonMethod.sendKeys("SearchField",Leedid);
		  CommonMethod.click("SearchField");
		  CommonMethod.testlog("Pass", "Entering Project name in searchfield "+ Leedid);
		  
		 }

		 

		 public void VerifySearchedProgram(String Leedid)
		  throws IOException, InterruptedException {
		  SearchProgram(Leedid);
		  Thread.sleep(3000);
		  CommonMethod.FluentWait("NumberOfProject");
		  String NoOfProject=CommonMethod.getText("NumberOfProject");
		  System.out.println(NoOfProject);
		  
		  
		  Assert.assertEquals("Project (1 project)", NoOfProject);
		  CommonMethod.testlog("Pass", "Searched total (1 project) Number of Projects");
		  CommonMethod.click("fetchedSearchResult");
		  CommonMethod.testlog("Pass", "Clicking on searched project from search bar");
		   

		 }

/*	public void SearchProgram(String Leedid)throws IOException, InterruptedException {
		CommonMethod.IsEnabled("SearchField", "Search field is not enabled");
		CommonMethod.clear("SearchField");
		CommonMethod.highLightElement("SearchField");
		CommonMethod.testlog("Pass", "Clearing values in search field");
		CommonMethod.sendKeys("SearchField",Leedid);
		CommonMethod.click("SearchField");
		CommonMethod.testlog("Pass", "Entering Project name in searchfield "+ Leedid);
		Thread.sleep(3000);
		CommonMethod.FluentWait("NumberOfProject");
		String NoOfProject=CommonMethod.getText("NumberOfProject");
		System.out.println(NoOfProject);
		//Assert.assertEquals(actual, expected);
	//	CommonMethod.highLightElement("NumberOfProject");
	//	Assert.assertEquals("Project (1 project)", NoOfProject);
		CommonMethod.testlog("Pass", "Searched total (1 project) Number of Projects");
		CommonMethod.click("fetchedSearchResult");
		CommonMethod.highLightElement("fetchedSearchResult");
		CommonMethod.testlog("Pass", "Clicking on searched project from search bar");	
		
	}

	

	public void VerifySearchedProgram(String Leedid)
		throws IOException, InterruptedException {
		SearchProgram(Leedid);
		Thread.sleep(3000);
		CommonMethod.FluentWait("NumberOfProject");
		String NoOfProject=CommonMethod.getText("NumberOfProject");
		System.out.println(NoOfProject);
		//Assert.assertEquals(actual, expected);
		
	//	Assert.assertEquals("Project (1 project)", NoOfProject);
		CommonMethod.testlog("Pass", "Searched total (1 project) Number of Projects");
		CommonMethod.click("fetchedSearchResult");
		CommonMethod.FluentWait("fetchedSearchResult");
		CommonMethod.moveToElement( "fetchedSearchResult");
		CommonMethod.testlog("Pass", "Clicking on searched project from search bar");
	   // CommonMethod.assertEqualsmessage( "SearchsuccessMessage", successMessage,
		// "Clicking on searched program don't navigates to desired page");

	}*/

}
