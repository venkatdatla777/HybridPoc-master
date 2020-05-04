package flextesting.strategistportal.workflowmanager;


import com.qa.base.TestBase;
import flextesting.pagefactories.strategistportal.workflowmanager.TaskElementFactory;
import flextesting.strategistportal.defaultdata.TaskElementData;
import flextesting.utilities.DataUtil;
import flextesting.utilities.Utils;

import java.util.Map;

public class TaskElementStepsPage extends TestBase {
	private TaskElementFactory taskElement;
	protected Map<String, String> dataMap = TaskElementData.dataMap;

	public void i_create_a_task_element() throws Throwable {
		String elementCode = "Br_"+ DataUtil.getDateFormatTxt();
		String variableName = "wfBankruptcyFiling_"+DataUtil.getDateFormatTxt();
		TaskElementData.setElementCode(elementCode);
		TaskElementData.setVariableName(variableName);
		createTaskElement(elementCode, variableName);
	}

	private void createTaskElement(String elementCode, String variableName) throws InterruptedException {
		taskElement.click_tab_TaskElements();
		taskElement.click_Add();
		taskElement.enter_ElementCode(elementCode);
		taskElement.enter_VariableName(variableName);
		taskElement.choose_DataType(dataMap.get("Data Type"));
		taskElement.enter_Text1(dataMap.get("Text 1"));
		taskElement.choose_Layout(dataMap.get("Layout"));
		taskElement.choose_AnswerType(dataMap.get("Answer Type"));
		taskElement.click_SaveAsDraft();
		taskElement.message_TaskElementSaved_OK();
		taskElement.click_PublishThisVersion();
		taskElement.message_TaskElementPublished_OK();
	}

	public void the_task_element_is_created() throws Throwable {
		String elementCode = TaskElementData.getElementCode();
		taskElement.search_TaskElementByCode(elementCode);
		taskElement.present_TaskElement(elementCode);
	}

	public void i_delete_the_task_element() throws Throwable {
		if (taskElement.isTaskElementCreated()) {
			taskElement.click_tab_TaskElements();
			String elementCode = TaskElementData.getElementCode();
			taskElement.search_TaskElementByCode(elementCode);
			taskElement.choose_TaskElementByCode(elementCode);
			taskElement.click_Delete();
			taskElement.confirmation_DeleteTaskElement_Yes();
		}
	}

	public void i_create_a_sample_task_element_if_not_already_existing() throws Throwable {
		taskElement.click_tab_TaskElements();
		String elementCode = dataMap.get("Permanent Element Code");
		taskElement.search_TaskElementByCode(elementCode);
		// continue creating the permanent task element if not already existing
		String xpathTE = "//div[starts-with(@id,'elementlist') and contains(@id,'body')]//div[contains(@class,'x-grid-cell-inner') and text()='"
				+ elementCode + "']//ancestor::tr";
		if (!Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), xpathTE, true, false)) {
			createTaskElement(elementCode, dataMap.get("Permanent Variable Name"));
		}
	}

	public void i_create_a_task_element_with_the_following_informations(Map<String, String> data, String dateFormat) throws Throwable {
		dataMap = data;
		String elemntCode = dataMap.get("Element Code");
		elemntCode = elemntCode + "_" + dateFormat;
		System.out.println("elemntCode : " + elemntCode);
		String variableName = dataMap.get("Variable Name") + "_" + DataUtil.getDateFormatTxt();
		taskElement.click_tab_TaskElements();
		taskElement.click_Add();
		taskElement.enter_ElementCode(elemntCode);
		taskElement.enter_VariableName(variableName);
		taskElement.choose_DataType(dataMap.get("Data Type"));
		taskElement.enter_Text1(dataMap.get("Text 1"));
		
		if (dataMap.get("Layout") != null) {
			taskElement.choose_Layout(dataMap.get("Layout"));
		}
		
		if (dataMap.get("Text 2") != null) {
			taskElement.enter_Text2(dataMap.get("Text 2"));
		}
		
		if (dataMap.get("Text 2 Format") != null) {
			String fromat = dataMap.get("Text 2 Format");
			if(fromat.equals("Italics")) {
				taskElement.click_Italic_Icon();
			}
		}

		String answerType = dataMap.get("Answer Type");
		taskElement.choose_AnswerType(answerType);
		
		if(dataMap.get("Allow Audit") != null && dataMap.get("Allow Audit").equals("Yes")) {
			taskElement.click_checkbox_AllowEdit();
		}
		
		if(dataMap.get("Require Answer") != null && dataMap.get("Require Answer").equals("No")) {
			taskElement.click_checkbox_RequireAnswer();
		}
		
		
		String dataType = dataMap.get("Data Type");
		if(dataType.equals("Currency")) {
			taskElement.choose_RoundingMethod(dataMap.get("Rounding Method"));
		}

		if (dataMap.get("Answer Options") != null) {
			String answerOptions[] = dataMap.get("Answer Options").split(", ");
			if (answerType.equals("Drop Down") || answerType.equals("Checkbox")) {
//				taskElement.click_checkbox_AllowEdit();
				taskElement.click_edit_AnswerOtion();
				taskElement.addAnswerOptions(answerOptions);
				taskElement.click_edit_btn_SaveClose();
			}
		}

		taskElement.click_SaveAsDraft();
		taskElement.message_TaskElementSaved_OK();
		taskElement.click_PublishThisVersion();
		taskElement.message_TaskElementPublished_OK();
	}


}
