package flextesting.associateportal.defaultdata;



import flextesting.utilities.BuildDBurl;
import flextesting.utilities.DataUtil;
import flextesting.utilities.RetrieveDataFromDB;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FundingAccountData {
	public static final Map<String, String> CARD_ACCOUNT = new HashMap<String, String>(); 
	static {
		CARD_ACCOUNT.put("Account Nick Name","TestCard_"+ DataUtil.getRandomChars());
		CARD_ACCOUNT.put("Credit/Debit","DebitCard");
		CARD_ACCOUNT.put("Card Type","Visa");
		CARD_ACCOUNT.put("Card Number","4003830171874018");
		CARD_ACCOUNT.put("Card Holder Full Name","Tester "+DataUtil.getRandomChars());
		CARD_ACCOUNT.put("Expiration Date","Apr/2020");
		CARD_ACCOUNT.put("Address Line 1","King's Road");
		CARD_ACCOUNT.put("City","KingsLanding");
		CARD_ACCOUNT.put("State","Westeros");
		CARD_ACCOUNT.put("Zip Code","88888");
	}
	
	public static String getNickName() {
		return "TestBankAccount_" + DataUtil.getRandomChars();
	}
	public static List<String> getRoutingNumberList() {
		RetrieveDataFromDB instance = new RetrieveDataFromDB();
		return instance.retrieveRoutingNumber(BuildDBurl.buildDBURL(System.getProperty("dbIP"),System.getProperty("dbName"),
				Boolean.parseBoolean(System.getProperty("needPostfixToHandleTimeZoneSQLException"))),
				System.getProperty("UserName"), System.getProperty("Password"));
	}
	public static String getAccountNumber() {
		return "123456789";
	}
	public static String getHolderFullName() {
		return "Tester "+DataUtil.getRandomChars();
	}
}
