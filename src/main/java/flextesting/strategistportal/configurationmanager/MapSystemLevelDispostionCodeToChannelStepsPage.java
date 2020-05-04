package flextesting.strategistportal.configurationmanager;


import com.qa.base.TestBase;
import flextesting.pagefactories.CommonElementsFactory;
import flextesting.strategistportal.defaultdata.ConfManagerData;
import flextesting.utilities.Utils;
import org.openqa.selenium.NoSuchElementException;

import static flextesting.utilities.Utils.clickByXpath;
import static flextesting.utilities.Utils.isElementDisplayed_clickIfNeeded;


public class MapSystemLevelDispostionCodeToChannelStepsPage extends TestBase {

	private CommonElementsFactory commonElementsFactory;
	// SLDCTC: SystemLevelDispostionCodeToChannel
	private String xpathOfSLDCTC = "//div[contains(@id, 'systemcoreagentdispositionchannelcode') and contains(@id, '-body')]//div[text()='"
			+ ConfManagerData.getDispositionCode() + "']";

	public void i_click_the_tab_Map_System_Level_Disposition_Code_to_Channel() throws Throwable {
		clickByXpath(getDriver(), "//span[text()='Map System Level Disposition Code to Channel']");
	}

	public void i_select_option_for_Channel_in_window_Add_System_Disposition_Channel_Code(int index) throws Throwable {
		clickByXpath(getDriver(), "//input[@name='channelId']");
		clickByXpath(getDriver(), "(//li[@role='option']//div)[" + index + "]");
	}

	public void i_select_the_Disposition_Code_created_earilier_in_window_Add_System_Disposition_Channel_Code()
			throws Throwable {
		clickByXpath(getDriver(), "//input[@name='dispositionCodeId']");
		String xpath = "//li[contains(@class,'x-boundlist-item')]//*[contains(text(),'"
				+ ConfManagerData.getDispositionCode() + "')]";
		boolean foundInCurrentPage = false;
		String xpathOfNextPageIcon = "//div[contains(@id,'systemdispositionchannelcodeedit')]//following::span[contains(@class,'x-tbar-page-next')]";
		String xpathOfGrayedOutNextPageIcon = "//div[contains(@id,'systemdispositionchannelcodeedit')]//following::span[contains(@class,'x-tbar-page-next')]//parent::button[@disable='']";
		while (!foundInCurrentPage) {
			try {
				clickByXpath(getDriver(), xpath);
				foundInCurrentPage = true;
			} catch (NoSuchElementException ex) {
				foundInCurrentPage = false;
				// if the next page button is not grayed-out, then click it.
				// else: throw exception
				if (!isElementDisplayed_clickIfNeeded(1000, getDriver(), xpathOfGrayedOutNextPageIcon, false, false))
					clickByXpath(getDriver(), xpathOfNextPageIcon);
				else
					throw new RuntimeException(
							"Disposition code not found in the list of window [Add System Disposition Channel Code]");
			}
		}
	}

	public void i_click_the_checkbox(String arg1) throws Throwable {
		commonElementsFactory.clickCheckBox("Check Verification");
	}

	public void i_select_the_System_Disposition_Channel_Code() throws Throwable {
		commonElementsFactory.search(ConfManagerData.getDispositionCode());
		// if no wait, then the selected might become not selected instantly
		// after it's selected for some weird unknown reason
		Thread.sleep(1500);
		Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfSLDCTC, true, true);
	}

	public void i_should_see_the_System_Disposition_Channel_Code_created() throws Throwable {
		commonElementsFactory.search(ConfManagerData.getDispositionCode());
		org.junit.Assert.assertTrue(Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfSLDCTC, true, false));
	}
}
