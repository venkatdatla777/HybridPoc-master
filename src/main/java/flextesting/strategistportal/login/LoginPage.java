package flextesting.strategistportal.login;


import com.qa.base.TestBase;
import flextesting.client.ClientProvider;
import flextesting.exceptions.NoClientCodeSpecified;
import flextesting.utilities.UpdateAndRetrieveDataFromDBForLogin;
import flextesting.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author Shiyi Chen
 *
 */
public class LoginPage extends TestBase {
	//private static Logger log = LoggerFactory.getLogger(LoginPage.class.getName());

	public void i_am_on_Login_Page() throws Throwable {
		String strategistPortalURL = System.getProperty("FlexCenterURL");
		if (strategistPortalURL == null)
			throw new InterruptedException("Strategist Portal URL is not provided");
		getDriver().get(strategistPortalURL);
	}

	public void i_enter_username_as_and_I_enter_password_as_and_I_click_the_Login_button(String arg1, String arg2)
			throws Throwable {
		// if not already logged in (because previously not logged out.), then
		// do login.
		// title matches the pattern means already logged in.
		// if (!getDriver().getTitle().matches("(FlexCenter Desktop *)|(CMC*)"))
		// {
		getDriver().findElement(By.name("j_username")).clear();
		getDriver().findElement(By.name("j_username")).sendKeys(arg1);
		Utils.clearAndEnter(getDriver(), "//input[@name='j_password']", arg2);
		// getDriver().findElement(By.name("j_password")).clear();
		// getDriver().findElement(By.name("j_password")).sendKeys(arg2);
		Thread.sleep(3999);
		getDriver().findElement(By.cssSelector("input.btn-login")).click();
		// }
	}

	public String getFailMessage() {
		return getDriver().findElement(By.cssSelector("BODY")).getText();

	}

	public boolean isStillOnLoginPage() {
		return isElementPresent(By.cssSelector("input.btn-login"));
	}

	public void i_have_logged_in_the_Strategist_Portal() throws Throwable {
		try {
			List<String> users = UpdateAndRetrieveDataFromDBForLogin.retrieveUsersCreated();
			Collections.shuffle(users);
			String UserName = users.get(0);
			String Password = "Test123!";
			loginFlexCenter(UserName, Password);
		} catch (UnhandledAlertException ex) {
			// you can use WebDriverWait or sleep the thread to wait for the
			// alert
			// new
			// WebDriverWait(driver).until(ExpectedConditions.alertIsPresen‌​t())
			getDriver().switchTo().alert().accept();
			//log.debug("Accepted the alert.");
			// if still logged in, then no need to login again. BUT this is not
			// possible because cookies are deleted before running every feature
			// if (!getDriver().getTitle().matches("(FlexCenter Desktop
			// *)|(CMC*)")) {

			try {
				loginFlexCenter(ClientProvider.getClient().getUsername(), ClientProvider.getClient().getPassword());
			} catch (UnhandledAlertException ex2) {
				getDriver().switchTo().alert().accept();
				//log.debug("Accepted the second alert.");
				loginFlexCenter(ClientProvider.getClient().getUsername(), ClientProvider.getClient().getPassword());
			}
		}
	}

	public void i_logout_the_Strategist_Portal() throws Throwable {
		Thread.sleep(1500);
		getDriver().findElement(By.xpath("//button/child::span[text()='Start']")).click();
		getDriver().findElement(By.xpath("//span[text()='Logout']")).click();
		getDriver()
				.findElement(
						By.xpath("//div[text()='Are you sure you want to logout?']//following::span[text()='Yes']"))
				.click();
	}

	public void loginFlexCenter(String loginName, String password) throws Throwable {
		i_am_on_Login_Page();
		i_enter_username_as_and_I_enter_password_as_and_I_click_the_Login_button(loginName, password);
		login_should_be_successful();
	}

	public void login_should_be_successful() {
		// TODO Auto-generated method stub

	}

	public void the_testing_client_is_provided_as_system_property() throws Throwable {
		System.out.println("CLIENT CODE : " +  System.getProperty("CLIENT_CODE"));
		System.out.println("loginName : " +  System.getProperty("loginName"));
		System.out.println("password : " +  System.getProperty("password"));
		String clientCode = System.getProperty("CLIENT_CODE");
		if (clientCode == null)
			throw new NoClientCodeSpecified("No client/region code provided");
		else if (clientCode.equals("TNA"))
			throw new RuntimeException("TNA maybe outdated, abort tesing...");
		else if (clientCode.equals("FLXQA"))
			throw new RuntimeException("FLX has customizations for channel, program, etc... auto-testing is NOT ready");
		//log.info("Client: " + clientCode);
		ClientProvider.writeClientCodeToFile(clientCode);
	}

	public void login_fail_message_should_show_and_I_am_still_on_the_login_page() throws Throwable {
		// Warning: assertTextPresent may require manual changes
		assertTrue(getDriver().findElement(By.cssSelector("BODY")).getText()
				.matches("^[\\s\\S]*Invalid User Name or Password\\. Please try again\\.[\\s\\S]*$"));
		assertTrue(isElementPresent(By.cssSelector("input.btn-login")));
		// driver.close();
	}

	public void i_am_logged_in_the_Strategist_Portal_with_super_user() throws Throwable {
		loginFlexCenter(System.getProperty("loginName"), System.getProperty("password"));
	}

	private boolean isElementPresent(By by) {
		try {
			getDriver().findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public void quitBrowser() {
		getDriver().quit();
	}

}
