package flextesting.strategistportal.defaultdata;

public class TestManagerData {
	//the following three need to be changed together
	public static String expression = "balance";
	public static String query = "select count(*), a.balance from " 
			+ "Responsible as r, Account as a " 
			+ "where a.accountNum = r.accountNum " 
			+ "and r.userLogon = ";
	public static String[] columnNameInDBTable = {"balance"};
}
