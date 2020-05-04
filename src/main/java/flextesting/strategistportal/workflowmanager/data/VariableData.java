package flextesting.strategistportal.workflowmanager.data;


import flextesting.utilities.DataUtil;

public class VariableData {
	public static String getName() {
		return "WMVar41_" + DataUtil.getRandomChars();
	}
	public static String Description = "Variable description";
	
	
	public static String getPermanentName() {
		return "WMVar_AT41"; 
	}
}
