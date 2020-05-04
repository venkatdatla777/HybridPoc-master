package features.steps.serenity;


import flextesting.strategistportal.testmanager.TestManagerStepsPage;

public class TestManagerStep {
	TestManagerStepsPage testManagerStepsPage;


	public void i_choose_one_from_the_Context_Search() throws Throwable {
		testManagerStepsPage.i_choose_one_from_the_Context_Search();
	}


	public void i_enter_an_Expression_in_the_Test_Manager_window() throws Throwable {
		testManagerStepsPage.i_enter_an_Expression_in_the_Test_Manager_window();
	}


	public void i_click_the_Expression_Evaluation_button() throws Throwable {
		testManagerStepsPage.i_click_the_Expression_Evaluation_button();
	}


	public void i_should_see_the_result_in_the_Test_Manager_window() throws Throwable {
		testManagerStepsPage.i_should_see_the_result_in_the_Test_Manager_window();
	}


	public void the_result_matches_the_record_in_the_database() throws Throwable {
		testManagerStepsPage.the_result_matches_the_record_in_the_database();
	}

}
