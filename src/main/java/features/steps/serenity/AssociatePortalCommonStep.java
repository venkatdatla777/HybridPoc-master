package features.steps.serenity;


import flextesting.associateportal.AssociatePortalCommonStepsPage;

public class AssociatePortalCommonStep {

	AssociatePortalCommonStepsPage associatePortalCommonStepsPage;

	public void i_click_the_tab_at_the_customer_level(String tabName, String level) throws Throwable {
		associatePortalCommonStepsPage.i_click_the_tab_at_the_customer_level(tabName, level);
	}

	public void i_click_the_button_at_the_customer_level(String btnName, String level) throws Throwable {
		associatePortalCommonStepsPage.i_click_the_button_at_the_customer_level(btnName, level);
	}

	public void i_click_the_Update_button_in_the_X_propagation_window(String x) throws Throwable {
		associatePortalCommonStepsPage.i_click_the_Update_button_in_the_X_propagation_window(x);
	}

	public void i_click_the_Next_button_in_FlexStation() throws Throwable {
		associatePortalCommonStepsPage.i_click_the_Next_button_in_FlexStation();
	}

	public void i_click_the_Submit_button_in_FlexStation() throws Throwable {
		associatePortalCommonStepsPage.i_click_the_Submit_button_in_FlexStation();
	}
}
