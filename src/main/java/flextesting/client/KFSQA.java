package flextesting.client;


import flextesting.utilities.DataUtil;

public class KFSQA implements Client{
	private KFSQA() {
	}

	private static KFSQA instance = null;
	public static KFSQA getInstance() {
		if (instance==null) {
			instance = new KFSQA();
		}
		return instance;
	}
	@Override
	public String getFlexCenterUrl() {
		return "https://kfsqa.credagility.com/bcc";
	}

	@Override
	public String getFlexStationUrl() {
		return "https://kfsqa.credagility.com/agent";
	}

	/*
	@Override
	public String getUsername() {
		return "schen";
	}

	@Override
	public String getPassword() {
		return "Test123#";
	}
	*/

	@Override
	public String getDispositionOutcome() {
		return "Other (misc.)";
	}

//	@Override
//	public String getAvailablePortfolio() {
//		return "Kessler Financial Services (280300)";
//	}

	@Override
	public String getDBUrl() {
		return Client.buildDBURL("10.1.104.21", "C2QA_KFS", true);
	}
	
	/* (non-Javadoc)
	 * @see com.cmc.flextesting.client.Client#getRandomPhoneNumber()
	 */
	@Override
	public String getRandomPhoneNumber() {
		return DataUtil.getRandomPhoneNumber("333", 6);
	}
	
}
