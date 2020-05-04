package features;


import features.steps.serenity.DTMExternalEntityStep;
import flextesting.strategistportal.defaultdata.DTMExternalEntityData;
import flextesting.utilities.DataUtil;

public class DTMExternalEntityStepDefination {


	DTMExternalEntityStep dTMExternalEntityStep;
	
	public void i_click_the_External_Entity_tab_in_DTM() throws Throwable {
		dTMExternalEntityStep.i_click_the_External_Entity_tab_in_DTM();
	}

	public void i_click_the_button_under_the_External_Entity_tab(String arg1) throws Throwable {
		dTMExternalEntityStep.i_click_the_button_under_the_External_Entity_tab(arg1);
	}

	public void i_enter_an_Action_Name_for_the_External_Entity() throws Throwable {
		dTMExternalEntityStep.i_enter_an_Action_Name_for_the_External_Entity();
	}

	public void i_choose_an_available_external_entity_in_the_Add_External_Entity_window() throws Throwable {
		dTMExternalEntityStep.i_choose_an_available_external_entity_in_the_Add_External_Entity_window();
	}

	public void the_external_entity_is_saved_in_Action_Repository() throws Throwable {
		dTMExternalEntityStep.the_external_entity_is_saved_in_Action_Repository();
	}
	
	public void i_create_a_external_entity_as_in_DTM(String arg1) throws Throwable {
		DTMExternalEntityData.setErternalEntityName(arg1+ DataUtil.getDateFormatTxt());
		dTMExternalEntityStep.i_create_a_external_entity_as_in_DTM(DTMExternalEntityData.getErternalEntityName());
	}
}
