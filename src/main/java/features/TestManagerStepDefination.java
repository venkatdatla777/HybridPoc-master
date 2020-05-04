package features;


import features.steps.serenity.TestManagerStep;

public class TestManagerStepDefination {

	TestManagerStep testManagerStep;

	public void i_choose_one_from_the_Context_Search() throws Throwable {
		testManagerStep.i_choose_one_from_the_Context_Search();
	}

	public void i_enter_an_Expression_in_the_Test_Manager_window() throws Throwable {
		testManagerStep.i_enter_an_Expression_in_the_Test_Manager_window();
	}

	public void i_click_the_Expression_Evaluation_button() throws Throwable {
		testManagerStep.i_click_the_Expression_Evaluation_button();
	}

	public void i_should_see_the_result_in_the_Test_Manager_window() throws Throwable {
		testManagerStep.i_should_see_the_result_in_the_Test_Manager_window();
	}

	public void the_result_matches_the_record_in_the_database() throws Throwable {
		testManagerStep.the_result_matches_the_record_in_the_database();
	}

}
