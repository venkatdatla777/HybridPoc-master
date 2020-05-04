package flextesting.client;

public class TACQA implements Client {
	
	private TACQA() {

	}

	private static TACQA instance = null;
	public static TACQA getInstance() {
		if (instance==null) {
			instance = new TACQA();
		}
		return instance;
	}

	@Override
	public String getFlexCenterUrl() {
		return "https://tacqa.credagility.com/bcc";
	}

	@Override
	public String getFlexStationUrl() {
		return "https://tacqa.credagility.com/agent";
	}


	@Override
	public String getDispositionOutcome() {
		return "TEST";
	}

//	@Override
//	public String getAvailablePortfolio() {
//		return "CMC Test Portfolio (90901)";
//	}

	@Override
	public String getDBUrl() {
		return Client.buildDBURL("10.1.104.151", "C2QA_TAC", true);
	}

	}


