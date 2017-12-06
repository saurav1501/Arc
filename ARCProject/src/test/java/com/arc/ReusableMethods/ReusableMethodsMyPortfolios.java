package com.arc.ReusableMethods;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;

import org.testng.Assert;

import com.arc.driver.BaseClass;
import com.arc.driver.CommonMethod;
import com.relevantcodes.extentreports.ExtentTest;

public class ReusableMethodsMyPortfolios extends BaseClass{

	public static ExtentTest test;

	public void goalCarbon(String sheetName, int rowNum,String pGoal) throws IOException, InterruptedException {		

		String cpReduction 		= data.getCellData(sheetName, "CPReduction", rowNum);
		String cbValue 	= data.getCellData(sheetName, "CBValue", rowNum);
		String cUnit 	= data.getCellData(sheetName, "Cunit", rowNum);
		String ctextbox 	= data.getCellData(sheetName,"CTextBox", rowNum);	
		CommonMethod.driverwait(1);
		
		CommonMethod.ArcSpecifictoggle(pGoal);
		CommonMethod.testlog("Pass", "Filling carbon reduction percentage value");
		CommonMethod.clear("CarbonPReduction");
		CommonMethod.sendKeys("CarbonPReduction",cpReduction);
		CommonMethod.testlog("Pass", "Filling carbon baseline value");
		CommonMethod.clear("CarbonBValue");
		CommonMethod.sendKeys("CarbonBValue",cbValue);
		   
        CommonMethod.testlog("Pass", "Test started verifying carbon unit MTCO2E");
        String mtco2e = CommonMethod.getText("CMTCO2e");
        System.out.println(mtco2e);
        Assert.assertEquals(mtco2e,cUnit);
		CommonMethod.testlog("Pass", "Test passed verified carbon unit  MTCO2E successfully");
		
		CommonMethod.testlog("Pass", "Test Started Carbon differece of goal calcation");
		String forntenddiffGoal = CommonMethod.getText("CDFormGoal");
		CommonMethod.highLightElement("CDFormGoal");
		String currentProgress=CommonMethod.getText("CarbonCProgress");
		System.out.println(currentProgress);
		CommonMethod.highLightElement("CarbonCProgress");
		String replace = currentProgress.replace("%" , "");
		double replace1=Double.parseDouble(replace);
		double result1 =replace1-100;
		//NumberFormat formatter = new result("#000.00");
		BigDecimal result2 = new BigDecimal(result1);     
		result2 =  result2 .setScale(2, RoundingMode.HALF_UP);
        String calcalteddiffGoal = result2 + " %";  
        System.out.println(calcalteddiffGoal);  
		Assert.assertEquals(forntenddiffGoal, calcalteddiffGoal);
		CommonMethod.testlog("Pass", "Test passed verified differece goal successfully");
						
		CommonMethod.testlog("Pass","Test started verifying acheive goal in percentage");
		String carbonGoal = CommonMethod.getText("CarbonGoal");
        String greplace = carbonGoal.replace("%" , "");
		double cGexpected=Double.parseDouble(greplace);
		System.out.println(cGexpected);
		double cGactual = 100/2;
		System.out.println(cGactual);
		Assert.assertEquals(cGactual, cGexpected);
		CommonMethod.testlog("Pass","Test passed verified acheive goal percentage successfully");
		
		CommonMethod.testlog("Pass","Test started verifying carbon textarea");
		CommonMethod.clear("CTextBox");
		CommonMethod.click("CTextBox");
		CommonMethod.highLightElement("CTextBox");
		CommonMethod.sendKeys("CTextBox",ctextbox);
		CommonMethod.click("CarbonCProgress");
		CommonMethod.driverwait(2);
		CommonMethod.assertcontainsattributevalue("CTextBox", ctextbox, "Not Valid");	
		CommonMethod.testlog("Pass","Test passed verified carbon textarea successfully");		
		
	}
	public void goalWaste(String sheetName, int rowNum,String pGoal) throws IOException, InterruptedException {		

		String cpReduction 		= data.getCellData(sheetName, "CPReduction", rowNum);
		String cbValue 	= data.getCellData(sheetName, "CBValue", rowNum);
		String cUnit 	= data.getCellData(sheetName, "Cunit", rowNum);
		String ctextbox 	= data.getCellData(sheetName,"CTextBox", rowNum);	
		CommonMethod.driverwait(1);
		
		CommonMethod.ArcSpecifictoggle(pGoal);
		CommonMethod.testlog("Pass", "Filling carbon reduction percentage value");
		CommonMethod.clear("CarbonPReduction");
		CommonMethod.sendKeys("CarbonPReduction",cpReduction);
		CommonMethod.testlog("Pass", "Filling carbon baseline value");
		CommonMethod.clear("CarbonBValue");
		CommonMethod.sendKeys("CarbonBValue",cbValue);
		   
        CommonMethod.testlog("Pass", "Test started verifying carbon unit MTCO2E");
        String mtco2e = CommonMethod.getText("CMTCO2e");
        System.out.println(mtco2e);
        Assert.assertEquals(mtco2e,cUnit);
		CommonMethod.testlog("Pass", "Test passed verified carbon unit  MTCO2E successfully");
		
		CommonMethod.testlog("Pass", "Test Started Carbon differece of goal calcation");
		String forntenddiffGoal = CommonMethod.getText("CDFormGoal");
		CommonMethod.highLightElement("CDFormGoal");
		String currentProgress=CommonMethod.getText("CarbonCProgress");
		System.out.println(currentProgress);
		CommonMethod.highLightElement("CarbonCProgress");
		String replace = currentProgress.replace("%" , "");
		double replace1=Double.parseDouble(replace);
		double result1 =replace1-100;
		//NumberFormat formatter = new result("#000.00");
		BigDecimal result2 = new BigDecimal(result1);     
		result2 =  result2 .setScale(2, RoundingMode.HALF_UP);
        String calcalteddiffGoal = result2 + " %";  
        System.out.println(calcalteddiffGoal);  
		Assert.assertEquals(forntenddiffGoal, calcalteddiffGoal);
		CommonMethod.testlog("Pass", "Test passed verified differece goal successfully");
						
		CommonMethod.testlog("Pass","Test started verifying acheive goal in percentage");
		String carbonGoal = CommonMethod.getText("CarbonGoal");
        String greplace = carbonGoal.replace("%" , "");
		double cGexpected=Double.parseDouble(greplace);
		System.out.println(cGexpected);
		double cGactual = 100/2;
		System.out.println(cGactual);
		Assert.assertEquals(cGactual, cGexpected);
		CommonMethod.testlog("Pass","Test passed verified acheive goal percentage successfully");
		
		CommonMethod.testlog("Pass","Test started verifying carbon textarea");
		CommonMethod.clear("CTextBox");
		CommonMethod.click("CTextBox");
		CommonMethod.highLightElement("CTextBox");
		CommonMethod.sendKeys("CTextBox",ctextbox);
		CommonMethod.click("CarbonCProgress");
		CommonMethod.driverwait(2);
		CommonMethod.assertcontainsattributevalue("CTextBox", ctextbox, "Not Valid");	
		CommonMethod.testlog("Pass","Test passed verified carbon textarea successfully");		
		
	}
	public void goalTransport(String sheetName, int rowNum,String pGoal) throws IOException, InterruptedException {		

		String cpReduction 		= data.getCellData(sheetName, "CPReduction", rowNum);
		String cbValue 	= data.getCellData(sheetName, "CBValue", rowNum);
		String cUnit 	= data.getCellData(sheetName, "Cunit", rowNum);
		String ctextbox 	= data.getCellData(sheetName,"CTextBox", rowNum);	
		CommonMethod.driverwait(1);
		
		CommonMethod.ArcSpecifictoggle(pGoal);
		CommonMethod.testlog("Pass", "Filling carbon reduction percentage value");
		CommonMethod.clear("CarbonPReduction");
		CommonMethod.sendKeys("CarbonPReduction",cpReduction);
		CommonMethod.testlog("Pass", "Filling carbon baseline value");
		CommonMethod.clear("CarbonBValue");
		CommonMethod.sendKeys("CarbonBValue",cbValue);
		   
        CommonMethod.testlog("Pass", "Test started verifying carbon unit MTCO2E");
        String mtco2e = CommonMethod.getText("CMTCO2e");
        System.out.println(mtco2e);
        Assert.assertEquals(mtco2e,cUnit);
		CommonMethod.testlog("Pass", "Test passed verified carbon unit  MTCO2E successfully");
		
		CommonMethod.testlog("Pass", "Test Started Carbon differece of goal calcation");
		String forntenddiffGoal = CommonMethod.getText("CDFormGoal");
		CommonMethod.highLightElement("CDFormGoal");
		String currentProgress=CommonMethod.getText("CarbonCProgress");
		System.out.println(currentProgress);
		CommonMethod.highLightElement("CarbonCProgress");
		String replace = currentProgress.replace("%" , "");
		double replace1=Double.parseDouble(replace);
		double result1 =replace1-100;
		//NumberFormat formatter = new result("#000.00");
		BigDecimal result2 = new BigDecimal(result1);     
		result2 =  result2 .setScale(2, RoundingMode.HALF_UP);
        String calcalteddiffGoal = result2 + " %";  
        System.out.println(calcalteddiffGoal);  
		Assert.assertEquals(forntenddiffGoal, calcalteddiffGoal);
		CommonMethod.testlog("Pass", "Test passed verified differece goal successfully");
						
		CommonMethod.testlog("Pass","Test started verifying acheive goal in percentage");
		String carbonGoal = CommonMethod.getText("CarbonGoal");
        String greplace = carbonGoal.replace("%" , "");
		double cGexpected=Double.parseDouble(greplace);
		System.out.println(cGexpected);
		double cGactual = 100/2;
		System.out.println(cGactual);
		Assert.assertEquals(cGactual, cGexpected);
		CommonMethod.testlog("Pass","Test passed verified acheive goal percentage successfully");
		
		CommonMethod.testlog("Pass","Test started verifying carbon textarea");
		CommonMethod.clear("CTextBox");
		CommonMethod.click("CTextBox");
		CommonMethod.highLightElement("CTextBox");
		CommonMethod.sendKeys("CTextBox",ctextbox);
		CommonMethod.click("CarbonCProgress");
		CommonMethod.driverwait(2);
		CommonMethod.assertcontainsattributevalue("CTextBox", ctextbox, "Not Valid");	
		CommonMethod.testlog("Pass","Test passed verified carbon textarea successfully");		
		
	}
	public void goalHumanExp(String sheetName, int rowNum,String pGoal) throws IOException, InterruptedException {		

		String cpReduction 		= data.getCellData(sheetName, "CPReduction", rowNum);
		String cbValue 	= data.getCellData(sheetName, "CBValue", rowNum);
		String cUnit 	= data.getCellData(sheetName, "Cunit", rowNum);
		String ctextbox 	= data.getCellData(sheetName,"CTextBox", rowNum);	
		CommonMethod.driverwait(1);
		
		CommonMethod.ArcSpecifictoggle(pGoal);
		CommonMethod.testlog("Pass", "Filling carbon reduction percentage value");
		CommonMethod.clear("CarbonPReduction");
		CommonMethod.sendKeys("CarbonPReduction",cpReduction);
		CommonMethod.testlog("Pass", "Filling carbon baseline value");
		CommonMethod.clear("CarbonBValue");
		CommonMethod.sendKeys("CarbonBValue",cbValue);
		   
        CommonMethod.testlog("Pass", "Test started verifying carbon unit MTCO2E");
        String mtco2e = CommonMethod.getText("CMTCO2e");
        System.out.println(mtco2e);
        Assert.assertEquals(mtco2e,cUnit);
		CommonMethod.testlog("Pass", "Test passed verified carbon unit  MTCO2E successfully");
		
		CommonMethod.testlog("Pass", "Test Started Carbon differece of goal calcation");
		String forntenddiffGoal = CommonMethod.getText("CDFormGoal");
		CommonMethod.highLightElement("CDFormGoal");
		String currentProgress=CommonMethod.getText("CarbonCProgress");
		System.out.println(currentProgress);
		CommonMethod.highLightElement("CarbonCProgress");
		String replace = currentProgress.replace("%" , "");
		double replace1=Double.parseDouble(replace);
		double result1 =replace1-100;
		//NumberFormat formatter = new result("#000.00");
		BigDecimal result2 = new BigDecimal(result1);     
		result2 =  result2 .setScale(2, RoundingMode.HALF_UP);
        String calcalteddiffGoal = result2 + " %";  
        System.out.println(calcalteddiffGoal);  
		Assert.assertEquals(forntenddiffGoal, calcalteddiffGoal);
		CommonMethod.testlog("Pass", "Test passed verified differece goal successfully");
						
		CommonMethod.testlog("Pass","Test started verifying acheive goal in percentage");
		String carbonGoal = CommonMethod.getText("CarbonGoal");
        String greplace = carbonGoal.replace("%" , "");
		double cGexpected=Double.parseDouble(greplace);
		System.out.println(cGexpected);
		double cGactual = 100/2;
		System.out.println(cGactual);
		Assert.assertEquals(cGactual, cGexpected);
		CommonMethod.testlog("Pass","Test passed verified acheive goal percentage successfully");
		
		CommonMethod.testlog("Pass","Test started verifying carbon textarea");
		CommonMethod.clear("CTextBox");
		CommonMethod.click("CTextBox");
		CommonMethod.highLightElement("CTextBox");
		CommonMethod.sendKeys("CTextBox",ctextbox);
		CommonMethod.click("CarbonCProgress");
		CommonMethod.driverwait(2);
		CommonMethod.assertcontainsattributevalue("CTextBox", ctextbox, "Not Valid");	
		CommonMethod.testlog("Pass","Test passed verified carbon textarea successfully");		
		
	}
	public void goalCertification(String sheetName, int rowNum,String pGoal) throws IOException, InterruptedException {		

		String cpReduction 		= data.getCellData(sheetName, "CPReduction", rowNum);
		String cbValue 	= data.getCellData(sheetName, "CBValue", rowNum);
		String cUnit 	= data.getCellData(sheetName, "Cunit", rowNum);
		String ctextbox 	= data.getCellData(sheetName,"CTextBox", rowNum);	
		CommonMethod.driverwait(1);
		
		CommonMethod.ArcSpecifictoggle(pGoal);
		CommonMethod.testlog("Pass", "Filling carbon reduction percentage value");
		CommonMethod.clear("CarbonPReduction");
		CommonMethod.sendKeys("CarbonPReduction",cpReduction);
		CommonMethod.testlog("Pass", "Filling carbon baseline value");
		CommonMethod.clear("CarbonBValue");
		CommonMethod.sendKeys("CarbonBValue",cbValue);
		   
        CommonMethod.testlog("Pass", "Test started verifying carbon unit MTCO2E");
        String mtco2e = CommonMethod.getText("CMTCO2e");
        System.out.println(mtco2e);
        Assert.assertEquals(mtco2e,cUnit);
		CommonMethod.testlog("Pass", "Test passed verified carbon unit  MTCO2E successfully");
		
		CommonMethod.testlog("Pass", "Test Started Carbon differece of goal calcation");
		String forntenddiffGoal = CommonMethod.getText("CDFormGoal");
		CommonMethod.highLightElement("CDFormGoal");
		String currentProgress=CommonMethod.getText("CarbonCProgress");
		System.out.println(currentProgress);
		CommonMethod.highLightElement("CarbonCProgress");
		String replace = currentProgress.replace("%" , "");
		double replace1=Double.parseDouble(replace);
		double result1 =replace1-100;
		//NumberFormat formatter = new result("#000.00");
		BigDecimal result2 = new BigDecimal(result1);     
		result2 =  result2 .setScale(2, RoundingMode.HALF_UP);
        String calcalteddiffGoal = result2 + " %";  
        System.out.println(calcalteddiffGoal);  
		Assert.assertEquals(forntenddiffGoal, calcalteddiffGoal);
		CommonMethod.testlog("Pass", "Test passed verified differece goal successfully");
						
		CommonMethod.testlog("Pass","Test started verifying acheive goal in percentage");
		String carbonGoal = CommonMethod.getText("CarbonGoal");
        String greplace = carbonGoal.replace("%" , "");
		double cGexpected=Double.parseDouble(greplace);
		System.out.println(cGexpected);
		double cGactual = 100/2;
		System.out.println(cGactual);
		Assert.assertEquals(cGactual, cGexpected);
		CommonMethod.testlog("Pass","Test passed verified acheive goal percentage successfully");
		
		CommonMethod.testlog("Pass","Test started verifying carbon textarea");
		CommonMethod.clear("CTextBox");
		CommonMethod.click("CTextBox");
		CommonMethod.highLightElement("CTextBox");
		CommonMethod.sendKeys("CTextBox",ctextbox);
		CommonMethod.click("CarbonCProgress");
		CommonMethod.driverwait(2);
		CommonMethod.assertcontainsattributevalue("CTextBox", ctextbox, "Not Valid");	
		CommonMethod.testlog("Pass","Test passed verified carbon textarea successfully");		
		
	}

