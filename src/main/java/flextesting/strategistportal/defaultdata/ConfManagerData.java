package flextesting.strategistportal.defaultdata;


import flextesting.utilities.DataUtil;

public class ConfManagerData {
	public static String description = "Disposition Description";
	public static String getDispositionCode() {
		return "DC41_" + DataUtil.getRandomChars();
	}
}
