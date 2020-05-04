package flextesting.pagefactories.associateportalAccountView.customerpage;


import com.qa.base.TestBase;
import flextesting.pagefactories.associateportalAccountView.AssociatePortalCommonFactoryAccountView;
import flextesting.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static flextesting.utilities.Utils.clickByXpath;
import static flextesting.utilities.Utils.waitToBeClickableAndClick;
import static org.junit.Assert.assertTrue;

public class PaymentFactoryAccountView extends TestBase {

	@FindBy(xpath="//div[@class='sm-customer']//button[contains(@class,'payment-btn')]")
	private WebElement icon_Payment_level_customer;

	@FindBy(xpath="//button[text()='Make a One Time Payment']")
	private WebElement btn_MakeAOneTimePayment;

	@FindBy(xpath="//label[text()='Payment Date:']//following::img[contains(@class,'x-form-date-trigger')][2]")
	private WebElement dropdown_PaymentDate;

//	@FindBy(xpath="//table[@class='x-date-inner']")
//	private WebElement picker_PaymentDate;

	@FindBy(xpath="//td[contains(@class,'x-date-today') and @title='Today']")
	private WebElement today;	//not used

	@FindBy(xpath="//label[text()='Payment Amount:']//following::img[contains(@class,'x-form-arrow-trigger')][1]")
	private WebElement dropdown_PaymentAmount;

	@FindBy(xpath="//input[@name='paymentAmount']//following-sibling::input")
	private WebElement field_PaymentAmount;

	@FindBy(xpath="//label[text()='Funding Account:']//following-sibling::div[@id='x-form-el-fundingcombo']//img")
	private WebElement dropdown_FundingAccount;

	@FindBy(xpath="//label[text()='The payments above were submitted successfully.']")
	private WebElement element_text_PaymentSubmittedConfirmation;

	@FindBy(xpath="//label[text()='The payments above were submitted successfully.']//following::button[text()='OK']")
	private WebElement btn_OK_PaymentSubmitedConfirmation;

	/**
	 * change the index at the end to 2,3,4... when you need data of other columns. 
	 */
	@FindBy(xpath="//label[text()='The payments above were submitted successfully.']//parent::div//preceding-sibling::div//td[contains(@class,'x-grid3-col')][1]")
	private WebElement data_PaymentId_paymentSubmittedConfirmationWindow;

	@FindBy(xpath="//button[text()='Update Payment']")
	private WebElement btn_UpdatePayment;

	@FindBy(xpath="//table[@id='updatePaymentBtn']//button[text()='Next']")
	private WebElement btn_Next_window_UpdatePayment;

	@FindBy(xpath="//div[@id='paymentConfirm']//button[text()='Submit']")
	private WebElement btn_Submit_window_UpdatePayment;

	@FindBy(xpath="//span[text()='Update payment accepted successfully.']")
	private WebElement element_text_PaymentUpdatedConfirmation;

	@FindBy(xpath="//span[text()='Update payment accepted successfully.']//following::button[text()='OK']")
	private WebElement btn_OK_PaymentUpdatedConfirmation;

	@FindBy(xpath="//button[text()='Delete Payment']")
	private WebElement btn_DeletePayment;

	@FindBy(xpath="//span[text()='Are you sure you want to delete the selected payment(s)?']//following::button[text()='Yes']")
	private WebElement btn_Yes_confirmation_DeletePayment;

	@FindBy(xpath="//span[text()='The payment(s) has been deleted.']")
	private WebElement element_text_PaymentDeletedConfirmation;

	@FindBy(xpath="//span[text()='The payment(s) has been deleted.']//following::button[text()='OK']")
	private WebElement btn_OK_PaymentDeletedConfirmation;

	/*
	@FindBy(xpath="")
	private WebElement ;

	*/

	private String paymentId = null;
	private AssociatePortalCommonFactoryAccountView associatePortalCommonFactoryAccountView;
	

	/**
	 * wait 3 sec for the payment window to be fully loaded
	 * @throws InterruptedException
	 */
	public void click_PaymentIcon_level_account() throws InterruptedException {
		clickByXpath(getDriver(), "//div[@class='account-content' or @id='accountView']//button[contains(@class,'payment-btn')]");
//		icon_Payment_level_account.click();
		Thread.sleep(3000);
	}

	public void click_MakeAOneTimePayment() {
		btn_MakeAOneTimePayment.click();
	}

