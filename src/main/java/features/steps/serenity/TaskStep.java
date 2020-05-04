package features.steps.serenity;



import flextesting.strategistportal.workflowmanager.TaskStepsPage;

import java.util.Map;

public class TaskStep {

	TaskStepsPage taskStepsPage;


	public void i_create_a_task() throws Throwable {
		taskStepsPage.i_create_a_task();
	}

	/**
	 * here we only check the existence of the task, not checking the content of
	 * it at all.
	 * 
	 * @throws Throwable
	 */

	public void the_task_should_be_created() throws Throwable {
		taskStepsPage.the_task_should_be_created();
	}


	public void i_edit_the_task() throws Throwable {
		taskStepsPage.i_edit_the_task();
	}


	public void i_delete_the_task() throws Exception {
		taskStepsPage.i_delete_the_task();
	}


	public void the_task_is_deleted() throws Throwable {
		// TODO
	}


	public void i_create_a_sample_task_if_not_already_existing() throws Throwable {
		taskStepsPage.i_create_a_sample_task_if_not_already_existing();
	}
	

	public void i_Select_tasks_and_Add_task_with_the_following_information(Map<String,String> data, String dateFormat) throws Throwable {
		System.out.println("dataMap.get(\"Introduction for Associate Portal\") :" + data.get("Introduction for Associate Portal"));
		taskStepsPage.i_Select_tasks_and_Add_task_with_the_following_information(data, dateFormat);
	}
	

	public void the_task_is_created(String dateFormat) throws Throwable {
	    taskStepsPage.the_task_is_created(dateFormat);
	}

}
