package features;


import features.steps.serenity.BatchStrategyCreationStep;

public class BatchStrategyCreationStepDefination {

	BatchStrategyCreationStep batchStrategyCreationStep;


	public void i_add_a_decision_tree_strategy() throws Throwable {
		batchStrategyCreationStep.i_add_a_decision_tree_strategy();
	}

	public void i_have_created_a_sample_decision_tree() throws Throwable {
		batchStrategyCreationStep.i_have_created_a_sample_decision_tree();
	}

	public void i_edit_the_strategy_in_DTM() throws Throwable {
		batchStrategyCreationStep.i_edit_the_strategy_in_DTM();
	}

	public void the_strategy_should_be_edited() throws Throwable {
		batchStrategyCreationStep.the_strategy_should_be_edited();
	}

	public void i_copy_the_strategy_in_DTM() throws Throwable {
		batchStrategyCreationStep.i_copy_the_strategy_in_DTM();
	}

	public void the_stragegy_should_be_copied() throws Throwable {
		batchStrategyCreationStep.the_stragegy_should_be_copied();
	}

	public void i_delete_the_strategy_in_DTM() throws Throwable {
		batchStrategyCreationStep.i_delete_the_strategy_in_DTM();
	}

	public void the_stragegy_should_be_deleted() throws Throwable {
		batchStrategyCreationStep.the_stragegy_should_be_deleted();
	}

	// Added new steps
	public void i_add_a_decision_tree_strategy_as(String batchStrategyName) throws Throwable {
		batchStrategyCreationStep.i_add_a_decision_tree_strategy_as(batchStrategyName);
	}

}