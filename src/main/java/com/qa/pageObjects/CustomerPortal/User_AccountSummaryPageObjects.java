package com.qa.pageObjects.CustomerPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.qa.base.TestBase;

public class User_AccountSummaryPageObjects extends TestBase {

	
	@FindBy(xpath = "//span[@class='page-header-stuffix']")
	public WebElement AccountSummary_LastFourDigits;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	public WebElement LogoutLink;
	
	@FindBy(xpath = "//a[contains(text(),'Schedule Appointment')]")
	public WebElement Schedule_Appointment_Hyperlink;
	

	
	public String getLastFourDigits(){
		waitFor(AccountSummary_LastFourDigits);
		LogThisStepInExtentReport("Customer Portal :Getting text value of Last 4 Digits is :"+AccountSummary_LastFourDigits.getText());
		return AccountSummary_LastFourDigits.getText();
	}
	
	public void LogoutFromUserPortal() throws InterruptedException {
		Thread.sleep(5000);
		waitFor(LogoutLink);
		LogoutLink.click();
		LogThisStepInExtentReport("Customer Portal : Clicked on Logout Button");
	}
	
	public void ClickOnScheduleAppointmentHyperlink() throws InterruptedException {
		waitFor(Schedule_Appointment_Hyperlink);
		Schedule_Appointment_Hyperlink.click();
		LogThisStepInExtentReport("Customer Portal : Clicked Schedule Appointment Hyperlink");
		Thread.sleep(5000);
	}
}
