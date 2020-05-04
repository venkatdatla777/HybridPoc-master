package features.steps.serenity;


import flextesting.strategistportal.configurationmanager.ConfigurationManagerStepsPage;

public class ConfigurationManagerStep {
	ConfigurationManagerStepsPage configurationManagerStepsPage;

	public void i_click_the_tab_Add_Edit_System_Level_Disposition_Code() throws Throwable {
		configurationManagerStepsPage.i_click_the_tab_Add_Edit_System_Level_Disposition_Code();
	}


	public void i_enter_a_Description_in_the_Add_System_Disposition_Code_window() throws Throwable {
		configurationManagerStepsPage.i_enter_a_Description_in_the_Add_System_Disposition_Code_window();
	}


	public void i_enter_a_Disposition_Code_in_the_Add_System_Disposition_Code_window() throws Throwable {
		configurationManagerStepsPage.i_enter_a_Disposition_Code_in_the_Add_System_Disposition_Code_window();
	}


	public void i_select_as_the_Core_Category(String optionName) throws Throwable {
		configurationManagerStepsPage.i_select_as_the_Core_Category(optionName);
	}


	public void i_select_as_the_Contact_Result(String optionName) throws Throwable {
		configurationManagerStepsPage.i_select_as_the_Contact_Result(optionName);
	}


	public void i_should_see_the_disposition_code_created() throws Throwable {
		configurationManagerStepsPage.i_should_see_the_disposition_code_created();
	}


	public void i_select_the_disposition_code() throws Throwable {
		configurationManagerStepsPage.i_select_the_disposition_code();
	}


	public void i_should_see_the_disposition_code_disabled() throws Throwable {
		configurationManagerStepsPage.i_should_see_the_disposition_code_disabled();
	}


	public void i_should_see_the_disposition_code_enabled() throws Throwable {
		configurationManagerStepsPage.i_should_see_the_disposition_code_enabled();
	}


	public void i_should_see_the_disposition_code_deleted() throws Throwable {
		configurationManagerStepsPage.i_should_see_the_disposition_code_deleted();
	}
	// End of disposition code

	// Program Type
	// program type: one sentence step:
	/**
	 * Only add a program type if no one exist
	 * 
	 * @throws Throwable
	 */

	public void i_add_a_program_type() throws Throwable {
		configurationManagerStepsPage.i_add_a_program_type();
	}

	// program type: details steps

	public void i_select_as_the_Configuration_Category(String arg1) throws Throwable {
		configurationManagerStepsPage.i_select_as_the_Configuration_Category(arg1);
	}


	public void i_select_a_Program_Type() throws Throwable {
		configurationManagerStepsPage.i_select_a_Program_Type();
	}


	public void i_enter_a_description_for_the_Program_Type() throws Throwable {
		configurationManagerStepsPage.i_enter_a_description_for_the_Program_Type();
	}


	public void i_should_see_the_program_type_saved() throws Throwable {
		configurationManagerStepsPage.i_should_see_the_program_type_saved();
	}

}
