package features;


import features.steps.serenity.DTMChannelStep;
import flextesting.strategistportal.defaultdata.ChannelData;
import flextesting.utilities.DataUtil;

public class DTMChannelStepDefination {

	DTMChannelStep dTMChannelStep;

	public void i_click_the_Channels_tab_in_DTM() throws Throwable {
		dTMChannelStep.i_click_the_Channels_tab_in_DTM();
	}

	public void i_click_the_button_under_the_Channels_tab(String btnName) throws Throwable {
		dTMChannelStep.i_click_the_button_under_the_Channels_tab(btnName);
	}

	public void i_choose_Send_using_template(String channelType) throws Throwable {
		dTMChannelStep.i_choose_Send_using_template(channelType);
	}

	public void i_enter_an_Action_Name_for_the_channel() throws Throwable {
		dTMChannelStep.i_enter_an_Action_Name_for_the_channel();
	}

	public void i_select_the_a_template_and_a_vendor() throws Throwable {
		dTMChannelStep.i_select_the_a_template_and_a_vendor();
	}

	public void the_channel_is_saved() throws Throwable {
		dTMChannelStep.the_channel_is_saved();
	}

	public void i_select_the_channel_that_is_just_created() throws Throwable {
		dTMChannelStep.i_select_the_channel_that_is_just_created();
	}

	public void i_enter_a_Description_for_the_channel() throws Throwable {
		dTMChannelStep.i_enter_a_Description_for_the_channel();
	}

	public void i_choose_as_the_Recipient_Type(String arg1) throws Throwable {
		dTMChannelStep.i_choose_as_the_Recipient_Type(arg1);
	}

	public void i_choose_an_EE_Name() throws Throwable {
		dTMChannelStep.i_choose_an_EE_Name();
	}

	public void the_channel_is_deleted() throws Throwable {
		dTMChannelStep.the_channel_is_deleted();
	}

	/**
	 * One sentence step
	 * 
	 * @throws Throwable
	 */
	public void i_have_created_a_channel_in_DTM(String channelType) throws Throwable {
		dTMChannelStep.i_have_created_a_channel_in_DTM(channelType);
	}

	/**
	 * one sentence step
	 * 
	 * @throws Throwable
	 */
	public void i_delete_the_channel_in_DTM() throws Throwable {
		dTMChannelStep.i_delete_the_channel_in_DTM();
	}

	public void i_delete_all_channels_in_DTM() throws Throwable {
		dTMChannelStep.i_delete_all_channels_in_DTM();
	}

	public void i_create_sample_channels_if_not_already_existing() throws Throwable {
		dTMChannelStep.i_create_sample_channels_if_not_already_existing();
	}
	
	public void i_create_a_channel_in_DTM(String channelType) throws Throwable {
		String name = channelType + "_" + DataUtil.getDateFormatTxt();
		ChannelData.setNewChannelName(name);
		dTMChannelStep.i_create_a_channel_in_DTM(channelType, name);
	}

}
