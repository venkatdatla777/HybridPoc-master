package features;



import features.steps.serenity.WorkflowCanvasStep;
import flextesting.strategistportal.defaultdata.TaskElementData;

import java.util.Map;

public class WorkflowCanvasStepDefination {


	WorkflowCanvasStep workflowCanvasStep;

	public void i_drag_the_task_to_the_workflow() throws Throwable {
		workflowCanvasStep.i_drag_the_task_to_the_workflow();
	}
	
	public void the_workflow_is_updated_with_the_task() throws Throwable {
	
		workflowCanvasStep.the_workflow_is_updated_with_the_task();
	}
	
	public void i_right_click_the_node_of_the_task() throws Throwable {
		workflowCanvasStep.i_right_click_the_node_of_the_task();
	}

	public void i_choose_from_the_right_click_menu_of_the_workflow_node(String action) throws Throwable {
		workflowCanvasStep.i_choose_from_the_right_click_menu_of_the_workflow_node(action);
	}

	public void i_drag_the_first_action_from_the_repository_to_the_left_panel() throws Throwable {
		workflowCanvasStep.i_drag_the_first_action_from_the_repository_to_the_left_panel();
	}

	public void i_choose_as_the_trigger_type_of_the_action(String triggerType) throws Throwable {
		workflowCanvasStep.i_choose_as_the_trigger_type_of_the_action(triggerType);
	}

	public void i_click_Submit_in_the_window_of_Add_Flow_Action() throws Throwable {
		workflowCanvasStep.i_click_Submit_in_the_window_of_Add_Flow_Action();
	}

	public void i_should_see_the_action_appearing_in_the_left_panel() throws Throwable {
		workflowCanvasStep.i_should_see_the_action_appearing_in_the_left_panel();
	}
	
	public void i_assign_the_task_to_some_roles() throws Throwable {
		workflowCanvasStep.i_assign_the_task_to_some_roles();
	}

	public void the_task_is_assigned_to_some_roles() throws Throwable {
		workflowCanvasStep.the_task_is_assigned_to_some_roles();
	}

	public void i_assign_the_task_to_some_users() throws Throwable {
		workflowCanvasStep.i_assign_the_task_to_some_users();
	}

	public void the_task_is_assigned_to_some_users() throws Throwable {
		workflowCanvasStep.the_task_is_assigned_to_some_users();
	}
	
	public void i_check_Synchronize_Role_User_Assignment_for_Task() throws Throwable {
		workflowCanvasStep.i_check_Synchronize_Role_User_Assignment_for_Task();
	}

	public void i_check_Synchronize_Role_User_for_all_current_Tasks_in_this_workflow() throws Throwable {
		workflowCanvasStep.i_check_Synchronize_Role_User_for_all_current_Tasks_in_this_workflow();
	}
	public void i_click_the_button_in_the_Flow_Variable_Actions_window(String addEditDelete) throws Throwable {
		workflowCanvasStep.i_click_the_button_in_the_Flow_Variable_Actions_window(addEditDelete);
	}

	public void i_choose_a_Variable_in_the_Add_Variable_Action_window() throws Throwable {
		workflowCanvasStep.i_choose_a_Variable_in_the_Add_Variable_Action_window();
	}

	public void i_choose_as_Trigger_Time(String optionName) throws Throwable {
		workflowCanvasStep.i_choose_as_Trigger_Time(optionName);
	}

	public void i_enter_in_the_IF_field(String arg1) throws Throwable {
		workflowCanvasStep.i_enter_in_the_IF_field(arg1);
	}

	public void i_etner_in_the_THEN_field(String arg1) throws Throwable {
		workflowCanvasStep.i_etner_in_the_THEN_field(arg1);
	}

	public void i_should_see_the_variable_action_shown_in_the_Flow_Variable_Action_window() throws Throwable {
		workflowCanvasStep.i_should_see_the_variable_action_shown_in_the_Flow_Variable_Action_window();
	}

	public void i_close_the_Flow_Variable_Action_window() throws Throwable {
		workflowCanvasStep.i_close_the_Flow_Variable_Action_window();
	}
	
	public void i_Select_tasks_tab_and_search_for_created_task_and_drag_it_to_the_WF(Map<String,String> data) throws Throwable {
	    workflowCanvasStep.i_Select_tasks_tab_and_search_for_created_task_and_drag_it_to_the_WF(data, TaskElementData.getDateFormatTxt());
	}

