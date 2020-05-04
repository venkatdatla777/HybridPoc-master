package flextesting.utilities;

import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Shiyi Chen
 *
 */
public class WaitTypes extends TestBase {
	
	public WebElement waitForElement(By locator, int timeout){
		WebElement element = null;
		try{	
			System.out.println("waiting...");
			WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			System.out.println("waiting ends, element becomes visible");
		} catch(Exception e) {
			System.out.println("Element: " + locator.toString() + " \nNot visible after waiting " + timeout + " seconds");
		}
		return element;
	}
	
	public WebElement waitForElementToBeClickable(By locator, int timeout) throws Exception{
		WebElement element = null;
		//try{	
		System.out.println("waiting to be clickable...");
		WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
		element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		//} catch(Exception e) {
		//	throw e;
		//}
		return element;
	}
	
	
}
