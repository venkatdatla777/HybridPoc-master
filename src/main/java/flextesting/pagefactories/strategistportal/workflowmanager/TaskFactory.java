package flextesting.pagefactories.strategistportal.workflowmanager;

import com.qa.base.TestBase;
import flextesting.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static flextesting.utilities.Utils.*;

/**
 * @author Shiyi Chen
 *
 */
public class TaskFactory extends TestBase {

	@FindBy(xpath = "//div[starts-with(@id,'tabbar')]//div[starts-with(@id,'tab')]//button//span[text()='Tasks']")
	private WebElement tab_TaskElements;

	@FindBy(xpath = "//div[starts-with(@id,'workflowrepository') and contains(@id,'-body')]//div[starts-with(@id,'buttongroup')]//span[text()='Add']//parent::button[1]")
	private WebElement btn_Add;

	@FindBy(xpath = "//div[starts-with(@id,'workflowrepository') and contains(@id,'-body')]//div[starts-with(@id,'buttongroup')]//span[text()='Edit']//parent::button[1]")
	private WebElement btn_Edit;

	@FindBy(xpath = "//div[starts-with(@id,'workflowrepository') and contains(@id,'-body')]//div[starts-with(@id,'buttongroup')]//span[text()='Delete']//parent::button[1]")
	private WebElement btn_Delete;

	@FindBy(xpath = "//div[starts-with(@id,'tasklist')]//div[starts-with(@id,'toolbar')]//table//input")
	private WebElement field_SearchTask;

	@FindBy(xpath = "//div[starts-with(@id,'tasklist')]//div[starts-with(@id,'toolbar')]//table//td//div[@role='button' and contains(@class,'search-trigger')]")
	private WebElement btn_Search;

	@FindBy(xpath = "//div[contains(@id,'taskedit')]//input[@name='name']")
	private WebElement field_TaskName;

	@FindBy(name = "surveyCode")
	private WebElement field_TaskCode;

	@FindBy(xpath = "//div[@data-qtip='Element -> Task']")
	private WebElement btn_ElementToTask;

	@FindBy(xpath = "//div[starts-with(@id,'taskedit')]//span[text()='Save as Draft']//parent::button")
	private WebElement btn_saveAsDraft;

	@FindBy(xpath = "//div[starts-with(@id,'taskedit')]//span[text()='Publish This Version']//parent::button")
	private WebElement btn_Publish;

	@FindBy(xpath = "//div[starts-with(@id,'messagebox')]//*[contains(text(),'This task was successfully saved')]//following::span[text()='OK'][1]")
	private WebElement btn_OK_messageWindow_TaskElementSaved;

	@FindBy(xpath = "//div[starts-with(@id,'messagebox')]//*[contains(text(),'This task has been published successfully')]//following::span[text()='OK'][1]")
	private WebElement btn_OK_messageWindow_TaskElementPublished;

	@FindBy(xpath = "//div[starts-with(@id,'taskelementassignment') and @class='x-window x-layer x-window-default']//button[@data-qtip='Delete element from current task.']")
	private WebElement btn_Delete_window_AssignedElements;

	@FindBy(xpath = "//span[text()='Delete task element from group']//following::span[text()='Yes']")
	private WebElement btn_Yes_confirmation_DeleteTaskElementFromGroup;

	@FindBy(xpath = "//span[text()='Remove this task']//following::span[text()='Yes']")
	private WebElement btn_Yes_confirmation_RemoveThisTask;
	
	@FindBy(xpath = "//label[starts-with(@id,'checkboxfield') and text()='Allow Cancel Workflow in Customer Portal']")
	private WebElement checkbox_AllowCancelWorkflowInCustomerPortal;
	
	@FindBy(xpath = "//label[starts-with(@id,'checkboxfield') and text()='Allow Cancel Workflow in Associate Portal']")
	private WebElement checkbox_AllowCancelWorkflowInAssociatePortal;
	@FindBy(xpath = "//div[starts-with(@id,'window')]//span[text()='OK']")
	private WebElement clickOK;

