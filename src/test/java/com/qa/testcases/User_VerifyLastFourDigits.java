package com.qa.testcases;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import com.qa.ExtentReportListener.ExtentTestManager;
import com.qa.pageObjects.CustomerPortal.CommonActivities_Customer;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pageObjects.CustomerPortal.User_AccountSummaryPageObjects;
import com.qa.pageObjects.CustomerPortal.User_LandingPageObjects;



public class User_VerifyLastFourDigits extends TestBase {

	CommonActivities_Customer commonActivities_Customer=null;



	//@Parameters("browser")
	@BeforeTest
	public void browseGmail() throws MalformedURLException {
		initialization();
		//WebDriver driver=getDriver();
		//driver = getWebdriverOf(browser);
		commonActivities_Customer= new CommonActivities_Customer();
	}

	@Test
	public void User_VerifyLastFourDigits() throws InterruptedException
	{
		try {
			OpenURL("https://tacqa.credagility.com/security/login");
			commonActivities_Customer.logintoCustomerPortal();
			Thread.sleep(10000);
			String last4DigitsExtracted=User_AccountSummaryPage.getLastFourDigits();
			Assert.assertEquals("-1727", last4DigitsExtracted);
			commonActivities_Customer.logoutFromCustomerPortal();
		} catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed unfortuately",
                    ExtentTestManager.getTest().addBase64ScreenShot(getScreenShot()));
            e.printStackTrace();
		}
	}
	
	@AfterTest
	public void closeBrowser()
	{
		if (driver!=null)
	    driver.close();
	}
	
}
