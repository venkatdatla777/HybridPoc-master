package features;


import features.steps.serenity.EmailStep;

public class EmailStepDefination {

	EmailStep emailStep;

	public void i_select_as_the_Email_Type(String arg1) throws Throwable {
		emailStep.i_select_as_the_Email_Type(arg1);
	}

	public void i_enter_an_Email_Address() throws Throwable {
		emailStep.i_enter_an_Email_Address();
	}

	public void i_select_for_the_Express_Consent(String arg1) throws Throwable {
		emailStep.i_select_for_the_Express_Consent(arg1);
	}

	public void i_click_the_Update_button_in_the_Add_Email_windown() throws Throwable {
		emailStep.i_click_the_Update_button_in_the_Add_Email_windown();
	}

	public void i_should_see_the_email_created() throws Throwable {
		emailStep.i_should_see_the_email_created();
	}

	public void i_select_the_email() throws Throwable {
		emailStep.i_select_the_email();
	}

	public void i_should_see_the_email_deleted() throws Throwable {
		emailStep.i_should_see_the_email_deleted();
	}
}
