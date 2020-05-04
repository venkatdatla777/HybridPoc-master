package flextesting.associateportal.customerpage;


import com.qa.base.TestBase;
import flextesting.pagefactories.CommonElementsFactory;
import flextesting.pagefactories.associateportal.customerpage.PaymentFactory;
import flextesting.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.Arrays;

public class PaymentStepsPage extends TestBase {

	private PaymentFactory paymentFactory;
	private CommonElementsFactory commonElementsFactory;
	private boolean accountLevel = true;
	private String accountType = "BankAccount";

	public void i_click_the_Payment_icon_at_account_level() throws Throwable {
		accountLevel = true;
		paymentFactory.click_PaymentIcon_level_account();
	}

	public void i_click_Make_a_One_Time_Payment() throws Throwable {
		paymentFactory.click_MakeAOneTimePayment();
	}

	public void i_select_day_from_today_as_the_payment_date(int arg1) throws Throwable {
		// NOTE: if arg1 = 0, which means today, then you can NOT update the
		// payment later
//		if (accountType.equals("BankAccount"))
			paymentFactory.pick_PaymentDate(arg1, "account");
//		else
//			paymentFactory.pick_PaymentDate(0, "account");
	}

	public void i_select_the_minimum_due_as_the_payment_amount() throws Throwable {
		// there is a defect with the dropdown menu of payment amount, so
		// directly enter an amount for now
		// if(ClientProvider.getCode().equals("TNA"))
		paymentFactory.enter_PaymentAmount("5");
		// else
		// paymentFactory.choose_minimumDue();
	}

	public void i_click_Add_New_Funding_Account() throws Throwable {
		paymentFactory.click_AddNewFundingAccount();
	}

	public void i_choose_New_Card_Account() throws Throwable {
		paymentFactory.click_NewCardAccount();
	}

	public void i_select_a_funding_account() throws Throwable {
		accountType = paymentFactory.choose_theFirstFundingAccount("account");
		// if(accountType.equals("CardAccount")) {
		// Utils.clearAndEnter(driver, "//input[@name='cvv']", "123");
		// } else if (accountType.equals("customerLevel")) {
		// try {
		// Utils.clearAndEnter(driver, "//input[@name='cvv']", "123");
		// }
		// catch (NoSuchElementException ex) {
		// System.out.println("no cvv field found");}
	}
	// }

	public void i_click_Submit_All_Payments() throws Throwable {
		// before submitting, check if the "payment type" section is not hidden.
		// if not hidden, then choose "Regular" for the type
		// how to check? when this element: //label[text()='Payment
		// Type:']//following-sibling::div//div contains class "x-hide-display"
		// then the "payment type" section is hidden
		// Usually, in PLAQA, it's hidden. in PLBQA, it's not
		if (accountLevel) {
			String classNames = getDriver()
					.findElement(By.xpath("//label[text()='Payment Type:']//following-sibling::div//div"))
					.getAttribute("class");
			if (!Arrays.asList(classNames.split(" ")).contains("x-hide-display")) {
				// System.out.println("Payment type section is not hidden,
				// choose 'Regular'");
				Utils.isElementDisplayed_clickIfNeeded(0, getDriver(),
						"//label[text()='Payment Type:']//following-sibling::div//img", true, true);
				Utils.isElementDisplayed_clickIfNeeded(0, getDriver(),
						"//div[contains(@class,'x-combo-list-item') and text()='Regular']", true, true);
			}
		}
		paymentFactory.click_SubmitAllPayments();
	}

	public void the_payment_submitted_confirmation_window_should_show() throws Throwable {
		paymentFactory.present_PaymentSubmittedConfirmation();
	}

	public void i_select_the_payment_from_the_table() throws Throwable {
		paymentFactory.select_thePaymentJustSubmitted();
	}

	public void i_click_the_Update_button() throws Throwable {
//		if (accountType.equals("CardAccount")) {
//			throw new PendingException("Card account is chosen, update functionality won't be tested.");
//		}
		paymentFactory.click_UpdatePayment();
	}

	public void i_click_Next_in_Update_Payment_window() throws Throwable {
		paymentFactory.click_Next_window_UpdatePayment();
	}

