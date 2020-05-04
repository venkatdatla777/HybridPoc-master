package flextesting.pagefactories.strategistportal;

import com.qa.base.TestBase;
import flextesting.utilities.Utils;

public class DesktopFactory extends TestBase {

	public void click_UserAndRoleManager() {
		Utils.clickByXpath(getDriver(), "//div[@id='User & Role Manager-shortcut']/span");
	}

	public void click_DecisionTreeManager() {
		Utils.clickByXpath(getDriver(), "//div[@id='Decision Tree Manager-shortcut']/span");
	}

	public void click_DocumentManager() {
		Utils.clickByXpath(getDriver(), "//div[@id='Document Manager-shortcut']/span");
	}

	/**
	 * wait for 2 seconds for the current workflow to load
	 * 
	 * @throws InterruptedException
	 */
	public void click_WorkflowManager() throws InterruptedException {
		Utils.clickByXpath(getDriver(), "//div[@id='Workflow Manager-shortcut']/span");
		Thread.sleep(2000);
	}

	public void click_VariableManager() {
		Utils.clickByXpath(getDriver(), "//div[@id='Variable Manager-shortcut']");
	}

	public void click_TestManager() {
		Utils.clickByXpath(getDriver(), "//div[@id='Test Manager-shortcut']");
	}

	public void click_ConfigurationManager() {
		Utils.clickByXpath(getDriver(), "//div[@id='Configuration Manager-shortcut']");
	}
}
