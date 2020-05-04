package features;


import features.steps.serenity.LoginStep;

public class LoginStepDefination {

	LoginStep loginSteps;

	public void i_am_on_Login_Page() throws Throwable {
		loginSteps.i_am_on_Login_Page();
	}

	public void i_enter_username_as_and_I_enter_password_as_and_I_click_the_Login_button(String arg1, String arg2)
			throws Throwable {
		loginSteps.i_enter_username_as_and_I_enter_password_as_and_I_click_the_Login_button(arg1, arg2);
	}

	public void login_should_be_successful() throws Throwable {
		loginSteps.login_should_be_successful();
	}

	public void login_fail_message_should_show_and_I_am_still_on_the_login_page() throws Throwable {
		loginSteps.login_fail_message_should_show_and_I_am_still_on_the_login_page();
	}

	public void i_have_logged_in_the_Strategist_Portal() throws Throwable {
		loginSteps.i_have_logged_in_the_Strategist_Portal();
	}

	public void i_logout_the_Strategist_Portal() throws Throwable {
		loginSteps.i_logout_the_Strategist_Portal();
	}

	public void i_am_logged_in_the_Strategist_Portal_with_super_user() throws Throwable {
		loginSteps.i_am_logged_in_the_Strategist_Portal_with_super_user();
	}

	public void the_testing_client_is_provided_as_system_property() throws Throwable {
		loginSteps.the_testing_client_is_provided_as_system_property();
	}

	// Associate Portal Login Step

	public void i_am_logged_in_the_Associate_Portal() throws Throwable {
		loginSteps.i_am_logged_in_the_Associate_Portal();
	}

}
