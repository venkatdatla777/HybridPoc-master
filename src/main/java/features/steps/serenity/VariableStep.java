package features.steps.serenity;


import flextesting.strategistportal.workflowmanager.VariableStepsPage;

public class VariableStep {
	VariableStepsPage variableStepsPage;


	public void i_click_the_Variables_tab_in_WM() throws Throwable {
		variableStepsPage.i_click_the_Variables_tab_in_WM();
	}


	public void i_click_the_button_under_the_Variables_tab(String buttonName) throws Throwable {
		variableStepsPage.i_click_the_button_under_the_Variables_tab(buttonName);
	}


	public void i_enter_a_Variable_Name_in_the_Add_Variable_window() throws Throwable {
		variableStepsPage.i_enter_a_Variable_Name_in_the_Add_Variable_window();
	}


	public void i_enter_a_Display_Name_in_the_Add_Variable_window() throws Throwable {
		variableStepsPage.i_enter_a_Display_Name_in_the_Add_Variable_window();
	}


	public void i_choose_as_the_Data_Type(String optionName) throws Throwable {
		variableStepsPage.i_choose_as_the_Data_Type(optionName);
	}


	public void the_variable_is_created_under_the_Variables_tab() throws Throwable {
		variableStepsPage.the_variable_is_created_under_the_Variables_tab();
	}


	public void i_select_the_variable_in_WM() throws Throwable {
		variableStepsPage.i_select_the_variable_in_WM();
	}


	public void i_enter_an_Description_in_the_Add_Variable_window() throws Throwable {
		variableStepsPage.i_enter_an_Description_in_the_Add_Variable_window();
	}


	public void the_variable_is_deleted_under_the_Variables_tab() throws Throwable {
		variableStepsPage.the_variable_is_deleted_under_the_Variables_tab();
	}


	public void i_create_a_sample_variable_if_not_already_existing() throws Throwable {
		variableStepsPage.i_create_a_sample_variable_if_not_already_existing();
	}

}
