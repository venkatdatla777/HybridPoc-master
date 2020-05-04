package flextesting.strategistportal.workflowmanager;


import com.qa.base.TestBase;
import flextesting.AppConfig;
import flextesting.associateportal.customerpage.DispositionStepsPage;
import flextesting.client.ClientProvider;
import flextesting.pagefactories.associateportal.customerpage.DispositionFactory;
import flextesting.pagefactories.strategistportal.workflowmanager.WorkflowCreationPanelFactory;
import flextesting.strategistportal.defaultdata.WorkflowData;
import flextesting.utilities.Utils;
import org.openqa.selenium.By;

import java.util.Map;

import static flextesting.utilities.Utils.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WorkflowCreationStepsPage extends TestBase {
	private WorkflowCreationPanelFactory wcp;
	private DispositionStepsPage dispositionStepsPage;
	private DispositionFactory dispositionFactory;
	public static Map<String, String> dataMap = WorkflowData.dataMap;
	private String workflowName;
	private String assignedRoles;
	private String workflowCriteria;
	private String xpathOfWorkflow = null;
	private String xpathOfWorkflowCopy = null;

	public void i_have_chosen_for_View_Container(String viewName) throws Throwable {
		clickByXpath(getDriver(), "(//input)[1]");// trigger dropdown
		clickByXpath(getDriver(), "//li[@role='option' and text()='" + viewName + "']");
		// some workflow schedule needs a long time to load because it contains
		// lots of workflows or sub-flows
		Thread.sleep(2000); // sometimes it takes sometime (like 2 sec) for the
							// "Loading..." icon to appear
		By locator_loading = By.xpath("//div[text()='Loading...']");
		Utils.waitForElementNotPresent(getDriver(), locator_loading, 20);
		Thread.sleep(2000);
	}

	public void i_create_a_workflow_with_the_following_information(Map<String, String> data) throws Throwable {
		dataMap = data;
		workflowName = dataMap.get("Workflow Name");
		wcp.click_Add();
		wcp.enter_FlowName(workflowName);
		xpathOfWorkflow = "//div[starts-with(@id,'workflowlist')]//div[text()='" + workflowName + "']";
		xpathOfWorkflowCopy = "//div[starts-with(@id,'workflowlist')]//div[text()='" + workflowName + " Copy']";
		wcp.enter_EntryCriteria(dataMap.get("Entry Criteria"));
		wcp.click_Submit();
	}

	public void i_create_a_workflow_with_the_name(String name) throws Throwable {
		workflowName = name;
		wcp.click_Add();
		wcp.enter_FlowName(workflowName);
		xpathOfWorkflow = "//div[starts-with(@id,'workflowlist')]//div[text()='" + workflowName + "']";
		xpathOfWorkflowCopy = "//div[starts-with(@id,'workflowlist')]//div[text()='" + workflowName + " Copy']";
	}

	public void i_enter_as_the_entry_criteria(String criteria) throws Throwable {
		workflowCriteria = criteria;
		wcp.enter_EntryCriteria(workflowCriteria);
		wcp.click_Submit();
	}

	public void the_workflow_should_be_created() throws Throwable {
		wcp.present_workflow(dataMap.get("Workflow Name"));
	}

	public void i_have_created_a_workflow() throws Throwable {
		i_create_a_workflow_with_the_name(dataMap.get("Workflow Name"));
		i_enter_as_the_entry_criteria(dataMap.get("Entry Criteria"));
	}

	// ============================NEW============================
	public void i_select_the_workflow_just_created() throws Throwable {
		isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfWorkflow, true, true);
	}

	public void i_click_the_button_in_the_workflow_creation_panel(String arg1) throws Throwable {
		clickByXpath(getDriver(), "//div[starts-with(@id,'workflowlist')]//button//span[text()='" + arg1 + "']");
	}

	public void i_enter_as_the_Tag_for_the_workflow(String arg1) throws Throwable {
		clearAndEnter(getDriver(), "//input[@name='tag']", arg1);
	}

	public void the_workflow_is_saved() throws Throwable {
		assertTrue(isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfWorkflow, true, false));
	}

	public void the_workflow_copy_is_saved() throws Throwable {
		assertTrue(isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfWorkflowCopy, true, false));
	}

	public void the_workflow_copy_is_deleted() throws Throwable {
		assertFalse(isElementDisplayed_clickIfNeeded(2000, getDriver(), xpathOfWorkflow, false, false));
	}

	public void i_create_a_workflow_with_the_following_informations(Map<String, String> data) throws Throwable {
		dataMap = data;
		workflowName = dataMap.get("Workflow Name");
		wcp.click_Add();
		wcp.enter_FlowName(workflowName);
		xpathOfWorkflow = "//div[starts-with(@id,'workflowlist')]//div[text()='" + workflowName + "']";
		xpathOfWorkflowCopy = "//div[starts-with(@id,'workflowlist')]//div[text()='" + workflowName + " Copy']";
		wcp.enter_EntryCriteria(dataMap.get("Entry Criteria"));
		wcp.enter_WorkFlowTitleForFlexsite(dataMap.get("Workflow Title for FlexSite"));
		wcp.click_Submit();
	}

	public void i_Select_Assignment_and_add_Available_Roles(Map<String, String> data) throws Throwable {
		dataMap = data;
		wcp.click_Assignment();
		wcp.click_AssignRoleAndUser();
		assignedRoles = dataMap.get("Assigned Roles");
		if (dataMap.get("Assigned Roles") != null
				&& dataMap.get("Assigned Roles").equals("Move all from left to Right")) {
			wcp.click_MoveAllLeftRowsToRightSide();
		}

		wcp.click_Save();
	}

	public void the_Roles_are_assigned_to_Workflow() throws Throwable {
		// Assert.assertTrue();
		wcp.click_Ok();
	}

	public void i_bouble_click_on_Standard_Financial_Statement_in_Current_tab() throws Throwable {
		wcp.i_bouble_click_on_Standard_Financial_Statement_in_Current_tab();
	}

	public void i_click_on_Type_of_Budget_dropDown_and_select_and_click_on_Start_button(String arg1) throws Throwable {
		wcp.i_click_on_Type_of_Budget_dropDown_and_select_and_click_on_Start_button(arg1);
	}

	public void i_choose_one_option_form_Your_Accommodation_dropDown() throws Throwable {
		wcp.i_choose_one_option_form_Your_Accommodation_dropDown();
	}

	public void i_click_Full_time_checkbox_and_click_on_next_button() throws Throwable {
		wcp.i_click_Full_time_checkbox_and_click_on_next_button();
	}

	public void i_click_on_close_button_and_then_close_window() throws Throwable {
		wcp.i_click_on_close_button_and_then_close_window();
	}

	public void i_click_the_Disposition_icon_at_the_account_level() throws Throwable {
//		wcp.i_click_the_Disposition_icon_at_the_account_level();
		dispositionFactory.tryToClickDispositionBtn(AppConfig.isHideCustomerContainer());
		if (!AppConfig.isHideCustomerContainer()) {
			dispositionFactory.window_SelectAccountForDisposition();
			if (ClientProvider.selectAllAccountsWhenDisposition)
				Utils.clickAllVisibleOnes(getDriver(), "//input[@type='checkbox']", false, webElement -> webElement.getAttribute("checked") == null);
			dispositionFactory.click_Next_window_SelectAccountForDisposition();
			dispositionFactory.window_Disposition();
		}
	}

	public void i_click_Payment_Made_radio_button_and_Submit_Close_Account_button() throws Throwable {
//		wcp.i_click_Payment_Made_radio_button_and_Submit_Close_Account_button();
		if (ClientProvider.getCode().equalsIgnoreCase("mmeqa")) {
			Utils.clickByXpath(getDriver(), "//label[text()='Inbound Call']");
			Utils.clickByXpath(getDriver(), "//label[text()='Inbound Direct']");
			Utils.clickByXpath(getDriver(), "//label[text()='Other']");
		} else {
			dispositionFactory.radio_DispositionChannel_NoncallDocumentation();
			wcp.i_click_Payment_Made_radio_button_and_Submit_Close_Account_button();
		}
	}

}
