package flextesting.utilities;

public class BuildDBurl {

   public static String buildDBURL(String dbIP, String dbName, boolean needPostfixToHandleTimeZoneSQLException) {
        String url = "jdbc:mysql://"+dbIP+":3306/"+dbName;
        if (needPostfixToHandleTimeZoneSQLException)
            url+="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        return url;
    }
}
