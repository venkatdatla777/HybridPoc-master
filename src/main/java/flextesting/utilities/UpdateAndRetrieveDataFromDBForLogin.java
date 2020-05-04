package flextesting.utilities;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UpdateAndRetrieveDataFromDBForLogin {
    static Logger log = Logger.getLogger(QueryToChangeView.class);


    public static int updateTheChangePasswordToN(String query){
        int count = 0;

        Connection con = null;
        //Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
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
            Statement stmt = con.createStatement();
            count = stmt.executeUpdate(query);
            log.info("Number of accounts updated are :" + count);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public static List<String> retrieveUsersCreated(){
        List<String> users = new ArrayList<>();
        try{
            Connection con = null;
            //Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
            String dbUrl = BuildDBurl.buildDBURL(System.getProperty("dbIP"),System.getProperty("dbName"),
                    Boolean.parseBoolean(System.getProperty("needPostfixToHandleTimeZoneSQLException")));
            //Database Username
            String username = System.getProperty("UserName");
            //Database Password
            String password = System.getProperty("Password");
            //Load mysql jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            log.info("Connecting to a selected database...");
            con = DriverManager.getConnection(dbUrl, username, password);
            log.info("Connected database successfully...");
            Statement stmt = con.createStatement();
            String query = "select username from User where username LIKE 'testerauto%' and changePassword = 'N';";
            ResultSet rset = stmt.executeQuery(query);
            log.info("query executed for retrieving users"+ rset.getFetchSize());
            while (rset.next()){
                users.add(rset.getNString(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }


}
