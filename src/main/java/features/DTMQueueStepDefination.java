package features;

import features.steps.serenity.DTMQueueStep;
import flextesting.strategistportal.defaultdata.NodeAndQueueData;
import flextesting.utilities.DataUtil;

public class DTMQueueStepDefination {

	DTMQueueStep dTMQueueStep;

	public void i_click_the_Queues_tab_in_DTM() throws Throwable {
		dTMQueueStep.i_click_the_Queues_tab_in_DTM();
	}

	public void i_click_the_button_under_the_Queues_tab(String btnName) throws Throwable {
		dTMQueueStep.i_click_the_button_under_the_Queues_tab(btnName);
	}

	public void i_enter_an_Action_Name_for_the_queue() throws Throwable {
		dTMQueueStep.i_enter_an_Action_Name_for_the_queue();
	}

	public void the_queue_is_saved() throws Throwable {
		dTMQueueStep.the_queue_is_saved();
	}

	public void i_select_the_queue_that_is_just_created() throws Throwable {
		dTMQueueStep.i_select_the_queue_that_is_just_created();
	}

	public void i_enter_a_Description_for_the_queue() throws Throwable {
		dTMQueueStep.i_enter_a_Description_for_the_queue();
	}

	public void i_assign_the_queue_to_some_roles() throws Throwable {
		dTMQueueStep.i_assign_the_queue_to_some_roles();
	}

	public void the_queue_is_assigned_to_some_roles() throws Throwable {
		dTMQueueStep.the_queue_is_assigned_to_some_roles();
	}

	public void i_assign_the_queue_to_some_users() throws Throwable {
		dTMQueueStep.i_assign_the_queue_to_some_users();
	}

	public void the_queue_is_assigned_to_some_users() throws Throwable {
		dTMQueueStep.the_queue_is_assigned_to_some_users();
	}

	public void the_queue_is_deleted() throws Throwable {
		dTMQueueStep.the_queue_is_deleted();
	}

	/**
	 * one sentence step
	 * 
	 * @throws Throwable
	 */
	public void i_have_created_a_queue_in_DTM() throws Throwable {
		dTMQueueStep.i_have_created_a_queue_in_DTM();
	}

	public void i_have_created_some_queues_in_DTM() throws Throwable {
		dTMQueueStep.i_have_created_some_queues_in_DTM();
	}

	/**
	 * one sentence step
	 * 
	 * @throws Throwable
	 */
	public void i_delete_the_queue_in_DTM() throws Throwable {
		dTMQueueStep.i_delete_the_queue_in_DTM();
	}

	public void i_delete_all_queues_just_created_in_DTM() throws Throwable {
		dTMQueueStep.i_delete_all_queues_just_created_in_DTM();
	}

	public void i_create_sample_queues_if_not_already_existing() throws Throwable {
		dTMQueueStep.i_create_sample_queues_if_not_already_existing();
	}

	// Added new steps
	public void i_have_created_a_queue_as_in_DTM(String queueName) throws Throwable {
		String name = queueName + "_" + DataUtil.getDateFormatTxt();
		NodeAndQueueData.setNewQueueName(name);
		dTMQueueStep.i_have_created_a_queue_as_in_DTM(name);
	}
	
	public void i_assign_the_queue_to_roles(String role1, String role2) throws Throwable {
		dTMQueueStep.i_assign_the_queue_to_roles(NodeAndQueueData.getNewQueueName(), role1, role2);
	}
}
