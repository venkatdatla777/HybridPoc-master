package features;



import features.steps.serenity.TaskStep;
import flextesting.strategistportal.defaultdata.TaskElementData;
import flextesting.utilities.DataUtil;

import java.util.Map;

public class TaskStepDefination {


	TaskStep taskStep;
	
	public void i_create_a_task() throws Throwable {
		taskStep.i_create_a_task();
	}
	

	/**
	 * here we only check the existence of the task, not checking the content of it at all.
	 * @throws Throwable
	 */
	public void the_task_should_be_created() throws Throwable {
		taskStep.the_task_should_be_created();
	}
	
	public void i_edit_the_task() throws Throwable {
		taskStep.i_edit_the_task();
	}

	public void i_delete_the_task() throws Exception {
		taskStep.i_delete_the_task();
	}
	
	public void the_task_is_deleted() throws Throwable {
		taskStep.the_task_is_deleted();
	}
	
	public void i_create_a_sample_task_if_not_already_existing() throws Throwable {
		taskStep.i_create_a_sample_task_if_not_already_existing();
	}
	
	public void i_Select_tasks_and_Add_task_with_the_following_information(Map<String,String> data) throws Throwable {
//		TaskElementData.setDateFormatTxt("201811114430");
		if(TaskElementData.getDateFormatTxt() == null){
			TaskElementData.setDateFormatTxt(DataUtil.getDateFormatTxt());
		}
		System.out.println("dataMap.get(\"Introduction for Associate Portal\") :" + data.get("Introduction for Associate Portal"));
		
	    taskStep.i_Select_tasks_and_Add_task_with_the_following_information(data,TaskElementData.getDateFormatTxt());
	}
	
	public void the_task_is_created() throws Throwable {
	    taskStep.the_task_is_created(TaskElementData.getDateFormatTxt());
	}
	
}
