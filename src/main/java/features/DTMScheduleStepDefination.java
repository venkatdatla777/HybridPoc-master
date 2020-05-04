package features;


import features.steps.serenity.DTMScheduleStep;
import flextesting.utilities.DataUtil;

public class DTMScheduleStepDefination {

	DTMScheduleStep dTMScheduleStep;

	public void i_choose_from_the_Schedule_Operation_dropdown_menu(String operation) throws Throwable {
		dTMScheduleStep.i_choose_from_the_Schedule_Operation_dropdown_menu(operation);
	}

	public void i_enter_a_Schedule_Name() throws Throwable {
		dTMScheduleStep.i_enter_a_Schedule_Name();
	}

	public void i_pick_day_from_today_as_the_Schedule_Date(int daysFromToday) throws Throwable {
		dTMScheduleStep.i_pick_day_from_today_as_the_Schedule_Date(daysFromToday);
	}

	public void i_enter_a_Description_for_the_schedule() throws Throwable {
		dTMScheduleStep.i_enter_a_Description_for_the_schedule();
	}

	public void the_schedule_should_be_created() throws Throwable {
		dTMScheduleStep.the_schedule_should_be_created();
		;
	}

	public void the_schedule_is_deleted_in_DTM() throws Throwable {
		dTMScheduleStep.the_schedule_is_deleted_in_DTM();
	}

	/**
	 * one sentence step
	 * 
	 * @throws Throwable
	 */
	public void i_add_a_schedule() throws Throwable {
		dTMScheduleStep.i_add_a_schedule();
	}

	/**
	 * one sentence step
	 * 
	 * @throws Throwable
	 */
	public void i_delete_the_schedule_in_DTM() throws Throwable {
		dTMScheduleStep.i_delete_the_schedule_in_DTM();
	}
	
	public void i_add_a_schedule_as_in_DTM(String arg1) throws Throwable {
	   String name = arg1+ "_" + DataUtil.getDateFormatTxt();
	   dTMScheduleStep.i_add_a_schedule_as_in_DTM(name);
	}
}