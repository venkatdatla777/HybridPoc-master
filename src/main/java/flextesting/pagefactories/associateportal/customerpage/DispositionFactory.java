package flextesting.pagefactories.associateportal.customerpage;

import com.qa.base.TestBase;
import flextesting.utilities.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static flextesting.utilities.Utils.*;
import static org.junit.Assert.assertTrue;

public class DispositionFactory extends TestBase {
	@FindBy(xpath="//table[@id='dispositionMenuButton']//button[contains(@class,'disposition-btn')]")
	private WebElement btn_Disposition_level_Account;
	private String xpathOfBtnDispositionLevelAccount = "//table[@id='dispositionMenuButton']//button[contains(@class,'disposition-btn')]";
	
	@FindBy(xpath="//div[contains(@class,'customersummary')]//button[contains(@class,'disposition-btn')]")
	private WebElement btn_Disposition_level_Customer;
	private String xpathOfBtnDispositionLevelCustomer = "//div[contains(@class,'customersummary')]//button[contains(@class,'disposition-btn')]";

	@FindBy(xpath="//div[@class='x-form-check-wrap']//label[contains(text(),'Auto')]//preceding-sibling::input[1]")
	private WebElement checkBox_SelectAccountForDisposition_Auto;

	@FindBy(xpath="//div[@class='x-form-check-wrap']//label[contains(text(),'Mortgage')]//preceding-sibling::input[1]")
	private WebElement checkBox_SelectAccountForDisposition_Mortgage;

	@FindBy(xpath="//div[@class='x-form-check-wrap']//label[contains(text(),'Credit Card')]//preceding-sibling::input[1]")
	private WebElement checkBox_SelectAccountForDisposition_CreditCard;

	@FindBy(xpath="//div[@class='x-form-check-wrap']//label[contains(text(),'Gold Card')]//preceding-sibling::input[1]")
	private WebElement checkBox_SelectAccountForDisposition_GoldCard;

//	@FindBy(xpath="//div[@class='x-form-check-wrap']//label[contains(text(),'Auto')]//preceding-sibling::input[1]//following::button[text()='Next'][1]")
	@FindBy(xpath="//button[text()='Next']")
	private WebElement btn_Next_window_SelectAccountForDisposition;
//	private By locator_btn_Next_grayedOut_window_SelectAccountForDisposition = By.xpath("//div[@class='x-form-check-wrap']//label[contains(text(),'Auto')]//preceding-sibling::input[1]//following::button[text()='Next'][1]//ancestor::table[contains(@class,'x-item-disabled')][1]");
	private By locator_btn_Next_grayedOut_window_SelectAccountForDisposition = By.xpath("//button[text()='Next']//ancestor::table[contains(@class,'x-item-disabled')][1]");

	@FindBy(xpath="//div[@class='x-form-check-wrap']//label[contains(text(),'Auto')]//preceding-sibling::input[1]//following::button[text()='Cancel'][1]")
	private WebElement btn_Cancel_window_SelectAccountForDisposition;
	
	@FindBy(xpath="//span[text()='Select Account for Disposition']")
	private WebElement wind_SelectAccountForDisposition;

	@FindBy(xpath="//span[contains(text(),'Disposition for')]")
	private WebElement wind_Disposition;

	@FindBy(xpath="//div[contains(@style,'visibility: visible') and contains(@class, 'x-resizable-pinned')]//descendant::input[@name='accChannelName']//following-sibling::label[text()='Non-call Documentation']")
	private WebElement radioBtn_DispositionChannel_NonCallDocumentation;

	@FindBy(xpath="//div[contains(@style,'visibility: visible') and contains(@class, 'x-resizable-pinned')]//descendant::input[@name='accChannelName']//following-sibling::label[text()='Inbound Call']")
	private WebElement radio_DispositionChannel_InboundCall;

	@FindBy(xpath="//div[contains(@style,'visibility: visible') and contains(@class, 'x-resizable-pinned')]//descendant::input[@name='accChannelName']//following-sibling::label[text()='Outbound Manual Call']")
	private WebElement radio_DispositionChannel_OutboundManualCall;

	@FindBy(xpath="//div[contains(@style,'visibility: visible') and contains(@class, 'x-resizable-pinned')]//descendant::input[@name='accChannelName']//following-sibling::label[text()='Outbound Dialer / IVR Call']")
	private WebElement radio_DispositionChannel_OutboundDialerIVRCall;

