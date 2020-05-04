package com.qa.pageObjects.AssosiciatePortal;

import com.qa.ExtentReportListener.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.base.TestBase;
import org.testng.annotations.Test;

public class Associate_CreditProfile_Page extends TestBase{

	

	
	@FindBy(xpath="//span[contains(text(),'Credit Card:')]")
	private WebElement creditPortifolioWindow;
	

	@FindBy(xpath="//button[contains(text(), 'Skip')]")
	private WebElement SkipVerificationButtom;
	
	@FindBy(xpath="//button[contains(text(), 'Yes')]")
	private WebElement SkipVerificationConfirmation_YES;

	@FindBy(xpath="//span[contains(text(),'Email')] | //a[@id='ext-gen334']//span[contains(@class,'x-tab-strip-text')][contains(text(),'Email')]")
	private WebElement EmailTabInTableView;
	@FindBy(xpath="//a[@id='ext-gen334']//span[contains(@class,'x-tab-strip-text')][contains(text(),'Email')]")
	private WebElement EmailTabInTableView1;
	//
	
	@FindBy(xpath="//button[@id='ext-gen224']")
	private WebElement addButton;
	
	@FindBy(id="ext-comp-1169")
	private WebElement AddEmail_Type;
	
	@FindBy(xpath="//input[@id='ext-comp-1170']")
	private WebElement emailValue;
	
	@FindBy(id="ext-comp-1181")
	private WebElement updateemailValue;
	
	@FindBy(xpath="//input[@id='ext-comp-1171']")
	private WebElement ExpressConsent;
	//  
	
	@FindBy(xpath="//table[@id='updateEmailBtn']//td[@class='x-btn-mc']")
	private WebElement UpdateButton;
	
	@FindBy(xpath="//button[@id='ext-gen64']")
	private WebElement disPosition;
	
	@FindBy(xpath="//label[contains(text(), 'Payment offer Accepted')]")
	private WebElement paymentOfferAccepted;
	
	
	@FindBy(xpath="//div[@class='x-combo-list-item' and contains(text(), 'Other Email')]")
	private WebElement OtherEmailOption;
	
	@FindBy(xpath="//div[@class='x-combo-list-item' and contains(text(), 'Yes')]")
	private WebElement consent_Value_Yes;
	
	@FindBy(xpath="/html[1]/body[1]/div[27]/div[1]/div[2]")
	private WebElement consent_Value_No;
	
	@FindBy(xpath="//button[contains(text(), 'Close Account')]")
	private WebElement SubmitAndCloseAccountButton;
	
	@FindBy(xpath="//button[contains(text(), 'Update')]")
	private WebElement Update_Button;
	
	@FindBy(xpath="//button[@id='ext-gen228']")
	private WebElement Delete_Button;
	
	@FindBy(xpath="//button[contains(text(), 'Yes')]")
	private WebElement Delete_Yes_Button;
	
	@FindBy(xpath="//input[@id='ext-comp-1192']")
	private WebElement ExpressConsent_Update;
	
	@FindBy(id="ext-gen683")
	private WebElement UpdateCancelButton;
	//
	
	@FindBy(xpath="//*[(self::li or self::div) and (contains(@class,'x-boundlist-item')or @role='option' or contains(@class,'x-combo-list-item')) and contains(text(),'Other Email')]")
	private WebElement otherEmail;
	
	
	@FindBy(xpath="/html[1]/body[1]/div[25]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/input[2]")
	private WebElement Express_Concent_DropWonArrow;

	public void ClickOnEmailDeleteButton() throws InterruptedException{
		waitFor(Delete_Button);
		Delete_Button.click();
		Thread.sleep(3000);
		waitFor(Delete_Yes_Button);
		Delete_Yes_Button.click();
      //  LogThisStepInExtentReport("Associate: Clicked On Email Delete Button");
    }
	public void ClickOnEmailUpdateButton(){
		waitFor(Update_Button);
		Update_Button.click();
       // LogThisStepInExtentReport("Associate: Clicked On Email Update Button");

    }