	public void i_drag_the_selected_task_to_the_workflow_canvas() throws Throwable {
	    workflowCanvasStep.i_drag_the_selected_task_to_the_workflow_canvas(TaskElementData.getDateFormatTxt());
	}
	

	public void i_drag_the_selected_task_to_the_workflow_canvas_follow_YSD() throws Throwable {
	    workflowCanvasStep.i_drag_the_selected_task_to_the_workflow_canvas_follow_YSD(TaskElementData.getDateFormatTxt());
	}


	public void i_drag_the_selected_task_to_the_workflow_canvas_follow_Jnt() throws Throwable {
	    workflowCanvasStep.i_drag_the_selected_task_to_the_workflow_canvas_follow_Jnt(TaskElementData.getDateFormatTxt());
	}
	

	public void i_assign_the_task_to_all_roles() throws Throwable {
	   workflowCanvasStep.i_assign_the_task_to_all_roles();
	}


	public void the_task_is_assigned_to_all_roles() throws Throwable {
	   workflowCanvasStep.the_task_is_assigned_to_all_roles();
	}
	

	public void i_right_click_the_node_of_the_selected_task() throws Throwable {
	   workflowCanvasStep.i_right_click_the_node_of_the_selected_task(TaskElementData.getDateFormatTxt()); 
	}
	

	public void i_choose_from_the_right_click_menu_of_the_workflow_node_of_selected_task(String action) throws Throwable {
	   workflowCanvasStep.i_choose_from_the_right_click_menu_of_the_workflow_node_of_selected_task(action); 
	}
	

	public void i_click_on_submit_button() throws Throwable {
	   workflowCanvasStep.i_click_on_submit_button();
	}
	

	public void i_click_the_To_dropDown_and_select_the_task() throws Throwable {
	    workflowCanvasStep.i_click_the_To_dropDown_and_select_the_task(TaskElementData.getDateFormatTxt());
	}
	

	public void i_Select_channels_tab_and_drag_any_one_of_the_Letter_to_the_WF_node() throws Throwable {
	    workflowCanvasStep.i_Select_channels_tab_and_drag_any_one_of_the_Letter_to_the_WF_node(TaskElementData.getDateFormatTxt());
	}


	public void i_search_select_any_one_of_them_and_drag_it_to_one_of_the_WF_node(String action) throws Throwable {
	    workflowCanvasStep.i_search_select_any_one_of_them_and_drag_it_to_one_of_the_WF_node(action, TaskElementData.getDateFormatTxt());
	}


	public void i_Select_Programs_tab_and_select_any_one_of_them_and_drag_it_to_one_of_the_WF_node() throws Throwable {
	    workflowCanvasStep.i_Select_Programs_tab_and_select_any_one_of_them_and_drag_it_to_one_of_the_WF_node(TaskElementData.getDateFormatTxt());
	}


	public void i_choose_from_the_right_click_menu_of_the_workflow_node_of_the_selected_task(String action) throws Throwable {
	    workflowCanvasStep.i_choose_from_the_right_click_menu_of_the_workflow_node_of_the_selected_task(action);
	}


	public void i_Add_Update_Action_with_the_following_informations(Map<String,String> data) throws Throwable {
	    workflowCanvasStep.i_Add_Update_Action_with_the_following_informations(data);
	}
	

	public void i_click_on_button(String arg1) throws Throwable {
	    workflowCanvasStep.i_click_on_button(arg1);
	}


	public void i_enter_Menu_Link_Text_as(String arg1) throws Throwable {
	    workflowCanvasStep.i_enter_Menu_Link_Text_as(arg1);
	}


	public void i_click_on_Add_Sub_Menu_button() throws Throwable {
	    workflowCanvasStep.i_click_on_Add_Sub_Menu_button();
	}


	public void i_enter_Sub_Menu_Title_Text_as(String arg1) throws Throwable {
	    workflowCanvasStep.i_enter_Sub_Menu_Title_Text_as(arg1);
	}


	public void i_click_on_Workflow_Primary_Flow_dropDown_and_select_as(String arg1) throws Throwable {
	    workflowCanvasStep.i_click_on_Workflow_Primary_Flow_dropDown_and_select_as(arg1);
	}


	public void i_click_on_Save_Close_button() throws Throwable {
	   workflowCanvasStep.i_click_on_Save_Close_button();
	}


	public void i_click_on_Schedule_Operation_dropDown_button_and_select_Publish_Schedule() throws Throwable {
	    workflowCanvasStep.i_click_on_Schedule_Operation_dropDown_button_and_select_Publish_Schedule();
	}

}