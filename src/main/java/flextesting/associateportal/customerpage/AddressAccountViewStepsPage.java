package flextesting.associateportal.customerpage;


import com.qa.base.TestBase;
import flextesting.associateportal.defaultdata.ContactAndNoteData;
import flextesting.client.ClientProvider;
import flextesting.client.ScenarioInfo;
import flextesting.pagefactories.CommonElementsFactory;
import flextesting.pagefactories.associateportalAccountView.customerpage.AddressFactoryAccountView;
import flextesting.utilities.DataUtil;
import flextesting.utilities.Utils;
import org.openqa.selenium.NoSuchElementException;

public class AddressAccountViewStepsPage extends TestBase {

	private AddressFactoryAccountView addressFactoryAccountView;
	private CommonElementsFactory commonElementsFactory;
	private String addressType = null;


	public void i_add_an_address_for_a_responsible_party_for_Account_view() throws Throwable {
		addressFactoryAccountView.click_Address();
		addressFactoryAccountView.click_Add_tab_Address();
		addressFactoryAccountView.window_AddAddress();
		addressFactoryAccountView.choose_AddressType_Other();
		addressType = "Other Address";
		addressFactoryAccountView.enter_AddressLine1(ContactAndNoteData.getAddressLine1(addressType));
		addressFactoryAccountView.enter_AddressLine2(ContactAndNoteData.getAddressLine2(addressType));
		addressFactoryAccountView.choose_Country_US();
		addressFactoryAccountView.choose_State_Delaware();
		addressFactoryAccountView.enter_Zipcode("19713");
		addressFactoryAccountView.enter_City("Newark");
		addressFactoryAccountView.click_Update_window_AddAddress();
		addressFactoryAccountView.click_Update_window_PropagateAddress();
	}

	
	public void the_address_is_added_for_Account_view() throws Throwable {
		addressFactoryAccountView.message_UpdateAddress_OK();
	}
	
	
	public void i_update_an_address_for_a_responsible_party_for_Account_view() throws Throwable {
		addressFactoryAccountView.click_Address();
		addressFactoryAccountView.choose_CurrentAddressRecords_OtherAddress(ContactAndNoteData.getAddressLine1(addressType));
		addressFactoryAccountView.click_Update_tab_Address();
		addressFactoryAccountView.window_UpdateAddress();
		addressFactoryAccountView.enter_AddressLine1(ContactAndNoteData.getNewAddressLine1(addressType));
//		addressFactory.enter_AddressLine2(AddressEmailPhone.getNewAddressLine("2"));
		addressFactoryAccountView.choose_Country_US();
		addressFactoryAccountView.choose_State_Alaska();
		addressFactoryAccountView.enter_Zipcode("87654");
		addressFactoryAccountView.enter_City("GreatCity");
		addressFactoryAccountView.click_Update_window_UpdateAddress();
		addressFactoryAccountView.click_Update_window_PropagateAddress();
	}

	
	public void the_address_is_updated_for_Account_view() throws Throwable {
		addressFactoryAccountView.message_UpdateAddress_OK();
	}
	
	
	public void i_delete_an_address_for_a_responsible_party_for_Account_view() throws Throwable {
		addressFactoryAccountView.click_Address();
		addressFactoryAccountView.choose_CurrentAddressRecords_OtherAddress(ContactAndNoteData.getNewAddressLine1(addressType));
		addressFactoryAccountView.click_Delete_tab_Address();
		addressFactoryAccountView.confirmation_DeleteAddress_Yes();
	}

	
	public void the_address_is_deleted_for_Account_view() throws Throwable {
		//TODO
	}

	
	public void i_select_as_the_Address_Type_for_Account_view(String addressType) throws Throwable {
		this.addressType = addressType;
		commonElementsFactory.arrowTrigger("Type:");
		commonElementsFactory.chooseAnOptionByName(addressType);
	}

	
	public void i_enter_an_Address_Line_1_in_the_Add_Address_window_for_Account_view() throws Throwable {
		addressFactoryAccountView.enter_AddressLine1(ContactAndNoteData.getAddressLine1(addressType));
	}

	
	public void i_enter_an_Address_Line_2_in_the_Add_Address_window_for_Account_view() throws Throwable {
		addressFactoryAccountView.enter_AddressLine2(ContactAndNoteData.getAddressLine2(addressType));
	}

	
	public void i_select_as_the_Country_in_the_Add_Address_window_for_Account_view(String country) throws Throwable {
		commonElementsFactory.arrowTrigger("Country:");
//		Thread.sleep(4000);
//		Utils.clickByXpath(driver, "(//li[@role='option'])[1]");
		try {
			commonElementsFactory.chooseAnOptionByName(country);
		} catch (NoSuchElementException ex) {
//			System.out.println(country + " does not exist. choose the first one instead");
//			Utils.clickByXpath(driver, "(//li[@role='option'])[1]");
//			commonElementsFactory.chooseAnOptionByIndex(1);
			commonElementsFactory.chooseAnOptionByName("United Kingdom");
		}
	}

	
	public void i_select_as_the_State_in_the_Add_Address_window_for_Account_view(String state) throws Throwable {
		if (ClientProvider.getCode().equals("FFNPERF") && ScenarioInfo.getTags().contains("@ExternalEntityRole")) {
			Utils.clearAndEnter(getDriver(), "//input[@name='otherProvince']", DataUtil.getRandomChars());
		} else {
			commonElementsFactory.arrowTrigger("State/Province:");
			try {
				commonElementsFactory.chooseAnOptionByName(state);
			} catch (NoSuchElementException ex) {
//				System.out.println(country + " does not exist. choose the first one instead");
//				commonElementsFactory.chooseAnOptionByIndex(1);
				commonElementsFactory.chooseAnOptionByName("N/A");
			}	
		}
	}

	
	public void i_enter_a_Postal_Code_in_the_Add_Address_window_for_Account_view() throws Throwable {
//		addressFactory.enter_Zipcode("19713");
		addressFactoryAccountView.enter_Zipcode(DataUtil.getRandomNumberNotContainingZero(5));
	}

	
	public void i_enter_a_City_in_the_Add_Address_window_for_Account_view() throws Throwable {
//		addressFactory.enter_City("Newark");
		addressFactoryAccountView.enter_City(DataUtil.getRandomCharsByLength(6));
	}

	
	public void i_click_the_Update_button_in_the_Add_Address_window_for_Account_view() throws Throwable {
		//wait 1 sec for the button to be no longer grayed-out
		Thread.sleep(1000);
		Utils.clickByXpath(getDriver(), "(//label[text()='City:']//following::button[text()='Update'])[1]");
	}

	
	public boolean i_should_see_the_address_created_for_Account_view() throws Throwable {
		return Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), "//div[text()='"+ContactAndNoteData.getAddressLine1(addressType)+"']", true, false);
	}

	
	public void i_select_the_address_for_Account_view() throws Throwable {
		Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), "//div[text()='"+ContactAndNoteData.getAddressLine1(addressType)+"']", true, true);
	}


	public void i_enter_an_new_Address_Line_1_in_the_Update_Address_window_for_Account_view() throws Throwable {
		addressFactoryAccountView.enter_AddressLine1(ContactAndNoteData.getNewAddressLine1(addressType));
	}
	

	public boolean i_should_see_the_address_updated_for_Account_view() throws Throwable {
		return Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), "//div[text()='"+ContactAndNoteData.getNewAddressLine1(addressType)+"']", true, false);
	}


	public void i_select_the_updated_address_for_Account_view() throws Throwable {
		Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), "//div[text()='"+ContactAndNoteData.getNewAddressLine1(addressType)+"']", true, true);
	}
	
	public boolean i_should_see_the_address_deleted_for_Account_view() throws Throwable {
		//check if the address is in the history table 
		String xpath = "//div[contains(text(),'"+ContactAndNoteData.getNewAddressLine1(addressType)+"')]//ancestor::div[contains(@id,'gp-historical-true-bd')]";
		return Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), xpath, true, false);
	}
}
