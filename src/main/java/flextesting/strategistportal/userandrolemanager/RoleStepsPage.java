package flextesting.strategistportal.userandrolemanager;


import com.qa.base.TestBase;
import flextesting.pagefactories.CommonElementsFactory;
import flextesting.pagefactories.strategistportal.userandrolemanager.RoleFactory;
import flextesting.strategistportal.defaultdata.RoleData;
import flextesting.utilities.DataUtil;
import flextesting.utilities.Utils;
import org.junit.Assert;

import java.util.Arrays;

import static flextesting.utilities.Utils.*;


public class RoleStepsPage extends TestBase {
	private RoleFactory roleFactory;
	private CommonElementsFactory commonElementsFactory;
	private String ExternalEntityName = "ExternalEntity_" + DataUtil.getRandomChars();
	private String EntityBillingGroupName = "EntityBillingGroup_" + DataUtil.getRandomChars();
	
	public boolean isRoleCreated() {
		return roleFactory.isRoleCreated();
	}

	
	public void i_click_Manage_Roles_tab() throws Throwable {
		roleFactory.click_tab_ManageRoles();
	}

	
	public void i_click_Add_Role_and_choose_Add_Permission_Role() throws Throwable {
		roleFactory.click_AddRole();
		roleFactory.choose_AddPermissionRole();
	}

	
	public void i_enter_a_role_name() throws Throwable {
		roleFactory.enter_RoleName(RoleData.getName());
		roleFactory.enter_RoleDescription(RoleData.description);
	}

	
	public void i_assign_contexts_to_the_role() throws Throwable {
		roleFactory.assignFirstAvailableContext();
	}

	
	public void i_assign_features_to_the_role() throws Throwable {
		roleFactory.assignFirstAvailableFeature();
	}

	
	public void i_assign_portfolios_to_the_role() throws Throwable {
		roleFactory.assignFirstAvailablePortfolio();
	}

	
	public void i_save_the_role() throws Throwable {
		roleFactory.click_Save();
	}

	public void the_role_is_saved() throws Throwable {
		roleFactory.click_OK_AddNewRoleSuccessfully();
		roleFactory.search_RoleByName(RoleData.getName());
		roleFactory.present_RoleByName(RoleData.getName());
	}
	
	public void the_role_is_updated() throws Throwable {
		roleFactory.click_OK_UpdateRoleSuccessfully();
		roleFactory.search_RoleByName(RoleData.getName());
		roleFactory.present_RoleByName(RoleData.getName());
	}

	public void i_select_the_role() throws Throwable {
		roleFactory.search_RoleByName(RoleData.getName());
		roleFactory.select_RoleByName(RoleData.getName());
	}
	
	public void i_click_Edit_Role() throws Throwable {
		roleFactory.click_EditRole();
	}

	public void i_enter_a_new_description_for_the_role() throws Throwable {
		roleFactory.enter_RoleDescription(RoleData.description2);
	}

	public void i_click_Remove_Role() throws Throwable {
		roleFactory.click_RemoveRole();
		roleFactory.click_Yes_confirm_RemoveRole();
//		commonElementsFactory.confirm_Yes();
	}

	public void the_role_is_removed() throws Throwable {
		roleFactory.search_RoleByName(RoleData.getName());
		roleFactory.notPresent_RoleByName(RoleData.getName());
	}
	
	//for user.feature
	public void i_create_a_role() throws Throwable {
		i_click_Manage_Roles_tab();
		i_click_Add_Role_and_choose_Add_Permission_Role();
		i_enter_a_role_name();
		i_save_the_role();
	}

	public void i_delete_the_role() throws Throwable {
		if(isRoleCreated()) {
			i_click_Manage_Roles_tab();
			i_select_the_role();
			i_click_Remove_Role();
		}
	}
	//end of for user.feature
	
	//organizational  role
	public void i_search_the_organizational_role_created_last_time() throws Throwable {
		commonElementsFactory.search("org-role-test-lvl-One");
	}

	public void i_delete_it_if_found() throws Throwable {
		doesOrgRoleExistInSearchResult(true);
	}
	