	/*
	 * @FindBy(xpath="") private WebElement ;
	 * 
	 */
	String xpath_field_search_window_ElementToTask = "//div[starts-with(@id,'assignelementlist')]//td[starts-with(@id,'triggerfield') and contains(@id,'-bodyEl')]//td[contains(@id,'inputCell')]//input";
	String xpath_btn_SearchTaskElementToAssgin = "//div[starts-with(@id,'assignelementlist')]//td[starts-with(@id,'triggerfield') and contains(@id,'-bodyEl')]//div[contains(@class,'search-trigger')]";
	String xpath_btn_OK_window_ElementToTask = "//div[starts-with(@id,'taskelementassignment')]//span[text()='OK']//parent::button[1]";
	String xpath_btn_saveAsDraft = "//div[starts-with(@id,'taskedit')]//span[text()='Save as Draft']//parent::button";
	String xpath_btn_Publish = "//div[starts-with(@id,'taskedit')]//span[text()='Publish This Version']//parent::button";

	private boolean taskCreated = false;

	/**
	 * wait 3.5 sec for the UI of task to load
	 * 
	 * @throws InterruptedException
	 */
	public void click_tab_Tasks() throws InterruptedException {
		tab_TaskElements.click();
		Thread.sleep(12000);
	}

	public void click_Add() throws InterruptedException {
		btn_Add.click();
		Thread.sleep(2500);
	}

	public void enter_TaskName(String taskName) {
		clearAndEnter(getDriver(), "//div[contains(@id,'taskedit')]//input[@name='name']", taskName);
	}

	public void enter_TaskCode(String taskCode) {
		clearAndEnter(getDriver(), "//input[@name='surveyCode']", taskCode);
	}

	public void click_Elements() throws InterruptedException {
		String xpath_btn_ElementToTask = "//div[@data-qtip='Element -> Task']";
		clickByXpath(getDriver(), xpath_btn_ElementToTask);
		Thread.sleep(2000);
	}

	/**
	 * wait 1.5 sec for the searching results
	 * 
	 * @param taskElementCode
	 * @throws InterruptedException
	 */
	public void search_taskElementByCode(String taskElementCode) throws InterruptedException {
		clearAndEnter(getDriver(), xpath_field_search_window_ElementToTask, taskElementCode);
		Thread.sleep(3000);// very occasionally, the search btn is not clicked,
							// so we wait 1 sec before clicking. (Not sure can
							// fix the problem)
		clickByXpath(getDriver(), xpath_btn_SearchTaskElementToAssgin);
		Thread.sleep(4500);
	}

	public void dragTaskElementAndDropToGroup(String taskElementCode, String groupName) {
		String xpath_taskElement = "//div[starts-with(@id,'assignelementlist')]//div[starts-with(@id,'gridpanel') and contains(@id,'body')]//td//div[text()='"
				+ taskElementCode + "']";
		String xpath_group = "//div[starts-with(@id,'taskassignedelementlist') and contains(@id,'body')]//div[contains(text(),'"
				+ groupName + "')]";
		// WebElement taskElement =
		// driver.findElement(By.xpath("//div[starts-with(@id,'assignelementlist')]//div[starts-with(@id,'gridpanel')
		// and contains(@id,'body')]//td//div[text()='"+taskElementCode+"']"));
		// WebElement group =
		// driver.findElement(By.xpath("//div[starts-with(@id,'taskassignedelementlist')
		// and contains(@id,'body')]//div[contains(text(),'"+groupName+"')]"));
		dragAndDrop(getDriver(), returnTheVisibleOne(getDriver(), xpath_taskElement),
				returnTheVisibleOne(getDriver(), xpath_group));
	}

	public void dragTaskElementAndDropToGroup(int nthTask, String groupName) {
		// String xpath_nthTaskElement =
		// "(//div[starts-with(@id,'assignelementlist')]//tr[contains(@class,'x-grid-row')]//td//div)["+nthTask+"]";
		String xpath_nthTaskElement = "//div[starts-with(@id,'assignelementlist')]//tr[contains(@class,'x-grid-row')]//td//div";
		String xpath_group = "//div[starts-with(@id,'taskassignedelementlist') and contains(@id,'body')]//div[contains(text(),'"
				+ groupName + "')]";
		dragAndDrop(getDriver(), returnTheVisibleOne(getDriver(), xpath_nthTaskElement),
				returnTheVisibleOne(getDriver(), xpath_group));
	}

	/**
	 * wait 1 sec for the elementToTask window disappear
	 * 
	 * @throws InterruptedException
	 */
	public void click_OK_window_ElementToTask() throws InterruptedException {
		waitToBeClickableAndClick(getDriver(), returnTheVisibleOne(getDriver(), xpath_btn_OK_window_ElementToTask), 2);
		// Thread.sleep(1000);
	}

