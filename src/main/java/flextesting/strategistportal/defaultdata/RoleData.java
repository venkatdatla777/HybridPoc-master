package flextesting.strategistportal.defaultdata;


import flextesting.utilities.DataUtil;

public class RoleData {
	public static String description = "generated in automated testing process";
	public static String description2 = "should already be deleted";
	public static String getName() {
		return "aRole_"+ DataUtil.getRandomChars();
	}
}
