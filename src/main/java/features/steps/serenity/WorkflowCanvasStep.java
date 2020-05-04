package features.steps.serenity;



import flextesting.strategistportal.workflowmanager.WorkflowCanvasStepsPage;

import java.util.Map;

public class WorkflowCanvasStep {
	WorkflowCanvasStepsPage workflowCanvasStepsPage;


	public void i_drag_the_task_to_the_workflow() throws Throwable {
		workflowCanvasStepsPage.i_drag_the_task_to_the_workflow();
	}
	

	public void the_workflow_is_updated_with_the_task() throws Throwable {
		//TODO
		workflowCanvasStepsPage.the_workflow_is_updated_with_the_task();
	}
	

	public void i_right_click_the_node_of_the_task() throws Throwable {
		workflowCanvasStepsPage.i_right_click_the_node_of_the_task();
	}


	public void i_choose_from_the_right_click_menu_of_the_workflow_node(String action) throws Throwable {
		workflowCanvasStepsPage.i_choose_from_the_right_click_menu_of_the_workflow_node(action);
	}


	public void i_drag_the_first_action_from_the_repository_to_the_left_panel() throws Throwable {
		workflowCanvasStepsPage.i_drag_the_first_action_from_the_repository_to_the_left_panel();
	}


	public void i_choose_as_the_trigger_type_of_the_action(String triggerType) throws Throwable {
		workflowCanvasStepsPage.i_choose_as_the_trigger_type_of_the_action(triggerType);
	}


	public void i_click_Submit_in_the_window_of_Add_Flow_Action() throws Throwable {
		workflowCanvasStepsPage.i_click_Submit_in_the_window_of_Add_Flow_Action();
	}


	public void i_should_see_the_action_appearing_in_the_left_panel() throws Throwable {
		workflowCanvasStepsPage.i_should_see_the_action_appearing_in_the_left_panel();
	}
	

	public void i_assign_the_task_to_some_roles() throws Throwable {
		workflowCanvasStepsPage.i_assign_the_task_to_some_roles();
	}


	public void the_task_is_assigned_to_some_roles() throws Throwable {
		workflowCanvasStepsPage.the_task_is_assigned_to_some_roles();
	}


	public void i_assign_the_task_to_some_users() throws Throwable {
		workflowCanvasStepsPage.i_assign_the_task_to_some_users();
	}


	public void the_task_is_assigned_to_some_users() throws Throwable {
		workflowCanvasStepsPage.the_task_is_assigned_to_some_users();
	}
	

	public void i_check_Synchronize_Role_User_Assignment_for_Task() throws Throwable {
		workflowCanvasStepsPage.i_check_Synchronize_Role_User_Assignment_for_Task();
	}


	public void i_check_Synchronize_Role_User_for_all_current_Tasks_in_this_workflow() throws Throwable {
		workflowCanvasStepsPage.i_check_Synchronize_Role_User_for_all_current_Tasks_in_this_workflow();
	}

	public void i_click_the_button_in_the_Flow_Variable_Actions_window(String addEditDelete) throws Throwable {
		workflowCanvasStepsPage.i_click_the_button_in_the_Flow_Variable_Actions_window(addEditDelete);
	}


	public void i_choose_a_Variable_in_the_Add_Variable_Action_window() throws Throwable {
		workflowCanvasStepsPage.i_choose_a_Variable_in_the_Add_Variable_Action_window();
	}


	public void i_choose_as_Trigger_Time(String optionName) throws Throwable {
		workflowCanvasStepsPage.i_choose_as_Trigger_Time(optionName);
	}


	public void i_enter_in_the_IF_field(String arg1) throws Throwable {
		workflowCanvasStepsPage.i_enter_in_the_IF_field(arg1);
	}


	public void i_etner_in_the_THEN_field(String arg1) throws Throwable {
		workflowCanvasStepsPage.i_etner_in_the_THEN_field(arg1);
	}


	public void i_should_see_the_variable_action_shown_in_the_Flow_Variable_Action_window() throws Throwable {
		workflowCanvasStepsPage.i_should_see_the_variable_action_shown_in_the_Flow_Variable_Action_window();
	}


	public void i_close_the_Flow_Variable_Action_window() throws Throwable {
		workflowCanvasStepsPage.i_close_the_Flow_Variable_Action_window();
	}
	

	public void i_Select_tasks_tab_and_search_for_created_task_and_drag_it_to_the_WF(Map<String,String> data, String dateFormat) throws Throwable {
	    workflowCanvasStepsPage.i_Select_tasks_tab_and_search_for_created_task_and_drag_it_to_the_WF(data, dateFormat);
	}


