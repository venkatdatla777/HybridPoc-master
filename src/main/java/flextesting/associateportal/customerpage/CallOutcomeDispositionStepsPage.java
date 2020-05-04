package flextesting.associateportal.customerpage;

import com.qa.base.TestBase;
import flextesting.utilities.DataUtil;
import org.junit.Assert;

import static flextesting.utilities.Utils.*;

public class CallOutcomeDispositionStepsPage extends TestBase {
	private String channel, destination, spokeTo, callOutcome, comment;

	public void i_click_the_icon_Call_Outcome_Disposition() throws Throwable {
		// clickByXpath(getDriver(), "//span[text()='Manual Call Outcome
		// Disposition']");
		clickByXpath(getDriver(), "//table[@id='editCallOutcomeButton']");
	}

	public void i_choose_for_Channel_in_window_Manual_Call_Outcome_Disposition(String arg1) throws Throwable {
		channel = arg1;
		clickByXpath(getDriver(), "//label[contains(text(),'" + arg1 + "')]");
	}

	public void i_choose_for_Destination_Type_in_window_Manual_Call_Outcome_Disposition(String arg1) throws Throwable {
		destination = arg1;
		clickByXpath(getDriver(), "//label[contains(text(),'" + arg1 + "')]");
	}

	public void i_choose_for_Spoke_To_in_window_Manual_Call_Outcome_Disposition(String arg1) throws Throwable {
		spokeTo = arg1;
		clickByXpath(getDriver(), "//label[contains(text(),'" + arg1 + "')]");
	}

	public void i_choose_for_Call_Outcome_in_window_Manual_Call_Outcome_Disposition(String arg1) throws Throwable {
		callOutcome = arg1;
		clickByXpath(getDriver(), "//label[contains(text(),'" + arg1 + "')]");
	}

	public void i_enter_a_comments_in_window_Manual_Call_Outcome_Disposition() throws Throwable {
		comment = "Some random comment: " + DataUtil.getRandomChars();
		clearAndEnter(getDriver(), "//textarea[@name='notes']", comment);
	}

	public void i_should_see_the_call_outcome_disposition_showing_in_activities() throws Throwable {
		// refresh the Activities table
		// with waiting, the button might not be actually clicked
		Thread.sleep(2000);
		clickByXpath(getDriver(), "(//button[text()='Show All Activities']//following::button[text()='Refresh'])[1]");
		String callOutcomeDispositionActivity = "//div[contains(text(),'" + channel + "') " + "and contains(text(),'"
				+ destination + "') " + "and contains(text(),'" + spokeTo + "') " + "and contains(text(),'"
				+ callOutcome + "') " + "and contains(text(),'" + comment + "')]";
		Assert.assertTrue(
				isElementDisplayed_clickIfNeeded(0, getDriver(), callOutcomeDispositionActivity, true, false));
	}
	// div[contains(text(),'Inbound Call') and contains(text(),'Inbound Direct')
	// and contains(text(),'Other') and contains(text(),'Right Party Contact')]
}
