package flextesting.pagefactories.strategistportal.actions;

import com.qa.base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;

import static flextesting.utilities.Utils.*;

/**
 * @author Shiyi Chen
 *
 */
public class ChannelFactory extends TestBase {
	/*
	@FindBy(xpath="")
	private WebElement ;

	*/
	
	static Logger log = Logger.getLogger(ChannelFactory.class);
	private boolean channelCreated = false;

	public boolean isChannelCreated() {
		return channelCreated;
	}

	public void setChannelCreated(boolean channelCreated) {
		this.channelCreated = channelCreated;
	}

	/**
	 * wait 1.5 sec for loading UIs of channels 
	 * @throws InterruptedException 
	 */
	public void click_tab_Channels() throws InterruptedException {
		clickByXpath(getDriver(), "//div[starts-with(@id,'tabbar')]//div[starts-with(@id,'tab')]//button//span[text()='Channels']");
		Thread.sleep(1500);
	}
	public void click_AddEditDelete(String btnName) {
		String xpath = "//div[starts-with(@id,'actionstabpanel') and contains(@id,'-body')]//div[starts-with(@id,'actionofchannelgrid')]//div[starts-with(@id,'buttongroup')]//span[text()='"+btnName+"']//parent::button[1]";
		waitToBeClickableAndClick(getDriver(), xpath, 2);
	}
	/**
	 * wait 1 sec for some new ui to appear
	 * x can be: Email, Letter, SMS, Dialer, IVR
	 * @param x
	 * @throws InterruptedException
	 */
	public void choose_SendXUsingTemplate(String x) throws InterruptedException {
		//click input to trigger the dropdown menu
		clickByXpath(getDriver(), "//input[@name='templateType' and @type='text']");
		clickByXpath(getDriver(), "//li[text()='Send "+x+" using template']");
		Thread.sleep(1000);
	}
	public void select_thePermanentSampleOrThefirstTemplate() {
		clickByXpath(getDriver(), "//input[@name='templateId']");
		// if for some reason the permanent sample is not there, then selecting the first one
		try {
			clickByXpath(getDriver(), "//li[contains(@class,'x-boundlist-item') and contains(text(),'Auto') and contains(text(), '_')]");
		} catch (NoSuchElementException ex) {
			log.error("Permanent sample is not there. Trying to select the first one");
			selectFirstVisibleFromDropDown();
		}
	}
	public void selectFirstVisibleFromDropDown() {
		clickByXpath(getDriver(), "//li[contains(@class,'x-boundlist-item')]");
	}
	public void select_firstVendor() throws InterruptedException {
		clickByXpath(getDriver(), "//input[@name='vendorId']");
		selectFirstVisibleFromDropDown();
	}
	public boolean isPresent_channelByName_clickIfYes(String channelName, boolean expectPresent, boolean click) throws InterruptedException {
		String xpath = "//div[contains(@class,'x-grid-cell-inner') and text()='"+channelName+"']";
		return isElementDisplayed_clickIfNeeded(1500, getDriver(), xpath, expectPresent, click);
	}
	public void enter_SearchField(String channelName) {
		clearAndEnter(getDriver(), "//input[starts-with(@id,'triggerfield')]", channelName);
	}

	public boolean isPresent_channelByVisibleText(String channelName) throws InterruptedException {
		String xpath = "//div[contains(@class,'x-grid-cell-inner') and text()='"+channelName+"']";
		return checkIfDisplayedByGetVisibleText(getDriver(), xpath);
	}


}
