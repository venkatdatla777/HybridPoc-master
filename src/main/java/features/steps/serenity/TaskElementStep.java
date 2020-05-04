package features.steps.serenity;


import flextesting.strategistportal.workflowmanager.TaskElementStepsPage;

import java.util.Map;

public class TaskElementStep {

	TaskElementStepsPage taskElementStepsPage;


	public void i_create_a_task_element() throws Throwable {
		taskElementStepsPage.i_create_a_task_element();
	}


	public void the_task_element_is_created() throws Throwable {
		taskElementStepsPage.the_task_element_is_created();
	}


	public void i_delete_the_task_element() throws Throwable {
		taskElementStepsPage.i_delete_the_task_element();
	}


	public void the_task_element_is_deleted() throws Throwable {
		// TODO
	}


	public void i_create_a_sample_task_element_if_not_already_existing() throws Throwable {
		taskElementStepsPage.i_create_a_sample_task_element_if_not_already_existing();
	}
	

	public void i_create_a_task_element_with_the_following_informations(Map<String,String> data, String dateFormat) throws Throwable {
		taskElementStepsPage.i_create_a_task_element_with_the_following_informations(data, dateFormat);
	}
}
