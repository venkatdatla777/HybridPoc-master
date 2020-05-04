
package flextesting.pagefactories.associateportal;

import com.qa.base.TestBase;
import flextesting.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static flextesting.utilities.Utils.clickByXpath;

public class AssociatePortalCommonFactory extends TestBase {
	private String xpathOfPickerPaymentDate = "//table[@class='x-date-inner']";

	/**
	 * @param daysFromToday: 0 => today, 1 => tomorrow, etc...
	 */
	public void selectADate(int daysFromToday) {
		WebElement picker_PaymentDate = Utils.returnTheVisibleOne(getDriver(), xpathOfPickerPaymentDate);
		if (daysFromToday == 0) {
			picker_PaymentDate.findElement(By.xpath("//td[contains(@class,'x-date-today')]")).click();
		} else {
//			picker_PaymentDate.findElement(By.xpath("//td[contains(@class,'x-date-today')]//following::td[contains(@class,'x-date-active')]["+daysFromToday+"]")).click();
			try {
				picker_PaymentDate.findElement(By.xpath("//td[contains(@class,'x-date-active')]["+(daysFromToday+1)+"]")).click();
			} catch (NoSuchElementException ex) {
				//near the end of month, you could find this exception occur. Need to go to the next month, and select from there
				//a[@role='button' and contains(@title,'Next Month')]
				clickByXpath(getDriver(), "//a[@href='#' and contains(@title,'Next Month')]");
				picker_PaymentDate.findElement(By.xpath("//td[contains(@class,'x-date-active')]["+daysFromToday+"]")).click();
			}
		}
	}
	
}
