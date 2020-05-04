package com.qa.testcases;

import com.qa.ExtentReportListener.ExtentTestManager;
import com.qa.base.TestBase;
import com.qa.pageObjects.StrategistPortal.CommonActivities_Strategist;
import com.qa.pageObjects.AssosiciatePortal.CommonActivities_Assosiciate;
import com.qa.pageObjects.CustomerPortal.CommonActivities_Customer;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AllPoratalDemoScenario extends TestBase {
    CommonActivities_Strategist commonActivities_Strategist=null;
    CommonActivities_Assosiciate commonActivities_Assosiciate=null;
    CommonActivities_Customer commonActivities_Customer=null;

   // @Parameters("browser")
    @BeforeTest
    public void browseGmail(  ) throws MalformedURLException {
        //initialization();
        //driver=getDriver();
       driver = getWebdriverOf(browser_currennt);
        commonActivities_Strategist= new CommonActivities_Strategist();
        commonActivities_Assosiciate= new CommonActivities_Assosiciate();
        commonActivities_Customer= new CommonActivities_Customer();
    }

    @Test
    public void AllPortalScenario() throws InterruptedException
    {
        try {
            commonActivities_Strategist.openAdminPortal(Strategist_url);
            commonActivities_Strategist.loginToStrategistPortal();
            commonActivities_Strategist.logoutFromStrategistPortal();
            commonActivities_Assosiciate.openAssociatePortal(Associate_url);
            commonActivities_Assosiciate.loginToAssociatePortal();
            commonActivities_Assosiciate.logoutFromAssociatePortal();
            commonActivities_Customer.openCustomerPortal(Customer_url);
            commonActivities_Customer.logintoCustomerPortal();
//            commonActivities_Customer.createAnAppointment();
//            commonActivities_Customer.editAnAppointment();
//            commonActivities_Customer.deleteTheCreatedAppointmet();
            commonActivities_Customer.logoutFromCustomerPortal();
        } catch (Exception e) {
            // TODO: handle exception
            ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed unfortuately",
                    ExtentTestManager.getTest().addBase64ScreenShot(getScreenShot()));
            Assert.assertTrue(false);
        }

    }

    @AfterTest
    public void closeBrowser()
    {
        driver.quit();
    }

}
