package com.qa.pageObjects.CustomerPortal;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.base.TestBase;
import org.testng.annotations.Test;


public class User_LandingPageObjects extends TestBase {

	
	@FindBy(xpath = "//input[@placeholder='First Name']")
	public WebElement user_FirstName;
	
	@FindBy(xpath="//input[@placeholder='Last Name']") 
	public WebElement user_lastName;
	
	@FindBy(xpath="//input[@placeholder='Last 4 digits of Account Number']")
	private WebElement lastFourDigitNumber;
	
	@FindBy(xpath="//select[@name='birthMonth']")
	private WebElement birthMonth;
	
	@FindBy(xpath="//select[@name='birthDay']")
	private WebElement birthDay;

	@FindBy(xpath="//select[@name='birthYear']")
	private WebElement birthYear;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;



    @Test
	public void enterFirstName(String firstName){
		waitFor(user_lastName);
		user_FirstName.sendKeys(firstName);
       // LogThisStepInExtentReport("Customer Portal :Entered First Name :"+firstName);
	}
    @Test
	public void enterLastName(String lastName){
		waitFor(user_lastName);
		user_lastName.sendKeys(lastName);
       // LogThisStepInExtentReport("Entered Last Name :"+lastName);

    }
    @Test
	public void enterLastFourDigits(String fourDigits){
		waitFor(lastFourDigitNumber);
		lastFourDigitNumber.sendKeys(fourDigits);
      //  LogThisStepInExtentReport("Entered Last 4 Digits :"+fourDigits);

    }
	public void enterMonth(String month){
		driver.findElement(By.xpath("//option[contains(text(),'"+month+"')]")).click();
      //  LogThisStepInExtentReport("Selected Month :"+month);

    }
	public void enterDay(String day){
		driver.findElement(By.xpath("//option[contains(text(),'"+day+"')]")).click();
     //   LogThisStepInExtentReport("Selected Day :"+day);
    }
	public void enterYear(String year){
		driver.findElement(By.xpath("//option[contains(text(),'"+year+"')]")).click();
      //  LogThisStepInExtentReport("Selected Year :"+year);
    }
	public void clickOnLogin(){
		waitFor(loginButton);
		loginButton.click();
      //  LogThisStepInExtentReport("Clicked On Login button of Customer Portal");
    }
	
}