	public void goalWater(String sheetName, int rowNum,String pGoal) throws IOException, InterruptedException {		

		String cpReduction 		= data.getCellData(sheetName, "CPReduction", rowNum);
		String cbValue 	= data.getCellData(sheetName, "CBValue", rowNum);
		String cUnit 	= data.getCellData(sheetName, "Cunit", rowNum);
		String ctextbox 	= data.getCellData(sheetName,"CTextBox", rowNum);	
		CommonMethod.driverwait(1);
		
		CommonMethod.ArcSpecifictoggle(pGoal);
		CommonMethod.testlog("Pass", "Filling carbon reduction percentage value");
		CommonMethod.clear("CarbonPReduction");
		CommonMethod.sendKeys("CarbonPReduction",cpReduction);
		CommonMethod.testlog("Pass", "Filling carbon baseline value");
		CommonMethod.clear("CarbonBValue");
		CommonMethod.sendKeys("CarbonBValue",cbValue);
		   
        CommonMethod.testlog("Pass", "Test started verifying carbon unit MTCO2E");
        String mtco2e = CommonMethod.getText("CMTCO2e");
        System.out.println(mtco2e);
        Assert.assertEquals(mtco2e,cUnit);
		CommonMethod.testlog("Pass", "Test passed verified carbon unit  MTCO2E successfully");
		
		CommonMethod.testlog("Pass", "Test Started Carbon differece of goal calcation");
		String forntenddiffGoal = CommonMethod.getText("CDFormGoal");
		CommonMethod.highLightElement("CDFormGoal");
		String currentProgress=CommonMethod.getText("CarbonCProgress");
		System.out.println(currentProgress);
		CommonMethod.highLightElement("CarbonCProgress");
		String replace = currentProgress.replace("%" , "");
		double replace1=Double.parseDouble(replace);
		double result1 =replace1-100;
		//NumberFormat formatter = new result("#000.00");
		BigDecimal result2 = new BigDecimal(result1);     
		result2 =  result2 .setScale(2, RoundingMode.HALF_UP);
        String calcalteddiffGoal = result2 + " %";  
        System.out.println(calcalteddiffGoal);  
		Assert.assertEquals(forntenddiffGoal, calcalteddiffGoal);
		CommonMethod.testlog("Pass", "Test passed verified differece goal successfully");
						
		CommonMethod.testlog("Pass","Test started verifying acheive goal in percentage");
		String carbonGoal = CommonMethod.getText("CarbonGoal");
        String greplace = carbonGoal.replace("%" , "");
		double cGexpected=Double.parseDouble(greplace);
		System.out.println(cGexpected);
		double cGactual = 100/2;
		System.out.println(cGactual);
		Assert.assertEquals(cGactual, cGexpected);
		CommonMethod.testlog("Pass","Test passed verified acheive goal percentage successfully");
		
		CommonMethod.testlog("Pass","Test started verifying carbon textarea");
		CommonMethod.clear("CTextBox");
		CommonMethod.click("CTextBox");
		CommonMethod.highLightElement("CTextBox");
		CommonMethod.sendKeys("CTextBox",ctextbox);
		CommonMethod.click("CarbonCProgress");
		CommonMethod.driverwait(2);
		CommonMethod.assertcontainsattributevalue("CTextBox", ctextbox, "Not Valid");	
		CommonMethod.testlog("Pass","Test passed verified carbon textarea successfully");		
		
	}

