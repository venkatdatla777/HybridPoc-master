package flextesting.pagefactories.associateportal;

import com.qa.base.TestBase;
import flextesting.AppConfig;
import flextesting.client.Client;
import flextesting.client.ClientProvider;
import flextesting.utilities.BuildDBurl;
import flextesting.utilities.RetrieveDataFromDB;
import flextesting.utilities.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static flextesting.utilities.Utils.*;


/**
 * @author Shiyi Chen
 */
public class QueueViewFactory extends TestBase {
	static Logger log = Logger.getLogger(QueueViewFactory.class);
	public static String ReferenceNumber;

	@FindBy(xpath="//td[@id='previousCustomerComboBox-inputCell']//following::div[@role='button'][1]")
	private WebElement dropdown_PreviousAccount;
	
	@FindBy(xpath="(//div//ul//li//div[@class='x-combo-list-item']//h3[contains(text(),'Reference Number')])[1]")
	private WebElement option_PreviousAccount_theFirstOne;

	@FindBy(xpath="//input[@seleniumpath='queueviewsearchAcc']")
	private WebElement field_SearchAccount;

	public void choose_PreviouslyWorkedAccount_theFirstOne() throws InterruptedException {
		dropdown_PreviousAccount.click();

		Thread.sleep(1000);
		//for weird reason, if we don't wait, we get error "element is not attached to 
		//	the page document" as if the option is removed from the DOM 

		//click the first one
		//open in a new tab
		clickByXpath(getDriver(), "//div[@class='x-combo-list-item']//h3[contains(text(),'Reference Number')]");
		//open in a new window 
//		openInANewWindow(driver, "//div[@class='x-combo-list-item']//h3[contains(text(),'Reference Number')]");
	}

	/**
	 * Use searchAndLoadNonReadOnlyUserLogon instead
	 * 
	 * @deprecated
	 * @throws InterruptedException
	 */
	@Deprecated
	public void searchAndLoadAnNotReadOnlyAccount() throws InterruptedException {
		RetrieveDataFromDB instance = new RetrieveDataFromDB();
		String referenceNumber = instance.retrieveAccount(ClientProvider.getClient().getDBUrl(), Client.DB_USER, Client.DB_PASSWORD);
		clearAndEnter(getDriver(), "//input[@seleniumpath='queueviewsearchAcc']","r "+referenceNumber);
		//wait a sec for the searching process
		Thread.sleep(1000);
		clickByXpath(getDriver(), "//div[contains(@class,'x-boundlist-item')][1]");
	}

	public void getTheAccountNumberAndUpdateTheDBForDisposition(){
		RetrieveDataFromDB retrieveDataFromDB = new RetrieveDataFromDB();
		log.info("Reference number is "+ReferenceNumber);
		HashMap<String,String> accountAndResponsibleId = retrieveDataFromDB.retrieveAccountNumberAndResponsibleId
						(BuildDBurl.buildDBURL(System.getProperty("dbIP"),System.getProperty("dbName"),
								Boolean.parseBoolean(System.getProperty("needPostfixToHandleTimeZoneSQLException"))),
								System.getProperty("UserName"), System.getProperty("Password"),ReferenceNumber);
		retrieveDataFromDB.updateTheTableToPerformDisposition(BuildDBurl.buildDBURL(System.getProperty("dbIP"),System.getProperty("dbName"),
				Boolean.parseBoolean(System.getProperty("needPostfixToHandleTimeZoneSQLException"))),
				System.getProperty("UserName"), System.getProperty("Password"),
				accountAndResponsibleId.get("accountNumber"),accountAndResponsibleId.get("responsibleId"));
	}

