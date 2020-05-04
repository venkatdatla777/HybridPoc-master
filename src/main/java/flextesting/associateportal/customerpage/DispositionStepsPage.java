package flextesting.associateportal.customerpage;


import com.qa.base.TestBase;
import flextesting.AppConfig;
import flextesting.client.ClientProvider;
import flextesting.pagefactories.associateportal.customerpage.DispositionFactory;
import flextesting.utilities.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriverException;

public class DispositionStepsPage extends TestBase {
	static Logger log = Logger.getLogger(DispositionStepsPage.class);
	
	private DispositionFactory dispositionFactory;
	
	public boolean isDispositionNeeded() {
		return dispositionFactory.isDispositionNeeded();
	}

	//@After("@dispositionNeeded")
	public void i_disposition_an_account_using_Noncall_Documentation() throws Throwable {
		dispositionFactory.tryToClickDispositionBtn(AppConfig.isHideCustomerContainer());
		//if not dispostion at the account level, then more steps need to go through 
		if (!AppConfig.isHideCustomerContainer()) {
//			dispositionFactory.click_Disposition_level_Customer();
			dispositionFactory.window_SelectAccountForDisposition();
			if (ClientProvider.selectAllAccountsWhenDisposition)
				Utils.clickAllVisibleOnes(getDriver(), "//input[@type='checkbox']", false, webElement -> webElement.getAttribute("checked") == null);
			//the currently loaded account (usually "auto") is selected by default in the 
			//Select Account For Disposition window, so we don't need to explicitly select it again
			//customerPage.check_SelectAccountForDisposition_Auto();
			//if need to disposition mortgate
			//dispositionFactory.check_SelectAccountForDisposition_Mortgage();
			dispositionFactory.click_Next_window_SelectAccountForDisposition();
			dispositionFactory.window_Disposition();
		}
		//the currently loaded account (usually "auto") is selected by default in the 
			//Select Account For Disposition window, so we don't need to explicitly select it again
			//customerPage.check_SelectAccountForDisposition_Auto();
		//if need to disposition mortgate
//		dispositionFactory.check_SelectAccountForDisposition_Mortgage();
		if (ClientProvider.getCode().equalsIgnoreCase("mmeqa")) {
			Utils.clickByXpath(getDriver(), "//label[text()='Inbound Call']");
			Utils.clickByXpath(getDriver(), "//label[text()='Inbound Direct']");
			Utils.clickByXpath(getDriver(), "//label[text()='Other']");
		} else {
			dispositionFactory.radio_DispositionChannel_NoncallDocumentation();
			//only need to manually select a outcome when this client won't automatically choose one
			if (ClientProvider.processOutComeAutoChosen == false) 
				dispositionFactory.radio_DispositionOutcome(ClientProvider.getClient().getDispositionOutcome());
			//customerPage.click_SubmitAllDispositions();
		}
		dispositionFactory.click_SubmitAndCloseAccount();
		//switchWindow(driver);//switch back to the previous window to logout
	}

	public void i_should_see_the_account_dispositioned() throws Throwable {
		//TODO
	}
	
	public void tearDownAssociatePortal() throws Throwable {
		try {
			i_disposition_an_account_using_Noncall_Documentation();
		} catch (WebDriverException e) {
			log.info("WebDriverException occurs again when disposition, and ingored\n" + e);
		} finally {
			//no matter disposition failed or not, we add the user back to the queue
			log.info("For unknown reason, calling getWindowHandle here can solve this issue: "
					+ "An unknown server-side error occurred while processing the command. "
					+ "This issue is normally solved by getting current window and window pool before closing the "
					+ "current window (here it's the customer/account page), then pass them to switchWindow() below");
			getDriver().getWindowHandle();
			//Thread.sleep(500);
			//no need to logout, simply switch to the previous tab for the login action of the next test
			//logoutFlexStation();
			Utils.switchWindow(getDriver(),false,null,null);
		}
	}
	
	
}
