package flextesting.associateportal.customerpage;


import com.qa.base.TestBase;
import flextesting.associateportal.defaultdata.FundingAccountData;
import flextesting.pagefactories.CommonElementsFactory;
import flextesting.pagefactories.associateportal.customerpage.FundingAccountFactory;
import flextesting.pagefactories.associateportalAccountView.customerpage.ProgramOffersFactoryAccountView;
import org.junit.Assert;

public class ProgramOffersStepsPageAccountView extends TestBase {

	private ProgramOffersFactoryAccountView programOffersFactoryAccountView;
	private FundingAccountFactory fundingAccountFactory;
	private CommonElementsFactory commonElementsFactory;
	private boolean accountLevel = true;
	private String accountType = "BankAccount";

	public void i_click_the_Offers_icon_at_account_level() throws Throwable {
		accountLevel = true;
		programOffersFactoryAccountView.click_OffersIcon_Level_Account();

	}
	
	public void i_double_click_the_any_available_Offer() throws Throwable {
		programOffersFactoryAccountView.double_Click_The_Any_AvailableOffer();
	}
	
	public void i_click_the_Next_Button() throws Throwable {
		   programOffersFactoryAccountView.click_The_Next_Button();
	}
	
	
	public void i_Create_new_card_account_form_Add_New_funding_account_Dropdown() throws Throwable {
		programOffersFactoryAccountView.clickOnAddNewFundingAccountDropDown();
		programOffersFactoryAccountView.click_NewCardAccount();
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
		fundingAccountFactory.check_SaveThisAccountForFuturePayments();
		fundingAccountFactory.click_Next_window_AddNewCardAccount();
		fundingAccountFactory.click_Submit_window_AddNewCardAccount();
		fundingAccountFactory.present_NewCardAddedConfirmation();
	}

	public void i_Select_any_one_payment_and_click_on_Funding_Account_dropdown_for_selection_and_select_the_created_funding_account() throws Throwable {
		programOffersFactoryAccountView.select_The_Any_Account_FromList();
		programOffersFactoryAccountView.clickOnFundingAccountDropDown();
		programOffersFactoryAccountView.clickFundingAccountItem();
	}

	public void i_Click_on_Use_This_For_All_button_to_select_the_funding_account_for_all_payments() throws Throwable {
	  programOffersFactoryAccountView.clickOnUseThisForAllButton();
	}

	public void i_Click_on_Accept_Program_and_Offer_will_be_accepted() throws Throwable {
		programOffersFactoryAccountView.clickOnAcceptProgram();
		Assert.assertTrue(programOffersFactoryAccountView.verifyThatProgramAccepted().contains("Accepted"));
	}
	
	public void i_Select_Accepted_Program_Offer_and_click_on_Cancel_Accepted_Offer_button() throws Throwable {
	    programOffersFactoryAccountView.clickOnAcceptedProgramOffer();
	    programOffersFactoryAccountView.clickOnCancelAcceptedOfferButton();
	    programOffersFactoryAccountView.clickOnYesButton();
	    programOffersFactoryAccountView.clickOnOkButton();
	    Assert.assertTrue(programOffersFactoryAccountView.verifyThatProgramAccepted().contains("Cancelled"));
	}
	
    public void i_again_double_click_the_same_available_Offer() throws Throwable {
	    programOffersFactoryAccountView.again_Double_Click_The_Same_AvailableOffer();
	}
    
    public void i_Select_any_one_payment() throws Throwable {
    	programOffersFactoryAccountView.select_The_Any_Account_FromList();
	}
    
	public void i_click_the_Payment_tab() throws Throwable {
	    programOffersFactoryAccountView.i_click_the_Payment_tab();
	}

	public void i_Select_any_one_payment_and_click_on_Update_Payment_button() throws Throwable {
	    programOffersFactoryAccountView.i_Select_any_one_payment_and_click_on_Update_Payment_button();
	}
	
	public void i_Update_Payment_Date_day_from_today(int arg1) throws Throwable {
	   programOffersFactoryAccountView.i_Update_Payment_Date_day_from_today(arg1);
	}

	public void i_Update_Payment_Amount() throws Throwable {
	    programOffersFactoryAccountView.i_Update_Payment_Amount();
	}

	public void i_click_the_Submit_and_Ok_Button() throws Throwable {
	   programOffersFactoryAccountView.i_click_the_Submit_and_Ok_Button();
	}
	
	public void i_Select_any_one_payment_and_click_on_Delete_Payment_button() throws Throwable {
	    programOffersFactoryAccountView.i_Select_any_one_payment_and_click_on_Delete_Payment_button();
	    programOffersFactoryAccountView.clickOnYesButton();
	    programOffersFactoryAccountView.clickOnOkButton();
	}

//	public void payment_will_be_deleted() throws Throwable {
//		Assert.assertTrue(programOffersFactoryAccountView.verifyThatPaymentDeleted().contains("Deleted"));
//	}
	
    public void if_funding_account_is_available_in_funding_account_fields_then_select_one_and_accept_program_other_wise_create_new_card_account() throws Throwable {
    	String fundingAccount = programOffersFactoryAccountView.get_FundingAccount_Is_Available();
		System.out.println("field value " + fundingAccount);
		Assert.assertTrue(programOffersFactoryAccountView.get_FundingAccount_Is_Available().contains(fundingAccount));
		if (fundingAccount.isEmpty()) {
			programOffersFactoryAccountView.clickOnAddNewFundingAccountDropDown();
			programOffersFactoryAccountView.click_NewCardAccount();
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
			fundingAccountFactory.check_SaveThisAccountForFuturePayments();
			fundingAccountFactory.click_Next_window_AddNewCardAccount();
			fundingAccountFactory.click_Submit_window_AddNewCardAccount();
			fundingAccountFactory.present_NewCardAddedConfirmation();
			programOffersFactoryAccountView.select_The_Any_Account_FromList();
			programOffersFactoryAccountView.clickOnAcceptProgram();
			Assert.assertTrue(programOffersFactoryAccountView.verifyThatProgramAccepted().contains("Accepted"));
		}else {
			programOffersFactoryAccountView.clickOnAcceptProgram();
			Assert.assertTrue(programOffersFactoryAccountView.verifyThatProgramAccepted().contains("Accepted"));
		}
	}

}
