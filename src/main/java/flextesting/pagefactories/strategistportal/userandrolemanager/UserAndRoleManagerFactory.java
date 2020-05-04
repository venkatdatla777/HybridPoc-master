package flextesting.pagefactories.strategistportal.userandrolemanager;

import com.qa.base.TestBase;
import flextesting.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static flextesting.utilities.Utils.*;
import static org.junit.Assert.assertTrue;

/**
 * @author Shiyi Chen
 *
 */
public class UserAndRoleManagerFactory extends TestBase {
	@FindBy(xpath="//div[@id='manageUser']//descendant::span[text()='Add User']")
	private WebElement btn_AddUser;
	
	@FindBy(xpath="//div[@id='manageUser']//descendant::span[text()='Edit User']")
	private WebElement btn_EditUser;
	
	@FindBy(xpath="//div[@id='manageUser']//descendant::span[text()='Lock User']")
	private WebElement btn_LockUser;
	
	@FindBy(xpath="//div[@id='manageUser']//descendant::span[text()='Disable User']")
	private WebElement btn_DisableUser;
	
	@FindBy(xpath="//div[@id='manageUser']//descendant::span[text()='Add User']")
	private WebElement element_AvailableRoles;

	@FindBy(name="username")
	private WebElement field_username;

	@FindBy(name="firstName")
	private WebElement field_FirstName;

	@FindBy(name="lastName")
	private WebElement field_LastName;

	@FindBy(name="password")
	private WebElement field_Password;

	@FindBy(name="confirmPassword")
	private WebElement field_ConfirmPassword;

	@FindBy(name="email")
	private WebElement field_Email;
	
	@FindBy(xpath="//div[starts-with(@id,'useredit')]//descendant::span[text()='Available Roles']//following::input[1]")
	private WebElement field_SearchAvailableRoles;
	
	@FindBy(xpath="//div[starts-with(@id,'useredit')]//descendant::span[text()='Available Roles']//following::div[contains(@class,'x-form-search-trigger')][1]")
	private WebElement btn_search_AvailableRoles;
	
	@FindBy(xpath="//div[starts-with(@id,'useredit')]//descendant::span[text()='Available Roles']//following::button[@data-qtip='Move the left selected row(s) to right side']")
	private WebElement btn_leftToRight_window_AddUser;
	
	@FindBy(xpath="(//span[contains(@class,'arrow_right')])[1]")
	private WebElement btn_moveTheLeftSelectedRowToRigth;

	@FindBy(xpath="//div[starts-with(@id,'useredit')]//descendant::span[text()='Save']//parent::button[1]")
	private WebElement saveBtn_AddUser;
	
	@FindBy(xpath="//div[text()='Add new user successfully']")
	private WebElement message_NewUserAdded;

	@FindBy(xpath="//div[text()='Add new user successfully']//following::span[text()='OK'][1]")
	private WebElement btn_OK_message_NewUserAdded;
	
	@FindBy(xpath="//input[starts-with(@id,'triggerfield')]")
	private WebElement field_searchUser;
	
	@FindBy(xpath="//div[text()='Edited user successfully.']//following::span[text()='OK'][1]")
	private WebElement btn_OK_message_EditUserSuccessfully;
	
	@FindBy(xpath="//div[text()='Disabled user successfully.']//following::span[text()='OK'][1]")
	private WebElement btn_OK_message_DisableUserSuccessfully;
	

	public void click_tab_ManageUsers() {
		waitToBeVisibleAndClick(getDriver(), "//span[text()='Manage Users']", 2);
	}
	
	public void click_AddUser() {
		waitToBeClickableAndClick(getDriver(), btn_AddUser, 5);
		//btn_AddUser.click();
	}

	public void window_AddUser() {
		//by checking if 'available roles' are loaded
		assertTrue(element_AvailableRoles.isDisplayed());
	}

	public void enter_LoginName(String loginname) {
		clearAndEnter(getDriver(), "//input[@name='username']", loginname);
	}

	public void enter_FirstName(String firstname) {
		clearAndEnter(getDriver(), "//input[@name='firstName']", firstname);
	}

	public void enter_LastName(String lastname) {
		clearAndEnter(getDriver(), "//input[@name='lastName']", lastname);
	}

	public void enter_Password(String password) {
		clearAndEnter(getDriver(), "//input[@name='password']", password);
	}

	public void enter_ConfirmPassword(String confirmPassword) {
		clearAndEnter(getDriver(), "//input[@name='confirmPassword']", confirmPassword);
	}

	public void enter_Email(String email) {
		clearAndEnter(getDriver(), "//input[@name='email']", email);
	}

	public void choose_DefaultStationView_UnifiedCollections() {
		Utils.clickByXpath(getDriver(), "//label[text()='FlexStation Landing View:']//following::div[@role='button'][1]");
		Utils.clickByXpath(getDriver(), "//li[contains(text(),'Unified Collections')]");
	}

	public void search_AvailableRoles(String role) {
		clearAndEnter(getDriver(), "//div[starts-with(@id,'useredit')]//descendant::span[text()='Available Roles']//following::input[1]", role);
		btn_search_AvailableRoles.click();
	}

