package flextesting.pagefactories.strategistportal.decisiontreemanager;

import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static flextesting.utilities.Utils.clickByXpath;
import static flextesting.utilities.Utils.isElementDisplayed_clickIfNeeded;

public class DTMScheduleFactory extends TestBase {
	@FindBy(xpath="//span[text()='Schedule Operation:']")
	private WebElement dropdown_scheduleOperation;

	@FindBy(xpath="//label[text()='Schedule Date:']//following::td[@class='x-trigger-cell'][1]//div")
	private WebElement dropdown_scheduleDate;

	@FindBy(xpath="//table[@class='x-datepicker-inner']")
	private WebElement picker_scheduleDate;

	private boolean scheduleCreated = false;
	
	public void choose_ScheduleOperaton(String operation) {
		dropdown_scheduleOperation.click();
		clickByXpath(getDriver(), "//span[text()='"+operation+"']");
		
	}

	/**
	 * @param daysFromToday
	 * 0 for today, 1 for tomorrow, etc...
	 * @throws InterruptedException 
	 */
	public void pick_ScheduleDate(int daysFromToday) throws InterruptedException {
		dropdown_scheduleDate.click();
	    //List<WebElement> allValidDates = datePicker.findElements(By.xpath("//td[contains(@class,'x-datepicker-active')]"));
		//index starts from 1, so we add 1 to it
		Thread.sleep(1000);
		//if today
		if (daysFromToday == 0) {
			  picker_scheduleDate.findElement(By.xpath("//td[contains(@class,'x-date-today')]")).click();
		} 
		//if not today, but future
		else {
			try {
				picker_scheduleDate.findElement(By.xpath("//td[contains(@class,'x-datepicker-active')]["+(daysFromToday+1)+"]")).click();
			} catch (NoSuchElementException ex) {
				//near the end of month, you could find this exception occur. Need to go to the next month, and select from there
				//a[@role='button' and contains(@title,'Next Month')]
				clickByXpath(getDriver(), "//a[@role='button' and contains(@title,'Next Month')]");
				picker_scheduleDate.findElement(By.xpath("//td[contains(@class,'x-datepicker-active')]["+daysFromToday+"]")).click();
			}
		}
	}

	public void dropdown_scheduleList() {
		clickByXpath(getDriver(), "//table[starts-with(@id,'previewschedulecombo') and contains(@id,'triggerWrap')]//div[contains(@class,'x-form-arrow-trigger')]");
	}

	public boolean isPresent_ScheduleByName(String scheduleName, boolean expectedPresent) throws InterruptedException {
		return isElementDisplayed_clickIfNeeded(0, getDriver(), "//span[contains(text(),'"+scheduleName+"')]", expectedPresent, false);
	}

	public boolean isScheduleCreated() {
		return scheduleCreated;
	}

	public void setScheduleCreated(boolean scheduleCreated) {
		this.scheduleCreated = scheduleCreated;
	}
	

	
}