	public void goalEnergy(String sheetName, int rowNum,String pGoal) throws IOException, InterruptedException {		

		String cpReduction 		= data.getCellData(sheetName, "CPReduction", rowNum);
		String cbValue 	= data.getCellData(sheetName, "CBValue", rowNum);
		String cUnit 	= data.getCellData(sheetName, "Cunit", rowNum);
		String ctextbox 	= data.getCellData(sheetName,"CTextBox", rowNum);	
		CommonMethod.driverwait(1);
		
		CommonMethod.ArcSpecifictoggle(pGoal);
		CommonMethod.testlog("Pass", "Filling carbon reduction percentage value");
		CommonMethod.clear("CarbonPReduction");
		CommonMethod.sendKeys("CarbonPReduction",cpReduction);
		CommonMethod.testlog("Pass", "Filling carbon baseline value");
		CommonMethod.clear("CarbonBValue");
		CommonMethod.sendKeys("CarbonBValue",cbValue);
		   
        CommonMethod.testlog("Pass", "Test started verifying carbon unit MTCO2E");
        String mtco2e = CommonMethod.getText("CMTCO2e");
        System.out.println(mtco2e);
        Assert.assertEquals(mtco2e,cUnit);
		CommonMethod.testlog("Pass", "Test passed verified carbon unit  MTCO2E successfully");
		
		CommonMethod.testlog("Pass", "Test Started Carbon differece of goal calcation");
		String forntenddiffGoal = CommonMethod.getText("CDFormGoal");
		CommonMethod.highLightElement("CDFormGoal");
		String currentProgress=CommonMethod.getText("CarbonCProgress");
		System.out.println(currentProgress);
		CommonMethod.highLightElement("CarbonCProgress");
		String replace = currentProgress.replace("%" , "");
		double replace1=Double.parseDouble(replace);
		double result1 =replace1-100;
		//NumberFormat formatter = new result("#000.00");
		BigDecimal result2 = new BigDecimal(result1);     
		result2 =  result2 .setScale(2, RoundingMode.HALF_UP);
        String calcalteddiffGoal = result2 + " %";  
        System.out.println(calcalteddiffGoal);  
		Assert.assertEquals(forntenddiffGoal, calcalteddiffGoal);
		CommonMethod.testlog("Pass", "Test passed verified differece goal successfully");
						
		CommonMethod.testlog("Pass","Test started verifying acheive goal in percentage");
		String carbonGoal = CommonMethod.getText("CarbonGoal");
        String greplace = carbonGoal.replace("%" , "");
		double cGexpected=Double.parseDouble(greplace);
		System.out.println(cGexpected);
		double cGactual = 100/2;
		System.out.println(cGactual);
		Assert.assertEquals(cGactual, cGexpected);
		CommonMethod.testlog("Pass","Test passed verified acheive goal percentage successfully");
		
		CommonMethod.testlog("Pass","Test started verifying carbon textarea");
		CommonMethod.clear("CTextBox");
		CommonMethod.click("CTextBox");
		CommonMethod.highLightElement("CTextBox");
		CommonMethod.sendKeys("CTextBox",ctextbox);
		CommonMethod.click("CarbonCProgress");
		CommonMethod.driverwait(2);
		CommonMethod.assertcontainsattributevalue("CTextBox", ctextbox, "Not Valid");	
		CommonMethod.testlog("Pass","Test passed verified carbon textarea successfully");		
		
	}

