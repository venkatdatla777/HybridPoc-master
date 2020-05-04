package features.steps.serenity;


import flextesting.strategistportal.workflowmanager.HotspotStepsPage;

public class HotspotStep {
	HotspotStepsPage hotspotStepsPage;


	public void i_right_click_the_start_node_of_the_task() throws Throwable {
		hotspotStepsPage.i_right_click_the_start_node_of_the_task();
	}


	public void i_click_the_button_in_Manage_Hotspot_Assignment_window(String btnName) throws Throwable {
		hotspotStepsPage.i_click_the_button_in_Manage_Hotspot_Assignment_window(btnName);
	}


	public void i_choose_to_be_the_Hotspot_Name(String hotspotName) throws Throwable {
		hotspotStepsPage.i_choose_to_be_the_Hotspot_Name(hotspotName);
	}


	public void i_enter_to_be_the_Hotspot_Link_Text(String text) throws Throwable {
		hotspotStepsPage.i_enter_to_be_the_Hotspot_Link_Text(text);
	}


	public void the_hotspot_is_created_in_Manage_Hotspot_Assignment_window() throws Throwable {
		hotspotStepsPage.the_hotspot_is_created_in_Manage_Hotspot_Assignment_window();
	}


	public void i_choose_the_hotspot_just_being_created() throws Throwable {
		hotspotStepsPage.i_choose_the_hotspot_just_being_created();
	}


	public void i_check_the_Launch_workflow_within_the_same_browser_tab_on_the_Customer_Portal() throws Throwable {
		hotspotStepsPage.i_check_the_Launch_workflow_within_the_same_browser_tab_on_the_Customer_Portal();
	}


	public void the_hotspot_is_deleted_in_Manage_Hotspot_Assignment_window() throws Throwable {
		hotspotStepsPage.the_hotspot_is_deleted_in_Manage_Hotspot_Assignment_window();
	}


	public void i_close_the_Manage_Hotspot_Assignment_window() throws Throwable {
		hotspotStepsPage.i_close_the_Manage_Hotspot_Assignment_window();
	}

}