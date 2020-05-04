package flextesting.utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.sql.*;
import java.util.Properties;


public class QueryToChangeView {
	static Logger log = Logger.getLogger(QueryToChangeView.class);

    public static Properties CONFIG;
    protected static WebDriver driver = null;
    //public static String apptLanguages;
    static int portfolioid;

    public static Connection getConnection(){

        Connection con = null;

//        String id = System.getProperty("portfolioid");
//        if(id == null) {
//            portfolioid = ClientProvider.getClient().getPortfolioId();
//        } else {
//            portfolioid = Integer.parseInt(id);
//        }

        //Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
        String dbUrl = BuildDBurl.buildDBURL(System.getProperty("dbIP"),System.getProperty("dbName"),
                Boolean.parseBoolean(System.getProperty("needPostfixToHandleTimeZoneSQLException")));
        //Database Username
        String username = System.getProperty("UserName");
        //Database Password
        String password = System.getProperty("Password");
        try{
            //Load mysql jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            log.info("Connecting to a selected database...");
            con = DriverManager.getConnection(dbUrl, username, password);
            log.info("Connected database successfully...");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

/*    public static void main(String[] args){
        HashMap<String,String> configList = new HashMap<>();
        Connection con = getConnection();

        try {
            Statement stmt = con.createStatement();

            log.info("Getting the view configuration...");
            String query = "select featureValue from ApplicationConfig where `featureName` in ('hideCustomerContainer','overallViewWithoutIFrame');";

            ResultSet rset = stmt.executeQuery(query);
            rset.next();
            configList.put("hideCustomerContainer",rset.getString("featureValue"));
            rset.next();
            configList.put("overallViewWithoutIFrame",rset.getString("featureValue"));
            System.out.println(configList.get("hideCustomerContainer"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    */

    public static void getTheViewConfig(){
        //HashMap<String,String> configList = new HashMap<>();
        Connection con = getConnection();

        try {
            Statement stmt = con.createStatement();

            log.info("Getting the view configuration...");
            String query = "select featureValue from ApplicationConfig where `featureName` in ('hideCustomerContainer','overallViewWithoutIFrame');";

            ResultSet rset = stmt.executeQuery(query);
            rset.next();
            TestDataSetup.hideCustomerContainer = rset.getString("featureValue");
            //configList.put("hideCustomerContainer",rset.getString("featureValue"));
            rset.next();
            TestDataSetup.overallViewWithoutIFrame = rset.getString("featureValue");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //return configList;
    }

    public static void queryToAccountView() {
        try{

            Connection con = getConnection();



            //Query to Execute
//             if(!view.equalsIgnoreCase("overallView")) {
            // query = "update ApplicationConfig set featureValue='true' where featureName='hideCustomerContainer';" ;

//             }else {
//                 query = "update ApplicationConfig set featureValue='false' where featureName='hideCustomerContainer'" +
//                       "update ApplicationConfig set featureValue='true' where featureName='overallViewWithoutIFrame'" +
//                       "update ApplicationConfig set featureValue='newAccount5' where featureName='accountViewUrl'" +
//                       "update `User` set defaultStationView = 'queueView?newAccount2Mode=true' where username=':username'";
//             }
            //initialize().getProperty(firstname);

            //Create Statement Object
            Statement stmt = con.createStatement();
            
            log.info("Updating the View...");
            stmt.addBatch("update ApplicationConfig set featureValue='true' where featureName='hideCustomerContainer'");
            stmt.addBatch("update ApplicationConfig set featureValue='false' where featureName='overallViewWithoutIFrame'");
            stmt.addBatch("update ApplicationConfig set featureValue='newAccount5' where featureName='accountViewUrl'" );
            stmt.addBatch("update `User` set defaultStationView = 'queueView?newAccount2Mode=true' where username=':username'");

//             Excute the statement and get the count of the updated columns
            int[] count = stmt.executeBatch();
            System.out.println(count.length);
            log.info("View Updated into the Account View...");

        }catch(Exception e) {

        }
    }

    public static void queryToOverAllView() {
        try{

            Connection con = getConnection();



            //Query to Execute
//             if(!view.equalsIgnoreCase("overallView")) {
            // query = "update ApplicationConfig set featureValue='true' where featureName='hideCustomerContainer';" ;

//             }else {
//                 query = "update ApplicationConfig set featureValue='false' where featureName='hideCustomerContainer'" +
//                       "update ApplicationConfig set featureValue='true' where featureName='overallViewWithoutIFrame'" +
//                       "update ApplicationConfig set featureValue='newAccount5' where featureName='accountViewUrl'" +
//                       "update `User` set defaultStationView = 'queueView?newAccount2Mode=true' where username=':username'";
//             }
            //initialize().getProperty(firstname);

            //Create Statement Object
            Statement stmt = con.createStatement();
            log.info("Updating the View...");
            stmt.addBatch("update ApplicationConfig set featureValue='false' where featureName='hideCustomerContainer'");
            stmt.addBatch("update ApplicationConfig set featureValue='true' where featureName='overallViewWithoutIFrame'");
            stmt.addBatch("update ApplicationConfig set featureValue='newAccount5' where featureName='accountViewUrl'" );
            stmt.addBatch("update `User` set defaultStationView = 'queueView?newAccount2Mode=true' where username=':username'");

//             Excute the statement and get the count of the updated columns
            int[] count = stmt.executeBatch();
            System.out.println(count.length);
            log.info("View Updated into the OverAll View...");

        }catch(Exception e) {

        }
    }

}
