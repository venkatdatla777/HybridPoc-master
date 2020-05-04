package flextesting;

import flextesting.utilities.RetrieveDataFromDB;
import org.apache.log4j.Logger;

import java.util.HashMap;


public class AppConfig {
	static Logger log = Logger.getLogger(AppConfig.class);
	
	private static HashMap<String, String> config = new HashMap();
	private static boolean hideCustomerContainer = false; 
	private static boolean requireVerification = true; 

	//not used
	private static boolean noContactResultFieldWhenAddingSystemDispositionCode = false;
	private static boolean enableExpressConsentEmail = true;
//	public static boolean hasAgentNotification = false; // this is not read from Appconfig, but flexcenter config
	
	static {
		retrieveAppConfigFromDB();
	}

	private static void retrieveAppConfigFromDB() {
		String query = "select * from ApplicationConfig";
		for (String row: RetrieveDataFromDB.getRows(query)) {
			String[] columns = row.split("\\|");
			if (columns.length != 3) continue;//e.g. [, awShowPaymentEmailReminderR] this array should be skipped because it only has key, no value
			String key = columns[1];
			String value = columns[2];
			if (key.equals("")) continue;
//			System.out.println(Arrays.toString(columns));
			config.put(key, value);
		}
//		System.out.println(Arrays.asList(config));
		parseConfig();
	}
	
	private static void parseConfig() {
//		if (getValue("awEnableExpressConsentEmail").equals("N"))
//			enableExpressConsentEmail = false;
		if (getValue("hideCustomerContainer").equalsIgnoreCase("Y") || getValue("hideCustomerContainer").equalsIgnoreCase("TRUE")) {
			hideCustomerContainer = true;
			log.info("hideCustomerContainer: TURE");
		} else {
			log.info("hideCustomerContainer: FALSE");
		}
		if (getValue("awRequireVerification").equalsIgnoreCase("") //if missing, then no verification (based on ffnperf 7.2) 
				|| getValue("awRequireVerification").equalsIgnoreCase("FALSE")
				|| getValue("awRequireVerification").equalsIgnoreCase("N")) {
			requireVerification = false;
			log.info("requireVerification: FALSE");
		} else {
			log.info("requireVerification: TRUE");
		}
	}
	
	public static boolean isHideCustomerContainer() {
		return hideCustomerContainer;
	}

	public static boolean isRequireVerification() {
		return requireVerification;
	}

	private static String getValue(String key) {
		if (config.containsKey(key))
			return config.get(key);
		else return "";
	}
	
}
