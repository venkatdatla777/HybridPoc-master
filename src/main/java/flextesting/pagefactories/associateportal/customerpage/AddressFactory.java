package flextesting.pagefactories.associateportal.customerpage;

import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static flextesting.utilities.Utils.*;
import static org.junit.Assert.assertTrue;


public class AddressFactory extends TestBase {
	@FindBy(xpath="//li[@id='accountContactsId__addressTab']/child::a[2]")
	private WebElement btn_Address;
	
	@FindBy(xpath="//div[@class='x-grid-group-title' and contains(text(), 'Current') and contains(text(), 'Record')]")
	private WebElement element_CurrentRecord_tab_Address;

	//private By locator_text_CurrentRecord_tab_Address = By.xpath("//div[@class='x-grid-group-title' and contains(text(), 'Current') and contains(text(), 'Record')]");
	
	@FindBy(xpath="//table[@id='addContact']//button[text()='Add']")
	private WebElement btn_Add_tab_Address;

	@FindBy(xpath="//div[@id='addressForm']//descendant::label[text()='Type:']//following::img[1]")
	private WebElement dropdown_AddressType;

	@FindBy(xpath="//div[text()='Other Address' and contains(@class, 'x-combo-list-item')]")
	private WebElement option_AddressType_Other;

	@FindBy(name="address1")
	private WebElement field_AddressLine1;

	@FindBy(name="address2")
	private WebElement field_AddressLine2;

	@FindBy(xpath="//input[@name='country']//following-sibling::img")
	private WebElement dropdown_Country;

	@FindBy(xpath="//div[@id='updateAddress']//following::div[contains(@class,'x-combo-list-item') and text()='United States']")
	private WebElement option_Country_US;

	@FindBy(xpath="//input[@name='province']//following-sibling::img")
	private WebElement dropdown_States;

	@FindBy(xpath="//div[text()='Delaware']")
	private WebElement option_States_Delaware;

	@FindBy(xpath="//div[text()='Alaska']")
	private WebElement option_States_Alaska;

	@FindBy(name="postalCode")
	private WebElement field_Zipcode;

	@FindBy(name="city")
	private WebElement field_City;
	
	@FindBy(xpath="//table[@id='updateAddressBtn']//descendant::button[@type='button' and text()='Update']")
	private WebElement btn_Update_window_AddAddress;

	@FindBy(xpath="//div[contains(text(),'The selected address has been successfully updated at the Account Level')]//following::button[text()='Update'][1]")
	private WebElement btn_Update_window_PropagateAddress;

	@FindBy(xpath="//span[text()='The selected address has been successfully updated.']//following::button[text()='OK'][1]")
	private WebElement btn_OK_message_UpdateAddress;
	
	@FindBy(xpath="//div[@class='x-grid-group-title' and contains(text(), 'Historical') and contains(text(), 'Record')]//preceding::div[contains(@class,'x-grid3-cell-inner') and text()='Home Address']")
	private WebElement option_CurrentAddressRecords_HomeAddress;

	@FindBy(xpath="//div[@class='x-grid-group-title' and contains(text(), 'Historical') and contains(text(), 'Record')]//preceding::div[contains(@class,'x-grid3-cell-inner') and text()='Work Address']")
	private WebElement option_CurrentAddressRecords_WorkAddress;

	@FindBy(xpath="//div[@class='x-grid-group-title' and contains(text(), 'Historical') and contains(text(), 'Record')]//preceding::div[contains(@class,'x-grid3-cell-inner') and text()='Other Address']")
	private WebElement option_CurrentAddressRecords_OtherAddress;

	@FindBy(xpath="//table[@id='updateContact']//descendant::button[text()='Update']")
	private WebElement btn_Update_tab_Address;

	@FindBy(xpath="//table[@id='updateContact' and contains(@class,'x-item-disabled')]//descendant::button[text()='Update']")
	private WebElement btn_Update_grayedOut_tab_Address;
	private By locator_btn_Update_grayedOut_tab_Address = By.xpath("//table[@id='updateContact' and contains(@class,'x-item-disabled')]//descendant::button[text()='Update']");

	@FindBy(xpath="//table[@id='deleteContact']//descendant::button[text()='Delete']")
	private WebElement btn_Delete_tab_Address;

	@FindBy(xpath="//table[@id='deleteContact' and contains(@class,'x-item-disabled')]//descendant::button[text()='Delete']")
	private WebElement btn_Delete_grayedOut_tab_Address;
	private By locator_btn_Delete_grayedOut_tab_Address = By.xpath("//table[@id='deleteContact' and contains(@class,'x-item-disabled')]//descendant::button[text()='Delete']");

	@FindBy(xpath="//table[@id='updateAddressBtn']//descendant::button[@type='button' and text()='Update']")
	private WebElement btn_Update_window_UpdateAddress;

	@FindBy(xpath="//span[text()='Do you really want to delete the address?']")
	private WebElement confirmationWindow_DeleteAddress;

