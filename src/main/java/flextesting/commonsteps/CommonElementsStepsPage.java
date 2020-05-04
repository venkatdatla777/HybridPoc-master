package flextesting.commonsteps;


import com.qa.base.TestBase;
import flextesting.AppConfig;
import flextesting.pagefactories.CommonElementsFactory;
import flextesting.utilities.Utils;
import org.openqa.selenium.NoSuchElementException;

import static flextesting.utilities.Utils.clickByXpath;


public class CommonElementsStepsPage extends TestBase {
	//private CommonElementsFactory commonElementsFactory;

	public void i_click_the_Next_button() throws Throwable {
		commonElementsFactory.click_Next();
	}

	public void i_click_the_Save_button() throws Throwable {
		commonElementsFactory.click_Save();
	}

	public void i_click_the_Submit_button() throws Throwable {
		commonElementsFactory.click_Submit();
	}

	public void i_click_Yes_in_the_confirmation_window() throws Throwable {
		commonElementsFactory.confirm_Yes();
	}

	public void i_click_OK() throws Throwable {
		try {
			commonElementsFactory.message_OK();
		} catch (NoSuchElementException ex) {
			// if only has account view, then some click OK steps are allowed to
			// throw this exception because no such step, thus we ignore the ex
			// else throw the ex
			// TODO: be more clear when are allowed, like in which feature
			if (!AppConfig.isHideCustomerContainer())
				throw ex;
		}
	}

	/**
	 * Not used
	 * 
	 * @param name
	 * @throws Throwable
	 */
	public void i_enter_as_the_name(String name) throws Throwable {
		commonElementsFactory.enterName(name);
	}

	public void i_enter_as_the_description(String description) throws Throwable {
		commonElementsFactory.enterDescription(description);
	}

	public void i_close_the_window(String windowName) throws Throwable {
		commonElementsFactory.closeWindow(windowName);
	}

	public void i_have_selected_as_the_context(String context) throws Throwable {
		// trigger dropdown menu
		clickByXpath(getDriver(),
				"//*[text()='Context' or text()='Context:']//following::div[contains(@class,'x-form-arrow-trigger')][1]");
		// select a context (like 'Responsible')
		clickByXpath(getDriver(), "//li[text()='" + context + "']");
	}

	public void i_have_selected_a_portfolio() throws Throwable {
		// trigger the dropdown menu
		// maybe change "div" to "*" to include "label" (from:
		// i_select_a_portfolio_in_the_Create_Entity_Billing_Group_window)
		clickByXpath(getDriver(),
				"//div[contains(text(),'Portfolio')]//following::div[contains(@class,'x-form-arrow-trigger')][1]");
		// select a portfolio
		Utils.selectAPortfolioFromDropDown(getDriver());
		// clickByXpath(getDriver(),
		// "//div[text()='"+ClientProvider.getClient().getAvailablePortfolio()+"']");
	}

	public void i_click_the_button(String buttonName) throws Throwable {
		clickByXpath(getDriver(), "//span[text()='" + buttonName + "']");
	}

}
