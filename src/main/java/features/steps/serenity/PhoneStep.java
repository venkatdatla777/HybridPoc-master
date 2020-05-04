package features.steps.serenity;


import flextesting.associateportal.customerpage.PhoneStepsPage;
import org.junit.Assert;

public class PhoneStep {
	PhoneStepsPage phoneStepsPage;


	public void i_select_a_Phone_Number_Type() throws Throwable {
		phoneStepsPage.i_select_a_Phone_Number_Type();
	}


	public void i_select_a_country_code() throws Throwable {
		phoneStepsPage.i_select_a_country_code();
	}


	public void i_enter_an_Phone_Number() throws Throwable {
		phoneStepsPage.i_enter_an_Phone_Number();
	}


	public void i_enter_an_Phone_Number_Extension() throws Throwable {
		phoneStepsPage.i_enter_an_Phone_Number_Extension();
	}


	public void i_select_for_the_Express_Consent_Call(String arg1) throws Throwable {
		phoneStepsPage.i_select_for_the_Express_Consent_Call(arg1);
	}


	public void i_select_for_the_Express_Consent_SMS(String arg1) throws Throwable {
		phoneStepsPage.i_select_for_the_Express_Consent_SMS(arg1);
	}


	public void i_click_the_Update_button_in_the_Add_Phone_Number_windown() throws Throwable {
		phoneStepsPage.i_click_the_Update_button_in_the_Add_Phone_Number_windown();
	}


	public void i_should_see_the_phone_created() throws Throwable {
		Assert.assertTrue(phoneStepsPage.i_should_see_the_phone_created());
	}


	public void i_select_the_phone_number() throws Throwable {
		phoneStepsPage.i_select_the_phone_number();
	}


	public void i_should_see_the_phone_number_deleted() throws Throwable {
		Assert.assertTrue(phoneStepsPage.i_should_see_the_phone_number_deleted());
	}

}
