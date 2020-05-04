package features.steps.serenity;


import flextesting.commonsteps.CommonElementsStepsPage;

public class CommonElementsStep {
	CommonElementsStepsPage commonElementsStepsPage;


	public void i_click_the_Next_button() throws Throwable {
		commonElementsStepsPage.i_click_the_Next_button();
	}


	public void i_click_the_Save_button() throws Throwable {
		commonElementsStepsPage.i_click_the_Save_button();
	}


	public void i_click_the_Submit_button() throws Throwable {
		commonElementsStepsPage.i_click_the_Submit_button();
	}


	public void i_click_Yes_in_the_confirmation_window() throws Throwable {
		commonElementsStepsPage.i_click_Yes_in_the_confirmation_window();
	}


	public void i_click_OK() throws Throwable {
		commonElementsStepsPage.i_click_OK();
	}

	/**
	 * Not used
	 * 
	 * @param name
	 * @throws Throwable
	 */

	public void i_enter_as_the_name(String name) throws Throwable {
		commonElementsStepsPage.i_enter_as_the_name(name);
	}


	public void i_enter_as_the_description(String description) throws Throwable {
		commonElementsStepsPage.i_enter_as_the_description(description);
	}


	public void i_close_the_window(String windowName) throws Throwable {
		commonElementsStepsPage.i_close_the_window(windowName);
	}


	public void i_have_selected_as_the_context(String context) throws Throwable {
		commonElementsStepsPage.i_have_selected_as_the_context(context);
	}


	public void i_have_selected_a_portfolio() throws Throwable {
		commonElementsStepsPage.i_have_selected_a_portfolio();
	}


	public void i_click_the_button(String buttonName) throws Throwable {
		commonElementsStepsPage.i_click_the_button(buttonName);
	}

}