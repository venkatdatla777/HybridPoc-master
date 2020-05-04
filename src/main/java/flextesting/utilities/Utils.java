package flextesting.utilities;


import flextesting.client.ClientProvider;
import flextesting.exceptions.NoSoManyOptionsAvailable;
import flextesting.exceptions.NoVisibleElementFoundException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

/**
 * @author Shiyi Chen
 */
public class Utils {
	static Logger log = Logger.getLogger(Utils.class);
	final static int IMPLICIT_WAIT_SECOND = 15;
	/**
	 * wait for 1 sec to ensure that any hint window disappears before further actions
	 * 	Example of a hint window: in decision tree, when you put the mouse on a node, 
	 * 	a hint window appears to show some information about the node. This window blocks 
	 * 	all elements behind it and make them unclickable. To avoid this situation, we first
	 *  move mouse away from the node, then wait 1 sec. 
	 * @param driver
	 * @param webElement
	 * @throws InterruptedException
	 */
	public static void rightClickElement(WebDriver driver, WebElement webElement) throws InterruptedException {
		Actions actions = new Actions(driver);
		//the following try catch block is used to deal with the situation when the element is located
		//	but immediately removed from DOM somehow. In which case we will relocate the element after 1.5 second.
		try {
			actions.contextClick(webElement).build().perform();
    	} catch (StaleElementReferenceException ex) {
    		Thread.sleep(1500);
			actions.contextClick(webElement).build().perform();
    	}
		//move the mouse away from the current location in case a hint shows up and block some elements
		actions.moveByOffset(200, 200).perform();
		Thread.sleep(1000);
	}
	
	public static void doubleClickElement(WebDriver driver, WebElement webElement) {
		Actions actions = new Actions(driver);
		actions.doubleClick(webElement).build().perform();
	}
	
	public static void doubleClickWithJavascript(WebDriver driver, WebElement element) {
	    String jsCode = "var evObj = new MouseEvent('dblclick', {bubbles: true, cancelable: true, view: window});";
	    jsCode += " arguments[0].dispatchEvent(evObj);";
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript(jsCode, element);	    
	}

