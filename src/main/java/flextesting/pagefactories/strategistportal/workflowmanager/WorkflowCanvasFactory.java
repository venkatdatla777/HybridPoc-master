package flextesting.pagefactories.strategistportal.workflowmanager;

import com.qa.base.TestBase;
import flextesting.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static flextesting.utilities.Utils.*;
import static org.junit.Assert.assertTrue;


public class WorkflowCanvasFactory extends TestBase {

	@FindBy(xpath="//div[starts-with(@id,'workflowgraph') and contains(@id, '-body')]//*[local-name()='svg']//*[local-name()='g']")
	private WebElement workflowCanvas;

	@FindBy(xpath="//div[starts-with(@id,'workflownodeactionedit') and contains(@id,'body')]//label[text()='Trigger Type:']//following::div[contains(@class,'x-trigger')][1]")
	private WebElement dropdown_TriggerType_window_AddFlowAction;

	@FindBy(xpath="//div[starts-with(@id,'workflownodeactionedit') and contains(@id,'body')]//span[text()='Submit']")
	private WebElement btn_Submit_window_AddFlowAction;

	@FindBy(xpath="//div[starts-with(@id,'workflownodeactionlist') and contains(@id,'body')]//div[1]//table//tr[contains(@class,'x-grid-row')]")
	private WebElement element_programInLeftPanel_window_CurrentActionsOnNode;
	
	@FindBy(xpath = "//div[starts-with(@id,'channelactiongrid')]//div[starts-with(@id,'toolbar')]//table//td//div[@role='button' and contains(@class,'search-trigger')]")
	private WebElement btn_Search;
	
	private String xpathNumberOfPages = "//div[starts-with(@id,'workflownodeaccessassignment')]//div[starts-with(@id,'gridpanel') and contains(@id,'body')]//tr";
	private String xpathArrowRightDouble = "//span[contains(@class,'arrow_right_double')]";
	
	/*
	@FindBy(xpath="")
	private WebElement ;

	@FindBy(xpath="")
	private WebElement ;

	*/

	private TaskFactory task;

	public void dragTaskAndDropToWorkflow(String taskCode, String workflowName) throws InterruptedException {
		task.click_tab_Tasks();
		WebElement theChosenTask = task.search_TaskByCode(taskCode);
		//in case there are more than one workflow, we click the tab of the one we want to modify 
		WebElement tab_WorkflowCanvas = getDriver().findElement(By.xpath("//div[starts-with(@id,'tabpane')]//span[text()='"+workflowName+"']"));
		tab_WorkflowCanvas.click();
		dragAndDrop(getDriver(), theChosenTask, workflowCanvas);
	}

	public void rightclick_taskNode(String taskCode) throws InterruptedException {
		System.out.println("taskCode :" + taskCode);
		By nodeLocator = By.xpath("//div[starts-with(@id,'workflowgraph') and contains(@id, '-body')]//*[local-name()='g']//*[local-name()='text' and starts-with(text(),'"+taskCode+"')]");
		System.out.println("nodeLocator :" + nodeLocator);
		rightClickElement(getDriver(), getDriver().findElement(nodeLocator));
	}

	public void chooseActionFromRightClickMenuOfNode(String action) {
		By actionLocator = By.xpath("//span[text()='"+action+"']");
		getDriver().findElement(actionLocator).click();
	}

	public void dragActionToLeftPanel() {
		WebElement firstAction = getDriver().findElement(By.xpath("//div[starts-with(@id,'nodeactionlist') and 'body' = substring(@id, string-length(@id)- string-length('body') +1)]//table//tr[2]"));
		WebElement leftPanel = getDriver().findElement(By.xpath("//div[starts-with(@id,'workflownodeactionlist') and contains(@id,'body')]//div[1]"));
		dragAndDrop(getDriver(), firstAction, leftPanel);
	}

	public void chooseAsTriggerType(String triggerType) {
		dropdown_TriggerType_window_AddFlowAction.click();
		getDriver().findElement(By.xpath("//li[text()='"+triggerType+"']")).click();
	}

	/**
	 * wait 1 sec for the saving process
	 * @throws InterruptedException
	 */
	public void click_Submit_window_AddFlowAction() throws InterruptedException {
		btn_Submit_window_AddFlowAction.click();
		Thread.sleep(1000);
	}

	public void present_chosenProgramInLeftPanel() {
		assertTrue(element_programInLeftPanel_window_CurrentActionsOnNode.isDisplayed());
	}

	public void click_close_window_CurrentActionsOnNode() throws Exception {
		clickByXpath(getDriver(), "//span[contains(text(), 'Current') and contains(text(),'Action(s) on Node: ')]//following::img[1]");
	}

	public void i_drag_the_selected_task_to_the_workflow_canvas(String search, String workflowName) throws InterruptedException {
		task.click_tab_Tasks();
		WebElement theChosenTask = task.search_TaskByCode(search);
		System.out.println("search : " + search);
		//in case there are more than one workflow, we click the tab of the one we want to modify 
		WebElement tab_WorkflowCanvas = getDriver().findElement(By.xpath("//div[starts-with(@id,'tabpane')]//span[text()='Standard Financial Statement']"));
		tab_WorkflowCanvas.click();
		Thread.sleep(9999);
		dragAndDrop(getDriver(), theChosenTask, workflowCanvas);
	}
	
