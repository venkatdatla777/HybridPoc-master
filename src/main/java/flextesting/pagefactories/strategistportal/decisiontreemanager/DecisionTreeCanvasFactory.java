package flextesting.pagefactories.strategistportal.decisiontreemanager;

import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static flextesting.utilities.Utils.*;
import static org.junit.Assert.assertTrue;

public class DecisionTreeCanvasFactory extends TestBase {
	@FindBy(xpath="//div[starts-with(@id,'strategygraph') and 'body' = substring(@id, string-length(@id)- string-length('body') +1)]//*[local-name()='svg']//*[local-name()='g']//*[local-name()='text' and contains(text(),'Root')]")
	private WebElement element_RootNode;
	
	@FindBy(name="name")
	private WebElement field_Name;
	
	@FindBy(xpath="//span[text()='Manage Current Node']")
	private WebElement option_ManageCurrentNode;
	
	@FindBy(xpath="//span[starts-with(@id,'nodeedit') and text()='Edit Node']")
	private WebElement wind_EditNode;
	
	@FindBy(xpath="//div[starts-with(@id,'nodeedit')]//label[text()='Check this box to make all child nodes exclusive.']//preceding-sibling::input[@type='button']")
	private WebElement checkBox_ExclusiveCriteria;
	
	@FindBy(xpath="//div[starts-with(@id,'nodeedit')]//descendant::span[text()='Save']//parent::button[1]")
	private WebElement saveBtn_EditNode;
	
	@FindBy(xpath="//span[text()='Manage Child Node(s)']")
	private WebElement option_ManageChildNodes;
	
	@FindBy(xpath="//span[starts-with(@id,'nodelist') and contains(text(),'Manage Child Node(s)')]")
	private WebElement wind_ManageChildNodes;
	
	@FindBy(xpath="//div[starts-with(@id,'nodelist')]//span[text()='Add']//parent::button")
	private WebElement btn_Add_window_ManageChildNodes;

	@FindBy(xpath="//div[starts-with(@id,'nodeedit')]//descendant::span[text()='Save']")
	private WebElement saveBtn_CreateNode;

	@FindBy(xpath="//div[starts-with(@id,'nodelist')]//span[text()='Close']")
	private WebElement btn_close_window_ManageChildNodes;

	@FindBy(xpath="//span[text()='Manage Programs']")
	private WebElement option_ManagePrograms;

	@FindBy(xpath="//span[text()='Assign available action(s) to node']")
	private WebElement btn_AssignAvailableActionsToNode;

	/*
	@FindBy(xpath="//div[starts-with(@id,'nodechannelactions')]//span[text()='Assign available action(s) to node']")
	private WebElement btn_AssignAvailableActionsToNode_window_NodeChannelActions;

	@FindBy(xpath="//div[starts-with(@id,'nodequeueactions')]//span[text()='Assign available action(s) to node']")
	private WebElement btn_AssignAvailableActionsToNode_window_NodeQueueActions;
	*/

	@FindBy(xpath="//div[starts-with(@id,'nodeassignactions')]//span[text()='Submit']//parent::button[1]")
	private WebElement btn_Submit_window_AssignProgramActionToNode;

	@FindBy(xpath="//div[text()='The selected action has been successfully assigned to the node.']//following::span[text()='OK'][1]")
	private WebElement btn_OK_message_Assign$any$ActionToNode;

	@FindBy(xpath="//div[starts-with(@id,'programactionmanage')]//img")
	private WebElement btn_close_window_NodeProgramActions;

	@FindBy(xpath="//span[text()='Manage Channels']")
	private WebElement option_ManageChannels;;

	@FindBy(xpath="//div[starts-with(@id,'nodeassignactions')]//div[starts-with(@id,'gridview')]//table//tr[contains(@class,'x-grid-row')][1]//td[1]")
	private WebElement checkBox_Assign$any$ActionToNode_theFirstOne;

	@FindBy(xpath="//span[text()='Node Channel Actions']//parent::div//following-sibling::div//img")
	private WebElement btn_close_window_NodeChannelActions;

	@FindBy(xpath="//span[text()='Manage Queues']")
	private WebElement option_ManageQueues;;

	/**
	 * "waitToBeVisible()" might be needed if no time waited after clicking the OK button in previous message window 
	 */
	@FindBy(xpath="//span[text()='Node Queue Actions']//parent::div//following-sibling::div//img")
	private WebElement btn_close_window_NodeQueueActions;
	
