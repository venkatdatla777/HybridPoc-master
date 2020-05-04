package flextesting.strategistportal.workflowmanager;


import com.qa.base.TestBase;
import flextesting.pagefactories.CommonElementsFactory;
import flextesting.utilities.DataUtil;
import org.openqa.selenium.By;

import static flextesting.utilities.Utils.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HotspotStepsPage extends TestBase {
	private CommonElementsFactory commonElementsFactory;
	private String randomChars = DataUtil.getRandomChars();
	private String xpathOfHotspot = "//div[contains(@class,'x-grid-cell-inner') and contains(text(),'" + randomChars
			+ "')]";

	public void i_right_click_the_start_node_of_the_task() throws Throwable {
		String xpathOfTheStartNode = "//div[starts-with(@id,'workflowgraph') and contains(@id, '-body')]//*[local-name()='g']//*[local-name()='text' and starts-with(text(),'Start')]";
		rightClickElement(getDriver(), getDriver().findElement(By.xpath(xpathOfTheStartNode)));
	}

	public void i_click_the_button_in_Manage_Hotspot_Assignment_window(String btnName) throws Throwable {
		clickByXpath(getDriver(),
				"//div[starts-with(@id,'workflowhotspotlist')]//button//span[text()='" + btnName + "']");
	}

	public void i_choose_to_be_the_Hotspot_Name(String hotspotName) throws Throwable {
		clickByXpath(getDriver(), "//input[@name='hotSpotId']");// works like
																// clicking the
																// arrow trigger
		// choose hotspot if found, otherwise, choose the first one
		String xpath_hotspot = "//li[@role='option' and contains(text(),'" + hotspotName + "')]";
		if (isElementDisplayed_clickIfNeeded(0, getDriver(), xpath_hotspot, true, false))
			clickByXpath(getDriver(), "//li[@role='option' and contains(text(),'" + hotspotName + "')]");
		else
			clickByXpath(getDriver(), "//li[@role='option']");
	}

	public void i_enter_to_be_the_Hotspot_Link_Text(String text) throws Throwable {
		enterTextInIframe(getDriver(), "//iframe", text + " " + randomChars);
	}

	public void the_hotspot_is_created_in_Manage_Hotspot_Assignment_window() throws Throwable {
		assertTrue(isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfHotspot, true, false));
	}

	public void i_choose_the_hotspot_just_being_created() throws Throwable {
		isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfHotspot, true, true);
	}

	public void i_check_the_Launch_workflow_within_the_same_browser_tab_on_the_Customer_Portal() throws Throwable {
		clickByXpath(getDriver(), "//label[text()='Launch workflow within the same browser tab on the Customer Portal']");
	}

	public void the_hotspot_is_deleted_in_Manage_Hotspot_Assignment_window() throws Throwable {
		assertFalse(isElementDisplayed_clickIfNeeded(2000, getDriver(), xpathOfHotspot, false, false));
	}

	public void i_close_the_Manage_Hotspot_Assignment_window() throws Throwable {
		commonElementsFactory.closeWindowByNameContaining("Manage Hotspot Assignment for Flow");
	}

}
