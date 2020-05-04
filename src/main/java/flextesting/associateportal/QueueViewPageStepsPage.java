package flextesting.associateportal;

//import com.cmc.flextesting.associateportal.customerpage.VerificationWindowSteps;
//import com.cmc.flextesting.client.ClientProvider;
//import com.cmc.flextesting.pagefactories.associateportal.QueueViewFactory;
import com.qa.base.TestBase;
import flextesting.associateportal.customerpage.VerificationWindowSteps;
import flextesting.client.ClientProvider;
import flextesting.pagefactories.associateportal.QueueViewFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import sun.security.util.PendingException;

import java.util.HashMap;

import static flextesting.utilities.Utils.*;
import static org.junit.Assert.assertEquals;

public class QueueViewPageStepsPage extends TestBase {
	static Logger log = Logger.getLogger(QueueViewPageStepsPage.class);
	private QueueViewFactory queueViewFactory;
	private String xpathOfArrowTriggers = "(//td[@class='x-trigger-cell'])"; // add
																				// [1],
																				// [2]...
																				// to
																				// get
																				// the
																				// one
																				// you
																				// need
	// consider to move the next factory future
	private VerificationWindowSteps verificationWindowSteps;
	private String xpathOfQueueId = "//div[starts-with(@id,'queuetreepanel')]//div[contains(text(),'Queue Id')]";
	private String xpathOfAccountsInQueue = "//div[@id='showQueueViewAccountsGrid-body']//table//tr[contains(@class,'x-grid-row')]";
	private boolean shouldSeeAccountLoaded = true;

	public void i_select_an_account_from_recent_accounts() throws Throwable {
		queueViewFactory.choose_PreviouslyWorkedAccount_theFirstOne();
		switchWindow(getDriver(), false, null, null);
	}

	public void i_search_and_load_an_account_that_is_not_currently_loaded_by_another_agent() throws Throwable {
		queueViewFactory.searchAndLoadNonReadOnlyUserLogon();
	}

	public void i_should_see_the_account_loaded() throws Throwable {
		if (shouldSeeAccountLoaded) {
			log.info("shouldSeeAccountLoaded is true, continue switching and check for verification window");
			verificationWindowSteps.verifyInfo();
		} else {
			log.info("shouldSeeAccountLoaded is false, will NOT continue switching window");
		}

	}

	public void i_have_loaded_an_account_of_a_customer() throws Throwable {
		// i_select_an_account_from_recent_accounts();
		i_search_and_load_an_account_that_is_not_currently_loaded_by_another_agent();
		i_should_see_the_account_loaded();
	}

	// load from queue

	public void there_is_queue_in_Queue_View() throws Throwable {
		// assertTrue(isElementDisplayed_clickIfNeeded(0, driver,
		// xpathOfQueueId, true, false));
		// if there is no queue in Queue View, throw exception
		if (!isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfQueueId, true, false))
			throw new PendingException("No queue found in Queue View Section. Mission aborted...");
	}

	public void i_double_click_a_queue_in_Queue_View() throws Throwable {
		doubleClickElement(getDriver(), getDriver().findElement(By.xpath(xpathOfQueueId)));
	}

	public void i_should_see_accounts_in_Queue_Accounts() throws Throwable {
		// assertTrue(isElementDisplayed_clickIfNeeded(0, driver,
		// xpathOfAccountsInQueue, true, false));
		// if no accounts found in queue, then skip the rest
		if (!isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfAccountsInQueue, true, false)) {
			throw new PendingException("No Accounts found in queue. Mission Abort");
		}
	}

	public void i_double_click_an_account_in_Queue_Accounts() throws Throwable {
		doubleClickElement(getDriver(), getDriver().findElement(By.xpath(xpathOfAccountsInQueue)));
	}

	public void i_should_see_a_new_tab_is_opened_so_what_I_know_the_account_is_loaded() throws Throwable {
		int windowPoolSize = switchWindow(getDriver(), false, null, null);
		assertEquals(2, windowPoolSize);
		try {
			// It will make sure that the two windows are opened and thus checks
			// if an account is loaded or not.
			// click the skip verification button if it's there.
			verificationWindowSteps.verifyInfo();
		} catch (NoSuchElementException ex) {
			// ignore the action when the account is locked
			log.info("The 'Skip Verification' button is not found. The account might be locked by another agent");
		}
	}

	// get next account from portfolio

	public void i_select_instead_of_for_Get_Next_Account_From(String choose, String notChoose) throws Throwable {
		clickByXpath(getDriver(), xpathOfArrowTriggers + "[2]");
		clickByXpath(getDriver(), "//li[@role='option' and text()='" + choose + "']");
	}

	public void i_select_a_portfolio_for_Get_Next_Account_From() throws Throwable {
		clickByXpath(getDriver(), xpathOfArrowTriggers + "[3]");
		// choose the first portfolio from the drop down
		HashMap aPortfolioInfo = ClientProvider.getClient().getAvailablePortfolios().get(0);
		String xpathOfAPortfolio = "//li[contains(@class,'x-boundlist-item') and " + "contains(text(),'"
				+ aPortfolioInfo.get("portfolioId") + "') " + "and (contains(text(),'" + aPortfolioInfo.get("name")
				+ "') " + "or contains(text(),'" + aPortfolioInfo.get("description") + "'))]";
		clickByXpath(getDriver(), xpathOfAPortfolio);
	}

	public void i_click_the_Get_Next_Account_From_button() throws Throwable {
		clickByXpath(getDriver(), "//span[text()='Get Next Account From']");
		switchWindow(getDriver(), false, null, null);
	}

	public void i_select_a_queue_for_Get_Next_Account_From() throws Throwable {
		clickByXpath(getDriver(), "//input[@name='queueId']");
		// clickByXpath(driver, xpathOfArrowTriggers+"[3]"); //this trigger
		// becomes invisible after selecting queue. So: the xpath only works
		// when selecting Portfolio
		try {
			clickByXpath(getDriver(), "//div[contains(@class,'x-boundlist-item')]//h3[contains(text(),'Queue:')]");
		} catch (NoSuchElementException ex) {
			throw new PendingException("No Queue found in the dropdown menu. Mission Abort...");
		}
	}

	public void if_there_is_no_message_saying_No_next_account_available_or_No_workable_queue_found() throws Throwable {
		if (isElementDisplayed_clickIfNeeded(2000, getDriver(), "//div[contains(text(),'No next account available.')]",
				false, false)) {
			shouldSeeAccountLoaded = false;
			log.info("Message shows up: No next account available");
		} else if (isElementDisplayed_clickIfNeeded(2000, getDriver(),
				"//div[contains(text(),'No workable queue found.')]", false, false)) {
			shouldSeeAccountLoaded = false;
			log.info("Message shows up: No workable queue found.");
		}
	}
	
	public void i_have_loaded_an_account_of_a_customer_for_program_offer() throws Throwable {
		// i_select_an_account_from_recent_accounts();
		i_search_and_load_an_account_that_is_not_currently_loaded_by_another_agent_and_have_payment_offer();
		i_should_see_the_account_loaded();
	}
	
	public void i_search_and_load_an_account_that_is_not_currently_loaded_by_another_agent_and_have_payment_offer() throws Throwable {
		queueViewFactory.searchAndLoadNonReadOnlyAndHavePaymentOfferUserLogon();
	}

	public void get_the_accountnumber_and_responsibleId_from_referenceNumber_and_update_the_DB_for_disposition(){
	queueViewFactory.getTheAccountNumberAndUpdateTheDBForDisposition();
	}
}
