package flextesting.client;

public class FFBQA implements Client{

	//constructor is private so that you have to call getInstance
	private FFBQA() {
	}

	private static FFBQA instance = null;
	public static FFBQA getInstance() {
		if (instance==null) {
			instance = new FFBQA();
		}
		return instance;
	}

	@Override
	public String getFlexCenterUrl() {
		return "https://ffbqa.credagility.com/bcc";
	}

	@Override
	public String getFlexStationUrl() {
		return "https://ffbqa.credagility.com/agent";
	}

	@Override
	public String getDispositionOutcome() {
		return "Comment";
	}

	@Override
	public String getDBUrl() {
		return Client.buildDBURL("10.1.104.151", "C2QA_FFB", true);
	}

}