	public void i_click_Submit_in_Update_Payment_window() throws Throwable {
		paymentFactory.click_Submit_window_UpdatePayment();
	}

	public void the_payment_updated_confirmation_window_should_show() throws Throwable {
		paymentFactory.present_PaymentUpdatedConfirmation();
	}

	public void i_click_the_Delete_button() throws Throwable {
		paymentFactory.click_DeletePayment();
	}

	public void i_click_Yes_in_Delete_Payment_confirmation_window() throws Throwable {
		paymentFactory.click_Yes_confirmation_DeletePayment();
	}

	public void the_payment_deleted_confirmation_window_should_show() throws Throwable {
		paymentFactory.present_PaymentDeletedConfirmation();
	}

	// customer level steps

	public void i_click_the_Payment_icon_at_customer_level() throws Throwable {
		accountLevel = false;
		// for some unknown reason, click it once sometimes does not pop out the
		// payment window
		// if still has problem in future, change 2 to 3 or even 4
		for (int i = 0; i < 2; i++) {
			Utils.clickByXpath(getDriver(), "//div[@class='sm-customer']//button[contains(@class,'payment-btn')]");
			Thread.sleep(1000);
		}
	}

	public void i_click_the_Make_Payment_button() throws Throwable {
		Utils.clickByXpath(getDriver(),
				"//table[@id='makeCustomerPayment' or @id='makePayment']//button[text()='Make Payment']");
	}

	public void i_select_an_account_for_the_payment() throws Throwable {
		Utils.clickByXpath(getDriver(), "//input[contains(@id,'payCheckbox')]");
	}

	public void i_select_day_from_today_as_the_payment_date_for_the_chosen_account(int arg1) throws Throwable {
		// if (Utils.isElementDisplayed_clickIfNeeded(0, driver,
		// "//input[@name='cvv']", true, false)) {
		// paymentFactory.pick_PaymentDate(0,"customer");
		// } else {
		paymentFactory.pick_PaymentDate(arg1, "customer");
	}
	// }

	public void i_enter_as_the_payment_amount(String amount) throws Throwable {
		Utils.clearAndEnter(getDriver(), "//input[@name='paymentAmount']", amount);
		// SLMQA has an extra field: Payment Type
		if (Utils.isElementDisplayed_clickIfNeeded(1000, getDriver(),
				"//input[@name='paymentType']//following-sibling::img", false, false)) {
			Utils.clickByXpath(getDriver(), "//input[@name='paymentType']//following-sibling::img");
			// change this to: choose the first option, if needed (for instance,
			// if another client has a different option)
			commonElementsFactory.chooseAnOptionByName("Regular");
		}
		/*
		 * //SLMQA has an extra field: Payment Type if
		 * (Utils.isElementDisplayed_clickIfNeeded(1000, driver,
		 * "//input[@name='paymentType']", false, false)) {
		 * Utils.clickByXpath(driver, "//input[@name='paymentType']");
		 * commonElementsFactory.chooseAnOptionByName("Regular"); }
		 */
	}

	public void i_select_a_funding_account_for_the_chosen_account() throws Throwable {
		paymentFactory.choose_theFirstFundingAccount("customer");
		// if (Utils.isElementDisplayed_clickIfNeeded(0, driver,
		// "//input[@name='cvv']", true, false)) {
		// Utils.clearAndEnter(driver, "//input[@name='cvv']", "123");
	}
	// try {
	// Utils.clearAndEnter(driver, "//input[@name='cvv']", "123");
	// } catch (NoSuchElementException ex) {
	// System.out.println("no cvv field found");
	// }
	// }

	public void the_payment_submitted_confirmation_window_should_show_customer_level() throws Throwable {
		// click the OK button in the confirmation window. Sometimes it takes
		// longer than implicit time for the window to show up
		// so give it another chance (essentially, give it another period of
		// implicit time)
		try {
			Utils.clickByXpath(getDriver(),
					"//label[text()='Update payment accepted successfully.' or text()='The payments above were submitted successfully.']//following::button[text()='OK']");
		} catch (NoSuchElementException ex) {
			Utils.clickByXpath(getDriver(),
					"//label[text()='Update payment accepted successfully.' or text()='The payments above were submitted successfully.']//following::button[text()='OK']");
		}
	}
}
