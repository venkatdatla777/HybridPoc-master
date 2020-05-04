package flextesting.strategistportal.workflowmanager;


import com.qa.base.TestBase;
import flextesting.pagefactories.CommonElementsFactory;
import flextesting.pagefactories.strategistportal.workflowmanager.AssignRoleAndUserFactory;
import flextesting.pagefactories.strategistportal.workflowmanager.TaskFactory;
import flextesting.pagefactories.strategistportal.workflowmanager.WorkflowCanvasFactory;
import flextesting.pagefactories.strategistportal.workflowmanager.WorkflowCreationPanelFactory;
import flextesting.strategistportal.defaultdata.TaskData;
import flextesting.strategistportal.defaultdata.WorkflowData;
import flextesting.strategistportal.workflowmanager.data.VariableData;
import org.apache.log4j.Logger;

import java.util.Map;

import static flextesting.utilities.Utils.*;


public class WorkflowCanvasStepsPage extends TestBase {

	static Logger log = Logger.getLogger(WorkflowCanvasStepsPage.class);
	private WorkflowCanvasFactory workflowCanvas;
	private TaskFactory task;
	private WorkflowCreationPanelFactory wcp;
	private String taskCode = TaskData.dataMap.get("Permanent Task Code");
	protected Map<String,String> dataMap = TaskData.dataMap;
	public static Map<String,String> dataMap2 = WorkflowData.dataMap;

	/**
	 * use this to get the workflow name
	 */
	private String workflowName = WorkflowCreationStepsPage.dataMap.get("Workflow Name");
	private AssignRoleAndUserFactory assignRoleAndUserFactory;
	private CommonElementsFactory commonElementsFactory;

	public void i_drag_the_task_to_the_workflow() throws Throwable {
		workflowCanvas.dragTaskAndDropToWorkflow(taskCode, workflowName);
		Thread.sleep(3000);
	}

	public void the_workflow_is_updated_with_the_task() throws Throwable {
		// TODO
	}

	public void i_right_click_the_node_of_the_task() throws Throwable {
		workflowCanvas.rightclick_taskNode(taskCode);
	}

	public void i_choose_from_the_right_click_menu_of_the_workflow_node(String action) throws Throwable {
		workflowCanvas.chooseActionFromRightClickMenuOfNode(action);
	}

	public void i_drag_the_first_action_from_the_repository_to_the_left_panel() throws Throwable {
		workflowCanvas.dragActionToLeftPanel();
	}

	public void i_choose_as_the_trigger_type_of_the_action(String triggerType) throws Throwable {
		workflowCanvas.chooseAsTriggerType(triggerType);
	}

	public void i_click_Submit_in_the_window_of_Add_Flow_Action() throws Throwable {
		workflowCanvas.click_Submit_window_AddFlowAction();
	}

	public void i_should_see_the_action_appearing_in_the_left_panel() throws Throwable {
		workflowCanvas.present_chosenProgramInLeftPanel();
		workflowCanvas.click_close_window_CurrentActionsOnNode();
	}

	public void i_assign_the_task_to_some_roles() throws Throwable {
		assignRoleAndUserFactory.assignTheFirstAvailableRole();
	}

	public void the_task_is_assigned_to_some_roles() throws Throwable {
		assignRoleAndUserFactory.checkAssignedRole();
	}

	public void i_assign_the_task_to_some_users() throws Throwable {
		assignRoleAndUserFactory.assignTheFirstAvailableUser();
	}

	public void the_task_is_assigned_to_some_users() throws Throwable {
		assignRoleAndUserFactory.checkAssignedUser();
	}

	public void i_check_Synchronize_Role_User_Assignment_for_Task() throws Throwable {
		clickByXpath(getDriver(),
				"//label[contains(text(),'Synchronize Role/User Assignment for Task')]//preceding-sibling::input");
	}

	public void i_check_Synchronize_Role_User_for_all_current_Tasks_in_this_workflow() throws Throwable {
		clickByXpath(getDriver(),
				"//label[contains(text(),'Synchronize Role/User for all current Tasks in this workflow')]//preceding-sibling::input");
	}

