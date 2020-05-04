package features.steps.serenity;


import flextesting.strategistportal.decisiontreemanager.DTMQueueStepsPage;

public class DTMQueueStep {
	DTMQueueStepsPage dTMQueueStepsPage;


	public void i_click_the_Queues_tab_in_DTM() throws Throwable {
		dTMQueueStepsPage.i_click_the_Queues_tab_in_DTM();
	}


	public void i_click_the_button_under_the_Queues_tab(String btnName) throws Throwable {
		dTMQueueStepsPage.i_click_the_button_under_the_Queues_tab(btnName);
	}


	public void i_enter_an_Action_Name_for_the_queue() throws Throwable {
		dTMQueueStepsPage.i_enter_an_Action_Name_for_the_queue();
	}


	public void the_queue_is_saved() throws Throwable {
		dTMQueueStepsPage.the_queue_is_saved();
	}


	public void i_select_the_queue_that_is_just_created() throws Throwable {
		dTMQueueStepsPage.i_select_the_queue_that_is_just_created();
	}


	public void i_enter_a_Description_for_the_queue() throws Throwable {
		dTMQueueStepsPage.i_enter_a_Description_for_the_queue();
	}


	public void i_assign_the_queue_to_some_roles() throws Throwable {
		dTMQueueStepsPage.i_assign_the_queue_to_some_roles();
	}


	public void the_queue_is_assigned_to_some_roles() throws Throwable {
		dTMQueueStepsPage.the_queue_is_assigned_to_some_roles();
	}


	public void i_assign_the_queue_to_some_users() throws Throwable {
		dTMQueueStepsPage.i_assign_the_queue_to_some_users();
	}


	public void the_queue_is_assigned_to_some_users() throws Throwable {
		dTMQueueStepsPage.the_queue_is_assigned_to_some_users();
	}


	public void the_queue_is_deleted() throws Throwable {
		dTMQueueStepsPage.the_queue_is_deleted();
	}

	/**
	 * one sentence step
	 * 
	 * @throws Throwable
	 */

	public void i_have_created_a_queue_in_DTM() throws Throwable {
		dTMQueueStepsPage.i_have_created_a_queue_in_DTM();
	}


	public void i_have_created_some_queues_in_DTM() throws Throwable {
		dTMQueueStepsPage.i_have_created_some_queues_in_DTM();
	}

	/**
	 * one sentence step
	 * 
	 * @throws Throwable
	 */

	public void i_delete_the_queue_in_DTM() throws Throwable {
		dTMQueueStepsPage.i_delete_the_queue_in_DTM();
	}


	public void i_delete_all_queues_just_created_in_DTM() throws Throwable {
		dTMQueueStepsPage.i_delete_all_queues_just_created_in_DTM();
	}


	public void i_create_sample_queues_if_not_already_existing() throws Throwable {
		dTMQueueStepsPage.i_create_sample_queues_if_not_already_existing();
	}
	

	public void i_have_created_a_queue_as_in_DTM(String queueName) throws Throwable {
		dTMQueueStepsPage.i_have_created_a_queue_as_in_DTM(queueName);
	}
	

	public void i_assign_the_queue_to_roles(String queueName, String role1, String role2) throws Throwable {
		dTMQueueStepsPage.i_assign_the_queue_to_roles(queueName, role1, role2);
	}

}
