package flextesting.strategistportal.defaultdata;


import flextesting.utilities.DataUtil;

public class WMScheduleData {
	private static String scheduleName = "Test Schedule_" + DataUtil.getDateFormatTxt();
	private static String wmScheduleName;
	
	public static void setScheduleName(String scheduleName) {
		WMScheduleData.scheduleName = scheduleName;
	}
	
	public static String getScheduleName() {
		return scheduleName;
	}

	public static String getWmScheduleName() {
		return wmScheduleName;
	}

	public static void setWmScheduleName(String wmScheduleName) {
		WMScheduleData.wmScheduleName = wmScheduleName;
	}
}
