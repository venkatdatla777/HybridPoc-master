package flextesting.client;

public class SMWQA implements Client{
	private SMWQA() {
	}

	private static SMWQA instance = null;
	public static SMWQA getInstance() {
		if (instance==null) {
			instance = new SMWQA();
		}
		return instance;
	}
	@Override
	public String getFlexCenterUrl() {
		return "https://smwqa.credagility.com/bcc";
	}

	@Override
	public String getFlexStationUrl() {
		return "https://smwqa.credagility.com/agent";
	}

	@Override
	public String getDispositionOutcome() {
		return "QOC";
	}

//	@Override
//	public String getAvailablePortfolio() {
//		return "Sallie Mae (310001)";
//	}

	@Override
	public String getDBUrl() {
		return Client.buildDBURL("10.1.104.21", "C2QA_SMW", true);
	}
	
//	/* (non-Javadoc)
//	 * @see com.cmc.flextesting.client.Client#getRandomPhoneNumber()
//	 */
//	@Override
//	public String getRandomPhoneNumber() {
//		return DataUtil.getRandomPhoneNumber("333", 6);
//	}
	
}
