package flextesting.strategistportal.defaultdata;

import java.util.HashMap;
import java.util.Map;

public class TaskElementData {
/*
        |   Element Code    |   taskEleCode41Def                   |
        |   Variable Name   |   taskElement41VarDef                | 
        |   Data Type       |   Integer                         |
        |   Text 1          |   What is your monthly income?    | 
        |   Layout          |   Answer after text               |
        |   Answer Type     |   Text Field                      |
 */
	public static Map<String, String> dataMap = new HashMap<>();
	static {
		dataMap.put("Permanent Element Code", "Bankruptcy_TE_AT");
		dataMap.put("Permanent Variable Name","wfBankruptcyFiling_AT41");
		dataMap.put("Data Type","String");
		dataMap.put("Text 1","Have you already filed for Bankruptcy?");
		dataMap.put("Layout","Answer after text");
		dataMap.put("Answer Type","Text Field");
	}
	
	private static String dateFormatTxt;
	private static String elementCode;
	private static String variableName;

	public static String getElementCode() {
		return elementCode;
	}

	public static void setElementCode(String elementCode) {
		TaskElementData.elementCode = elementCode;
	}

	public static String getVariableName() {
		return variableName;
	}

	public static void setVariableName(String variableName) {
		TaskElementData.variableName = variableName;
	}

	public static String getDateFormatTxt() {
		return dateFormatTxt;
	}

	public static void setDateFormatTxt(String dateFormatTxt) {
		TaskElementData.dateFormatTxt = dateFormatTxt;
	}
	
}