	public void totalcarbonConsumpation(String param) throws IOException, InterruptedException {
   	    CommonMethod.ArcSpecifictoggle( "PAnalytics");
   	    CommonMethod.driverwait(2);
   	    CommonMethod.click(param);
  	    CommonMethod.driverwait(2);
  	    
  	    String  aTotalCarbon=CommonMethod.getText( "ACMTCO2e"); 	    
        System.out.println(aTotalCarbon);
        double acmtco2e =Double.parseDouble(aTotalCarbon);   
        String avgOccupanit = CommonMethod.getText("AOccupanit");
        String repavgOccupanit  = avgOccupanit.replace(" occupants", "");
        double favgOccupanit_proj =Double.parseDouble(repavgOccupanit);    
        String avg_sqarefoot = CommonMethod.getText("AvgSqaurefoot");
        String avg_sqarefoot1  = avg_sqarefoot.replace(" sf", "");
        double avg_sqarefoot2 =Double.parseDouble(avg_sqarefoot1);
        System.out.println(avg_sqarefoot2);  
        CommonMethod.driverwait(2);
        CommonMethod.click("PCarbon");
        CommonMethod.driverwait(2);
        
        CommonMethod.testlog("Pass", "Test started verifying 2018 Reduction Targets");   
		String carbonGoal = CommonMethod.getText("CarbonGoal");
        String greplace = carbonGoal.replace("%" , "");
		double cGoalPercetage=Double.parseDouble(greplace);
		System.out.println(cGoalPercetage);
		double result =((acmtco2e) * (cGoalPercetage * 2))/100;
		BigDecimal cGoalPercentage = new BigDecimal(result);     
		cGoalPercentage =  cGoalPercentage .setScale(2, RoundingMode.HALF_UP);	
		String areductionTarget = CommonMethod.getText("RTarget");	
	    double areductionTarget1 = Double.parseDouble(areductionTarget);
	    BigDecimal areductionTarget2 = new BigDecimal(areductionTarget1);     
	    areductionTarget2 =  areductionTarget2 .setScale(2, RoundingMode.HALF_UP);	
		Assert.assertEquals(areductionTarget2, cGoalPercentage);	
		System.out.println(areductionTarget2);
		System.out.println(cGoalPercentage);	
		CommonMethod.testlog("Pass", "verifyed 2018 Reduction Targets");
		
		CommonMethod.testlog("Pass","Test started verifying average occpant per project");
		String totalNoOccupaint = CommonMethod.getText("AverageOccupant");
		double expavgmtco2_peroccupant = Double.parseDouble(totalNoOccupaint);
		BigDecimal expavgmtco2_peroccupant1 = new BigDecimal(expavgmtco2_peroccupant); 
		expavgmtco2_peroccupant1 = expavgmtco2_peroccupant1.setScale(4, RoundingMode.HALF_UP);
		double occupancyCalcuation = (acmtco2e / favgOccupanit_proj);		
		BigDecimal avgmtco2_peroccupant = new BigDecimal(occupancyCalcuation); 
		avgmtco2_peroccupant = avgmtco2_peroccupant.setScale(4, RoundingMode.HALF_UP);	
		System.out.println(avgmtco2_peroccupant);
		System.out.println(expavgmtco2_peroccupant1);
		Assert.assertEquals(avgmtco2_peroccupant, expavgmtco2_peroccupant1);
		CommonMethod.testlog("Pass","verified average occpant per project successully");
		
		CommonMethod.testlog("Pass","Test started verifying average sqaure feet per project");
		String avg_squarefoot = CommonMethod.getText("CAvgSqaurefoot");
		System.out.println(avg_squarefoot);
		double avg_squarefoot1 = Double.parseDouble(avg_squarefoot);
		BigDecimal avg_squarefoot2 = new BigDecimal(avg_squarefoot1); 
		avg_squarefoot2 = avg_squarefoot2.setScale(4, RoundingMode.HALF_UP);
		System.out.println(avg_squarefoot);
		double cavg_squarefoot = (acmtco2e / avg_sqarefoot2);		
		BigDecimal cavg_squarefoot1 = new BigDecimal(cavg_squarefoot); 
		cavg_squarefoot1 = cavg_squarefoot1.setScale(4, RoundingMode.HALF_UP);	
		System.out.println(avg_squarefoot2);
		System.out.println(cavg_squarefoot1);
		Assert.assertEquals(avg_squarefoot2, cavg_squarefoot1);
		CommonMethod.testlog("Pass"," verified average sqaure feet per project successully");		
		 	    

	}
	
