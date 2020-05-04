package flextesting.pagefactories.strategistportal.workflowmanager;

import com.qa.base.TestBase;
import flextesting.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static flextesting.utilities.Utils.*;

public class TaskElementFactory extends TestBase {
	@FindBy(xpath = "//div[starts-with(@id,'tabbar')]//div[starts-with(@id,'tab')]//button//span[text()='Task Elements']")
	private WebElement tab_TaskElements;

	@FindBy(xpath = "//div[starts-with(@id,'workflowrepository') and contains(@id,'-body')]//div[starts-with(@id,'elementlist')]//div[starts-with(@id,'buttongroup')]//span[text()='Add']//parent::button[1]")
	private WebElement btn_Add;

	@FindBy(xpath = "//div[starts-with(@id,'workflowrepository') and contains(@id,'-body')]//div[starts-with(@id,'elementlist')]//div[starts-with(@id,'buttongroup')]//span[text()='Delete']//parent::button[1]")
	private WebElement btn_Delete;

	@FindBy(xpath = "//div[starts-with(@id,'elementlist')]//div[starts-with(@id,'toolbar')]//table//input")
	private WebElement field_SearchTaskElement;

	@FindBy(xpath = "//div[starts-with(@id,'elementlist')]//div[starts-with(@id,'toolbar')]//table//td//div[@role='button' and contains(@class,'search-trigger')]")
	private WebElement btn_Search;
	private String xpathBtnSearch = "//div[starts-with(@id,'elementlist')]//div[starts-with(@id,'toolbar')]//table//td//div[@role='button' and contains(@class,'search-trigger')]";

	@FindBy(xpath = "//div[starts-with(@id,'elementlist')]//div[starts-with(@id,'toolbar')]//table//td//div[@role='button' and contains(@class,'clear-trigger')]")
	private WebElement field_ClearSearch;

	@FindBy(name = "questionCode")
	private WebElement field_ElementCode;

	@FindBy(xpath = "//div[contains(@id,'elementedit')]//input[@name='name']")
	private WebElement field_VariableName;

	@FindBy(xpath = "//div[starts-with(@id,'elementedit')]//label[text()='Data Type:']//following::div[@role='button'][1]")
	private WebElement dropdown_DataType;

	@FindBy(xpath = "(//iframe[starts-with(@id,'htmleditor')])[1]")
	private WebElement field_Text1;

	@FindBy(xpath = "//div[starts-with(@id,'elementedit')]//label[text()='Layout:']//following::div[@role='button'][1]")
	private WebElement dropdown_Layout;

	@FindBy(xpath = "//div[starts-with(@id,'elementedit')]//label[text()='Answer Type:']//following::div[@role='button'][1]")
	private WebElement dropdown_AnswerType;

	@FindBy(xpath = "//div[starts-with(@id,'elementedit')]//span[text()='Save as Draft']//parent::button")
	private WebElement btn_saveAsDraft;

	@FindBy(xpath = "//div[starts-with(@id,'elementedit')]//span[text()='Publish This Version']//parent::button")
	private WebElement btn_Publish;

	@FindBy(xpath = "//div[starts-with(@id,'messagebox')]//div[contains(text(),'This task element was successfully saved')]//following::span[text()='OK']")
	private WebElement btn_OK_messageWindow_TaskElementSaved;

	@FindBy(xpath = "//div[starts-with(@id,'messagebox')]//div[contains(text(),'This task element has been published successfully')]//following::span[text()='OK']")
	private WebElement btn_OK_messageWindow_TaskElementPublished;

	/**
	 * this element can NOT be uniquely identified, thus can NOT use
	 * waitToBeVisible method
	 */
	@FindBy(xpath = "//div[contains(@id,'boundlist')]//following::div[@class='x-css-shadow' and contains(@style,'display: block')][1]")
	private WebElement element_messageWindow_displayBlock;

	@FindBy(xpath = "//span[text()='Delete Task Element']//following::span[text()='Yes']")
	private WebElement btn_Yes_confirmation_DeleteTaskElement;
	
	@FindBy(xpath = "//label[text()='Allow Audit']")
	private WebElement checkbox_AllowEdit;

	/*
	 * @FindBy(xpath="") private WebElement ;
	 * 
	 */

	private boolean taskElementCreated = false;

	/**
	 * wait 1.5 second for the UI of take element to load
	 * 
	 * @throws InterruptedException
	 */
	public void click_tab_TaskElements() throws InterruptedException {
		clickByXpath(getDriver(),
				"//div[starts-with(@id,'tabbar')]//div[starts-with(@id,'tab')]//button//span[text()='Task Elements']");
		// tab_TaskElements.click();
		Thread.sleep(5000);
	}

	public void click_Add() throws InterruptedException {
		Thread.sleep(3000);
		btn_Add.click();
	}

	public void enter_ElementCode(String elementCode) {
		clearAndEnter(getDriver(), "//input[@name='questionCode']", elementCode);
	}

	public void enter_VariableName(String variableName) {
		clearAndEnter(getDriver(), "//div[contains(@id,'elementedit')]//input[@name='name']", variableName);
	}

