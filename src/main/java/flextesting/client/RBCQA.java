package flextesting.client;

public class RBCQA implements Client {
	private RBCQA() {
	}

	private static RBCQA instance = null;
	public static RBCQA getInstance() {
		if (instance==null) {
			instance = new RBCQA();
		}
		return instance;
	}

	@Override
	public String getFlexCenterUrl() {
		return "https://rbcqa.credagility.com/bcc";
	}

	@Override
	public String getFlexStationUrl() {
		return "https://rbcqa.credagility.com/agent";
	}


	@Override
	public String getDispositionOutcome() {
		return "Other (misc.)";
	}

	@Override
	public String getDBUrl() {
		return Client.buildDBURL("10.1.104.151", "C2QA_RBC", true);
	}

}


