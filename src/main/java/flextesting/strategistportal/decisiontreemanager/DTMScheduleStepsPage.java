package flextesting.strategistportal.decisiontreemanager;



import com.qa.base.TestBase;
import flextesting.pagefactories.CommonElementsFactory;
import flextesting.pagefactories.strategistportal.decisiontreemanager.DTMScheduleFactory;
import flextesting.utilities.DataUtil;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DTMScheduleStepsPage extends TestBase {

	private String scheduleName = "Schedule41_" + DataUtil.getRandomChars();
	private String scheduleDesc = "Schedule Description";

	public boolean isScheduleCreate() {
		return dtScheduleFactory.isScheduleCreated();
	}

	public void i_choose_from_the_Schedule_Operation_dropdown_menu(String operation) throws Throwable {
		dtScheduleFactory.choose_ScheduleOperaton(operation);
	}

	public void i_enter_a_Schedule_Name() throws Throwable {
		commonElementsFactory.enterName(scheduleName);
	}

	public void i_pick_day_from_today_as_the_Schedule_Date(int daysFromToday) throws Throwable {
		dtScheduleFactory.pick_ScheduleDate(daysFromToday);
	}

	public void i_enter_a_Description_for_the_schedule() throws Throwable {
		commonElementsFactory.enterDescription(scheduleDesc);
	}

	public void the_schedule_should_be_created() throws Throwable {
		dtScheduleFactory.dropdown_scheduleList();
		assertTrue(dtScheduleFactory.isPresent_ScheduleByName(scheduleName, true));
	}

	public void the_schedule_is_deleted_in_DTM() throws Throwable {
		dtScheduleFactory.dropdown_scheduleList();
		assertFalse(dtScheduleFactory.isPresent_ScheduleByName(scheduleName, false));
	}

	/**
	 * one sentence step
	 * 
	 * @throws Throwable
	 */
	public void i_add_a_schedule() throws Throwable {
		dtScheduleFactory.choose_ScheduleOperaton("Add Schedule");
		commonElementsFactory.enterName(scheduleName);
		dtScheduleFactory.pick_ScheduleDate(1);
		commonElementsFactory.click_Save();
		the_schedule_should_be_created();
	}

	/**
	 * one sentence step
	 * 
	 * @throws Throwable
	 */
	public void i_delete_the_schedule_in_DTM() throws Throwable {
		dtScheduleFactory.choose_ScheduleOperaton("Delete Schedule");
		commonElementsFactory.confirm_Yes();
		commonElementsFactory.message_OK();
	}
	
	public void i_add_a_schedule_as_in_DTM(String name) throws Throwable {
		dtScheduleFactory.choose_ScheduleOperaton("Add Schedule");
		commonElementsFactory.enterName(name);
		dtScheduleFactory.pick_ScheduleDate(1);
		commonElementsFactory.click_Save();
		dtScheduleFactory.dropdown_scheduleList();
		assertTrue(dtScheduleFactory.isPresent_ScheduleByName(name, true));
	}

}
