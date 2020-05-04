package com.qa.pageObjects.StrategistPortal;

import features.BatchStrategyCreationStepDefination;
import features.steps.serenity.*;
import flextesting.commonsteps.CommonElementsStepsPage;
import flextesting.strategistportal.decisiontreemanager.*;
import flextesting.strategistportal.defaultdata.ChannelData;
import flextesting.strategistportal.defaultdata.DTMExternalEntityData;
import flextesting.strategistportal.defaultdata.NodeAndQueueData;
import flextesting.strategistportal.defaultdata.ProgramData;
import flextesting.strategistportal.documentmanager.DocumentManagerPage;
import flextesting.utilities.DataUtil;

import static com.qa.base.TestBase.*;

public class CommonActivities_Strategist {

    DTMScheduleStep dTMScheduleStep= new DTMScheduleStep();
    LoginStep loginSteps= new LoginStep();
    DesktopSteps desktopSteps = new DesktopSteps();
    DTContextPortfolioStep dTContextPortfolioStep= new DTContextPortfolioStep();
    BatchStrategyCreationStep batchStrategyCreationStep= new BatchStrategyCreationStep();
    DTCanvasStepsPage dtCanvasStepsPage = new DTCanvasStepsPage();
    DTMQueueStepsPage dTMQueueStepsPage= new DTMQueueStepsPage();
    DTMProgramStepsPage dTMProgramStepsPage= new DTMProgramStepsPage();
    DTMExternalEntityStepsPage dTMExternalEntityStepsPage= new DTMExternalEntityStepsPage();
    CIDStrategyCreationStepsPage cIDStrategyCreationStepsPage= new CIDStrategyCreationStepsPage();
    DTMChannelStepsPage dTMChannelStepsPage = new DTMChannelStepsPage();
    CommonElementsStepsPage commonElementsStepsPage = new CommonElementsStepsPage();
    DocumentManagerPage documentManagerPage = new DocumentManagerPage();


    public  void  openAdminPortal(String AdminPortalURL){
        getDriver().navigate().to(AdminPortalURL);
        LogThisStepInExtentReport("Strategist Portal is Opened with URL :"+AdminPortalURL);
    }

    public void loginToAdminPortal(){
        LandingPage.enterUsename("rdatla");
        LandingPage.enterPassword("Rama7@renuka");
        LandingPage.loginButtonClick(getDriver());
        LogThisStepInExtentReport("An User Logged into Strategist portal with userame : Ramki and Paddword : Test1234");

    }

    public void logoutFromAdminPortal() throws InterruptedException {
        LandingPage.clickLogout(getDriver());
        LandingPage.verifyLogout(getDriver());
        LogThisStepInExtentReport("An User Logged out from Strategist Portal");

    }

    public void loginToStrategistPortal(){
        LandingPage.enterUsename("rdatla");
        LandingPage.enterPassword("Rama7@renuka");
        LandingPage.loginButtonClick(getDriver());
        LogThisStepInExtentReport("An User Logged into Strategist portal with userame : Ramki and Paddword : Test1234");
    }

    public void logoutFromStrategistPortal() throws InterruptedException {
        Thread.sleep(5000);
        LandingPage.clickOnStartButton();
        LandingPage.clickOnLogoutButton();
        Thread.sleep(2000);
        LandingPage.clickOnLogoutConfirmationYesButton();
        LogThisStepInExtentReport("An User Logged out from Strategist Portal");

    }


