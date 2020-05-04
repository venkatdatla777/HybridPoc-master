package flextesting.pagefactories.associateportal.customerpage;


import com.qa.base.TestBase;
import flextesting.pagefactories.associateportalAccountView.AssociatePortalCommonFactoryAccountView;
import flextesting.utilities.DataUtil;
import flextesting.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static flextesting.utilities.Utils.clearAndEnter;
import static flextesting.utilities.Utils.clickByXpath;


public class ProgramOffersFactory extends TestBase {
	
	private String  xpathOfAvailableOffer = "//div[starts-with(@class,'x-window-bwrap')]//div[contains(@class,'x-grid3-row-first')]";
	private String  xpathOfAccount = "//div[starts-with(@class,'x-window-bwrap')]//div[contains(@class,'x-grid3-body')]";
	private String  xpathOfAvailableOfferAgain = "//div[starts-with(@class,'x-window-bwrap')]//div[contains(@class,'x-grid3-row-alt')]";
	private String  xpathOfPayments = "//div[starts-with(@class,'x-window-bwrap')]//div[contains(@class,'x-grid3-col-8')]";
	
	private AssociatePortalCommonFactoryAccountView associatePortalCommonFactoryAccountView;
	private String paymentAmount = null;
	private String xpathOfPaymentAmount = null;
	
	@FindBy(xpath = "//div[starts-with(@class,'x-window-bwrap')]//div[contains(@class,'x-form-field-trigger-wrap')]")
    WebElement fundingAccountFields;
	
	@FindBy(xpath = "//div[starts-with(@class,'x-window-bwrap')]//img[contains(@class,'x-form-arrow-trigger')]")
    WebElement fundingAccountDropDown;
	
	@FindBy(xpath = "//div[starts-with(@class,'x-combo-list')]//div[contains(@class,'funding-item')]")
    WebElement fundingAccountItem;
	
	@FindBy(xpath="//label[text()='Payment Date:']//following::img[contains(@class,'x-form-date-trigger')][2]")
	private WebElement dropdown_PaymentDate;
	
	public void click_OffersIcon_Level_Account() throws InterruptedException {
		clickByXpath(getDriver(), "//table[@id='offersMenuButton']//button[contains(@class,'offers-btn')]");
		
		Thread.sleep(3000);
	}
	
	public void double_Click_The_Any_AvailableOffer() throws InterruptedException {
		Utils.doubleClickElement(getDriver(), getDriver().findElement(By.xpath(xpathOfAvailableOffer)));
		Thread.sleep(4000);
	}
	
	public void click_The_Next_Button() throws InterruptedException {
		Thread.sleep(3000);
		clickByXpath(getDriver(), "//div[starts-with(@class,'x-window-bwrap')]//button[contains(text(),'Next')]");
		Thread.sleep(3000);
	}

	public String get_FundingAccount_Is_Available() {
		waitFor(fundingAccountFields);
		return fundingAccountFields.getText();
	}
	
	public void clickOnAddNewFundingAccountDropDown() throws InterruptedException {
		clickByXpath(getDriver(), "//div[starts-with(@class,'x-window-bwrap')]//button[contains(text(),'Add New Funding Account')]");
		Thread.sleep(3000);
	}
	public void click_NewCardAccount() throws InterruptedException {
		clickByXpath(getDriver(), "//*[@id=\"x-menu-el-newCard\"]");
		Thread.sleep(3000);
	}
	public void clickOnAcceptProgram() throws InterruptedException {
		clickByXpath(getDriver(), "//div[starts-with(@class,'x-window-bwrap')]//button[contains(text(),'Accept Program')]");
		Thread.sleep(20000);
	}
	
	public void select_The_Any_Account_FromList() throws InterruptedException {
		clickByXpath(getDriver(), "//div[starts-with(@class,'x-window-bwrap')]//div[contains(@class,'x-grid3-row-alt')]");
		Thread.sleep(3000);
		
	}
	public void selectFundingItem() throws InterruptedException {
		clickByXpath(getDriver(), "//div[starts-with(@class,'x-window-bwrap')]//div[contains(@class,'funding-item')]");
		Thread.sleep(3000);
	}
	public String verifyThatProgramAccepted() throws InterruptedException {
		Thread.sleep(6000);
		String str = getDriver().findElement(By.xpath(xpathOfAccount)).getText();
		return str;
		
	}
	