	public void ClickOnUpdateCancelButton(){
		waitFor(UpdateCancelButton);
		UpdateCancelButton.click();
      //  LogThisStepInExtentReport("Associate: Clicked On Update Cancel Button");

    }

	public void ClickOnSubmitAndCloseAccountButton(){
		waitFor(SubmitAndCloseAccountButton);
		SubmitAndCloseAccountButton.click();
       // LogThisStepInExtentReport("Associate: Clicked On Submit & Close Button");

    }

	public void SelectPaymentOfferAccepted(){
		waitFor(paymentOfferAccepted);
		paymentOfferAccepted.click();
       // LogThisStepInExtentReport("Associate: Clicked On Select Payment Offer Radio Button");

    }
	public void clickOnDisposition(){
		waitFor(disPosition);
		disPosition.click();
      //  LogThisStepInExtentReport("Associate: Clicked on Disposition Button");

    }
	public void waiTillCreditCardPortifolioPageLoaded(){
		waitFor(creditPortifolioWindow);
	}

	public void clickOnSkipVerficationYes(){
		waitFor(SkipVerificationButtom);
		SkipVerificationButtom.click();
//        if (SkipVerificationButtom.isDisplayed()) {
//            waitFor(SkipVerificationConfirmation_YES);
//            SkipVerificationConfirmation_YES.click();
//        }
     //   LogThisStepInExtentReport("Associate: Clicked On Skip Verification Yes Button");

    }
	
	public void clickOnEmailTab(){
		waitFor(EmailTabInTableView);
		EmailTabInTableView.click();
      //  LogThisStepInExtentReport("Associate: Clicked On Email TAB");

    }

	public void clickOnEmailTab1(){
		waitFor(EmailTabInTableView1);
		EmailTabInTableView1.click();
		//LogThisStepInExtentReport("Associate: Clicked On Email TAB");

	}
	public void ClickOnAddButton(){
		waitFor(addButton);
		addButton.click();
      //  LogThisStepInExtentReport("Associate: Clicked On Email ADD Button");

    }
	
	public void selectEmailTypeAsOtherEmail( ) throws InterruptedException{
		waitFor(AddEmail_Type);
		AddEmail_Type.click();
		Thread.sleep(2000);
		waitFor(OtherEmailOption);
		OtherEmailOption.click();
       // LogThisStepInExtentReport("Associate: Selected Email Type as OtherEmail");

    }
	
	
	public void enterMailAddress(String email ){
		waitFor(emailValue);
		emailValue.sendKeys(email);
      //  LogThisStepInExtentReport("Associate: Email Address Entered is :"+email);

    }
	
	public void UpdateMailAddress(String email ){
		waitFor(updateemailValue);
		updateemailValue.clear();
		updateemailValue.sendKeys(email);
      //  LogThisStepInExtentReport("Associate: Email Address Updated to :"+email);

    }
	public void enterEmailConsentYes(){
		waitFor(ExpressConsent);
		ExpressConsent.click();
		//Thread.sleep(1000);
		consent_Value_Yes.click();
     //   LogThisStepInExtentReport("Associate: Selected Email Consent as YES");

    }
	
	public void enterEmailConsentNo() throws InterruptedException{
		//waitFor(Express_Concent_DropWonArrow);
		//Express_Concent_DropWonArrow.click();
		Thread.sleep(1000);
		waitFor(consent_Value_No);
		consent_Value_No.click();
      //  LogThisStepInExtentReport("Associate: Selected Email Consent as NO");

    }
	public void ClickOnUpdateButton (){
		waitFor(UpdateButton);
		UpdateButton.click();
      //  LogThisStepInExtentReport("Associate: Clicked on Email Updated Button");

    }
	
	public void SelectEmailRecordToUpdate(String emailAccount){
		waitFor(UpdateButton);
		UpdateButton.click();
	}
}
