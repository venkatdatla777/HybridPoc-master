package flextesting.pagefactories.strategistportal.workflowmanager;

import com.qa.base.TestBase;
import flextesting.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static flextesting.utilities.Utils.*;

public class WorkflowCreationPanelFactory extends TestBase {

	// @FindBy(xpath="//button[@data-qtip='Add New Flow']")
	// private WebElement btn_Add;
	private String xpathBtnAdd = "//button[@data-qtip='Add New Flow']";
	private String xpathBtnAssignment = "//span[@id='AccessFlows-btnInnerEl']";
	private String xpathBtnAssignRoleAndUser = "//span[text()='Assign Role & User']";
	private String xpathNumberOfPages = "//div[starts-with(@id,'workflowaccessassignment')]//div[starts-with(@id,'gridpanel') and contains(@id,'body')]//tr";
	// div[starts-with(@id,'workflowaccessassignment')]//div[starts-with(@role,'presentation')]//div[starts-with(@id,'tbtext')][2]
	private String xpathArrowRightDouble = "//span[contains(@class,'arrow_right_double')]";
	private String xpathBtnSave = "//span[text()='Save']";
	private String xpathAssignUserRoleToStartFlow = "//div[contains(@class,'x-window x-message-box')]";
	private String xpathBtnOk = "//span[text()='OK']";

	@FindBy(xpath = "//button[@data-qtip='Edit Flow.']")
	private WebElement btn_Edit;

	@FindBy(xpath = "//button[@data-qtip='Delete Flow.']")
	private WebElement btn_Delete;

	@FindBy(xpath = "//div[contains(@id,'surveyflowedit')]//input[@name='name']")
	private WebElement field_Name;

	@FindBy(xpath = "//table[starts-with(@id,'workflowcriteriaeditor') and contains(@style,'fixed')]//textarea")
	private WebElement field_Criteria;

	@FindBy(xpath = "//div[starts-with(@id,'surveyflowedit')]//descendant::span[text()='Submit']//parent::button[1]")
	private WebElement btn_Submit;

	@FindBy(xpath = "//span[text()='Standard Financial Statement']")
	private WebElement btn_Standard_Financial_Statement;

	public void click_Add() throws InterruptedException {
		// btn_Add.click();
		Thread.sleep(999);
		clickByXpath(getDriver(), xpathBtnAdd);
	}

	public void enter_FlowName(String name) throws InterruptedException {
		Thread.sleep(1999);
		clearAndEnter(getDriver(), "//div[contains(@id,'surveyflowedit')]//input[@name='name']", name);
	}

	public void enter_EntryCriteria(String criteria) {
		clearAndEnter(getDriver(),
				"//table[starts-with(@id,'workflowcriteriaeditor') and contains(@style,'fixed')]//textarea", criteria);
	}

	public void enter_WorkFlowTitleForFlexsite(String title) {
		WebElement frameElm = getDriver().findElement(By.xpath("//iframe[starts-with(@id,'htmleditor')]"));
		getDriver().switchTo().frame(frameElm);
		clearAndEnter(getDriver(), "/html/body", title);
		getDriver().switchTo().defaultContent();
	}

	/**
	 * wait for 2 seconds for the new workflow to load
	 * 
	 * @throws InterruptedException
	 */
	public void click_Submit() throws InterruptedException {
		waitToBeClickableAndClick(getDriver(), btn_Submit, 2);
		Thread.sleep(2000);
	}

	public void present_workflow(String workflowName) throws InterruptedException {
		String xpath = "//div[starts-with(@id,'workflowlist')]//div[text()='" + workflowName + "']";
		isElementDisplayed_clickIfNeeded(500, getDriver(), xpath, true, false);
	}

	public void click_Assignment() throws InterruptedException {
		Thread.sleep(999);
		clickByXpath(getDriver(), xpathBtnAssignment);
	}

	public void click_AssignRoleAndUser() throws InterruptedException {
		Thread.sleep(999);
		clickByXpath(getDriver(), xpathBtnAssignRoleAndUser);
	}

