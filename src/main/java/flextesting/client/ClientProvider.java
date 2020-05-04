package flextesting.client;

import flextesting.utilities.Utils;
import org.apache.log4j.Logger;

import java.io.IOException;

public class ClientProvider {
	static Logger log = Logger.getLogger(ClientProvider.class);
	private static String CODE = null;
	public static boolean preparingUsersAndClientCodeFileIsSet = false;

	public static boolean noContactResultFieldWhenAddingSystemDispositionCode = false;
	public static boolean hasAgentNotification = false;
	public static boolean enableExpressConsentEmail = true;
	
	public static boolean processOutComeAutoChosen = false;//when disposition, select non-call documentation will automatically choose a outcome
	public static boolean selectAllAccountsWhenDisposition = true;
	
	public static String portfolioIdFocusedOn = "";
	public static String portfolioNameFocusedOn = "";
//	static {
//		retrieveCodeFromFile();
//		getClient();//just to set flags
//	}
	/**
	 * This method should only be called when doing User Preparation
	 * because it's the only time we change the clientCode.txt 
	 * @param clientCode
	 * @throws IOException
	 */
	public static void writeClientCodeToFile(String clientCode) throws IOException {
		Utils.writeToFile("clientCode.txt", clientCode);
		//Update ClientProvider.CODE because you now have a new client code written to the file 
		ClientProvider.retrieveCodeFromFile();
	}
	public static void retrieveCodeFromFile() {
		try {
			CODE = Utils.readFromFile("clientCode.txt").get(0);//if IndexOutOfBoundsException, meaning the file is empty, mission will be aborted
			log.info("Client code retrieved from file: " + CODE + " (If you are running user preparation, then this log might show an old client code)");
		} catch (IOException e) {
			e.printStackTrace();
			try {
				log.info("Sleep 5 sec and try to read from the file again");
				Thread.sleep(5000);
				CODE = Utils.readFromFile("clientCode.txt").get(0);
			} catch (Exception ex) {
				log.info("Failed reading from file again, throw runtime exception and abort mission...");
				throw new RuntimeException(ex); 
			}
		} 
	}
	public static String getCode() {
		return CODE;
	}
	public static Client getClient() {
		Client client = null;
		CODE = System.getProperty("CLIENT_CODE");
		if(CODE == null || CODE.equals("")) {
			CODE= "TACQA";
		}
		switch (CODE) {
		case "DNC": 
			client = DNC.getInstance();
			break;
		case "ELVQA": 
			client = ELVQA.getInstance();
			break;
		case "TGAQA": 
			client = TGAQA.getInstance();
			break;
		case "RBCQA": 
			client = RBCQA.getInstance();
			break;
		case "PLAQA": 
			client = PLAQA.getInstance();
			break;
		case "TACQA": 
			client = TACQA.getInstance();
			break;
		case "PLBQA": 
			client = PLBQA.getInstance();
			break;
		case "FFNPERF": 
			client = FFNPERF.getInstance();
			noContactResultFieldWhenAddingSystemDispositionCode = true;
			hasAgentNotification = true;
			break;
		case "FFEPERF": 
			client = FFEPERF.getInstance();
			noContactResultFieldWhenAddingSystemDispositionCode = true;
			hasAgentNotification = true;
			break;
		case "FFBQA": 
			client = FFBQA.getInstance();
			noContactResultFieldWhenAddingSystemDispositionCode = true;
			portfolioIdFocusedOn = "220216";
			portfolioNameFocusedOn = "MX Volana";
			break;
		case "MMEQA": 
			client = MMEQA.getInstance();
			break;
		case "KFSQA":
			client = KFSQA.getInstance();
			break;
		case "FLXQA":
			client = FLXQA.getInstance();
			break;
		case "SLMQA":
			client = SLMQA.getInstance();
			break;
		case "SMWQA":
			selectAllAccountsWhenDisposition = false;
			client = SMWQA.getInstance();
			break;
		case "PCIQA":
			client = PCIQA.getInstance();
			break;
		case "PCRQA":
			client = PCRQA.getInstance();
			break;
		case "UCOQA":
			client = UCOQA.getInstance();
			break;
		case "GSCQA":
			client = GSCQA.getInstance();
			break;
		case "REFQA":
			client = REFQA.getInstance();
			break;
		case "TDCQA":
			noContactResultFieldWhenAddingSystemDispositionCode = true;
			client = TDCQA.getInstance();
			break;
		case "DNA":
			client = DNA.getInstance();
			break;
		case "TNA":
			client = TNA.getInstance();
			break;
		}
		return client;
	}

	private static String autoCreatedUsersFileName() {
		return CODE+"AutoCreatedUsers";
	}
	public static String getAutoCreatedUsersFileName() {
		return "accounts/"+autoCreatedUsersFileName();
	}
	
}
