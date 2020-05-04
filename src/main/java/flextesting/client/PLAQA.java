package flextesting.client;

public class PLAQA implements Client{

	//constructor is private so that you have to call getInstance
	private PLAQA() {
//		System.out.println("++++++++++++++++ New PLAQA by :" + Thread.currentThread().getName()); 

	}

	private static PLAQA instance = null;
	public static PLAQA getInstance() {
		if (instance==null) {
			instance = new PLAQA();
		}
		return instance;
	}

	@Override
	public String getFlexCenterUrl() {
		return "https://plaqa.credagility.com/bcc";
	}

	@Override
	public String getFlexStationUrl() {
		return "https://plaqa.credagility.com/agent";
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
		return Client.buildDBURL("10.1.104.151", "C2QA_PLA", true);
	}

}
