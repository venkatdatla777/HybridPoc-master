package flextesting.strategistportal.decisiontreemanager;


import com.qa.base.TestBase;
import flextesting.pagefactories.CommonElementsFactory;
import flextesting.utilities.DataUtil;

import static flextesting.utilities.Utils.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CIDStrategyCreationStepsPage extends TestBase {
	
	//private CommonElementsFactory commonElementsFactory;
	private String cidStrategyName = "CIDStrategy41_"+ DataUtil.getRandomChars();
	private String xpathOfTheStrategy = "//div[starts-with(@id,'strategylist')]//div[text()='"+cidStrategyName+"']";
	private String xpathOfTheStrategyCopy = "//div[starts-with(@id,'strategylist')]//div[text()='"+cidStrategyName+" copy']";
	
	public void i_click_in_the_Strategies_panel(String btnName) throws Throwable {
		clickByXpath(getDriver(), "//div[starts-with(@id,'strategylist')]//button//span[text()='"+btnName+"']");
	}

	public void i_choose_as_the_Strategy_Type(String optionName) throws Throwable {
		clickByXpath(getDriver(), "//input[@name='type']");
		commonElementsFactory.chooseAnOptionByName(optionName);
	}

	public void i_select_as_the_Event(String optionName) throws Throwable {
		clickByXpath(getDriver(), "//input[@name='eventId']");
		commonElementsFactory.chooseAnOptionByName(optionName);
	}
	
	public void i_enter_a_Name_for_the_CID_strategy() throws Throwable {
		clearAndEnter(getDriver(), "//input[@name='name']", cidStrategyName);
	}
	
	public void i_select_as_the_context_for_the_Strategy(String context) throws Throwable {
		clickByXpath(getDriver(), "//div[starts-with(@id,'strategyedit')]//input[@name='context']");
		//select a context (like 'Responsible')
		clickByXpath(getDriver(), "//li[text()='"+context+"']");
	}

	public void the_CID_strategy_is_saved() throws Throwable {
		assertTrue(isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfTheStrategy, true, false));
	}

	public void i_select_the_CID_strategy_just_created() throws Throwable {
		assertTrue(isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfTheStrategy, true, true));
	}

	public void the_CID_strategy_copy_is_saved() throws Throwable {
		assertTrue(isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfTheStrategyCopy, true, false));
	}

	public void the_CID_strategy_is_deleted() throws Throwable {
		assertFalse(isElementDisplayed_clickIfNeeded(2000, getDriver(), xpathOfTheStrategy, false, false));
	}
	
	public void i_add_a_CID_strategy_name_as_and_event_as(String name, String event) throws Throwable {
		clickByXpath(getDriver(), "//div[starts-with(@id,'strategylist')]//button//span[text()='Add']");
		clickByXpath(getDriver(), "//input[@name='type']");
		commonElementsFactory.chooseAnOptionByName("CID Strategy");
		clickByXpath(getDriver(), "//input[@name='eventId']");
		commonElementsFactory.chooseAnOptionByName(event);
		clearAndEnter(getDriver(), "//input[@name='name']", name);
		commonElementsFactory.click_Save();
		assertTrue(isElementDisplayed_clickIfNeeded(0, getDriver(), "//div[starts-with(@id,'strategylist')]//div[text()='"+name+"']", true, true));
	}
	
}