    public void i_add_a_schedule_as_in_DTM(String arg1) throws Throwable {
        String name = arg1+ "_" + DataUtil.getDateFormatTxt();
        dTMScheduleStep.i_add_a_schedule_as_in_DTM(name);
        LogThisStepInExtentReport("add a decision tree strategy as ::"+name);

    }
    public void i_have_logged_in_the_Strategist_Portal() throws Throwable {
        loginSteps.i_have_logged_in_the_Strategist_Portal();
    }
    public void i_open_the_Decision_Tree_Manager() throws Throwable {
        desktopSteps.i_open_the_Decision_Tree_Manager();
        LogThisStepInExtentReport("  I Have Opened Decession Tree Manger");

        //desktopPage.click_DecisionTreeManager();
    }
    public void i_choose_a_context_and_a_porfolio() throws Throwable {
        dTContextPortfolioStep.i_choose_a_context_and_a_porfolio();
        LogThisStepInExtentReport("Context and Portifolio has choosen");

    }
    public void i_add_a_decision_tree_strategy_as(String batchStrategyName) throws Throwable {
        batchStrategyCreationStep.i_add_a_decision_tree_strategy_as(batchStrategyName);
        LogThisStepInExtentReport("I add a decision tree strategy as ::"+batchStrategyName);

    }
    public void the_strategy_should_be_created() throws Throwable {
        dtCanvasStepsPage.the_strategy_should_be_created();
        LogThisStepInExtentReport("Then The strategy should be created");

    }

    public void i_add_a_child_node_name_as_and_criteria_as(String childNodeName, String criteria) throws Throwable {
        dtCanvasStepsPage.i_add_a_child_node_name_as_and_criteria_as(childNodeName, criteria);
        LogThisStepInExtentReport("I add a child node name as :: "+childNodeName+" :: and criteria as ::"+criteria);
    }
    public void i_rename_the_root_to(String arg1, String arg2) throws Throwable {
        dtCanvasStepsPage.i_rename_the_root_to(arg1, arg2);
        //Then I rename the "Left Over" root to "Main Left Over"
        LogThisStepInExtentReport("Then I rename the ::"+arg1+":: root to::"+arg2);
    }
    public void i_open_Manage_child_s_for_sub_root(String subRootName) throws Throwable {
        dtCanvasStepsPage.i_open_Manage_child_s_for_sub_root(subRootName);
        LogThisStepInExtentReport(" When I open Manage child(s)for sub-root ::"+subRootName);
    }
    public void i_add_a_sub_child_node_name_as_and_criteria_as(String childNodeName, String criteria) throws Throwable {
        dtCanvasStepsPage.i_add_a_sub_child_node_name_as_and_criteria_as(childNodeName, criteria);
        LogThisStepInExtentReport(" And I add a sub-child node name as ::"+childNodeName+":: and criteria as  ::"+criteria);
    }
    public void i_close_the_Manage_child_s_for_sub_root() throws Throwable {
        dtCanvasStepsPage.i_close_the_Manage_child_s_for_sub_root();
        LogThisStepInExtentReport(" Then I close the Manage child(s)for sub-root");
    }

    public void i_have_created_a_queue_as_in_DTM(String queueName) throws Throwable {
        String name = queueName + "_" + DataUtil.getDateFormatTxt();
        NodeAndQueueData.setNewQueueName(name);
        dTMQueueStepsPage.i_have_created_a_queue_as_in_DTM(name);
        LogThisStepInExtentReport("  And I have created a queue as ::"+name+":: in DTM");

    }

    public void i_assign_the_queue_to_roles(String role1, String role2) throws Throwable {
        String queueName=NodeAndQueueData.getNewQueueName();
        dTMQueueStepsPage.i_assign_the_queue_to_roles(queueName, role1, role2);
        LogThisStepInExtentReport(" I assign the queue to ::"+role1+":: & :: "+role2+":: roles");


    }
    public void i_attach_the_queue_to_the_node(String nodeName) throws Throwable {
        String queueName=NodeAndQueueData.getNewQueueName();
        dtCanvasStepsPage.i_attach_the_queue_to_the_node(queueName, nodeName);
        LogThisStepInExtentReport(" I attach the queue to the ::"+nodeName+" ::node");

    }

