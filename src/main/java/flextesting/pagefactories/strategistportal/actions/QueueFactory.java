package flextesting.pagefactories.strategistportal.actions;

import com.qa.base.TestBase;

import static flextesting.utilities.Utils.*;
import static org.junit.Assert.assertEquals;

/**
 * @author Shiyi Chen
 *
 */
public class QueueFactory extends TestBase {
	private boolean queueCreated = false;
	
	public boolean isQueueCreated() {
		return queueCreated;
	}

	public void setQueueCreated(boolean queueCreated) {
		this.queueCreated = queueCreated;
	}

	/**
	 * wait 1.5 sec for loading UIs of queues 
	 * @throws InterruptedException 
	 */
	public void click_tab_Queues() throws InterruptedException {
		clickByXpath(getDriver(), "//div[starts-with(@id,'tabbar')]//div[starts-with(@id,'tab')]//button//span[text()='Queues']");
		Thread.sleep(1500);
	}
	public void click_AddEditDeleteAssignment(String btnName) {
		String xpath = "//div[starts-with(@id,'actionstabpanel') and contains(@id,'-body')]//div[starts-with(@id,'actionofqueuegrid')]//div[starts-with(@id,'buttongroup')]//span[text()='"+btnName+"']//parent::button[1]";
		//waitFor(xpath);
		waitToBeClickableAndClick(getDriver(), xpath, 3);
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
	public void select_firstTemplate() {
		clickByXpath(getDriver(), "//input[@name='templateId']");
		clickByXpath(getDriver(), "//li[contains(@class,'x-boundlist-item')]");
	}
	public void select_firstVendor() {
		clickByXpath(getDriver(), "//input[@name='vendorId']");
		clickByXpath(getDriver(), "//li[contains(@class,'x-boundlist-item')]");
	}
	public boolean isPresent_queueByName_clickIfYes(String queueName, boolean expectNotPresent, boolean click) throws InterruptedException {
		String xpath = "//div[contains(@class,'x-grid-cell-inner') and text()='"+queueName+"']";
		return isElementDisplayed_clickIfNeeded(1000, getDriver(), xpath, expectNotPresent, click);
	}
	public void enter_SearchField(String queueName) {
		System.out.println("queueName : " + queueName);
		clearAndEnter(getDriver(), "//input[starts-with(@id,'triggerfield')]", queueName);
	}

	/**
	 * wait 1.5 sec for the loading process
	 * @throws InterruptedException
	 */
	public void assignQueueToTheFirstRole() throws InterruptedException {
		Thread.sleep(4000);
		doubleClickNInTable(getDriver(), "//div[contains(@id,'picklistgrid') and string-length(@id) = 17][1]//div[starts-with(@id,'gridpanel') and string-length(@id)=14][1]//tr[contains(@class,'x-grid-row')]", 1);
	}

	public void checkIfQueueIsAssignedToRole() throws InterruptedException {
		//number of roles of right table should be 1 
		assertEquals(numberOfAllVisibleOnes(getDriver(), "//div[contains(@id,'picklistgrid') and string-length(@id) = 17][1]//div[starts-with(@id,'gridpanel') and string-length(@id)=14][2]//tr[contains(@class,'x-grid-row')]"), 1);
	}
	
	public void checkIfQueueIsAssignedToTwoRoles() throws InterruptedException {
		//number of roles of right table should be 2
		Thread.sleep(1500);
		assertEquals(numberOfAllVisibleOnes(getDriver(), "//div[contains(@id,'picklistgrid') and string-length(@id) = 17][1]//div[starts-with(@id,'gridpanel') and string-length(@id)=14][2]//tr[contains(@class,'x-grid-row')]"), 2);
	}

	public void assignQueueToTheFirstUser() {
//		doubleClickNInTable(driver, "//div[contains(@id,'queueassignmentlist') and contains(@id,'innerCt')]//div[contains(@id,'picklistgrid') and string-length(@id) = 17][2]//div[starts-with(@id,'gridpanel') and string-length(@id)=14][1]//tr[contains(@class,'x-grid-row')]", 1);
		doubleClickNInTable(getDriver(), "//div[contains(@id,'picklistgrid') and string-length(@id) = 17][2]//div[starts-with(@id,'gridpanel') and string-length(@id)=14][1]//tr[contains(@class,'x-grid-row')]", 1);
	}

	public void checkIfQueueIsAssignedToUser() throws InterruptedException {
		//number of users roles of right table should be 1 
		assertEquals(numberOfAllVisibleOnes(getDriver(), "//div[contains(@id,'picklistgrid') and string-length(@id) = 17][2]//div[starts-with(@id,'gridpanel') and string-length(@id)=14][2]//tr[contains(@class,'x-grid-row')]"), 1);
	}
}