	public void choose_DataType(String dataType) throws InterruptedException {
//		dropdown_DataType.click();
		Utils.clickByXpath(getDriver(), "//div[starts-with(@id,'elementedit')]//label[text()='Data Type:']//following::div[@role='button'][1]");
		Utils.clickByXpath(getDriver(),"//li[contains(@class,'x-boundlist-item') and text()='" + dataType + "']");
	}

	public void enter_Text1(String text1) throws InterruptedException {
//		 enter(field_Text1, text1);
//		field_Text1.sendKeys(text1);
//		clearAndEnter(getDriver(), "", text1);
		WebElement elm = Utils.returnTheVisibleOne(getDriver(), "//iframe[starts-with(@id,'htmleditor')]");
		elm.sendKeys(text1);
	}

	public void choose_Layout(String layout) {
//		dropdown_Layout.click();
		Utils.returnTheVisibleOne(getDriver(), "//div[starts-with(@id,'elementedit')]//label[text()='Layout:']//following::div[@role='button'][1]").click();
		Utils.returnTheVisibleOne(getDriver(), "//li[contains(@class,'x-boundlist-item') and text()='" + layout + "']").click();
		// Thread.sleep(1000);
	}

	public void choose_AnswerType(String answerType) {
//		dropdown_AnswerType.click();
//		getDriver().findElement(By.xpath("//li[contains(@class,'x-boundlist-item') and text()='" + answerType + "']"))
//				.click();
		Utils.returnTheVisibleOne(getDriver(), "//div[starts-with(@id,'elementedit')]//label[text()='Answer Type:']//following::div[@role='button'][1]").click();
		Utils.returnTheVisibleOne(getDriver(), "//li[contains(@class,'x-boundlist-item') and text()='" + answerType + "']").click();
	}

	public void click_SaveAsDraft() throws InterruptedException {
		try {
			waitToBeClickableAndClick(getDriver(), btn_saveAsDraft, 2);
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			Utils.returnTheVisibleOne(getDriver(), "//div[starts-with(@id,'elementedit')]//span[text()='Save as Draft']//parent::button").click();
		}
		Thread.sleep(1000);
	}

	/**
	 * wait 1 second for the message window to show
	 * 
	 * @throws InterruptedException
	 */
	public void message_TaskElementSaved_OK() throws InterruptedException {
		// waitToBeVisible(driver, element_messageWindow_displayBlock, 2);
		By overwriteOldTaskElementMsg = By
				.xpath("//span[text()='Override Task Element']//following::span[text()='OK']");
		clickInCaseElementIsPresent(getDriver(), overwriteOldTaskElementMsg);
		Thread.sleep(1000);
//		btn_OK_messageWindow_TaskElementSaved.click();
//		WebElement elem = Utils.returnTheVisibleOne(getDriver(), "//div[starts-with(@id,'messagebox')]//div[contains(text(),'This task element was successfully saved')]//following::span[text()='OK']");
//		elem.click();
		clickByXpath(getDriver(), "//div[starts-with(@id,'messagebox')]//div[contains(text(),'This task element was successfully saved')]//following::span[text()='OK']");
		setTaskElementCreated(true);
	}

	public void click_PublishThisVersion() {
//		waitToBeClickableAndClick(getDriver(), btn_Publish, 2);
		Utils.returnTheVisibleOne(getDriver(), "//div[starts-with(@id,'elementedit')]//span[text()='Publish This Version']//parent::button").click();
	}

	/**
	 * wait 1 second for the message window to show wait 2 seconds for the newly
	 * created task element to load
	 * 
	 * @throws InterruptedException
	 */
	public void message_TaskElementPublished_OK() throws InterruptedException {
		// waitToBeVisible(driver, element_messageWindow_displayBlock, 2);
		Thread.sleep(1000);
//		btn_OK_messageWindow_TaskElementPublished.click();
		Utils.returnTheVisibleOne(getDriver(), "//div[starts-with(@id,'messagebox')]//div[contains(text(),'This task element has been published successfully')]//following::span[text()='OK']").click();
		Thread.sleep(1500);
	}

	/**
	 * wait 1.5 for the searching process
	 * 
	 * @param elementCode
	 * @throws InterruptedException
	 */
	public void search_TaskElementByCode(String elementCode) throws InterruptedException {
		clearAndEnter(getDriver(),
				"//div[starts-with(@id,'elementlist')]//div[starts-with(@id,'toolbar')]//table//input", elementCode);
		clickByXpath(getDriver(), xpathBtnSearch);
		// btn_Search.click();
		Thread.sleep(1500);
	}

	public void present_TaskElement(String elementCode) throws InterruptedException {
		String xpath = "//div[starts-with(@id,'elementlist')]//div[starts-with(@id,'gridpanel') and contains(@id,'-body')]//table//td//div[text()='"
				+ elementCode + "']";
		isElementDisplayed_clickIfNeeded(500, getDriver(), xpath, true, false);
	}

	public boolean isTaskElementCreated() {
		return taskElementCreated;
	}

	public void setTaskElementCreated(boolean taskElementCreated) {
		this.taskElementCreated = taskElementCreated;
	}