	@FindBy(xpath="//span[text()='Do you really want to delete the address?']//following::button[text()='Yes']")
	private WebElement btn_Yes_confirmation_DeleteAddress;

	@FindBy(xpath="//span[text()='Do you really want to delete the address?']//following::button[text()='No']")
	private WebElement btn_No_confirmation_DeleteAddress;


	public void click_Address() throws InterruptedException {
		//without sleeping first, this error might appear: 
		//unknown error: Element is not clickable at point (100, 788). Other element would receive the click
		Thread.sleep(3000);
		clickElement1UntilElement2AppearBeforeTimeOut(getDriver(), false, btn_Address, element_CurrentRecord_tab_Address, 5);
		/*
		for (int second = 0;; second++) {
			//System.out.println("second: " + second);
	    	if (second >= 5) fail("timeout");
	    	btn_Address.click();
	    	//startTime = System.nanoTime();
	    	//try { if (isElementPresent(By.xpath("//div[@class='x-grid-group-title' and contains(text(), 'Current') and contains(text(), 'Record')]"))) break; } catch (Exception e) {}
	    	try { 
	    		//if we use explicit wait, then we don't need to use thread.sleep 
	    		//if ((new WebDriverWait(driver, 5)).until(ExpectedConditions.numberOfElementsToBe(locator_CurrentRecord_tab_Address, 1)) != null) {
	    		turnOffImplicitWaits(driver);
	    		if (element_CurrentRecord_tab_Address.isDisplayed()) {
	    			break; 
	    		}
	    	} catch (Exception e) {
	    		//System.out.println("exception caught: " + second);
	    	} finally {
				//estimatedTime = (System.nanoTime() - startTime)/1000000;
				//System.out.println("elapsed time: " + estimatedTime);
				turnOnImplicitWaits(driver);
	    	}
	    	Thread.sleep(1000);
	    	//System.out.println("sleep");
	    }
	    */
	}
	
	public void click_Add_tab_Address() {
		//waitToBeClickableAndClick(driver, btn_Add_tab_Address, 5);
		btn_Add_tab_Address.click();
	}

	public void window_AddAddress() {
		// TODO Auto-generated method stub
	}

	public void choose_AddressType_Other() {
		dropdown_AddressType.click();
		option_AddressType_Other.click();
	}

	public void enter_AddressLine1(String addrLine1) {
		clearAndEnter(getDriver(), "//input[@name='address1']", addrLine1);
	}

	public void enter_AddressLine2(String addrLine2) {
		clearAndEnter(getDriver(), "//input[@name='address2']", addrLine2);
	}

	public void choose_Country_US() {
		dropdown_Country.click();
		option_Country_US.click();
	}

	public void choose_State_Delaware() {
		dropdown_States.click();
		option_States_Delaware.click();
	}

	public void choose_State_Alaska() {
		dropdown_States.click();
		option_States_Alaska.click();
	}

	public void enter_Zipcode(String zipcode) {
		clearAndEnter(getDriver(), "//input[@name='postalCode']", zipcode);
	}

	public void enter_City(String city) {
		clearAndEnter(getDriver(), "//input[@name='city']", city);
	}

	public void click_Update_window_AddAddress() {
		waitToBeClickableAndClick(getDriver(), btn_Update_window_AddAddress, 3);
	}

	public void click_Update_window_PropagateAddress() throws InterruptedException {
		waitToBeClickableAndClick(getDriver(), btn_Update_window_PropagateAddress, 3);
		Thread.sleep(3000);
	}

	public void message_UpdateAddress_OK() throws InterruptedException {
		assertTrue(btn_OK_message_UpdateAddress.isDisplayed());
		btn_OK_message_UpdateAddress.click();
	}

	public void choose_CurrentAddressRecords_HomeAddress() {
		option_CurrentAddressRecords_HomeAddress.click();
	}

	public void choose_CurrentAddressRecords_WorkAddress() {
		option_CurrentAddressRecords_WorkAddress.click();
	}

	public void choose_CurrentAddressRecords_OtherAddress(String addressLine) {
//		option_CurrentAddressRecords_OtherAddress.click();
		clickByXpath(getDriver(), "//div[text()='"+addressLine+"']");
	}

	public void click_Update_tab_Address() throws InterruptedException {
		waitForElementNotPresent(getDriver(), locator_btn_Update_grayedOut_tab_Address, 3);
		btn_Update_tab_Address.click();
	}

	public void window_UpdateAddress() {
		//TODO assuming true 
	}

	public void click_Update_window_UpdateAddress() {
		btn_Update_window_UpdateAddress.click();
	}

	public void click_Delete_tab_Address() throws InterruptedException {
		waitForElementNotPresent(getDriver(), locator_btn_Delete_grayedOut_tab_Address, 3);
		btn_Delete_tab_Address.click();
	}

	public void confirmation_DeleteAddress_Yes() {
		assertTrue(confirmationWindow_DeleteAddress.isDisplayed());
		btn_Yes_confirmation_DeleteAddress.click();
	}
}
