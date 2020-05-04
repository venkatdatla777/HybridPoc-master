package flextesting.client;


import flextesting.AppConfig;
import org.apache.log4j.Logger;
import sun.security.util.PendingException;

import java.util.Collection;

public class ScenarioInfo {
	static Logger log = Logger.getLogger(ScenarioInfo.class);
	private static Collection<String> tags = null;
	public static Collection<String> getTags() {
		return tags;
	}
	/**
	 * check if the tag contains "@not-ready-for-customization" and the client code
	 * throw PendingException if needed to skip the following steps and NOT fail the build (when strict = false in cucumber options)
	 * @param featureTags
	 */
	public static void setTags(Collection<String> featureTags) {
		if (AppConfig.isHideCustomerContainer() && featureTags.contains("@customer_level"))
			throw new PendingException("Client " + ClientProvider.getCode() + " only has account view. This feature is for customer view. Mission Abort");
		if (featureTags.contains("@not-ready-for-customization")) {
			String clientCode = ClientProvider.getCode();
			if (!(clientCode.equals("PLAQA")
					||clientCode.equals("PLBQA")
					||clientCode.equals("PCIQA"))) {
				throw new PendingException("This feature/scenario is not ready for " + clientCode + " because it has customization");
			}
		}
	    log.info("Tags: " + featureTags);
		tags = featureTags;
	}
	public static String getTagsString() {
		StringBuilder sb = new StringBuilder();
		int i = 1;
		for (String tag: tags) {
			sb.append(tag.replace('@', Character.forDigit(i++, 10))); //convert int to char 1 to '1', 2 to '2', etc..
		}
		return sb.toString();
	}
	
	private static String name = null; 
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		ScenarioInfo.name = name;
	}
	
}

