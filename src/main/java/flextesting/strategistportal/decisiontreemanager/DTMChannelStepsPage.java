package flextesting.strategistportal.decisiontreemanager;


import com.qa.base.TestBase;
import flextesting.exceptions.NoVisibleElementFoundException;
import flextesting.pagefactories.CommonElementsFactory;
import flextesting.pagefactories.strategistportal.actions.ChannelFactory;
import flextesting.strategistportal.defaultdata.ChannelData;
import flextesting.utilities.Utils;
import org.apache.log4j.Logger;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DTMChannelStepsPage extends TestBase {
	static Logger log = Logger.getLogger(DTMChannelStepsPage.class);
	//private ChannelFactory channelFactory;
	//private CommonElementsFactory commonElementsFactory;
	private String channelName;
	
	public void i_click_the_Channels_tab_in_DTM() throws Throwable {
		channelFactory.click_tab_Channels();
	}

	public void i_click_the_button_under_the_Channels_tab(String btnName) throws Throwable {
		channelFactory.click_AddEditDelete(btnName);
	}

	public void i_choose_Send_using_template(String channelType) throws Throwable {
		ChannelData.setName(channelType);
		channelName = ChannelData.getName();
		channelFactory.choose_SendXUsingTemplate(channelType);
	}


	public void i_enter_an_Action_Name_for_the_channel() throws Throwable {
		commonElementsFactory.enterName(channelName);
	}

	public void i_select_the_a_template_and_a_vendor() throws Throwable {
		channelFactory.select_thePermanentSampleOrThefirstTemplate();
		channelFactory.select_firstVendor();
	}


	public void the_channel_is_saved() throws Throwable {
		channelFactory.enter_SearchField(channelName);
		commonElementsFactory.click_Search();
		assertTrue(channelFactory.isPresent_channelByName_clickIfYes(channelName, true, false));
	}
	
	public void i_select_the_channel_that_is_just_created() throws Throwable {
		selectChannelByName(channelName);
	}
	private void selectChannelByName(String name) throws InterruptedException {
		channelFactory.enter_SearchField(name);
		commonElementsFactory.click_Search();
		assertTrue(channelFactory.isPresent_channelByName_clickIfYes(name, true, true));
	}

	
	public void i_enter_a_Description_for_the_channel() throws Throwable {
		commonElementsFactory.enterDescription(ChannelData.description);
	}
	
	
	public void i_choose_as_the_Recipient_Type(String arg1) throws Throwable {
		commonElementsFactory.arrowTrigger("Recipient Type:");
		commonElementsFactory.chooseAnOptionByName(arg1);
	}

	
	public void i_choose_an_EE_Name() throws Throwable {
		commonElementsFactory.arrowTrigger("EE Name:");
		//if the client doesn't have an EE Name configured, then we go back and choose Responsible as the type  
		try {
			channelFactory.selectFirstVisibleFromDropDown();
//			commonElementsFactory.chooseAnOptionByName(arg1);
		} catch (NoVisibleElementFoundException ex) {
			log.info("the client doesn't have an EE Name configured, go back and choose Responsible as the type");
//			ex.printStackTrace();
			i_choose_as_the_Recipient_Type("Responsible");
		}
	}

	
	public void the_channel_is_deleted() throws Throwable {
		checkIfChannelIsDeletedByName(channelName);
	}
	private void checkIfChannelIsDeletedByName(String name) throws InterruptedException {
		channelFactory.enter_SearchField(name);
		commonElementsFactory.click_Search();
		assertFalse(channelFactory.isPresent_channelByVisibleText(name));
	}

	/**
	 * One sentence step
	 * @throws Throwable
	 */
	
	public void i_have_created_a_channel_in_DTM(String channelType) throws Throwable {
		channelFactory.click_tab_Channels();
		channelFactory.click_AddEditDelete("Add");
		ChannelData.setName(channelType);
		channelName = ChannelData.getName();
		channelFactory.choose_SendXUsingTemplate(channelType);
		commonElementsFactory.enterName(channelName);
		channelFactory.select_thePermanentSampleOrThefirstTemplate();
		channelFactory.select_firstVendor();
		commonElementsFactory.click_Save();
		the_channel_is_saved();
	}
	
	/**
	 * one sentence step
	 * @throws Throwable
	 */
	
	public void i_delete_the_channel_in_DTM() throws Throwable {
		deleteChannelByName(channelName);
	}	
	private void deleteChannelByName(String name) throws InterruptedException {
		channelFactory.click_tab_Channels();	
		selectChannelByName(name);
		channelFactory.click_AddEditDelete("Delete");
		commonElementsFactory.confirm_Yes();
		checkIfChannelIsDeletedByName(name);
	}
	
	
	public void i_delete_all_channels_in_DTM() throws Throwable {
		for(String name: ChannelData.getNames())
			deleteChannelByName(name);
	}
	
	
	public void i_create_sample_channels_if_not_already_existing() throws Throwable {
		String[] channelTypes = {"Email", "Letter", "SMS"};
		String[] channelNames = new String[channelTypes.length];
		for (int i=0;i<channelTypes.length;i++) {
			channelNames[i] = ChannelData.getPermanentName(channelTypes[i]);
		}
//		for(String channelName: channels) {
		for(int i=0;i<channelNames.length;i++) {
			channelFactory.click_tab_Channels();
			channelFactory.enter_SearchField(channelNames[i]);
			commonElementsFactory.click_Search();
			//continue creating channel sample is not existing
			if (!Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), "//div[contains(@class,'x-grid-cell-inner') and text()='"+channelNames[i]+"']", true, false)) {
				channelFactory.click_AddEditDelete("Add");
				channelFactory.choose_SendXUsingTemplate(channelTypes[i]);
				commonElementsFactory.enterName(channelNames[i]);
				channelFactory.select_thePermanentSampleOrThefirstTemplate();
				channelFactory.select_firstVendor();
				commonElementsFactory.click_Save();
			}	
		}
	}
	
	public void i_create_a_channel_in_DTM(String channelType, String name) throws Throwable {
		channelFactory.click_tab_Channels();
		channelFactory.click_AddEditDelete("Add");
		ChannelData.setName(channelType);
		channelName = ChannelData.getName();
		channelFactory.choose_SendXUsingTemplate(channelType);
		commonElementsFactory.enterName(name);
		channelFactory.select_thePermanentSampleOrThefirstTemplate();
		channelFactory.select_firstVendor();
		commonElementsFactory.click_Save();
		channelFactory.enter_SearchField(name);
		commonElementsFactory.click_Search();
		assertTrue(channelFactory.isPresent_channelByName_clickIfYes(name, true, false));
	}

}