    public void i_create_a_program_as_in_DTM(String programName) throws Throwable {
        String programNameFinal = programName + "_" + DataUtil.getDateFormatTxt();
        ProgramData.setProgramName(programNameFinal);
        dTMProgramStepsPage.i_create_a_program_as_in_DTM(programNameFinal);
        LogThisStepInExtentReport(" I create a program as ::"+programNameFinal+" :: in DTM");

    }
    public void i_attach_the_program_to_the_node(String nodeName) throws Throwable {
        dtCanvasStepsPage.i_attach_the_program_to_the_node(ProgramData.getProgramName(), nodeName);
        LogThisStepInExtentReport(" I attach the program to the ::"+nodeName+" :: node");

    }

    public void i_attach_updated_action_variable_as_and_if_as_and_then_as_to_the_node(String variablename, String ifValue, String thenValue, String nodeName) throws Throwable {
        dtCanvasStepsPage.i_attach_updated_action_variable_as_and_if_as_and_then_as_to_the_node(variablename, ifValue, thenValue, nodeName);
        LogThisStepInExtentReport("  i_attach_updated_action_variable_as_and_if_as_and_then_as_to_the_node ::"+nodeName);

    }
    public void i_create_a_external_entity_as_in_DTM(String arg1) throws Throwable {
        DTMExternalEntityData.setErternalEntityName(arg1+DataUtil.getDateFormatTxt());
        dTMExternalEntityStepsPage.i_create_a_external_entity_as_in_DTM(DTMExternalEntityData.getErternalEntityName());
    }

    public void i_attach_the_external_entity_to_the_node( String nodeName) throws Throwable {
        dtCanvasStepsPage.i_attach_the_external_entity_to_the_node(DTMExternalEntityData.getErternalEntityName(), nodeName);
        LogThisStepInExtentReport(" i_attach_the_external_entity_to_the_node ::"+nodeName);

    }

    public void i_add_a_CID_strategy_name_as_and_event_as(String name, String event) throws Throwable {
        cIDStrategyCreationStepsPage.i_add_a_CID_strategy_name_as_and_event_as(name, event);
        LogThisStepInExtentReport("  And I have created a queue as ::"+name+":: in DTM");

    }
    public void i_create_a_channel_in_DTM(String channelType) throws Throwable {
        String name = channelType + "_" + DataUtil.getDateFormatTxt();
        ChannelData.setNewChannelName(name);
        dTMChannelStepsPage.i_create_a_channel_in_DTM(channelType, name);
        LogThisStepInExtentReport("  And I have created a queue as ::"+name+":: in DTM");

    }

    public void i_attach_the_channel_to_the_node(String nodeName) throws Throwable {
        dtCanvasStepsPage.i_attach_the_channel_to_the_node(ChannelData.getNewChannelName(), nodeName);
        LogThisStepInExtentReport(" i_attach_the_channel_to_the_node ::"+nodeName);

    }
    public void i_choose_from_the_Schedule_Operation_dropdown_menu(String operation) throws Throwable {
        dTMScheduleStepsPage.i_choose_from_the_Schedule_Operation_dropdown_menu(operation);
        LogThisStepInExtentReport("  i_choose_from_the_Schedule_Operation_dropdown_menu ::"+operation);

    }

    public void i_Delete_Schedule( ) throws Throwable {
        dTMScheduleStepsPage.i_delete_the_schedule_in_DTM();
        LogThisStepInExtentReport("  i_delete_the_schedule_in_DTM ::");

    }
    public void i_click_Yes_in_the_confirmation_window() throws Throwable {
        commonElementsStepsPage.i_click_Yes_in_the_confirmation_window();
        LogThisStepInExtentReport("  i_click_Yes_in_the_confirmation_window");

    }


