package features;


import features.steps.serenity.PhoneStep;

public class PhoneStepDefination {

	PhoneStep phoneStep;

	public void i_select_a_Phone_Number_Type() throws Throwable {
		phoneStep.i_select_a_Phone_Number_Type();
	}

	public void i_select_a_country_code() throws Throwable {
		phoneStep.i_select_a_country_code();
	}

	public void i_enter_an_Phone_Number() throws Throwable {
		phoneStep.i_enter_an_Phone_Number();
	}

	public void i_enter_an_Phone_Number_Extension() throws Throwable {
		phoneStep.i_enter_an_Phone_Number_Extension();
	}

	public void i_select_for_the_Express_Consent_Call(String arg1) throws Throwable {
		phoneStep.i_select_for_the_Express_Consent_Call(arg1);
	}

	public void i_select_for_the_Express_Consent_SMS(String arg1) throws Throwable {
		phoneStep.i_select_for_the_Express_Consent_SMS(arg1);
	}

	public void i_click_the_Update_button_in_the_Add_Phone_Number_windown() throws Throwable {
		phoneStep.i_click_the_Update_button_in_the_Add_Phone_Number_windown();
	}

	public void i_should_see_the_phone_created() throws Throwable {
		phoneStep.i_should_see_the_phone_created();
	}

	public void i_select_the_phone_number() throws Throwable {
		phoneStep.i_select_the_phone_number();
	}

	public void i_should_see_the_phone_number_deleted() throws Throwable {
		phoneStep.i_should_see_the_phone_number_deleted();
	}

}
