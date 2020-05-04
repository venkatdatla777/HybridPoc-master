package features;



import features.steps.serenity.TaskElementStep;
import flextesting.strategistportal.defaultdata.TaskElementData;
import flextesting.utilities.DataUtil;

import java.util.Map;

public class TaskElementStepDefination {


	TaskElementStep taskStep;
	
	public void i_create_a_task_element() throws Throwable {
		taskStep.i_create_a_task_element();
	}	
	
	public void the_task_element_is_created() throws Throwable {
		taskStep.the_task_element_is_created();
	}

	public void i_delete_the_task_element() throws Throwable {
		taskStep.i_delete_the_task_element();
	}

	public void the_task_element_is_deleted() throws Throwable {
		//TODO
		taskStep.the_task_element_is_deleted();
	}
	
	public void i_create_a_sample_task_element_if_not_already_existing() throws Throwable {
		taskStep.i_create_a_sample_task_element_if_not_already_existing();
	}
	
	// New Steps
	public void i_create_a_task_element_with_the_following_informations(Map<String,String> data) throws Throwable {
		if(TaskElementData.getDateFormatTxt() == null){
			TaskElementData.setDateFormatTxt(DataUtil.getDateFormatTxt());
		}
		taskStep.i_create_a_task_element_with_the_following_informations(data, TaskElementData.getDateFormatTxt());	
	}
	
}