	public void i_drag_the_selected_task_to_the_workflow_canvas_follow_YSD(String search, String taskCode) throws InterruptedException {
		task.click_tab_Tasks();
		WebElement theChosenTask = task.search_TaskByCode(search);
		System.out.println("search : " + search);
		//in case there are more than one workflow, we click the tab of the one we want to modify 
		WebElement tab_WorkflowCanvas = getDriver().findElement(By.xpath("//div[starts-with(@id,'workflowgraph') and contains(@id, '-body')]//*[local-name()='g']//*[local-name()='text' and starts-with(text(),'"+taskCode+"')]"));
//		tab_WorkflowCanvas.click();
		dragAndDrop(getDriver(), theChosenTask, tab_WorkflowCanvas);
	}
	
	public void i_drag_the_selected_task_to_the_workflow_canvas_follow_Jnt(String search, String taskCode) throws InterruptedException {
		task.click_tab_Tasks();
		WebElement theChosenTask = task.search_TaskByCode(search);
		System.out.println("search : " + search);
		//in case there are more than one workflow, we click the tab of the one we want to modify 
		WebElement tab_WorkflowCanvas = getDriver().findElement(By.xpath("//div[starts-with(@id,'workflowgraph') and contains(@id, '-body')]//*[local-name()='g']//*[local-name()='text' and starts-with(text(),'"+taskCode+"')]"));
//		tab_WorkflowCanvas.click();
		dragAndDrop(getDriver(), theChosenTask, tab_WorkflowCanvas);
	}
	
	
	public void i_drag_the_selected_item_to_the_workflow_Node(String items, String taskCode) throws InterruptedException {
		WebElement item = getDriver().findElement(By.xpath("//div[starts-with(@id,'channelactiongrid')]//div[starts-with(@id,'gridview')]//table//tr[contains(@class,'x-grid-row')]"));
		WebElement tab_WorkflowCanvas = getDriver().findElement(By.xpath("//div[starts-with(@id,'workflowgraph') and contains(@id, '-body')]//*[local-name()='g']//*[local-name()='text' and starts-with(text(),'"+taskCode+"')]"));
		dragAndDrop(getDriver(), item, tab_WorkflowCanvas);
	}
	
	public void i_drag_the_selected_programs_item_to_the_workflow_Node(String items, String taskCode) throws InterruptedException {
		WebElement item = getDriver().findElement(By.xpath("//div[starts-with(@id,'programactiongrid')]//div[starts-with(@id,'gridview')]//table//tr[contains(@class,'x-grid-row')]"));
		WebElement tab_WorkflowCanvas = getDriver().findElement(By.xpath("//div[starts-with(@id,'workflowgraph') and contains(@id, '-body')]//*[local-name()='g']//*[local-name()='text' and starts-with(text(),'"+taskCode+"')]"));
		dragAndDrop(getDriver(), item, tab_WorkflowCanvas);
	}
	
	public void rightClickTaskNode(String taskCode) throws InterruptedException {
		System.out.println("taskCode :" + taskCode);
		By nodeLocator = By.xpath("//div[starts-with(@id,'workflowgraph') and contains(@id, '-body')]//*[local-name()='g']//*[local-name()='text' and starts-with(text(),'"+taskCode+"')]");
		System.out.println("nodeLocator :" + nodeLocator);
		rightClickElement(getDriver(), getDriver().findElement(nodeLocator));
	}
	
	public void click_MoveAllLeftRowsToRightSide() throws InterruptedException {
		Thread.sleep(999);
		int len =  getDriver().findElements(By.xpath(xpathNumberOfPages)).size();
//		String txt = getDriver().findElement(By.xpath(xpathNumberOfPages)).getText();
		System.out.println("len :" + len);
		
		for(int i = 1; i <= len-1; i++) {
			
			clickByXpath(getDriver(), xpathArrowRightDouble);
			
		}
	}
	
	public void chooseActionFromRightClickMenuOfNodeOfTheSelectedTask(String action) {
		By actionLocator = By.xpath("(//span[text()='"+action+"'])[2]");
		getDriver().findElement(actionLocator).click();
	}
	
	public void clickSubmitbtn() throws InterruptedException {
		Thread.sleep(999);
		clickByXpath(getDriver(), "//span[text()='Submit']");
		Thread.sleep(3000);
	}
	
  public void i_click_the_To_dropDown_and_select_the_task(String task) throws Throwable {
	  Thread.sleep(999);
		clickByXpath(getDriver(), "//label[text()='To:']//following::input[1]");
		Thread.sleep(999);
		By taskLocator = By.xpath("//li[text()='"+task+"']");
		getDriver().findElement(taskLocator).click();
		Thread.sleep(3000);
	}
  