	public void present_rootNode() {
		assertTrue(element_RootNode.isDisplayed());
		//if (!isDisplaying(driver, locator_element_RootNode))
		//	throw new NoSuchElementException("Root Node can not be found");
	}
	/**
	 * NOTE: the locator of root has this in it: contains(text(),'Root') 
	 * @throws InterruptedException 
	 */
	public void rightClick_RootNode() throws InterruptedException {
		String xpath="//div[starts-with(@id,'strategygraph') and 'body' = substring(@id, string-length(@id)- string-length('body') +1)]//*[local-name()='svg']//*[local-name()='g']//*[local-name()='text' and contains(text(),'Root')]";
		//sleep to see if can get rid of the "element is not aatached to page" error
		Thread.sleep(1500);
		rightClickElement(getDriver(), returnTheVisibleOne(getDriver(), xpath));
	}
	public void rightClick_NodeByName(String nodeName) throws InterruptedException {
		rightClickElement(getDriver(), getDriver().findElement(By.xpath("//*[local-name()='text' and text()='"+nodeName+"']")));
	}

	public void choose_ManageCurrentNode() {
		option_ManageCurrentNode.click();
	}

	public void window_EditNode() {
		assertTrue(wind_EditNode.isDisplayed());
	}

	public void enter_NodeName(String name) {
//		clearAndEnter(field_Name, name);
		clearAndEnter(getDriver(),"//input[@name='name']",name);
	}

	public void enter_Criteria(String criteria) {
		clearAndEnter(getDriver(), "//tr[starts-with(@id,'treestrategycriteriaeditor')]//textarea", criteria);
		checkBox_ExclusiveCriteria.click();
	}
	
	public void enter_Criteria_withoutCheckingCheckBox_ExclusiveCriteria(String criteria) {
		clearAndEnter(getDriver(), "//tr[starts-with(@id,'treestrategycriteriaeditor')]//textarea", criteria);
		checkBox_ExclusiveCriteria.click();
	}

	public void save_EditNode() throws InterruptedException {
		Thread.sleep(9999);
//		waitFor(saveBtn_EditNode);
		waitToBeClickableAndClick(getDriver(), saveBtn_EditNode, 2);
		Thread.sleep(9999);
	}
	
	public void choose_ManageChildNodes() throws InterruptedException {
//		Thread.sleep(9999);
		waitFor(option_ManageChildNodes);
		option_ManageChildNodes.click();
		Thread.sleep(9999);
	}

	public void window_ManageChildNodes() {
		assertTrue(wind_ManageChildNodes.isDisplayed());
	}

	public void click_Add_window_ManageChildNodes() throws InterruptedException {
		Thread.sleep(999);
		waitABit(5000);
		btn_Add_window_ManageChildNodes.click();
	}

	public void window_CreateNode() {
		// TODO Auto-generated method stub
		//assuming true
	}

	public void save_CreateNode() {
		waitToBeClickableAndClick(getDriver(), saveBtn_CreateNode, 3);
		waitABit(5000);
	}

	/**
	 * wait 1.5 sec for the DT to update
	 * @throws InterruptedException
	 */
	public void close_ManageChildNodesWindow() throws InterruptedException {
		btn_close_window_ManageChildNodes.click();
		Thread.sleep(2000);
		waitABit(5000);
	}
	
	public void choose_ManagePrograms() {
		option_ManagePrograms.click();
	}

	public void click_AssignAvailableActionsToNode() {
		String xpath_btn_AssignAvailableActionsToNode = "//span[text()='Assign available action(s) to node']";
		clickByXpath(getDriver(), xpath_btn_AssignAvailableActionsToNode);
		//btn_AssignAvailableActionsToNode.click();
	}

	public void check_AssignAvailableActionsToNode_ActionName(String actionName) throws InterruptedException {
//		By locator_program = By.xpath("//div[starts-with(@id,'nodeassignactions')]//div[text()='"+actionName+"']");
//		driver.findElement(locator_program).click();
		String xpath_action = "//div[starts-with(@id,'nodeassignactions')]//div[text()='"+actionName+"']";
//		clickByXpath(getDriver(), xpath_action);
//		Thread.sleep(25000);
		//waitFor(xpath_action);
		waitABit(20000);
		waitToBeClickableAndClick(getDriver(), getDriver().findElement(By.xpath(xpath_action)), 5);
	}

	public void click_Submit_window_AssignAvailableActionsToNode() {
		waitToBeClickableAndClick(getDriver(), btn_Submit_window_AssignProgramActionToNode, 3);
	}

	public void message_AssignProgramActionToNode_OK() throws InterruptedException {
		btn_OK_message_Assign$any$ActionToNode.click();
		Thread.sleep(2000);
	}

