package flextesting.pagefactories;

import com.qa.base.TestBase;
import flextesting.exceptions.NoVisibleElementFoundException;
import org.openqa.selenium.NoSuchElementException;

import static flextesting.utilities.Utils.*;

public class CommonElementsFactory extends TestBase {
	
	public void enterName(String name) throws InterruptedException {	
		clearAndEnter(getDriver(), "//input[@name='name']", name);
	}
	public void enterDisplayName(String name) throws InterruptedException {	
		clearAndEnter(getDriver(), "//input[@name='displayName']", name);
	}
	public void enterDescription(String name) throws InterruptedException {	
		try {
			clearAndEnter(getDriver(), "//input[@name='description']", name);
		} catch (NoSuchElementException ex) {
			clearAndEnter(getDriver(), "//textarea[@name='description']", name);
		}
	}
	public void click_Next() {
		waitToBeClickableAndClick(getDriver(), returnTheVisibleOne(getDriver(), "//span[text()='Next']//parent::button"), 2);
	}
	/**
	 * wait 1.5 sec for the saving process 
	 * @throws InterruptedException 
	 */
	public void click_Save() throws InterruptedException {
		waitToBeClickableAndClick(getDriver(), returnTheVisibleOne(getDriver(), "//span[text()='Save']//parent::button"), 2);
		Thread.sleep(1500);
	}
	public void click_Submit() {
		waitToBeClickableAndClick(getDriver(), returnTheVisibleOne(getDriver(), "//span[text()='Submit']//parent::button"), 2);
	}
	/**
	 * wait 1 sec for the searching process 
	 * @throws InterruptedException 
	 */
	public void click_Search() throws InterruptedException {
		clickByXpath(getDriver(), "//div[contains(@class,'x-form-search-trigger')]");
		Thread.sleep(1000);
	}
	/**
	 * wait 1 sec after confirming an action 
	 * @throws InterruptedException 
	 */
	public void confirm_Yes() throws InterruptedException {
		clickByXpath(getDriver(), "//*[(self::span or self::button) and text()='Yes']");
		Thread.sleep(12000);
	}
	/**
	 * wait 1 sec after clicking message window OK
	 * @throws InterruptedException
	 */
	public void message_OK() throws InterruptedException {
		clickByXpath(getDriver(), "//*[(self::span or self::button) and text()='OK']");
		Thread.sleep(5000);
	}

	public void closeWindow(String windowName) {
		clickByXpath(getDriver(), "//span[text()='"+windowName+"']//following::img[contains(@class,'x-tool-close')]");
	}
	public void closeWindowByNameContaining(String windowName) {
		clickByXpath(getDriver(), "//span[contains(text(),'"+windowName+"')]//following::img[contains(@class,'x-tool-close')]");
	}
	
	public void search(String name) throws InterruptedException {
		clearAndEnter(getDriver(), "//span[text()='Search']//following::input[1]", name);
		click_Search();
	}
	
	public void arrowTrigger(String name) {
		clickByXpath(getDriver(), "//*[(self::label or self::div) and (text()='"+name+"')]//following::*[(self::div or self::img) and contains(@class,'x-form-arrow-trigger')][1]");
	}
	
	public void arrowTriggerAccountView(String name) {
		clickByXpath(getDriver(), "(//div[starts-with(@id,'updatePhone')]//div[starts-with(@id,'phoneForm')]//label[text()='"+name+"']//following::input[contains(@class,'x-trigger-noedit')])[1]");
		
//			clickByXpath(getDriver(), "//*[(self::label or self::div) and (text()='Express Consent (Call):')]//following::*[(self::div or self::img) and contains(@class,'x-form-arrow-trigger')][1]");
	}
	
	
	/**
	 * index = 1 => first option 
	 * <p> the risks/problems outweigh the benefits
	 */
	@Deprecated
	public void chooseAnOptionByIndex(int index) {
		try {
			clickByXpath(getDriver(), "(//*[(self::li or self::div) and (@role='option' or contains(@class,'x-combo-list-item'))])["+index+"]");
		} catch ( NoVisibleElementFoundException ex) {
			clickByXpath(getDriver(), "(//li[@role='option'])["+index+"]");
		}
//		clickByXpath(getDriver(), "(//div[contains(@class,'x-combo-list-item')])["+index+"]");
	}
	
	/**
	 * choose an option by name
	 * @param optionName
	 */
	public void chooseAnOptionByName(String optionName) {
		try {
			clickByXpath(getDriver(), "//*[(self::li or self::div) and (@role='option' or contains(@class,'x-combo-list-item')) and contains(text(),'"+optionName+"')]");
		} catch (NoSuchElementException ex) {
			clickByXpath(getDriver(), "//li[@role='option']//div[contains(text(),'"+optionName+"')]");
		}
	}
	
	public void clickCheckBox(String checkBoxName) {
		clickByXpath(getDriver(), "//label[contains(text(),'"+checkBoxName+"')]");
	}

}
