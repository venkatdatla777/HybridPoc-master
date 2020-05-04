package flextesting.client;


import flextesting.utilities.DataUtil;

public class FFEPERF implements Client{

	//constructor is private so that you have to call getInstance
	private FFEPERF() {
	}

	private static FFEPERF instance = null;
	public static FFEPERF getInstance() {
		if (instance==null) {
			instance = new FFEPERF();
		}
		return instance;
	}

	@Override
	public String getFlexCenterUrl() {
		return "https://ffeperf.credagility.com/bcc";
	}

	@Override
	public String getFlexStationUrl() {
		return "https://ffeperf.credagility.com/agent";
	}

	@Override
	public String getDispositionOutcome() {
		return "Comment";
	}

//	@Override
//	public String getAvailablePortfolio() {
//		return "DK Vivus (220207)";
//	}
	
	@Override
	public String getRandomPhoneNumber() {
		return DataUtil.getRandomPhoneNumber("55", 7);
	}

	@Override
	public String getDBUrl() {
		return Client.buildDBURL("10.10.4.31", "C2PERF_FFE", true);
	}

}
