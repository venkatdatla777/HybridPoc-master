package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.ExtentTest;
import com.qa.ExtentReportListener.ExtentTestManager;
import com.qa.pageObjects.StrategistPortal.Strategist_LandingPagePageObjects;
import com.qa.pageObjects.AssosiciatePortal.Associate_AccountDashboardPage;
import com.qa.pageObjects.AssosiciatePortal.Associate_CreditProfile_Page;
import com.qa.pageObjects.AssosiciatePortal.Associate_LandingPage;
import com.qa.pageObjects.CustomerPortal.User_AccountSummaryPageObjects;
import com.qa.pageObjects.CustomerPortal.User_LandingPageObjects;
import com.qa.pageObjects.CustomerPortal.User_ScheduleAppointmentsPageObjects;
import com.relevantcodes.extentreports.LogStatus;
import flextesting.pagefactories.CommonElementsFactory;
import flextesting.pagefactories.strategistportal.actions.ChannelFactory;
import flextesting.pagefactories.strategistportal.actions.QueueFactory;
import flextesting.pagefactories.strategistportal.decisiontreemanager.*;
import flextesting.pagefactories.strategistportal.documentmanager.DocumentManagerFactory;
import flextesting.strategistportal.DesktopPage;
import flextesting.strategistportal.decisiontreemanager.BatchStrategyCreationStepsPage;
import flextesting.strategistportal.decisiontreemanager.DTContextPortfolioStepsPage;
import flextesting.strategistportal.decisiontreemanager.DTMScheduleStepsPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.util.TestUtil;
import com.qa.util.WebEventListener;

