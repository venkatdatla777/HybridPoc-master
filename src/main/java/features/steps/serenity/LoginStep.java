package features.steps.serenity;


import flextesting.associateportal.login.FlexSatationLoginPage;
import flextesting.strategistportal.login.LoginPage;
import org.junit.After;

public class LoginStep {
	LoginPage loginPage;
	FlexSatationLoginPage flexSatationLoginPage;
	
	/*@Before
	public void setScenarioName(Scenario scenario) {
		System.out.println("scenario  :::::::::::::::::: " + scenario.getName());
		TestDataSetup.setScenarioName(scenario.getName());
	}*/
	
	@After
	public void closeBrowser() {
		loginPage.quitBrowser();
	}


	public void i_am_on_Login_Page() throws Throwable {
//		loginPage.open();
		loginPage.i_am_on_Login_Page();
	}


	public void i_enter_username_as_and_I_enter_password_as_and_I_click_the_Login_button(String arg1, String arg2)
			throws Throwable {
		loginPage.i_enter_username_as_and_I_enter_password_as_and_I_click_the_Login_button(arg1, arg2);
	}


	public void login_should_be_successful() throws Throwable {
		loginPage.login_should_be_successful();
	}


	public void login_fail_message_should_show_and_I_am_still_on_the_login_page() throws Throwable {
		loginPage.login_fail_message_should_show_and_I_am_still_on_the_login_page();
	}


	public void i_have_logged_in_the_Strategist_Portal() throws Throwable {
/*
		loginPage.open();
*/
		loginPage.i_have_logged_in_the_Strategist_Portal();
	}


	public void i_logout_the_Strategist_Portal() throws Throwable {
		loginPage.i_logout_the_Strategist_Portal();
	}


	public void i_am_logged_in_the_Strategist_Portal_with_super_user() throws Throwable {
		loginPage.i_am_logged_in_the_Strategist_Portal_with_super_user();
	}


	public void the_testing_client_is_provided_as_system_property() throws Throwable {
		loginPage.the_testing_client_is_provided_as_system_property();
	}

	// Associate Portal

	public void i_am_logged_in_the_Associate_Portal() throws Throwable {
		flexSatationLoginPage.loginAssociatePortal();
	}

}
