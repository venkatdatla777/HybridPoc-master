package com.qa.testcases;

import com.qa.ExtentReportListener.ExtentTestManager;
import com.qa.base.TestBase;
import com.qa.pageObjects.AssosiciatePortal.CommonActivities_Assosiciate;
import com.qa.pageObjects.CustomerPortal.CommonActivities_Customer;
import com.qa.pageObjects.StrategistPortal.CommonActivities_Strategist;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class Email_Document extends TestBase {


        CommonActivities_Strategist commonActivities_Strategist=null;
        CommonActivities_Assosiciate commonActivities_Assosiciate=null;
        CommonActivities_Customer commonActivities_Customer=null;
        String browserOfTesting=null;

         @Parameters("browser")
        @BeforeTest
        public void browseGmail( String browser ) throws MalformedURLException {
             if (browser.equalsIgnoreCase("ie")){
                 getWebdriverOf(browser);
                 System.out.println("In IE Logic==========================>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
             }else {
                 browserOfTesting=browser;
                 initialization(browser);
                 System.out.println("Out of  IE Logic ==========================>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
             }
            //driver=getDriver();
            //driver = getWebdriverOf(browser_currennt);
            commonActivities_Strategist= new CommonActivities_Strategist();
            commonActivities_Assosiciate= new CommonActivities_Assosiciate();
            commonActivities_Customer= new CommonActivities_Customer();
            // LogThisStepInExtentReport("Browser Details ::"+browser);
        }

        @Test
        public void Email_Document_Test()
        {
            try {
                LogThisStepInExtentReport("Current Browser Of Testing :"+browserOfTesting);
                commonActivities_Strategist.openAdminPortal(Strategist_url);
                commonActivities_Strategist.loginToStrategistPortal();
                commonActivities_Strategist.i_have_opened_the_Document_manager();
                commonActivities_Strategist.i_have_chosen_Responsible_as_Context_in_DM();
                commonActivities_Strategist.i_click_the_Add_button_in_DM();
                commonActivities_Strategist.i_enter_a_document_name("Email");
                commonActivities_Strategist.i_click_the_Edit_button_of_Assigned_Portfolio();
                commonActivities_Strategist.i_assign_some_portfolios_to_the_document();
                commonActivities_Strategist.i_check_Enable_Delivery_via_Email();
                commonActivities_Strategist.i_enter_an_email_address_in_the_Mail_From_field();
                commonActivities_Strategist.i_enter_a_subject();
                commonActivities_Strategist.i_enter_a_Email_html_body();
                commonActivities_Strategist.i_click_Text_Body();
                commonActivities_Strategist.i_enter_a_Email_text_body();
                commonActivities_Strategist.i_click_the_Save_as_Draft_button_in_the_Add_Document_window();
                commonActivities_Strategist.the_document_is_saved();
                commonActivities_Strategist.i_click_the_Publish_This_Version_button_in_the_Add_Document_window();
                commonActivities_Strategist.the_document_is_published();
                commonActivities_Strategist.i_search_the_document_in_DM();
                commonActivities_Strategist.i_select_the_document();
                commonActivities_Strategist.i_click_the_Edit_button_in_DM();
                commonActivities_Strategist.i_enter_as_the_description("This is an email sample");
                commonActivities_Strategist.i_click_the_Save_as_Draft_button_in_the_Add_Document_window();
                commonActivities_Strategist. the_document_is_saved();
                commonActivities_Strategist.i_click_the_Publish_This_Version_button_in_the_Add_Document_window();
                commonActivities_Strategist.the_document_is_published();
                commonActivities_Strategist.i_search_the_document_in_DM();
                commonActivities_Strategist.i_select_the_document();
                commonActivities_Strategist.i_click_the_Delete_button_in_DM();
                commonActivities_Strategist.the_document_is_deleted();
                commonActivities_Strategist.logoutFromStrategistPortal();

            } catch (Exception e) {
                // TODO: handle exception
                ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed unfortuately",
                        ExtentTestManager.getTest().addBase64ScreenShot(getScreenShot()));
                e.printStackTrace();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }

        }

        @AfterTest
        public void closeBrowser()  {
          // Thread.sleep(10000);
            driver.quit();
        }


}
