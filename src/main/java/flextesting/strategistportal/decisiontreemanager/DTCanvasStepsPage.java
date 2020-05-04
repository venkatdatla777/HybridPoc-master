package flextesting.strategistportal.decisiontreemanager;


import com.qa.base.TestBase;
import flextesting.pagefactories.strategistportal.decisiontreemanager.DecisionTreeCanvasFactory;
import flextesting.strategistportal.defaultdata.ChannelData;
import flextesting.strategistportal.defaultdata.NodeAndQueueData;
import flextesting.strategistportal.defaultdata.ProgramData;

public class DTCanvasStepsPage extends DecisionTreeCanvasFactory {

	public void the_strategy_should_be_created() throws Throwable {
		decisionTreeCanvasFactory.present_rootNode();
	}

	public void i_change_the_name_and_set_a_criteria_for_the_root_node() throws Throwable {
		decisionTreeCanvasFactory.rightClick_RootNode();
		decisionTreeCanvasFactory.choose_ManageCurrentNode();
		decisionTreeCanvasFactory.window_EditNode();
		decisionTreeCanvasFactory.enter_NodeName("Root41");
		decisionTreeCanvasFactory.enter_Criteria("balance>=0");
		decisionTreeCanvasFactory.save_EditNode();
	}

	public void i_add_some_children_nodes() throws Throwable {
		decisionTreeCanvasFactory.rightClick_RootNode();
		decisionTreeCanvasFactory.choose_ManageChildNodes();
		decisionTreeCanvasFactory.window_ManageChildNodes();
		decisionTreeCanvasFactory.click_Add_window_ManageChildNodes();
		decisionTreeCanvasFactory.window_CreateNode();
		decisionTreeCanvasFactory.enter_NodeName(NodeAndQueueData.getPermanentNodeAndQueueNames()[0]);
		System.out.println("NodeAndQueueData.getPermanentNodeAndQueueNames()[0] : " + NodeAndQueueData.getPermanentNodeAndQueueNames()[0]);
		decisionTreeCanvasFactory.enter_Criteria("accountStatus = \"BKR\"");
		decisionTreeCanvasFactory.save_CreateNode();
		decisionTreeCanvasFactory.click_Add_window_ManageChildNodes();
		decisionTreeCanvasFactory.window_CreateNode();
		decisionTreeCanvasFactory.enter_NodeName(NodeAndQueueData.getPermanentNodeAndQueueNames()[1]);
		System.out.println("NodeAndQueueData.getPermanentNodeAndQueueNames()[1] : " + NodeAndQueueData.getPermanentNodeAndQueueNames()[1]);
		decisionTreeCanvasFactory.enter_Criteria("accountStatus = \"FRD\"");
		decisionTreeCanvasFactory.save_CreateNode();
		decisionTreeCanvasFactory.close_ManageChildNodesWindow();
	}

	public void the_strategy_should_be_updated() throws Throwable {
		//TODO assuming true for now
	}
	
	public void i_attach_the_program_to_the_decision_tree() throws Throwable {
		decisionTreeCanvasFactory.rightClick_RootNode();
		attachProgramByName(ProgramData.getName());
	}
	private void attachProgramByName(String name) throws InterruptedException {
		decisionTreeCanvasFactory.choose_ManagePrograms();
		decisionTreeCanvasFactory.click_AssignAvailableActionsToNode();
		decisionTreeCanvasFactory.check_AssignAvailableActionsToNode_ActionName(name);
		decisionTreeCanvasFactory.click_Submit_window_AssignAvailableActionsToNode();
		decisionTreeCanvasFactory.message_AssignProgramActionToNode_OK();
		decisionTreeCanvasFactory.click_close_window_NodeProgramActions();
	}

	public void the_program_is_attached_to_the_decision_tree() throws Throwable {
		//TODO
	}
	
	public void i_attach_the_channel_to_the_decision_tree() throws Throwable {
		decisionTreeCanvasFactory.rightClick_RootNode();
		attachChannelByName(ChannelData.getName());
	}
	private void attachChannelByName(String name) throws InterruptedException {
		decisionTreeCanvasFactory.choose_ManageChannels();
		decisionTreeCanvasFactory.click_AssignAvailableActionsToNode();
//		decisionTreeCanvasFactory.check_AssignAvailableActionsToNode_theFirstChannel();
		decisionTreeCanvasFactory.check_AssignAvailableActionsToNode_ActionName(name);
		decisionTreeCanvasFactory.click_Submit_window_AssignAvailableActionsToNode();
		decisionTreeCanvasFactory.message_AssignChannelActionToNode_OK();
		decisionTreeCanvasFactory.click_close_window_NodeChannelActions();	
	}
	

