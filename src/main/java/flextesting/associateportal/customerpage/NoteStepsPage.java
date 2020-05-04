package flextesting.associateportal.customerpage;


import com.qa.base.TestBase;
import flextesting.associateportal.defaultdata.ContactAndNoteData;
import flextesting.utilities.Utils;
import org.openqa.selenium.By;

public class NoteStepsPage extends TestBase {

	public void i_double_click_the_note_area() throws Throwable {
		/*
		 * WebElement noteShowingArea =
		 * driver.findElement(By.xpath("//span[@class='accountMemo']"));
		 * WebElement noteInputArea =
		 * driver.findElement(By.xpath("//input[@name='']")); // WebElement
		 * noteInputArea =
		 * driver.findElement(By.xpath("//input[@id="ext-comp-1160"]")); //for
		 * unknown reason, this method does not work.
		 * Utils.clickElement1UntilElement2AppearBeforeTimeOut(driver, true,
		 * noteShowingArea, noteInputArea, 5);
		 */
		// String driverType = System.getProperty("driverType");
		// if (
		// driverType.equals("nfd")
		// || (SeleniumConfig.BROWSER_STACK_BROWSER_TYPE.equals("firefox") &&
		// driverType.equals("sbd"))
		// ) {
		// WebElement wb =
		// driver.findElement(By.xpath("//span[@class='accountMemo']"));
		// Utils.doubleClickWithJavascript(driver, wb);
		// } else {
		// //for unknown reason, clicking only once does not always trigger the
		// input field to show up
		// for (int i=0;i<2;i++) {
		Utils.doubleClickElement(getDriver(), getDriver().findElement(By.xpath("//span[@class='accountMemo']")));
		// Utils.doubleClickElement(driver,
		// driver.findElement(By.xpath("//*[@id='ext-gen555']")));
		Thread.sleep(1000);
	}

	public void i_enter_a_note() throws Throwable {
		Utils.clearAndEnter(getDriver(), "//input[@name='']", ContactAndNoteData.getNote());
	}

	public void i_click_elsewhere() throws Throwable {
		Utils.clickByXpath(getDriver(), "//span[contains(text(),'Notes:')]");
	}

	public void the_note_is_saved() throws Throwable {
		org.junit.Assert.assertTrue(Utils.isElementDisplayed_clickIfNeeded(0, getDriver(),
				"//span[text()='" + ContactAndNoteData.getNote() + "']", true, false));
	}
}
