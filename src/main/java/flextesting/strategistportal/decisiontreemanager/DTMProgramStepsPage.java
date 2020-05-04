package flextesting.strategistportal.decisiontreemanager;


import com.qa.base.TestBase;
import flextesting.pagefactories.CommonElementsFactory;
import flextesting.pagefactories.strategistportal.decisiontreemanager.DTMProgramFactory;
import flextesting.strategistportal.defaultdata.ProgramData;
import flextesting.utilities.Utils;

public class DTMProgramStepsPage extends TestBase {
	//private DTMProgramFactory programFactory;
	//private CommonElementsFactory commonElementsFactory;
	
	public boolean isProgramCreated() {
		return programFactory.isProgramCreated();
	}

	public void i_create_a_new_program() throws Throwable {
		createProgram(ProgramData.getName());
	}
	
	private void createProgram(String programName) throws InterruptedException {
		programFactory.click_tab_Programs();
		programFactory.click_Add_tab_Programs();
		programFactory.window_AddProgramAction();
		programFactory.enter_Name(programName);
		programFactory.choose_ProgramType_Any();
		programFactory.choose_InstallmentFrequency_Monthly();
		programFactory.enter_DueDateRange("3");
		programFactory.choose_RoundingMethod_CentsRoundUp();
		programFactory.enter_TotalNumberOfInstallments("10");
		programFactory.enter_NumberOfPaymentsRequired("5");
		programFactory.enter_TotalAmount("5000");
		programFactory.click_Edit_ProgramAvailableTo_window_AddProgramAction();
		programFactory.window_ProgramAvailableTo();
		//programFactory.choose_ProgramAvailableTo_Admin();
		programFactory.choose_ProgramAvailableTo_Web();
		programFactory.click_close_window_ProgramAvailableTo();
		programFactory.save_AddProgramAction();	
	}

	public void the_program_should_be_created() throws Throwable {
		checkIfProgramExist(true);
	}
	
	public void i_delete_the_program() throws Throwable {
		if (isProgramCreated()) {
			programFactory.click_tab_Programs();
			commonElementsFactory.search(ProgramData.getName());
			Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), "//div[text()='"+ProgramData.getName()+"']", true, true);
			programFactory.click_Delete_tab_Programs();
			programFactory.confirmation_RemoveActionFromPortfolio();
			programFactory.confirmation_RemoveActionFromPortfolio_Yes();
		}
	}

	public void the_program_is_deleted() throws Throwable {
		checkIfProgramExist(false);
	}
	
	private void checkIfProgramExist(boolean expectToExist) throws InterruptedException {
		Utils.clearAndEnter(getDriver(), "//input[starts-with(@id,'triggerfield')]", ProgramData.getName());
		commonElementsFactory.click_Search();
		String xpath = "//div[contains(@class,'x-grid-cell-inner') and text()='"+ProgramData.getName()+"']";
		if (expectToExist)
			org.junit.Assert.assertTrue(Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), xpath, true, false));
		else
			org.junit.Assert.assertFalse(Utils.isElementDisplayed_clickIfNeeded(1500, getDriver(), xpath, false, false));
	}
	
	public void i_create_a_sample_program_if_not_already_existing() throws Throwable {
		String sampleProgramName = ProgramData.getPermanentName();
		programFactory.click_tab_Programs();
		commonElementsFactory.search(sampleProgramName);
		//continue creating the sample program is not existing
		if (!Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), "//div[text()='"+sampleProgramName+"']", true, false)) {
			createProgram(sampleProgramName);
		}
	}
	
	public void i_create_a_program_as_in_DTM(String programName) throws Throwable {
		if(programName.contains("Settlement")){
			createProgramWithData(programName, "Settlement");
		} else {
			createProgramWithData(programName, "Full");
		}
		checkIfProgramExist(programName,true);
	}
	
	private void createProgramWithData(String programName, String ProgramType) throws InterruptedException {
		programFactory.click_tab_Programs();
		programFactory.click_Add_tab_Programs();
		programFactory.window_AddProgramAction();
		programFactory.enter_Name(programName);
		if(ProgramType.equals("Settlement")){
			programFactory.choose_ProgramType_Settlement();
			programFactory.enter_firstInstallment_dueDate("today");
			programFactory.choose_InstallmentFrequency_Monthly();
			programFactory.enter_DueDateRange("7");
			programFactory.choose_RoundingMethod_CentsRoundUp();
			programFactory.enter_TotalNumberOfInstallments("3");
			programFactory.enter_NumberOfPaymentsRequired("3");
			programFactory.enter_TotalAmount("CurrentDue");
			programFactory.click_Edit_ProgramAvailableTo_window_AddProgramAction();
			programFactory.window_ProgramAvailableTo();
			programFactory.choose_ProgramAvailable_To_Web();
			programFactory.choose_ProgramAvailable_To_Admin();
		} else {
			programFactory.choose_ProgramType_Any();
			programFactory.choose_InstallmentFrequency("Fortnightly");
			programFactory.enter_DueDateRange("10");
			programFactory.choose_RoundingMethod_CentsRoundUp();
			programFactory.enter_TotalNumberOfInstallments("2");
			programFactory.enter_NumberOfPaymentsRequired("2");
			programFactory.enter_NoOfPromisesRequired("2");
			programFactory.enter_TotalAmount("balance");
			programFactory.click_Edit_ProgramAvailableTo_window_AddProgramAction();
			programFactory.window_ProgramAvailableTo();
			programFactory.choose_ProgramAvailableTo_Admin();
			programFactory.choose_ProgramAvailableTo_Web();
			programFactory.choose_ProgramAvailableTo_Admin();
		}
		programFactory.click_close_window_ProgramAvailableTo();
		programFactory.save_AddProgramAction();	
	}
	
	private void checkIfProgramExist(String programName, boolean expectToExist) throws InterruptedException {
		Utils.clearAndEnter(getDriver(), "//input[starts-with(@id,'triggerfield')]", programName);
		commonElementsFactory.click_Search();
		String xpath = "//div[contains(@class,'x-grid-cell-inner') and text()='"+programName+"']";
		if (expectToExist)
			org.junit.Assert.assertTrue(Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), xpath, true, false));
		else
			org.junit.Assert.assertFalse(Utils.isElementDisplayed_clickIfNeeded(1500, getDriver(), xpath, false, false));
	}
}
