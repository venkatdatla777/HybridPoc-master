package flextesting.client;

public class SLMQA implements Client{
	private SLMQA() {
	}

	private static SLMQA instance = null;
	public static SLMQA getInstance() {
		if (instance==null) {
			instance = new SLMQA();
		}
		return instance;
	}
	@Override
	public String getFlexCenterUrl() {
		return "https://slmqa.credagility.com/bcc";
	}

	@Override
	public String getFlexStationUrl() {
		return "https://slmqa.credagility.com/agent";
	}

	@Override
	public String getDispositionOutcome() {
		return "Letter QC";
	}

//	@Override
//	public String getAvailablePortfolio() {
//		return "Sallie Mae (310001)";
//	}

	@Override
	public String getDBUrl() {
		return Client.buildDBURL("10.1.104.21", "C2QA_SLM", true);
	}
	
//	/* (non-Javadoc)
//	 * @see com.cmc.flextesting.client.Client#getRandomPhoneNumber()
//	 */
//	@Override
//	public String getRandomPhoneNumber() {
//		return DataUtil.getRandomPhoneNumber("333", 6);
//	}
	
}
