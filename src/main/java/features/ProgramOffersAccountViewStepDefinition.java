package features;


import features.steps.serenity.ProgramOffersStepAccountView;

public class ProgramOffersAccountViewStepDefinition {

    ProgramOffersStepAccountView programOffersStepAccountView;

   /* @When("^I click the Offers icon at account level for Account view$")
    public void i_click_the_Offers_icon_at_account_level_for_Account_view() throws Throwable {
        programOffersStepAccountView.i_click_the_Offers_icon_at_account_level();
    }*/

   //changing this to resolve the pending issue
    public void i_click_the_Offers_icon_for_Account_view_at_account_level() throws Throwable {
        programOffersStepAccountView.i_click_the_Offers_icon_at_account_level();
    }

    public void i_double_click_the_any_available_Offer_for_Account_view() throws Throwable {
        programOffersStepAccountView.i_double_click_the_any_available_Offer();
    }

    public void i_click_the_Next_Button_for_Account_view() throws Throwable {
        programOffersStepAccountView.i_click_the_Next_Button();
    }

    public void i_Create_new_card_account_form_Add_New_funding_account_Dropdown_for_Account_view() throws Throwable {
        programOffersStepAccountView.i_Create_new_card_account_form_Add_New_funding_account_Dropdown();
    }

    public void i_Select_any_one_payment_and_click_on_Funding_Account_dropdown_for_selection_and_select_the_created_funding_account_for_Account_view() throws Throwable {
        programOffersStepAccountView.i_Select_any_one_payment_and_click_on_Funding_Account_dropdown_for_selection_and_select_the_created_funding_account();
    }

    public void i_Click_on_Use_This_For_All_button_to_select_the_funding_account_for_all_payments_for_Account_view() throws Throwable {
        programOffersStepAccountView.i_Click_on_Use_This_For_All_button_to_select_the_funding_account_for_all_payments();
    }

    public void i_Click_on_Accept_Program_and_Offer_will_be_accepted_for_Account_view() throws Throwable {
        programOffersStepAccountView.i_Click_on_Accept_Program_and_Offer_will_be_accepted();
    }

    public void i_Select_Accepted_Program_Offer_and_click_on_Cancel_Accepted_Offer_button_for_Account_view() throws Throwable {
        programOffersStepAccountView.i_Select_Accepted_Program_Offer_and_click_on_Cancel_Accepted_Offer_button();
    }

    public void i_again_double_click_the_same_available_Offer_for_Account_view() throws Throwable {
        programOffersStepAccountView.i_again_double_click_the_same_available_Offer();
    }

    public void i_Select_any_one_payment_for_Account_view() throws Throwable {
        programOffersStepAccountView.i_Select_any_one_payment();
    }

    public void i_click_the_Payment_tab_for_Account_view() throws Throwable {
        programOffersStepAccountView.i_click_the_Payment_tab();
    }

    public void i_Select_any_one_payment_and_click_on_Update_Payment_button_for_Account_view() throws Throwable {
        programOffersStepAccountView.i_Select_any_one_payment_and_click_on_Update_Payment_button();
    }

    public void i_Update_Payment_Date_day_from_today_for_Account_view(int arg1) throws Throwable {
        programOffersStepAccountView.i_Update_Payment_Date_day_from_today(arg1);
    }

    public void i_Update_Payment_Amount_for_Account_view() throws Throwable {
        programOffersStepAccountView.i_Update_Payment_Amount();
    }

    public void i_click_the_Submit_and_Ok_Button_for_Account_view() throws Throwable {
        programOffersStepAccountView.i_click_the_Submit_and_Ok_Button();
    }

    public void i_Select_any_one_payment_and_click_on_Delete_Payment_button_for_Account_view() throws Throwable {
        programOffersStepAccountView.i_Select_any_one_payment_and_click_on_Delete_Payment_button();
    }

}