	public static void mouseOverElement(WebDriver driver, WebElement webElement) {
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).build().perform();
	}
	
	public static void dragAndDrop(WebDriver driver, WebElement source, WebElement destination) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(source)
		   .moveToElement(destination)
		   .release(destination)
		   .build().perform();
	}
	
	public static void pressEscapeKeyMultipleTimes(WebDriver driver, int times) throws InterruptedException {
		if (times < 0) throw new IllegalArgumentException("param has to be >= 0");
		for (int i=0;i<times;i++) {
			log.info("Press the Escape Key");
			pressEscapeKey(driver);
			Thread.sleep(1000);
		}
	}
	private static void clickAndIngoreWebDriverException(WebElement we) {
		try {
			we.click();
		} catch (WebDriverException e){
			log.info("WebDriverException ignored when clicking: " + we);
		} 	
	}
	public static void clickCancelBtnMultipleTimes(WebDriver driver, int times) throws InterruptedException {
		if (times < 0) throw new IllegalArgumentException("param has to be >= 0");
		for (int i=0;i<times;i++) {
//			try {
				log.info("Click the possible [Cancel] then [Yes] button");
				for (WebElement cancelBtn: findAllVisibleOnes(driver, "//button[text()='Cancel']")) {
					try {
						cancelBtn.click();
						for (WebElement yesBtn: findAllVisibleOnes(driver, "//button[text()='Yes']")) {
							clickAndIngoreWebDriverException(yesBtn);
						}
					} catch (WebDriverException e){
						log.info("WebDriverException ignored when attempting to click the [Cancel] button");
					} 
					
				}
//				returnTheVisibleOne(driver, "//button[text()='Cancel']").click();
//				returnTheVisibleOne(driver, "//button[text()='Yes']").click();
//			} catch (WebDriverException ex) {
//				log.info("WebDriverException ignored when attempting to click the [Cancel] button");
//			}
			Thread.sleep(1000);
		}
	}
	
	public static void pressEscapeKey(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ESCAPE).build().perform();
	}
	
	public static void pressDeleteKey(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.DELETE).build().perform();
	}
	
	/**
	 * NOTE: ALWAYS use this to enter a field
	 * 
	 * USAGE: If multiple fields found and the first one is not the visible one, then clearAndEnterTheVisibleField()
	 * will be called (which will wait some seconds and find the visible one to enter)
	 * 
	 * NOTE: CAN NOT be used in iframe
	 * @param driver
	 * @param xpath
	 * @param text
	 */
	public static void clearAndEnter(WebDriver driver, String xpath, String text) {
		try {
			WebElement webElement  = driver.findElement(By.xpath(xpath));
			webElement.clear();
			webElement.sendKeys(text);
		} catch (InvalidElementStateException ex) {
			log.info("field found, but not a visible one, calling clearAndEnterTheVisibleField()");
			clearAndEnterTheVisibleField(driver, xpath, text);
		}
	}
	
	public static void enterTextInIframe(WebDriver driver, String iframXpath, String text) {
		try {
			WebElement webElement = driver.findElement(By.xpath(iframXpath));
			//"\n" is needed to trigger writing to iframe action
			webElement.sendKeys("\n"+text);
		} catch (InvalidElementStateException ex) {
			WebElement webElement = returnTheVisibleOne(driver, iframXpath);
			log.info("Iframe found, but not a visible one, calling returnTheVisibleOne()");
			webElement.sendKeys("\n"+text);
		}
	}
	/**
	 * Usage: use this one to enter a field when the xpath is associated with multiple fields, but only one is visible.
	 * (if using the normal clearAndEnter(), when the first one is invisible, the InvalidElementStateException will occur.)
	 * 
	 * DRAWBACK: when a field is not immediately found, this method will wait some seconds because of returnTheVisibleOne(),
	 * and try again. So performance wise, this method might not be the optimized one. So the clearAndEnter() is always preferred,  
	 * because it only use this method as the last resort.
	 * @param driver
	 * @param xpath
	 * @param text
	 */
	private static void clearAndEnterTheVisibleField(WebDriver driver, String xpath, String text) {
		WebElement webElement = returnTheVisibleOne(driver, xpath);
		webElement.clear();
		webElement.sendKeys(text);
	}

	/**
	 * Mainly used for window buttons like "save", "update" that are initially grayed-out (has "@disabled=" in its html tag)
	 * NOT used for 'element not visible' (in which situation you should use clickTheVisibleOne)
	 * @param driver
	 * @param webElement
	 * @param second
	 */
	public static void waitToBeClickableAndClick(WebDriver driver, WebElement webElement, int second) {
		turnOffImplicitWaits(driver);
		(new WebDriverWait(driver, second)).until(ExpectedConditions.elementToBeClickable(webElement));
		webElement.click();
		turnOnImplicitWaits(driver);
	}
	
	/**
	 * Mainly used for window buttons like "save", "update" that are initially grayed-out (has "@disabled=" in its html tag)
	 * NOT used for 'element not visible' (in which situation you should use clickTheVisibleOne)
	 * @param driver
	 * @param xpath
	 * @param second
	 */
	public static void waitToBeClickableAndClick(WebDriver driver, String xpath, int second) {
		turnOffImplicitWaits(driver);
		WebElement webElement = driver.findElement(By.xpath(xpath));
		(new WebDriverWait(driver, second)).until(ExpectedConditions.elementToBeClickable(webElement));
		webElement.click();
		turnOnImplicitWaits(driver);
	}
	
	public static void waitToBeVisible(WebDriver driver, WebElement webElement, int second) {
		turnOffImplicitWaits(driver);
		(new WebDriverWait(driver, second)).until(ExpectedConditions.visibilityOf(webElement));
		turnOnImplicitWaits(driver);
	}

	public static void waitToBePresent(WebDriver driver, String xpathExpression, int second) {
		turnOffImplicitWaits(driver);
		(new WebDriverWait(driver, second)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathExpression)));
		turnOnImplicitWaits(driver);
	}
	/**
	 * use this when you get 'Element not visible' exception when clicking
	 * @param driver
	 * @param webElement
	 * @param second
	 */
	public static void waitToBeVisibleAndClick(WebDriver driver, WebElement webElement, int second) {
		turnOffImplicitWaits(driver);
		(new WebDriverWait(driver, second)).until(ExpectedConditions.visibilityOf(webElement));
		webElement.click();
		turnOnImplicitWaits(driver);
	}

	/**
	 * use this when you get 'Element not visible' exception when clicking
	 * @param driver
	 * @param second
	 */	
	public static void waitToBeVisibleAndClick(WebDriver driver, String xpath, int second) {
		turnOffImplicitWaits(driver);
		WebElement webElement = driver.findElement(By.xpath(xpath));
		(new WebDriverWait(driver, second)).until(ExpectedConditions.visibilityOf(webElement));
		webElement.click();
		turnOnImplicitWaits(driver);
	}
	
	/**
	 * Might be unstable 
	 * 
	 * Consider Using Thread.sleep instead
	 * 
	 * Mainly used for tab buttons like "update", "delete" that are initially grayed-out (has "x-item-disabled" in its "@class")
	 * sometimes it's not the button itself contains the "x-item-disabled" class, but the tag wrapping it, consider following:
	 * 
	 * e.g. button: //div[@class='x-form-check-wrap']//label[contains(text(),'Auto')]//preceding-sibling::input[1]//following::button[text()='Next'][1]
	 * the table wraps it: //div[@class='x-form-check-wrap']//label[contains(text(),'Auto')]//preceding-sibling::input[1]//following::button[text()='Next'][1]//ancestor::table[contains(@class,'x-item-disabled')][1]
	 * in this case, you need the locator of the table to be used here, not the button itself
	 * @param driver
	 * @param locator
	 * @param timeOutInSecond
	 * @throws InterruptedException
	 */
	public static void waitForElementNotPresent(WebDriver driver, By locator, int timeOutInSecond) throws InterruptedException {
		try {
	    	turnOffImplicitWaits(driver);
	    	log.info("implicit wait turned off");
	    	
	    	for (int second = 0;; second++) {
	    		if (second >= timeOutInSecond) {
					Assert.fail("timeout: element still present");
				}
	    		if (!isElementPresent(driver, locator)) {
	    			break; 
	    		}
		    	Thread.sleep(1000);
		    	log.info("wait for " + locator.toString() + " to not present");
	    	}
		} finally {
			turnOnImplicitWaits(driver);
	    	log.info("implicit wait turned on");
		}
	}

	/**
	 * Mainly used for some weird situations like: you click a button, nothing happens as if you did not click.
	 * So you can keep clicking it until something happens (here we say: until webelement2 shows)
	 * @param driver
	 * @param doubleClick boolean flag
	 * @param element1
	 * @param element2
	 * @param timeOutInSecond
	 * @throws InterruptedException
	 */
	public static void clickElement1UntilElement2AppearBeforeTimeOut(WebDriver driver, boolean doubleClick, WebElement element1, WebElement element2, int timeOutInSecond) throws InterruptedException, NoSuchElementException {
		//long startTime;
		//long estimatedTime;
		for (int second = 0;; second++) {
			//System.out.println("second: " + second);
	    	if (second >= timeOutInSecond) 
	    		Assert.fail("timeout");
	    	if (doubleClick)
	    		doubleClickElement(driver, element1);
	    	else
				element1.click();
	    	//startTime = System.nanoTime();
	    	//try { if (isElementPresent(By.xpath("//div[@class='x-grid-group-title' and contains(text(), 'Current') and contains(text(), 'Record')]"))) break; } catch (Exception e) {}
	    	try { 
	    		//if we use explicit wait, then we don't need to use thread.sleep (not tested)
	    		//if ((new WebDriverWait(driver, 5)).until(ExpectedConditions.numberOfElementsToBe(locator_CurrentRecord_tab_Address, 1)) != null) {
	    		turnOffImplicitWaits(driver);
	    		if (element2.isDisplayed()) {
	    			break; 
	    		}
	    	} catch (Exception e) {
	    		//System.out.println("exception caught: " + second);
	    	} finally {
				//estimatedTime = (System.nanoTime() - startTime)/1000000;
				//System.out.println("elapsed time: " + estimatedTime);
				turnOnImplicitWaits(driver);
	    	}
	    	Thread.sleep(1000);
	    	//System.out.println("sleep");
	    }	
	}
	
	public static void turnOffImplicitWaits(WebDriver driver) {
		//System.out.println("Turned off ===============================");
	    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}

	public static void turnOnImplicitWaits(WebDriver driver) {
	    driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_SECOND, TimeUnit.SECONDS);
	}
	
	/**
	 * NOTE: InterruptedException should be thrown
	 * 
	 * NOTE: Always use this one to click
	 * 
	 * Use this when you don't know there are multiple xpath matches beforehand
	 * @param driver
	 * @param xpath
	 */
	public static void clickByXpath(WebDriver driver, String xpath) {
		try {
			WebElement webElement = driver.findElement(By.xpath(xpath));
			boolean isDisplayed = false;
			try {
				isDisplayed = webElement.isDisplayed();
			} catch (StaleElementReferenceException ex) {
				//wait 2 sec and check again if get this exception while checking the visibility (very rarely)
				log.info("StaleElementReferenceException occurred when checking isDisplayed: " + xpath);
				Thread.sleep(2000);
				webElement = driver.findElement(By.xpath(xpath));
				isDisplayed = webElement.isDisplayed();
			}
			if (isDisplayed) {
				//the following try catch block is used to deal with the situation where the element is located
				//	but covered by other element somehow when we click it, and cause the 'not clickable at point XX'
				//	exception. In this case we will relocate the element after 1 second.
				try {
					webElement.click();
				} catch (WebDriverException ex) {
					log.info("WebDriverException caught when clicking: " + xpath);
					log.info("Clicking again after 1 sec... \n");
//					System.out.println("Clicking " + xpath +" after 1 sec... \n"
//							+"----Reason: element is displayed, but clicking it has caused WebDriverException:\n"
//							+"----Exception message is usually like: \"is not clickable at point (1224, 164)\"");
					Thread.sleep(1000);
					webElement = driver.findElement(By.xpath(xpath));
					try {
						webElement.click();
					} catch (WebDriverException ex2) {
						log.info("WebDriverException caught AGAIN when clicking: " + xpath);
						log.info("Clicking again after 5 sec... \n");
//						System.out.println("Clicking " + xpath +" after 1 sec... \n"
//								+"----Reason: element is displayed, but clicking it has caused WebDriverException:\n"
//								+"----Exception message is usually like: \"is not clickable at point (1224, 164)\"");
						Thread.sleep(5000);
						webElement = returnTheVisibleOne(driver, xpath);
						webElement.click();
					}
				}
			}
			//found one, but hidden
			else {
				log.info("Can't click " + xpath +"\n----Reason: First match is not visible. Calling clickthevisibleone...");
				clickTheVisibleOne(driver, xpath);
			}
		} catch (InterruptedException ex){
			throw new RuntimeException("FATAL ERROR: Interrupted when sleeping...");
		}
	}
	
	/**
	 * NOTE: InterruptedException should be thrown
	 * @param driver
	 * @param xpath
	 */
	private static void clickTheVisibleOne(WebDriver driver, String xpath) {
//		System.out.println("click the visible one");
		//the following try catch block is used to deal with the situation where the element is located
		//	but covered by other element somehow when we click it, and cause the 'not clickable at point XX'
		//	exception. In this case we will relocate the element after 1 second.
		try {
			returnTheVisibleOne(driver, xpath).click();
		} catch (WebDriverException ex) {
			log.info("WebDriverException caught when clicking: " + xpath);
			log.info("Clicking again after 1 sec... \n");
//			System.out.println("Clicking " + xpath +" after 1 sec... \n"
//					+"----Reason: element is displayed, but clicking it has caused WebDriverException:\n"
//					+"----Exception message is usually like: \"is not clickable at point (1224, 164)\"");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex1){
				log.error("FATAL ERROR: Interrupted when sleeping...");
			}
			returnTheVisibleOne(driver, xpath).click();
		}
	}
	
	/**
	 * Usage: use this method whenever there are multiple xpath hits and only one visible.
	 * 
	 * This can happen when: 
	 * 
	 * case 1: When the xpath is very simple and causes multiple hits, but only one is visible.
	 * 
	 * case 2: When open an "Edit" window after closing the "Add" window, all UI element of the "Add"
	 * 	window do not disappear, instead they become 'invisible' (under a tab that has "display: none")
	 * 
	 * NOTE: this method will try again after 2 sec if no visible element found the first time.
	 * @param driver
	 * @param xpath
	 * @return
	 * @throws InterruptedException 
	 */
	public static WebElement returnTheVisibleOne(WebDriver driver, String xpath) {
		WebElement theVisibleOne = findTheVisibleOne(driver, xpath);
		if (theVisibleOne == null) {
			//try again after 2 second
	    	log.info("Trying again after 2 sec...");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ex){
//				System.err.println("Thread is interrupted when sleeping!!!");
				log.error("Thread is interrupted when sleeping!!!\n"+ex.toString(),ex);
			}
			theVisibleOne = findTheVisibleOne(driver, xpath);
			if(theVisibleOne == null)
				throw new NoVisibleElementFoundException("No visible element found");
		}
	    log.info("Returning the visible one");
		return theVisibleOne;
	}
	private static WebElement findTheVisibleOne(WebDriver driver, String xpath) {
		List<WebElement> allFound = driver.findElements(By.xpath(xpath));
	    log.info("Method: findTheVisibleOne() - Total found: " + allFound.size());
		WebElement visibleOne = null;
		for (WebElement webElement: allFound) {
			if (webElement.isDisplayed()) {
				log.info("visible one found: " + webElement.toString());
				visibleOne = webElement;
				break;
			}
		}
		return visibleOne;
	}
	
	/**
	 * @param driver
	 * @param xpath
	 * @param doubleClick whether you need to doubleClick
	 * @param specialRequirement if this web element needs to meet some special condition, eg. webElement -> webElement.getAttribute("checked") == null
	 * @throws InterruptedException
	 */
	public static void clickAllVisibleOnes(WebDriver driver, String xpath, boolean doubleClick, Predicate<WebElement> specialRequirement) throws InterruptedException {
		for(WebElement we: findAllVisibleOnes(driver, xpath)) {
			if (doubleClick)
				doubleClickElement(driver, we);
			else {
				if (specialRequirement == null || specialRequirement.test(we))
					we.click();
			}
		}
	}
	public static int numberOfAllVisibleOnes(WebDriver driver, String xpath) throws InterruptedException {
		return findAllVisibleOnes(driver, xpath).size();
	}
	/**
	 * wait 2 sec then return all visible ones 
	 * @param driver
	 * @param xpath
	 * @return
	 * @throws InterruptedException
	 */
	public static List<WebElement> findAllVisibleOnes(WebDriver driver, String xpath) throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> allVisible = new ArrayList<WebElement>();
		List<WebElement> allFound = driver.findElements(By.xpath(xpath));
		for (WebElement webElement: allFound) {
			if (webElement.isDisplayed()) {
				allVisible.add(webElement);
			}
		}