	private WebElement selectTaskElementByCode(String taskElementCode) {
		By taskLocator = By
				.xpath("//div[starts-with(@id,'elementlist') and contains(@id,'body')]//div[contains(@class,'x-grid-cell-inner') and text()='"
						+ taskElementCode + "']//ancestor::tr");
		return getDriver().findElement(taskLocator);
	}

	public void choose_TaskElementByCode(String elementCode) {
		selectTaskElementByCode(elementCode).click();
	}

	public void click_Delete() {
		btn_Delete.click();
	}

	/**
	 * wait 1.5 for the deleting process
	 * 
	 * @throws InterruptedException
	 */
	public void confirmation_DeleteTaskElement_Yes() throws InterruptedException {
		btn_Yes_confirmation_DeleteTaskElement.click();
		setTaskElementCreated(false);
		Thread.sleep(1500);
	}
	
	public void click_checkbox_AllowEdit() {
//		checkbox_AllowEdit.click();
		Utils.returnTheVisibleOne(getDriver(), "//label[text()='Allow Audit']").click();
	}
	
	@FindBy(xpath = "(//div[starts-with(@id,'elementedit')]//span[contains(@class,'table-add')])[1]")
	private WebElement edit_AnswerOtion;

	public void click_edit_AnswerOtion() {
		// TODO Auto-generated method stub
//		edit_AnswerOtion.click();		
//		Utils.returnTheVisibleOne(getDriver(), "(//div[starts-with(@id,'elementedit')]//span[contains(@class,'table-add')])[1]").click();
		Utils.returnTheVisibleOne(getDriver(), "//div[starts-with(@id,'elementedit')]//span[contains(@class,'table-add')]").click();
	}
	
	@FindBy(xpath = "//span[starts-with(@id,'button')and text()='Add Answer Option']")
	private WebElement btn_AddAnswerOption;
	
	@FindBy(xpath = "//span[text()='Save & Close']")
	private WebElement btn_SaveClose;
	
	public void addAnswerOptions(String ...options) throws InterruptedException {
		// TODO Auto-generated method stub
		for(String option: options) {
			btn_AddAnswerOption.click();
			WebElement elm= Utils.returnTheVisibleOne(getDriver(), "//tr[contains(@class,'x-grid-row-selected')]/td[2]/div[contains(@data-errorqtip,'<ul><li>Please input the display text</li></ul>')]");
			Actions actions = new Actions(getDriver());
			actions.moveToElement(elm).doubleClick().build().perform();
			Thread.sleep(499);
			actions.sendKeys(option).build().perform();
			Thread.sleep(999);
		}
	}
	
	public void click_edit_btn_SaveClose() {
		// TODO Auto-generated method stub
//		btn_SaveClose.click();		
		Utils.returnTheVisibleOne(getDriver(), "//span[text()='Save & Close']").click();
		try {
			Utils.returnTheVisibleOne(getDriver(), "//span[text()='Save & Close']").click();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Message : " + e.getMessage());
		}
	}
	
	public void enter_Text2(String text2) throws InterruptedException {
		int len = getDriver().findElements(By.xpath("//iframe[contains(@id,'htmleditor')]")).size()-1;
		WebElement elm = getDriver().findElements(By.xpath("//iframe[contains(@id,'htmleditor')]")).get(len);
		getDriver().switchTo().frame(elm);
		clearAndEnter(getDriver(), "/html/body", text2);
		getDriver().switchTo().defaultContent();
//		elm.sendKeys(text2);                                    
	}
	
	public void click_Italic_Icon() throws InterruptedException {
		int len = getDriver().findElements(By.xpath("//iframe[contains(@id,'htmleditor')]")).size()-1;
		WebElement frameElm = getDriver().findElements(By.xpath("//iframe[contains(@id,'htmleditor')]")).get(len);
		getDriver().switchTo().frame(frameElm);
		clickByXpath(getDriver(), "/html/body");
		getDriver().switchTo().defaultContent();
		int Len = getDriver().findElements(By.xpath("//div[starts-with(@id,'htmleditor')]//span[contains(@class,'x-edit-italic')]")).size()-1;
		WebElement ItcElm = getDriver().findElements(By.xpath("//div[starts-with(@id,'htmleditor')]//span[contains(@class,'x-edit-italic')]")).get(Len);
		ItcElm.click();
		Thread.sleep(2000);
//		clickByXpath(getDriver(), "//div[starts-with(@id,'htmleditor')]//span[contains(@class,'x-edit-italic')]");
	}
	
	public void click_checkbox_RequireAnswer() {
//		checkbox_AllowEdit.click();
		Utils.returnTheVisibleOne(getDriver(), "//label[text()='Require Answer']").click();
	}
	
	public void choose_RoundingMethod(String roundingMethod) throws InterruptedException {
		Utils.clickByXpath(getDriver(), "//div[starts-with(@id,'elementedit')]//label[text()='Rounding Method:']//following::div[@role='button'][1]");
		Utils.clickByXpath(getDriver(),"//li[contains(@class,'x-boundlist-item') and text()='" + roundingMethod + "']");
	}


}
