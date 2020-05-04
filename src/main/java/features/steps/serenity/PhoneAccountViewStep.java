package features.steps.serenity;


import flextesting.associateportal.customerpage.PhoneAccountViewStepsPage;
import org.junit.Assert;

public class PhoneAccountViewStep {
	PhoneAccountViewStepsPage phoneAccountViewStepsPage;


	public void i_select_a_Phone_Number_Type_for_Account_view() throws Throwable {
		phoneAccountViewStepsPage.i_select_a_Phone_Number_Type_for_Account_view();
	}


	public void i_select_a_country_code_for_Account_view() throws Throwable {
		phoneAccountViewStepsPage.i_select_a_country_code_for_Account_view();
	}


	public void i_enter_an_Phone_Number_for_Account_view() throws Throwable {
		phoneAccountViewStepsPage.i_enter_an_Phone_Number_for_Account_view();
	}


	public void i_enter_an_Phone_Number_Extension_for_Account_view() throws Throwable {
		phoneAccountViewStepsPage.i_enter_an_Phone_Number_Extension_for_Account_view();
	}


	public void i_select_for_the_Express_Consent_Call_for_Account_view(String arg1) throws Throwable {
		phoneAccountViewStepsPage.i_select_for_the_Express_Consent_Call_for_Account_view(arg1);
	}


	public void i_select_for_the_Express_Consent_SMS_for_Account_view(String arg1) throws Throwable {
		phoneAccountViewStepsPage.i_select_for_the_Express_Consent_SMS_for_Account_view(arg1);
	}


	public void i_click_the_Update_button_in_the_Update_Phone_Number_windown_for_Account_view() throws Throwable {
		phoneAccountViewStepsPage.i_click_the_Update_button_in_the_Update_Phone_Number_windown_for_Account_view();
	}


	public void i_should_see_the_phone_updated_for_Account_view() throws Throwable {
		Assert.assertTrue(phoneAccountViewStepsPage.i_should_see_the_phone_updated_for_Account_view());
	}


	public void i_select_the_phone_number_for_Account_view() throws Throwable {
		phoneAccountViewStepsPage.i_select_the_phone_number_for_Account_view();
	}


	public void i_should_see_the_phone_number_deleted_for_Account_view() throws Throwable {
		Assert.assertTrue(phoneAccountViewStepsPage.i_should_see_the_phone_number_deleted_for_Account_view());
	}

}