	/**
	 * need to check a default role.
	 * @param role
	 */
	public void move_leftToRight(String role) {
		//locate the right search result
		WebElement roleFoundInAvailable = getDriver().findElement(By.xpath("//div[starts-with(@id,'useredit')]//descendant::span[text()='Available Roles']//following::div[contains(@class,'x-grid-cell-inner') and text()='" + role + "']"));
		roleFoundInAvailable.click();
		//click > button
		btn_leftToRight_window_AddUser.click();
	}
	
	public void click_btn_move_leftToRight(String role) {
		//locate the right search result
		WebElement roleFoundInAvailable = getDriver().findElement(By.xpath("//div[starts-with(@id,'useredit')]//descendant::span[text()='Available Roles']//following::div[contains(@class,'x-grid-cell-inner') and text()='CMC Admin']"));
		roleFoundInAvailable.click();
		//click > button
		btn_moveTheLeftSelectedRowToRigth.click();
	}

	public void check_AssignedRoles(String role) {
		WebElement roleFoundInAssigned = getDriver().findElement(By.xpath("//div[starts-with(@id,'useredit')]//descendant::span[contains(text(),'Assigned Roles')]//following::div[contains(@class,'x-grid-cell-inner') and text()='" + role + "']"));
		roleFoundInAssigned.click();
	}

	public void search_AssignedRoles(String role) {
		// TODO Auto-generated method stub
		
	}

	public void move_rightToLeft(String role) {
		WebElement roleInAssigned = getDriver().findElement(By.xpath("//div[starts-with(@id,'useredit')]//descendant::span[contains(text(),'Assigned Roles')]//following::div[contains(@class,'x-grid-cell-inner') and text()='" + role + "']"));
		doubleClickElement(getDriver(), roleInAssigned);
	}
	public void move_rightToLeft_FirstAssignedRoles() {
		doubleClickNInTable(getDriver(), "//div[starts-with(@id,'useredit')]//descendant::span[contains(text(),'Assigned Roles')]//following::div[contains(@class,'x-grid-cell-inner')]", 1);
	}

	/**
	 * no need to check a default role (when double clicking like following) 
	 */
	public void move_leftToRight_FirstAvailableRoles() {
		doubleClickNInTable(getDriver(), "//div[starts-with(@id,'useredit')]//descendant::span[text()='Available Roles']//following::tr[contains(@class,'x-grid-row')]", 1);
	}

	public void check_AssignedRoles_FirstOne() {
		clickByXpath(getDriver(), "//div[starts-with(@id,'useredit')]//descendant::span[contains(text(),'Assigned Roles')]//following::tr[contains(@class,'x-grid-row')]");
	}

	public void save_AddUser() {
		waitToBeClickableAndClick(getDriver(), saveBtn_AddUser, 3);
	}

	/**
	 * wait 1 sec for the saving process
	 * @throws InterruptedException
	 */
	public void message_NewUserAdded_OK() throws InterruptedException {
		clickByXpath(getDriver(), "//div[text()='Add new user successfully']//following::span[text()='OK'][1]");
	}

	public void search_User(String loginName) throws InterruptedException {
		clearAndEnter(getDriver(), "//input[starts-with(@id,'triggerfield')]", loginName);
		clickByXpath(getDriver(), "//div[contains(@class,'x-form-search-trigger')]");
		Thread.sleep(1000);
	}


	public boolean present_User(String loginName) throws InterruptedException {
		return isElementDisplayed_clickIfNeeded(500, getDriver(), "//div[contains(@class,'x-grid-cell-inner') and text()='"+loginName.toLowerCase()+"']", true, false);
	}


	public void select_User(String loginName) {
		clickByXpath(getDriver(), "//div[contains(@class,'x-grid-cell-inner') and text()='"+loginName.toLowerCase()+"']");
	}


	public void click_EditUser() {
		waitToBeClickableAndClick(getDriver(), btn_EditUser, 2);
	}


	public void message_EditUserSuccessfully_OK() {
		btn_OK_message_EditUserSuccessfully.click();
	}


	public void click_LockUser() {
		btn_LockUser.click();
	}


	public void confirmation_LockUser(String option) {
		clickByXpath(getDriver(), "//div[contains(text(),'Do you really want to lock user')]//following::span[text()='"+option+"'][1]");
	}


	public void present_UserGrayedOut(String loginName) throws InterruptedException {
		String xpath = "//div[contains(@class,'x-grid-cell-inner') and text()='"+loginName.toLowerCase()+"']//parent::td//parent::tr[contains(@class,'locked-row')]";
		isElementDisplayed_clickIfNeeded(500, getDriver(), xpath, true, false);
	}


	public void click_DisableUser() {
		btn_DisableUser.click();
	}


	public void confirmation_DisableUser(String option) {
		clickByXpath(getDriver(), "//div[contains(text(),'Do you really want to disable user')]//following::span[text()='"+option+"'][1]");
	}


	public void message_DisableUserSuccessfully_OK() {
		btn_OK_message_DisableUserSuccessfully.click();
	}


	public void present_UserTurnRed(String loginName) throws InterruptedException {
		String xpath = "//div[contains(@class,'x-grid-cell-inner') and text()='"+loginName.toLowerCase()+"']//parent::td//parent::tr[contains(@class,'error-row')]";
		isElementDisplayed_clickIfNeeded(500, getDriver(), xpath, true, false);
	}

	public void click_btn_MoveAllLeftRowsToRightSide() {
		clickByXpath(getDriver(), "//span[@class='x-btn-icon arrow_right_double']");
	}

}
