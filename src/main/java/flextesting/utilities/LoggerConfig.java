package flextesting.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LoggerConfig {
	static Logger log = Logger.getLogger(LoggerConfig.class);
	public static String logLevel = null;
	public static void config() {
		logLevel = System.getProperty("logLevel"); 
//		logLevel = "DEBUG";
		Properties log4jprop = new Properties();
		log4jprop.setProperty("log4j.rootLogger", logLevel+", CA");
		log4jprop.setProperty("log4j.appender.CA", "org.apache.log4j.ConsoleAppender");
		log4jprop.setProperty("log4j.appender.CA.layout", "org.apache.log4j.PatternLayout");
		log4jprop.setProperty("log4j.appender.CA.layout.ConversionPattern", "%d{HH:mm:ss} -- %-7p %-24c{1}:%-4L %m%n");

//		log4jprop.setProperty("log4j.rootLogger", "DEBUG, FILE");
//		log4jprop.setProperty("log4j.appender.FILE", "org.apache.log4j.RollingFileAppender");
//		log4jprop.setProperty("log4j.appender.FILE.File", "target\\logs\\testlog7.log");
//		log4jprop.setProperty("log4j.appender.FILE.MaxFileSize", "1MB");
//		log4jprop.setProperty("log4j.appender.FILE.MaxBackupIndex", "5");
//		log4jprop.setProperty("log4j.appender.FILE.layout", "org.apache.log4j.PatternLayout");
//		log4jprop.setProperty("log4j.appender.FILE.layout.ConversionPattern", "%d{yyyy-MM-dd HH:mm:ss} -- %-10p %c - %m%n");
		
		//no debug and info level log needed from org.apache.http 
		log4jprop.setProperty("log4j.logger.org.apache.http", "WARN");
		log4jprop.setProperty("log4j.logger.org.apache.http.wire", "WARN");
		PropertyConfigurator.configure(log4jprop);
	}
	public static void test() {
		config();
		log.info("logtest");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void test1() {
		log.info("logtest1");
	}

	public static void main(String[] args) {
		LoggerConfig.test();
		LoggerConfig.test1();
	}

    public static class MvnExecJavaTest {
        static WebDriver driver;

        private static final Thread CLOSE_THREAD = new Thread() {
            @Override
            public void run() {
                driver.quit();
                System.out.println("quit");
            }
        };

        public static ChromeOptions options(boolean headless) {
            ChromeOptions options = new ChromeOptions();
    //		options.addArguments("--start-maximized");
            options.addArguments("--window-size=1440,900");
                options.addArguments("no-sandbox");/////////////////////////////////////////////////////////////////////////////
            if (headless) {
                options.addArguments("headless");
                options.addArguments("disable-gpu");
            }
            return options;
        }

        static {
            Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
            try {
                String ip = System.getProperty("ip");
    //			if (ip == null) ip = "localhost";
    //			if (ip == null) ip = "172.17.0.2";
    //			if (ip == null) ip = "54.174.217.183";
                if (ip == null) ip = "192.168.99.100";
                URL url = new URL("http://"+ip+":4444/wd/hub");

                DesiredCapabilities caps = DesiredCapabilities.chrome();
                caps.setCapability(ChromeOptions.CAPABILITY, options(false));
                DataUtil.setRandomChars(10);
                caps.setCapability("Tags", DataUtil.getRandomChars());

                driver = new RemoteWebDriver(url, caps);
            } catch (MalformedURLException e) {
                throw new IllegalArgumentException("Could not construct Hub URL", e);
            }
    //		driver.manage().window().maximize();
    //		driver.manage().window().setSize(new Dimension(1024,768));
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        }

        public static void main(String[] args) throws InterruptedException, IOException {
            //maybe mvn compile first
            System.out.println("Run this by using: mvn exec:java");

            driver.get("https://en.wikipedia.org/wiki/Main_Page"); // navigate to Wikipedia

            Utils.signIn(driver);

            By searchInput = By.id("searchInput"); // search for "Software"
            driver.findElement(searchInput).sendKeys("Software");
            driver.findElement(searchInput).sendKeys(Keys.ENTER);

    //		Thread.sleep(5000);
    //		File scrFile = ((TakesScreenshot) driver)
    //				.getScreenshotAs(OutputType.FILE);
    //		FileUtils.copyFile(scrFile, new File(("screenshot.jpg")));

    //		if (driver != null) {
    //			System.out.println("quitting...");
    //		  driver.quit();
    //		}

        }
    }
}
