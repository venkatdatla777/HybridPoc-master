package flextesting.client;

public class UCOQA implements Client{

	//constructor is private so that you have to call getInstance
	private UCOQA() {
	}

	private static UCOQA instance = null;
	public static UCOQA getInstance() {
		if (instance==null) {
			instance = new UCOQA();
		}
		return instance;
	}

	@Override
	public String getFlexCenterUrl() {
		return "https://ucoqa.credagility.com/bcc";
	}

	@Override
	public String getFlexStationUrl() {
		return "https://ucoqa.credagility.com/agent";
	}

	@Override
	public String getDispositionOutcome() {
		return "Skip accounts";
	}

	@Override
	public String getDBUrl() {
		return Client.buildDBURL("10.1.104.21", "C2QA_UCO", true);
	}

}
