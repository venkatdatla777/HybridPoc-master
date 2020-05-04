package com.qa.testcases;

import com.qa.ExtentReportListener.ExtentTestManager;
import com.qa.base.TestBase;
import com.qa.pageObjects.AssosiciatePortal.CommonActivities_Assosiciate;
import com.qa.pageObjects.CustomerPortal.CommonActivities_Customer;
import com.qa.pageObjects.StrategistPortal.CommonActivities_Strategist;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Create_Publish_Strategy extends TestBase {
    CommonActivities_Strategist commonActivities_Strategist=null;
    CommonActivities_Assosiciate commonActivities_Assosiciate=null;
    CommonActivities_Customer commonActivities_Customer=null;
    String browserOfTesting=null;
     @Parameters("browser")
    @BeforeTest
    public void browseGmail(String browser  ) throws MalformedURLException {

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
    }

    @Test
    public void Create_Publish_Strategy_Scenario() throws InterruptedException
    {
        try {
            LogThisStepInExtentReport("Current Browser Of Testing :"+browserOfTesting);
            commonActivities_Strategist.openAdminPortal(Strategist_url);
            commonActivities_Strategist.loginToStrategistPortal();
            commonActivities_Strategist.i_open_the_Decision_Tree_Manager();
            commonActivities_Strategist.i_choose_a_context_and_a_porfolio();
            commonActivities_Strategist.i_add_a_schedule_as_in_DTM("Test Autoamtion Schedule");
            commonActivities_Strategist.i_add_a_decision_tree_strategy_as("Delinquent Account");
            commonActivities_Strategist.the_strategy_should_be_created();
            commonActivities_Strategist.i_add_a_child_node_name_as_and_criteria_as("Pre-delinquent","delinquencyDays=0");
            commonActivities_Strategist.i_rename_the_root_to("Left Over","Main Left Over");
            commonActivities_Strategist.i_open_Manage_child_s_for_sub_root("Pre-delinquent");
            commonActivities_Strategist.i_add_a_sub_child_node_name_as_and_criteria_as("High Risk Del","behaviorscore=0");
            commonActivities_Strategist.i_add_a_sub_child_node_name_as_and_criteria_as("Medium Risk Del","riskscore>620 and riskscore<=650");
            commonActivities_Strategist.i_add_a_sub_child_node_name_as_and_criteria_as("Low Risk Del","riskscore>650");
            commonActivities_Strategist.i_close_the_Manage_child_s_for_sub_root();
            commonActivities_Strategist.i_rename_the_root_to("Left Over","Pre Del Left Over");

            commonActivities_Strategist.i_have_created_a_queue_as_in_DTM("Pre-delinquent");
            commonActivities_Strategist.i_assign_the_queue_to_roles("CMC Admin" , "Client Admin");
            commonActivities_Strategist.i_attach_the_queue_to_the_node("Pre-delinquent");

            commonActivities_Strategist.i_have_created_a_queue_as_in_DTM("High Risk Del");
            commonActivities_Strategist.i_assign_the_queue_to_roles("CMC Admin" , "Client Admin");
            commonActivities_Strategist.i_attach_the_queue_to_the_node("High Risk Del");

            commonActivities_Strategist.i_have_created_a_queue_as_in_DTM("Medium Risk Del");
            commonActivities_Strategist.i_assign_the_queue_to_roles("CMC Admin" , "Client Admin");
            commonActivities_Strategist.i_attach_the_queue_to_the_node("Medium Risk Del");

            commonActivities_Strategist.i_have_created_a_queue_as_in_DTM("Low Risk Del");
            commonActivities_Strategist.i_assign_the_queue_to_roles("CMC Admin" , "Client Admin");
            commonActivities_Strategist.i_attach_the_queue_to_the_node("Low Risk Del");

            commonActivities_Strategist.i_have_created_a_queue_as_in_DTM("Main Left Over");
            commonActivities_Strategist.i_assign_the_queue_to_roles("CMC Admin" , "Client Admin");
            commonActivities_Strategist.i_attach_the_queue_to_the_node("Main Left Over");

            commonActivities_Strategist.i_have_created_a_queue_as_in_DTM("Pre Del Left Over");
            commonActivities_Strategist.i_assign_the_queue_to_roles("CMC Admin" , "Client Admin");
            commonActivities_Strategist.i_attach_the_queue_to_the_node("Pre Del Left Over");
            commonActivities_Strategist.i_create_a_program_as_in_DTM("Half as Half");
            commonActivities_Strategist.i_attach_the_program_to_the_node("High Risk Del");
            commonActivities_Strategist.i_attach_updated_action_variable_as_and_if_as_and_then_as_to_the_node("reasonForDelinquency" , "true" ,"'NatureDisaster'" ,"Pre-delinquent");
            commonActivities_Strategist.i_add_a_decision_tree_strategy_as("PTP and Promise");
            commonActivities_Strategist.the_strategy_should_be_created();
            commonActivities_Strategist.i_add_a_child_node_name_as_and_criteria_as("No PTP", "hasOutstandingPromise=false");
            commonActivities_Strategist.i_add_a_child_node_name_as_and_criteria_as("No Program Accepted" , "hasAcceptedProgram=false");
            commonActivities_Strategist.i_have_created_a_queue_as_in_DTM("No PTP");
            commonActivities_Strategist.i_rename_the_root_to("Left Over" , "PTP Promise Left Over");
            commonActivities_Strategist.i_assign_the_queue_to_roles("CMC Admin" , "Client Admin");
            commonActivities_Strategist.i_attach_the_queue_to_the_node("No PTP");

            commonActivities_Strategist.i_have_created_a_queue_as_in_DTM("No Program Accepted");
            commonActivities_Strategist.i_assign_the_queue_to_roles("CMC Admin" , "Client Admin");
            commonActivities_Strategist.i_attach_the_queue_to_the_node("No Program Accepted");

            commonActivities_Strategist.i_have_created_a_queue_as_in_DTM("PTP Promise Left Over");
            commonActivities_Strategist.i_assign_the_queue_to_roles("CMC Admin" , "Client Admin");
            commonActivities_Strategist.i_attach_the_queue_to_the_node("PTP Promise Left Over");

            commonActivities_Strategist.i_create_a_external_entity_as_in_DTM("TestExternal");
            commonActivities_Strategist.i_attach_the_external_entity_to_the_node("No Program Accepted");
            commonActivities_Strategist.i_add_a_CID_strategy_name_as_and_event_as("FlexSite Login-1", "FlexSite Login");
            commonActivities_Strategist.i_create_a_channel_in_DTM("Letter");
            commonActivities_Strategist.i_attach_the_channel_to_the_node("FlexSite Login");
            commonActivities_Strategist.i_create_a_program_as_in_DTM("Settlement");
            commonActivities_Strategist.i_attach_the_program_to_the_node("FlexSite Login");
            commonActivities_Strategist.i_attach_updated_action_variable_as_and_if_as_and_then_as_to_the_node("billingCycle" , "true", "20" , "FlexSite Login");
            commonActivities_Strategist.i_choose_from_the_Schedule_Operation_dropdown_menu("Publish Schedule");
           // commonActivities_Strategist.i_choose_from_the_Schedule_Operation_dropdown_menu("Unpublish Schedule");
            commonActivities_Strategist.i_click_Yes_in_the_confirmation_window();



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
    public void closeBrowser() throws InterruptedException {
            Thread.sleep(10000);
        driver.quit();
    }
}