	@FindBy(xpath="//div[contains(@style,'visibility: visible') and contains(@class, 'x-resizable-pinned')]//descendant::button[text()='Submit All Dispositions']")
	private WebElement btn_SubmitAllDispositions;
	
	@FindBy(xpath="//div[contains(@style,'visibility: visible') and contains(@class, 'x-resizable-pinned')]//descendant::button[text()='Submit & Close Account']")
	private WebElement btn_SubmitAndCloseAccount;

	@FindBy(xpath="//div[contains(@style,'visibility: visible') and contains(@class, 'x-resizable-pinned')]//descendant::button[text()='Cancel']")
	private WebElement btn_Cancel_window_Disposition;


	
	// -----------START: elements for data verification --------------
	@FindBy(xpath="//div[@class='customer-box']//div[contains(@class,'mraCustomerAccountList')]//div[contains(@class,'x-grid3-row')]//td[1]//img[contains(@class,'table-ok')]//ancestor::tr//td[3]//div")
	private WebElement data_portfolioName_tab_CustomerAccounts;

	@FindBy(xpath="//div[@class='customer-box']//div[contains(@class,'mraCustomerAccountList')]//div[contains(@class,'x-grid3-row')]//td[1]//img[contains(@class,'table-ok')]//ancestor::tr//td[6]//div")
	private WebElement data_firstName_tab_CustomerAccounts;

	@FindBy(xpath="//div[@class='customer-box']//div[contains(@class,'mraCustomerAccountList')]//div[contains(@class,'x-grid3-row')]//td[1]//img[contains(@class,'table-ok')]//ancestor::tr//td[7]//div")
	private WebElement data_lastName_tab_CustomerAccounts;

	@FindBy(xpath="//div[@id='textGerneralWidgetPanel']//div[@id='detailTabs']/div[2]/div/div[1]//td/div[text()='Balance']//following::div[1]")
	private WebElement data_balance_level_Account_tab_firstResponsible;
	private By locator_data_balance_level_Account_tab_firstResponsible = By.xpath("//div[@id='textGerneralWidgetPanel']//div[@id='detailTabs']/div[2]/div/div[1]//td/div[text()='Balance']//following::div[1]");

	@FindBy(xpath="//div[@id='textGerneralWidgetPanel']//div[@id='detailTabs']/div[2]/div/div[1]//td/div[text()='Days Past Due']//following::div[1]")
	private WebElement data_daysPastDue_level_Account_tab_firstResponsible;

	@FindBy(xpath="//div[@id='textGerneralWidgetPanel']//div[@id='detailTabs']/div[2]/div/div[1]//td/div[text()='Current Due']//following::div[1]")
	private WebElement data_currentDue_level_Account_tab_firstResponsible;

	//NOTE the difference in the xpath between the first reponsible tab and the second responsible tab is the index after the 5th div
	@FindBy(xpath="//div[@id='textGerneralWidgetPanel']//div[@id='detailTabs']/div[2]/div/div[2]//td/div[text()='Current Due']//following::div[1]")
	static Logger log = Logger.getLogger(DispositionFactory.class);
	private WebElement data_currentDue_level_Account_tab_secondResponsible;
	
	private boolean dispositionNeeded = false;
	/*
	public DispositionFactoryAccountView(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		setDispositionNeeded(true);
	}
	*/
	

	public void click_Disposition_level_Account() throws InterruptedException {
		//page keeps refreshing for a little while, so clicking the button actually clicks another button and 
		//sometimes shows this error if that element is not clickable: Element is not clickable at point
		Thread.sleep(3000);
		btn_Disposition_level_Account.click();
	}

	public void click_Disposition_level_Customer() throws InterruptedException {
		//directly clicking the button for once does not trigger the account selection window appearing. 
		//nothing happens as if you did not click. so use the following util method
		clickElement1UntilElement2AppearBeforeTimeOut(getDriver(), false, btn_Disposition_level_Customer, wind_SelectAccountForDisposition, 5);
		//Thread.sleep(3000);
		//btn_Disposition_level_Customer.click();
	}

	public void window_SelectAccountForDisposition() {
		assertTrue(wind_SelectAccountForDisposition.isDisplayed());
	}

	public void check_SelectAccountForDisposition_Auto() {
		checkBox_SelectAccountForDisposition_Auto.click();
	}

	public void check_SelectAccountForDisposition_Mortgage() {
		checkBox_SelectAccountForDisposition_Mortgage.click();
	}

