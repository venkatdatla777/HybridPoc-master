package flextesting.associateportal.login;


import com.qa.base.TestBase;
import flextesting.utilities.UpdateAndRetrieveDataFromDBForLogin;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;

import java.util.Collections;
import java.util.List;

/**
 * @author Shiyi Chen
 * 
 */
public class FlexSatationLoginPage extends TestBase {

	static Logger log = Logger.getLogger(FlexSatationLoginPage.class);

	private void i_am_logged_in_the_Associate_Portal() throws Throwable {
		String associatePortalURL = System.getProperty("FlexStationURL");
		if (associatePortalURL == null)
			throw new InterruptedException("Associate Portal URL is not provided");
		getDriver().get(associatePortalURL);
//		Utils.signIn(driver);
//		assertEquals("CMC-FlexStation", driver.getTitle());
		List<String> users = UpdateAndRetrieveDataFromDBForLogin.retrieveUsersCreated();
		Collections.shuffle(users);
		String UserName = users.get(0);
		System.out.println("*********"+UserName+"********");
		log.info("*********"+UserName+"********");
		getDriver().findElement(By.name("j_username")).clear();
		//getDriver().findElement(By.name("j_username")).sendKeys(ClientProvider.getClient().getUsername());
		getDriver().findElement(By.name("j_username")).sendKeys(UserName);
		getDriver().findElement(By.name("j_password")).clear();
		//getDriver().findElement(By.name("j_password")).sendKeys(ClientProvider.getClient().getPassword());
		getDriver().findElement(By.name("j_password")).sendKeys("Test123!");
		getDriver().findElement(By.cssSelector("input.btn-login")).click();
		//assertTrue(Pattern.compile("^CMC.*|^Collections.*").matcher(driver.getTitle()).find());
	}
	

	public void loginAssociatePortal() throws Throwable {
//		startUp.init();
		try {
			i_am_logged_in_the_Associate_Portal();
		} catch (UnhandledAlertException ex) {
			getDriver().switchTo().alert().accept();	
			i_am_logged_in_the_Associate_Portal();
		}
	}

}
