package flextesting.utilities;

import flextesting.client.Client;
import flextesting.client.ClientProvider;
import org.apache.log4j.Logger;
import org.junit.Assert;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VerifyWithDB {
	static Logger log = Logger.getLogger(VerifyWithDB.class);
	// Connection object
	private Connection conn = null;
	// Statement object
	private Statement stmt;
	// Result Set
	private ResultSet queryResults = null;
	// Driver
	//private String driver = "com.mysql.jdbc.Driver"; // "oracle.jdbc.driver.OracleDriver"
	private String driver = "com.mysql.cj.jdbc.Driver";

	private HashMap<String, String> dataInDB = new HashMap<String, String>();
	private List<String> verifyResults = new ArrayList<String>();
	
	private static HashMap<String, Integer> portfolioNameToId = new HashMap<String, Integer>();

	private String dbURL = null;
	public VerifyWithDB() {
		this.dbURL = ClientProvider.getClient().getDBUrl();
	}
	
	/**
	 * execute the query and store the value to the hashmap using keys from columnNameInDBTable
	 * 
	 * NOTE: the query must contains "count(*)" and the result of it must be 1
	 * @param query
	 * @param columnNameInDBTable
	 */
	public void connectToDatabaseAndRetrieveData(String query, String[] columnNameInDBTable) {
		
		try {
			// STEP 1: Register JDBC driver
			Class.forName(driver).newInstance();

			// STEP 2: Get connection to DB
			log.info("Connecting to a selected database...");
			conn = DriverManager.getConnection(dbURL, Client.DB_USER, Client.DB_PASSWORD);
//			conn.setCatalog("C2PERF_TNA");
			// conn = DriverManager.getConnection(DB_URL, props);		
			log.info("Connected database successfully...");

			// STEP 3: Statement object to send the SQL statement to the Database
			log.info("Creating statement...");
			stmt = conn.createStatement();
			
			log.info(query);
			queryResults = stmt.executeQuery(query);
			while (queryResults.next()) {
				//int id = results.getInt("user_id");
				//String last = results.getString("last_name");
				int numberOfRows = queryResults.getInt(1);
				Assert.assertEquals(1, numberOfRows);
//      put each field retrieved from DB to the hashmap with its corresponding key
				for(int i=0;i<columnNameInDBTable.length;i++) {
					String dataName = columnNameInDBTable[i];
					String dataValueInDB = queryResults.getString(i+2);
					dataInDB.put(dataName, dataValueInDB);
					log.info(dataName + " from DB: " + dataValueInDB);
				}
			}
			queryResults.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnectionToDatabase();
		}
	}

	/**
	 * use columnNameInDBTable as the key to get the database's data from the hashmap, then 
	 * compare it with the UI's data
	 * @param columnNameInDBTable
	 * @param valueInUI
	 */
	public void verifyData(String columnNameInDBTable, String valueInUI) {
		log.info(columnNameInDBTable + " from UI: " + valueInUI);
		String columnInDB = dataInDB.get(columnNameInDBTable);
		if (!valueInUI.equals(columnInDB)) {
			if (valueInUI.equals("N/A") && columnInDB == null) {
				//if value in UI and it's corresponding column in DB are both null, then they are consistent and will not be in inconsistency report
				log.info("N/A in UI = null in DB, no problem");
			} else {
				verifyResults.add("Name: " + columnNameInDBTable + " | Value in UI: " + valueInUI + " | in DB: " + columnInDB);  
			}
		}
	}
	
	/**
	 * If report is not null, then there is data inconsistency between database and UI.
	 * @return
	 */
	public String generateReport() {
		String report = null;
		if (!verifyResults.isEmpty()) {
			report = "Data inconsistency found: ";
			for (String s: verifyResults) 
				report += "\n " + s;
		}
		return report;
	}

	private void closeConnectionToDatabase() {
		try {
			if (queryResults != null)
				queryResults.close();
			if (stmt != null)
				conn.close();
			if (conn != null)
				conn.close();
			log.info("Database connection closed.");
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
}
