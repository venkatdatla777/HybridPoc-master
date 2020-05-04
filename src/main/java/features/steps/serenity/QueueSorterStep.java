package features.steps.serenity;


import flextesting.associateportal.QueueSorterStepsPage;

public class QueueSorterStep {

	QueueSorterStepsPage queueSorterStepsPage;


	public void i_grap_the_portfolio_info_of_the_queue_selected() throws Throwable {
		queueSorterStepsPage.i_grap_the_portfolio_info_of_the_queue_selected();
	}


	public void i_click_the_Manager_Sorter_icon() throws Throwable {
		queueSorterStepsPage.i_click_the_Manager_Sorter_icon();
	}


	public void i_click_the_button_in_Manage_Sorter_window(String btnName) throws Throwable {
		queueSorterStepsPage.i_click_the_button_in_Manage_Sorter_window(btnName);
	}


	public void i_select_the_portfolio_of_the_selected_queue_in_Add_Sorter_window() throws Throwable {
		queueSorterStepsPage.i_select_the_portfolio_of_the_selected_queue_in_Add_Sorter_window();
	}


	public void i_select_a_portfolio_in_Add_Sorter_window() throws Throwable {
		queueSorterStepsPage.i_select_a_portfolio_in_Add_Sorter_window();
	}


	public void i_enter_a_Sorter_Name() throws Throwable {
		queueSorterStepsPage.i_enter_a_Sorter_Name();
	}


	public void i_choose_the_sort_option_for_sort_variable(int indexOfSortDropDown, int theNthSortVar)
			throws Throwable {
		queueSorterStepsPage.i_choose_the_sort_option_for_sort_variable(indexOfSortDropDown, theNthSortVar);
	}


	public void i_choose_as_the_sort_order_for_sort_variable(String order, int theNthSortVar) throws Throwable {
		queueSorterStepsPage.i_choose_as_the_sort_order_for_sort_variable(order, theNthSortVar);
	}


	public void the_sorter_is_saved() throws Throwable {
		queueSorterStepsPage.the_sorter_is_saved();
	}


	public void i_select_the_sorter_just_created() throws Throwable {
		queueSorterStepsPage.i_select_the_sorter_just_created();
	}


	public void i_click_the_Add_button_in_Update_Sorter_window() throws Throwable {
		queueSorterStepsPage.i_click_the_Add_button_in_Update_Sorter_window();
	}


	public void the_sorter_is_deleted() throws Throwable {
		queueSorterStepsPage.the_sorter_is_deleted();
	}


	public void i_close_the_Manage_Sorter_window() throws Throwable {
		queueSorterStepsPage.i_close_the_Manage_Sorter_window();
	}


	public void i_get_all_avaliable_sorter_options() throws Throwable {
		queueSorterStepsPage.i_get_all_avaliable_sorter_options();
	}


	public void i_get_back_to_the_Queue_View_by_escaping_all_sorter_windows() throws Throwable {
		queueSorterStepsPage.i_get_back_to_the_Queue_View_by_escaping_all_sorter_windows();
	}


	public void i_can_find_a_column_name_matches_a_sort_options() throws Throwable {
		queueSorterStepsPage.i_can_find_a_column_name_matches_a_sort_options();
	}


	public void i_get_the_data_for_the_column_before_sorter_applied() throws Throwable {
		queueSorterStepsPage.i_get_the_data_for_the_column_before_sorter_applied();
	}


	public void i_choose_the_specific_sort_option_for_sort_variable(int theNthSortVar) throws Throwable {
		queueSorterStepsPage.i_choose_the_specific_sort_option_for_sort_variable(theNthSortVar);
	}


	public void i_choose_the_sorter_for_the_queue() throws Throwable {
		queueSorterStepsPage.i_choose_the_sorter_for_the_queue();
	}


	public void i_click_Apply_Filter_Sorter() throws Throwable {
		// Thread.sleep(1000);
		queueSorterStepsPage.i_click_Apply_Filter_Sorter();
	}


	public void i_get_the_data_for_the_column_after_sorter_applied() throws Throwable {
		// we don't know how much time needed to sort
		queueSorterStepsPage.i_get_the_data_for_the_column_after_sorter_applied();
	}


	public void i_find_that_the_column_is_sorted_according_to_the_sorter() throws Throwable {
		queueSorterStepsPage.i_find_that_the_column_is_sorted_according_to_the_sorter();
	}


	public void i_click_the_Reset_button_to_reset_the_order_of_the_queue() throws Throwable {
		queueSorterStepsPage.i_click_the_Reset_button_to_reset_the_order_of_the_queue();
	}


	public void i_get_the_data_for_the_column_after_reset() throws Throwable {
		queueSorterStepsPage.i_get_the_data_for_the_column_after_reset();
	}


	public void i_find_that_the_column_is_in_the_original_order() throws Throwable {
		queueSorterStepsPage.i_find_that_the_column_is_in_the_original_order();
	}
}
