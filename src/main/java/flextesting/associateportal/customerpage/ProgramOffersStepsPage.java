package flextesting.associateportal.customerpage;


import com.qa.base.TestBase;
import flextesting.associateportal.defaultdata.FundingAccountData;
import flextesting.pagefactories.CommonElementsFactory;
import flextesting.pagefactories.associateportal.customerpage.FundingAccountFactory;
import flextesting.pagefactories.associateportal.customerpage.ProgramOffersFactory;
import org.junit.Assert;

public class ProgramOffersStepsPage extends TestBase {

	private ProgramOffersFactory programOffersFactory;
	private FundingAccountFactory fundingAccountFactory;
	private CommonElementsFactory commonElementsFactory;
	private boolean accountLevel = true;
	private String accountType = "BankAccount";

	public void i_click_the_Offers_icon_at_account_level() throws Throwable {
		accountLevel = true;
		programOffersFactory.click_OffersIcon_Level_Account();

	}
	
	public void i_double_click_the_any_available_Offer() throws Throwable {
		programOffersFactory.double_Click_The_Any_AvailableOffer();
	}
	
	public void i_click_the_Next_Button() throws Throwable {
		   programOffersFactory.click_The_Next_Button();
	}
	
	
	public void i_Create_new_card_account_form_Add_New_funding_account_Dropdown() throws Throwable {
		programOffersFactory.clickOnAddNewFundingAccountDropDown();
		programOffersFactory.click_NewCardAccount();
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
		programOffersFactory.select_The_Any_Account_FromList();
		programOffersFactory.clickOnFundingAccountDropDown();
		programOffersFactory.clickFundingAccountItem();
	}

	public void i_Click_on_Use_This_For_All_button_to_select_the_funding_account_for_all_payments() throws Throwable {
	  programOffersFactory.clickOnUseThisForAllButton();
	}

	public void i_Click_on_Accept_Program_and_Offer_will_be_accepted() throws Throwable {
		programOffersFactory.clickOnAcceptProgram();
		Assert.assertTrue(programOffersFactory.verifyThatProgramAccepted().contains("Accepted"));
	}
	
	public void i_Select_Accepted_Program_Offer_and_click_on_Cancel_Accepted_Offer_button() throws Throwable {
	    programOffersFactory.clickOnAcceptedProgramOffer();
	    programOffersFactory.clickOnCancelAcceptedOfferButton();
	    programOffersFactory.clickOnYesButton();
	    programOffersFactory.clickOnOkButton();
	    Assert.assertTrue(programOffersFactory.verifyThatProgramAccepted().contains("Cancelled"));
	}
	
    public void i_again_double_click_the_same_available_Offer() throws Throwable {
	    programOffersFactory.again_Double_Click_The_Same_AvailableOffer();
	}
    
    public void i_Select_any_one_payment() throws Throwable {
    	programOffersFactory.select_The_Any_Account_FromList(); 
	}
    
	public void i_click_the_Payment_tab() throws Throwable {
	    programOffersFactory.i_click_the_Payment_tab();
	}

	public void i_Select_any_one_payment_and_click_on_Update_Payment_button() throws Throwable {
	    programOffersFactory.i_Select_any_one_payment_and_click_on_Update_Payment_button();
	}
	
	public void i_Update_Payment_Date_day_from_today(int arg1) throws Throwable {
	   programOffersFactory.i_Update_Payment_Date_day_from_today(arg1);
	}

	public void i_Update_Payment_Amount() throws Throwable {
	    programOffersFactory.i_Update_Payment_Amount();
	}

	public void i_click_the_Submit_and_Ok_Button() throws Throwable {
	   programOffersFactory.i_click_the_Submit_and_Ok_Button();
	}
	
	public void i_Select_any_one_payment_and_click_on_Delete_Payment_button() throws Throwable {
	    programOffersFactory.i_Select_any_one_payment_and_click_on_Delete_Payment_button();
	    programOffersFactory.clickOnYesButton();
	    programOffersFactory.clickOnOkButton();
	}

//	public void payment_will_be_deleted() throws Throwable {
//		Assert.assertTrue(programOffersFactory.verifyThatPaymentDeleted().contains("Deleted"));
//	}
	
    public void if_funding_account_is_available_in_funding_account_fields_then_select_one_and_accept_program_other_wise_create_new_card_account() throws Throwable {
    	String fundingAccount = programOffersFactory.get_FundingAccount_Is_Available();
		System.out.println("field value " + fundingAccount);
		Assert.assertTrue(programOffersFactory.get_FundingAccount_Is_Available().contains(fundingAccount));
		if (fundingAccount.isEmpty()) {
			programOffersFactory.clickOnAddNewFundingAccountDropDown();
			programOffersFactory.click_NewCardAccount();
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
			programOffersFactory.select_The_Any_Account_FromList();
			programOffersFactory.clickOnAcceptProgram();
			Assert.assertTrue(programOffersFactory.verifyThatProgramAccepted().contains("Accepted"));
		}else {
			programOffersFactory.clickOnAcceptProgram();
			Assert.assertTrue(programOffersFactory.verifyThatProgramAccepted().contains("Accepted"));
		}
	}

}
