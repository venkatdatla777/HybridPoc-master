package flextesting;/*
package com.cmc.flextesting;

import static com.cmc.flextesting.utilities.Utils.readFromFile;
import static com.cmc.flextesting.utilities.Utils.writeToFile;

import java.io.IOException;
import java.util.List;

import com.cmc.flextesting.webdriver.NormalWebDriver;
import com.cmc.flextesting.webdriver.SpecialBrowserstackDriver;
import com.cmc.flextesting.webdriver.SpecialChromeDriver;
import com.cmc.flextesting.webdriver.SpecialRemoteDriver;

import cucumber.runtime.java.picocontainer.PicoFactory;

public class CustomPicoFactory extends PicoFactory {
	public CustomPicoFactory() {
		//driverType: 
		//Normal => a singleton instance for each JVM instance (so each JVM instance has its own video)
			//nrd => normal remote driver
			//ncd => normal chrome driver
			//nchd => normal chrome headless driver
		//Special => a new instance for every scenario (so each scenario has its own video)
			//scd => special chrome driver
			//srd => special romote driver
		String driverType = System.getProperty("driverType"); 
		if (driverType.equals("nrd") 
				|| driverType.equals("ncd")
				|| driverType.equals("nchd")
				|| driverType.equals("nfd")
				|| driverType.equals("nied")) {
			addClass(NormalWebDriver.class);
			System.out.println("Normal Web Driver Injected");
		} else if (driverType.equals("scd")) {
			addClass(SpecialChromeDriver.class);
			System.out.println("Special Chrome Driver Injected");
		} else if (driverType.equals("srd")) {
			addClass(SpecialRemoteDriver.class);
			System.out.println("Special Remote Driver Injected");
		} else if (driverType.equals("sbd")) {
			sendFirstNtoBrowserstack("re-rerun\\re-rerun.txt");
			addClass(SpecialBrowserstackDriver.class);
			System.out.println("Special Browserstack Driver Injected");
		} else {
			throw new IllegalArgumentException("Invalid driver type: " + driverType);
		}
    }
	
	private static void sendFirstNtoBrowserstack(String filePath) {
		try {
			List<String> fileContent = readFromFile(filePath);
			if (!fileContent.isEmpty()) {
				String[] failed = readFromFile(filePath).get(0).split(" ");
				if (failed.length > AutomatedTestConfig.SELECT_FIRST_N) {
					String firstNinFailed = "";
					for (int i=0;i<AutomatedTestConfig.SELECT_FIRST_N;i++) {
						firstNinFailed += failed[i] + " ";
					}
					System.out.println("Only select first "+AutomatedTestConfig.SELECT_FIRST_N+" failed cases to send to browserstack");
					AutomatedTestConfig.moreThanNFailed = true;
					writeToFile(filePath, firstNinFailed.substring(0, firstNinFailed.length()-1));
				}
			}
		} catch (IOException e) {
			System.out.println("IOException occured when reading/writing re-rerun.txt. Skipping this method: sendFirstNtoBrowserstack");
		}
	}
}
*/
