package flextesting.pagefactories.associateportalAccountView.customerpage;

import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static flextesting.utilities.Utils.waitToBeClickableAndClick;
import static org.junit.Assert.assertTrue;

public class VerificationWindowFactoryAccountView extends TestBase {

	@FindBy(xpath="//span[@class='x-window-header-text' and text()='Verification']")
	private WebElement wind_Verification;

	@FindBy(xpath="//button[text()='Verified']")
	private WebElement btn_Verified;
	
	
	public void window_Verification() {
		assertTrue(wind_Verification.isDisplayed());
	}

	public void click_SkipVerification() {
		// TODO Auto-generated method stub
	}

	public void check_Verification(String string) {
		getDriver().findElement(By.xpath("(//span[@class='x-window-header-text' and text()='Verification']//following::div[text()='"+string+"'][1]//following::td//div//div[@class='x-grid3-check-col'])[1]")).click();
	}

	/**
	 * wait 4 sec for the page to be fully loaded
	 * @throws InterruptedException
	 */
	public void click_Verified() throws InterruptedException {
		waitToBeClickableAndClick(getDriver(), btn_Verified, 3);
		Thread.sleep(4000);
	}
}
