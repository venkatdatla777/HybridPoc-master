package flextesting.associateportal.customerpage;


import com.qa.base.TestBase;
import flextesting.associateportal.defaultdata.ContactAndNoteData;
import flextesting.pagefactories.CommonElementsFactory;
import flextesting.utilities.Utils;

public class EmailStepsPage extends TestBase {
	
	private CommonElementsFactory commonElementsFactory;
	private String email = null;

	
	
	public void i_select_as_the_Email_Type(String arg1) throws Throwable {
		commonElementsFactory.arrowTrigger("Type:");
		commonElementsFactory.chooseAnOptionByName(arg1);
	}



	public void i_enter_an_Email_Address() throws Throwable {
		email = ContactAndNoteData.getEmail();
		Utils.clearAndEnter(getDriver(), "//input[@name='address']", email);
	}


	public void i_select_for_the_Express_Consent(String arg1) throws Throwable {
		commonElementsFactory.arrowTrigger("Express Consent :");
		commonElementsFactory.chooseAnOptionByName(arg1);
	}

	
	public void i_click_the_Update_button_in_the_Add_Email_windown() throws Throwable {
		//wait 1 sec for the button to be no longer grayed-out
		Thread.sleep(1000);
		Utils.clickByXpath(getDriver(), "(//label[text()='Express Consent :']//following::button[text()='Update'])[1]");
	}

	
	public void i_should_see_the_email_created() throws Throwable {
		org.junit.Assert.assertTrue(Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), "//*[(self::div or self::span) and (contains(text(),'"+email+"'))]", true, false));
	}

	
	public void i_select_the_email() throws Throwable {
		Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), "//*[(self::div or self::span) and (contains(text(),'"+email+"'))]", true, true);
	}

	
	public void i_should_see_the_email_deleted() throws Throwable {
		//check if the email is in the history table 
		String xpath = "//div[contains(text(),'"+email+"')]//ancestor::div[contains(@id,'gp-historical-true-bd')]";
		org.junit.Assert.assertTrue(Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), xpath, true, false));
	}
}
