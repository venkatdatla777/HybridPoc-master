package flextesting.client;



import flextesting.utilities.DataUtil;
import flextesting.utilities.RetrieveDataFromDB;
import flextesting.utilities.Row;
import sun.security.util.PendingException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public interface Client {
	String getFlexCenterUrl();
	String getFlexStationUrl();
//	String getAvailablePortfolio();
	String getDispositionOutcome();
	String getDBUrl();
	
//	default String[] focusOnPortfolio() {
//		return new String[]{"",""};
//	}
	
	default String getUsername() throws ClassNotFoundException, IOException {
		return UserMaster.getInstance().getUsername();
	}

	default String getPassword() throws ClassNotFoundException, IOException {
		return UserMaster.getInstance().getPassword();
	}
	default List<HashMap> getAvailablePortfolios() {
		String query = "select portfolioId, name, description from Portfolio";// where portfolioId = 220216";
		RetrieveDataFromDB retrieveDataFromDB = new RetrieveDataFromDB();
		List<Row> queryResult = retrieveDataFromDB.retrieveData(query);
		List<String> rows = Row.formatTableToListOfString(queryResult);
		List<HashMap> portfolios = new ArrayList<>();
		for (String row: rows) {
			//each row will look like:|90901|CMCCard|CMC Test Portfolio
			//Notice there is a | at the beginning, so after splitting, useful index starts from 1
			HashMap<String, String> portfolioInfo = new HashMap<>();
			String[] columns = row.split("\\|");
			if (columns.length != 4) {
				throw new RuntimeException("Invalid query results of portfolio\n"
						+ "Expected sth like: [,90901,CMCCard,CMC Test Portfolio]\n"
						+ "Actual: "+Arrays.toString(columns));
			}
			portfolioInfo.put("portfolioId", columns[1]);
			portfolioInfo.put("name", columns[2]);
			portfolioInfo.put("description", columns[3]);
			portfolios.add(portfolioInfo);
		}
		if (portfolios.size() < 1)
			throw new RuntimeException("Invalid query results of portfolio: no valid result parsed out");
		return portfolios;
	}

	/**
	 * This is deprecated because each client has its own phone # validation mechanism and 
	 * it's impossible for me to know them before hand. So instead, we can get a
	 * phone number from DB (which should always be valid, unless it's added directly
	 * from the back end), and use it in our testing. (in which case, the random 
	 * extension will become the unique identifier of the phone number HTML element) 
	 * 
	 * US phone# has 10 digits. AUS has 9 digits 
	 * @return random phone # with valid length based on country
	 */
	@Deprecated
	default String getRandomPhoneNumber() {
		return DataUtil.getRandomPhoneNumber("3022", 6);
	}
	
	/**
	 * @return phone info array of size 3: phone type / country code / phone number
	 * @throws Exception 
	 */
	default String[] getPhoneInfoFromDB() {
		String[] phoneInfo = new String[3];
		String query = "select pt.name, p.telephoneCountryCode, p.phoneNum "
				+ "from ContactPhone p, PhoneType pt "
				+ "where p.telephoneCountryCode != '' "
				+ "and p.typeId = pt.typeId "
				+ "and p.typeId in (1,2,3,4) " //type can be: Home/work/mobile/other
				+ "limit 1";
		RetrieveDataFromDB retrieveDataFromDB = new RetrieveDataFromDB();
		List<Row> queryResult = retrieveDataFromDB.retrieveData(query);
		if (queryResult.size() != 1) {
			query = "select pt.name, p.telephoneCountryCode, p.phoneNum "
					+ "from ContactPhone p, PhoneType pt "
					+ "where p.typeId = pt.typeId "
					+ "and p.typeId in (1,2,3,4) " //type can be: Home/work/mobile/other
					+ "limit 1";
			retrieveDataFromDB = new RetrieveDataFromDB();
			queryResult = retrieveDataFromDB.retrieveData(query);
			if (queryResult.size() != 1)
				throw new PendingException("No Phone Info retrieved from DB. Mission aborted...");
		}
		List<String> rows = Row.formatTableToListOfString(queryResult);
		String[] columns = rows.get(0).split("\\|");
		if (columns.length != 4) {
			throw new RuntimeException("Invalid query results of phone info\n"
					+ "Expected sth like: [,HomePhone,34,965071630]\n"
					+ "Actual: "+Arrays.toString(columns));
		}
		phoneInfo[0] = columns[1]; //phone type
		phoneInfo[1] = columns[2]; //country code
		phoneInfo[2] = columns[3]; //phone number
		return phoneInfo;
	}
	/**
	 * NOTE: If the following statement is true, uncomment the method
	 * 
	 * For some(may most?) clients, you can only use a rounting # exist in DB.
	 * For other clients, any valid rounting number is fine to use. (
	 * @return
	 */
//	default String getRountingNumberForAddingBankAccount() {
//		String rountingNumber = FundingAccountData.getRountingNumber();
//		if (rountingNumber == null)
//			throw new NoRountingNumberFoundInDBException("No routing number found in DB");
//		return rountingNumber;
//	}
	static final String DB_USER = "autotest";
	static final String DB_PASSWORD = "AutoKat123$";
	static String buildDBURL(String dbIP, String dbName, boolean needPostfixToHandleTimeZoneSQLException) {
		String url = "jdbc:mysql://"+dbIP+":3306/"+dbName;
		if (needPostfixToHandleTimeZoneSQLException)
			url+="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		return url;
	}
}
