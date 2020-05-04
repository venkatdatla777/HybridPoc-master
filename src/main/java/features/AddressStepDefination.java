package features;


import features.steps.serenity.AddressStep;

public class AddressStepDefination {


	AddressStep addressStep;
	
	public void i_add_an_address_for_a_responsible_party() throws Throwable {
		addressStep.i_add_an_address_for_a_responsible_party();
	}

	public void the_address_is_added() throws Throwable {
		addressStep.the_address_is_added();
	}
	
	public void i_update_an_address_for_a_responsible_party() throws Throwable {
		addressStep.i_update_an_address_for_a_responsible_party();
	}

	public void the_address_is_updated() throws Throwable {
		addressStep.the_address_is_updated();
	}
	
	public void i_delete_an_address_for_a_responsible_party() throws Throwable {
		addressStep.i_delete_an_address_for_a_responsible_party();
	}

	public void the_address_is_deleted() throws Throwable {
		addressStep.the_address_is_deleted();
	}

	public void i_select_as_the_Type(String addressType) throws Throwable {
		addressStep.i_select_as_the_Type(addressType);
	}

	public void i_enter_an_Address_Line_1_in_the_Add_Address_window() throws Throwable {
		addressStep.i_enter_an_Address_Line_1_in_the_Add_Address_window();
	}

	public void i_enter_an_Address_Line_2_in_the_Add_Address_window() throws Throwable {
		addressStep.i_enter_an_Address_Line_2_in_the_Add_Address_window();
	}

	public void i_select_as_the_Country_in_the_Add_Address_window(String country) throws Throwable {
		addressStep.i_select_as_the_Country_in_the_Add_Address_window(country);
	}

	public void i_select_as_the_State_in_the_Add_Address_window(String state) throws Throwable {
		addressStep.i_select_as_the_State_in_the_Add_Address_window(state);
	}

	public void i_enter_a_Postal_Code_in_the_Add_Address_window() throws Throwable {
		addressStep.i_enter_a_Postal_Code_in_the_Add_Address_window();
	}

	public void i_enter_a_City_in_the_Add_Address_window() throws Throwable {
		addressStep.i_enter_a_City_in_the_Add_Address_window();
	}

	public void i_click_the_Update_button_in_the_Add_Address_windown() throws Throwable {
		addressStep.i_click_the_Update_button_in_the_Add_Address_windown();
	}

	public void i_should_see_the_address_created() throws Throwable {
		addressStep.i_should_see_the_address_created();
	}

	public void i_select_the_address() throws Throwable {
		addressStep.i_select_the_address();
	}

	public void i_enter_an_new_Address_Line_1_in_the_Add_Address_window() throws Throwable {
		addressStep.i_enter_an_new_Address_Line_1_in_the_Add_Address_window();
	}
	
	public void i_should_see_the_address_updated() throws Throwable {
		addressStep.i_should_see_the_address_updated();
	}

	public void i_select_the_updated_address() throws Throwable {
		addressStep.i_select_the_updated_address();
	}
	
	public void i_should_see_the_address_deleted() throws Throwable {
		addressStep.i_should_see_the_address_deleted();
	}
	
}
