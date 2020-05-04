package flextesting.pagefactories.strategistportal.documentmanager;

import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static flextesting.utilities.Utils.*;
import static org.junit.Assert.assertFalse;

public class DocumentManagerFactory extends TestBase {
	@FindBy(xpath="//div[text()='Context']//following::td[@class='x-trigger-cell'][1]//div")
	private WebElement dropdown_Context;
	
	@FindBy(xpath="//li[contains(@class,'x-boundlist-item') and text()='Responsible']")
	private WebElement option_Context_Responsible;

	@FindBy(xpath="//span[text()='Add']")
	private WebElement btn_Add;

	@FindBy(xpath="//span[text()='Edit']")
	private WebElement btn_Edit;

	@FindBy(xpath="//span[text()='Delete']")
	private WebElement btn_Delete;

	@FindBy(xpath="//input[@name='name']")
	private WebElement field_DocumentName;

	@FindBy(xpath="//iframe[starts-with(@title,'Rich Text Editor')]")
	private WebElement field_body;

	@FindBy(xpath="//td[starts-with(@id,'listdisplayfield') and contains(@id, 'imageBtnEl')]//button")
	private WebElement btn_Edit_AssignedPortfolio;

	@FindBy(xpath="//span[text()='Available Portfolios']//preceding::img[1]")
	private WebElement btn_close_AssignPortfolio;

	@FindBy(xpath="//div[text()='Enable Delivery via Letter']//preceding-sibling::table//input[contains(@id,'checkboxfieldset')]")
	private WebElement checkBox_EnableDeliveryViaLetter;

	@FindBy(xpath="//div[text()='Enable Delivery via Email']//preceding-sibling::table//input[contains(@id,'checkboxfieldset')]")
	private WebElement checkBox_EnableDeliveryViaEmail;

	@FindBy(xpath="//div[text()='Enable Delivery via SMS']//preceding-sibling::table//input[contains(@id,'checkboxfieldset')]")
	private WebElement checkBox_EnableDeliveryViaSMS;

	@FindBy(xpath="//input[@name='mailSubject']")
	private WebElement field_MailSubject;

	@FindBy(xpath="//span[text()='Save as Draft']//parent::button[1]")
	private WebElement btn_SaveAsDraft;

	@FindBy(xpath="//div[text()='This document has been saved successfully.']//following::span[text()='OK'][1]")
	private WebElement messageWindow_DocumentSaved_OK;

	@FindBy(xpath="//span[text()='Publish This Version']//parent::button[1]")
	private WebElement btn_PublishThisVersion;

	@FindBy(xpath="//div[text()='This document has been published successfully.']//following::span[text()='OK'][1]")
	private WebElement messageWindow_DocumentPublished_OK;

	@FindBy(xpath="//input[starts-with(@id,'triggerfield')]")
	private WebElement field_Search;

	@FindBy(xpath="//div[contains(@class,'x-form-search-trigger')]")
	private WebElement btn_search;

	@FindBy(xpath="//span[text()='Text Body']")
	private WebElement tab_TextBody;


	@FindBy(xpath="//div[text()='If you delete this document, you can not enable it anymore. Are you sure you want to continue and delete this document?']//following::span[text()='Yes'][1]")
	private WebElement btn_Yes_confirmationWindow_DeleteDocument;

	/*
	@FindBy(xpath="")
	private WebElement ;	

	*/

	private boolean isDocumentCreated = false;

	public boolean isDocumentCreated() {
		return isDocumentCreated;
	}

	public void setDocumentCreated(boolean isDocumentCreated) {
		this.isDocumentCreated = isDocumentCreated;
	}

	public void choose_Context_Responsible() {
		waitToBeVisibleAndClick(getDriver(), dropdown_Context, 3);
		option_Context_Responsible.click();
	}

	/**
	 * Must wait so the window element can load properly, especially the text editor of body (tag: iframe)
	 * @throws InterruptedException
	 */
	public void click_Add() throws InterruptedException {
		btn_Add.click();
		Thread.sleep(2000);
	}

	public void enter_name(String name) {
		clearAndEnter(getDriver(), "//input[@name='name']", name);
	}

	/**
	 * Body must start with \n to trigger the text editor area (iframe) properly. 
	 * @param body
	 */
	public void enter_body(String body) {
		returnTheVisibleOne(getDriver(), "//iframe[starts-with(@title,'Rich Text Editor')]").sendKeys(body);
	}