	public void click_SaveAsDraft() {
		waitToBeClickableAndClick(getDriver(), returnTheVisibleOne(getDriver(), xpath_btn_saveAsDraft), 2);
	}

	/**
	 * wait 1 sec for the message to appear
	 * 
	 * @throws InterruptedException
	 */
	public void message_TaskSaved_OK() throws InterruptedException {
		Thread.sleep(2000);
		btn_OK_messageWindow_TaskElementSaved.click();
		setTaskCreated(true);
	}

	public void click_Publish() {
		waitToBeClickableAndClick(getDriver(), returnTheVisibleOne(getDriver(), xpath_btn_Publish), 2);
	}

	/**
	 * wait 1 sec for the message to appear wait 1.5 sec for creating the task
	 * 
	 * @throws InterruptedException
	 */
	public void message_TaskPublished_OK() throws InterruptedException {
		Thread.sleep(1000);
		btn_OK_messageWindow_TaskElementPublished.click();
		Thread.sleep(1500);
	}

	public boolean isTaskCreated() {
		return taskCreated;
	}

	public void setTaskCreated(boolean taskCreated) {
		this.taskCreated = taskCreated;
	}

	/**
	 * wait 1.5 sec for the search result to load
	 * 
	 * @param taskCode
	 * @return
	 * @throws InterruptedException
	 */
	public WebElement search_TaskByCode(String taskCode) throws InterruptedException {
		clearAndEnter(getDriver(), "//div[starts-with(@id,'tasklist')]//div[starts-with(@id,'toolbar')]//table//input",
				taskCode);
		System.out.println("taskCode : " + taskCode);
		btn_Search.click();
		Thread.sleep(1500);
		return selectTaskByCode(taskCode);
	}

	public void present_Task(String taskCode) throws InterruptedException {
		String taskXpath = "//div[starts-with(@id,'tasklist') and contains(@id,'body')]//div[contains(@class,'x-grid-cell-inner') and text()='"
				+ taskCode + "']";
		isElementDisplayed_clickIfNeeded(500, getDriver(), taskXpath, true, false);
	}

	private WebElement selectTaskByCode(String taskCode) {
		System.out.println("taskCode : " + taskCode);
		By taskLocator = By
				.xpath("//div[starts-with(@id,'tasklist') and contains(@id,'body')]//div[contains(@class,'x-grid-cell-inner') and text()='"
						+ taskCode + "']//ancestor::tr");
		System.out.println("taskLocator : " + taskLocator);
		return getDriver().findElement(taskLocator);
	}

	public void choose_TaskByCode(String taskCode) {
		selectTaskByCode(taskCode).click();
	}

	public void click_Edit() {
		btn_Edit.click();
	}

	public void choose_TaskElementByCode_window_AssignedElements(String taskElementCode) {
		clickByXpath(getDriver(),
				"//div[starts-with(@id,'taskassignedelementlist')]//div[contains(text(),'" + taskElementCode + "')]");
	}

	public void click_Delete_window_AssignedElements() {
		waitToBeClickableAndClick(getDriver(), btn_Delete_window_AssignedElements, 1);
	}

	public void confirmation_DeleteTaskElementFromGourp_Yes() {
		btn_Yes_confirmation_DeleteTaskElementFromGroup.click();
	}

	/**
	 * wait 1.5 sec for the deleting process
	 * 
	 * @throws InterruptedException
	 */
	public void click_Delete() throws InterruptedException {
		btn_Delete.click();
		btn_Yes_confirmation_RemoveThisTask.click();
		setTaskCreated(false);
		Thread.sleep(1500);
	}

	public void enter_IntroductionForFlexStation(String string) throws InterruptedException {
		enterIntroduction("Associate Portal", string);
	}

	public void enter_IntroductionForFlexSite(String string) throws InterruptedException {
		enterIntroduction("Customer Portal", string);
	}

	private void enterIntroduction(String location, String text) throws InterruptedException {
		Utils.clickByXpath(getDriver(), "//label[text()='Introduction for " + location + ":']//following::button[1]");
		WebElement iframeTextEditor = getDriver()
				.findElement(By.xpath("//span[text()='Introduction for " + location + "']//following::iframe"));
		iframeTextEditor.sendKeys(text);
		iframeTextEditor.click();
		Thread.sleep(500);
		Utils.clickByXpath(getDriver(), "//span[text()='Confirm']");
	}
	
