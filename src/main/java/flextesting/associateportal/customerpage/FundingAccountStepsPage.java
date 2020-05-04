package flextesting.associateportal.customerpage;


import flextesting.associateportal.defaultdata.FundingAccountData;
import flextesting.pagefactories.CommonElementsFactory;
import flextesting.pagefactories.associateportal.customerpage.FundingAccountFactory;
import flextesting.utilities.RetrieveDataFromDB;
import flextesting.utilities.Utils;

import java.util.List;

import static com.qa.base.TestBase.getDriver;
import static flextesting.utilities.Utils.*;


public class FundingAccountStepsPage {

	private FundingAccountFactory fundingAccountFactory;
	private CommonElementsFactory commonElementsFactory;

	public void i_click_Manage_Funding_Account() throws Throwable {
		fundingAccountFactory.click_ManageFundingAccount();
	}

	public void i_click_New_Card_Account() throws Throwable {
		fundingAccountFactory.click_NewCardAccount();
	}

	public void i_complete_the_form_in_the_Add_New_Card_Account_window() throws Throwable {
		fundingAccountFactory.enter_AccountNickName(FundingAccountData.CARD_ACCOUNT.get("Account Nick Name"));
		fundingAccountFactory.choose_CreditDebit(FundingAccountData.CARD_ACCOUNT.get("Credit/Debit"));
		fundingAccountFactory.choose_CardType(FundingAccountData.CARD_ACCOUNT.get("Card Type"));
		fundingAccountFactory.enter_CardNumber(FundingAccountData.CARD_ACCOUNT.get("Card Number"));
		fundingAccountFactory.enter_CardHolderFullName(FundingAccountData.CARD_ACCOUNT.get("Card Holder Full Name"));
		fundingAccountFactory.pick_ExpirationDate(FundingAccountData.CARD_ACCOUNT.get("Expiration Date"));
		fundingAccountFactory.enter_AddressLine1(FundingAccountData.CARD_ACCOUNT.get("Address Line 1"));
		fundingAccountFactory.enter_City(FundingAccountData.CARD_ACCOUNT.get("City"));
		fundingAccountFactory.enter_State(FundingAccountData.CARD_ACCOUNT.get("State"));
		fundingAccountFactory.enter_ZipCode(FundingAccountData.CARD_ACCOUNT.get("Zip Code"));
	}

	public void i_check_Save_this_account_for_future_payments() throws Throwable {
		fundingAccountFactory.check_SaveThisAccountForFuturePayments();
	}

	public void i_click_Next_button_in_the_Add_New_Card_Account_window() throws Throwable {
		fundingAccountFactory.click_Next_window_AddNewCardAccount();
	}

	public void i_click_Submit_button_in_the_Add_New_Card_Account_window() throws Throwable {
		fundingAccountFactory.click_Submit_window_AddNewCardAccount();
	}

	public void i_should_see_the_new_card_added_confirmation_window() throws Throwable {
		fundingAccountFactory.present_NewCardAddedConfirmation();
	}

	public void i_select_the_card_in_Manage_Funding_Accounts_window() throws Throwable {
		fundingAccountFactory.select_NewlyAddedCard();
	}

	public void i_click_Remove_Funding_Account() throws Throwable {
		fundingAccountFactory.click_RemoveFundingAccount();
	}

	public void i_click_Yes_in_the_Delete_Funding_Account_window() throws Throwable {
		fundingAccountFactory.click_Yes_window_DeleteFundingAccount();
	}

	public void i_should_see_the_funding_account_deleted_confirmation() throws Throwable {
		fundingAccountFactory.click_OK_message_FundingAccountDeleted();
	}

	// Back_account
	public void i_click_New_Bank_Account() throws Throwable {
		clickByXpath(getDriver(), "//button[text()='New Bank Account']");
	}

	public void i_enter_an_Account_Nick_Name() throws Throwable {
		clearAndEnter(getDriver(), "//input[@name='nickName' and @type='text']", FundingAccountData.getNickName());
	}

	public void i_select_as_the_Bank_Account_Type(String accountType) throws Throwable {
		commonElementsFactory.arrowTrigger("Bank Account Type:");
		commonElementsFactory.chooseAnOptionByName(accountType);
	}

	public void i_enter_a_valid_Routing_Number() throws Throwable {
		// Two rules to verify a routing number: 1. in DB, 2. pass the
		// verification method
		// However, if no routing number in DB, then should be able to enter any
		// valid routing number
		List<String> routingNumberList = FundingAccountData.getRoutingNumberList();
		if (routingNumberList.size() == 0) {
			// note the routing number 021000021 is only for US.
			String routingNumber = "021000021";
			List<String> result = RetrieveDataFromDB.getRows("select defaultCountry from Portfolio");
			String defaultCountry = "";
			if (result.size() > 0) {
				defaultCountry = result.get(0).split("\\|")[1];
			} // scope
			if (defaultCountry.equalsIgnoreCase("au")) {
				// if
				// (ClientProvider.getCode().equals("KFSQA")||ClientProvider.getCode().equals("TGAQA")){
				// note the routing number 565777 is only for Australia
				routingNumber = "565777";
			}
			clearAndEnter(getDriver(), "//input[@name='routingNumber' and @type='text']", routingNumber);
			// used to be like this: no routing # in DB => any routing number
			// entered is invalid. That's why we used to throw an exception
			// throw new NoRountingNumberFoundInDBException("No routing number
			// found in DB, can not proceed on adding bank account");
		} else {
			int i = 0;
			do {
				if (i < routingNumberList.size())
					clearAndEnter(getDriver(), "//input[@name='routingNumber' and @type='text']",
							routingNumberList.get(i++));
				else
					throw new RuntimeException(
							"Exhausted all routing numbers in the list. None of them is valid. Abort mission...");
			} while (isElementDisplayed_clickIfNeeded(2000, getDriver(),
					"//input[@name='routingNumber' and contains(@class,'x-form-invalid')]", false, false));
		}
	}

	public void i_enter_a_valid_Bank_Account_Number() throws Throwable {
		clearAndEnter(getDriver(), "//input[@name='fundingAccountNum']", FundingAccountData.getAccountNumber());
	}

	public void i_enter_the_Bank_Account_Holder_Full_Name() throws Throwable {
		clearAndEnter(getDriver(), "//input[@name='holderFullName' and @type='text']",
				FundingAccountData.getHolderFullName());
	}

	public boolean i_should_see_the_new_bank_account_added() throws Throwable {
		return Utils.isElementDisplayed_clickIfNeeded(0, getDriver(),
				"//div[text()='" + FundingAccountData.getNickName() + "']", true, false);
	}

	public void i_select_the_bank_account_in_the_Manage_Funding_Accounts_window() throws Throwable {
		isElementDisplayed_clickIfNeeded(0, getDriver(), "//div[text()='" + FundingAccountData.getNickName() + "']",
				true, true);
	}

	public boolean i_should_see_the_bank_account_removed() throws Throwable {
		return Utils.isElementDisplayed_clickIfNeeded(1000, getDriver(),
				"//div[text()='" + FundingAccountData.getNickName() + "']", false, false);
	}

}