	public void searchAndLoadNonReadOnlyUserLogon() throws Exception {
		ReferenceNumber = null;
		List<String> userLogonList = new RetrieveDataFromDB().
				retrieveUserLogons(BuildDBurl.buildDBURL(System.getProperty("dbIP"),System.getProperty("dbName"),
						Boolean.parseBoolean(System.getProperty("needPostfixToHandleTimeZoneSQLException"))),
						System.getProperty("UserName"), System.getProperty("Password"));
		//shuffle the list and try userlogon one by one later if needed
		Collections.shuffle(userLogonList);
		int i = 0;
		System.out.println("USer : " + userLogonList.get(i));
		ReferenceNumber = userLogonList.get(i);
		searchAndLoadUserLogon(userLogonList.get(i));
		String xpathCustomerLock = "//span[contains(text(),'Customer in read-only mode')]";
		String xpathAccountLock = "//span[contains(text(),'account in read-only mode')]";
		//if window shows indicating the account or customer is lock, then load another userlogon
		boolean	customerLocked = Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), xpathCustomerLock, true, false);
		boolean accountLocked = false;
		//if customerLocked is true, then no need to check accountLocked
		if (!customerLocked) {
			//setting parameters 1 + false is not because accountLocked is not expected to be present, but because checking whether
			//customerLocked already took 5 sec (implicit wait time), hence no need to wait another 5 sec to check accountLocked 
			accountLocked = Utils.isElementDisplayed_clickIfNeeded(1, getDriver(), xpathAccountLock, false, false);
		}
		while( customerLocked || accountLocked) {
			// if showing accountLocked, meaning the customer is not locked, then we need to click the X button
			// at the top right corner to "disposition" the customer (not really disposition, but by doing so,
			// this customer will not be counted as one locked by me, thus the following no message won't show: 
			//			"Exceeds the maximum number of customers that can be loaded. 
			//			Please disposition and close other customer(s) to load further."
			if (accountLocked) {
				log.info("A window shows up indicating the account is locked");
				clickByXpath(getDriver(), "//button[text()='OK']");
				log.info("OK button clicked");
				if (AppConfig.isRequireVerification()) {
					clickByXpath(getDriver(), "//button[text()='Skip Verification']");
				}
				if (ClientProvider.hasAgentNotification){
					clickByXpath(getDriver(), "//div[contains(@class,'x-tool-minimize')]");
				}
				log.info("Skip Verification clicked");
				log.info("current window will be closed before switching, so get the current window and window pool now and pass them to switchWindow() later"); 
				String currentWindow = getDriver().getWindowHandle();
				Set<String> windowPool = getDriver().getWindowHandles();
				//wait 2 sec for the X Btn to be clickable
				Thread.sleep(2000);
				clickByXpath(getDriver(), "//button[contains(@class,'closeOverallView-btn')]");
				log.info("Top right corner X button (close overall view) clicked");
				log.info("Current tab already closed before switching, so: Switching => load another userlogon...");
				switchWindow(getDriver(), false, currentWindow, windowPool);
			} else {
				log.info("A window shows up indicating the customer is locked");
				log.info("No need to get current window and window pool because current window will not be closed before switching");
				log.info("Now, during window/tab switching: close current tab => switching => load another userlogon...");
				switchWindow(getDriver(), true, null, null);
			}
			//load another userlogon if there is still any left in the list
			if (i < userLogonList.size()-1) {
				ReferenceNumber = userLogonList.get(++i);
				searchAndLoadUserLogon(userLogonList.get(++i));
				customerLocked = Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), xpathCustomerLock, true, false);
				accountLocked = Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), xpathAccountLock, true, false);
			} else {
				throw new RuntimeException("Exhausted all userlogons, no non-read-only found. Abort mission...");
			}
		} 
	}
	private void searchAndLoadUserLogon(String userLogon) throws Exception {
		log.info("Try userLogon: " + userLogon);
		clearAndEnter(getDriver(), "//input[@seleniumpath='queueviewsearchAcc']","r "+userLogon);
		//wait a sec for the searching process
		Thread.sleep(1000);
		//click the first account after searching
		clickByXpath(getDriver(), "//div[contains(@class,'x-boundlist-item')][1]");
		switchWindow(getDriver(),false,null,null);
	}
	
	public void searchAndLoadNonReadOnlyAndHavePaymentOfferUserLogon() throws Exception {
		ReferenceNumber = null;
		List<String> userLogonList = new RetrieveDataFromDB().
				retrieveUserLogonsWhoHavePaymentOffer(BuildDBurl.buildDBURL(System.getProperty("dbIP"),System.getProperty("dbName"),
						Boolean.parseBoolean(System.getProperty("needPostfixToHandleTimeZoneSQLException"))),
						System.getProperty("UserName"), System.getProperty("Password"));
		//shuffle the list and try userlogon one by one later if needed
		Collections.shuffle(userLogonList);
		int i = 0;
		System.out.println("USer : " + userLogonList.get(i));
		ReferenceNumber = userLogonList.get(i);
		searchAndLoadUserLogon(userLogonList.get(i));
		String xpathCustomerLock = "//span[contains(text(),'Customer in read-only mode')]";
		String xpathAccountLock = "//span[contains(text(),'account in read-only mode')]";
		//if window shows indicating the account or customer is lock, then load another userlogon
		boolean	customerLocked = Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), xpathCustomerLock, true, false);
		boolean accountLocked = false;
		//if customerLocked is true, then no need to check accountLocked
		if (!customerLocked) {
			//setting parameters 1 + false is not because accountLocked is not expected to be present, but because checking whether
			//customerLocked already took 5 sec (implicit wait time), hence no need to wait another 5 sec to check accountLocked 
			accountLocked = Utils.isElementDisplayed_clickIfNeeded(1, getDriver(), xpathAccountLock, false, false);
		}
		while( customerLocked || accountLocked) {
			// if showing accountLocked, meaning the customer is not locked, then we need to click the X button
			// at the top right corner to "disposition" the customer (not really disposition, but by doing so,
			// this customer will not be counted as one locked by me, thus the following no message won't show: 
			//			"Exceeds the maximum number of customers that can be loaded. 
			//			Please disposition and close other customer(s) to load further."
			if (accountLocked) {
				log.info("A window shows up indicating the account is locked");
				clickByXpath(getDriver(), "//button[text()='OK']");
				log.info("OK button clicked");
				if (AppConfig.isRequireVerification()) {
					clickByXpath(getDriver(), "//button[text()='Skip Verification']");
				}
				if (ClientProvider.hasAgentNotification){
					clickByXpath(getDriver(), "//div[contains(@class,'x-tool-minimize')]");
				}
				log.info("Skip Verification clicked");
				log.info("current window will be closed before switching, so get the current window and window pool now and pass them to switchWindow() later"); 
				String currentWindow = getDriver().getWindowHandle();
				Set<String> windowPool = getDriver().getWindowHandles();
				//wait 2 sec for the X Btn to be clickable
				Thread.sleep(2000);
				clickByXpath(getDriver(), "//button[contains(@class,'closeOverallView-btn')]");
				log.info("Top right corner X button (close overall view) clicked");
				log.info("Current tab already closed before switching, so: Switching => load another userlogon...");
				switchWindow(getDriver(), false, currentWindow, windowPool);
			} else {
				log.info("A window shows up indicating the customer is locked");
				log.info("No need to get current window and window pool because current window will not be closed before switching");
				log.info("Now, during window/tab switching: close current tab => switching => load another userlogon...");
				switchWindow(getDriver(), true, null, null);
			}
			//load another userlogon if there is still any left in the list
			if (i < userLogonList.size()-1) {
				ReferenceNumber = userLogonList.get(++i);
				searchAndLoadUserLogon(userLogonList.get(++i));
				customerLocked = Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), xpathCustomerLock, true, false);
				accountLocked = Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), xpathAccountLock, true, false);
			} else {
				throw new RuntimeException("Exhausted all userlogons, no non-read-only found. Abort mission...");
			}
		} 
	}

	
	
}
