package features.steps.serenity;


import flextesting.strategistportal.decisiontreemanager.DTCanvasStepsPage;

public class DTCanvasStep {
	DTCanvasStepsPage dTCanvasStepsPage;


	public void the_strategy_should_be_created() throws Throwable {
		dTCanvasStepsPage.the_strategy_should_be_created();
	}


	public void i_change_the_name_and_set_a_criteria_for_the_root_node() throws Throwable {
		dTCanvasStepsPage.i_change_the_name_and_set_a_criteria_for_the_root_node();
	}


	public void i_add_some_children_nodes() throws Throwable {
		dTCanvasStepsPage.i_add_some_children_nodes();
	}


	public void the_strategy_should_be_updated() throws Throwable {
		// TODO assuming true for now
		dTCanvasStepsPage.the_strategy_should_be_updated();
	}


	public void i_attach_the_program_to_the_decision_tree() throws Throwable {
		dTCanvasStepsPage.i_attach_the_program_to_the_decision_tree();
	}


	public void the_program_is_attached_to_the_decision_tree() throws Throwable {
		// TODO
		dTCanvasStepsPage.the_program_is_attached_to_the_decision_tree();
	}


	public void i_attach_the_channel_to_the_decision_tree() throws Throwable {
		dTCanvasStepsPage.i_attach_the_channel_to_the_decision_tree();
	}


	public void the_channel_is_attached_to_the_decision_tree() throws Throwable {
		// TODO
		dTCanvasStepsPage.the_channel_is_attached_to_the_decision_tree();
	}


	public void i_attach_the_queue_to_the_decision_tree() throws Throwable {
		dTCanvasStepsPage.i_attach_the_queue_to_the_decision_tree();
	}


	public void the_queue_is_attached_to_the_decision_tree() throws Throwable {
		// TODO
		dTCanvasStepsPage.the_queue_is_attached_to_the_decision_tree();
	}

	// for multiple channels and queues attachment and deletion

	public void i_attach_the_program_to_the_nth_child_node(int nth) throws Throwable {
		dTCanvasStepsPage.i_attach_the_program_to_the_nth_child_node(nth);
	}


	public void i_attach_the_channel_to_the_nth_child_node(String channelType, int nth) throws Throwable {
		dTCanvasStepsPage.i_attach_the_channel_to_the_nth_child_node(channelType, nth);
	}


	public void i_attach_the_corresponding_queue_to_each_of_the_children_nodes() throws Throwable {
		dTCanvasStepsPage.i_attach_the_corresponding_queue_to_each_of_the_children_nodes();
	}


	public void i_add_a_child_node_name_as_and_criteria_as(String childNodeName, String criteria) throws Throwable {
		dTCanvasStepsPage.i_add_a_child_node_name_as_and_criteria_as(childNodeName, criteria);
	}
	

	public void i_open_Manage_child_s_for_sub_root(String subRootName) throws Throwable {
		dTCanvasStepsPage.i_open_Manage_child_s_for_sub_root(subRootName);
	}
	

	public void i_add_a_sub_child_node_name_as_and_criteria_as(String childNodeName, String criteria) throws Throwable {
		dTCanvasStepsPage.i_add_a_sub_child_node_name_as_and_criteria_as(childNodeName, criteria);
	}
	

	public void i_close_the_Manage_child_s_for_sub_root() throws Throwable {
		dTCanvasStepsPage.i_close_the_Manage_child_s_for_sub_root();
	}
	

	public void i_rename_the_root_to(String arg1, String arg2) throws Throwable {
		dTCanvasStepsPage.i_rename_the_root_to(arg1, arg2);
	}
	

	public void i_attach_the_queue_to_the_node(String queueName, String nodeName) throws Throwable {
		dTCanvasStepsPage.i_attach_the_queue_to_the_node(queueName, nodeName);
	}
	

	public void i_attach_the_program_to_the_node(String programName, String nodeName) throws Throwable {
		dTCanvasStepsPage.i_attach_the_program_to_the_node(programName, nodeName);
	}
	

	public void i_attach_updated_action_variable_as_and_if_as_and_then_as_to_the_node(String variablename, String ifValue, String thenValue, String nodeName) throws Throwable {
		dTCanvasStepsPage.i_attach_updated_action_variable_as_and_if_as_and_then_as_to_the_node(variablename, ifValue, thenValue, nodeName);
	}
	

	public void i_attach_the_external_entity_to_the_node(String externalEntityname, String nodeName) throws Throwable {
		dTCanvasStepsPage.i_attach_the_external_entity_to_the_node(externalEntityname, nodeName);
	}
	

	public void i_attach_the_channel_to_the_node(String channelName, String nodeName) throws Throwable {
		dTCanvasStepsPage.i_attach_the_channel_to_the_node(channelName, nodeName);
	}
	
}