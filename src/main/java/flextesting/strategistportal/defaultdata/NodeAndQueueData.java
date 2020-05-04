package flextesting.strategistportal.defaultdata;


import static flextesting.utilities.DataUtil.getRandomChars;

public class NodeAndQueueData {
	
	private static String newQueueName;
	
	public static String getQueueName() {
		return "Queue_"+getRandomChars();
	}
	public static String getQueueDescription() {
		return "Queue description";
	}
	//decision tree nodes have the same name as the queue
	public static String[] getNodeAndQueueNames() {
		String[] nodeandqueueNames = {"Bankruptcy_"+getRandomChars(),"Fraud_"+getRandomChars(),"Left Over_"+getRandomChars()};
		return nodeandqueueNames;
	}
	
	//decision tree nodes have the same name as the queue
	public static String[] getPermanentNodeAndQueueNames() {
		//AT: automated testing
		String[] nodeandqueueNames = {"Bankruptcy_AT41","Fraud_AT41","Left Over_AT41"};
		return nodeandqueueNames;
	}
	public static String getNewQueueName() {
		return newQueueName;
	}
	public static void setNewQueueName(String newQueueName) {
		NodeAndQueueData.newQueueName = newQueueName;
	}	
	
}
