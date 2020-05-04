package features.steps.serenity;


import flextesting.strategistportal.userandrolemanager.RoleStepsPage;

public class RoleStep {
	RoleStepsPage roleStepsPage;


	public void i_click_Manage_Roles_tab() throws Throwable {
		roleStepsPage.i_click_Manage_Roles_tab();
	}


	public void i_click_Add_Role_and_choose_Add_Permission_Role() throws Throwable {
		roleStepsPage.i_click_Add_Role_and_choose_Add_Permission_Role();
	}


	public void i_enter_a_role_name() throws Throwable {
		roleStepsPage.i_enter_a_role_name();
	}


	public void i_assign_contexts_to_the_role() throws Throwable {
		roleStepsPage.i_assign_contexts_to_the_role();
	}


	public void i_assign_features_to_the_role() throws Throwable {
		roleStepsPage.i_assign_features_to_the_role();
	}


	public void i_assign_portfolios_to_the_role() throws Throwable {
		roleStepsPage.i_assign_portfolios_to_the_role();
	}


	public void i_save_the_role() throws Throwable {
		roleStepsPage.i_save_the_role();
	}


	public void the_role_is_saved() throws Throwable {
		roleStepsPage.the_role_is_saved();
	}
	

	public void the_role_is_updated() throws Throwable {
		roleStepsPage.the_role_is_updated();
	}


	public void i_select_the_role() throws Throwable {
		roleStepsPage.i_select_the_role();
	}
	

	public void i_click_Edit_Role() throws Throwable {
		roleStepsPage.i_click_Edit_Role();
	}


	public void i_enter_a_new_description_for_the_role() throws Throwable {
		roleStepsPage.i_enter_a_new_description_for_the_role();
	}


	public void i_click_Remove_Role() throws Throwable {
		roleStepsPage.i_click_Remove_Role();
	}


	public void the_role_is_removed() throws Throwable {
		roleStepsPage.the_role_is_removed();
	}
	
	//for user.feature

	public void i_create_a_role() throws Throwable {
		roleStepsPage.i_create_a_role();
	}


	public void i_delete_the_role() throws Throwable {
		roleStepsPage.i_delete_the_role();
	}
	//end of for user.feature
	
	//organizational  role

	public void i_search_the_organizational_role_created_last_time() throws Throwable {
		roleStepsPage.i_search_the_organizational_role_created_last_time();
	}


	public void i_delete_it_if_found() throws Throwable {
		roleStepsPage.i_delete_it_if_found();
	}
	


	public void i_click_Add_Role_and_choose(String arg1) throws Throwable {
		roleStepsPage.i_click_Add_Role_and_choose(arg1);
	}


	public void i_click_the_edit_button(String orgLevel) throws Throwable {
		roleStepsPage.i_click_the_edit_button(orgLevel);
	}

	/**
	 * @param orgLevelName must end with "One" or "Two" or "Three" or "Four"
	 * @throws Throwable
	 */

	public void i_add_a_new_if_it_is_not_there(String orgLevelName) throws Throwable {
		roleStepsPage.i_add_a_new_if_it_is_not_there(orgLevelName);
	}


	public void i_choose_for_Organizational_Level_1234(String optionName, String orgLevel) throws Throwable {
		roleStepsPage.i_choose_for_Organizational_Level_1234(optionName, orgLevel);
	}
	

	public void the_organizational_role_is_saved() throws Throwable {
		roleStepsPage.the_organizational_role_is_saved();
	}


	public void i_select_the_organizational_role_just_created() throws Throwable {
		roleStepsPage.i_select_the_organizational_role_just_created();
	}


	public void the_organizational_role_is_removed() throws Throwable {
		roleStepsPage.the_organizational_role_is_removed();
	}
	
	//External Entity role steps

	public void i_click_Add_Role_and_choose_Add_Enternal_Entity_Role() throws Throwable {
		roleStepsPage.i_click_Add_Role_and_choose_Add_Enternal_Entity_Role();
	}


	public void i_select_an_Entity_Type() throws Throwable {
		roleStepsPage.i_select_an_Entity_Type();
	}


	public void i_enter_an_Entity_Name() throws Throwable {
		roleStepsPage.i_enter_an_Entity_Name();
	}


	public void i_enter_an_Entity_Display_Name() throws Throwable {
		roleStepsPage.i_enter_an_Entity_Display_Name();
	}
	

	public void i_select_the_first_option_in_Entity_Invoice_Frequency() throws Throwable {
		roleStepsPage.i_select_the_first_option_in_Entity_Invoice_Frequency();
	}



	public void i_click_under_the_Address_tab_of_the_Entity_contact(String buttonName) throws Throwable {
		roleStepsPage.i_click_under_the_Address_tab_of_the_Entity_contact(buttonName);
	}
	

	public void i_select_the_first_option_in_Address_Type_in_the_Create_Entity_Address_window() throws Throwable {
		roleStepsPage.i_select_the_first_option_in_Address_Type_in_the_Create_Entity_Address_window();
	}
	

	public void i_click_the_Save_button_in_the_Create_Entity_Address_window() throws Throwable {
		roleStepsPage.i_click_the_Save_button_in_the_Create_Entity_Address_window();
	}


	public void i_click_under_the_Details_tab_of_the_Entity_Billing_Group(String buttonName) throws Throwable {
		roleStepsPage.i_click_under_the_Details_tab_of_the_Entity_Billing_Group(buttonName);
	}


	public void i_select_a_portfolio_in_the_Create_Entity_Billing_Group_window() throws Throwable {
		roleStepsPage.i_select_a_portfolio_in_the_Create_Entity_Billing_Group_window();
	}
	

	public void i_enter_a_Name_in_the_Create_Entity_Billing_Group_window() throws Throwable {
		roleStepsPage.i_enter_a_Name_in_the_Create_Entity_Billing_Group_window();
	}


	public void i_enter_as_the_Criteria_in_the_Create_Entity_Billing_Group_window(String arg1) throws Throwable {
		roleStepsPage.i_enter_as_the_Criteria_in_the_Create_Entity_Billing_Group_window(arg1);
	}


	public void i_select_the_first_option_in_Billing_Group_Category() throws Throwable {
		roleStepsPage.i_select_the_first_option_in_Billing_Group_Category();
	}
	

	public void i_enter_as_a_Commission_Rate(String arg1) throws Throwable {
		roleStepsPage.i_enter_as_a_Commission_Rate(arg1);
	}


	public void i_enter_as_the_Effective_Date(String date) throws Throwable {
		roleStepsPage.i_enter_as_the_Effective_Date(date);
	}
	

	public void i_click_the_Save_button_in_the_Create_Entity_Billing_Group_window() throws Throwable {
		roleStepsPage.i_click_the_Save_button_in_the_Create_Entity_Billing_Group_window();
	}
	

	public void the_external_entity_is_saved() throws Throwable {
		roleStepsPage.the_external_entity_is_saved();
	}


	public void i_select_the_external_entity() throws Throwable {
		roleStepsPage.i_select_the_external_entity();
	}
	

	public void i_enter_in_Entity_Description(String arg1) throws Throwable {
		roleStepsPage.i_enter_in_Entity_Description(arg1);
	}


	public void the_external_entity_is_removed() throws Throwable {
		roleStepsPage.the_external_entity_is_removed();
	}

}
