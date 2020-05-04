package com.qa.testcases;

import java.net.MalformedURLException;

import com.qa.ExtentReportListener.ExtentTestManager;
import com.qa.pageObjects.StrategistPortal.CommonActivities_Strategist;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;


public class AgentLoginLogout extends TestBase {
    CommonActivities_Strategist commonActivities_Agent=null;
	//@Parameters("browser")
	@BeforeTest
	public void browseGmail() throws MalformedURLException {
		initialization();
		 driver=getDriver();
		//driver = getWebdriverOf(browser);
		commonActivities_Agent= new CommonActivities_Strategist();
	}

	@Test
	public void Agent_LoginLogout() throws InterruptedException
	{

		try {
			commonActivities_Agent.openAdminPortal("https://tacqa.credagility.com/agent/security/login");
			commonActivities_Agent.loginToAdminPortal();
			commonActivities_Agent.logoutFromAdminPortal();
		} catch (Exception e) {
			// TODO: handle exception
            ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed unfortuately",
                    ExtentTestManager.getTest().addBase64ScreenShot(getScreenShot()));
		}

	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
	
}