	/**
	 * wait 1 sec, otherwise the screen will load the change back
	 * @param daysFromToday
	 * 0 for today, 1 for tomorrow, etc...
	 * @throws InterruptedException 
	 */
	public void pick_PaymentDate(int daysFromToday, String level) throws InterruptedException {
		Thread.sleep(1000);
		if (level.equals("account")) {
			dropdown_PaymentDate.click();
		} else if (level.equals("customer")) {
			clickByXpath(getDriver(), "//input[@name='paymentDate']");
		}
		associatePortalCommonFactoryAccountView.selectADate(daysFromToday);
	}

	public void choose_minimumDue() {
		dropdown_PaymentAmount.click();
		clickByXpath(getDriver(), "//div[contains(text(),'Minimum Due')]");
	}
	
	public void enter_PaymentAmount(String amount) {
		field_PaymentAmount.sendKeys(amount);
	}

	public String choose_theFirstFundingAccount(String level) {
		if (level.equals("account")) {
			clickByXpath(getDriver(), "//label[text()='Funding Account:']//following-sibling::div//input[@id='fundingcombo']");
//			driver.findElement(By.xpath("//div[contains(@class,'funding-item')]//h3[contains(text(),'Testing')]")).click();
			WebElement firstAccount = getDriver().findElement(By.xpath("(//div[contains(@class,'funding-item')]//h3)[1]//span"));
			String text = firstAccount.getText();
			firstAccount.click();
			if (text.contains("BankAccount"))
				return "BankAccount";
			else
				return "CardAccount";	
		}
		else if (level.equals("customer")) {
			clickByXpath(getDriver(), "//input[@name='fundingAccountId']");
			WebElement firstAccount = getDriver().findElement(By.xpath("//div[@class=\"funding-item\"]"));
 			firstAccount.click();
// 			return "customerLevel";
		}
		return null;
		
		
			
	}

	public void click_SubmitAllPayments() {
		clickByXpath(getDriver(), "//button[text()='Submit All Payments']");
	}

	/**
	 * wait 3 sec for the payment submitting process
	 * @throws InterruptedException
	 */
	public void present_PaymentSubmittedConfirmation() throws InterruptedException {
		assertTrue(element_text_PaymentSubmittedConfirmation.isDisplayed());
		paymentId = data_PaymentId_paymentSubmittedConfirmationWindow.getText(); 
		//System.out.println("------------------: "+paymentId);
		btn_OK_PaymentSubmitedConfirmation.click();
		Thread.sleep(3000);
	}

	public void select_thePaymentJustSubmitted() {
		getDriver().findElement(By.xpath("//div[@id='paymentGrid']//div[@class='x-grid3-scroller']//div[text()='"+paymentId+"']")).click();
	}

	public void click_UpdatePayment() {
		waitToBeClickableAndClick(getDriver(), btn_UpdatePayment, 2);
	}

	public void click_Next_window_UpdatePayment() {
		waitToBeClickableAndClick(getDriver(), btn_Next_window_UpdatePayment, 2);
	}

	public void click_Submit_window_UpdatePayment() {
		clickByXpath(getDriver(), "//div[@id='paymentConfirm']//button[text()='Submit']");
	}

	/**
	 * wait 1 sec for the updating process
	 * @throws InterruptedException
	 */
	public void present_PaymentUpdatedConfirmation() throws InterruptedException {
		assertTrue(element_text_PaymentUpdatedConfirmation.isDisplayed());
		btn_OK_PaymentUpdatedConfirmation.click();
		Thread.sleep(1000);
	}

	public void click_DeletePayment() {
		waitToBeClickableAndClick(getDriver(), btn_DeletePayment, 2);
	}

	public void click_Yes_confirmation_DeletePayment() {
		btn_Yes_confirmation_DeletePayment.click();
	}

	/**
	 * wait 2 sec for the deleting process
	 * @throws InterruptedException
	 */
	public void present_PaymentDeletedConfirmation() throws InterruptedException {
		assertTrue(element_text_PaymentDeletedConfirmation.isDisplayed());
		btn_OK_PaymentDeletedConfirmation.click();
		Thread.sleep(2000);
	}

	public void click_AddNewFundingAccount() {
		clickByXpath(getDriver(), "//button[text()='Add New Funding Account']");
	}

	public void click_NewCardAccount() {
		clickByXpath(getDriver(), "//span[text()='New Card Account']");
	}
}
