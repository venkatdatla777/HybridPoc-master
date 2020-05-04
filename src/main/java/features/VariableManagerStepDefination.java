package features;



import features.steps.serenity.VariableManagerStep;

import java.util.List;

public class VariableManagerStepDefination {

	VariableManagerStep variableManagerStep;

	public void i_click_the_Variable_button(String buttonName) throws Throwable {
		variableManagerStep.i_click_the_Variable_button(buttonName);
	}	
	public void i_enter_a_Variable_Name_in_the_New_Variable_window() throws Throwable {
		variableManagerStep.i_enter_a_Variable_Name_in_the_New_Variable_window();
	}
	public void i_enter_a_Display_Name_in_the_New_Variable_window() throws Throwable {
		variableManagerStep.i_enter_a_Display_Name_in_the_New_Variable_window();
	}
	public void i_select_as_the_Variable_Type(String mappedOrDerived) throws Throwable {
		variableManagerStep.i_select_as_the_Variable_Type(mappedOrDerived);
	}
	public void i_enter_as_the_Expression_in_the_New_Variable_window(String arg1) throws Throwable {
		variableManagerStep.i_enter_as_the_Expression_in_the_New_Variable_window(arg1);
	}
	public void i_choose_a_format() throws Throwable {
		variableManagerStep.i_choose_a_format();
	}
	public void the_variable_is_created() throws Throwable {
		variableManagerStep.the_variable_is_created();
	}
	public void i_enter_a_Tag_in_the_Update_Variable_window() throws Throwable {
		variableManagerStep.i_enter_a_Tag_in_the_Update_Variable_window();
	}
	public void the_variable_is_deleted() throws Throwable {
		variableManagerStep.the_variable_is_deleted();
	}
	
	public void i_have_selected_this_portfolio(int arg1) throws Throwable {
		variableManagerStep.i_have_selected_this_portfolio(arg1);
	}
	
	public void i_create_these_variables_in(int arg1, List<List<String>> arg2) throws Throwable {
		variableManagerStep.i_create_these_variables_in(arg1, arg2);
	}
}