	public void the_channel_is_attached_to_the_decision_tree() throws Throwable {
		//TODO
	}

	public void i_attach_the_queue_to_the_decision_tree() throws Throwable {
		decisionTreeCanvasFactory.rightClick_RootNode();
		attachQueueByName(NodeAndQueueData.getQueueName());
	}
	private void attachQueueByName(String name) throws InterruptedException{
		decisionTreeCanvasFactory.choose_ManageQueues();
		decisionTreeCanvasFactory.click_AssignAvailableActionsToNode();
//		decisionTreeCanvasFactory.check_AssignAvailableActionsToNode_theFirstQueue();
		decisionTreeCanvasFactory.check_AssignAvailableActionsToNode_ActionName(name);
		decisionTreeCanvasFactory.click_Submit_window_AssignAvailableActionsToNode();
		decisionTreeCanvasFactory.message_AssignQueueActionToNode_OK();
		decisionTreeCanvasFactory.click_close_window_NodeQueueActions();	
	}

	public void the_queue_is_attached_to_the_decision_tree() throws Throwable {
		//TODO
	}
	
	//for multiple channels and queues attachment and deletion
	public void i_attach_the_program_to_the_nth_child_node(int nth) throws Throwable {
		System.out.println("int nth : " + nth);
		//if it's the last node (left over node), it has a different name than the queue name
		if(nth == NodeAndQueueData.getPermanentNodeAndQueueNames().length)
			decisionTreeCanvasFactory.rightClick_NodeByName("Left Over");
		else
			decisionTreeCanvasFactory.rightClick_NodeByName(NodeAndQueueData.getPermanentNodeAndQueueNames()[nth-1]);
		System.out.println("NodeAndQueueData.getPermanentNodeAndQueueNames()[nth-1] :" + NodeAndQueueData.getPermanentNodeAndQueueNames()[nth-1]);
		attachProgramByName(ProgramData.getPermanentName());
	}

	public void i_attach_the_channel_to_the_nth_child_node(String channelType, int nth) throws Throwable {
		System.out.println("String channelType : " + channelType);
		System.out.println("int nth : " + nth);
		//if it's the last node (left over node), it has a different name than the queue name
		if(nth == NodeAndQueueData.getPermanentNodeAndQueueNames().length)
			decisionTreeCanvasFactory.rightClick_NodeByName("Left Over");
		else
			decisionTreeCanvasFactory.rightClick_NodeByName(NodeAndQueueData.getPermanentNodeAndQueueNames()[nth-1]);
		System.out.println("NodeAndQueueData.getPermanentNodeAndQueueNames()[nth-1] :" + NodeAndQueueData.getPermanentNodeAndQueueNames()[nth-1]);
		attachChannelByName(ChannelData.getPermanentNameByType(channelType));
	}

	public void i_attach_the_corresponding_queue_to_each_of_the_children_nodes() throws Throwable {
		for (int i = 0; i<NodeAndQueueData.getPermanentNodeAndQueueNames().length; i++) {
			//if it's the last node (left over node), it has a different name than the queue name
			if(i == NodeAndQueueData.getPermanentNodeAndQueueNames().length-1)
				decisionTreeCanvasFactory.rightClick_NodeByName("Left Over");
			else
				decisionTreeCanvasFactory.rightClick_NodeByName(NodeAndQueueData.getPermanentNodeAndQueueNames()[i]);
			attachQueueByName(NodeAndQueueData.getPermanentNodeAndQueueNames()[i]);
		}
	}
	
	public void i_add_a_child_node_name_as_and_criteria_as(String childNodeName, String criteria) throws Throwable {
		decisionTreeCanvasFactory.rightClick_RootNode();
		decisionTreeCanvasFactory.choose_ManageChildNodes();
		decisionTreeCanvasFactory.window_ManageChildNodes();
		decisionTreeCanvasFactory.click_Add_window_ManageChildNodes();
		decisionTreeCanvasFactory.window_CreateNode();
		decisionTreeCanvasFactory.enter_NodeName(childNodeName);
		decisionTreeCanvasFactory.enter_Criteria(criteria);
		decisionTreeCanvasFactory.save_CreateNode();
		decisionTreeCanvasFactory.close_ManageChildNodesWindow();
	}
	
