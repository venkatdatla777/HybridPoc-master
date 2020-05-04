package flextesting.client;


import flextesting.utilities.DataUtil;

public class FFNPERF implements Client{

	//constructor is private so that you have to call getInstance
	private FFNPERF() {
	}

	private static FFNPERF instance = null;
	public static FFNPERF getInstance() {
		if (instance==null) {
			instance = new FFNPERF();
		}
		return instance;
	}

	@Override
	public String getFlexCenterUrl() {
		return "https://ffnperf.credagility.com/bcc";
	}

	@Override
	public String getFlexStationUrl() {
		return "https://ffnperf.credagility.com/agent";
	}

	@Override
	public String getDispositionOutcome() {
		return "Comment";
	}
//
//	@Override
//	public String getAvailablePortfolio() {
//		return "CZ Kimbi (220214)";
//	}
	
	@Override
	public String getRandomPhoneNumber() {
		return DataUtil.getRandomPhoneNumber("55", 7);
	}

	@Override
	public String getDBUrl() {
		return Client.buildDBURL("10.10.4.21", "C2PERF_FFN", true);
	}

}
