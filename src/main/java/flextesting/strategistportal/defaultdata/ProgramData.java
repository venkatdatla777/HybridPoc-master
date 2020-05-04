package flextesting.strategistportal.defaultdata;


import flextesting.utilities.DataUtil;

public class ProgramData {
	private static String programName;
	
	public static String getName() {
		return "Monthly Program_"+ DataUtil.getRandomChars();
	}
	public static String getPermanentName() {
		return "Sample Program_";
	}
	
	public static String getProgramName() {
		return programName;
	}
	
	public static void setProgramName(String programName) {
		ProgramData.programName = programName;
	}

}
