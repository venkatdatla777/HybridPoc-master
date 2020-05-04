package flextesting.strategistportal.defaultdata;


import flextesting.utilities.DataUtil;

import java.util.HashMap;
import java.util.Map;

public class TaskData {
	/*
	    |   Task Name   |   Task 41 Def     	|
        |   Task Code   |   TCode41Def     		|
        |   Element 1   |   taskEleCode41Def	|
        |   Group       |   Default     		|
	 */

	public static final Map<String, String> dataMap = new HashMap<String, String>();
	static {
		dataMap.put("Task Name","BankruptcyIntro_"+ DataUtil.getRandomChars());
		dataMap.put("Task Code","Bankruptcy_"+DataUtil.getRandomChars());
		dataMap.put("Introduction for Associate Portal","​Inform the Customer that by retaining an attorney to file bankruptcy or filing bankruptcy our Company will do the following 1. Close the account(s) 2. Report the account to the credit bureaus as Credit Revoked");
		dataMap.put("Introduction for Customer Portal","​Thank You for taking the time out today to complete this form. If at any time you have questions please call us at 800-555-1212");
//		dataMap.put("Element 1", TaskElementData.getElementCode());
		dataMap.put("Group","Default");

		dataMap.put("Permanent Task Name","BankruptcyIntro_AT41");
		dataMap.put("Permanent Task Code","Bankruptcy_T_AT");
		dataMap.put("Permanent Element 1", TaskElementData.dataMap.get("Permanent Element Code"));
	}
}
