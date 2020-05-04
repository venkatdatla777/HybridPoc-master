package flextesting.associateportal.customerpage;


import com.qa.base.TestBase;
import flextesting.client.ClientProvider;
import flextesting.pagefactories.CommonElementsFactory;
import flextesting.utilities.DataUtil;
import flextesting.utilities.Utils;
import org.apache.log4j.Logger;

public class PhoneAccountViewStepsPage extends TestBase {
	static Logger log = Logger.getLogger(PhoneAccountViewStepsPage.class);
	private CommonElementsFactory commonElementsFactory;
	private String[] phoneInfo = ClientProvider.getClient().getPhoneInfoFromDB();
	private String phoneNumber = phoneInfo[2];
	private String randomExtension;
	
	/*
	public PhoneSteps() {
		this.phoneInfo = ClientProvider.getClient().getPhoneInfoFromDB();
		log.debug("Phone Info Retrieved from DB: Phone Type | Country Code | Phone # : " + Arrays.toString(phoneInfo));
		phoneNumber = phoneInfo[2];
	}
	*/
	
	private String getPhoneNumberIdentifier() {
		return "//*[(self::div or self::span) and (contains(text(),' - "+randomExtension+"'))]";
	}

//	@When("^I select \"([^\"]*)\" as the Phone Number Type$")
//	public void i_select_as_the_Phone_Number_Type(String arg1) throws Throwable {
	
	public void i_select_a_Phone_Number_Type_for_Account_view() throws Throwable {
		Thread.sleep(2000);
		commonElementsFactory.arrowTrigger("Type:");
		String phoneType = Utils.splitCamelCase(phoneInfo[0]);
		log.debug("Phone Type retrieved from DB: " + phoneType);
		commonElementsFactory.chooseAnOptionByName(phoneType);
	}
	
	public void i_select_a_country_code_for_Account_view() throws Throwable {
		String xpathCountryCodeField = "//input[@name='telephoneCountryCode']//following-sibling::input";
		if (Utils.findAllVisibleOnes(getDriver(), xpathCountryCodeField).size() != 0) {
			Utils.clearAndEnter(getDriver(), xpathCountryCodeField, "+"+phoneInfo[1]);
			//press delete key to get rid of the auto completed part (press the key too soon might not working)
			Thread.sleep(2000);
			Utils.pressDeleteKey(getDriver());
			//press the escape key to get rid of the dropdown menu
			Utils.pressEscapeKey(getDriver());
		}
	}

	
	public void i_enter_an_Phone_Number_for_Account_view() throws Throwable {
//		Utils.clearAndEnter(getDriver(), "//input[(@name='phoneNumber') or (@name='maskPhoneNumber')]", ClientProvider.getClient().getRandomPhoneNumber());
		Utils.clearAndEnter(getDriver(), "//input[(@name='phoneNumber') or (@name='maskPhoneNumber')]", phoneNumber);
	}

	
	public void i_enter_an_Phone_Number_Extension_for_Account_view() throws Throwable {
		//currently, the extension change can not be propagated, so as a temporary way to trigger the propagation
		//we change the last digit of the phone number
		changeLastDigitOfPhoneNumber();
		Utils.clearAndEnter(getDriver(), "//input[(@name='phoneNumber') or (@name='maskPhoneNumber')]", phoneNumber);
		//now enter the extension
		randomExtension = DataUtil.getRandomNumberNotContainingZero(5);
		Utils.clearAndEnter(getDriver(), "//input[@name='extension']", randomExtension); 
		Thread.sleep(4000);
	}
	
	private void changeLastDigitOfPhoneNumber() {
		int length = phoneNumber.length();
		int lastNumber = Character.getNumericValue(phoneNumber.charAt(length - 1));
		lastNumber = lastNumber == 2 ? 0 : 2; //change the last digit
		phoneNumber = phoneNumber.substring(0, length-1) + lastNumber;	
	}

	
	public void i_select_for_the_Express_Consent_Call_for_Account_view(String arg1) throws Throwable {
		commonElementsFactory.arrowTriggerAccountView("Express Consent (Call):");
		commonElementsFactory.chooseAnOptionByName(arg1);
	}
	
	
	public void i_select_for_the_Express_Consent_SMS_for_Account_view(String arg1) throws Throwable {
		commonElementsFactory.arrowTriggerAccountView("Express Consent (SMS):");
		commonElementsFactory.chooseAnOptionByName(arg1);
	}

	
	public void i_click_the_Update_button_in_the_Update_Phone_Number_windown_for_Account_view() throws Throwable {
//		Utils.clickByXpath(driver, "//input[(@name='phoneNumber') or (@name='maskPhoneNumber')]");
		//wait 1 sec for the button to be no longer grayed-out
		Thread.sleep(1000);
		Utils.clickByXpath(getDriver(), "(//label[text()='Express Consent (SMS):']//following::button[text()='Update'])[1]");
		
		//the following CDRP button only exists in some clients. e.g. TDC
		String xpathOfCDRP = "//button[text()='Confirm Disclosure Read & Proceed']";
		if (Utils.isElementDisplayed_clickIfNeeded(3000, getDriver(), xpathOfCDRP, false, false))
			Utils.clickByXpath(getDriver(), xpathOfCDRP);
	}

	
	public boolean i_should_see_the_phone_updated_for_Account_view() throws Throwable {
		return Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), getPhoneNumberIdentifier(), true, false);
	}

	
	public void i_select_the_phone_number_for_Account_view() throws Throwable {
		Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), getPhoneNumberIdentifier(), true, true);
	}

	
	public boolean i_should_see_the_phone_number_deleted_for_Account_view() throws Throwable {
		//check if the phone is in the history table 
//		String xpath = "//*[(self::div or self::span) and contains(text(),'"+DataUtil.getRandomNumber()+"')]//ancestor::div[contains(@id,'gp-historical-true-bd')]";
		String xpath = getPhoneNumberIdentifier()+"//ancestor::div[contains(@id,'gp-historical-true-bd')]";
		return Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), xpath, true, false);
	}
	
	
}