  public void clickDropDownAndSelectTheVariable(String variable) throws Throwable {
	  Thread.sleep(999);
		clickByXpath(getDriver(), "//label[text()='Variable:']//following::input[1]");
		Thread.sleep(999);
		By variableLocator = By.xpath("//div[text()='"+variable+"']");
		getDriver().findElement(variableLocator).click();
		Thread.sleep(3000);
	}
  
  public void click_tab_Channels() throws InterruptedException {
		clickByXpath(getDriver(),
				"//div[starts-with(@id,'tabbar')]//div[starts-with(@id,'tab')]//button//span[text()='Channels']");
		Thread.sleep(5000);
	}
  
  public void click_tab_Programs() throws InterruptedException {
		clickByXpath(getDriver(),
				"//div[starts-with(@id,'tabbar')]//div[starts-with(@id,'tab')]//button//span[text()='Programs']");
		Thread.sleep(5000);
	}
  
  public void search_Email(String email) throws InterruptedException {
	  Thread.sleep(500);
		clearAndEnter(getDriver(), "//div[starts-with(@id,'channelactiongrid')]//table//input[starts-with(@id,'triggerfield')]",
				email);
		btn_Search.click();
		Thread.sleep(1500);
	}
  
  public void chooseActionFromRightClickMenuOfNodeOfTheTask(String action) {
		By actionLocator = By.xpath("//span[text()='"+action+"']");
		getDriver().findElement(actionLocator).click();
	}
  
  public void clickAddbtn() throws InterruptedException {
		Thread.sleep(999);
		clickByXpath(getDriver(), "(//span[text()='Add'])[6]");
		Thread.sleep(3000);
	}
  
  public void enter_Text_as_true(String txt) throws InterruptedException {
		clearAndEnter(getDriver(), "(//table[starts-with(@id,'workflowcriteriaeditor') and contains(@style,'fixed')]//textarea)[1]", txt);
		Thread.sleep(1000);
	}
  
  public void enter_billingCycle_Text(String txt) throws InterruptedException {
		clearAndEnter(getDriver(), "(//table[starts-with(@id,'workflowcriteriaeditor') and contains(@style,'fixed')]//textarea)[2]", txt);
		Thread.sleep(1000);
	}
  
  public void clickSavebtn() throws InterruptedException {
		clickByXpath(getDriver(), "//div[starts-with(@id,'workflownodeactionupdatevariableedit')]//span[text()='Save']");
		Thread.sleep(1000);
	}
  
  public void clickClosebtn() throws InterruptedException {
		clickByXpath(getDriver(), "//div[starts-with(@id,'workflownodeactionupdatevariablelist')]//span[text()='Close']");
		Thread.sleep(1000);
	}
  
  public void clickCustomerPortalSubMenubtn(String arg1) throws InterruptedException {
		clickByXpath(getDriver(), "//span[text()='"+arg1+"']");
		Thread.sleep(1000);
	}
  
  public void enter_Menu_Link_Text(String arg1) throws InterruptedException {
		clearAndEnter(getDriver(), "//label[text()='Menu Link Text:']//following::input", arg1);
		Thread.sleep(1000);
	}
  
  public void clickAdd_Sub_Menu_btn() throws InterruptedException {
		clickByXpath(getDriver(), "//span[text()='Add Sub Menu']");
		Thread.sleep(1000);
	}
  
  public void enter_Sub_Menu_Title_Text(String arg1) throws InterruptedException {
		clearAndEnter(getDriver(), "(//label[text()='Sub Menu Title Text:']//following::input)[1]", arg1);
		Thread.sleep(1000);
	}
  
  public void i_click_on_Workflow_Primary_Flow_dropDown_and_select_as(String arg1) throws Throwable {
	  Thread.sleep(999);
		clickByXpath(getDriver(), "//label[text()='Workflow (Primary Flow):']//following::input");
		Thread.sleep(999);
		By arg1Locator = By.xpath("//li[text()='"+arg1+"']");
		getDriver().findElement(arg1Locator).click();
		Thread.sleep(1000);
	}
  
  public void clickSaveClose_btn() throws InterruptedException {
		clickByXpath(getDriver(), "(//span[text()='Save & Close'])[2]");
		Thread.sleep(1000);
	}
  
  public void clickOnSaveClose_btn() throws InterruptedException {
		clickByXpath(getDriver(), "(//span[text()='Save & Close'])[1]");
		Thread.sleep(1000);
	}
  
  public void click_on_Schedule_Operation_dropDown_button_and_select_Publish_Schedule() throws Throwable {
	  clickByXpath(getDriver(), "//span[text()='Schedule Operation:']");
		Thread.sleep(999);
		clickByXpath(getDriver(), "//span[text()='Publish Schedule']");
		Thread.sleep(999);
		clickByXpath(getDriver(), "//span[text()='Yes']");
		Thread.sleep(3000);
		
		try {
			Utils.clickByXpath(getDriver(), "//span[text()='Yes']");
		} catch (Exception ex) {
//			log.info("Skip Verification window is not found");
//			log.debug("Skip Verification window is not found");
		}
	}

}
