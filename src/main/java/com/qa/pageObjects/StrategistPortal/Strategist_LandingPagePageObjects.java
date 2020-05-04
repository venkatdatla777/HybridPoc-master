package com.qa.pageObjects.StrategistPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.base.TestBase;

public class Strategist_LandingPagePageObjects extends TestBase  {
	@FindBy(xpath = "//input[@placeholder='Username']")
	public WebElement username_input_user;
	
	@FindBy(xpath="//input[@placeholder='Password']") 
	public WebElement password_input_user;
	
	@FindBy(xpath="//div[text()='Enter an email or phone number']")
	private WebElement emptyUsernameValidation;
	
	@FindBy(xpath="//input[@value='Log in']")
	private WebElement LoginButton;
	
	@FindBy(xpath="//div[@class='valid-user']")
	private WebElement LandingPageErrorMessagePlaceholder;

	@FindBy(xpath="//em[@id='queueViewMenuCombo-btnWrap']")
	private WebElement userMenuAfterLogin;
	
	@FindBy(id="logoutBtn-itemEl")
	private WebElement LogoutHyperlink;

	@FindBy(id="queueViewMenuCombo-btnEl")
	private WebElement WelcomeUsername;


	@FindBy(id="button-1055")
	private WebElement startButton;

	@FindBy(xpath="//button[@id='button-1049-btnEl']")
	private WebElement logoutButton;

	@FindBy(xpath="//button[@id='button-1006-btnEl']")
	private WebElement LogoutConfirmatioYesButton;

	//

	public void clickOnStartButton(){
		waitFor(startButton);
		startButton.click();
	}

	public void clickOnLogoutButton(){
		waitFor(logoutButton);
		logoutButton.click();
	}

	public void clickOnLogoutConfirmationYesButton(){
		waitFor(LogoutConfirmatioYesButton);
		LogoutConfirmatioYesButton.click();
	}

	public void validateUserNameField(){
        waitFor(username_input_user);
        Assert.assertEquals(username_input_user.getAttribute("placeholder"), "Username");
	}
	
	public void enterUsename(String userName){
        waitFor(username_input_user);
        username_input_user.sendKeys(userName);
		password_input_user.click();
      //  LogThisStepInExtentReport("Entered UserName :"+userName);

	}
	public void validatePasswordField(){
        waitFor(password_input_user);
        Assert.assertEquals(password_input_user.getAttribute("placeholder"), "Password");
	}
	
	public void enterPassword(String password){
        waitFor(password_input_user);
        password_input_user.sendKeys(password);
       // LogThisStepInExtentReport("Entered password :"+password);
    }
	
	public void loginButtonClick(WebDriver driver){
        waitFor(LoginButton);
		LoginButton.click();
      //  LogThisStepInExtentReport("Clicked On Login Button");
    }
	
	public void verifySuccessfulLogin(WebDriver driver) {
        waitFor(WelcomeUsername);
        Assert.assertEquals(WelcomeUsername.getText(), "Ram Datla");
	}
	
	public void clickLogout(WebDriver driver) throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 10);
        waitFor(userMenuAfterLogin);
        userMenuAfterLogin.click();
       // LogThisStepInExtentReport("Clicked On Logout DropDown");
        Thread.sleep(2000);
		LogoutHyperlink.click();
       // LogThisStepInExtentReport("Clicked On Logout Button");

	}
	
	public void verifyLogout(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 10);
        waitFor(username_input_user);
        Assert.assertEquals(username_input_user.getAttribute("placeholder"), "Username");
       // LogThisStepInExtentReport("Logout successfully Verified");

    }
}

