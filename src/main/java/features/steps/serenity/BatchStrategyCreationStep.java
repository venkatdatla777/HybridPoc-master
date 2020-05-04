package features.steps.serenity;


import flextesting.strategistportal.decisiontreemanager.BatchStrategyCreationStepsPage;

public class BatchStrategyCreationStep extends  BatchStrategyCreationStepsPage{


	public void i_add_a_decision_tree_strategy() throws Throwable {
		batchStrategyCreationStepsPage.i_add_a_decision_tree_strategy();
	}
	
	public void i_have_created_a_sample_decision_tree() throws Throwable {
		batchStrategyCreationStepsPage.i_have_created_a_sample_decision_tree();
	}
	
	
	public void i_edit_the_strategy_in_DTM() throws Throwable {
		batchStrategyCreationStepsPage.i_edit_the_strategy_in_DTM();
	}

	public void the_strategy_should_be_edited() throws Throwable {
		batchStrategyCreationStepsPage.the_strategy_should_be_edited();
	}
	
	public void i_copy_the_strategy_in_DTM() throws Throwable {
		batchStrategyCreationStepsPage.i_copy_the_strategy_in_DTM();
	}

	public void the_stragegy_should_be_copied() throws Throwable {
		batchStrategyCreationStepsPage.the_stragegy_should_be_copied();
	}

	public void i_delete_the_strategy_in_DTM() throws Throwable {
		batchStrategyCreationStepsPage.i_delete_the_strategy_in_DTM();
	}

	public void the_stragegy_should_be_deleted() throws Throwable {
		batchStrategyCreationStepsPage.the_stragegy_should_be_deleted();
	}	
	
	
	public void
	i_add_a_decision_tree_strategy_as(String batchStrategyName) throws Throwable {
		batchStrategyCreationStepsPage.i_add_a_decision_tree_strategy_as(batchStrategyName);
	}

}