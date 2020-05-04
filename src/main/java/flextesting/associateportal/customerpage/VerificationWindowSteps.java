package flextesting.associateportal.customerpage;


import com.qa.base.TestBase;
import flextesting.AppConfig;
import flextesting.pagefactories.associateportalAccountView.AssociatePortalCommonFactoryAccountView;
import flextesting.utilities.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;

public class VerificationWindowSteps extends TestBase {
	static Logger log = Logger.getLogger(VerificationWindowSteps.class);
	private AssociatePortalCommonFactoryAccountView verificationWindowFactoryAccountView;

	public void verifyInfo() throws Throwable {
		if (AppConfig.isRequireVerification()) {
			// maybe skip verifying the verification window for now because
			// there are two different versions
			// verificationWindowFactoryAccountView.window_Verification();
			String browserName = (String) ((JavascriptExecutor) getDriver()).executeScript("return navigator.userAgent;");
	        System.out.println("Browser name : " + browserName);
			// if (System.getProperty("driverType").equals("nfd")) {
			if (browserName.equals("Firefox")) {
				Utils.clickAllVisibleOnes(getDriver(), "//div[@class='x-grid3-check-col']", false, null);
				Utils.clickByXpath(getDriver(), "//button[text()='Verified']");
			} else {
				Utils.clickByXpath(getDriver(), "//button[text()='Skip Verification']");
			}

		}
		// if (ClientProvider.hasAgentNotification){
		// minimize notification
		try {
			Utils.clickByXpath(getDriver(), "//div[contains(@class,'x-tool-minimize')]");
		} catch (Exception ex) {
			log.info("The Minimizing button of the Agent Notification window is not found");
		}
		// Exception will ignore any type of exception if the minimizing button
		// is not found.
		// }
		// verificationWindowFactoryAccountView.check_Verification("Customer Name");
		// verificationWindowFactoryAccountView.check_Verification("Social Security
		// Number");
		// verificationWindowFactory.click_Verified();
		// verificationWindowFactoryAccountView.click_Verified();
		
		try {
			Utils.clickByXpath(getDriver(), "//button[text()='Yes']");
		} catch (Exception ex) {
//			log.info("Skip Verification window is not found");
			log.debug("Skip Verification window is not found");
		}
	}
}
