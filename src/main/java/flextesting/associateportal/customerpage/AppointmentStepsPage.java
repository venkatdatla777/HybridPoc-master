package flextesting.associateportal.customerpage;


import com.qa.base.TestBase;
import flextesting.pagefactories.associateportalAccountView.AssociatePortalCommonFactoryAccountView;
import flextesting.utilities.DataUtil;
import flextesting.utilities.Utils;
import org.openqa.selenium.By;

import static flextesting.utilities.Utils.*;


public class AppointmentStepsPage extends TestBase {
	private String randomComment = "This is some random comment: " + DataUtil.getRandomChars();
	private String xpathOfAppointment = "//div[text()='" + randomComment + "']";
	private AssociatePortalCommonFactoryAccountView associatePortalCommonFactoryAccountView;

	public void i_click_the_Appointments_icon() throws Throwable {
		clickByXpath(getDriver(), "//button[contains(@class,'appointments-btn')]");
	}

	public void i_click_the_button_in_Advisor_Appointments_window(String btnName) throws Throwable {
		clickByXpath(getDriver(), "//button[text()='" + btnName + "']");
	}

	public void i_select_a_Customer_Timezone() throws Throwable {
		clickByXpath(getDriver(), "//input[@id='appointmentTimeSecZoneId']");
		// choose the first one
		clickByXpath(getDriver(), "//div[contains(@class,'x-combo-list-item')]");
	}

	public void i_select_a_Customer_Appt_Date() throws Throwable {
		clickByXpath(getDriver(), "//div[@id='appointmentWin']//img[contains(@class,'x-form-date-trigger')]");
		// choose the first valid date
		// clickByXpath(driver, "//td[@class='x-date-active']");
		associatePortalCommonFactoryAccountView.selectADate(1);
	}

	public void i_select_a_Customer_Appt_Time() throws Throwable {
		clickByXpath(getDriver(), "//input[@id='timeSlot']");
		// choose the first one
		Thread.sleep(3000);
		clickByXpath(getDriver(), "//div[contains(@class,'x-combo-list-item')]");
	}

	public void i_choose_a_phone_number_for_the_schedule() throws Throwable {
		if(Utils.isElementPresent(getDriver(), By.xpath("//input[@name='byOtherPhone']//preceding::label[contains(text(),' Phone:')]"))){
			clickByXpath(getDriver(), "//input[@name='byOtherPhone']//preceding::label[contains(text(),' Phone:')]");
		} else {
			clickByXpath(getDriver(), "//input[@name='byOtherPhone']");
			clearAndEnter(getDriver(), "//input[@name='otherPhoneNum']", "5042670320");
		}
	}

	
	public void i_check_the_Schedule_Appointment_Phone() throws Throwable {
		clickByXpath(getDriver(), "//input[@name='byOtherPhone']");
	}

	public void i_select_a_country_code_for_the_phone() throws Throwable {
		String xpathOfArrowTrigger = "//div[@id='appointmentWin']//input[@name='telephoneCountryCode']//following-sibling::img";
		clickByXpath(getDriver(), xpathOfArrowTrigger);
		// +1 for USA
		clickByXpath(getDriver(), "//span[contains(text(),'United States') and contains(text(),'(+1)') ]");
	}

	public void i_enter_a_phone_number_after_the_country_code() throws Throwable {
		clearAndEnter(getDriver(), "//input[@name='otherPhoneNum']", "3022222222");
	}

	public void i_select_a_Language_for_the_appointment() throws Throwable {
		clickByXpath(getDriver(), "//input[@name='language']//following-sibling::input");
		clickByXpath(getDriver(), "//div[contains(@class,'x-combo-list-item')]");
	}

	public void i_enter_some_comments_about_the_appointment() throws Throwable {
		clearAndEnter(getDriver(), "//div[@id='appointmentWin']//textarea", randomComment);
	}

	public boolean i_should_see_the_appointment_scheduled() throws Throwable {
		return isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfAppointment, true, false);
	}

	public void i_select_the_appointment_just_scheduled() throws Throwable {
		isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfAppointment, true, true);
	}

	public void i_select_another_Customer_Appt_Time() throws Throwable {
		clickByXpath(getDriver(), "//input[@id='timeSlot']");
		// choose the second one
		clickByXpath(getDriver(), "//div[contains(@class,'x-combo-list-item')][2]");
	}

	public boolean i_should_see_the_appointment_cancelled() throws Throwable {
		String xpathOfStatusCancelled = xpathOfAppointment
				+ "//parent::td//preceding-sibling::td//div[text()='Cancelled']";
		return isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfStatusCancelled, true, false);
	}

}
