package flextesting.client;

public class DNC implements Client{

	private DNC() {
	}

	private static DNC instance = null;
	public static DNC getInstance() {
		if (instance==null) {
			instance = new DNC();
		}
		return instance;
	}

	@Override
	public String getFlexCenterUrl() {
		return "https://dnc.credagility.com/bcc";
	}

	@Override
	public String getFlexStationUrl() {
		return "https://dnc.credagility.com/agent";
	}


	@Override
	public String getDispositionOutcome() {
		return "Other (misc.)";
	}

	@Override
	public String getDBUrl() {
		return Client.buildDBURL("10.1.104.25", "C2PERF_DNC", true);
	}

}