	public void click_close_window_NodeProgramActions() {
		String xpath="//div[starts-with(@id,'programactionmanage')]//img";
		clickByXpath(getDriver(), xpath);
	}

	public void choose_ManageChannels() throws InterruptedException {
		Thread.sleep(999);
		option_ManageChannels.click();
		Thread.sleep(9999);
	}

	public void check_AssignAvailableActionsToNode_theFirstChannel() {
		checkBox_Assign$any$ActionToNode_theFirstOne.click();
	}

	public void message_AssignChannelActionToNode_OK() throws InterruptedException {
		waitToBeVisible(getDriver(), btn_OK_message_Assign$any$ActionToNode, 8);
		btn_OK_message_Assign$any$ActionToNode.click();
		Thread.sleep(2000);
	}

	public void click_close_window_NodeChannelActions() {
		String xpathBtnCloseWindow = "//span[text()='Node Channel Actions']//parent::div//following-sibling::div//img"; 
		clickByXpath(getDriver(), xpathBtnCloseWindow);
	}

	public void choose_ManageQueues() {
		option_ManageQueues.click();
	}

	public void check_AssignAvailableActionsToNode_theFirstQueue() {
		checkBox_Assign$any$ActionToNode_theFirstOne.click();
	}

	public void message_AssignQueueActionToNode_OK() throws InterruptedException {
		//btn_OK_message_Assign$any$ActionToNode.click();
		Thread.sleep(1500);
		waitToBeVisible(getDriver(), btn_OK_message_Assign$any$ActionToNode, 5);
		btn_OK_message_Assign$any$ActionToNode.click();
		Thread.sleep(2000);
	}

	public void click_close_window_NodeQueueActions() {
		String xpath = "//span[text()='Node Queue Actions']//parent::div//following-sibling::div//img";
		clickByXpath(getDriver(), xpath);
	}
	
	@FindBy(xpath="//span[text()='Assign Update Action']")
	private WebElement option_AssignUpdateAction;
	
	public void choose_AssignUpdateAction() {
		option_AssignUpdateAction.click();
	}
	
	public void click_AddUpdateAction() {
		String xpath_btn_AssignAvailableActionsToNode = "//div[starts-with(@id,'nodeupdateactionlist')]//span[text()='Add']//parent::button";
		clickByXpath(getDriver(), xpath_btn_AssignAvailableActionsToNode);
	}
	
	@FindBy(xpath="//div[starts-with(@id,'nodeupdateactionedit')]//following::td[@class='x-trigger-cell']//div")
	private WebElement click_VariableDropdown;
	public void click_VariableDropdown() {
		click_VariableDropdown.click();
	}
	
	public void choose_VariableName(String name) {
		String xpath_btn_AssignAvailableActionsToNode = "//li[contains(@class,'x-boundlist-item')]//div[contains(text(),'"+name+"')]";
		clickByXpath(getDriver(), xpath_btn_AssignAvailableActionsToNode);
	}
	
	public void enter_IfTxt(String value) {
		clearAndEnter(getDriver(), "//div[starts-with(@id,'ace-editor-ext-gen')]/textarea", value);
	}
	
	public void enter_ThenTxt(String value) {
		clearAndEnter(getDriver(), "(//div[starts-with(@id,'ace-editor-ext-gen')]/textarea)[2]", value);
	}
	
	public void save_UpdateActionBtn() {
		int len = getDriver().findElements(By.xpath("//span[starts-with(@id,'button') and text()='Save']")).size() - 1;
		WebElement elm = getDriver().findElements(By.xpath("//span[starts-with(@id,'button') and text()='Save']")).get(len);
		waitToBeClickableAndClick(getDriver(), elm, 5);
//		waitToBeClickableAndClick(getDriver(), saveUpdateActionBtn, 5);
	}
	
	public void click_close_window_UpdateAction() {
		String xpathBtnCloseWindow = "//div[starts-with(@id,'nodeupdateactionlist')]//span[starts-with(@id,'button') and text()='Close']"; 
		clickByXpath(getDriver(), xpathBtnCloseWindow);
	}
	
	@FindBy(xpath="//span[text()='Manage External Entities']")
	private WebElement option_ManageExternalEntities;
	public void choose_ManageExternalEnitity() {
		option_ManageExternalEntities.click();
	}
	
	public void click_close_window_NodeExternalEntityActions() {
		String xpathBtnCloseWindow = "//span[text()='Node External Entity Actions']//parent::div//following-sibling::div//img"; 
		clickByXpath(getDriver(), xpathBtnCloseWindow);
	}
	
}
