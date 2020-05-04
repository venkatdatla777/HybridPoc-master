package flextesting.client;

public class TDCQA implements Client{

	//constructor is private so that you have to call getInstance
	private TDCQA() {
//		System.out.println("++++++++++++++++ New PLAQA by :" + Thread.currentThread().getName()); 

	}

	private static TDCQA instance = null;
	public static TDCQA getInstance() {
		if (instance==null) {
			instance = new TDCQA();
		}
		return instance;
	}

	@Override
	public String getFlexCenterUrl() {
		return "https://tdcqabcc.cmcassist.com";
	}

	@Override
	public String getFlexStationUrl() {
		return "https://tdcqa.credagility.com/agent";
	}


	@Override
	public String getDispositionOutcome() {
		return "Other (misc.)";
	}

	@Override
	public String getDBUrl() {
		return Client.buildDBURL("10.1.104.21", "C2QA_TDC", true);
	}

}
