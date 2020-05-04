package features;


import features.steps.serenity.PaymentStep;

public class PaymentStepDefination {

	PaymentStep paymentStep;

	public void i_click_the_Payment_icon_at_account_level() throws Throwable {
		paymentStep.i_click_the_Payment_icon_at_account_level();
	}

	public void i_click_Make_a_One_Time_Payment() throws Throwable {
		paymentStep.i_click_Make_a_One_Time_Payment();
	}

	public void i_select_day_from_today_as_the_payment_date(int arg1) throws Throwable {
		paymentStep.i_select_day_from_today_as_the_payment_date(arg1);
	}

	public void i_select_the_minimum_due_as_the_payment_amount() throws Throwable {
		paymentStep.i_select_the_minimum_due_as_the_payment_amount();
	}

	public void i_click_Add_New_Funding_Account() throws Throwable {
		paymentStep.i_click_Add_New_Funding_Account();
	}

	public void i_choose_New_Card_Account() throws Throwable {
		paymentStep.i_choose_New_Card_Account();
	}

	public void i_select_a_funding_account() throws Throwable {
		paymentStep.i_select_a_funding_account();
	}

	public void i_click_Submit_All_Payments() throws Throwable {
		paymentStep.i_click_Submit_All_Payments();
	}

	public void the_payment_submitted_confirmation_window_should_show() throws Throwable {
		paymentStep.the_payment_submitted_confirmation_window_should_show();
	}

	public void i_select_the_payment_from_the_table() throws Throwable {
		paymentStep.i_select_the_payment_from_the_table();
	}

	public void i_click_the_Update_button() throws Throwable {
		paymentStep.i_click_the_Update_button();
	}

	public void i_click_Next_in_Update_Payment_window() throws Throwable {
		paymentStep.i_click_Next_in_Update_Payment_window();
	}

	public void i_click_Submit_in_Update_Payment_window() throws Throwable {
		paymentStep.i_click_Submit_in_Update_Payment_window();
	}

	public void the_payment_updated_confirmation_window_should_show() throws Throwable {
		paymentStep.the_payment_updated_confirmation_window_should_show();
	}

	public void i_click_the_Delete_button() throws Throwable {
		paymentStep.i_click_the_Delete_button();
	}

	public void i_click_Yes_in_Delete_Payment_confirmation_window() throws Throwable {
		paymentStep.i_click_Yes_in_Delete_Payment_confirmation_window();
	}

	public void the_payment_deleted_confirmation_window_should_show() throws Throwable {
		paymentStep.the_payment_deleted_confirmation_window_should_show();
	}

	// customer level steps
	public void i_click_the_Payment_icon_at_customer_level() throws Throwable {
		paymentStep.i_click_the_Payment_icon_at_customer_level();
	}

	public void i_click_the_Make_Payment_button() throws Throwable {
		paymentStep.i_click_the_Make_Payment_button();
	}

	public void i_select_an_account_for_the_payment() throws Throwable {
		paymentStep.i_select_an_account_for_the_payment();
	}

	public void i_select_day_from_today_as_the_payment_date_for_the_chosen_account(int arg1) throws Throwable {
		paymentStep.i_select_day_from_today_as_the_payment_date_for_the_chosen_account(arg1);
	}

	public void i_enter_as_the_payment_amount(String amount) throws Throwable {
		paymentStep.i_enter_as_the_payment_amount(amount);
	}

	public void i_select_a_funding_account_for_the_chosen_account() throws Throwable {
		paymentStep.i_select_a_funding_account_for_the_chosen_account();
	}

	public void the_payment_submitted_confirmation_window_should_show_customer_level() throws Throwable {
		paymentStep.the_payment_submitted_confirmation_window_should_show_customer_level();
	}

}
