package flextesting.client;

//TODO: Disposition; Verification window 
public class GSCQA implements Client{

	//constructor is private so that you have to call getInstance
	private GSCQA() {
	}

	private static GSCQA instance = null;
	public static GSCQA getInstance() {
		if (instance==null) {
			instance = new GSCQA();
		}
		return instance;
	}

	@Override
	public String getFlexCenterUrl() {
		return "https://gscqa.credagility.com/bcc";
	}

	@Override
	public String getFlexStationUrl() {
		return "https://gscqa.credagility.com/agent";
	}

	@Override
	public String getDispositionOutcome() {
		return "Skip accounts";
	}

	@Override
	public String getDBUrl() {
		return Client.buildDBURL("10.1.104.21", "C2QA_GSC", true);
	}

}
