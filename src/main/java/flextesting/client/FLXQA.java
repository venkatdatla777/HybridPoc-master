package flextesting.client;

public class FLXQA implements Client{
	private FLXQA() {
	}

	private static FLXQA instance = null;
	public static FLXQA getInstance() {
		if (instance==null) {
			instance = new FLXQA();
		}
		return instance;
	}
	@Override
	public String getFlexCenterUrl() {
		return "https://flxqa.credagility.com/bcc";
	}

	@Override
	public String getFlexStationUrl() {
		return "https://flxqa.credagility.com/agent";
	}

	@Override
	public String getUsername() {
		return "schen";
	}

	@Override
	public String getPassword() {
		return "Test123%";
	}

	@Override
	public String getDispositionOutcome() {
		//TODO
		return "";
//		return "Other (misc.)";
	}

//	@Override
//	public String getAvailablePortfolio() {
//		return "Credit Card (330002)";
//	}

	@Override
	public String getDBUrl() {
		//TODO
		return "";
//		return Client.buildDBURL("10.1.104.21", "C2QA_KFS", true);
	}
	
//	/* (non-Javadoc)
//	 * @see com.cmc.flextesting.client.Client#getRandomPhoneNumber()
//	 */
//	@Override
//	public String getRandomPhoneNumber() {
//		return DataUtil.getRandomPhoneNumber("333", 6);
//	}
	
}
