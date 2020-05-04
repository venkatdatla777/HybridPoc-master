package features;

import features.steps.serenity.CIDStrategyCreationStep;

public class CIDStrategyCreationStepsDefination {

	CIDStrategyCreationStep cIDStrategyCreationStep;

	public void i_click_in_the_Strategies_panel(String btnName) throws Throwable {
		cIDStrategyCreationStep.i_click_in_the_Strategies_panel(btnName);
	}

	public void i_choose_as_the_Strategy_Type(String optionName) throws Throwable {
		cIDStrategyCreationStep.i_choose_as_the_Strategy_Type(optionName);
	}

	public void i_select_as_the_Event(String optionName) throws Throwable {
		cIDStrategyCreationStep.i_select_as_the_Event(optionName);
	}
	
	public void i_enter_a_Name_for_the_CID_strategy() throws Throwable {
		cIDStrategyCreationStep.i_enter_a_Name_for_the_CID_strategy();
	}
	
	public void i_select_as_the_context_for_the_Strategy(String context) throws Throwable {
		cIDStrategyCreationStep.i_select_as_the_context_for_the_Strategy(context);
	}

	public void the_CID_strategy_is_saved() throws Throwable {
		cIDStrategyCreationStep.the_CID_strategy_is_saved();
	}

	public void i_select_the_CID_strategy_just_created() throws Throwable {
		cIDStrategyCreationStep.i_select_the_CID_strategy_just_created();
	}

	public void the_CID_strategy_copy_is_saved() throws Throwable {
		cIDStrategyCreationStep.the_CID_strategy_copy_is_saved();
	}

	public void the_CID_strategy_is_deleted() throws Throwable {
		cIDStrategyCreationStep.the_CID_strategy_is_deleted();
	}
	
	public void i_add_a_CID_strategy_name_as_and_event_as(String name, String event) throws Throwable {
		cIDStrategyCreationStep.i_add_a_CID_strategy_name_as_and_event_as(name, event);
	}
}
