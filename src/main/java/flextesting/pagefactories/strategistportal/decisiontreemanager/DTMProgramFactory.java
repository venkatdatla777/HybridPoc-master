package flextesting.pagefactories.strategistportal.decisiontreemanager;

import flextesting.pagefactories.strategistportal.actions.ProgramFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static flextesting.utilities.Utils.*;


/**
 * @author Shiyi Chen
 */
public class DTMProgramFactory extends ProgramFactory {
	
	@FindBy(xpath="//div[starts-with(@id,'actionstabpanel') and contains(@id,'-body')]//div[starts-with(@id,'actionofprogramgrid')]//div[starts-with(@id,'buttongroup')]//span[text()='Add']//parent::button[1]")
	private WebElement btn_Add_tab_Programs;
	
	@FindBy(xpath="//div[starts-with(@id,'actionstabpanel') and contains(@id,'-body')]//div[starts-with(@id,'actionofprogramgrid')]//div[starts-with(@id,'buttongroup')]//span[text()='Delete']//parent::button[1]")
	private WebElement btn_Delete_tab_Programs;
	
	private By locator_element_hiddenWindow_ProgramAvailableTo = By.xpath("//div[starts-with(@id,'programactionedit')]//following-sibling::div[starts-with(@id,'window') and contains(@class,'x-hide-offsets')]");

	@FindBy(xpath="//div[starts-with(@id,'programactionedit')]//following-sibling::div[starts-with(@id,'window')]//img[@class='x-tool-close']")
	private WebElement btn_close_ProgramAvailableTo;

	@FindBy(xpath="//div[starts-with(@id,'programactionedit') and contains(@id,'body')]//span[text()='Save']//parent::button[1]")
	private WebElement saveBtn_AddProgramAction;
	
	public void click_Add_tab_Programs() {
		btn_Add_tab_Programs.click();
	}
	
	public void window_ProgramAvailableTo() throws InterruptedException {
		waitForElementNotPresent(getDriver(), locator_element_hiddenWindow_ProgramAvailableTo, 3);
	}
	
	public void click_close_window_ProgramAvailableTo() {
		btn_close_ProgramAvailableTo.click();
	}
	
	public void save_AddProgramAction() throws InterruptedException {
		waitToBeClickableAndClick(getDriver(), saveBtn_AddProgramAction, 3);
		setProgramCreated(true);
		//give time for updating
		Thread.sleep(3000);
	}
	
	public void choose_Program(String programName) {
		String xpath = "//div[starts-with(@id,'actionofprogramgrid')]//div[contains(@class,'x-grid-cell-inner') and text()='"+programName+"']";
		clickByXpath(getDriver(), xpath);
	}

	public void click_Delete_tab_Programs() throws InterruptedException {
		waitToBeClickableAndClick(getDriver(), btn_Delete_tab_Programs, 2);
		//give time for updating
		Thread.sleep(2000);
	}
	
}
