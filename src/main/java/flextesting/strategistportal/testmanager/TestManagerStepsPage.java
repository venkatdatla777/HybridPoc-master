package flextesting.strategistportal.testmanager;



import com.qa.base.TestBase;
import flextesting.exceptions.DataInconsistencyException;
import flextesting.pagefactories.CommonElementsFactory;
import flextesting.strategistportal.defaultdata.TestManagerData;
import flextesting.utilities.Utils;
import flextesting.utilities.VerifyWithDB;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TestManagerStepsPage extends TestBase {
	static Logger log = Logger.getLogger(TestManagerStepsPage.class);

	private CommonElementsFactory commonElementsFactory;
	private String result = null;

	public void i_choose_one_from_the_Context_Search() throws Throwable {
		commonElementsFactory.arrowTrigger("Context Search:");
		String xpathOfOption = "//div[contains(text(),'(')]";
		Utils.waitToBePresent(getDriver(), xpathOfOption, 15);
		Utils.clickByXpath(getDriver(), xpathOfOption);
	}


	public void i_enter_an_Expression_in_the_Test_Manager_window() throws Throwable {
//		Utils.clearAndEnter(driver, "//textarea", TestManagerData.expression);
		
		getDriver().findElement(By.xpath("//input[@name='contextHolder']")).sendKeys(Keys.TAB, TestManagerData.expression);
//		Thread.sleep(2000);
//		Actions action = new Actions(driver);
//		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		
		}

	public void i_click_the_Expression_Evaluation_button() throws Throwable {
		
	
		//wait 1.5 sec for the evaluating button to be not grayed out 
		Thread.sleep(1500);
//		Utils.clickByXpath(driver, "//span[text()='Expression Evaluation']");
		getDriver().findElement(By.xpath("//*[contains(text(),'Expression Evaluation')]")).click();
		//wait 2 sec for the evaluating process
		Thread.sleep(2000);
	}

	public void i_should_see_the_result_in_the_Test_Manager_window() throws Throwable {
		result = getDriver().findElement(By.xpath("//div[starts-with(@id, 'panel') and contains(@id,'body') and contains(@style,'transparent')]")).getText();
		//if result retrieve no data from UI, then wait 2 sec and give it another chance.
		if (result.equals("")) {
			Thread.sleep(2000);
			result = getDriver().findElement(By.xpath("//div[starts-with(@id, 'panel') and contains(@id,'body') and contains(@style,'transparent')]")).getText();
		}
	}

	public void the_result_matches_the_record_in_the_database() throws Throwable {
		//get the responsible# which is the userLogon # from UI
		String userLogon = Utils.extractNumber(getDriver().findElement(By.xpath("//div[contains(text(),'Responsible#')]")).getText());
		//store value from UI to an array
		String[] resultOfEvaluation = {result};

		//get and store value from DB in the hashmap of the verifyWithDB instance
		VerifyWithDB verifyWithDB = new VerifyWithDB();
		String query = TestManagerData.query + userLogon;
		log.info("Query: " + query);
		verifyWithDB.connectToDatabaseAndRetrieveData(query, TestManagerData.columnNameInDBTable);

		//compare the values (there is only one value to compare here because the array length is 1)
		for(int i=0;i<resultOfEvaluation.length;i++)
			verifyWithDB.verifyData(TestManagerData.columnNameInDBTable[i], resultOfEvaluation[i]);

		String report = verifyWithDB.generateReport();
//		if report is not null, then there is some data inconsistency found
		if(report != null)
			throw new DataInconsistencyException(report);
	}




}
