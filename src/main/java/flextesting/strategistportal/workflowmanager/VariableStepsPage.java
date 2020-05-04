package flextesting.strategistportal.workflowmanager;


import com.qa.base.TestBase;
import flextesting.commonsteps.CommonElementsStepsPage;
import flextesting.pagefactories.CommonElementsFactory;
import flextesting.strategistportal.workflowmanager.data.VariableData;

import static flextesting.utilities.Utils.clickByXpath;
import static flextesting.utilities.Utils.isElementDisplayed_clickIfNeeded;


public class VariableStepsPage extends TestBase {

	private CommonElementsFactory commonElementsFactory;
	public CommonElementsStepsPage commonElementsSteps;
	
	
	public void i_click_the_Variables_tab_in_WM() throws Throwable {
		clickByXpath(getDriver(), "//span[@class='x-tab-inner' and text()='Variables']");
	}

	
	public void i_click_the_button_under_the_Variables_tab(String buttonName) throws Throwable {
		clickByXpath(getDriver(), "//div[starts-with(@id,'variableactiongrid')]//span[@class='x-btn-inner' and text()='"+buttonName+"']");
	}

	
	public void i_enter_a_Variable_Name_in_the_Add_Variable_window() throws Throwable {
		commonElementsFactory.enterName(VariableData.getName());
	}

	
	public void i_enter_a_Display_Name_in_the_Add_Variable_window() throws Throwable {
		commonElementsFactory.enterDisplayName(VariableData.getName());
	}

	
	public void i_choose_as_the_Data_Type(String optionName) throws Throwable {
		commonElementsFactory.arrowTrigger("Data Type:");
		commonElementsFactory.chooseAnOptionByName(optionName);
	}

	
	public void the_variable_is_created_under_the_Variables_tab() throws Throwable {
		commonElementsFactory.search(VariableData.getName());
		org.junit.Assert.assertTrue(isElementDisplayed_clickIfNeeded(0, getDriver(), "//div[text()='"+VariableData.getName()+"']", true, false));
	}

	
	public void i_select_the_variable_in_WM() throws Throwable {
		i_click_the_Variables_tab_in_WM();
		commonElementsFactory.search(VariableData.getName());
		isElementDisplayed_clickIfNeeded(0, getDriver(), "//div[text()='"+VariableData.getName()+"']", true, true);
	}

	
	public void i_enter_an_Description_in_the_Add_Variable_window() throws Throwable {
		commonElementsFactory.enterDescription(VariableData.Description);
	}

	
	public void the_variable_is_deleted_under_the_Variables_tab() throws Throwable {
		commonElementsFactory.search(VariableData.getName());
		org.junit.Assert.assertFalse(isElementDisplayed_clickIfNeeded(1000, getDriver(), "//div[text()='"+VariableData.getName()+"']", false, false));
	}
	
	
	public void i_create_a_sample_variable_if_not_already_existing() throws Throwable {
		String varName = VariableData.getPermanentName();
		i_click_the_Variables_tab_in_WM();
		commonElementsFactory.search(varName);
		//continue creating var if not already existing
		if (!isElementDisplayed_clickIfNeeded(0, getDriver(), "//div[text()='"+varName+"']", true, false)) {
			i_click_the_button_under_the_Variables_tab("Add");
			commonElementsFactory.enterName(varName);
			commonElementsFactory.enterDisplayName(varName);
			i_choose_as_the_Data_Type("Currency");
			commonElementsSteps.i_click_the_Next_button();
			commonElementsSteps.i_click_the_Submit_button();
		}
	}
	
}