	public void click_Edit_AssignedPortfolio() {
		btn_Edit_AssignedPortfolio.click();
	}

	public void drag_AvailablePortfoliosToSelectedPortfolios(String availablePortfolio) {
		doubleClickElement(getDriver(), returnTheVisibleOne(getDriver(), "//li[text()='"+availablePortfolio+"']"));
	}
	public void drag_FirstAvailablePortfoliosToSelectedPortfolios() {
		doubleClickElement(getDriver(), returnTheVisibleOne(getDriver(), "//li[@class='x-boundlist-item']"));
	}
	public void drag_AllAvailablePortfoliosToSelectedPortfolios() throws InterruptedException {
		clickAllVisibleOnes(getDriver(), "//li[@class='x-boundlist-item']", true, null);
	}
	public void click_close_AssignPortfolio() {
//		btn_close_AssignPortfolio.click();
		clickByXpath(getDriver(), "//span[text()='Available Portfolios']//preceding::img[1]");
	}
 
	public void check_EnableDeliveryViaLetter() {
		checkBox_EnableDeliveryViaLetter.click();
	}

	public void click_SaveAsDraft() {
		waitToBeClickableAndClick(getDriver(), btn_SaveAsDraft, 2);
	}

	public void message_DocumentSaved_OK() {
		messageWindow_DocumentSaved_OK.click();
		setDocumentCreated(true);
	}

	public void click_PublishThisVersion() {
		waitToBeClickableAndClick(getDriver(), btn_PublishThisVersion, 1);
	}

	/**
	 * wait 2 sec for the saving process
	 * @throws InterruptedException
	 */
	public void message_DocumentPublished_OK() throws InterruptedException {
		messageWindow_DocumentPublished_OK.click();
		Thread.sleep(2000);
	}

	public void enter_Search(String name) {
		clearAndEnter(getDriver(), "//input[starts-with(@id,'triggerfield')]", name);
	}

	/**
	 * wait 1 sec for the searching process
	 * @throws InterruptedException
	 */
	public void click_Search() throws InterruptedException {
		btn_search.click();
		Thread.sleep(1000);
	}

	public boolean present_documentInSearchResult(String name) throws InterruptedException {
		return isElementDisplayed_clickIfNeeded(0, getDriver(), "//td//div[text()='"+name+"']", true, false);
	}

	public void select_documentInSearchResult(String name) {
		getDriver().findElement(By.xpath("//td//div[text()='"+name+"']")).click();
	}

	/**
	 * wait 3 sec for the doc to load
	 * @throws InterruptedException
	 */
	public void click_Edit() throws InterruptedException {
		btn_Edit.click();
		Thread.sleep(3000);
	}

	public void check_EnableDeliveryViaEmail() {
		checkBox_EnableDeliveryViaEmail.click();
	}

	public void enter_MailFrom(String mailFrom) {
		clearAndEnter(getDriver(), "//input[@name='mailFrom']", mailFrom);
	}

	public void enter_MailSubject(String mailSubject) {
		clearAndEnter(getDriver(), "//input[@name='mailSubject']", mailSubject);
	}

	public void click_TextBody() {
		tab_TextBody.click();
	}

	public void enter_EmailTextBody(String body) {
		clearAndEnter(getDriver(), "(//span[text()='English']//following::table[starts-with(@id,'textareafield')]//textarea)[1]", body);
	}

	public void check_EnableDeliveryViaSMS() {
		checkBox_EnableDeliveryViaSMS.click();
	}

	public void enter_SMSTextBody(String body) {
	/**
	 * the index is 2 when Enable email delivery is checked before enable sms delivery is checked 
	 */
		clearAndEnter(getDriver(), "(//span[text()='English']//following::table[starts-with(@id,'textareafield')]//textarea)[1]", body);
	}

	public void click_Delete() {
		btn_Delete.click();
	}

	/**
	 * wait 1.5 sec for the deleting process
	 * @throws InterruptedException
	 */
	public void confirmation_DeleteDocument_Yes() throws InterruptedException {
		btn_Yes_confirmationWindow_DeleteDocument.click();
		setDocumentCreated(false);
		Thread.sleep(1500);
	}

	public void notPresent_documentInSearchResult(String name) throws InterruptedException {
		assertFalse(isElementDisplayed_clickIfNeeded(1500, getDriver(), "//td//div[text()='"+name+"']", false, false));
	}
}