	private boolean doesOrgRoleExistInSearchResult(boolean delete) throws InterruptedException {
		String xpathOfSearchResultRows = "//div[@id='roleGrid-body']//div[contains(@class,'x-grid-cell-inner') and text()='org-role-test-lvl-One']";
		boolean found = isElementDisplayed_clickIfNeeded(2000, getDriver(), xpathOfSearchResultRows, false, false);
		if (found) {
			//if found, we click it, and remove it if delete=true
			isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfSearchResultRows, true, true);
			if (delete) {
				roleFactory.click_RemoveRole();
				roleFactory.click_Yes_confirm_RemoveRole();
			}
			return true;
		}
		return false;
	}

	public void i_click_Add_Role_and_choose(String arg1) throws Throwable {
		roleFactory.click_AddRole();
		clickByXpath(getDriver(), "//span[text()='Add Organizational Role']");
	}

	public void i_click_the_edit_button(String orgLevel) throws Throwable {
		clickByXpath(getDriver(), "//div[@data-qtip='"+orgLevel+"']");
	}

	/**
	 * @param orgLevelName must end with "One" or "Two" or "Three" or "Four"
	 * @throws Throwable
	 */
	public void i_add_a_new_if_it_is_not_there(String orgLevelName) throws Throwable {
		String level = orgLevelName.substring(orgLevelName.lastIndexOf('-') + 1);
		String[] validLevels = {"One", "Two", "Three", "Four"};
		Assert.assertTrue(Arrays.asList(validLevels).contains(level));
		String xpathOfOrgLevelName = "//div[starts-with(@id,'orgrolelevelistgrid')]//div[contains(@class,'x-grid-cell-inner') and contains(text(),'"+orgLevelName+"')]";
		//if it does not exist, then we create one
		if (!isElementDisplayed_clickIfNeeded(0, getDriver(), xpathOfOrgLevelName, true, false)){
			clickByXpath(getDriver(), "//span[text()='Add Organization Level "+level+"']");
			commonElementsFactory.enterName(orgLevelName);
//			commonElementsFactory.click_Save();//two save button visible, thus can NOT use this general method. we have to be more specific.
			Utils.waitToBeClickableAndClick(getDriver(), Utils.returnTheVisibleOne(getDriver(), "//div[starts-with(@id,'orgroleleveledit')]//span[text()='Save']//parent::button"), 2);
		}
	}

	public void i_choose_for_Organizational_Level_1234(String optionName, String orgLevel) throws Throwable {
		clickByXpath(getDriver(), "//input[@name='organizationLevel"+orgLevel+"Id']");
		Thread.sleep(1000);
		isElementDisplayed_clickIfNeeded(0, getDriver(), "//li[@role='option']//div[text()='"+optionName+"']", true, true);
	}
	
	public void the_organizational_role_is_saved() throws Throwable {
		i_search_the_organizational_role_created_last_time();//last time = just created
		Assert.assertTrue(doesOrgRoleExistInSearchResult(false));
	}

	public void i_select_the_organizational_role_just_created() throws Throwable {
		i_search_the_organizational_role_created_last_time();
		doesOrgRoleExistInSearchResult(false);
	}

	public void the_organizational_role_is_removed() throws Throwable {
		i_search_the_organizational_role_created_last_time();
		Assert.assertFalse(doesOrgRoleExistInSearchResult(false));
	}
	
	//External Entity role steps
	public void i_click_Add_Role_and_choose_Add_Enternal_Entity_Role() throws Throwable {
		roleFactory.click_AddRole();
		clickByXpath(getDriver(), "//span[text()='Add External Entity']");
	}

	public void i_select_an_Entity_Type() throws Throwable {
		//equal to clicking arrow trigger
		clickByXpath(getDriver(), "//input[@name='typeId']");
		//click the first option
		clickByXpath(getDriver(), "//li[@role='option']");
	}

	public void i_enter_an_Entity_Name() throws Throwable {
		commonElementsFactory.enterName(ExternalEntityName);
	}

	public void i_enter_an_Entity_Display_Name() throws Throwable {
		clearAndEnter(getDriver(), "//input[@name='displayName']", ExternalEntityName);
	}
	
	public void i_select_the_first_option_in_Entity_Invoice_Frequency() throws Throwable {
		//if the field is not disabled
		if (!isElementDisplayed_clickIfNeeded(0, getDriver(), "//input[@name='invoiceFrequencyType' and @disabled='']", true, false)) {
			//act as arrow trigger
			clickByXpath(getDriver(), "//input[@name='invoiceFrequencyType']");
			//click the first visible option
			clickByXpath(getDriver(), "//li[@role='option']");
		}
	}


	public void i_click_under_the_Address_tab_of_the_Entity_contact(String buttonName) throws Throwable {
		clickByXpath(getDriver(), "//div[@id='contactdetailtab']//span[text()='"+buttonName+"']");
	}
	
	public void i_select_the_first_option_in_Address_Type_in_the_Create_Entity_Address_window() throws Throwable {
		commonElementsFactory.arrowTrigger("Type:");
		clickByXpath(getDriver(), "//li[@role='option' and contains(text(),'Address')]");
	}
	
	public void i_click_the_Save_button_in_the_Create_Entity_Address_window() throws Throwable {
		waitToBeClickableAndClick(getDriver(), "//div[starts-with(@id,'agencycontactaddressedit')]//span[text()='Save']//parent::button", 2);
	}

	public void i_click_under_the_Details_tab_of_the_Entity_Billing_Group(String buttonName) throws Throwable {
		clickByXpath(getDriver(), "//div[@id='billinggroupgridtab']//span[text()='"+buttonName+"']");
	}

	public void i_select_a_portfolio_in_the_Create_Entity_Billing_Group_window() throws Throwable {
		clickByXpath(getDriver(), "//label[contains(text(),'Portfolio')]//following::div[contains(@class,'x-form-arrow-trigger')][1]");
		//select a portfolio
		selectAPortfolioFromDropDown(getDriver());
//		clickByXpath(driver, "//div[text()='"+ClientProvider.getClient().getAvailablePortfolio()+"']");
	}
	
	public void i_enter_a_Name_in_the_Create_Entity_Billing_Group_window() throws Throwable {
		clearAndEnter(getDriver(), "//div[starts-with(@id,'billinggroupedit')]//input[@name='name']", EntityBillingGroupName);
	}

	public void i_enter_as_the_Criteria_in_the_Create_Entity_Billing_Group_window(String arg1) throws Throwable {
		clearAndEnter(getDriver(), "//div[starts-with(@id,'billinggroupedit')]//textarea", arg1);
	}

	public void i_select_the_first_option_in_Billing_Group_Category() throws Throwable {
		//arrow trigger
		clickByXpath(getDriver(), "//input[@name='ruleType']");
		//first visible option
		clickByXpath(getDriver(), "//li[@role='option']");
	}
	
	public void i_enter_as_a_Commission_Rate(String arg1) throws Throwable {
		clearAndEnter(getDriver(), "//input[@name='commissionRate']", arg1);
	}

	public void i_enter_as_the_Effective_Date(String date) throws Throwable {
		String xpath = "//input[@name='ruleEffectiveDate']";
		clearAndEnter(getDriver(), xpath, date);
		// sometimes the hint toolkit "This field is required" block the Save btn, so we click the input field again after entering value
		Thread.sleep(1000);
		clickByXpath(getDriver(), xpath);
		Thread.sleep(1000);
	}
	
	public void i_click_the_Save_button_in_the_Create_Entity_Billing_Group_window() throws Throwable {
		//wait 1.5 sec for validating criteria expression with the server
		Thread.sleep(1500);
		waitToBeClickableAndClick(getDriver(), "//div[starts-with(@id,'billinggroupedit')]//span[text()='Save']//parent::button", 2);
	}
	
	public void the_external_entity_is_saved() throws Throwable {
		commonElementsFactory.search(ExternalEntityName);
		Assert.assertTrue(isElementDisplayed_clickIfNeeded(0, getDriver(), "//div[text()='"+ExternalEntityName+"']", true, true));
	}

	public void i_select_the_external_entity() throws Throwable {
		commonElementsFactory.search(ExternalEntityName);
		isElementDisplayed_clickIfNeeded(0, getDriver(), "//div[text()='"+ExternalEntityName+"']", true, true);
	}
	
	public void i_enter_in_Entity_Description(String arg1) throws Throwable {
		commonElementsFactory.enterDescription(arg1);
	}

	public void the_external_entity_is_removed() throws Throwable {
		commonElementsFactory.search(ExternalEntityName);
		Assert.assertFalse(isElementDisplayed_clickIfNeeded(2000, getDriver(), "//div[text()='"+ExternalEntityName+"']", false, false));
	}

}
