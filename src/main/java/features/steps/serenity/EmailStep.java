package features.steps.serenity;


import flextesting.associateportal.customerpage.EmailStepsPage;

public class EmailStep {
	EmailStepsPage emailStepsPage;


	public void i_select_as_the_Email_Type(String arg1) throws Throwable {
		emailStepsPage.i_select_as_the_Email_Type(arg1);
	}


	public void i_enter_an_Email_Address() throws Throwable {
		emailStepsPage.i_enter_an_Email_Address();
	}


	public void i_select_for_the_Express_Consent(String arg1) throws Throwable {
		emailStepsPage.i_select_for_the_Express_Consent(arg1);
	}


	public void i_click_the_Update_button_in_the_Add_Email_windown() throws Throwable {
		emailStepsPage.i_click_the_Update_button_in_the_Add_Email_windown();
	}


	public void i_should_see_the_email_created() throws Throwable {
		emailStepsPage.i_should_see_the_email_created();
	}


	public void i_select_the_email() throws Throwable {
		emailStepsPage.i_select_the_email();
	}


	public void i_should_see_the_email_deleted() throws Throwable {
		emailStepsPage.i_should_see_the_email_deleted();
	}

}