	public void i_click_the_button_in_the_Flow_Variable_Actions_window(String addEditDelete) throws Throwable {
		clickByXpath(getDriver(),
				"//div[starts-with(@id,'workflownodeactionvariablelist')]//span[text()='" + addEditDelete + "']");
	}

	public void i_choose_a_Variable_in_the_Add_Variable_Action_window() throws Throwable {
		commonElementsFactory.arrowTrigger("Variable:");
		commonElementsFactory.chooseAnOptionByName(VariableData.getPermanentName());
	}

	public void i_choose_as_Trigger_Time(String optionName) throws Throwable {
		commonElementsFactory.arrowTrigger("Trigger Time:");
		commonElementsFactory.chooseAnOptionByName(optionName);
	}

	public void i_enter_in_the_IF_field(String arg1) throws Throwable {
		clearAndEnter(getDriver(), "(//div[text()='IF']//following::div[starts-with(@id,'ace-editor')]//textarea)[1]",
				arg1);
	}

	public void i_etner_in_the_THEN_field(String arg1) throws Throwable {
		String xpath = "(//div[text()='THEN']//following::div[starts-with(@id,'ace-editor')]//textarea)[1]";
		clearAndEnter(getDriver(), xpath, arg1);
		// without clicking something, the 'save' button will keep being
		// grayed-out. so here we just click the window title
		clickByXpath(getDriver(), "//span[text()='Add Variable Action']");
	}

	public void i_should_see_the_variable_action_shown_in_the_Flow_Variable_Action_window() throws Throwable {
		isElementDisplayed_clickIfNeeded(0, getDriver(),
				"//div[starts-with(@id,'workflownodeactionvariablelist')]//div[text()='" + VariableData.getName()
						+ "']",
				true, false);
	}

	public void i_close_the_Flow_Variable_Action_window() throws Throwable {
		commonElementsFactory.closeWindow("Flow Variable Actions");
		// wait 1 sec for the workflow to update with the variable action
		Thread.sleep(1000);
	}
	
	public void i_Select_tasks_tab_and_search_for_created_task_and_drag_it_to_the_WF(Map<String,String> data, String dateFormat) throws Throwable {
		dataMap = data;
//		task.click_tab_Tasks();
		String search = dataMap.get("Search");
		search = search + "_" + dateFormat;
		task.search_TaskByTaskCode(search);
		task.present_TaskCode(search);
//		workflowCanvas.i_drag_the_selected_task_to_the_workflow_canvas(search, workflowName);
	}

	public void i_drag_the_selected_task_to_the_workflow_canvas(String dateFormat) throws Throwable {
		String workflowName = dataMap2.get("Workflow Name"); 
		String search = dataMap.get("Search");
		search = search + "_" + dateFormat;
		task.search_TaskByTaskCode(search);
	    workflowCanvas.i_drag_the_selected_task_to_the_workflow_canvas(search, workflowName);
	    Thread.sleep(3000);
	}
	
	public void i_drag_the_selected_task_to_the_workflow_canvas_follow_YSD(String dateFormat) throws Throwable {
		String YSDlink = "YSD" + "_" + dateFormat;
		String search = dataMap.get("Search");
		search = search + "_" + dateFormat;
		workflowCanvas.i_drag_the_selected_task_to_the_workflow_canvas_follow_YSD(search, YSDlink);
	    Thread.sleep(3000);
	}

	public void i_drag_the_selected_task_to_the_workflow_canvas_follow_Jnt(String dateFormat) throws Throwable {
		String Jntlink = "Jnt" + "_" + dateFormat;
		String search = dataMap.get("Search");
		search = search + "_" + dateFormat;
		workflowCanvas.i_drag_the_selected_task_to_the_workflow_canvas_follow_Jnt(search, Jntlink);
	    Thread.sleep(3000);
	}
	
	public void i_assign_the_task_to_all_roles() throws Throwable {
		workflowCanvas.click_MoveAllLeftRowsToRightSide();
	}

	public void the_task_is_assigned_to_all_roles() throws Throwable {
		assignRoleAndUserFactory.checkAssignedRole();
	}
	
	public void i_right_click_the_node_of_the_selected_task(String dateFormat) throws Throwable {
		String search = dataMap.get("Search");
		search = search + "_" + dateFormat;
	    workflowCanvas.rightClickTaskNode(search);
	}
	
public void i_choose_from_the_right_click_menu_of_the_workflow_node_of_selected_task(String action) throws Throwable {
	    workflowCanvas.chooseActionFromRightClickMenuOfNodeOfTheSelectedTask(action);
	}

