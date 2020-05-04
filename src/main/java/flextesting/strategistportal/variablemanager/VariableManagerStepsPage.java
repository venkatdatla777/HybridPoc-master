package flextesting.strategistportal.variablemanager;


import com.qa.base.TestBase;
import flextesting.pagefactories.CommonElementsFactory;
import flextesting.pagefactories.strategistportal.variablemanager.VariableManagerFactory;
import flextesting.strategistportal.defaultdata.VariableData;

import java.util.Arrays;
import java.util.List;

import static flextesting.utilities.Utils.*;


public class VariableManagerStepsPage extends TestBase {

	private VariableManagerFactory variableManagerFactory;
	private CommonElementsFactory commonElementsFactory;

	public void i_click_the_Variable_button(String buttonName) throws Throwable {
		clickByXpath(getDriver(), "//span[text()='" + buttonName + " Variable']");
	}

	public void i_enter_a_Variable_Name_in_the_New_Variable_window() throws Throwable {
		commonElementsFactory.enterName(VariableData.getName());
	}

	public void i_enter_a_Display_Name_in_the_New_Variable_window() throws Throwable {
		clearAndEnter(getDriver(), "//input[@name='displayName']", VariableData.getName());
	}

	public void i_select_as_the_Variable_Type(String mappedOrDerived) throws Throwable {
		// trigger the dropdown menu
		clickByXpath(getDriver(),
				"//label[text()='Variable Type:']//following::div[contains(@class,'x-form-arrow-trigger')][1]");
		clickByXpath(getDriver(), "//li[text()='" + mappedOrDerived + "']");
	}

	public void i_enter_as_the_Expression_in_the_New_Variable_window(String arg1) throws Throwable {
		String textareaXpath = "//label[text()='Expression:']//following::textarea";
		clearAndEnter(getDriver(), textareaXpath, arg1);
		// clickByXpath(getDriver(), "//div[@class='criteria-item
		// criteria-item-var']");
		// clicking something to make the next button not grayed-out
		Thread.sleep(1000);
		clickByXpath(getDriver(), "//label[text()='Expression:']");
	}

	public void i_choose_a_format() throws Throwable {
		// choose the first one
		clickByXpath(getDriver(),
				"//span[text()='Please select a format for the decimal type value...']//following::input[1]");
	}

	public void the_variable_is_created() throws Throwable {
		commonElementsFactory.search(VariableData.getName());
		org.junit.Assert.assertTrue(isElementDisplayed_clickIfNeeded(0, getDriver(),
				"//div[text()='" + VariableData.getName() + "']", true, true));
	}

	public void i_enter_a_Tag_in_the_Update_Variable_window() throws Throwable {
		clearAndEnter(getDriver(), "//input[@name='tag']", VariableData.tag);
	}

	public void the_variable_is_deleted() throws Throwable {
		commonElementsFactory.search(VariableData.getName());
		org.junit.Assert.assertFalse(isElementDisplayed_clickIfNeeded(1000, getDriver(),
				"//div[text()='" + VariableData.getName() + "']", false, false));
	}

	public void i_have_selected_this_portfolio(int arg1) throws Throwable {
		clickByXpath(getDriver(),
				"//div[contains(text(),'Portfolio')]//following::div[contains(@class,'x-form-arrow-trigger')][1]");
		// select a portfolio
		String xpathOfAPortfolio = "//*[(self::li or self::div) and "
				+ "(contains(@class,'x-boundlist-item') or @role='option' or contains(@class,'x-combo-list-item')) and "
				+ "contains(text(),'" + arg1 + "')]";
		clickByXpath(getDriver(), xpathOfAPortfolio);
	}

	public void i_create_these_variables_in(int arg1, List<List<String>> arg2) throws Throwable {
		for (List<String> list : arg2) {
			Thread.sleep(2000);
			i_click_the_Variable_button("Add New");
			commonElementsFactory.enterName(list.get(0) + arg1);
			clearAndEnter(getDriver(), "//input[@name='displayName']", list.get(0) + arg1);
			i_select_as_the_Variable_Type("Derived");
			i_enter_as_the_Expression_in_the_New_Variable_window(list.get(1) + "(" + arg1 + ")");
			commonElementsFactory.click_Next();
			try {
				Thread.sleep(2000);
				i_choose_a_format();
				commonElementsFactory.message_OK();
			} catch (Exception ex) {
				System.out.println("may be no format to choose");
			}
			commonElementsFactory.click_Submit();
			commonElementsFactory.message_OK();
		}
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
		System.out.println("round: " + arg1);
		System.out.println(Arrays.toString(arg2.toArray()));
	}
}
