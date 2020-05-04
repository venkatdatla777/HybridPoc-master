package flextesting.client;

public class REFQA implements Client{

	private REFQA() {
	}

	private static REFQA instance = null;
	public static REFQA getInstance() {
		if (instance==null) {
			instance = new REFQA();
		}
		return instance;
	}

	@Override
	public String getFlexCenterUrl() {
		return "https://refqa.credagility.com/bcc";
	}

	@Override
	public String getFlexStationUrl() {
		return "https://refqa.credagility.com/agent";
	}


	@Override
	public String getDispositionOutcome() {
		return "Other (misc.)";
	}

//	@Override
//	public String getAvailablePortfolio() {
//		return "CMC Test Portfolio (90901)";
//	}

	@Override
	public String getDBUrl() {
		return Client.buildDBURL("10.1.104.151", "C2QA_REF", true);
	}

}
