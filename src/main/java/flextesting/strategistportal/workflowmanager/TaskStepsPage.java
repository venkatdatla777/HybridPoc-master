package flextesting.strategistportal.workflowmanager;


import com.qa.base.TestBase;
import flextesting.pagefactories.strategistportal.workflowmanager.TaskElementFactory;
import flextesting.pagefactories.strategistportal.workflowmanager.TaskFactory;
import flextesting.strategistportal.defaultdata.TaskData;
import flextesting.strategistportal.defaultdata.TaskElementData;
import flextesting.utilities.DataUtil;
import flextesting.utilities.Utils;
import org.openqa.selenium.By;

import java.util.Map;

import static flextesting.utilities.Utils.clearAndEnter;


public class TaskStepsPage extends TestBase {
	private TaskFactory task;
	protected Map<String,String> dataMap = TaskData.dataMap;

	/**
	 * use this to get the taskElementCode 
	 */
	private TaskElementFactory taskElementFactory;
	private TaskElementStepsPage taskElementSteps;


	
	public void i_create_a_task() throws Throwable {
//		createTask(dataMap.get("Task Name"), dataMap.get("Task Code"), dataMap.get("Element 1"));
		createTask(dataMap.get("Task Name"), dataMap.get("Task Code"), TaskElementData.getElementCode());
	}
	
	private void createTask(String taskName, String taskCode, String Element1) throws InterruptedException {
		task.click_tab_Tasks();
		task.click_Add();
		task.enter_TaskName(taskName);
		task.enter_TaskCode(taskCode);
		task.enter_IntroductionForFlexStation(dataMap.get("Introduction for Associate Portal"));
		task.enter_IntroductionForFlexSite(dataMap.get("Introduction for Customer Portal"));
		task.click_Elements();
		task.search_taskElementByCode(Element1);
		task.dragTaskElementAndDropToGroup(Element1, dataMap.get("Group"));
		task.click_OK_window_ElementToTask();
		task.click_SaveAsDraft();
		task.message_TaskSaved_OK();
		task.click_Publish();
		task.message_TaskPublished_OK();	
	}

	/**
	 * here we only check the existence of the task, not checking the content of it at all.
	 * @throws Throwable
	 */
	
