package features.steps.serenity;


import flextesting.associateportal.customerpage.AddressAccountViewStepsPage;
import org.junit.Assert;

public class AddressAccountViewStep {

	AddressAccountViewStepsPage addressAccountViewStepsPage;

	public void i_add_an_address_for_a_responsible_party_for_Account_view() throws Throwable {
		addressAccountViewStepsPage.i_add_an_address_for_a_responsible_party_for_Account_view();
	}

	public void the_address_is_added_for_Account_view() throws Throwable {
		addressAccountViewStepsPage.the_address_is_added_for_Account_view();
	}

	public void i_update_an_address_for_a_responsible_party_for_Account_view() throws Throwable {
		addressAccountViewStepsPage.i_update_an_address_for_a_responsible_party_for_Account_view();
	}

	public void the_address_is_updated_for_Account_view() throws Throwable {
		addressAccountViewStepsPage.the_address_is_updated_for_Account_view();
	}

	public void i_delete_an_address_for_a_responsible_party_for_Account_view() throws Throwable {
		addressAccountViewStepsPage.i_delete_an_address_for_a_responsible_party_for_Account_view();
	}

	public void the_address_is_deleted_for_Account_view() throws Throwable {
		addressAccountViewStepsPage.the_address_is_deleted_for_Account_view();
	}

	public void i_select_as_the_Address_Type_for_Account_view(String addressType) throws Throwable {
		addressAccountViewStepsPage.i_select_as_the_Address_Type_for_Account_view(addressType);
	}

	public void i_enter_an_Address_Line_1_in_the_Add_Address_window_for_Account_view() throws Throwable {
		addressAccountViewStepsPage.i_enter_an_Address_Line_1_in_the_Add_Address_window_for_Account_view();
	}

	public void i_enter_an_Address_Line_2_in_the_Add_Address_window_for_Account_view() throws Throwable {
		addressAccountViewStepsPage.i_enter_an_Address_Line_2_in_the_Add_Address_window_for_Account_view();
	}

	public void i_select_as_the_Country_in_the_Add_Address_window_for_Account_view(String country) throws Throwable {
		addressAccountViewStepsPage.i_select_as_the_Country_in_the_Add_Address_window_for_Account_view(country);
	}

	public void i_select_as_the_State_in_the_Add_Address_window_for_Account_view(String state) throws Throwable {
		addressAccountViewStepsPage.i_select_as_the_State_in_the_Add_Address_window_for_Account_view(state);
	}


	public void i_enter_a_Postal_Code_in_the_Add_Address_window_for_Account_view() throws Throwable {
		addressAccountViewStepsPage.i_enter_a_Postal_Code_in_the_Add_Address_window_for_Account_view();
	}


	public void i_enter_a_City_in_the_Add_Address_window_for_Account_view() throws Throwable {
		addressAccountViewStepsPage.i_enter_a_City_in_the_Add_Address_window_for_Account_view();
	}

	public void i_click_the_Update_button_in_the_Add_Address_window_for_Account_view() throws Throwable {
		addressAccountViewStepsPage.i_click_the_Update_button_in_the_Add_Address_window_for_Account_view();
	}

	public void i_should_see_the_address_created_for_Account_view() throws Throwable {
		Assert.assertTrue(addressAccountViewStepsPage.i_should_see_the_address_created_for_Account_view());
	}

	public void i_select_the_address_for_Account_view() throws Throwable {
		addressAccountViewStepsPage.i_select_the_address_for_Account_view();
	}

	public void i_enter_an_new_Address_Line_1_in_the_Update_Address_window_for_Account_view() throws Throwable {
		addressAccountViewStepsPage.i_enter_an_new_Address_Line_1_in_the_Update_Address_window_for_Account_view();
	}

	public void i_should_see_the_address_updated_for_Account_view() throws Throwable {
		Assert.assertTrue(addressAccountViewStepsPage.i_should_see_the_address_updated_for_Account_view());
	}

	public void i_select_the_updated_address_for_Account_view() throws Throwable {
		addressAccountViewStepsPage.i_select_the_updated_address_for_Account_view();
	}

	public void i_should_see_the_address_deleted_for_Account_view() throws Throwable {
		Assert.assertTrue(addressAccountViewStepsPage.i_should_see_the_address_deleted_for_Account_view());
	}
}