    public void i_have_opened_the_Document_manager() throws Throwable {
        desktopPage.click_DocumentManager();
        LogThisStepInExtentReport("Open Document Manager");

    }
    public void i_have_chosen_Responsible_as_Context_in_DM() throws Throwable {
        documentManagerPage.i_have_chosen_Responsible_as_Context_in_DM();
        LogThisStepInExtentReport("Chose Responsible as Context in DM");

    }
    public void i_click_the_Add_button_in_DM() throws Throwable {
        documentManagerPage.i_click_the_Add_button_in_DM();
        LogThisStepInExtentReport("Click the Add button in DM");
    }
    public void i_enter_a_document_name(String docType) throws Throwable {
        documentManagerPage.i_enter_a_document_name(docType);
        //LogThisStepInExtentReport("Enter :::"+docType+"::: document name");
    }
    public void i_click_the_Edit_button_of_Assigned_Portfolio() throws Throwable {
        documentManagerPage.i_click_the_Edit_button_of_Assigned_Portfolio();
        LogThisStepInExtentReport(" Click Edit button of Assigned Portfolio");
    }
    public void i_assign_some_portfolios_to_the_document() throws Throwable {
        documentManagerPage.i_assign_some_portfolios_to_the_document();
        LogThisStepInExtentReport("Assign some portfolios to the document");
    }
    public void i_check_Enable_Delivery_via_Email() throws Throwable {
        documentManagerPage.i_check_Enable_Delivery_via_Email();
        LogThisStepInExtentReport("Check Enable Delivery via Email");
    }
    public void i_enter_an_email_address_in_the_Mail_From_field() throws Throwable {
        documentManagerPage.i_enter_an_email_address_in_the_Mail_From_field();
        LogThisStepInExtentReport("Enter an email address in the Mail From field");
    }
    public void i_enter_a_subject() throws Throwable {
        documentManagerPage.i_enter_a_subject();
        LogThisStepInExtentReport("Enter a subject");
    }
    public void i_enter_a_Email_html_body() throws Throwable {
        documentManagerPage.i_enter_a_Email_html_body();
        LogThisStepInExtentReport("Enter a Email html body");
    }
    public void i_click_Text_Body() throws Throwable {
        documentManagerPage.i_click_Text_Body();
        LogThisStepInExtentReport("Click Text Body");
    }
    public void i_enter_a_Email_text_body() throws Throwable {
        documentManagerPage.i_enter_a_Email_text_body();
        LogThisStepInExtentReport("Enter a Email text body");
    }
    public void i_click_the_Save_as_Draft_button_in_the_Add_Document_window() throws Throwable {
        documentManagerPage.i_click_the_Save_as_Draft_button_in_the_Add_Document_window();
        LogThisStepInExtentReport("Click the Save as Draft button in the Add Document window");
    }
    public void the_document_is_saved() throws Throwable {
        documentManagerPage.the_document_is_saved();
        LogThisStepInExtentReport("The document is saved");
    }
    public void i_click_the_Publish_This_Version_button_in_the_Add_Document_window() throws Throwable {
        documentManagerPage.i_click_the_Publish_This_Version_button_in_the_Add_Document_window();
        LogThisStepInExtentReport("Click the Publish This Version button in the Add Document window");
    }
    public void the_document_is_published() throws Throwable {
        documentManagerPage.the_document_is_published();
        LogThisStepInExtentReport("The document is published");

    }
    public void i_search_the_document_in_DM() throws Throwable {
        documentManagerPage.i_search_the_document_in_DM();
        LogThisStepInExtentReport("Search the document in DM");

    }
    public void i_select_the_document() throws Throwable {
        documentManagerPage.i_select_the_document();
        LogThisStepInExtentReport("Select the document");
    }
    public void i_click_the_Edit_button_in_DM() throws Throwable {
        documentManagerPage.i_click_the_Edit_button_in_DM();
        LogThisStepInExtentReport("Click the Edit button in DM");

    }
    public void i_enter_as_the_description(String description) throws Throwable {
        commonElementsStepsPage.i_enter_as_the_description(description);
        LogThisStepInExtentReport("Enter"+description+"as the description");

    }
    public void i_click_the_Delete_button_in_DM() throws Throwable {
        documentManagerPage.i_click_the_Delete_button_in_DM();
        LogThisStepInExtentReport("Click the Delete button in DM");
    }
    public void the_document_is_deleted() throws Throwable {
        documentManagerPage.the_document_is_deleted();
        LogThisStepInExtentReport("The document is deleted");

    }









}
