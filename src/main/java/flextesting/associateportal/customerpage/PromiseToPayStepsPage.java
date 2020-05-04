package flextesting.associateportal.customerpage;


import com.qa.base.TestBase;
import flextesting.exceptions.NoVisibleElementFoundException;
import flextesting.pagefactories.CommonElementsFactory;
import flextesting.utilities.DataUtil;
import org.apache.log4j.Logger;

import static flextesting.utilities.Utils.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PromiseToPayStepsPage extends TestBase {
	static Logger log = Logger.getLogger(PromiseToPayStepsPage.class);
	private CommonElementsFactory commonElementsFactory;
	private String promiseAmount = null;
	private int numberOfRecursivePromises = 1;
	private String xpathOfPromise = null;
	private boolean deleteTheSecondPTP = true;

	
	public void i_click_the_Promise_tab() throws Throwable {
		clickByXpath(getDriver(), "//span[text()='Promise']");
	}

	
	public void i_click_the_Make_A_Promise_button() throws Throwable {
		clickByXpath(getDriver(), "//button[text()='Make A Promise']");
	}

	
	public void i_enter_an_Amount_for_the_promise() throws Throwable {
		promiseAmount = DataUtil.getRandomNumberNotContainingZero(4);
		clearAndEnter(getDriver(), "//input[@name='paymentAmount']", promiseAmount);
		System.out.println("promiseAmount :" + promiseAmount);
		xpathOfPromise = "//div[contains(text(),'"+DataUtil.currencyFormatter(promiseAmount)+"')]";
		System.out.println("xpathOfPromise :" + xpathOfPromise);
	}

	
	public void i_set_a_Send_Date_for_the_promise() throws Throwable {
		clickByXpath(getDriver(), "//input[@name='sendDate']");
		clickByXpath(getDriver(), "//button[text()='Today']");
	}

	
	public void i_choose_an_Payment_Method() throws Throwable {
		clickByXpath(getDriver(), "//input[@id='newAccountPromisesPaymentMethodCombo']");
		//select "OTHER" , if "OTHER" not found then select the first one
		String xpathOfOTHER = "//div[contains(@class,'x-combo-list-item') and text()='OTHER']";
		if (isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfOTHER, true, false))
			isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfOTHER, true, true);
		else
			clickByXpath(getDriver(), "//div[contains(@class,'x-combo-list-item')]");
	}

	
	public void i_set_a_Arrival_Date_for_the_promise() throws Throwable {
		clickByXpath(getDriver(), "//input[@name='arrivalDate']");
		//select the first valid date
		try {
			clickByXpath(getDriver(), "//td[@class='x-date-active']");
			log.info("choose a future date for Arriving date, thus the promise will be outstanding. Will delete the recurring PTP");
		} catch (NoVisibleElementFoundException ex) {
			//when choosing "client" as the payment method, we might have to choose today as it's the only valid choice 
			clickByXpath(getDriver(), "//td[contains(@class,'x-date-today')]");
			//when choosing today, we will NOT delete the recurring PTP, because the first PTP will be broken and can't be updated
			deleteTheSecondPTP = false;
			log.info("choose today for Arriving date, thus the promise will be broken. Will NOT delete the recurring PTP and use it to test [Update]");
		}
	}

	
	public void i_check_Make_it_Recursive_for() throws Throwable {
		clickByXpath(getDriver(), "//input[@name='recursiveChk']");
	}

	
	public void i_enter_a_number_for_Additional_Months() throws Throwable {
		String xpathOfField = "//input[@name='recursiveNum']";
		waitToBeClickableAndClick(getDriver(), xpathOfField, 2);
		clearAndEnter(getDriver(), xpathOfField, Integer.toString(numberOfRecursivePromises));
	}
	
	
	public void i_click_Submit_All_Promises() throws Throwable {
		clickByXpath(getDriver(), "//button[text()='Submit All Promises']");
	}
	
	
	public void the_promise_is_saved() throws Throwable {
		//wait 2 sec then find all visible ones
		Thread.sleep(2000);
		int numberOfPromisesMade = findAllVisibleOnes(getDriver(), xpathOfPromise).size();
		assertEquals(numberOfRecursivePromises+1, numberOfPromisesMade);
		//delete the second promise now because later the xpathOfPromise will change (because amount will be updated)
		if (deleteTheSecondPTP) {
			String xpathOfTheSecondPromise = "(" + xpathOfPromise + ")[2]";
			isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfTheSecondPromise, true, true);
			i_click_the_button_in_the_Promise_tab("Delete PTP");
			commonElementsFactory.confirm_Yes();
			commonElementsFactory.message_OK();
			the_promise_is_deleted();
		}
	}

	/**
	 * If second PTP (the recurring one) is not deleted, choose it 
	 * Else: choose the first one
	 * @throws Throwable
	 */
	
	public void i_select_the_promise() throws Throwable {
		if (deleteTheSecondPTP)
			isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfPromise, true, true);
		else {
			String xpathOfTheSecondPromise = "(" + xpathOfPromise + ")[2]";
			isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfTheSecondPromise, true, true);
		}
	}

	
	public void i_click_the_button_in_the_Promise_tab(String btnName) throws Throwable {
		//wait 1 sec for it to be not grayed out
		Thread.sleep(1000);
		clickByXpath(getDriver(), "//div[@id='paymentPromiseOfferWindow']//button[text()='"+btnName+"']");
	}

	
	public void i_click_the_Update_button_in_Update_a_Promise_window() throws Throwable {
		String xpathOfUpdateBtn = "//div[@id='updatePromiseForm']//button[text()='Update']"; 
		Thread.sleep(1000);
		clickByXpath(getDriver(), xpathOfUpdateBtn);
//		String xpathOfBtnDisableWrapper = xpathOfUpdateBtn + "//ancestor::table[1]";
//		waitToBeClickableAndClick(driver, xpathOfBtnDisableWrapper, 3);
	}

	
	public void the_promise_is_updated() throws Throwable {
		if (deleteTheSecondPTP)
			assertTrue(isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfPromise, true, false));
		else {
			String xpathOfTheSecondPromise = "(" + xpathOfPromise + ")[2]";
			assertTrue(isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfTheSecondPromise, true, true));
		}
	}

	
	public void the_promise_is_deleted() throws Throwable {
		//check if the status of the promise is "deleted"
		String xpathOfStatusDeleted = xpathOfPromise + "//parent::td//following-sibling::td//div[text()='DELETED']";
		assertTrue(isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfStatusDeleted, true, false));
	}
	
	public void the_promise_is_updated_for_Account_view() throws Throwable {
		if (deleteTheSecondPTP)
			assertTrue(isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfPromise, true, false));
		else {
			String xpathOfTheSecondPromise = "(" + xpathOfPromise + ")";
			assertTrue(isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfTheSecondPromise, true, true));
		}
	}
	
}
