package flextesting.utilities;


import flextesting.client.ClientProvider;
import flextesting.client.ScenarioInfo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class RetrieveDataFromDB {
	static Logger log = Logger.getLogger(RetrieveDataFromDB.class);
//	static {
//		Properties log4jprop = new Properties();
//		log4jprop.setProperty("log4j.rootLogger", "DEBUG, CA");
//		log4jprop.setProperty("log4j.appender.CA", "org.apache.log4j.ConsoleAppender");
//		log4jprop.setProperty("log4j.appender.CA.layout", "org.apache.log4j.PatternLayout");
//		log4jprop.setProperty("log4j.appender.CA.layout.ConversionPattern", "%-5p %c{1}:%L - %m%n");
//		
//		log4jprop.setProperty("log4j.logger.org.apache.http", "WARN");
//		log4jprop.setProperty("log4j.logger.org.apache.http.wire", "WARN");
//		PropertyConfigurator.configure(log4jprop);
//	}
	// Connection object
	private Connection conn = null;
	// Statement object
	private Statement stmt;
	// Result Set
	private ResultSet queryResults = null;
	// Driver
	//private String driver = "com.mysql.jdbc.Driver"; // "oracle.jdbc.driver.OracleDriver"
	private String driver = "com.mysql.cj.jdbc.Driver";

	/**
	 * Buggy, and deprecated
	 * @param db_url
	 * @param db_user
	 * @param db_password
	 * @return
	 */
	@Deprecated
	public String retrieveAccount(String db_url, String db_user, String db_password) {
		
		String referenceNumber = null;
		try {
			//How much time need to wait for the lockExpirationTime updated in DB? 10s is ok, what about 4? or even less?
			Thread.sleep(4000);
			// STEP 1: Register JDBC driver
			Class.forName(driver).newInstance();

			// STEP 2: Get connection to DB
			log.info("Connecting to a selected database...");
			conn = DriverManager.getConnection(db_url, db_user, db_password);
			log.info("Connected database successfully...");

			// STEP 3: Statement object to send the SQL statement to the Database
			log.info("Creating statement...");
			stmt = conn.createStatement();
			
			//load from table: UserLoadedAccount. retrieve the userlogon with the earliest lock expiration time.
			// e.g. say without using limit 1, let's say there are three rows in the table:
			//	LET						userlogon
			//	2017-05-18 16:10:43		5850169838
			//	2017-05-22 17:33:44		5886956481
			//	2017-05-23 14:05:23		5868453927
			// suppose the current time is 2017-05-18 16:09:00, which is earlier than the first row.
			// this means, even the first userlogon is still locked (because the lock will expire at 16:10:43)
			// then all other userlogons are also locked. 
			String query = "select MAX(u.lockExpirationTime) as LET, r.userLogon FROM Account AS a INNER JOIN Responsible AS r ON r.accountNum = a.accountNum "
							+ "INNER JOIN UserLoadedAccount as u on r.accountNum = u.accountNum "
							+ "where a.active = 'Y' and a.balance>0 and r.last4Ssn is not NULL "
							+ "group by r.userLogon ORDER BY LET ASC limit 1";
			queryResults = stmt.executeQuery(query);
			while (queryResults.next()) {
//				String lockExpirationTime = queryResults.getString(1);
		        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		        Date lockExpirationTime = ft.parse(queryResults.getString(1));
		        Date currentTime = new Date();
		        log.info("Earliest lockExpirationTime: " + ft.format(lockExpirationTime));
		        log.info("Current Time: " + ft.format(currentTime));
		        //if current time is after lock expiration time, then it means the userlogon is unlocked (not currently locked by another agent)
		        if (currentTime.compareTo(lockExpirationTime) > 0) {
					referenceNumber = queryResults.getString(2);
					log.info("UserLoadedAccount table has an userlogon that's no longer locked, returning it...");
		        } else {
					log.info("Earlisest LockExpirationTime is greater than current time, so: ");
		        }
			}
			// if null, means all userlogons in the UserLoadedAccount are still locked. we then need to find a 
			// userlogon from another table and make sure it's not locked (by checking its most recent lockExpirationTime
			// in the UserLoadedAccount table.
			if (referenceNumber == null) {
				log.info("All userlogons are still locked based on UserLoadedAccount table.");
				log.info("Trying to find one from account/responsible table that is NOT locked based on the UserLoadedAccount table...");
				//get all locked userlogons
				query = "select r.userLogon FROM Account AS a INNER JOIN Responsible AS r ON r.accountNum = a.accountNum "
						+ "INNER JOIN UserLoadedAccount as u on r.accountNum = u.accountNum "
						+ "where a.active = 'Y' and a.balance>0 and r.last4Ssn is not NULL "
						+ "group by r.userLogon";
				queryResults = stmt.executeQuery(query);
				StringBuilder lockedUserLogons = new StringBuilder();
				lockedUserLogons.append("(");
				while (queryResults.next()) {
					lockedUserLogons.append(queryResults.getString(1) + ",");
				}
				//delete the last ,
				lockedUserLogons.deleteCharAt(lockedUserLogons.length()-1);
				lockedUserLogons.append(")"); 
				log.info("locked: " + lockedUserLogons.toString());

				//find an userlogon that is not locked (not in lockedUserLogons)
				query = "select r.userLogon, r.last4Ssn FROM Account AS a INNER JOIN Responsible AS r ON r.accountNum = a.accountNum "
						+"WHERE r.userLogon NOT IN "+lockedUserLogons.toString()
						+" and a.active = 'Y' and a.balance>0 and r.last4Ssn is not NULL "
						+"limit 1";
				queryResults = stmt.executeQuery(query);
				while (queryResults.next()) {
					referenceNumber = queryResults.getString(1);
					log.info("Non-read-only reference# found from account/responsible table, returning it...");
				}
			}
			if (referenceNumber == null)
				throw new RuntimeException("no qualified reference#/userlogon found");
			else
				log.info("Non-read-only reference# retrieved from DB: " + referenceNumber);
			//OLD logic: will be deleted soon.
			//if unable to load an account from userLoadedAccount, then directly load one from Account table, because it's 
			//guaranteed to be not loaded by another agent
//			if (referenceNumber == null) {
//				query = "select r.userLogon FROM Account AS a INNER JOIN Responsible AS r ON r.accountNum = a.accountNum "
//						+ "WHERE a.active = 'Y' and a.balance>0 and r.last4Ssn is not NULL "
//						+ "limit 1";
//				queryResults = stmt.executeQuery(query);
//				while (queryResults.next()) {
//					referenceNumber = queryResults.getString(1);
//					log.info("Retrieved an account from DB by reference number: " + referenceNumber);
//				}
//			}
			queryResults.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnectionToDatabase();
		}
		return referenceNumber;
	}

	public HashMap<String,String> retrieveAccountNumberAndResponsibleId(String db_url, String db_user, String db_password,String refNumber){
		HashMap<String,String> AccountAndResponsibleId = new HashMap<>();
		try {
			Class.forName(driver).newInstance();
			log.info("Connecting to a selected database...");
			conn = DriverManager.getConnection(db_url, db_user, db_password);
			log.info("Connected database successfully...");
			log.info("Creating statement...");
			stmt = conn.createStatement();

			String query = "select accountNum,responsibleId from Responsible where userLogon = "+refNumber+";";
			log.info(query);
			//no SSN required because the verification window can always be skipped now.
//							+" and a.active = 'Y' and a.balance>5 and r.last4Ssn is not NULL limit 50";
			queryResults = stmt.executeQuery(query);
			while (queryResults.next()) {
				AccountAndResponsibleId.put("accountNumber",queryResults.getString(1));
				AccountAndResponsibleId.put("responsibleId",queryResults.getString(2));
			}
			if (AccountAndResponsibleId.size() == 0)
				throw new RuntimeException("no qualified reference#/userlogon found");
			else
				log.info("userLogon list containing " + AccountAndResponsibleId.size()+ " userlogons retrieved from DB: ");
			queryResults.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnectionToDatabase();
		}
		return AccountAndResponsibleId;
	}

	public void updateTheTableToPerformDisposition(String db_url, String db_user, String db_password,String accountNum,String responsibleId){
        try {
            Class.forName(driver).newInstance();
            log.info("Connecting to a selected database...");
            conn = DriverManager.getConnection(db_url, db_user, db_password);
            log.info("Connected database successfully...");
            log.info("Creating statement...");
            stmt = conn.createStatement();
            stmt.addBatch("UPDATE UserLoadedAccount SET current ='N' WHERE accountNum='"+accountNum+"';");
            stmt.addBatch("UPDATE UserLoadedCustomer SET current ='N' WHERE loadedResponsibleId='"+responsibleId+"';");
//             Execute the statement and get the count of the updated columns
            int[] count = stmt.executeBatch();
            System.out.println("Disposition update is successful only if this length is "+count.length);
            log.info("Disposition update is successful only if this length is "+count.length);
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
                log.info("Database connection closed.");
            }catch(SQLException e){
                log.info(e.getMessage());
            }
        }
    }



	
	public List<String> retrieveUserLogons(String db_url, String db_user, String db_password) {
		List<String> userLogonsList = new ArrayList<String>();
		try {
			Class.forName(driver).newInstance();
			log.info("Connecting to a selected database...");
			conn = DriverManager.getConnection(db_url, db_user, db_password);
			log.info("Connected database successfully...");
			log.info("Creating statement...");
			stmt = conn.createStatement();

			String portfolioIdTxt = System.getProperty("portfolioId");
			
			
			String query = "select r.userLogon FROM Account AS a INNER JOIN Responsible AS r ON r.accountNum = a.accountNum" 
							+" and a.active = 'Y' and a.balance>5";
			if(portfolioIdTxt == null || portfolioIdTxt.equals("")) {
				System.out.println("portfolioIdTxt : " + portfolioIdTxt);
			if (!ClientProvider.portfolioIdFocusedOn.equals(""))
				query += " and a.portfolioId = " + ClientProvider.portfolioIdFocusedOn;
		    if (null!= ScenarioInfo.getTags()&& ScenarioInfo.getTags().contains("@do_workflow")) {
		    	log.info("Adjust query for running do_workflow");
		    	query += " and a.portfolioId = 90903"; //90903 for auto, which has workflow configured in workflow manager
		    }
			} else {
				query += " and a.portfolioId = " + portfolioIdTxt;
			}
		    
		    
		    query += " limit 50";
		    log.info(query);
					//no SSN required because the verification window can always be skipped now.	
//							+" and a.active = 'Y' and a.balance>5 and r.last4Ssn is not NULL limit 50";
			queryResults = stmt.executeQuery(query);
			while (queryResults.next()) {
				userLogonsList.add(queryResults.getString(1));
			}
			if (userLogonsList.size() == 0)
				throw new RuntimeException("no qualified reference#/userlogon found");
			else
				log.info("userLogon list containing " + userLogonsList.size()+ " userlogons retrieved from DB: ");
			queryResults.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnectionToDatabase();
		}
		return userLogonsList;
	}
	
	public List<String> retrieveRoutingNumber(String db_url, String db_user, String db_password) {
		List<String> rountingNumberList = new ArrayList<String>();
		try {
			// STEP 1: Register JDBC driver
			Class.forName(driver).newInstance();

			// STEP 2: Get connection to DB
			log.info("Connecting to a selected database...");
			conn = DriverManager.getConnection(db_url, db_user, db_password);
			log.info("Connected database successfully...");

			// STEP 3: Statement object to send the SQL statement to the Database
			log.info("Creating statement...");
			stmt = conn.createStatement();
			
			//load from table: UserLoadedAccount, this account is not loaded by another agent
			String query = "select routingNumber from RoutingNumber limit 10";
			queryResults = stmt.executeQuery(query);
			while (queryResults.next()) {
				rountingNumberList.add(queryResults.getString(1));
//				log.info("rounting number from DB: " + rountingNumber);
			}
			log.info(rountingNumberList.size() + " rounting numbers retrieved from DB: ");
			queryResults.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnectionToDatabase();
		}
		return rountingNumberList;
	}
	
	/**
	 * Usage: 
	 * <br>step 1: new or inject an instance of this class (RetrieveDataFromDB)
	 * <br>step 2: define a query: String query = "select portfolioId, name, description from Portfolio";
	 * <br>step 3: get a list of rows of the query result: List<Row> queryResult = retrieveDataFromDB.retrieveData(query);
	 * <br>step 4: convert the list of rows to a list of strings separated by |
	 * <br>			List<String> userDataInDB = Row.formatTableToListOfString(queryResult);
	 * <br>			so now each row will look like:|90901|CMCCard|CMC Test Portfolio
	 * <br>			Notice there is a | at the beginning, so after splitting, useful index starts from 1
	 * @param query
	 * @return
	 * @throws Exception 
	 */
	public List<Row> retrieveData(String query) {
		List<Row> table = new ArrayList<Row>();
		try {
			// STEP 1: Register JDBC driver
			Class.forName(driver).newInstance();

			// STEP 2: Get connection to DB
			//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
			String dbUrl = BuildDBurl.buildDBURL(System.getProperty("dbIP"),System.getProperty("dbName"),
					Boolean.parseBoolean(System.getProperty("needPostfixToHandleTimeZoneSQLException")));
			//Database Username
			String username = System.getProperty("UserName");
			//Database Password
			String password = System.getProperty("Password");
			log.info("Connecting to a selected database: " + dbUrl);
			conn = DriverManager.getConnection(dbUrl,username, password);
			log.info("Connected database successfully...");

			// STEP 3: Statement object to send the SQL statement to the Database
			log.info("Creating statement...");
			stmt = conn.createStatement();
			
			log.info("Executing query: "+query);
			//load from table: UserLoadedAccount, this account is not loaded by another agent
			queryResults = stmt.executeQuery(query);
			Row.formTable(queryResults, table);
			
			log.info("Query finished...");
			queryResults.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
//			e.printStackTrace();
			throw new IllegalArgumentException("Failure occurred when retrieving data from DB: " + e);
		} finally {
			closeConnectionToDatabase();
		}
		log.info("Query result returned");
		return table;
	}

	private void closeConnectionToDatabase() {
		try {
			if (queryResults != null)
				queryResults.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
			log.info("Database connection closed.");
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	/**
	 * <p>columns in each row are separated by |
	 * <p>each row will look like:|90901|CMCCard|CMC Test Portfolio
	 * <p>Notice there is a | at the beginning, so after splitting, useful index starts from 1
	 * @param query
	 * @return
	 */
	public static List<String> getRows(String query) {
		RetrieveDataFromDB retrieveDataFromDB = new RetrieveDataFromDB();
		List<Row> queryResult = retrieveDataFromDB.retrieveData(query);
		List<String> rows = Row.formatTableToListOfString(queryResult);
		return rows;
	}
	
	public List<String> retrieveUserLogonsWhoHavePaymentOffer(String db_url, String db_user, String db_password) {
		List<String> userLogonsList = new ArrayList<String>();
		try {
			Class.forName(driver).newInstance();
			log.info("Connecting to a selected database...");
			conn = DriverManager.getConnection(db_url, db_user, db_password);
			log.info("Connected database successfully...");
			log.info("Creating statement...");
			stmt = conn.createStatement();

			String portfolioId = "900001";
			if (!ClientProvider.portfolioIdFocusedOn.equals(""))
				portfolioId = ClientProvider.portfolioIdFocusedOn;
		    
			String query = "SELECT b.userLogon from Responsible b, ResponsibleIndex ri, Customer c, Account a, AccountIndex ai where a.portfolioId ="+portfolioId+" and a.active='Y' and a.accountNum = b.accountNum and b.responsibleId=ri.responsibleId and ri.customerInfoId=c.customerId and a.accountNum= ai.accountNum and b.dateOfBirth is not null and c.ucid is not null and a.acceptProgramDate is NULL and b.accountNum not in (select accountNum from PromiseToPay);";
		    
		    log.info(query);
					//no SSN required because the verification window can always be skipped now.	
//							+" and a.active = 'Y' and a.balance>5 and r.last4Ssn is not NULL limit 50";
			queryResults = stmt.executeQuery(query);
			while (queryResults.next()) {
				userLogonsList.add(queryResults.getString(1));
			}
			if (userLogonsList.size() == 0)
				throw new RuntimeException("no qualified reference#/userlogon found");
			else
				log.info("userLogon list containing " + userLogonsList.size()+ " userlogons retrieved from DB: ");
			queryResults.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnectionToDatabase();
		}
		return userLogonsList;
	}
	
	/*public static void main(String[] args) throws SQLException {
		//to see log, uncomment the static initializer block
		RetrieveDataFromDB instance = new RetrieveDataFromDB();
		instance.retrieveAccount(Client.buildDBURL("10.1.104.151", "C2QA_PLA", true), Client.DB_USER, Client.DB_PASSWORD);
	}*/
}