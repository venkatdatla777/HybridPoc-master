package flextesting.strategistportal.decisiontreemanager;



import com.qa.base.TestBase;
import flextesting.pagefactories.CommonElementsFactory;
import flextesting.pagefactories.strategistportal.actions.QueueFactory;
import flextesting.strategistportal.defaultdata.NodeAndQueueData;
import flextesting.utilities.Utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DTMQueueStepsPage extends TestBase {
	private String queueName;
	private String queueDesc = NodeAndQueueData.getQueueDescription();
	
	public void i_click_the_Queues_tab_in_DTM() throws Throwable {
		queueFactory.click_tab_Queues();
	}

	
	public void i_click_the_button_under_the_Queues_tab(String btnName) throws Throwable {
		queueFactory.click_AddEditDeleteAssignment(btnName);
	}

	
	public void i_enter_an_Action_Name_for_the_queue() throws Throwable {
		queueName = NodeAndQueueData.getQueueName();
		commonElementsFactory.enterName(queueName);
	}

	
	public void the_queue_is_saved() throws Throwable {
		checkIfSavedByName(queueName);
	}
	private void checkIfSavedByName(String name) throws InterruptedException {
		Thread.sleep(1500);
		queueFactory.enter_SearchField(name);
		commonElementsFactory.click_Search();
		assertTrue(queueFactory.isPresent_queueByName_clickIfYes(name, true, false));
	}
	
	public void i_select_the_queue_that_is_just_created() throws Throwable {
		selectQueueByName(queueName);
	}
	private void selectQueueByName(String name) throws InterruptedException {
		queueFactory.enter_SearchField(name);
		commonElementsFactory.click_Search();
		assertTrue(queueFactory.isPresent_queueByName_clickIfYes(name, true, true));
		try {
			queueFactory.isPresent_queueByName_clickIfYes(name, true, true);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	public void i_enter_a_Description_for_the_queue() throws Throwable {
		commonElementsFactory.enterDescription(queueDesc);
	}
	
	
	public void i_assign_the_queue_to_some_roles() throws Throwable {
		queueFactory.assignQueueToTheFirstRole();
	}

	
	public void the_queue_is_assigned_to_some_roles() throws Throwable {
		queueFactory.checkIfQueueIsAssignedToRole();
	}

	
	public void i_assign_the_queue_to_some_users() throws Throwable {
		queueFactory.assignQueueToTheFirstUser();
	}

	
	public void the_queue_is_assigned_to_some_users() throws Throwable {
		queueFactory.checkIfQueueIsAssignedToUser();
	}

	
	public void the_queue_is_deleted() throws Throwable {
		checkIfDeleteByName(queueName);
	}

	private void checkIfDeleteByName(String name) throws InterruptedException {
		queueFactory.enter_SearchField(name);
		commonElementsFactory.click_Search();
		assertFalse(queueFactory.isPresent_queueByName_clickIfYes(name, false, false));
	}


	/**
	 * one sentence step
	 * @throws Throwable
	 */
	
	public void i_have_created_a_queue_in_DTM() throws Throwable {
		createAQueue(queueName);
	}
	
	
	public void i_have_created_some_queues_in_DTM() throws Throwable {
		for(String name: NodeAndQueueData.getNodeAndQueueNames()) {
			createAQueue(name);
		}
	}
	
	private void createAQueue(String name) throws Throwable {
		queueFactory.click_tab_Queues();
		queueFactory.click_AddEditDeleteAssignment("Add");
		commonElementsFactory.enterName(name);
		commonElementsFactory.click_Save();
		commonElementsFactory.click_Submit();
		checkIfSavedByName(name);
	}
	/**
	 * one sentence step
	 * @throws Throwable
	 */
	
	public void i_delete_the_queue_in_DTM() throws Throwable {
		deleteQueueByName(queueName);
	}
	
	
	public void i_delete_all_queues_just_created_in_DTM() throws Throwable {
		for(String name: NodeAndQueueData.getNodeAndQueueNames()) {
			deleteQueueByName(name);
		}
	}
	private void deleteQueueByName(String name) throws Throwable {
		queueFactory.click_tab_Queues();
		selectQueueByName(name);
		queueFactory.click_AddEditDeleteAssignment("Delete");
		commonElementsFactory.confirm_Yes();
		checkIfDeleteByName(name);
	}
	
	public void i_create_sample_queues_if_not_already_existing() throws Throwable {
		for(String queueName: NodeAndQueueData.getPermanentNodeAndQueueNames()) {
			queueFactory.click_tab_Queues();
			queueFactory.enter_SearchField(queueName);
			commonElementsFactory.click_Search();
			//continue creating queue if not already existing
			if (!Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), "//div[contains(@class,'x-grid-cell-inner') and text()='"+queueName+"']", true, false)) {
				queueFactory.click_AddEditDeleteAssignment("Add");
				commonElementsFactory.enterName(queueName);
				commonElementsFactory.click_Save();
				commonElementsFactory.click_Submit();		
			}
		}
	}
	
	public void i_have_created_a_queue_as_in_DTM(String name) throws Throwable {
		System.out.println("Queue Name : " + name);
		createAQueue(name);
	}
	
	public void i_assign_the_queue_to_roles(String queueName, String role1, String role2) throws Throwable {
		selectQueueByName(queueName);
		queueFactory.click_AddEditDeleteAssignment("Assignment");
		queueFactory.assignQueueToTheFirstRole();
		queueFactory.checkIfQueueIsAssignedToRole();
		queueFactory.assignQueueToTheFirstRole();
		queueFactory.checkIfQueueIsAssignedToTwoRoles();
		commonElementsFactory.closeWindow("Queue Assignment");
	}
}