	public void i_open_Manage_child_s_for_sub_root(String subRootName) throws Throwable {
		decisionTreeCanvasFactory.rightClick_NodeByName(subRootName);
		decisionTreeCanvasFactory.choose_ManageChildNodes();
		decisionTreeCanvasFactory.window_ManageChildNodes();
	}
	
	private void addChildNode(String childNodeName, String criteria) throws InterruptedException {
		decisionTreeCanvasFactory.click_Add_window_ManageChildNodes();
		decisionTreeCanvasFactory.window_CreateNode();
		decisionTreeCanvasFactory.enter_NodeName(childNodeName);
		decisionTreeCanvasFactory.enter_Criteria_withoutCheckingCheckBox_ExclusiveCriteria(criteria);
		decisionTreeCanvasFactory.save_CreateNode();
	}
	
	public void i_add_a_sub_child_node_name_as_and_criteria_as(String childNodeName, String criteria) throws Throwable {
		addChildNode(childNodeName, criteria);
	}

	public void i_close_the_Manage_child_s_for_sub_root() throws Throwable {
		decisionTreeCanvasFactory.close_ManageChildNodesWindow();
	}
	
	public void i_rename_the_root_to(String name, String arg2) throws Throwable {
		decisionTreeCanvasFactory.rightClick_NodeByName(name);
		decisionTreeCanvasFactory.choose_ManageCurrentNode();
		decisionTreeCanvasFactory.window_EditNode();
		decisionTreeCanvasFactory.enter_NodeName(arg2);
		decisionTreeCanvasFactory.save_EditNode();
	}
	
	public void i_attach_the_queue_to_the_node(String queueName, String nodeName) throws Throwable {
		decisionTreeCanvasFactory.rightClick_NodeByName(nodeName);
		attachQueueByName(queueName);
	}
	
	public void i_attach_the_program_to_the_node(String programName, String nodeName) throws Throwable {
		decisionTreeCanvasFactory.rightClick_NodeByName(nodeName);
		attachProgramByName(programName);
	}

	public void i_attach_updated_action_variable_as_and_if_as_and_then_as_to_the_node(String variablename, String ifValue, String thenValue, String nodeName) throws Throwable {
		decisionTreeCanvasFactory.rightClick_NodeByName(nodeName);
		attachUpdatedAction(variablename, ifValue, thenValue);
	}
	
	private void attachUpdatedAction(String variablename, String ifValue, String thenValue) throws InterruptedException {
		decisionTreeCanvasFactory.choose_AssignUpdateAction();
		decisionTreeCanvasFactory.click_AddUpdateAction();
		decisionTreeCanvasFactory.click_VariableDropdown();
		decisionTreeCanvasFactory.choose_VariableName(variablename);
		decisionTreeCanvasFactory.enter_IfTxt(ifValue);
		decisionTreeCanvasFactory.enter_ThenTxt(thenValue);
		decisionTreeCanvasFactory.save_UpdateActionBtn();
		decisionTreeCanvasFactory.click_close_window_UpdateAction();
	}
	
	public void i_attach_the_external_entity_to_the_node(String externalEntityname, String nodeName) throws Throwable {
		decisionTreeCanvasFactory.rightClick_NodeByName(nodeName);
		attachExternalEntityByName(externalEntityname);
	}
	
	private void attachExternalEntityByName(String name) throws InterruptedException {
		decisionTreeCanvasFactory.choose_ManageExternalEnitity();
		decisionTreeCanvasFactory.click_AssignAvailableActionsToNode();
		// decisionTreeCanvasFactory.check_AssignAvailableActionsToNode_theFirstChannel();
		decisionTreeCanvasFactory.check_AssignAvailableActionsToNode_ActionName(name);
		decisionTreeCanvasFactory.click_Submit_window_AssignAvailableActionsToNode();
		decisionTreeCanvasFactory.message_AssignChannelActionToNode_OK();
		decisionTreeCanvasFactory.click_close_window_NodeExternalEntityActions();
	}
	
	public void i_attach_the_channel_to_the_node(String channelName, String nodeName) throws Throwable {
		decisionTreeCanvasFactory.rightClick_NodeByName(nodeName);
		attachChannelByName(channelName);
	}

}
