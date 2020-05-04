package flextesting.strategistportal.configurationmanager;


import com.qa.base.TestBase;
import flextesting.client.ClientProvider;
import flextesting.exceptions.MissingMasterConfigurationException;
import flextesting.pagefactories.CommonElementsFactory;
import flextesting.strategistportal.defaultdata.ConfManagerData;
import flextesting.utilities.DataUtil;
import org.openqa.selenium.NoSuchElementException;

import static flextesting.utilities.Utils.*;
import static org.junit.Assert.assertTrue;

public class ConfigurationManagerStepsPage extends TestBase {
	private CommonElementsFactory commonElementsFactory;
	private String programTypeDesc = "Program type description_" + DataUtil.getRandomChars();

	// Disposition Code
	public void i_click_the_tab_Add_Edit_System_Level_Disposition_Code() throws Throwable {
		clickByXpath(getDriver(), "//span[text()='Add/Edit System Level Disposition Code']");
	}

	public void i_enter_a_Description_in_the_Add_System_Disposition_Code_window() throws Throwable {
		commonElementsFactory.enterDescription(ConfManagerData.description);
	}

	public void i_enter_a_Disposition_Code_in_the_Add_System_Disposition_Code_window() throws Throwable {
		clearAndEnter(getDriver(), "//input[@name='dispositionCode']", ConfManagerData.getDispositionCode());
	}

	public void i_select_as_the_Core_Category(String optionName) throws Throwable {
		commonElementsFactory.arrowTrigger("Core Category:");
		commonElementsFactory.chooseAnOptionByName(optionName);
	}

	public void i_select_as_the_Contact_Result(String optionName) throws Throwable {
		if (!ClientProvider.noContactResultFieldWhenAddingSystemDispositionCode) {
			commonElementsFactory.arrowTrigger("Contact Result:");
			commonElementsFactory.chooseAnOptionByName(optionName);
		}
	}

	public void i_should_see_the_disposition_code_created() throws Throwable {
		commonElementsFactory.search(ConfManagerData.getDispositionCode());
		org.junit.Assert.assertTrue(isElementDisplayed_clickIfNeeded(0, getDriver(),
				"//div[text()='" + ConfManagerData.getDispositionCode() + "']", true, false));
	}

	public void i_select_the_disposition_code() throws Throwable {
		commonElementsFactory.search(ConfManagerData.getDispositionCode());
		// if no wait, then the selected might become not selected instantly
		// after it's selected for some weird unknown reason
		Thread.sleep(1500);
		isElementDisplayed_clickIfNeeded(0, getDriver(),
				"//div[text()='" + ConfManagerData.getDispositionCode() + "']", true, true);
	}

	public void i_should_see_the_disposition_code_disabled() throws Throwable {
		commonElementsFactory.search(ConfManagerData.getDispositionCode());
		String xpath = "//div[text()='" + ConfManagerData.getDispositionCode()
				+ "']//parent::td//parent::tr[contains(@class,'error-row')]";
		org.junit.Assert.assertTrue(isElementDisplayed_clickIfNeeded(0, getDriver(), xpath, true, false));
	}

	public void i_should_see_the_disposition_code_enabled() throws Throwable {
		commonElementsFactory.search(ConfManagerData.getDispositionCode());
		org.junit.Assert.assertTrue(
				isElementDisplayed_clickIfNeeded(0, getDriver(), "//div[text()='ENABLED']", true, false));
	}

	public void i_should_see_the_disposition_code_deleted() throws Throwable {
		commonElementsFactory.search(ConfManagerData.getDispositionCode());
		String xpath = "//div[text()='" + ConfManagerData.getDispositionCode()
				+ "']//parent::td//parent::tr[contains(@class,'locked-row')]";
		org.junit.Assert.assertTrue(isElementDisplayed_clickIfNeeded(0, getDriver(), xpath, true, false));
	}
	// End of disposition code

	// Program Type
	// program type: one sentence step:
	/**
	 * Only add a program type if no one exist
	 * 
	 * @throws Throwable
	 */

	public void i_add_a_program_type() throws Throwable {
		String xpathOfAnyProgramType = "//div[starts-with(@id,'portfolioprogramtypelist')]//tr[contains(@class,'x-grid-row')]";
		if (!isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfAnyProgramType, true, false)) {
			clickByXpath(getDriver(), "//span[text()='Add']");
			try {
				i_select_a_Program_Type();
			} catch (NoSuchElementException ex) {
				throw new MissingMasterConfigurationException("Basic Program Type is not configured");
			}
			i_enter_a_description_for_the_Program_Type();
			commonElementsFactory.click_Submit();
			i_should_see_the_program_type_saved();
		}
	}
	// program type: details steps

	public void i_select_as_the_Configuration_Category(String arg1) throws Throwable {
		commonElementsFactory.arrowTrigger("Configuration Category");
		commonElementsFactory.chooseAnOptionByName(arg1);
	}

	public void i_select_a_Program_Type() throws Throwable {
		clickByXpath(getDriver(), "//input[@name='programTypeId']");
		// choose the first one
		clickByXpath(getDriver(), "//div[starts-with(@id,'portfolioprogramtypeedit')]//following::li[@role='option']");
	}

	public void i_enter_a_description_for_the_Program_Type() throws Throwable {
		clearAndEnter(getDriver(), "//input[@name='description']", programTypeDesc);
	}

	public void i_should_see_the_program_type_saved() throws Throwable {
		assertTrue(isElementDisplayed_clickIfNeeded(0, getDriver(), "//div[text()='" + programTypeDesc + "']", true,
				false));
	}
}
