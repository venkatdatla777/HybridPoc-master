package flextesting.client;

public class TNA implements Client{
	private TNA() {
	}

	private static TNA instance = null;
	public static TNA getInstance() {
		if (instance==null) {
			instance = new TNA();
		}
		return instance;
	}
	@Override
	public String getFlexCenterUrl() {
		return "https://tna.credagility.com/bcc";
	}

	@Override
	public String getFlexStationUrl() {
		return "https://tna.credagility.com/agent";
	}

	@Override
	public String getUsername() {
		return "schen";
	}

	@Override
	public String getPassword() {
		return "Test123@";
	}

	@Override
	public String getDispositionOutcome() {
		return "TEST";
	}

//	@Override
//	public String getAvailablePortfolio() {
//		return "Gold Card (90901)";
//	}

	@Override
	public String getDBUrl() {
		return Client.buildDBURL("10.1.4.70", "C2PERF_TNA", false);
	}

}
