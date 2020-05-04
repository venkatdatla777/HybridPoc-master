package flextesting.strategistportal.defaultdata;


import flextesting.utilities.DataUtil;

import java.util.Collection;
import java.util.HashMap;

public class ChannelData {
	private static String channelName = null;
	private static String newChannelName;
	private static HashMap<String, String> channelsCreated = new HashMap<String, String>(); 
	public static void setName(String channelType) {
		channelName = channelType + " channel_" + DataUtil.getRandomChars();
		channelsCreated.put(channelType, channelName);
	}
	public static String getName() {
		return channelName;
	}
	public static Collection<String> getNames() {
		return channelsCreated.values();
	}
	public static String getNameByType(String channelType) {
		return channelsCreated.get(channelType);
	}
	
//	public static String channel = "Email";//Letter,SMS,Dialer,IVR
	public static String description = "Channel description";//Letter,SMS,Dialer,IVR
	
	
	
	private static HashMap<String, String> permanentChannelsMap = new HashMap<String, String>(); 
	private static String[] permanentChannels = {"Email", "Letter", "SMS"};
	static {
		for (String permanentChannel: permanentChannels)
			permanentChannelsMap.put(permanentChannel, getPermanentName(permanentChannel));
	}
	public static String getPermanentName(String channelType) {
		return channelType + " sample channel_";
	}
	public static Collection<String> getPermanentNames() {
		return permanentChannelsMap.values();
	}
	public static String getPermanentNameByType(String channelType) {
		return permanentChannelsMap.get(channelType);
	}
	public static String getChannelName() {
		return channelName;
	}
	public static void setChannelName(String channelName) {
		ChannelData.channelName = channelName;
	}
	public static String getNewChannelName() {
		return newChannelName;
	}
	public static void setNewChannelName(String newChannelName) {
		ChannelData.newChannelName = newChannelName;
	}
	
	

}
