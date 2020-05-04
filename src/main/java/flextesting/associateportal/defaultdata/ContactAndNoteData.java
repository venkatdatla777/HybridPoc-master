package flextesting.associateportal.defaultdata;


import flextesting.utilities.DataUtil;

public class ContactAndNoteData {
	public static String getAddressLine1(String addressType) {
		return addressType + "line 1 " + DataUtil.getRandomChars();
	}
	public static String getNewAddressLine1(String addressType) {
		return "New " + addressType + "line 1 " + DataUtil.getRandomChars();
	}
	public static String getAddressLine2(String addressType) {
		return addressType + "line 2 " + DataUtil.getRandomChars();
	}

	public static String getEmail() {
		DataUtil.setRandomChars(5);
		return DataUtil.getRandomChars() + "@cmc.cmc";
	}
	
	public static String getNote() {
		return "This is a random note: " + DataUtil.getRandomChars();
	}
}