	public void the_task_should_be_created() throws Throwable {
		String taskCode = dataMap.get("Task Code");
		task.search_TaskByCode(taskCode);
		task.present_Task(taskCode);
	}
	
	
	public void i_edit_the_task() throws Throwable {
		task.click_tab_Tasks();
		task.search_TaskByCode(dataMap.get("Task Code"));
		task.choose_TaskByCode(dataMap.get("Task Code"));
		task.click_Edit();
		task.click_Elements();
		//remove the old task element
		task.choose_TaskElementByCode_window_AssignedElements(TaskElementData.getElementCode());
		task.click_Delete_window_AssignedElements();
		task.confirmation_DeleteTaskElementFromGourp_Yes();
		//assign the first task element to the group (it's possible this element is the same one we just removed)
		task.dragTaskElementAndDropToGroup(1, dataMap.get("Group"));
		//assign a specific task element by code to the group
//		task.dragTaskElementAndDropToGroup("/*an element code*/", dataMap.get("Group"));
		task.click_OK_window_ElementToTask();
		task.click_SaveAsDraft();
		task.message_TaskSaved_OK();
		task.click_Publish();
		task.message_TaskPublished_OK();
	}

	
	public void i_delete_the_task() throws Exception {
		if(task.isTaskCreated()) {
			task.click_tab_Tasks();
			task.search_TaskByCode(dataMap.get("Task Code"));
			task.choose_TaskByCode(dataMap.get("Task Code"));
			task.click_Delete();	
		}
	}
	
	
	public void the_task_is_deleted() throws Throwable {
		//TODO
	}
	
	
	public void i_create_a_sample_task_if_not_already_existing() throws Throwable {
		String taskCode = dataMap.get("Permanent Task Code");
		task.click_tab_Tasks();
		clearAndEnter(getDriver(), "//div[starts-with(@id,'tasklist')]//div[starts-with(@id,'toolbar')]//table//input", taskCode);
		//find and click the search icon
		getDriver().findElement(By.xpath("//div[starts-with(@id,'tasklist')]//div[starts-with(@id,'toolbar')]//table//td//div[@role='button' and contains(@class,'search-trigger')]")).click();
		//continue creating permanent task if not already existing.
		String xpathTask = "//div[starts-with(@id,'tasklist') and contains(@id,'body')]//div[contains(@class,'x-grid-cell-inner') and text()='"+taskCode+"']//ancestor::tr";
		if (!Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), xpathTask, true, false)) {
			createTask(dataMap.get("Permanent Task Name"), taskCode, dataMap.get("Permanent Element 1"));
		}
	}
	
	
	public void i_Select_tasks_and_Add_task_with_the_following_information(Map<String,String> data, String dateFormat) throws Throwable {
		System.out.println("dataMap.get(\"Introduction for Associate Portal\") :" + data.get("Introduction for Associate Portal"));
		dataMap = data;
		String taskCode = dataMap.get("Task Code");
		taskCode = taskCode + "_" + dateFormat;
		System.out.println("taskCode : " + taskCode);
		String taskName = dataMap.get("Task Name") + "_" + DataUtil.getDateFormatTxt();
		String Element1 = TaskElementData.getDateFormatTxt();
		task.click_tab_Tasks();
		task.click_Add();
		task.enter_TaskName(taskName);
		task.enter_TaskCode(taskCode);
		task.enter_Description(dataMap.get("Description"));
		task.enterIntroductionForFlexStation(dataMap.get("Introduction for Associate Portal"));
		task.click_checkbox_ShowPostscriptForFlexStation();
		task.click_checkbox_ShowPrintButtonInFlexStation();
		task.enterIntroductionForFlexSite(dataMap.get("Introduction for Customer Portal"));
		task.click_checkbox_ShowPostscriptForFlexSite();
		task.click_checkbox_ShowPrintButtonInFlexSite();
		task.enter_SubmitButtonText(dataMap.get("Submit Button Text"));
		
		if(dataMap.get("Is this a Customer Involved Task?") != null && dataMap.get("Is this a Customer Involved Task?").equals("No")) {
			task.click_checkbox_IsThisACustomerInvolvedTask();
		}
		
		if(dataMap.get("Make task an \"End Page\"") != null && dataMap.get("Make task an \"End Page\"").equals("Yes")) {
			task.click_checkbox_MakeTaskAnEndPage();
		}
		
		if(dataMap.get("Show Confirm Button") != null && dataMap.get("Show Confirm Button").equals("No")) {
			task.click_checkbox_ShowConfirmButton();
		}
		
		if (dataMap.get("Button Alignment Mode") != null) {
			task.choose_BtnAlignmentMode(dataMap.get("Button Alignment Mode"));
		}
		
		if (dataMap.get("Allow Cancel Workflow in Customer Portal") != null) {
			if (dataMap.get("Allow Cancel Workflow in Customer Portal").equals("yes")) {
				task.click_checkbox_AllowCancelWorkflowInCustomerPortal();
			}
		}
		
		if (dataMap.get("Allow Cancel Workflow in Associate Portal") != null) {
			if (dataMap.get("Allow Cancel Workflow in Associate Portal").equals("yes")) {
				task.click_checkbox_AllowCancelWorkflowInCustomerPortal();
			}
		}
		
		if(dataMap.get("Group Header Text1") != null) {
			task.click_Elements();
			task.search_taskElementByCode(Element1);
		
		if (dataMap.get("Elements1") != null) {
			String element[] = dataMap.get("Elements1").split(", ");
			String groupName1 = dataMap.get("Group Header Text1");
			if(!groupName1.equals("Default") && dataMap.get("Group Header Text1").contains("Creditor One")) {
				System.out.println("groupName1 :" + groupName1);
				task.addGroup(groupName1);
			}
			for(int i = 0 ; i < element.length ; i++) {
				task.dragTaskElementAndDropToGroup(element[i]+"_"+Element1, groupName1);
				
			}
		}
		if (dataMap.get("Elements2") != null) {
			String element[] = dataMap.get("Elements2").split(", ");
			String groupName2 = dataMap.get("Group Header Text2");
			if(!groupName2.equals("Default") && dataMap.get("Group Header Text2").contains("Creditor Two")) {
				System.out.println("groupName2 :" + groupName2);
				task.addGroup(groupName2);
			}
			for(int i = 0 ; i < element.length ; i++) {
				task.dragTaskElementAndDropToGroup(element[i]+"_"+Element1, groupName2);
				
			}
		}
		task.click_OK_window_ElementToTask();
   }
		task.click_SaveAsDraft();
		task.message_TaskSaved_OK();
		task.click_Publish();
		task.message_TaskPublished_OK();
		
		
	}
	
	public void the_task_is_created(String dateFormat) throws Throwable {
		String taskCode = dataMap.get("Task Code");
		taskCode = taskCode + "_" + dateFormat;
		task.search_TaskByTaskCode(taskCode);
		task.present_TaskCode(taskCode);
	}
	
}
