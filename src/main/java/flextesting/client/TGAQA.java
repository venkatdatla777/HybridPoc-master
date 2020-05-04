package flextesting.client;

public class TGAQA implements Client {
	private TGAQA() {
	}

	private static TGAQA instance = null;
	public static TGAQA getInstance() {
		if (instance==null) {
			instance = new TGAQA();
		}
		return instance;
	}

	@Override
	public String getFlexCenterUrl() {
		return "https://tgaqa.credagility.com/bcc";
	}

	@Override
	public String getFlexStationUrl() {
		return "https://tgaqa.credagility.com/agent";
	}


	@Override
	public String getDispositionOutcome() {
		return "Other (misc.)";
	}

	@Override
	public String getDBUrl() {
		return Client.buildDBURL("10.1.104.151", "C2QA_TGA", true);
	}

}
