package com.qa.pageObjects.AssosiciatePortal;

import com.qa.ExtentReportListener.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.base.TestBase;

public class Associate_AccountDashboardPage extends TestBase {

	
	@FindBy(xpath = "//input[@id='combobox-1020-inputEl']")
	public WebElement agent_AccountInputSearchTextBox;
	
	@FindBy(xpath="//p[contains(text(), 'Pavy')]") 
	public WebElement agent_password;
	
	@FindBy(xpath="//input[@value='Log in']")
	private WebElement agent_LoginButton;
	
	
	

	public void searchAccountWith_LF(String username) throws InterruptedException{
		waitFor(agent_AccountInputSearchTextBox);
		agent_AccountInputSearchTextBox.sendKeys(username);
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//p[contains(text(), '"+username.split(" ")[1].split(",")[0]+"')]")).click();
		//LogThisStepInExtentReport("Associate: Searching Account with Last name First Name :"+username);

	}
	public void enterLastName(String password){
		waitFor(agent_password);
		agent_password.sendKeys(password);
		//LogThisStepInExtentReport("Associate: Entered Password :"+password);

	}

	public void clickOnLogin(){
		waitFor(agent_LoginButton);
		agent_LoginButton.click();
		//LogThisStepInExtentReport("Associate: Click On Login Button");
	}

	}