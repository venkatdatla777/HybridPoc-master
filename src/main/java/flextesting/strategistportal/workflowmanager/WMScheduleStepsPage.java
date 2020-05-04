package flextesting.strategistportal.workflowmanager;

import com.qa.base.TestBase;
import flextesting.pagefactories.strategistportal.workflowmanager.WMScheduleFactory;
import flextesting.strategistportal.defaultdata.WMScheduleData;
import flextesting.utilities.DataUtil;
import sun.security.util.PendingException;


public class WMScheduleStepsPage extends TestBase {
	private WMScheduleFactory wmScheduleFactory;

	public void i_have_chosen_a_ViewContainer() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	public void i_add_a_schedule_in_WM() throws Throwable {
		String scheduleName = "Test Schedule_" + DataUtil.getDateFormatTxt();
		WMScheduleData.setScheduleName(scheduleName);
		wmScheduleFactory.click_AddSchedule();
		wmScheduleFactory.window_CreateSchedule();
		wmScheduleFactory.enter_ScheduleName(scheduleName);
		wmScheduleFactory.save_CreateSchedule();
	}

	public void the_schedule_is_added() throws Throwable {
		String scheduleName = WMScheduleData.getScheduleName();
		wmScheduleFactory.present_Schedule(scheduleName);
	}

	public void i_rename_the_schedule_to(String name) throws Throwable {
		WMScheduleData.setScheduleName(name);
		wmScheduleFactory.click_EditSchedule(WMScheduleData.getScheduleName());
		wmScheduleFactory.save_EditSchedule();
	}

	public void the_schedule_is_renamed() throws Throwable {
		wmScheduleFactory.present_Schedule(WMScheduleData.getScheduleName());
	}

	public void i_delete_the_schedule() throws Throwable {
		if (wmScheduleFactory.isScheduleCreated()) {
			wmScheduleFactory.click_DeleteSchedule();
			wmScheduleFactory.confirmation_DeleteSchedule_Yes();
			wmScheduleFactory.message_DeleteSchedule_OK();
		}
	}

	public void the_schedule_is_deleted() throws Throwable {
		wmScheduleFactory.notPresent_Schedule(WMScheduleData.getScheduleName());
	}
	
	public void i_create_a_schedule_as_in_WM(String wmScheduleName) throws Throwable {
		wmScheduleFactory.click_AddSchedule();
		wmScheduleFactory.window_CreateSchedule();
		wmScheduleFactory.enter_ScheduleName(wmScheduleName);
		wmScheduleFactory.save_CreateSchedule();
	}
}
