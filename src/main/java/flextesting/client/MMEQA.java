package flextesting.client;

public class MMEQA implements Client{
	private MMEQA() {
	}

	private static MMEQA instance = null;
	public static MMEQA getInstance() {
		if (instance==null) {
			instance = new MMEQA();
		}
		return instance;
	}
	@Override
	public String getFlexCenterUrl() {
		return "https://mmeqa.credagility.com/bcc";
	}

	@Override
	public String getFlexStationUrl() {
		return "https://mmeqa.credagility.com/agent";
	}

	@Override
	public String getDispositionOutcome() {
		return "TEST";
	}

//	@Override
//	public String getAvailablePortfolio() {
//		return "Momentum (280400)";
//	}

	@Override
	public String getDBUrl() {
		return Client.buildDBURL("10.1.104.151", "C2QA_MME", true);
	}

}
