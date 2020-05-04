package features.steps.serenity;


import flextesting.associateportal.QueueViewPageStepsPage;

public class QueueViewPageStep {

	QueueViewPageStepsPage queueViewPageStepsPage;


	public void i_select_an_account_from_recent_accounts() throws Throwable {
		queueViewPageStepsPage.i_select_an_account_from_recent_accounts();
	}


	public void i_search_and_load_an_account_that_is_not_currently_loaded_by_another_agent() throws Throwable {
		queueViewPageStepsPage.i_search_and_load_an_account_that_is_not_currently_loaded_by_another_agent();
	}


	public void i_should_see_the_account_loaded() throws Throwable {
		queueViewPageStepsPage.i_should_see_the_account_loaded();
	}


	public void i_have_loaded_an_account_of_a_customer() throws Throwable {
		queueViewPageStepsPage.i_have_loaded_an_account_of_a_customer();
	}

	// load from queue

	public void there_is_queue_in_Queue_View() throws Throwable {
		queueViewPageStepsPage.there_is_queue_in_Queue_View();
	}


	public void i_double_click_a_queue_in_Queue_View() throws Throwable {
		queueViewPageStepsPage.i_double_click_a_queue_in_Queue_View();
	}


	public void i_should_see_accounts_in_Queue_Accounts() throws Throwable {
		queueViewPageStepsPage.i_should_see_accounts_in_Queue_Accounts();
	}


	public void i_double_click_an_account_in_Queue_Accounts() throws Throwable {
		queueViewPageStepsPage.i_double_click_an_account_in_Queue_Accounts();
	}


	public void i_should_see_a_new_tab_is_opened_so_what_I_know_the_account_is_loaded() throws Throwable {
		queueViewPageStepsPage.i_should_see_a_new_tab_is_opened_so_what_I_know_the_account_is_loaded();
	}

	// get next account from portfolio

	public void i_select_instead_of_for_Get_Next_Account_From(String choose, String notChoose) throws Throwable {
		queueViewPageStepsPage.i_select_instead_of_for_Get_Next_Account_From(choose, notChoose);
	}


	public void i_select_a_portfolio_for_Get_Next_Account_From() throws Throwable {
		queueViewPageStepsPage.i_select_a_portfolio_for_Get_Next_Account_From();
	}


	public void i_click_the_Get_Next_Account_From_button() throws Throwable {
		queueViewPageStepsPage.i_click_the_Get_Next_Account_From_button();
	}


	public void i_select_a_queue_for_Get_Next_Account_From() throws Throwable {
		queueViewPageStepsPage.i_select_a_queue_for_Get_Next_Account_From();
	}


	public void if_there_is_no_message_saying_No_next_account_available_or_No_workable_queue_found() throws Throwable {
		queueViewPageStepsPage.if_there_is_no_message_saying_No_next_account_available_or_No_workable_queue_found();
	}
	

	public void i_have_loaded_an_account_of_a_customer_for_program_offer() throws Throwable {
		queueViewPageStepsPage.i_have_loaded_an_account_of_a_customer_for_program_offer();
	}


	public void get_the_accountNumber_and_responsibleId_from_referenceNumber_and_update_the_DB_for_disposition_as_an_extra_step(){
		queueViewPageStepsPage.get_the_accountnumber_and_responsibleId_from_referenceNumber_and_update_the_DB_for_disposition();
	}

}