	public void click_MoveAllLeftRowsToRightSide() throws InterruptedException {
		Thread.sleep(999);
		int len = getDriver().findElements(By.xpath(xpathNumberOfPages)).size();
		// String txt =
		// getDriver().findElement(By.xpath(xpathNumberOfPages)).getText();
		System.out.println("len :" + len);

		for (int i = 1; i <= len - 1; i++) {
			clickByXpath(getDriver(), xpathArrowRightDouble);
			Thread.sleep(499);
		}
	}

	public void click_Save() throws InterruptedException {
		Thread.sleep(999);
		clickByXpath(getDriver(), xpathBtnSave);
	}

	public void click_Ok() throws InterruptedException {
		Thread.sleep(999);
		clickByXpath(getDriver(), xpathBtnOk);
	}

	public String the_Roles_are_assigned_to_Workflow() throws Throwable {
		Thread.sleep(9999);
		String text = getDriver().findElement(By.xpath(xpathAssignUserRoleToStartFlow)).getText();
		return text;
	}

	public void i_bouble_click_on_Standard_Financial_Statement_in_Current_tab() throws Throwable {
		Thread.sleep(20000);
		Utils.doubleClickElement(getDriver(), btn_Standard_Financial_Statement);
		Thread.sleep(1500);
		clickByXpath(getDriver(), "//button[text()='Yes']");
		Thread.sleep(20000);
	}

	public void i_click_on_Type_of_Budget_dropDown_and_select_and_click_on_Start_button(String arg1) throws Throwable {
		clickByXpath(getDriver(), "(//label[contains(text(),'Type of Budget?')]//following::img)[1]");
		Thread.sleep(999);
		clickByXpath(getDriver(), "//div[text()='" + arg1 + "']");
		clickByXpath(getDriver(), "//button[text()='Start']");
		Thread.sleep(9999);
	}

	public void i_choose_one_option_form_Your_Accommodation_dropDown() throws Throwable {
		clickByXpath(getDriver(), "(//label[contains(text(),'Your Accommodation:​ ')]//following::img)[1]");
		Thread.sleep(999);
		clickByXpath(getDriver(), "//div[contains(text(),'Mortgage')]");
	}

	public void i_click_Full_time_checkbox_and_click_on_next_button() throws Throwable {
		String str = "12";
		clickByXpath(getDriver(), "//label[contains(text(),'Full-time')]");
		clickByXpath(getDriver(), "(//button[contains(text(),'Next')])[3]");
		Thread.sleep(9999);
		clickByXpath(getDriver(), "//label[contains(text(),'Full-time')]");
		Thread.sleep(9999);
		clickByXpath(getDriver(), "(//label[contains(text(),'Your Accommodation:​ ')]//following::img)[1]");
		Thread.sleep(999);
		clickByXpath(getDriver(), "//div[contains(text(),'Mortgage')]");
		Thread.sleep(999);
		clearAndEnter(getDriver(), "(//div[starts-with(@class,' x-column')]//input[contains(@id,'ext-comp')])[17]",
				str);
		clickByXpath(getDriver(), "(//button[contains(text(),'Next')])[3]");
		Thread.sleep(9999);
		clickByXpath(getDriver(), "//button[text()='Priority Debt']");
		Thread.sleep(9999);
	}

	public void i_click_on_close_button_and_then_close_window() throws Throwable {
		clickByXpath(getDriver(), "(//button[contains(text(),'Close')])[2]");
		Thread.sleep(9999);
		clickByXpath(getDriver(),
				"(//div[starts-with(@class,'x-window-tl')]//div[contains(@class,'x-tool-close')])[1]");
	}

	public void i_click_the_Disposition_icon_at_the_account_level() throws Throwable {
		clickByXpath(getDriver(), "//table[@id='dispositionMenuButton']//button[contains(@class,'disposition-btn')]");
		Thread.sleep(1500);
	}

	public void i_click_Payment_Made_radio_button_and_Submit_Close_Account_button() throws Throwable {
		clickByXpath(getDriver(), "//label[text()='Payment Made']");
		Thread.sleep(999);
		clickByXpath(getDriver(), "//button[text()='Submit & Close Account']");
		Thread.sleep(1500);
	}

}
