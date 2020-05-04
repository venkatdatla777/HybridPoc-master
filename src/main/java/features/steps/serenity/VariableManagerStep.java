package features.steps.serenity;



import flextesting.strategistportal.variablemanager.VariableManagerStepsPage;

import java.util.List;

public class VariableManagerStep {
	VariableManagerStepsPage variableManagerStepsPage;


	public void i_click_the_Variable_button(String buttonName) throws Throwable {
		variableManagerStepsPage.i_click_the_Variable_button(buttonName);
	}


	public void i_enter_a_Variable_Name_in_the_New_Variable_window() throws Throwable {
		variableManagerStepsPage.i_enter_a_Variable_Name_in_the_New_Variable_window();
	}


	public void i_enter_a_Display_Name_in_the_New_Variable_window() throws Throwable {
		variableManagerStepsPage.i_enter_a_Display_Name_in_the_New_Variable_window();
	}


	public void i_select_as_the_Variable_Type(String mappedOrDerived) throws Throwable {
		variableManagerStepsPage.i_select_as_the_Variable_Type(mappedOrDerived);
	}


	public void i_enter_as_the_Expression_in_the_New_Variable_window(String arg1) throws Throwable {
		variableManagerStepsPage.i_enter_as_the_Expression_in_the_New_Variable_window(arg1);
	}


	public void i_choose_a_format() throws Throwable {
		variableManagerStepsPage.i_choose_a_format();
	}


	public void the_variable_is_created() throws Throwable {
		variableManagerStepsPage.the_variable_is_created();
	}


	public void i_enter_a_Tag_in_the_Update_Variable_window() throws Throwable {
		variableManagerStepsPage.i_enter_a_Tag_in_the_Update_Variable_window();
	}


	public void the_variable_is_deleted() throws Throwable {
		variableManagerStepsPage.the_variable_is_deleted();
	}


	public void i_have_selected_this_portfolio(int arg1) throws Throwable {
		variableManagerStepsPage.i_have_selected_this_portfolio(arg1);
	}


	public void i_create_these_variables_in(int arg1, List<List<String>> arg2) throws Throwable {
		variableManagerStepsPage.i_create_these_variables_in(arg1, arg2);
	}

}