import javax.imageio.ImageIO;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
    public static ExtentTest test;
	public static String Strategist_url= System.getProperty("surl");
	public static String Associate_url= System.getProperty("aurl");
	public static String Customer_url= System.getProperty("curl");
	public static String browser_currennt= System.getProperty("browser");

    public  static Associate_LandingPage associate_LandingPage = null;
    public  static Associate_AccountDashboardPage asociate_AccountDashboardPage = null;
    public  static Associate_CreditProfile_Page associate_CreditProfile_Page = null;
    public  static Strategist_LandingPagePageObjects LandingPage = null;
	public static User_LandingPageObjects User_LandingPage = null;
	public static User_AccountSummaryPageObjects User_AccountSummaryPage = null;
    public static User_ScheduleAppointmentsPageObjects user_ScheduleAppointments = null;
	public static DesktopPage desktopPage = null;
	public static DTContextPortfolioStepsPage dTContextPortfolioStepsPage=null;
	public static DTMScheduleStepsPage dTMScheduleStepsPage=null;
	public static ContextPortfolioFactory contextPortfolioFactory=null;
	public static DTMScheduleFactory dtScheduleFactory=null;
	public static CommonElementsFactory commonElementsFactory=null;
	public static DecisionTreeCreationFactory decisionTreeCreationFactory=null;
	public static BatchStrategyCreationStepsPage batchStrategyCreationStepsPage=null;
	public static DecisionTreeCanvasFactory decisionTreeCanvasFactory=null;
	public static QueueFactory queueFactory=null;
	public static DTMProgramFactory programFactory=null;
	public static ChannelFactory channelFactory=null;
	public static DocumentManagerFactory documentManagerFactory= null;


	//public  CommonActivities_Assosiciate commonActivities_Assosiciate=null;
	String workingDir = System.getProperty("user.dir");

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					workingDir+"/src/main/java/com/qa/config/config.properties");
			prop.load(ip);
           // loadStartUpParameters();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadStartUpParameters(){

        // Strategist_url = System.getenv("url");

    }
	public void loadAllAssociatePortalPageObjects(){

        associate_LandingPage=PageFactory.initElements(getDriver(),Associate_LandingPage.class);
        asociate_AccountDashboardPage=PageFactory.initElements(getDriver(),Associate_AccountDashboardPage.class);
        associate_CreditProfile_Page=PageFactory.initElements(getDriver(),Associate_CreditProfile_Page.class);
      // commonActivities_Assosiciate=new CommonActivities_Assosiciate();
    }
    public void loadAllAdminPortalPageObjects(){
        LandingPage=PageFactory.initElements(getDriver(),Strategist_LandingPagePageObjects.class);
        desktopPage=PageFactory.initElements(getDriver(),DesktopPage.class);
		dTContextPortfolioStepsPage=PageFactory.initElements(getDriver(),DTContextPortfolioStepsPage.class);
		dTMScheduleStepsPage=PageFactory.initElements(getDriver(), DTMScheduleStepsPage.class);
		contextPortfolioFactory=PageFactory.initElements(getDriver(), ContextPortfolioFactory.class);
		dtScheduleFactory=PageFactory.initElements(getDriver(), DTMScheduleFactory.class);
		commonElementsFactory=PageFactory.initElements(getDriver(), CommonElementsFactory.class);
		decisionTreeCreationFactory=PageFactory.initElements(getDriver(), DecisionTreeCreationFactory.class);
		batchStrategyCreationStepsPage=PageFactory.initElements(getDriver(), BatchStrategyCreationStepsPage.class);
		decisionTreeCanvasFactory=PageFactory.initElements(getDriver(), DecisionTreeCanvasFactory.class);
		queueFactory=PageFactory.initElements(getDriver(), QueueFactory.class);
		programFactory=PageFactory.initElements(getDriver(), DTMProgramFactory.class);
		channelFactory=PageFactory.initElements(getDriver(), ChannelFactory.class);
		documentManagerFactory=PageFactory.initElements(getDriver(), DocumentManagerFactory.class);

	}

	public void loadAllCustomerPortalPageObjects(){
		User_LandingPage=PageFactory.initElements(getDriver(),User_LandingPageObjects.class);
		User_AccountSummaryPage=PageFactory.initElements(getDriver(),User_AccountSummaryPageObjects.class);
        user_ScheduleAppointments=PageFactory.initElements(getDriver(),User_ScheduleAppointmentsPageObjects.class);
	}

    public void waitFor(WebElement webElement){
		(new WebDriverWait(driver, 120))
		  .until(ExpectedConditions.visibilityOf(webElement));
	}

	public void waitFor(final By byElementCriteria) {
		//(new WebDriverWait(driver, 120)).until(elementDisplayed(byElementCriteria));

	}
	private ExpectedCondition<Boolean> elementDisplayed(final By byElementCriteria) {
		return new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return (elementIsCurrentlyVisible(byElementCriteria));
			}

			@Override
			public String toString() {
				return "Expecting element is displayed: " + byElementCriteria.toString();
			}
		};
	}

	public boolean elementIsCurrentlyVisible(final By byElementCriteria) {
		try {
			List<WebElement> matchingElements = driver.findElements(byElementCriteria);
			return (!matchingElements.isEmpty() && matchingElements.get(0).isDisplayed());
		} catch (NoSuchElementException noSuchElement) {
			return false;
		} catch (StaleElementReferenceException se) {
			return false;
		} catch (TimeoutException iGuessItsNotThere) {
			return false;
		}
	}
	public WebDriver getWebdriverOf(String browserType) throws MalformedURLException {
		
		// ramakrishnadatla1   TNF7nH7GJtpGpGN4ZrP9
		//  nandyala1    6kBxicBdVnZybNVRbEiC
		//final String USERNAME = "ramakrishnadatla1";
		//final String AUTOMATE_KEY = "TNF7nH7GJtpGpGN4ZrP9";
		
//		final String USERNAME = "nandyala1";
//		final String AUTOMATE_KEY = "6kBxicBdVnZybNVRbEiC";

		final String USERNAME = "ram782";
		final String AUTOMATE_KEY = "XM1X8ks8goynPvY1EPfF";
		
		final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
		String browser = browserType.trim();
		
		if (browser.equalsIgnoreCase("chrome") || browser.equalsIgnoreCase("crome") || browser.equalsIgnoreCase("c")
				|| browser.equalsIgnoreCase("CHROME")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("browser", "Chrome");
			caps.setCapability("browser_version", "69.0");
			caps.setCapability("os", "OS X");
			caps.setCapability("os_version", "Mojave");
			caps.setCapability("resolution", "1280x1024");
			driver = new RemoteWebDriver(new URL(URL), caps);
		} else if (browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("FireFox")
				|| browser.equalsIgnoreCase("ff") || browser.equalsIgnoreCase("FIREFOX")
				|| browser.equalsIgnoreCase("FF")) {
			DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("browser", "Firefox");
		    caps.setCapability("browser_version", "58.0");
		    caps.setCapability("os", "OS X");
		    caps.setCapability("os_version", "Mojave");
		    caps.setCapability("resolution", "1280x1024");
			driver = new RemoteWebDriver(new URL(URL), caps);

		} else if (browser.equalsIgnoreCase("iphone") || browser.equalsIgnoreCase("IPHONE")) {
			DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("browserName", "iPad");
		    caps.setCapability("device", "iPad Pro 12.9 2017");
		    caps.setCapability("realMobile", "true");
		    caps.setCapability("os_version", "11");
			driver = new RemoteWebDriver(new URL(URL), caps);

		} else if (browser.equalsIgnoreCase("safari") || browser.equalsIgnoreCase("Safari")
				|| browser.equalsIgnoreCase("SAFARI")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("browser", "Safari");
			caps.setCapability("browser_version", "12.0");
			caps.setCapability("os", "OS X");
			caps.setCapability("os_version", "Mojave");
			caps.setCapability("resolution", "1280x1024");
			driver = new RemoteWebDriver(new URL(URL), caps);
		} else if (browser.equalsIgnoreCase("IE") || browser.equalsIgnoreCase("ie")
				|| browser.equalsIgnoreCase("internetexplorer") || browser.equalsIgnoreCase("INTERNETEXPLORER")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("browser", "IE");
			caps.setCapability("browser_version", "11.0");
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "10");
			caps.setCapability("resolution", "1280x1024");
			caps.setCapability("ignoreZoomSetting", true);
			driver = new RemoteWebDriver(new URL(URL), caps);
		}

		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loadAllAssociatePortalPageObjects();
        loadAllAdminPortalPageObjects();
		loadAllCustomerPortalPageObjects();
		return driver;

	}
	public void initialization( ) {

	}
	public void initialization(String browser_currennt) {
		//String browserName = prop.getProperty("browser");
		//System.out.println("browser name>>>>>>>>>>>" + browserName);
		try {
			if (browser_currennt.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						workingDir+"/src/main/resources/Drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}  else if (browser_currennt.equals("FF")||browser_currennt.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						workingDir+"/src/main/resources/Drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}else if (browser_currennt.equals("ie")||browser_currennt.equals("InternetExplorer")) {
				System.setProperty("webdriver.ie.driver",
						workingDir + "/src/main/resources/Drivers/iedriverserver.exe");
				driver = new InternetExplorerDriver();
			}
			/// Users/rdatla/Documents/CMCIT/PageObjectModel-master/src/main/java/com/crm/qa/config/config.properties


			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with
			// EventFiringWebDriver
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			loadAllAssociatePortalPageObjects();
			loadAllAdminPortalPageObjects();
			loadAllCustomerPortalPageObjects();
		}catch (Exception e){
			e.printStackTrace();
		}

	}

	public void OpenURL(String URL) {
		driver.get(URL);

	}

	public static WebDriver getDriver() {
		return driver;

	}
	
	public static int generateRandomNumber(){
		Random rand = new Random();


		int randomNum = rand.nextInt((100000 - 1) + 1) + 1;

	    return randomNum;
	}

    public static String capture(WebDriver driver) throws IOException {

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File Dest = new File("src/../ErrImages/" + System.currentTimeMillis() + ".png");

        String errflpath = Dest.getAbsolutePath();

        FileUtils.copyFile(scrFile, Dest);

        return errflpath;
    }


    public static String getScreenShot(){


        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)driver).
                getScreenshotAs(OutputType.BASE64);
     //   String base64Screenshot = "data:image/jpeg;base64,"+((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);


        return base64Screenshot;
    }

    public static void LogThisStepInExtentReport(String stepDetails){
        ExtentTestManager.getTest().log(LogStatus.PASS,stepDetails,
                ExtentTestManager.getTest().addBase64ScreenShot(getScreenShot()));
    }

    public void LogFailureReasonsInExtentReports(String failureReasons){
        ExtentTestManager.getTest().log(LogStatus.FAIL,failureReasons,
                ExtentTestManager.getTest().addBase64ScreenShot(getScreenShot()));
    }

	protected void waitABit(final long timeInMilliseconds) {
		try {
			Thread.sleep(timeInMilliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
