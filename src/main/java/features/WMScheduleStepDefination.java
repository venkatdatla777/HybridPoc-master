package features;


import features.steps.serenity.WMScheduleStep;
import flextesting.strategistportal.defaultdata.WMScheduleData;
import flextesting.utilities.DataUtil;

public class WMScheduleStepDefination {

	WMScheduleStep wMScheduleStep;

	public void i_have_chosen_a_ViewContainer() throws Throwable {
		wMScheduleStep.i_have_chosen_a_ViewContainer();
	}
	
	public void i_add_a_schedule_in_WM() throws Throwable {
		wMScheduleStep.i_add_a_schedule_in_WM();
	}

	public void the_schedule_is_added() throws Throwable {
		wMScheduleStep.the_schedule_is_added();
	}

	public void i_rename_the_schedule_to(String name) throws Throwable {
		wMScheduleStep.i_rename_the_schedule_to(name);
	}

	public void the_schedule_is_renamed() throws Throwable {
		wMScheduleStep.the_schedule_is_renamed();
	}

	public void i_delete_the_schedule() throws Throwable {
		wMScheduleStep.i_delete_the_schedule();
	}

	public void the_schedule_is_deleted() throws Throwable {
		wMScheduleStep.the_schedule_is_deleted();
	}
	
	// New steps	
	public void i_create_a_schedule_as_in_WM(String name) throws Throwable {
		String wmScheduleName = name+"_"+ DataUtil.getDateFormatTxt();
		WMScheduleData.setWmScheduleName(wmScheduleName);
		wMScheduleStep.i_create_a_schedule_as_in_WM(wmScheduleName);
	}
}