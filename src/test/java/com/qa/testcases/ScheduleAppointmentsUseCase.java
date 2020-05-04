package com.qa.testcases;

import java.net.MalformedURLException;

import com.qa.ExtentReportListener.ExtentTestManager;
import com.qa.pageObjects.CustomerPortal.CommonActivities_Customer;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pageObjects.CustomerPortal.User_AccountSummaryPageObjects;
import com.qa.pageObjects.CustomerPortal.User_LandingPageObjects;
import com.qa.pageObjects.CustomerPortal.User_ScheduleAppointmentsPageObjects;



public class ScheduleAppointmentsUseCase extends TestBase {

	CommonActivities_Customer commonActivities_Customer=null;
	//@Parameters("browser")
	@BeforeTest
	public void initilizeAllPreRequsites() throws MalformedURLException
	{
//		 driver = getWebdriverOf(browser);
//		 b1=browser;
		initialization();
		 driver=getDriver();
		commonActivities_Customer=new CommonActivities_Customer();
	}


	@Test
	public void User_ScheduleAppointmentsUseCase() throws InterruptedException
	{
		
		try {
            commonActivities_Customer.openCustomerPortal("https://tacqa.credagility.com/security/login");
			commonActivities_Customer.logintoCustomerPortal();
			commonActivities_Customer.createAnAppointment();
			commonActivities_Customer.editAnAppointment();
			commonActivities_Customer.deleteTheCreatedAppointmet();
			commonActivities_Customer.logoutFromCustomerPortal();

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
		driver.quit();
	}
	
}