	 public void verifyEDailiyMTCO2e(String param) throws IOException, InterruptedException{
	   	    CommonMethod.ArcSpecifictoggle( "PAnalytics");
	   	    CommonMethod.click(param);
	    
	  	    CommonMethod.driverwait(2);    
	        CommonMethod.testlog( "Pass","TEST STARTED ENERGY PROJECT(TOTAL DAILY CARBON EMISSIONS=TOTAL ANNUAL CARBON EMISSIONS/365)");
	    	String  str1=CommonMethod.getText( "Anualcarbon");
	        System.out.println(str1);
	        double d1=Double.parseDouble(str1);  
	        double edaily=d1/365; 
	        BigDecimal pden = new BigDecimal(edaily);     
            pden = pden.setScale(4, RoundingMode.HALF_UP);    
	        System.out.println(pden);
	    	String dailyCarbon =CommonMethod.getText("Dailycarbon");
	    	Thread.sleep(1000);
	    	String str2= new String(dailyCarbon);
	    	System.out.println(dailyCarbon);
	    	double d3=Double.parseDouble(str2);
	    	BigDecimal pden1 = new BigDecimal(d3);     
	        pden1 = pden.setScale(4, RoundingMode.HALF_UP); 
	    	System.out.println(pden);
	   	    System.out.println(pden1);
	    	Assert.assertEquals(pden,pden1);
	    	CommonMethod.testlog( "Pass", "Verified Project Energy Daily Carbon Emissions successully");
	    	CommonMethod.testlog( "Pass", "Test Passed");
	    	
	    	CommonMethod.testlog( "Pass","TEST STARTED ENERGY PER SQ FT(TOTAL DAILY CARBON EMISSIONS=TOTAL ANNUAL CARBON EMISSIONS/365)");
		    String  pstr1=CommonMethod.getText( "PAnualcarbon");
		    System.out.println(pstr1);
		    double epdaily=Double.parseDouble(pstr1)/365;    
		    BigDecimal epden = new BigDecimal(epdaily);     
	        epden = epden.setScale(4, RoundingMode.HALF_UP);    
		    System.out.println(epden);	
		    String epdailyCarbon =CommonMethod.getText("PDailycarbon");
		    Thread.sleep(1000);
		    double epdailyCarbon1 =Double.parseDouble(epdailyCarbon);	
		    BigDecimal epden1 = new BigDecimal(epdailyCarbon1);     
		    epden1 = epden1.setScale(4, RoundingMode.HALF_UP); 	
		   	System.out.println(epden);
		   	System.out.println(epden1);
		    Assert.assertEquals(epden,epden1);
		    CommonMethod.testlog( "Pass", "Verified PER SQ FT DAILY ADJUSTED CARBON EMISSIONS (MTCO2e)");
		    CommonMethod.testlog( "Pass", "Test Passed");
		    
			CommonMethod.testlog( "Pass","TEST STARTED ENERGY PER OCC(TOTAL DAILY CARBON EMISSIONS=TOTAL ANNUAL CARBON EMISSIONS/365)");
		    String  ostr1=CommonMethod.getText( "OAnualcarbon");
		    System.out.println(ostr1);
		    double eodaily=Double.parseDouble(ostr1)/365;    
		    BigDecimal eoden = new BigDecimal(eodaily);     
	        eoden = eoden.setScale(4, RoundingMode.HALF_UP);      
		    String eodailyCarbon =CommonMethod.getText("ODailycarbon");
		    Thread.sleep(1000);
		    double eodailyCarbon1 =Double.parseDouble(eodailyCarbon);	
		    BigDecimal eoden1 = new BigDecimal(eodailyCarbon1);     
		    eoden1 = eoden1.setScale(4, RoundingMode.HALF_UP); 	
		   	System.out.println(eoden);
		   	System.out.println(eoden1);
		    Assert.assertEquals(eoden,eoden1);
		    CommonMethod.testlog( "Pass", "Verified PER OCC DAILY ADJUSTED CARBON EMISSIONS (MTCO2e) Successfully");
		    		    	
}
	 public void verifyWDailiyMTCO2e(String param) throws IOException, InterruptedException{
	  	   
		   CommonMethod.ArcSpecifictoggle( "PAnalytics");
	   	   CommonMethod.click(param);
	    
	  	   CommonMethod.driverwait(2);    
	    
	       CommonMethod.testlog( "Pass","TEST STARTED WATER PROJECT(TOTAL DAILY CARBON EMISSIONS=TOTAL ANNUAL CARBON EMISSIONS/365)");
	   	   String  str1=CommonMethod.getText( "WAnualcarbon");
	       System.out.println(str1);
	       double d1=Double.parseDouble(str1);  
	       double edaily=d1/365; 
	       System.out.println(edaily);
	       
	      BigDecimal pden = new BigDecimal(edaily);     
	      pden = pden.setScale(4, RoundingMode.HALF_UP);    
	      System.out.println(pden);
	   	  String dailyCarbon =CommonMethod.getText("WDailycarbon");
	      Thread.sleep(1000);
	   	  String str2= new String(dailyCarbon);
	   	  System.out.println(dailyCarbon);
	   	  double d3=Double.parseDouble(str2);
	   	  BigDecimal pden1 = new BigDecimal(d3);     
	      pden1 = pden.setScale(4, RoundingMode.HALF_UP); 
	      System.out.println(pden);
	  	  System.out.println(pden1);
	   	  Assert.assertEquals(pden,pden1);
	   	  CommonMethod.testlog( "Pass", "Verified Project Water Daily Carbon Emissions successully");
	      CommonMethod.testlog( "Pass", "Test Passed");
	       
	       
	   		CommonMethod.testlog( "Pass","TEST STARTED Water PER SQ FT(TOTAL DAILY CARBON EMISSIONS=TOTAL ANNUAL CARBON EMISSIONS/365)");
		    String  pstr1=CommonMethod.getText( "WPAnualcarbon");
		    System.out.println(pstr1);
		    double epdaily=Double.parseDouble(pstr1)/365;    
		    BigDecimal epden = new BigDecimal(epdaily);     
	        epden = epden.setScale(4, RoundingMode.HALF_UP);    
		    System.out.println(epden);	
		    String epdailyCarbon =CommonMethod.getText("WPDailycarbon");
		    Thread.sleep(1000);
		    double epdailyCarbon1 =Double.parseDouble(epdailyCarbon);	
		    BigDecimal epden1 = new BigDecimal(epdailyCarbon1);     
		    epden1 = epden1.setScale(4, RoundingMode.HALF_UP); 	
		   	System.out.println(epden);
		   	System.out.println(epden1);
		    Assert.assertEquals(epden,epden1);
		    CommonMethod.testlog( "Pass", "Verified Water PER SQ FT DAILY ADJUSTED CARBON EMISSIONS (MTCO2e)");
		    CommonMethod.testlog( "Pass", "Test Passed");
		    
			CommonMethod.testlog( "Pass","TEST STARTED Water PER OCC(TOTAL DAILY CARBON EMISSIONS=TOTAL ANNUAL CARBON EMISSIONS/365)");
		    String  ostr1=CommonMethod.getText( "WOAnualcarbon");
		    System.out.println(ostr1);
		    double eodaily=Double.parseDouble(ostr1)/365;    
		    BigDecimal eoden = new BigDecimal(eodaily);     
	        eoden = eoden.setScale(4, RoundingMode.HALF_UP);      
		    String eodailyCarbon =CommonMethod.getText("WODailycarbon");
		    Thread.sleep(1000);
		    double eodailyCarbon1 =Double.parseDouble(eodailyCarbon);	
		    BigDecimal eoden1 = new BigDecimal(eodailyCarbon1);     
		    eoden1 = eoden1.setScale(4, RoundingMode.HALF_UP); 	
		   	System.out.println(eoden);
		   	System.out.println(eoden1);
		    Assert.assertEquals(eoden,eoden1);
		    CommonMethod.testlog( "Pass", "Verified Water PER OCC DAILY ADJUSTED CARBON EMISSIONS (MTCO2e) Successfully");
		    	
	   	
	}
}