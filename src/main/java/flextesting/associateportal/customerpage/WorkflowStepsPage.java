package flextesting.associateportal.customerpage;


import com.qa.base.TestBase;
import flextesting.associateportal.AssociatePortalCommonStepsPage;
import flextesting.client.ClientProvider;
import flextesting.client.ScenarioInfo;
import flextesting.utilities.Utils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import sun.security.util.PendingException;

import static flextesting.utilities.Utils.clickByXpath;
import static flextesting.utilities.Utils.isElementDisplayed_clickIfNeeded;


public class WorkflowStepsPage extends TestBase {
	static Logger log = Logger.getLogger(WorkflowStepsPage.class);

	private AssociatePortalCommonStepsPage flexStationCommonSteps;
	private int numberOfCancelledWorkflowInHistoryBeforeTestingCancellation = 0;

	
	public void the_chosen_client_supports_workflow_testing() throws Throwable {
		if (ScenarioInfo.getTags().contains("@do_workflow")) {
	    	if (ClientProvider.getCode().equals("PCIQA"))
	    		log.info("The chosen client supports flexstation workflow testing");
	    	else
	    		throw new PendingException("Do_workflow test of flexstation can ONLY run on PCIQA. Mission abort...");
	    }
	}
	
	
	public void i_click_the_Workflow_icon_at_the_account_level() throws Throwable {
		clickByXpath(getDriver(), "//table[@id='workflowMenuButton']//button[contains(@class,'workflow-btn')]");
	}

	
	public void i_select_a_workflow_in_the_account_level_workflow_window() throws Throwable {
		clickByXpath(getDriver(), "(//span[text()='workflowForAutoTesting'])[1]");
	}

	
	public void i_click_the_Start_New_button_in_the_account_level_workflow_window() throws Throwable {
		clickByXpath(getDriver(), "//button[text()='Start New']");
	}

	
	public void i_click_Yes_for_the_step_of_the_account_level_workflow() throws Throwable {
		clickByXpath(getDriver(), "(//input[@type='radio'])[2]");
	}

	
	public void the_account_level_workflow_is_finished() throws Throwable {
		isElementDisplayed_clickIfNeeded(0, getDriver(), "//*[text()='The workflow is finished']", true, false);
	}

	
	public void i_click_Close_button_at_the_account_level_workflow_window() throws Throwable {
		clickByXpath(getDriver(), "//*[text()='The workflow is finished']//following::button[text()='Close']");
	}
	
	
	//cancel
	
	public void i_select_the_In_Process_account_level_workflow() throws Throwable {
		clickByXpath(getDriver(), "//div[text()='In Process']");
	}

	
	public void i_click_the_Cancel_button_in_the_account_level_workflow_window() throws Throwable {
		
	}

	
	public void the_account_level_workflow_is_canceled() throws Throwable {
		isElementDisplayed_clickIfNeeded(2000, getDriver(), "//div[text()='In Process']", false, false);
	}
	
	
	public void i_click_the_Cancel_button_to_cancel_to_the_current_account_level_workflow_process() throws Throwable {
		clickByXpath(getDriver(), "//div[contains(@id,'PORTFOLIO-fw')]//button[text()='Cancel']");
	}

	
	public void i_click_the_Cancel_button_to_cancel_the_in_process_account_level_workflow() throws Throwable {
		clickByXpath(getDriver(), "//tr[@class='x-toolbar-right-row']//button[text()='Cancel']");
	}
	
	//check history
	
	public void i_click_the_History_button_in_the_account_level_workflow_window() throws Throwable {
		clickByXpath(getDriver(), "//span[text()='History']");
	}

	
	public void i_record_the_number_of_canceled_acocunt_level_workflows() throws Throwable {
		numberOfCancelledWorkflowInHistoryBeforeTestingCancellation = Utils.findAllVisibleOnes(getDriver(), "//div[text()='Cancelled']").size();
		log.info("Number of cancelled workflow in history before testing cancalation: " + numberOfCancelledWorkflowInHistoryBeforeTestingCancellation);
	}

	
	public void i_click_the_Current_button_in_the_account_level_workflow_window() throws Throwable {
		clickByXpath(getDriver(), "//span[text()='Current']");
	}

	
	public void there_is_one_more_record_of_canceled_account_level_workflow() throws Throwable {
		int numberOfCancelledWorkflowInHistoryAfterTestingCancellation = Utils.findAllVisibleOnes(getDriver(), "//div[text()='Cancelled']").size();
		log.info("Number of cancelled workflow in history after testing cancalation: " + numberOfCancelledWorkflowInHistoryAfterTestingCancellation);
		Assert.assertEquals(numberOfCancelledWorkflowInHistoryBeforeTestingCancellation+1, numberOfCancelledWorkflowInHistoryAfterTestingCancellation);
	}
}
