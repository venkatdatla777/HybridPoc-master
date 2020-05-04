package flextesting.client;

public class PCRQA implements Client{

	private PCRQA() {
	}

	private static PCRQA instance = null;
	public static PCRQA getInstance() {
		if (instance==null) {
			instance = new PCRQA();
		}
		return instance;
	}

	@Override
	public String getFlexCenterUrl() {
		return "https://pcrqa.credagility.com/bcc";
	}

	@Override
	public String getFlexStationUrl() {
		return "https://pcrqa.credagility.com/agent";
	}


	@Override
	public String getDispositionOutcome() {
		return "Other (misc.)";
	}

	@Override
	public String getDBUrl() {
		return Client.buildDBURL("10.1.104.151", "C2QA_PCR", true);
	}

}
