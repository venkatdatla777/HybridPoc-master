package flextesting.client;

public class ELVQA implements Client{
	private ELVQA() {
	}

	private static ELVQA instance = null;
	public static ELVQA getInstance() {
		if (instance==null) {
			instance = new ELVQA();
		}
		return instance;
	}
	@Override
	public String getFlexCenterUrl() {
		return "https://elvqa.credagility.com/bcc/ ";
	}

	@Override
	public String getFlexStationUrl() {
		return "https://elvqa.credagility.com/agent";
	}

	@Override
	public String getDispositionOutcome() {
		return "TEST";
	}



	@Override
	public String getDBUrl() {
		return Client.buildDBURL("10.1.104.151", "C2QA_ELV", true);
	}

}


