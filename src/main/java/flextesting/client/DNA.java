package flextesting.client;

public class DNA implements Client{
	private DNA() {
	}

	private static DNA instance = null;
	public static DNA getInstance() {
		if (instance==null) {
			instance = new DNA();
		}
		return instance;
	}
	@Override
	public String getFlexCenterUrl() {
		return "https://dna.credagility.com/bcc";
	}

	@Override
	public String getFlexStationUrl() {
		return "https://dna.credagility.com/agent";
	}

	@Override
	public String getUsername() {
		return "schen";
	}

	@Override
	public String getPassword() {
		return "Test123$";
	}

	@Override
	public String getDispositionOutcome() {
		return "TEST";
	}

//	@Override
//	public String getAvailablePortfolio() {
//		return "Auto Credit Card (90903)";
//	}

	@Override
	public String getDBUrl() {
		return Client.buildDBURL("10.1.104.25", "C2PERF_DNA", true);
	}

}
