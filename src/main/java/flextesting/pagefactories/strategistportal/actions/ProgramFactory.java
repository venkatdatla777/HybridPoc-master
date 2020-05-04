package flextesting.pagefactories.strategistportal.actions;

import com.qa.base.TestBase;
import flextesting.utilities.Utils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static flextesting.utilities.Utils.*;


/**
 * @author Shiyi Chen
 */
public class ProgramFactory extends TestBase {

	@FindBy(xpath = "//div[starts-with(@id,'tabbar')]//div[starts-with(@id,'tab')]//button//span[text()='Programs']")
	private WebElement btn_Programs;

	@FindBy(xpath = "//span[contains(@id,'programactionedit')]")
	private WebElement wind_AddProgramAction;

	@FindBy(xpath = "//label[text()='Program Type:']//following::td[@class='x-trigger-cell'][1]")
	private WebElement dropdown_ProgramType;

	/**
	 * TNA: Full, PLAQA: Settlement
	 */
	@FindBy(xpath = "//li[contains(@class,'x-boundlist-item')]")
	private WebElement option_ProgramType_Any;

	@FindBy(xpath = "//label[text()='Installment Frequency:']//following::td[@class='x-trigger-cell'][1]")
	private WebElement dropdown_InstallmentFrequency;

	@FindBy(xpath = "//li[contains(@class,'x-boundlist-item') and text()='Monthly']")
	private WebElement option_InstallmentFrequency_Monthly;

	@FindBy(xpath = "//input[@name='allowedPaymentDateRange']")
	private WebElement field_DueDateRange;

	@FindBy(xpath = "//label[text()='Rounding Method:']//following::td[@class='x-trigger-cell'][1]")
	private WebElement dropdown_RoundingMethod;

	@FindBy(xpath = "//li[contains(@class,'x-boundlist-item') and text()='Cents (Round Up)']")
	private WebElement option_RoundingMethod_CentsRoundUp;

	@FindBy(xpath = "//div[text()='Program Available to:']//following::span[text()='Edit'][1]")
	private WebElement btn_Edit_ProgramAvailableTo;

	// @FindBy(xpath="//div[starts-with(@id,'programactionedit')]//following::table[starts-with(@id,'picklistfield')]//li[text()='Admin']")
	@FindBy(xpath = "//table[starts-with(@id,'picklistfield')]//li[contains(text(),'Admin')]")
	private WebElement option_Admin_ProgramAvailableTo;

	// @FindBy(xpath="//div[starts-with(@id,'programactionedit')]//following::table[starts-with(@id,'picklistfield')]//li[text()='Web']")
	@FindBy(xpath = "//table[starts-with(@id,'picklistfield')]//li[text()='Web']")
	private WebElement option_Web_ProgramAvailableTo;

	@FindBy(xpath = "//span[text()='Remove Action From Portfolio']")
	private WebElement confirmationWindow_RemoveActionFromPortfolio;

	@FindBy(xpath = "//span[text()='Remove Action From Portfolio']//following::span[text()='Yes']")
	private WebElement btn_Yes_confirmation_RemoveActionFromPortfolio;

	private boolean programCreated = false;

	public boolean isProgramCreated() {
		return programCreated;
	}

	public void setProgramCreated(boolean programCreated) {
		this.programCreated = programCreated;
	}

	public void click_tab_Programs() throws InterruptedException {
		Thread.sleep(2000);
		btn_Programs.click();
	}

	// public void click_Add_tab_Programs() {
	// btn_Add_tab_Programs.click();
	// }
	public void window_AddProgramAction() {
		Assert.assertTrue(wind_AddProgramAction.isDisplayed());
	}

	public void enter_Name(String name) {
		clearAndEnter(getDriver(), "//input[@name='name']", name);
	}

	public void choose_ProgramType_Any() throws InterruptedException {
		dropdown_ProgramType.click();
		// clickAgainForElementNotAttachedException(driver,
		// option_ProgramType_Full);
		Thread.sleep(1500);
		// click the first one
		clickByXpath(getDriver(), "//li[contains(@class,'x-boundlist-item')]");
	}

	public void choose_ProgramType_Settlement() throws InterruptedException {
		dropdown_ProgramType.click();
		// clickAgainForElementNotAttachedException(driver,
		// option_ProgramType_Full);
		Thread.sleep(1500);
		// click the first one
		clickByXpath(getDriver(), "//li[contains(@class,'x-boundlist-item') and contains(text(),'Settlement')][1]");
	}

