package flextesting.pagefactories.strategistportal.decisiontreemanager;

import com.qa.base.TestBase;
import flextesting.utilities.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static flextesting.utilities.Utils.clearAndEnter;
import static flextesting.utilities.Utils.waitToBeClickableAndClick;

public class DecisionTreeCreationFactory extends TestBase {
	@FindBy(xpath="//div[starts-with(@id,'strategylist') and 'header' = substring(@id, string-length(@id)- string-length('header') +1)]//following::span[text()='Add'][1]")
	private WebElement btn_AddStrategy;

	@FindBy(xpath="//span[starts-with(@id,'strategyedit') and text()='Add Strategy']")
	private WebElement wind_AddStrategy;

	@FindBy(xpath="//div[starts-with(@id,'strategyedit')]//descendant::span[text()='Save']//parent::button[1]")
	private WebElement saveBtn_AddStrategy;

	@FindBy(name="name")
	private WebElement field_Name;


	public void click_AddEditCopyDeleteStrategy(String buttonName) throws InterruptedException {
		//wait for the new schedule to load
		//(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(addStrategyBtn));
		Thread.sleep(2000);
		Utils.clickByXpath(getDriver(), "//div[starts-with(@id,'strategylist') and 'header' = substring(@id, string-length(@id)- string-length('header') +1)]//following::span[text()='"+buttonName+"'][1]");
	}
	
	public void window_AddStrategy() {
		wind_AddStrategy.isDisplayed();
	}
	
	public void enter_StrategyName(String name) {
		clearAndEnter(getDriver(), "//input[@name='name']", name);
	}
	
	/**
	 * wait 2 sec for the saving process
	 * @throws InterruptedException
	 */
	public void save_AddStrategy() throws InterruptedException {
		waitToBeClickableAndClick(getDriver(), saveBtn_AddStrategy, 3);
		Thread.sleep(2000);
	}
	public void selectADecisionTree(String dtStrategyName) {
		Utils.clickByXpath(getDriver(), "//div[starts-with(@id,'strategylist')]//div[contains(@class,'x-grid-cell-inner') and text()='"+dtStrategyName+"']");
	}

	public void checkIfStrategyExist(boolean expertPresent, String dtStrategyName) throws InterruptedException {
		String xpath = "//div[starts-with(@id,'strategylist')]//div[contains(@class,'x-grid-cell-inner') and text()='"+dtStrategyName+"']";
		if (expertPresent)
			org.junit.Assert.assertTrue(Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), xpath, true, false));
		else 
			org.junit.Assert.assertFalse(Utils.isElementDisplayed_clickIfNeeded(1000, getDriver(), xpath, false, false));
	}
	
	
}
