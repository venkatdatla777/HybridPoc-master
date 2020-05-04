package com.qa.pageObjects.AssosiciatePortal;

import com.aventstack.extentreports.Status;
import com.qa.ExtentReportListener.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



import com.qa.base.TestBase;
import org.testng.annotations.Test;


public class Associate_LandingPage extends TestBase {
//tacqa.credagility.com/agent/security/login
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	public WebElement agent_userName;
	
	@FindBy(xpath="//input[@placeholder='Password']") 
	public WebElement agent_password;
	
	@FindBy(xpath="//input[@value='Log in']")
	private WebElement agent_LoginButton;
	
	@FindBy(id="queueViewMenuCombo-btnEl")
	private WebElement agentLogoutHover;
	
	@FindBy(id="logoutBtn")
	private WebElement agentLogoutClick;


	public void enterUserName(String username){
		waitFor(agent_userName);
		agent_userName.sendKeys(username);
        //LogThisStepInExtentReport("Associate: UserName Entered :"+username);
    }
    public void enterPassword(String password){
		waitFor(agent_password);
		agent_password.sendKeys(password);
       // LogThisStepInExtentReport("Associate: Password Entered :"+password);
    }
    public void clickOnLogin(){
		waitFor(agent_LoginButton);
		agent_LoginButton.click();
       // LogThisStepInExtentReport("Associate: Clicked on Login Button");
    }
	public void clickOnLogout() throws InterruptedException{
		Thread.sleep(5000);
		waitFor(agentLogoutHover);
//		Actions action = new Actions(getDriver());
//		action.moveToElement(agentLogoutHover).build().perform();
		agentLogoutHover.click();
		Thread.sleep(1000);
		waitFor(agentLogoutClick);
		agentLogoutClick.click();
       // LogThisStepInExtentReport("Associate: Clicked on Logout Button");
    }
}
