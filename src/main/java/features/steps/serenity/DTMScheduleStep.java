package features.steps.serenity;


import flextesting.strategistportal.decisiontreemanager.DTMScheduleStepsPage;

public class DTMScheduleStep extends DTMScheduleStepsPage{


	public void i_choose_from_the_Schedule_Operation_dropdown_menu(String operation) throws Throwable {
		dTMScheduleStepsPage.i_choose_from_the_Schedule_Operation_dropdown_menu(operation);
	}


	public void i_enter_a_Schedule_Name() throws Throwable {
		dTMScheduleStepsPage.i_enter_a_Schedule_Name();
	}


	public void i_pick_day_from_today_as_the_Schedule_Date(int daysFromToday) throws Throwable {
		dTMScheduleStepsPage.i_pick_day_from_today_as_the_Schedule_Date(daysFromToday);
	}


	public void i_enter_a_Description_for_the_schedule() throws Throwable {
		dTMScheduleStepsPage.i_enter_a_Description_for_the_schedule();
	}


	public void the_schedule_should_be_created() throws Throwable {
		dTMScheduleStepsPage.the_schedule_should_be_created();
		;
	}


	public void the_schedule_is_deleted_in_DTM() throws Throwable {
		dTMScheduleStepsPage.the_schedule_is_deleted_in_DTM();
	}

	/**
	 * one sentence step
	 * 
	 * @throws Throwable
	 */

	public void i_add_a_schedule() throws Throwable {
		dTMScheduleStepsPage.i_add_a_schedule();
	}

	/**
	 * one sentence step
	 * 
	 * @throws Throwable
	 */

	public void i_delete_the_schedule_in_DTM() throws Throwable {
		dTMScheduleStepsPage.i_delete_the_schedule_in_DTM();
	}
	

	public void i_add_a_schedule_as_in_DTM(String name) throws Throwable {
		dTMScheduleStepsPage.i_add_a_schedule_as_in_DTM(name);
	}

}