	public void choose_InstallmentFrequency_Monthly() {
		dropdown_InstallmentFrequency.click();
		option_InstallmentFrequency_Monthly.click();
	}

	public void enter_DueDateRange(String days) {
		clearAndEnter(getDriver(), "//input[@name='allowedPaymentDateRange']", days);
	}

	public void choose_RoundingMethod_CentsRoundUp() {
		clickByXpath(getDriver(), "//label[text()='Rounding Method:']//following::td[@class='x-trigger-cell'][1]");
		option_RoundingMethod_CentsRoundUp.click();
	}

	public void enter_TotalNumberOfInstallments(String number) {
		clearAndEnter(getDriver(), "//input[@name='duration']", number);
	}

	public void enter_NumberOfPaymentsRequired(String number) {
		clearAndEnter(getDriver(), "//input[@name='requiredPayments']", number);
	}

	public void enter_TotalAmount(String amount) {
		clearAndEnter(getDriver(), "//input[@name='totalAmount']", amount);
	}

	public void click_Edit_ProgramAvailableTo_window_AddProgramAction() {
		btn_Edit_ProgramAvailableTo.click();
	}

	// public void window_ProgramAvailableTo() throws InterruptedException {
	// waitForElementNotPresent(driver,
	// locator_element_hiddenWindow_ProgramAvailableTo, 3);
	// }
	public void choose_ProgramAvailableTo_Admin() throws InterruptedException {
		Thread.sleep(1999);
		doubleClickElement(getDriver(), option_Admin_ProgramAvailableTo);
	}

	public void choose_ProgramAvailableTo_Web() {
		doubleClickElement(getDriver(), option_Web_ProgramAvailableTo);
	}

	// public void click_close_window_ProgramAvailableTo() {
	// btn_close_ProgramAvailableTo.click();
	// }
	// public void save_AddProgramAction() throws InterruptedException {
	// waitToBeClickableAndClick(driver, saveBtn_AddProgramAction, 3);
	// setProgramCreated(true);
	// //give time for updating
	// Thread.sleep(3000);
	// }
	//
	// public void choose_Program(String programName) {
	// By locator_program =
	// By.xpath("//div[starts-with(@id,'programactiongrid')]//div[contains(@class,'x-grid-cell-inner')
	// and text()='"+programName+"']");
	// driver.findElement(locator_program).click();
	// }
	// public void click_Delete_tab_Programs() throws InterruptedException {
	// waitToBeClickableAndClick(driver, btn_Delete_tab_Programs, 2);
	// //give time for updating
	// Thread.sleep(2000);
	// }
	public void confirmation_RemoveActionFromPortfolio() {
		Assert.assertTrue(confirmationWindow_RemoveActionFromPortfolio.isDisplayed());
	}

	public void confirmation_RemoveActionFromPortfolio_Yes() {
		btn_Yes_confirmation_RemoveActionFromPortfolio.click();
		setProgramCreated(false);
	}
	
	public void enter_firstInstallment_dueDate(String date) {
		clearAndEnter(getDriver(), "//*[@name='startDateExpression']", date);
	}
	
	public void choose_InstallmentFrequency(String value) {
		dropdown_InstallmentFrequency.click();
		WebElement elm = getDriver().findElement(By.xpath("//li[contains(@class,'x-boundlist-item') and text()='"+value+"']"));
		elm.click();
	}
	
	public void enter_NoOfPromisesRequired(String value) {
		clearAndEnter(getDriver(), "//*[@name='requiredPTPs']", value);
	}
	
	public void choose_ProgramAvailable_To_Admin() throws InterruptedException {
		Thread.sleep(1999);
		String xpath = "//table[starts-with(@id,'picklistfield')]//li[contains(text(),'Admin')]";
		int index = getDriver().findElements(By.xpath(xpath)).size() - 1;
		System.out.println("index : " + index);
		WebElement elm = getDriver().findElements(By.xpath(xpath)).get(index);
		doubleClickElement(getDriver(), elm);
		elm = getDriver().findElements(By.xpath("//table[starts-with(@id,'picklistfield')]//li[contains(text(),'Admin')]")).get(index-1);
		doubleClickElement(getDriver(), elm);
	}
	public void choose_ProgramAvailable_To_Web() throws InterruptedException {
		Thread.sleep(4999);
		String xpath = "//table[starts-with(@id,'picklistfield')]//li[text()='Web']";
		int index = getDriver().findElements(By.xpath(xpath)).size() - 1;
		System.out.println("index : " + index);
		WebElement elm = getDriver().findElements(By.xpath(xpath)).get(index);
		doubleClickElement(getDriver(), elm);
	}
}
