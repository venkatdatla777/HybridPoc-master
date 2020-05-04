package flextesting.strategistportal.defaultdata;


import static flextesting.utilities.DataUtil.getRandomChars;

public class UserData {
	public static String password = "Qeaszx123!";

	private static String loginName = "Tester";
	private static String firstName = "TesterKKK FN";
	private static String lastName = "TesterKKK LN";
	private static String email = "TesterKKK@cmc.cmc";
	
	public static String getLoginName() {
		return "Tester"+getRandomChars();
	}
	public static String getFirstName() {
		return "Tester"+getRandomChars()+" FN";
	}
	public static String getLastName() {
		return "Tester"+getRandomChars()+" LN";
	}
	public static String getEmail() {
		return "Tester"+getRandomChars()+"@cmc.com";
	}

	public static void main(String[] args) {
		System.out.println(getLoginName());
		System.out.println(getFirstName());
		System.out.println(getLastName());
		System.out.println(getEmail());
	}
}