	public void click_Next_window_SelectAccountForDisposition() throws InterruptedException {
		waitForElementNotPresent(getDriver(), locator_btn_Next_grayedOut_window_SelectAccountForDisposition, 3);
//		btn_Next_window_SelectAccountForDisposition.click();
		clickByXpath(getDriver(), "//button[text()='Next']");
	}

	public void window_Disposition() {
		assertTrue(wind_Disposition.isDisplayed());
	}

	/**
	 * 1. clicking too quickly has no effect, so sleep 2 seconds before clicking
	 * 2. after clicking, the 'Account maintenance' in Process Outcome is automatically
	 * selected, but it takes time, so sleep 2 second after clicking 
	 * @throws InterruptedException
	 */
	public void radio_DispositionChannel_NoncallDocumentation() throws InterruptedException {
		//Thread.sleep(2000);
		clickByXpath(getDriver(), "//input[@name='accChannelName']//following-sibling::label[text()='Non-call Documentation']");
//		radioBtn_DispositionChannel_NonCallDocumentation.click();
		//Thread.sleep(1000);
	}

	public void radio_DispositionOutcome(String outcome) {
//		String xpath_outcome = "//input[@name='accountDisResults']//following-sibling::label[text()='"+outcome+"']";
		Utils.clickByXpath(getDriver(), "//input[@name='accountDisResults']");
//		clickByXpath(driver, xpath_outcome);
	}

	public void click_SubmitAllDispositions() {
		clickByXpath(getDriver(), "//button[text()='Submit All Dispositions']");
//		btn_SubmitAllDispositions.click();
		setDispositionNeeded(false);
	}

	public void click_SubmitAndCloseAccount() throws InterruptedException {
		By locator_wrapper_disableSubmitBtn = By.xpath("//div[contains(@style,'visibility: visible') and contains(@class, 'x-resizable-pinned')]//descendant::button[text()='Submit & Close Account']//ancestor::table[contains(@class,'x-item-disabled')][1]");
		waitForElementNotPresent(getDriver(), locator_wrapper_disableSubmitBtn, 2);
		btn_SubmitAndCloseAccount.click();
		setDispositionNeeded(false);
	}
	
	public boolean tryToClickDispositionBtn(boolean accountLevel) throws InterruptedException {
		String level = "";
		if (accountLevel) level = "Account";
		else level = "Customer";

		if (dispositionBtnClicked(accountLevel)) return true;
		
		//if failed to click it, press escape key and try again
		log.info("Can not click " + level + " disposition btn. Pressing escape key 1 time and try again");
		pressEscapeKeyMultipleTimes(getDriver(), 1);
		if (dispositionBtnClicked(accountLevel)) return true;
		
		//if failed again, press [Cancel] then [Yes] btn if they exist
		log.info("Still can not click " + level + " disposition btn. Clicking [Cancel] then [Yes] button 1 time and try again");
		clickCancelBtnMultipleTimes(getDriver(), 1);
		if (dispositionBtnClicked(accountLevel)) return true;
		
		//when needed, add more rounds of pressing escape key or/and clicking cancel button   
		
		//if still not returned, meaning failed again, give up and return false
		log.info(level + " disposition btn is unclickable. Give up");
		return false;
	}
	
	private boolean dispositionBtnClicked(boolean accountLevel) {
		String xpath = "";
		String level = "";
		if (accountLevel) {
			xpath = xpathOfBtnDispositionLevelAccount;
			level = "Account";
		}
		else {
			xpath = xpathOfBtnDispositionLevelCustomer;
			level = "Customer";
		}
		WebElement btn = getDriver().findElement(By.xpath(xpath));
		//if not even displayed, return false
		if (!btn.isDisplayed()) {
			log.info(level + " disposition btn is not visible");
			return false;
		}
		//sometimes it's displayed, but clicking it will cause WebDriverException: unknown error ...  is not clickable at point
		try {
			btn.click();
		} catch (WebDriverException ex) {
			log.info(level + " disposition btn isDisplayed=true, but clicking it cause WebDriverException");
			return false;
		}
		//if not yet returned, meaning it's clicked successfully
		log.info(level + " disposition btn is clicked");
		return true;
	}
	
	private boolean isElementDisplayed(String xpath) {
		return getDriver().findElement(By.xpath(xpath)).isDisplayed();
	}

	public static String test() {
		return "haha";
	}

	public boolean isDispositionNeeded() {
		return dispositionNeeded;
	}

	public void setDispositionNeeded(boolean dispositionNeeded) {
		this.dispositionNeeded = dispositionNeeded;
	}


}
