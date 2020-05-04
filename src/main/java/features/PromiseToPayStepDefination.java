package features;


import features.steps.serenity.PromiseToPayStep;

public class PromiseToPayStepDefination {


	PromiseToPayStep promiseToPayStep;

	public void i_click_the_Promise_tab() throws Throwable {
		promiseToPayStep.i_click_the_Promise_tab();
	}

	public void i_click_the_Make_A_Promise_button() throws Throwable {
		promiseToPayStep.i_click_the_Make_A_Promise_button();
	}

	public void i_enter_an_Amount_for_the_promise() throws Throwable {
		promiseToPayStep.i_enter_an_Amount_for_the_promise();
	}

	public void i_set_a_Send_Date_for_the_promise() throws Throwable {
		promiseToPayStep.i_set_a_Send_Date_for_the_promise();
	}

	public void i_choose_an_Payment_Method() throws Throwable {
		promiseToPayStep.i_choose_an_Payment_Method();
	}

	public void i_set_a_Arrival_Date_for_the_promise() throws Throwable {
		promiseToPayStep.i_set_a_Arrival_Date_for_the_promise();
	}

	public void i_check_Make_it_Recursive_for() throws Throwable {
		promiseToPayStep.i_check_Make_it_Recursive_for();
	}

	public void i_enter_a_number_for_Additional_Months() throws Throwable {
		promiseToPayStep.i_enter_a_number_for_Additional_Months();
	}
	
	public void i_click_Submit_All_Promises() throws Throwable {
		promiseToPayStep.i_click_Submit_All_Promises();
	}
	
	public void the_promise_is_saved() throws Throwable {
		promiseToPayStep.the_promise_is_saved();
	}

	/**
	 * If second PTP (the recurring one) is not deleted, choose it 
	 * Else: choose the first one
	 * @throws Throwable
	 */
	public void i_select_the_promise() throws Throwable {
		promiseToPayStep.i_select_the_promise();
	}

	public void i_click_the_button_in_the_Promise_tab(String btnName) throws Throwable {
		promiseToPayStep.i_click_the_button_in_the_Promise_tab(btnName);
	}

	public void i_click_the_Update_button_in_Update_a_Promise_window() throws Throwable {
		promiseToPayStep.i_click_the_Update_button_in_Update_a_Promise_window();
	}

	public void the_promise_is_updated() throws Throwable {
		promiseToPayStep.the_promise_is_updated();
	}

	public void the_promise_is_deleted() throws Throwable {
		promiseToPayStep.the_promise_is_deleted();
	}
	
	public void the_promise_is_updated_for_Account_view() throws Throwable {
	    promiseToPayStep.the_promise_is_updated_for_Account_view();
	}

}
