package com.qa.testcases;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import com.qa.ExtentReportListener.ExtentTestManager;
import com.qa.pageObjects.AssosiciatePortal.CommonActivities_Assosiciate;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import com.qa.base.TestBase;




public class Associate_EmailEdit extends TestBase {
	//CommonActivities_Assosiciate commonActivities_Assosiciate;
    CommonActivities_Assosiciate commonActivities_Assosiciate;
	//@Parameters("browser")
	@BeforeTest
	public void initilizeAllPreRequsites() throws MalformedURLException
	{
		//driver = getWebdriverOf(browser);
		//b1=browser;
		initialization();
		 driver=getDriver();
		//commonActivities_Assosiciate= new CommonActivities_Assosiciate();
        commonActivities_Assosiciate = new CommonActivities_Assosiciate();

	}
	
	@BeforeMethod
	public void getBrowserSetUp() throws MalformedURLException{
		driver.get("https://tacqa.credagility.com/agent/security/login");
	}

	@Test
	public void Associate_EmailEditTest() throws InterruptedException
	{
		
		try {
			ExtentTestManager.getTest().setDescription("Associate_EmailEdit Test Execution");
            commonActivities_Assosiciate.loginToAssociatePortal();
			//lf Pavy,C
		//	searchForCostumerUsingFirstameLastName("lf Riteley,P");
//			addEmailInOtherCateogryAndUpdate();
//			editAndUpdateEmailInOtherCateogry();
//			deleteEnteredEmailInOtherCateogary();
//			disposeAccount_SelectingPaymentOffer_SubmitAndColseAccount();
			commonActivities_Assosiciate.logoutFromAssociatePortal();
		} catch (NoSuchElementException e ) {
			LogFailureReasonsInExtentReports("Test Failed unExpectedly due to NoSuchElementException");
			e.printStackTrace();
		}catch (WebDriverException e1){
			LogFailureReasonsInExtentReports("Test Failed unExpectedly due to WebDriverException");
			e1.printStackTrace();
		}
	}

	@AfterTest
	public void closeBrowser()
	{
		if (driver!=null)
		driver.quit();
	}
	
}