	public void enter_Description(String description) throws InterruptedException {
//		WebElement elm = Utils.returnTheVisibleOne(getDriver(), "//div[contains(@id,'taskedit')]//input[@name='description']");
//		elm.sendKeys(description);
		clearAndEnter(getDriver(), "//div[contains(@id,'taskedit')]//input[@name='description']", description);
	}
	
	public void click_checkbox_IsThisACustomerInvolvedTask() {
		Utils.returnTheVisibleOne(getDriver(), "//label[text()='Is this a Customer Involved Task? (If checked this task will appear as a \"Survey\" in reporting)']").click();
	}
	
	public void click_checkbox_MakeTaskAnEndPage() {
		Utils.returnTheVisibleOne(getDriver(), "//label[text()='Make task an \"End Page\"']").click();
	}
	
	public void enterIntroductionForFlexStation(String text1) throws InterruptedException {
		System.out.println("text1 : " + text1);
		Utils.clickByXpath(getDriver(), "//label[text()='Introduction for Associate Portal:']//following::button[1]");
		WebElement elm = Utils.returnTheVisibleOne(getDriver(), "//label[text()='Introduction for Associate Portal:']//following::iframe");
		getDriver().switchTo().frame(elm);
		clearAndEnter(getDriver(), "/html/body", text1);
		clickByXpath(getDriver(), "/html/body");
		getDriver().switchTo().defaultContent();
//		elm.sendKeys(string);
//		elm.click();
//		WebElement iframeTextEditor = getDriver()
//				.findElement(By.xpath("//label[text()='Introduction for FlexStation:']//following::iframe"));
//		iframeTextEditor.sendKeys(string);
//		elm.click();
		Thread.sleep(500);
		Utils.clickByXpath(getDriver(), "//span[text()='Confirm']");
		Thread.sleep(1500);
}
	public void enterIntroductionForFlexSite(String text2) throws InterruptedException {
		System.out.println("text1 : " + text2);
		Utils.clickByXpath(getDriver(), "//label[text()='Introduction for Customer Portal:']//following::button[1]");
		WebElement elm = Utils.returnTheVisibleOne(getDriver(), "//label[text()='Introduction for Customer Portal:']//following::iframe");getDriver().switchTo().frame(elm);
		clearAndEnter(getDriver(), "/html/body", text2);
		clickByXpath(getDriver(), "/html/body");
		getDriver().switchTo().defaultContent();
//		elm.sendKeys(string);
//		elm.click();
//		WebElement iframeTextEditor = getDriver()
//				.findElement(By.xpath("//label[text()='Introduction for FlexSite:']//following::iframe"));
//		iframeTextEditor.sendKeys(string);
//		elm.click();
		Thread.sleep(500);
		Utils.clickByXpath(getDriver(), "//span[text()='Confirm']");
		Thread.sleep(2500);
      }

	public void click_checkbox_ShowPostscriptForFlexStation() throws InterruptedException {
		Thread.sleep(2000);
		Utils.returnTheVisibleOne(getDriver(), "//label[text()='Show Postscript for Associate Portal']").click();
		Thread.sleep(500);
	}
	
	public void click_checkbox_ShowPrintButtonInFlexStation() throws InterruptedException {
		Thread.sleep(2000);
		Utils.returnTheVisibleOne(getDriver(), "//label[text()='Show \"Print\" Button in Associate Portal']").click();
		Thread.sleep(500);
	}
	
	public void click_checkbox_ShowPostscriptForFlexSite() throws InterruptedException {
		Thread.sleep(2000);
		Utils.returnTheVisibleOne(getDriver(), "//label[text()='Show Postscript for Customer Portal']").click();
		Thread.sleep(500);
	}
	
	public void click_checkbox_ShowPrintButtonInFlexSite() throws InterruptedException {
		Thread.sleep(2000);
		Utils.returnTheVisibleOne(getDriver(), "//label[text()='Show \"Print\" Button in Customer Portal']").click();
		Thread.sleep(500);
	}
	
	public void click_checkbox_ShowConfirmButton() throws InterruptedException {
		Thread.sleep(2000);
		Utils.returnTheVisibleOne(getDriver(), "//label[text()='Show \"Confirm\" Button']").click();
		Thread.sleep(500);
	}
	
