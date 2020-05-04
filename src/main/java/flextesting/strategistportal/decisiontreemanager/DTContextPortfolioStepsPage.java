package flextesting.strategistportal.decisiontreemanager;


import com.qa.base.TestBase;
import flextesting.pagefactories.strategistportal.decisiontreemanager.ContextPortfolioFactory;
import flextesting.utilities.Utils;
import org.openqa.selenium.By;

public class DTContextPortfolioStepsPage extends TestBase {

	
	
	public void i_choose_a_context_and_a_porfolio() throws Throwable {
	    contextPortfolioFactory.choose_Context_Responsible();
	    contextPortfolioFactory.choose_Portfolio_FromDropDownMenu();
	    //some clients need a long time to load decision trees (too many or too complex)
		Thread.sleep(2000); //sometimes it takes sometime (like 2 sec) for the "Loading..." icon to appear
	    /*By locator_loading = By.xpath("//div[text()='Loading...']");
	    Utils.waitForElementNotPresent(getDriver(), locator_loading, 20);*/
		Thread.sleep(10000);
	}
	
}
