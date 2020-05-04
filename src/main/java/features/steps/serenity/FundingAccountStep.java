package features.steps.serenity;


import flextesting.associateportal.customerpage.FundingAccountStepsPage;
import org.junit.Assert;

public class FundingAccountStep {

	FundingAccountStepsPage fundingAccountStepsPage;


	public void i_click_Manage_Funding_Account() throws Throwable {
		fundingAccountStepsPage.i_click_Manage_Funding_Account();
	}


	public void i_click_New_Card_Account() throws Throwable {
		fundingAccountStepsPage.i_click_New_Card_Account();
	}


	public void i_complete_the_form_in_the_Add_New_Card_Account_window() throws Throwable {
		fundingAccountStepsPage.i_complete_the_form_in_the_Add_New_Card_Account_window();
	}


	public void i_check_Save_this_account_for_future_payments() throws Throwable {
		fundingAccountStepsPage.i_check_Save_this_account_for_future_payments();
	}


	public void i_click_Next_button_in_the_Add_New_Card_Account_window() throws Throwable {
		fundingAccountStepsPage.i_click_Next_button_in_the_Add_New_Card_Account_window();
	}


	public void i_click_Submit_button_in_the_Add_New_Card_Account_window() throws Throwable {
		fundingAccountStepsPage.i_click_Submit_button_in_the_Add_New_Card_Account_window();
	}


	public void i_should_see_the_new_card_added_confirmation_window() throws Throwable {
		fundingAccountStepsPage.i_should_see_the_new_card_added_confirmation_window();
	}


	public void i_select_the_card_in_Manage_Funding_Accounts_window() throws Throwable {
		fundingAccountStepsPage.i_select_the_card_in_Manage_Funding_Accounts_window();
	}


	public void i_click_Remove_Funding_Account() throws Throwable {
		fundingAccountStepsPage.i_click_Remove_Funding_Account();
	}


	public void i_click_Yes_in_the_Delete_Funding_Account_window() throws Throwable {
		fundingAccountStepsPage.i_click_Yes_in_the_Delete_Funding_Account_window();
	}


	public void i_should_see_the_funding_account_deleted_confirmation() throws Throwable {
		fundingAccountStepsPage.i_should_see_the_funding_account_deleted_confirmation();
	}

	// Back_account

	public void i_click_New_Bank_Account() throws Throwable {
		fundingAccountStepsPage.i_click_New_Bank_Account();
	}


	public void i_enter_an_Account_Nick_Name() throws Throwable {
		fundingAccountStepsPage.i_enter_an_Account_Nick_Name();
	}


	public void i_select_as_the_Bank_Account_Type(String accountType) throws Throwable {
		fundingAccountStepsPage.i_select_as_the_Bank_Account_Type(accountType);
	}


	public void i_enter_a_valid_Routing_Number() throws Throwable {
		fundingAccountStepsPage.i_enter_a_valid_Routing_Number();
	}


	public void i_enter_a_valid_Bank_Account_Number() throws Throwable {
		fundingAccountStepsPage.i_enter_a_valid_Bank_Account_Number();
	}


	public void i_enter_the_Bank_Account_Holder_Full_Name() throws Throwable {
		fundingAccountStepsPage.i_enter_the_Bank_Account_Holder_Full_Name();
	}


	public void i_should_see_the_new_bank_account_added() throws Throwable {
		Assert.assertTrue(fundingAccountStepsPage.i_should_see_the_new_bank_account_added());
	}


	public void i_select_the_bank_account_in_the_Manage_Funding_Accounts_window() throws Throwable {
		fundingAccountStepsPage.i_select_the_bank_account_in_the_Manage_Funding_Accounts_window();
	}


	public void i_should_see_the_bank_account_removed() throws Throwable {
		Assert.assertFalse(fundingAccountStepsPage.i_should_see_the_bank_account_removed());
	}

}