	public void enter_SubmitButtonText(String submitButtonText) throws InterruptedException {
		clearAndEnter(getDriver(), "//div[contains(@id,'taskedit')]//input[@name='submitButtonText']", submitButtonText);
		Thread.sleep(1000);
	}
	
	public void choose_BtnAlignmentMode(String btnAlignmentMode) throws InterruptedException {
		Utils.returnTheVisibleOne(getDriver(), "//div[contains(@id,'taskedit')]//input[@name='btnAlignmentMode']").click();
		Utils.returnTheVisibleOne(getDriver(), "//li[contains(@class,'x-boundlist-item') and text()='" + btnAlignmentMode + "']").click();
		Thread.sleep(1000);
	}
	
	public void dragTaskElementsAndDropToGroup(String taskElementCode, String groupName) {
		String xpath_taskElement = "//div[starts-with(@id,'assignelementlist')]//div[starts-with(@id,'gridpanel') and contains(@id,'body')]//tr";
//		String xpath_group = "//div[starts-with(@id,'taskassignedelementlist') and contains(@id,'body')]//div[contains(text(),'"
//				+ groupName + "')]";
		String xpath_group = "//div[starts-with(@id,'taskassignedelementlist') and contains(@id,'body')]//tr//td//div";
		int len =  getDriver().findElements(By.xpath(xpath_taskElement)).size();
		System.out.println("len :" + len);
		for(int i = 1; i <= len-1; i++) {
			dragAndDrop(getDriver(), getDriver().findElements(By.xpath(xpath_taskElement)).get(i),
					returnTheVisibleOne(getDriver(), xpath_group));
			
		}
		
	}
	
	public WebElement search_TaskByTaskCode(String taskCode) throws InterruptedException {
		clearAndEnter(getDriver(), "//div[starts-with(@id,'tasklist')]//div[starts-with(@id,'toolbar')]//table//input",
				taskCode);
		Thread.sleep(2000);
		btn_Search.click();
		Thread.sleep(2000);
		return selectTaskByTaskCode(taskCode);
	}

	public void present_TaskCode(String taskCode) throws InterruptedException {
		String taskXpath = "//div[starts-with(@id,'tasklist') and contains(@id,'body')]//div[contains(@class,'x-grid-cell-inner') and text()='"
				+ taskCode + "']";
		isElementDisplayed_clickIfNeeded(500, getDriver(), taskXpath, true, false);
	}

	private WebElement selectTaskByTaskCode(String taskCode) {
		By taskLocator = By
				.xpath("//div[starts-with(@id,'tasklist') and contains(@id,'body')]//div[contains(@class,'x-grid-cell-inner') and text()='"
						+ taskCode + "']//ancestor::tr");
		return getDriver().findElement(taskLocator);
	}
	
	public void click_checkbox_AllowCancelWorkflowInCustomerPortal() throws InterruptedException {
		checkbox_AllowCancelWorkflowInCustomerPortal.click();
		Thread.sleep(5000);
	}
	
	public void click_checkbox_AllowCancelWorkflowInAssociatePortal() throws InterruptedException {
		checkbox_AllowCancelWorkflowInAssociatePortal.click();
		Thread.sleep(5000);
	}
	
	public void addGroup(String groupName) throws InterruptedException {
		System.out.println("groupName :" + groupName);
		String isGroupPresent = getDriver().findElement(By.xpath("//div[starts-with(@id,'taskassignedelementlist') and contains(@id,'body')]//table")).getText();
		if(!isGroupPresent.contains(groupName)) {
			System.out.println("groupName :" + groupName);
			Thread.sleep(999);
			Utils.clickByXpath(getDriver(), "//span[text()='Add Group']");
			Thread.sleep(999);
			Utils.clickByXpath(getDriver(), "//textarea[@name='groupHeader']");
//			clearAndEnter(getDriver(), "//textarea[@name='groupHeader']", groupName);
			Utils.clearAndEnter(getDriver(), "//textarea[@name='groupHeader']", groupName);
			Utils.clickByXpath(getDriver(), "//textarea[@name='groupHeader']");
			Thread.sleep(2000);
			Utils.clickByXpath(getDriver(), "//div[starts-with(@id,'window')]//span[text()='OK']");
//			clickOK.click();
//			try {
//				Utils.clickByXpath(getDriver(), "//div[starts-with(@id,'window')]//span[text()='OK']");
//			} catch (NoSuchElementException ex) {
//				
//			}
			Thread.sleep(3000);
		}
	}


}

