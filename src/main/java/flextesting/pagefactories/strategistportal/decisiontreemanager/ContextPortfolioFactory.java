package flextesting.pagefactories.strategistportal.decisiontreemanager;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static flextesting.utilities.Utils.*;

public class ContextPortfolioFactory extends TestBase {
	@FindBy(xpath="//div[@id='manageTree']//descendant::div[text()='Context']//following::td[@class='x-trigger-cell'][1]//div")
	private WebElement dropdown_Context;
	
	@FindBy(xpath="//li[contains(@class,'x-boundlist-item') and text()='Responsible']")
	private WebElement option_Context_Responsible;
	
	@FindBy(css="div.x-combo-list-item")
	private WebElement option_Portfolio_first;
	

	public void choose_Context_Responsible() {
		waitToBeClickableAndClick(getDriver(), dropdown_Context, 5);
		option_Context_Responsible.click();
	}
	
	public void choose_Portfolio_FromDropDownMenu() throws InterruptedException {
		Thread.sleep(2000);
		clickByXpath(getDriver(), "//div[@id='manageTree']//descendant::div[text()='Portfolio']//following::td[@class='x-trigger-cell'][1]//div");
//		option_Portfolio_first.click();
		selectAPortfolioFromDropDown(getDriver());
	}	
}
