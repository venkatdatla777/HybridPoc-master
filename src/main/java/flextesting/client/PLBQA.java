package flextesting.client;

public class PLBQA implements Client{
	private PLBQA() {
	}

	private static PLBQA instance = null;
	public static PLBQA getInstance() {
		if (instance==null) {
			instance = new PLBQA();
		}
		return instance;
	}
	@Override
	public String getFlexCenterUrl() {
		return "https://plbqa.credagility.com/bcc";
	}

	@Override
	public String getFlexStationUrl() {
		return "https://plbqa.credagility.com/agent";
	}

	@Override
	public String getDispositionOutcome() {
		return "Account maintenance";
	}

//	@Override
//	public String getAvailablePortfolio() {
//		return "Auto (90903)";
//	}

	@Override
	public String getDBUrl() {
		return Client.buildDBURL("10.1.104.151", "C2QA_PLB", true);
	}
//	public String getDBUrl() {
//		return Client.buildDBURL("10.1.104.151", "C2QA_PLB_GA82", true);
//	}
}
