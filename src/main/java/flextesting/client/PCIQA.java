package flextesting.client;

public class PCIQA implements Client{

	//constructor is private so that you have to call getInstance
	private PCIQA() {
	}

	private static PCIQA instance = null;
	public static PCIQA getInstance() {
		if (instance==null) {
			instance = new PCIQA();
		}
		return instance;
	}

	@Override
	public String getFlexCenterUrl() {
		return "https://pciqa.credagility.com/bcc";
	}

	@Override
	public String getFlexStationUrl() {
		return "https://pciqa.credagility.com/agent";
	}

	@Override
	public String getDispositionOutcome() {
		return "Account maintenance";
	}


	@Override
	public String getDBUrl() {
		return Client.buildDBURL("10.1.104.21", "C2QA_PCI", true);
	}

}
