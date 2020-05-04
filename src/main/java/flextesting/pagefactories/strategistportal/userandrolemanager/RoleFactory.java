package flextesting.pagefactories.strategistportal.userandrolemanager;

import com.qa.base.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import static flextesting.utilities.Utils.*;

public class RoleFactory extends TestBase {
	private boolean isRoleCreated = false;

	public boolean isRoleCreated() {
		return isRoleCreated;
	}
	public void setRoleCreated(boolean isRoleCreated) {
		this.isRoleCreated = isRoleCreated;
	}
	/**
	 * wait 2 sec for all UIs under this tab to load
	 * @throws InterruptedException
	 */
	public void click_tab_ManageRoles() throws InterruptedException {
		waitToBeVisibleAndClick(getDriver(), "//span[text()='Manage Roles']", 2);
		Thread.sleep(2000);
	}
	public void click_AddRole() {
		waitToBeClickableAndClick(getDriver(), "//div[@id='manageUser']//descendant::span[text()='Add Role']", 3);
	}
	public void choose_AddPermissionRole() {
		clickByXpath(getDriver(), "//span[text()='Add Permission Role']");
	}
	public void enter_RoleName(String name) {
		clearAndEnter(getDriver(), "//input[@name='name']", name);
	}
	public void enter_RoleDescription(String description) {
		clearAndEnter(getDriver(), "//input[@name='description']", description);
	}
	public void assignFirstAvailableContext() {
		String xpath = "(//div[@id='permissionRoleEdit-body']//fieldset[2]//table[contains(@class,'x-grid-table')])[1]//tr[contains(@class,'x-grid-row')]";
		doubleClickNInTable(getDriver(), xpath, 1);
	}
	public void assignFirstAvailableFeature() {
		String xpath = "(//div[@id='permissionRoleEdit-body']//fieldset[3]//table[contains(@class,'x-grid-table')])[1]//tr[contains(@class,'x-grid-row')]";
		doubleClickNInTable(getDriver(), xpath, 1);
	}
	public void assignFirstAvailablePortfolio() {
		String xpath = "(//div[@id='permissionRoleEdit-body']//fieldset[4]//table[contains(@class,'x-grid-table')])[1]//tr[contains(@class,'x-grid-row')]";
		doubleClickNInTable(getDriver(), xpath, 1);
	}
	/**
	 * wait 1 sec for the saving process and the message window to appear 
	 * @throws InterruptedException
	 */
	public void click_Save() throws InterruptedException {
		waitToBeClickableAndClick(getDriver(), "//span[text()='Save']//parent::button", 2);
		setRoleCreated(true);
		Thread.sleep(1000);
	}
	public void click_OK_AddNewRoleSuccessfully() {
		clickByXpath(getDriver(), "//div[text()='Add new role successfully']//following::span[text()='OK']");
	}
	public void click_OK_UpdateRoleSuccessfully() {
		clickByXpath(getDriver(), "//div[text()='Update role successfully']//following::span[text()='OK']");
	}
	/**
	 * wait 1 sec for the searching process 
	 * @param name
	 * @throws InterruptedException
	 */
	public void search_RoleByName(String name) throws InterruptedException {
		clearAndEnter(getDriver(), "//input[starts-with(@id,'triggerfield')]", name);
		clickByXpath(getDriver(), "//div[contains(@class,'x-form-search-trigger')]");
		Thread.sleep(1000);
	}
	public void present_RoleByName(String name) {
		getDriver().findElement(By.xpath("//div[contains(@class,'x-grid-cell-inner') and text()='"+name+"']"));
	}
	public void select_RoleByName(String name) {
		clickByXpath(getDriver(), "//div[contains(@class,'x-grid-cell-inner') and text()='"+name+"']");
	}
	public void click_EditRole() {
		waitToBeClickableAndClick(getDriver(), "//div[@id='manageUser']//descendant::span[text()='Edit Role']", 2);
	}
	public void click_RemoveRole() {
		waitToBeClickableAndClick(getDriver(), "//div[@id='manageUser']//descendant::span[text()='Remove Role']", 2);
	}
	public void notPresent_RoleByName(String name) throws InterruptedException {
		Assert.assertFalse(isElementDisplayed_clickIfNeeded(1000, getDriver(), "//div[contains(@class,'x-grid-cell-inner') and text()='"+name+"']", false, false));
	}
	public void click_Yes_confirm_RemoveRole() throws InterruptedException {
		clickByXpath(getDriver(), "//div[contains(text(),'Are you sure you want to remove this ')]//following::span[text()='Yes']");
		//if the role is tied to something, then the following confirmation window will show up
		clickInCaseElementIsPresent(getDriver(), By.xpath("//div[contains(text(),'This role is tied to a user')]//following::span[text()='Yes']"));
		setRoleCreated(false);
	}


}
