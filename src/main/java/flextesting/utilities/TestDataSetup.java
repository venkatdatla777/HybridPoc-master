package flextesting.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestDataSetup {

	private static List<Map<String,String>> pendingPasswordChangeList = new ArrayList<Map<String,String>>();

	public static List<Map<String, String>> getPendingPasswordChangeList() {
		return pendingPasswordChangeList;
	}

	public static void setPendingPasswordChangeList(List<Map<String, String>> pendingPasswordChangeList) {
		TestDataSetup.pendingPasswordChangeList = pendingPasswordChangeList;
	}

	private static String scenarioName;

	public static String getScenarioName() {
		return scenarioName;
	}

	public static void setScenarioName(String scenarioName) {
		TestDataSetup.scenarioName = scenarioName;
	}

	public static String hideCustomerContainer = null;

	public static String overallViewWithoutIFrame = null;
	
	
	
}
