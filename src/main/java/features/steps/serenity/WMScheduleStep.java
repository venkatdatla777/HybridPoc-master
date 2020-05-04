package features.steps.serenity;


import flextesting.strategistportal.workflowmanager.WMScheduleStepsPage;

public class WMScheduleStep {
	WMScheduleStepsPage wMScheduleStepsPage;


	public void i_have_chosen_a_ViewContainer() throws Throwable {
		wMScheduleStepsPage.i_have_chosen_a_ViewContainer();
	}
	

	public void i_add_a_schedule_in_WM() throws Throwable {
		wMScheduleStepsPage.i_add_a_schedule_in_WM();
	}


	public void the_schedule_is_added() throws Throwable {
		wMScheduleStepsPage.the_schedule_is_added();
	}


	public void i_rename_the_schedule_to(String name) throws Throwable {
		wMScheduleStepsPage.i_rename_the_schedule_to(name);
	}


	public void the_schedule_is_renamed() throws Throwable {
		wMScheduleStepsPage.the_schedule_is_renamed();
	}


	public void i_delete_the_schedule() throws Throwable {
		wMScheduleStepsPage.i_delete_the_schedule();
	}


	public void the_schedule_is_deleted() throws Throwable {
		wMScheduleStepsPage.the_schedule_is_deleted();
	}
	

	public void i_create_a_schedule_as_in_WM(String wmScheduleName) throws Throwable {
		wMScheduleStepsPage.i_create_a_schedule_as_in_WM(wmScheduleName);
	}
}