	public void i_drag_the_selected_task_to_the_workflow_canvas(String dateFormat) throws Throwable {
	  workflowCanvasStepsPage.i_drag_the_selected_task_to_the_workflow_canvas(dateFormat);  
	}
	

	public void i_drag_the_selected_task_to_the_workflow_canvas_follow_YSD(String dateFormat) throws Throwable {
	   workflowCanvasStepsPage.i_drag_the_selected_task_to_the_workflow_canvas_follow_YSD(dateFormat); 
	}


	public void i_drag_the_selected_task_to_the_workflow_canvas_follow_Jnt(String dateFormat) throws Throwable {
	    workflowCanvasStepsPage.i_drag_the_selected_task_to_the_workflow_canvas_follow_Jnt(dateFormat);
	}
	

	public void i_assign_the_task_to_all_roles() throws Throwable {
	   workflowCanvasStepsPage.i_assign_the_task_to_all_roles();
	}


	public void the_task_is_assigned_to_all_roles() throws Throwable {
	   workflowCanvasStepsPage.the_task_is_assigned_to_all_roles();
	}
	

	public void i_right_click_the_node_of_the_selected_task(String dateFormat) throws Throwable {
	   workflowCanvasStepsPage.i_right_click_the_node_of_the_selected_task(dateFormat); 
	}
	

	public void i_choose_from_the_right_click_menu_of_the_workflow_node_of_selected_task(String action) throws Throwable {
	   workflowCanvasStepsPage.i_choose_from_the_right_click_menu_of_the_workflow_node_of_selected_task(action); 
	}
	

	public void i_click_on_submit_button() throws Throwable {
	   workflowCanvasStepsPage.i_click_on_submit_button();
	}
	

	public void i_click_the_To_dropDown_and_select_the_task(String dateFormat) throws Throwable {
	    workflowCanvasStepsPage.i_click_the_To_dropDown_and_select_the_task(dateFormat);
	}
	

	public void i_Select_channels_tab_and_drag_any_one_of_the_Letter_to_the_WF_node(String dateFormat) throws Throwable {
	    workflowCanvasStepsPage.i_Select_channels_tab_and_drag_any_one_of_the_Letter_to_the_WF_node(dateFormat);
	}


	public void i_search_select_any_one_of_them_and_drag_it_to_one_of_the_WF_node(String action, String dateFormat) throws Throwable {
	    workflowCanvasStepsPage.i_search_select_any_one_of_them_and_drag_it_to_one_of_the_WF_node(action, dateFormat);
	}


	public void i_Select_Programs_tab_and_select_any_one_of_them_and_drag_it_to_one_of_the_WF_node(String dateFormat) throws Throwable {
	    workflowCanvasStepsPage.i_Select_Programs_tab_and_select_any_one_of_them_and_drag_it_to_one_of_the_WF_node(dateFormat);
	}


	public void i_choose_from_the_right_click_menu_of_the_workflow_node_of_the_selected_task(String action) throws Throwable {
	    workflowCanvasStepsPage.i_choose_from_the_right_click_menu_of_the_workflow_node_of_the_selected_task(action);
	}


	public void i_Add_Update_Action_with_the_following_informations(Map<String,String> data) throws Throwable {
	    workflowCanvasStepsPage.i_Add_Update_Action_with_the_following_informations(data);
	}
	

	public void i_click_on_button(String arg1) throws Throwable {
	    workflowCanvasStepsPage.i_click_on_button(arg1);
	}


	public void i_enter_Menu_Link_Text_as(String arg1) throws Throwable {
	    workflowCanvasStepsPage.i_enter_Menu_Link_Text_as(arg1);
	}


	public void i_click_on_Add_Sub_Menu_button() throws Throwable {
	    workflowCanvasStepsPage.i_click_on_Add_Sub_Menu_button();
	}


	public void i_enter_Sub_Menu_Title_Text_as(String arg1) throws Throwable {
	    workflowCanvasStepsPage.i_enter_Sub_Menu_Title_Text_as(arg1);
	}


	public void i_click_on_Workflow_Primary_Flow_dropDown_and_select_as(String arg1) throws Throwable {
	    workflowCanvasStepsPage.i_click_on_Workflow_Primary_Flow_dropDown_and_select_as(arg1);
	}


	public void i_click_on_Save_Close_button() throws Throwable {
	   workflowCanvasStepsPage.i_click_on_Save_Close_button();
	}


	public void i_click_on_Schedule_Operation_dropDown_button_and_select_Publish_Schedule() throws Throwable {
	    workflowCanvasStepsPage.i_click_on_Schedule_Operation_dropDown_button_and_select_Publish_Schedule();
	}

}