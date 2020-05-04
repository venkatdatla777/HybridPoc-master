package features.steps.serenity;



import flextesting.strategistportal.userandrolemanager.UserAndRoleManagerStepsPage;

import java.util.List;
import java.util.Map;

public class UserAndRoleManagerStep {

	UserAndRoleManagerStepsPage userAndRoleManagerStepsPage;


	public void i_add_a_new_user() throws Throwable {
		userAndRoleManagerStepsPage.i_add_a_new_user();
	}


	public void the_new_user_should_be_added() throws Throwable {
		userAndRoleManagerStepsPage.the_new_user_should_be_added();
	}


	public void i_update_the_user() throws Throwable {
		userAndRoleManagerStepsPage.i_update_the_user();
	}


	public void i_lock_the_user() throws Throwable {
		userAndRoleManagerStepsPage.i_lock_the_user();
	}


	public void the_user_should_be_locked() throws Throwable {
		userAndRoleManagerStepsPage.the_user_should_be_locked();
	}


	public void i_disable_the_user() throws Throwable {
		userAndRoleManagerStepsPage.i_disable_the_user();
	}


	public void the_user_should_be_disabled() throws Throwable {
		userAndRoleManagerStepsPage.the_user_should_be_disabled();
	}


	public void i_select_the_user() throws Throwable {
		userAndRoleManagerStepsPage.i_select_the_user();
	}


	public void i_click_the_Change_Password_button() throws Throwable {
		userAndRoleManagerStepsPage.i_click_the_Change_Password_button();
	}


	public void i_enter_a_New_Password() throws Throwable {
		userAndRoleManagerStepsPage.i_enter_a_New_Password();
	}


	public void i_enter_a_Confirm_Password() throws Throwable {
		userAndRoleManagerStepsPage.i_enter_a_Confirm_Password();
	}


	public void i_should_see_the_confirmation(String arg1) throws Throwable {
		userAndRoleManagerStepsPage.i_should_see_the_confirmation(arg1);
	}
	


	public void i_create_the_following_autotester_accounts(List<Map<String, String>> data) throws Throwable {
		userAndRoleManagerStepsPage.i_create_the_following_autotester_accounts(data);
	}


	public void i_login_with_each_account_to_change_the_password() throws Throwable {
		userAndRoleManagerStepsPage.i_login_with_each_account_to_change_the_password();
	}
}
