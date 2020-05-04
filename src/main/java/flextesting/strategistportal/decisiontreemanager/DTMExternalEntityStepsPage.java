package flextesting.strategistportal.decisiontreemanager;


import com.qa.base.TestBase;
import flextesting.pagefactories.CommonElementsFactory;
import flextesting.utilities.DataUtil;
import flextesting.utilities.Utils;
import org.junit.Assert;

import static flextesting.utilities.Utils.clickByXpath;


public class DTMExternalEntityStepsPage extends TestBase {
	//private CommonElementsFactory commonElementsFactory;
	private String EEname = "EE_" + DataUtil.getRandomChars();

	public void i_click_the_External_Entity_tab_in_DTM() throws Throwable {
		clickByXpath(getDriver(),
				"//div[starts-with(@id,'tabbar')]//div[starts-with(@id,'tab')]//button//span[text()='External Entity']");
		Thread.sleep(1500);
	}

	public void i_click_the_button_under_the_External_Entity_tab(String btnName) throws Throwable {
		String xpath = "//div[starts-with(@id,'actionstabpanel') and contains(@id,'-body')]//div[starts-with(@id,'actionofroleassignmentgrid')]//div[starts-with(@id,'buttongroup')]//span[text()='"
				+ btnName + "']";
		clickByXpath(getDriver(), xpath);
	}

	public void i_enter_an_Action_Name_for_the_External_Entity() throws Throwable {
		commonElementsFactory.enterName(EEname);
	}

	public void i_choose_an_available_external_entity_in_the_Add_External_Entity_window() throws Throwable {
		clickByXpath(getDriver(), "//div[@role='presentation']//div[@class='x-grid-cell-inner ']");
		clickByXpath(getDriver(), "//span[@class='x-btn-icon arrow_right']");
	}

	public void the_external_entity_is_saved_in_Action_Repository() throws Throwable {
		Utils.clearAndEnter(getDriver(),
				"//div[starts-with(@id,'actionofroleassignmentgrid')]//input[starts-with(@id,'triggerfield')]", EEname);
		clickByXpath(getDriver(),
				"//div[starts-with(@id,'actionofroleassignmentgrid')]//div[contains(@class,'x-form-search-trigger')]");
		Assert.assertTrue(
				Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), "//div[text()='" + EEname + "']", true, false));
	}
	
	public void i_create_a_external_entity_as_in_DTM(String eeName) throws Throwable {
		i_click_the_External_Entity_tab_in_DTM();
		i_click_the_button_under_the_External_Entity_tab("Add");
		commonElementsFactory.enterName(eeName);
		i_choose_an_available_external_entity_in_the_Add_External_Entity_window();
		commonElementsFactory.click_Save();
		Utils.clearAndEnter(getDriver(),
				"//div[starts-with(@id,'actionofroleassignmentgrid')]//input[starts-with(@id,'triggerfield')]", eeName);
		clickByXpath(getDriver(),
				"//div[starts-with(@id,'actionofroleassignmentgrid')]//div[contains(@class,'x-form-search-trigger')]");
		Assert.assertTrue(
				Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), "//div[text()='" + eeName + "']", true, false));
	}

}
