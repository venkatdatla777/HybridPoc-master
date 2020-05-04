package flextesting.strategistportal.decisiontreemanager;


import com.qa.base.TestBase;
import flextesting.pagefactories.CommonElementsFactory;
import flextesting.pagefactories.strategistportal.decisiontreemanager.DecisionTreeCreationFactory;
import flextesting.utilities.DataUtil;

public class
BatchStrategyCreationStepsPage extends TestBase {
	/*private DecisionTreeCreationFactory decisionTreeCreationFactory;
	private CommonElementsFactory commonElementsFactory;*/
	private String batchStrategyName = "BatchStrategy41_" + DataUtil.getRandomChars();

	public void i_add_a_decision_tree_strategy() throws Throwable {
		createADTStrategy(batchStrategyName);
	}

	public void i_have_created_a_sample_decision_tree() throws Throwable {
		createADTStrategy("AS Batch Sample_" + DataUtil.getRandomChars());
	}

	private void createADTStrategy(String name) throws InterruptedException {
		decisionTreeCreationFactory.click_AddEditCopyDeleteStrategy("Add");
		commonElementsFactory.enterName(name);
		decisionTreeCreationFactory.save_AddStrategy();
	}

	public void i_edit_the_strategy_in_DTM() throws Throwable {
		decisionTreeCreationFactory.selectADecisionTree(batchStrategyName);
		decisionTreeCreationFactory.click_AddEditCopyDeleteStrategy("Edit");
		commonElementsFactory.enterDescription("decision tree edited");
		commonElementsFactory.click_Save();
	}

	public void the_strategy_should_be_edited() throws Throwable {
		decisionTreeCreationFactory.checkIfStrategyExist(true, batchStrategyName);
	}

	public void i_copy_the_strategy_in_DTM() throws Throwable {
		decisionTreeCreationFactory.selectADecisionTree(batchStrategyName);
		decisionTreeCreationFactory.click_AddEditCopyDeleteStrategy("Copy");
		commonElementsFactory.enterDescription("decision tree copy");
		commonElementsFactory.click_Save();
	}

	public void the_stragegy_should_be_copied() throws Throwable {
		decisionTreeCreationFactory.checkIfStrategyExist(true, batchStrategyName + " copy");
	}

	public void i_delete_the_strategy_in_DTM() throws Throwable {
		decisionTreeCreationFactory.selectADecisionTree(batchStrategyName);
		decisionTreeCreationFactory.click_AddEditCopyDeleteStrategy("Delete");
		commonElementsFactory.confirm_Yes();
	}

	public void the_stragegy_should_be_deleted() throws Throwable {
		decisionTreeCreationFactory.checkIfStrategyExist(false, batchStrategyName);
	}
	
	public void i_add_a_decision_tree_strategy_as(String bSName) throws Throwable {
		createADTStrategy(bSName);
	}
}