   public void i_click_on_submit_button() throws Throwable {
	   workflowCanvas.clickSubmitbtn();
	   Thread.sleep(1500);
   }
   
	public void i_click_the_To_dropDown_and_select_the_task(String dateFormat) throws Throwable {
		String search = dataMap.get("Search");
		search = search + "_" + dateFormat;
	    workflowCanvas.i_click_the_To_dropDown_and_select_the_task(search);
	}
	
   public void i_Select_channels_tab_and_drag_any_one_of_the_Letter_to_the_WF_node(String dateFormat) throws Throwable {
	    workflowCanvas.click_tab_Channels();
	    String search = dataMap.get("Search");
		search = search + "_" + dateFormat;
		workflowCanvas.i_drag_the_selected_item_to_the_workflow_Node(null, search);
		Thread.sleep(2000);
		workflowCanvas.clickSubmitbtn();
		Thread.sleep(2000);
	}

	public void i_search_select_any_one_of_them_and_drag_it_to_one_of_the_WF_node(String action, String dateFormat) throws Throwable {
		String search = dataMap.get("Search");
		search = search + "_" + dateFormat;
	    workflowCanvas.search_Email(action);
	    workflowCanvas.i_drag_the_selected_item_to_the_workflow_Node(null, search);
	    Thread.sleep(2000);
	    workflowCanvas.clickSubmitbtn();
		Thread.sleep(2000);
	    
	}

	public void i_Select_Programs_tab_and_select_any_one_of_them_and_drag_it_to_one_of_the_WF_node(String dateFormat) throws Throwable {
	    workflowCanvas.click_tab_Programs();
	    String search = dataMap.get("Search");
		search = search + "_" + dateFormat;
		workflowCanvas.i_drag_the_selected_programs_item_to_the_workflow_Node(null, search);
		Thread.sleep(3000);
		workflowCanvas.clickSubmitbtn();
		Thread.sleep(3000);
	}

	public void i_choose_from_the_right_click_menu_of_the_workflow_node_of_the_selected_task(String action) throws Throwable {
	    workflowCanvas.chooseActionFromRightClickMenuOfNodeOfTheTask(action);
	}

	public void i_Add_Update_Action_with_the_following_informations(Map<String,String> data) throws Throwable {
		dataMap = data;
		String variable = dataMap.get("Variable:");
		workflowCanvas.clickAddbtn();
		workflowCanvas.clickDropDownAndSelectTheVariable(variable);
		workflowCanvas.enter_Text_as_true(dataMap.get("IF"));
		workflowCanvas.enter_billingCycle_Text(dataMap.get("billingCycle ="));
		workflowCanvas.clickSavebtn();
		workflowCanvas.clickClosebtn();
	}
	
	public void i_click_on_button(String arg1) throws Throwable {
	    workflowCanvas.clickCustomerPortalSubMenubtn(arg1);
	}

	public void i_enter_Menu_Link_Text_as(String arg1) throws Throwable {
	    workflowCanvas.enter_Menu_Link_Text(arg1);
	}

	public void i_click_on_Add_Sub_Menu_button() throws Throwable {
	    workflowCanvas.clickAdd_Sub_Menu_btn();
	}

	public void i_enter_Sub_Menu_Title_Text_as(String arg1) throws Throwable {
	    workflowCanvas.enter_Sub_Menu_Title_Text(arg1);
	}

	public void i_click_on_Workflow_Primary_Flow_dropDown_and_select_as(String arg1) throws Throwable {
	    workflowCanvas.i_click_on_Workflow_Primary_Flow_dropDown_and_select_as(arg1);
	}

	public void i_click_on_Save_Close_button() throws Throwable {
		workflowCanvas.clickSaveClose_btn();
		workflowCanvas.clickOnSaveClose_btn();
	   
	}

	public void i_click_on_Schedule_Operation_dropDown_button_and_select_Publish_Schedule() throws Throwable {
	    workflowCanvas.click_on_Schedule_Operation_dropDown_button_and_select_Publish_Schedule();
	}
}
