package features;



import features.steps.serenity.WorkflowCreationStep;

import java.util.Map;

public class WorkflowCreationStepDefination {

	WorkflowCreationStep workflowCreationStep;

	public void i_have_chosen_for_View_Container(String viewName) throws Throwable {
		workflowCreationStep.i_have_chosen_for_View_Container(viewName);
	}

	public void i_create_a_workflow_with_the_following_information(Map<String, String> data) throws Throwable {
		workflowCreationStep.i_create_a_workflow_with_the_following_information(data);
	}

	public void i_create_a_workflow_with_the_name(String name) throws Throwable {
		workflowCreationStep.i_create_a_workflow_with_the_name(name);
	}

	public void i_enter_as_the_entry_criteria(String criteria) throws Throwable {
		workflowCreationStep.i_enter_as_the_entry_criteria(criteria);
	}

	public void the_workflow_should_be_created() throws Throwable {
		workflowCreationStep.the_workflow_should_be_created();
	}

	public void i_have_created_a_workflow() throws Throwable {
		workflowCreationStep.i_have_created_a_workflow();
	}

	// ============================NEW============================
	public void i_select_the_workflow_just_created() throws Throwable {
		workflowCreationStep.i_select_the_workflow_just_created();
	}

	public void i_click_the_button_in_the_workflow_creation_panel(String arg1) throws Throwable {
		workflowCreationStep.i_click_the_button_in_the_workflow_creation_panel(arg1);
	}

	public void i_enter_as_the_Tag_for_the_workflow(String arg1) throws Throwable {
		workflowCreationStep.i_enter_as_the_Tag_for_the_workflow(arg1);
	}

	public void the_workflow_is_saved() throws Throwable {
		workflowCreationStep.the_workflow_is_saved();
	}

	public void the_workflow_copy_is_saved() throws Throwable {
		workflowCreationStep.the_workflow_copy_is_saved();
	}

	public void the_workflow_copy_is_deleted() throws Throwable {
		workflowCreationStep.the_workflow_copy_is_deleted();
	}

	// new steps
	public void i_create_a_workflow_with_the_following_informations(Map<String, String> data) throws Throwable {
		workflowCreationStep.i_create_a_workflow_with_the_following_informations(data);
	}

	public void i_Select_Assignment_and_add_Available_Roles(Map<String, String> data) throws Throwable {
		workflowCreationStep.i_Select_Assignment_and_add_Available_Roles(data);
	}

	public void the_Roles_are_assigned_to_Workflow() throws Throwable {
		workflowCreationStep.the_Roles_are_assigned_to_Workflow();
	}

	public void i_bouble_click_on_Standard_Financial_Statement_in_Current_tab() throws Throwable {
		workflowCreationStep.i_bouble_click_on_Standard_Financial_Statement_in_Current_tab();
	}

	public void i_click_on_Type_of_Budget_dropDown_and_select_and_click_on_Start_button(String arg1) throws Throwable {
		workflowCreationStep.i_click_on_Type_of_Budget_dropDown_and_select_and_click_on_Start_button(arg1);
	}

	public void i_choose_one_option_form_Your_Accommodation_dropDown() throws Throwable {
		workflowCreationStep.i_choose_one_option_form_Your_Accommodation_dropDown();
	}

	public void i_click_Full_time_checkbox_and_click_on_next_button() throws Throwable {
		workflowCreationStep.i_click_Full_time_checkbox_and_click_on_next_button();
	}

	public void i_click_on_close_button_and_then_close_window() throws Throwable {
		workflowCreationStep.i_click_on_close_button_and_then_close_window();
	}

	public void i_click_the_Disposition_icon_at_the_account_level() throws Throwable {
		workflowCreationStep.i_click_the_Disposition_icon_at_the_account_level();
	}

	public void i_click_Payment_Made_radio_button_and_Submit_Close_Account_button() throws Throwable {
		workflowCreationStep.i_click_Payment_Made_radio_button_and_Submit_Close_Account_button();
	}
}