	public void clickOnFundingAccountDropDown() {
		waitFor(fundingAccountDropDown);
		fundingAccountDropDown.click();
	}
	
	public void clickFundingAccountItem() {
		waitFor(fundingAccountItem);
		fundingAccountItem.click();
	}
	
	public void clickOnUseThisForAllButton() throws InterruptedException {
		clickByXpath(getDriver(), "//div[starts-with(@class,'x-window-bwrap')]//button[contains(text(),'Use This For All')]");
		Thread.sleep(3000);
	}
	
	public void clickOnAcceptedProgramOffer() throws InterruptedException {
        clickByXpath(getDriver(), "//div[starts-with(@class,'x-window-bwrap')]//div[contains(@class,'x-grid3-col-1')]");
		Thread.sleep(3000);
	}
	
	public void clickOnCancelAcceptedOfferButton() throws InterruptedException {
		clickByXpath(getDriver(), "//div[starts-with(@class,'x-window-bwrap')]//button[contains(text(),'Cancel Accepted Offer')]");
		Thread.sleep(4000);
	}
	
	public void clickOnYesButton() throws InterruptedException {
		clickByXpath(getDriver(), "//div[starts-with(@class,'x-window-bwrap')]//button[contains(text(),'Yes')]");
		Thread.sleep(5000);
	}
	
	public void clickOnOkButton() throws InterruptedException {
		clickByXpath(getDriver(), "//div[starts-with(@class,'x-window-bwrap')]//button[contains(text(),'OK')]");
		Thread.sleep(4000);
	}
	
	public void again_Double_Click_The_Same_AvailableOffer() throws InterruptedException {
		Utils.doubleClickElement(getDriver(), getDriver().findElement(By.xpath(xpathOfAvailableOfferAgain)));
		Thread.sleep(4000);
	}
	
    public void i_click_the_Payment_tab() throws Throwable {
    	clickByXpath(getDriver(), "//span[text()='Payment']");
    	Thread.sleep(20000);
	}

	public void i_Select_any_one_payment_and_click_on_Update_Payment_button() throws Throwable {
		clickByXpath(getDriver(), "//div[starts-with(@class,'x-window-bwrap')]//div[contains(@class,'x-grid3-row-first')]");
		clickByXpath(getDriver(), "//div[starts-with(@class,'x-window-bwrap')]//button[contains(text(),'Update Payment')]");
		Thread.sleep(3000);
	}
	
	public void i_Update_Payment_Date_day_from_today(int daysFromToday) throws Throwable {
		Thread.sleep(1000);
//			clickByXpath(getDriver(), "//input[@name='paymentDate']");
		dropdown_PaymentDate.click();
			Thread.sleep(1000);
		associatePortalCommonFactoryAccountView.selectADate(daysFromToday);
	}

	public void i_Update_Payment_Amount() throws Throwable {
		paymentAmount = DataUtil.getRandomNumberNotContainingZero(2);
		clearAndEnter(getDriver(), "//input[@name='paymentAmount']/following-sibling::input", paymentAmount);
		xpathOfPaymentAmount = "//div[contains(text(),'"+DataUtil.currencyFormatter(paymentAmount)+"')]";
	}

	public void i_click_the_Submit_and_Ok_Button() throws Throwable {
		clickByXpath(getDriver(), "//div[starts-with(@class,'x-window-bwrap')]//button[contains(text(),'Submit')]");
		Thread.sleep(4000);
		clickByXpath(getDriver(), "//div[starts-with(@class,'x-window-bwrap')]//button[contains(text(),'OK')]");
		Thread.sleep(4000);
	}
	
    public void i_Select_any_one_payment_and_click_on_Delete_Payment_button() throws Throwable {
    	clickByXpath(getDriver(), "//div[starts-with(@class,'x-window-bwrap')]//div[contains(@class,'x-grid3-row-first')]");
		clickByXpath(getDriver(), "//div[starts-with(@class,'x-window-bwrap')]//button[contains(text(),'Delete Payment')]");
		Thread.sleep(3000); 
	}
    
    public String verifyThatPaymentDeleted() throws InterruptedException {
		Thread.sleep(6000);
		String str = getDriver().findElement(By.xpath(xpathOfPayments)).getText();
		return str;
		
	}
	
}
