package flextesting.pagefactories.associateportal.customerpage;

import com.qa.base.TestBase;
import flextesting.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static flextesting.utilities.Utils.*;

public class FundingAccountFactory extends TestBase {
	
	@FindBy(xpath="//table[@id='updateFunding']//button[text()='Manage Funding Account']")
	private WebElement btn_ManageFundingAccount;

	@FindBy(xpath="//button[text()='New Card Account']")
	private WebElement btn_NewCardAccount;

	//

	@FindBy(xpath="(//div[contains(@id,'ewCardWin')]//img)[1]")
	private WebElement dropdown_CreditDebit;
	
	

	@FindBy(xpath="(//div[contains(@id,'ewCardWin')]//img)[2]")
	private WebElement dropdown_CardType;

	@FindBy(xpath="(//div[contains(@id,'ewCardWin')]//img)[3]")
	private WebElement picker_ExpirationDate;

	/*
	@FindBy(xpath="")
	private WebElement ;

	*/

	private String newCardNumber = null;
	
	private String getFieldElementXpath(String fieldLable) {
		return "//label[text()='"+fieldLable+":']//following-sibling::div//input";
	}
	/**
	 * wait 2.5 sec for the manage funding accounts window to fully load
	 * @throws InterruptedException
	 */
	public void click_ManageFundingAccount() throws InterruptedException {
		btn_ManageFundingAccount.click();
		moveMouseAway(getDriver());
	}
	public void click_NewCardAccount() {
		btn_NewCardAccount.click();
	}
	public void enter_AccountNickName(String nickName) {
		clearAndEnter(getDriver(), getFieldElementXpath("Account Nick Name"), nickName);
	}
	public void choose_CreditDebit(String creditOrDebit) {
		dropdown_CreditDebit.click();
       //driver.findElement(By.xpath("//div[text()='"+creditOrDebit+"']")).click();
		try {
			clickByXpath(getDriver(), "//div[@id='newCardWin']//following::div[text()='"+creditOrDebit+"']");
		} catch (NoSuchElementException e) {
			clickByXpath(getDriver(), "//div[@id='customerPayNewCardWin']//following::div[text()='"+creditOrDebit+"']");
		}
	}
	public void choose_CardType(String cardType) {
		dropdown_CardType.click();
		//driver.findElement(By.xpath("//div[text()='"+cardType+"']")).click();
		clickByXpath(getDriver(), "//div[text()='"+cardType+"']");
	}
	public void enter_CardNumber(String cardNumber) {
		newCardNumber = cardNumber;
		clearAndEnter(getDriver(), getFieldElementXpath("Card Number"), cardNumber);
	}
	public void enter_CardHolderFullName(String fullName) {
		clearAndEnter(getDriver(), getFieldElementXpath("Card Holder Full Name"), fullName);
	}
	public void pick_ExpirationDate(String string) throws InterruptedException {
		picker_ExpirationDate.click();
		Thread.sleep(1000);
		String[] parts = string.split("/");
		String month = parts[0];
		String year = parts[1];
		getDriver().findElement(By.xpath("//a[text()='"+month+"']")).click();
		getDriver().findElement(By.xpath("//a[text()='"+year+"']")).click();
		getDriver().findElement(By.xpath("//button[@class='x-date-mp-ok' and contains(text(),'OK')]")).click();
	}
	public void enter_AddressLine1(String addressLine1) {
		clearAndEnter(getDriver(), getFieldElementXpath("Address Line 1"), addressLine1);
	}
	public void enter_City(String city) {
		clearAndEnter(getDriver(), getFieldElementXpath("City"), city);
	}
	public void enter_State(String state) {
		clearAndEnter(getDriver(), getFieldElementXpath("Province/State"), state);
	}
	public void enter_ZipCode(String zipcode) {
		clearAndEnter(getDriver(), getFieldElementXpath("Postal Code/Zip Code"), zipcode);
	}
	public void check_SaveThisAccountForFuturePayments() {
		clickByXpath(getDriver(), "//label[text()='Save this account for future payments ']//preceding-sibling::input");
	}
	/**
	 * for unknown reason, if you don't wait 1 sec, sometimes clicking the Next button has no effect.
	 * @throws InterruptedException
	 */
	public void click_Next_window_AddNewCardAccount() throws InterruptedException {
		Thread.sleep(1000);
		clickByXpath(getDriver(), "//div[contains(@id,'ewCardWin')]//button[text()='Next']");
	}
	public void click_Submit_window_AddNewCardAccount() {
		clickByXpath(getDriver(), "//div[contains(@id,'ewCardWin')]//button[text()='Submit']");
	}
	/**
	 * wait 1.5 sec for the deleting process
	 * @throws InterruptedException
	 */
	public void present_NewCardAddedConfirmation() throws InterruptedException {
		isElementDisplayed_clickIfNeeded(500, getDriver(), "//span[text()='New Card Account has been added.']", true, false);
		clickByXpath(getDriver(), "//span[text()='New Card Account has been added.']//following::button[text()='OK'][1]");
		Thread.sleep(1500);
	}
	public void select_NewlyAddedCard() {
		String last4digitsOfCard = newCardNumber.substring(newCardNumber.length()-4);
		//System.out.println("aaaaaaaaaaaaaaaaaaaaaa" + last4digitsOfCard);
		clickByXpath(getDriver(), "//div[@id='fundingGrid']//div[contains(text(),'"+last4digitsOfCard+"')]");
	}
	public void click_RemoveFundingAccount() {
		clickByXpath(getDriver(), "//button[text()='Remove Funding Account']");
	}
	public void click_Yes_window_DeleteFundingAccount() {
		clickByXpath(getDriver(), "//button[text()='Yes']");
	}
	public void click_OK_message_FundingAccountDeleted() {
		clickByXpath(getDriver(), "//span[text()='Funding account deleted.']//following::button[text()='OK'][1]");
	}
}
