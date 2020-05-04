package flextesting.pagefactories.strategistportal.workflowmanager;

import flextesting.pagefactories.strategistportal.actions.ProgramFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static flextesting.utilities.Utils.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WMScheduleFactory extends ProgramFactory {
	@FindBy(xpath = "//table[starts-with(@id,'schedulecombo') and contains(@id,'triggerWrap')]//td[2]")
	private WebElement dropdown_scheduleList;

	@FindBy(xpath = "//span[text()='Schedule Operation:']")
	private WebElement dropdown_scheduleOperation;

	@FindBy(xpath = "//span[text()='Add Schedule']")
	private WebElement option_ScheduleOperation_AddSchedule;

	@FindBy(xpath = "//span[text()='Edit Schedule']")
	private WebElement option_ScheduleOperation_EditSchedule;

	@FindBy(xpath = "//span[text()='Delete Schedule']")
	private WebElement option_ScheduleOperation_DeleteSchedule;

	@FindBy(xpath = "//div[text()='Do you want to delete the current schedule?']")
	private WebElement confirmationWindow_DeleteSchedule;

	@FindBy(xpath = "//div[text()='Do you want to delete the current schedule?']//following::span[text()='Yes']")
	private WebElement confirmationWindow_DeleteSchedule_Yes;

	@FindBy(xpath = "//div[text()='This schedule has been removed successfully.']")
	private WebElement messageWindow_ScheduleDeleted;

	@FindBy(xpath = "//div[text()='This schedule has been removed successfully.']//following::span[text()='OK'][1]")
	private WebElement messageWindow_ScheduleDeleted_OK;

	@FindBy(xpath = "//span[contains(@id,'scheduleedit') and text()='Create Schedule']")
	private WebElement wind_createSchedule;

	@FindBy(xpath = "//div[contains(@id,'workflowscheduleedit')]//input[@name='name']")
	private WebElement field_Name;

	@FindBy(xpath = "//div[contains(@id,'scheduleedit')]//span[text()='Save']//parent::button[1]")
	private WebElement saveBtn_CreateOrEditSchedule;

	private boolean scheduleCreated = false;

	/**
	 * wait for 2 seconds for the current workflow to load
	 * 
	 * @throws InterruptedException
	 */
	public void click_AddSchedule() throws InterruptedException {
		Thread.sleep(2000);
		dropdown_scheduleOperation.click();
		option_ScheduleOperation_AddSchedule.click();
	}

	public void window_CreateSchedule() {
		assertTrue(wind_createSchedule.isDisplayed());
	}

	public void enter_ScheduleName(String name) {
		System.out.println("ScheduleName : " + name);
		clearAndEnter(getDriver(), "//div[contains(@id,'workflowscheduleedit')]//input[@name='name']", name);
	}

	/**
	 * wait 2 seconds for loading the newly created schedule
	 * 
	 * @throws InterruptedException
	 */
	public void save_CreateSchedule() throws InterruptedException {
		Thread.sleep(5000);
		waitToBeClickableAndClick(getDriver(), saveBtn_CreateOrEditSchedule, 2);
		setScheduleCreated(true);
		Thread.sleep(50000);
	}

	public void present_Schedule(String scheduleName) throws InterruptedException {
		dropdown_scheduleList.click();
		isElementDisplayed_clickIfNeeded(500, getDriver(), "//span[text()='Schedule Name: " + scheduleName + "']", true,
				false);
	}

	public void click_EditSchedule(String scheduleName) {
		dropdown_scheduleOperation.click();
		option_ScheduleOperation_EditSchedule.click();
		clearAndEnter(getDriver(), "//div[contains(@id,'workflowscheduleedit')]//input[@name='name']", scheduleName);
	}

	public void save_EditSchedule() {
		waitToBeClickableAndClick(getDriver(), saveBtn_CreateOrEditSchedule, 2);
	}

	/**
	 * wait 2 seconds for deleting the refreshing the schedule
	 * 
	 * @throws InterruptedException
	 */
	public void click_DeleteSchedule() throws InterruptedException {
		dropdown_scheduleOperation.click();
		option_ScheduleOperation_DeleteSchedule.click();
		Thread.sleep(2000);
	}

	/**
	 * wait for the schedule to refresh after deleting
	 * 
	 * @param scheduleName
	 * @throws InterruptedException
	 */
	public void notPresent_Schedule(String scheduleName) throws InterruptedException {
		dropdown_scheduleList.click();
		assertFalse(isElementDisplayed_clickIfNeeded(1000, getDriver(),
				"//span[text()='Schedule Name: " + scheduleName + "']", false, false));
	}

	public void confirmation_DeleteSchedule_Yes() {
		confirmationWindow_DeleteSchedule_Yes.click();
	}

	/**
	 * wait 1 sec for the deleting process
	 * 
	 * @throws InterruptedException
	 */
	public void message_DeleteSchedule_OK() throws InterruptedException {
		messageWindow_ScheduleDeleted_OK.click();
		setScheduleCreated(false);
		Thread.sleep(1000);
	}

	public boolean isScheduleCreated() {
		return scheduleCreated;
	}

	public void setScheduleCreated(boolean scheduleCreated) {
		this.scheduleCreated = scheduleCreated;
	}

	/**
	 * Only use for clean up hook
	 * 
	 * @throws InterruptedException
	 */
	public void cleanUpSchedule() throws InterruptedException {
		if (isScheduleCreated()) {
			click_DeleteSchedule();
			confirmation_DeleteSchedule_Yes();
			message_DeleteSchedule_OK();
		}
	}

}