//		assertEquals(expectAmount, allVisible.size());
		return allVisible;
	}
	
	public static boolean isElementPresent(WebDriver driver, By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	}
	
	/**
	 * <p>Usage 1: use this method to check whether an object exists. 
	 * <br> if specifyWaitTimeIfExpectNotPresent = 0, then expectPresent = true, and vice versa.
	 * <br> if specifyWaitTimeIfExpectNotPresent != 0, then expectPresent = false, and vice versa.
	 * 
	 * <p>Usage 2: use this method to check whether an object (e.g. task, program, ...) is successfully deleted. 
	 * <br>If yes, the NoSuchElementException will occur, and false will be returned. BUT, sometimes (very rarely),
	 * <br> the deleting an object will only make it invisible (e.g. deleting a channel), and it will be then be 
	 * <br> deleted after refreshing the page. In this case, the ElementNotVisibleException occurs.
	 *  
	 * <p>Usage 3: use this method to check whether an object (e.g. task, program, ...) is successfully saved. 
	 * <br>	if the object is visible, assertTrue and click it if needed 
	 * 
	 * <p>NOTE: only check the FIRST MATCH ELEMENT
	 * 
	 * <p>NOTE: if expectPresent is true, implicit wait will be used. So the waitTime does not matter
	 * @param specifyWaitTimeIfExpectNotPresent if expectedPresent is false, then give a short time to wait and check
	 * @param driver
	 * @param xpath
	 * @param expectPresent
	 * @param click
	 * @return
	 * @throws InterruptedException
	 */
	public static boolean isElementDisplayed_clickIfNeeded(int specifyWaitTimeIfExpectNotPresent, WebDriver driver, String xpath, boolean expectPresent, boolean click) throws InterruptedException {
	    try {
	    	// if checking not present, then we don't want to wait implicitly (for like 10 seconds or less depending on the setting).
	    	if (!expectPresent) {
	    		Thread.sleep(specifyWaitTimeIfExpectNotPresent);
	    		turnOffImplicitWaits(driver);
	    	}
	    	WebElement webElement = driver.findElement(By.xpath(xpath));
	    	//the following try catch block is used to deal with the situation when the element is located
	    	//	but immediately removed from DOM somehow. In which case we will relocate the element after 1 second.
	    	try {
	    		//isDisplayed() and click() can both cause the exception
				webElement.isDisplayed();
				if (expectPresent && click) {
					webElement.click();
				}
	    	} catch (WebDriverException ex) {
	    		//the reason that here used to be StaleElementReferenceException, now it's changed to WebDriverException is because
	    		// "not attached to DOM"(StaleElementReferenceException) can happen when calling isDisplayed() and click(), but 
	    		// "not clickable at point XXXX"(WebDriverException) can also happen. Since StaleElementReferenceException is a subclass 
	    		//	of WebDriverException, we make WebDriverException to handle both cases.
	    		Thread.sleep(1000);
	    		webElement = driver.findElement(By.xpath(xpath));
				webElement.isDisplayed();
				if (expectPresent && click) {
					webElement.click();
				}
	    	}
	    	return true;
	    } catch (NoSuchElementException ex) {// | ElementNotVisibleException ex) {
//	    	System.out.println("NoSuchElementException caught.\n----" + xpath);
	    	return false;
	    } finally {
	    	//turn of in case it's turned off. If already on, no harm
	    	turnOnImplicitWaits(driver);
	    }
	}
	
	/**
	 * ONLY for checking deletion for channel in DTcanvas steps
	 * 
	 * Reason: delete channel in the DTcanvas steps will make it invisible in search result, but will NOT
	 *  	cause an ElementNotVisibleException when using isDisplayed() to check its visibility. Hence, 
	 *  	we can use getText() to check the deletion. Because getText() only returns the visible text, and 
	 *  	in this case, it will return an empty string. 
	 * @param driver
	 * @param xpath
	 * @return false: not displaying. true: displaying
	 * @throws InterruptedException
	 */
	public static boolean checkIfDisplayedByGetVisibleText(WebDriver driver, String xpath) throws InterruptedException {
    	WebElement webElement = null;
		String visibleText = null;
    	try {
    		webElement = driver.findElement(By.xpath(xpath));
			visibleText = webElement.getText();
    	} catch (StaleElementReferenceException ex) {
			log.info("StaleElementReferenceException (not attached to DOM) caught when checking visibility " + xpath);
			log.info("Repeat action in 1 sec...");
    		Thread.sleep(1000);
    		webElement = driver.findElement(By.xpath(xpath));
			visibleText = webElement.getText();
		} catch (NoSuchElementException ex) {// | ElementNotVisibleException ex) {
			return false;//not displaying because no such element
		} 
    	if (visibleText.equals(""))
    		return false;//not displaying because it has no visible text 
    	else 
    		return true;//displaying
	}
	
	
	/**
	 * Usage: manually wait/sleep for a certain peroid of time and click if present.
	 * this way, we can shorten the waiting time because the implicit wait usually
	 * takes longer
	 * 
	 * Usage example: click OK in a window that only show up occasionally
	 * @param driver
	 * @param locator
	 * @throws InterruptedException 
	 */
	public static void clickInCaseElementIsPresent(WebDriver driver, By locator) throws InterruptedException {
	    try {
	    	Thread.sleep(1500);
	    	turnOffImplicitWaits(driver);
	    	driver.findElement(locator).click();
	    } catch (NoSuchElementException e) {
	    	log.info("Element ("+ locator.toString() +") is not present. Will not click it");
	    } finally {
	    	turnOnImplicitWaits(driver);
	    }
	}
	
	/**
	 * Get rid of the currency sign such as $, etc..
	 * @param numberText
	 * @return
	 */
	public static String extractNumber(String numberText) {
		return numberText.replaceAll("[^0-9.]", "");
	}


	
	/**
	 * move the mouse away from the current location in case a hint shows up and block some elements
	 * @param driver
	 * @throws InterruptedException
	 */
	public static void moveMouseAway(WebDriver driver) throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveByOffset(200, 200).perform();
		Thread.sleep(1000);
	}

	/**
	 * IF there is no option in the table, then nothing happens.
	 * ELSE:
	 * 	if trying to double click more options than the table contains, then exception will be thrown.
	 * @param driver
	 * @param xpathOfTableOptions
	 * @param n
	 */
	public static void doubleClickNInTable(WebDriver driver, String xpathOfTableOptions, int n) {
		List<WebElement> allOptions = driver.findElements(By.xpath(xpathOfTableOptions));
		if (allOptions.size()>=1) {
			if(n>allOptions.size())
				throw new NoSoManyOptionsAvailable("Trying to double click " + n + " options, but only found " + allOptions.size() + " available");
			for(int i = 0; i<n; i++) {
				doubleClickElement(driver, allOptions.get(i));
			}
		}
	}
	
	/**
	 * Please click the arrow trigger first
	 * @param driver
	 */
	public static void selectAPortfolioFromDropDown(WebDriver driver) {
		HashMap aPortfolioInfo = ClientProvider.getClient().getAvailablePortfolios().get(0);
		String xpathOfAPortfolio = "//*[(self::li or self::div) and "
				+ "(contains(@class,'x-boundlist-item') or @role='option' or contains(@class,'x-combo-list-item')) and "
				+ "contains(text(),'"+aPortfolioInfo.get("portfolioId")+"') "
				+ "and (contains(text(),'"+aPortfolioInfo.get("name")+"') "
						+ "or contains(text(),'"+aPortfolioInfo.get("description")+"'))]";
		clickByXpath(driver, xpathOfAPortfolio);
	}
	
	public static void openInANewWindow(WebDriver driver, String xpathOfLink) throws InterruptedException {
		WebElement link = driver.findElement(By.xpath(xpathOfLink));
		Actions newwin = new Actions(driver);
		newwin.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
		Thread.sleep(3000);
	}

	/**
	 * <p>Normal combination: driver, true, null, null / driver, false, (not null), (not null)
	 * 
	 * <p>1. use for switching to a new window (when total number of windows = 2, you can choose whether to close 
	 * the current window before switching) 
	 * 
	 * <p>2. use for switching to a new window (when total number of windows = 1 because the current window is already closed
	 * BEFORE switching (e.g. queueViewFactory line#93), then you need to get currentWindow and windowPool before
	 * closing the current window. Otherwise, you will get:
	 * <p> 	1. the browserStack might fail with 'unknown server error' 
	 * <p> 	2. the local browser might show in console: [SEVERE] Unable to receive message from renderer"
	 * @param driver
	 * @param closeCurrentTabBeforeSwitching if current tab is not closed yet, you have option to close it before switching (set it to true so that not possible to get three or more tabs)
	 * @param currentWindow if current tab is already closed before switching, then you need to get this before closing it and pass it to the method later
	 * @param windowPool if current tab is already closed before switching, then you need to get this before closing it and pass it to the method later
	 * @throws Exception
	 */
	public static int switchWindow(WebDriver driver, boolean closeCurrentTabBeforeSwitching, String currentWindow, Set<String> windowPool) throws Exception {
		Thread.sleep(3000);
		log.info("=============== Switching started ==============");
		if (currentWindow == null) 
			currentWindow = driver.getWindowHandle();
		if (windowPool == null) {
			windowPool = driver.getWindowHandles();
		}
		log.info("currentWindow: " + currentWindow);
		log.info("windowPool: " + Arrays.toString(windowPool.toArray()));
		//assert allWindows.size() == 2;
		int windowPoolSize = windowPool.size();
		if (windowPoolSize == 2 || windowPoolSize == 1) {
			if (windowPoolSize == 2)
				log.info("switching to a new window (window pool size: 2 - meaning previous window is not yet closed)");
			else
				log.info("switching to a new window (window pool size: 1 - meaning previous window is closed)");
			if (closeCurrentTabBeforeSwitching) {
				for(String window: windowPool) {
					if (window.equals(currentWindow)) {
						log.info("window closed: " + currentWindow);
						driver.close();
					}
				} 
			}
			for(String window: windowPool) {
				if (!window.equals(currentWindow)) {
					driver.switchTo().window(window);
					log.info("Switched to window : " + driver.getWindowHandle());
					break;
				} 
			} 
			log.info("=============== Switching done =================");
		} else {
			throw new Exception("more than two windows (tabs) are opened, CAN NOT switching");
		}
		return windowPoolSize;
	}	
	/**
	 * true: escape any window; 
	 * 
	 * false: only escape error window if found
	 * @param anyWindow
	 * @throws InterruptedException 
	 */
	public static void escapeWindow(WebDriver driver, boolean anyWindow) throws InterruptedException {
		Actions action = new Actions(driver);
		if(anyWindow || isElementDisplayed_clickIfNeeded(1000, driver, "//div[contains(@class,'x-message-box-error')]", true, false)) {
			//if anyWindow is false, meaning only escaping error window, so we log that error window is detected
			if (!anyWindow)
				log.info("Error window detected, escaping it...");
			action.sendKeys(Keys.ESCAPE).build().perform();
			try {
				clickByXpath(driver, "//span[text()='OK' or text()='Yes']");
			} catch (NoVisibleElementFoundException e) {
				//we don't care if there is no OK or Yes button
				log.info("No confirmation window appear when escaping the window");
			}
		}
	}
	
	/**
	 * @param driver
	 * @param fileName
	 * @param takeScreenshot true, false, or null (then it's decided by OS: windows: yes, others: no)
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public static void takeScreenshot(WebDriver driver, String fileName, Boolean takeScreenshot) throws InterruptedException, IOException {
		try {
			if (takeScreenshot == null) {
				if (System.getProperty("os.name").toLowerCase().startsWith("windows"))
					takeScreenshot = true;
			}
			
			if (takeScreenshot) {
				Thread.sleep(1000);
				File scrFile = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(fileName));
				log.info("Screeshot taken: " + fileName);
			}	
		} catch (TimeoutException ex) {
			log.info("Time out ex caught");
			log.info(ex.getMessage());
			log.info("Time out ex message ending");
		}

	}
	
	/**
	 * Sign in to Zscaler
	 * @param driver
	 * @throws InterruptedException
	 * @throws IOException
	 */
	private static boolean triedSignInZscalerInCurrentRun = false;
	public static void signIn(WebDriver driver) throws InterruptedException, IOException {
		//only make this attempt one time in a run (jvm) 
		if (!triedSignInZscalerInCurrentRun) {
			triedSignInZscalerInCurrentRun = true;
			log.info("Sign in to Zscaler if needed");
			if (isElementPresent(driver, By.xpath("//input[@name='lsubmit']"))) {
				log.info("Start Zscaler Sign in");
				log.info("1 " + driver.getCurrentUrl());
				driver.findElement(By.id("username_input")).sendKeys("schen@cmcagile.com");
				takeScreenshot(driver, "usernameEntered.jpg", null);
				log.info("2 " + driver.getCurrentUrl());
				driver.findElement(By.xpath("//input[@name='lsubmit']")).click();
				takeScreenshot(driver, "submitClickedFirstTime.jpg", null);
				log.info("3 " + driver.getCurrentUrl());
				driver.findElement(By.name("passsfc")).sendKeys(System.getProperty("ZscalerPW")); //TODO change this to environment var
				takeScreenshot(driver, "passwordEntered.jpg", null);
				log.info("4 " + driver.getCurrentUrl());
				driver.findElement(By.xpath("//input[@name='bsubmit']")).click();
				takeScreenshot(driver, "submitClickedSecondTime.jpg", null);
				Thread.sleep(5000); 
				log.info("fiveSecondPassed: " + driver.getCurrentUrl());
				takeScreenshot(driver, "fiveSecondPassed.jpg", null);
				log.info("finished Zscaler Sign in");
			} else {
				log.info("No Zscaler Sign in form detected");
			}	
		}
	}
	
	public static void writeToFile(String fileName, String content) throws IOException {
		log.info("Start writting to file: " + fileName);
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		writer.write(content);
		writer.close();
		log.info("Finished writting to file: " + fileName);
	}
	
	public static List<String> readFromFile(String fileName) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(fileName));
		return lines;
	}
	
	/**
	 * @param format: your desired format OR default: yyyy-MM-dd hh:mm:ss
	 * @param date: your desired date OR default: current time
	 * @return
	 */
	public static String getTimeInFormat(String format, Date date) {
		//default format and date(current)
		if (format == null) format = "yyyy-MM-dd HH:mm:ss";
		if (date == null) date = new Date();
		return (new SimpleDateFormat(format)).format(date);
	}
	
	
	/**
	 * Get how many days passed
	 * @param startDate: e.g. '2017-09-27'
	 * @return the days elapsed from the given date to today
	 * @throws ParseException: If the input date format is not sth like "2017-09-27" 
	 */
	public static Long getDaysElapsed(String startDate) throws ParseException {
		String date = startDate.replace("-", "/");
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd"); 
		Date startDateInFormat = new Date();
		startDateInFormat = formatter.parse(date);
		log.info("Start time in format: " + startDateInFormat);
		
		Date currentDate = new Date();
		log.info("Current date: " + currentDate);
		
		long diffDays = (currentDate.getTime() - startDateInFormat.getTime()) / (1000 * 60 * 60 * 24);
		return diffDays;
	}
	
	public static String splitCamelCase(String s) {
		return s.replaceAll(
			      String.format("%s|%s|%s",
			         "(?<=[A-Z])(?=[A-Z][a-z])",
			         "(?<=[^A-Z])(?=[A-Z])",
			         "(?<=[A-Za-z])(?=[^A-Za-z])"
			      ),
			      " "
			   );
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(extractNumber("UK22,222.00"));
		System.out.println(System.getProperty("os.name").toLowerCase());
//		writeToFile("accounts/testFile", "Yes \n");
		String values = "0|0|0|1|||0|1|0|||";
		String[] array = values.split("\\|");
		String[] array2 = values.split("\\|", -1);
		System.out.println(Arrays.toString(array));
		if (array[4].equals(""))
			System.out.println("empty at index 4");
		System.out.println(Arrays.toString(array2));
		System.out.println(readFromFile("clientCode.txt").get(0));
		System.out.println(splitCamelCase("99Bottles"));
		System.out.println(splitCamelCase("HomePhone"));
		System.out.println("Ref #".replaceAll("#", "number").toLowerCase());
	}
}
