package flextesting.strategistportal.workflowmanager;

import com.qa.base.TestBase;
import flextesting.pagefactories.CommonElementsFactory;
import flextesting.pagefactories.strategistportal.workflowmanager.WMProgramFactory;
import flextesting.strategistportal.defaultdata.ProgramData;
import flextesting.utilities.Utils;

import static flextesting.utilities.Utils.clickByXpath;
import static flextesting.utilities.Utils.isElementDisplayed_clickIfNeeded;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WMProgramStepsPage extends TestBase {

	private WMProgramFactory programFactory;
	private CommonElementsFactory commonElementsFactory;
	private String xpathOfProgram = "//div[text()='" + ProgramData.getName() + "']";
	private String xpathOfProgramCopy = "//div[text()='" + ProgramData.getName() + " copy']";

	public void i_create_a_new_program_in_Workflow_Manager() throws Throwable {
		programFactory.click_tab_Programs();
		programFactory.click_Add_tab_Programs();
		programFactory.window_AddProgramAction();
		commonElementsFactory.enterName(ProgramData.getName());
		programFactory.choose_ProgramType_Any();
		programFactory.choose_InstallmentFrequency_Monthly();
		programFactory.enter_DueDateRange("3");
		programFactory.choose_RoundingMethod_CentsRoundUp();
		programFactory.enter_TotalNumberOfInstallments("10");
		programFactory.enter_NumberOfPaymentsRequired("5");
		programFactory.enter_TotalAmount("5000");
		programFactory.click_Edit_ProgramAvailableTo_window_AddProgramAction();
		programFactory.window_ProgramAvailableTo();
		// programFactory.choose_ProgramAvailableTo_Admin();
		programFactory.choose_ProgramAvailableTo_Web();
		programFactory.click_close_window_ProgramAvailableTo();
		programFactory.save_AddProgramAction();
	}

	public void the_program_should_be_created_in_Workflow_Manager() throws Throwable {
		commonElementsFactory.search(ProgramData.getName());
		assertTrue(isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfProgram, true, false));
	}

	public void i_delete_the_program_in_Workflow_Manager() throws Throwable {
		deleteProgram(ProgramData.getName());
	}

	private void deleteProgram(String name) throws InterruptedException {
		programFactory.click_tab_Programs();
		commonElementsFactory.search(name);
		Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), "//div[text()='" + name + "']", true, true);
		programFactory.click_Delete_tab_Programs();
		programFactory.confirmation_RemoveActionFromPortfolio();
		programFactory.confirmation_RemoveActionFromPortfolio_Yes();
	}

	public void the_program_is_deleted_in_Workflow_Manager() throws Throwable {
		commonElementsFactory.search(ProgramData.getName());
		assertFalse(isElementDisplayed_clickIfNeeded(2000, getDriver(), xpathOfProgram, false, false));
	}

	// =========================NEW===========================
	public void i_select_the_program_just_created() throws Throwable {
		isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfProgram, true, true);
	}

	public void i_click_the_button_in_the_Workflow_Repository_panel(String arg1) throws Throwable {
		clickByXpath(getDriver(), "//div[starts-with(@id,'workflowrepository')]//button//span[text()='" + arg1 + "']");
	}

	public void the_program_copy_is_saved() throws Throwable {
		commonElementsFactory.search(ProgramData.getName() + " copy");
		assertTrue(isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfProgramCopy, true, false));
	}

	public void i_delete_the_program_copy_in_Workflow_Manager() throws Throwable {
		deleteProgram(ProgramData.getName() + " copy");
	}

	public void the_program_copy_is_deleted_in_Workflow_Manager() throws Throwable {
		commonElementsFactory.search(ProgramData.getName() + " copy");
		assertFalse(isElementDisplayed_clickIfNeeded(2000, getDriver(), xpathOfProgramCopy, false, false));
	}

}
