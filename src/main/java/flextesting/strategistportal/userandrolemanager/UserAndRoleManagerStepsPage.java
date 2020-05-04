package flextesting.strategistportal.userandrolemanager;


import com.qa.base.TestBase;
import flextesting.client.UserList;
import flextesting.client.UserMaster;
import flextesting.pagefactories.CommonElementsFactory;
import flextesting.pagefactories.strategistportal.userandrolemanager.UserAndRoleManagerFactory;
import flextesting.strategistportal.defaultdata.RoleData;
import flextesting.strategistportal.defaultdata.UserData;
import flextesting.strategistportal.login.LoginPage;
import flextesting.utilities.*;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * @author Shiyi Chen
 */
public class UserAndRoleManagerStepsPage extends TestBase {
	static Logger log = Logger.getLogger(UserAndRoleManagerStepsPage.class);
	private UserAndRoleManagerFactory urm;
	private CommonElementsFactory commonElementsFactory;
	private LoginPage loginPage;
	private RetrieveDataFromDB retrieveDataFromDB;
	private UserList userList;
	// private List<Map<String,String>> pendingPasswordChangeList;
	// private StringBuilder autoCreatedUsers = new StringBuilder();

	public void i_add_a_new_user() throws Throwable {
		urm.click_tab_ManageUsers();
		urm.click_AddUser();
		urm.window_AddUser();
		urm.enter_LoginName(UserData.getLoginName());
		urm.enter_FirstName(UserData.getFirstName());
		urm.enter_LastName(UserData.getLastName());
		urm.enter_Password(UserData.password);
		urm.enter_ConfirmPassword(UserData.password);
		urm.enter_Email(UserData.getEmail());
		// urm.choose_DefaultStationView_UnifiedCollections();
		urm.move_leftToRight_FirstAvailableRoles();
		// urm.check_AssignedRoles_FirstOne();
		urm.save_AddUser();
		urm.message_NewUserAdded_OK();
	}

	public void the_new_user_should_be_added() throws Throwable {
		urm.search_User(UserData.getLoginName());
		urm.present_User(UserData.getLoginName());
	}

	public void i_update_the_user() throws Throwable {
		urm.search_User(UserData.getLoginName());
		urm.select_User(UserData.getLoginName());
		urm.click_EditUser();
		urm.enter_Email("randomtester@cmc.cmc");
		// urm.search_AssignedRoles(UserData.role);
		// remove the old role
		urm.move_rightToLeft_FirstAssignedRoles();
		// assign a new role
		urm.search_AvailableRoles(RoleData.getName());
		urm.move_leftToRight(RoleData.getName());
		// set a default role
		urm.check_AssignedRoles(RoleData.getName());
		urm.save_AddUser();
		urm.message_EditUserSuccessfully_OK();
	}

	public void i_lock_the_user() throws Throwable {
		urm.search_User(UserData.getLoginName());
		urm.select_User(UserData.getLoginName());
		urm.click_LockUser();
		urm.confirmation_LockUser("Yes");
	}

	public void the_user_should_be_locked() throws Throwable {
		urm.present_UserGrayedOut(UserData.getLoginName());
	}

	public void i_disable_the_user() throws Throwable {
		urm.search_User(UserData.getLoginName());
		urm.select_User(UserData.getLoginName());
		urm.click_DisableUser();
		urm.confirmation_DisableUser("Yes");
		urm.message_DisableUserSuccessfully_OK();
	}

	public void the_user_should_be_disabled() throws Throwable {
		urm.present_UserTurnRed(UserData.getLoginName());
	}

	public void i_select_the_user() throws Throwable {
		urm.select_User(UserData.getLoginName());
	}

	public void i_click_the_Change_Password_button() throws Throwable {
		Utils.clickByXpath(getDriver(), "//div[@id='manageUser']//span[text()='Change Password']");
	}

	public void i_enter_a_New_Password() throws Throwable {
		Utils.clearAndEnter(getDriver(), "//input[@name='newPassword']", UserData.password);
	}

	public void i_enter_a_Confirm_Password() throws Throwable {
		Utils.clearAndEnter(getDriver(), "//input[@name='confirmPassword']", UserData.password);
	}

	public void i_should_see_the_confirmation(String arg1) throws Throwable {
		Utils.isElementDisplayed_clickIfNeeded(0, getDriver(), "//div[text()='Password changed.']", true, false);
		commonElementsFactory.message_OK();
	}

	public void i_create_the_following_autotester_accounts(List<Map<String, String>> data) throws Throwable {
		List<Map<String, String>> pendingPasswordChangeList = TestDataSetup.getPendingPasswordChangeList();
		List<String> lockedOrDisabledList = new ArrayList<String>();
		retrieveDataFromDB = new RetrieveDataFromDB();
		log.info(data.size());
		for (int i = 0; i < data.size(); i++) {
			Map<String, String> userInfo = data.get(i);
			String loginName = userInfo.get("Login Name");
			// check DB
			// String query = "select username, changePassword, accountLocked,
			// accountEnabled, passwordStartDate from User "
			String query = "select username, Date(passwordStartDate), accountLocked, accountEnabled from User "
					+ "where username = '" + loginName + "'";
			log.info(query);
			// retrieve data from db
			List<Row> queryResult = retrieveDataFromDB.retrieveData(query);
			// convert it into list of strings separated by |
			List<String> userDataInDB = Row.formatTableToListOfString(queryResult);
			// if the user exits in DB (meaning: size == 1)
			if (userDataInDB.size() == 1) {
				String[] columns = userDataInDB.get(0).split("\\|", -1);
				log.info("DB record of a user(username,passwordStartDate,accountLocked,accountEnabled): "
						+ Arrays.toString(columns));
				// since there is a "|" at the beginning, we ignore index 0 and
				// start from index 1
				// if pendingPasswordchange, added to pwChangePending list
				String queryForPWRotationDays = "select featureValue from ApplicationConfig where featureName='passwordRotationDays'";
				List<Row> queryForPWrotation = retrieveDataFromDB.retrieveData(queryForPWRotationDays);
				List<String> pwRDInDB = Row.formatTableToListOfString(queryForPWrotation);
				if (pwRDInDB.size() == 0)
					throw new RuntimeException("No passwordRotationDays retrived from DB. Mission Abort...");
				int rotationDays = Integer.parseInt(pwRDInDB.get(0).split("\\|", -1)[1]);
				long passwordElapsedDays = Utils.getDaysElapsed(columns[2]);
				log.info("Password Rotation Days from DB is: " + rotationDays + " | Password elapsed: "
						+ passwordElapsedDays + " days");
				if (passwordElapsedDays > rotationDays) {
					// The userInfo is an unmodifiableMap, so we need to create
					// a modifiableMap (E.g. HashMap...)
					Map<String, String> userInfoMap = new HashMap<String, String>();
					userInfoMap.put("Login Name", loginName);
					userInfoMap.put("Password", UserMaster.getInstance().getPassword(loginName));
					pendingPasswordChangeList.add(userInfoMap);
				}
				// if locked (locked = Y) or disable (enable = N), added to
				// lockedOrDiabledListlist
				if (columns[3].equals("Y") || columns[4].equals("N")) {
					lockedOrDisabledList.add(loginName);
				}
			}
			// if the user not exist in DB, add it to userToBeCreated and create
			// it in UserAndRole Manager later
			else {
				createUser(userInfo);
			}
		}
		log.info("Locked or disabled: " + Arrays.toString(lockedOrDisabledList.toArray()));
	}

	private void createUser(Map<String, String> userInfo) throws InterruptedException {
		List<Map<String, String>> pendingPasswordChangeList = TestDataSetup.getPendingPasswordChangeList();
		String loginName = userInfo.get("Login Name");
		urm.click_AddUser();
		urm.window_AddUser();
		urm.enter_LoginName(loginName);
		urm.enter_FirstName(userInfo.get("First Name"));
		urm.enter_LastName(userInfo.get("Last Name"));
		urm.enter_Password(userInfo.get("Password"));
		urm.enter_ConfirmPassword(userInfo.get("Password"));
		urm.enter_Email(userInfo.get("Email"));
		// choose FlexStation Landing View for certain clients
		if (System.getProperty("FlexStationURL").contains("tdcqa")) {
			urm.choose_DefaultStationView_UnifiedCollections();
		}
		String role = userInfo.get("Roles");
//		for (int j = 0; j < roles.length; j++) {
			urm.search_AvailableRoles(role);
			urm.click_btn_move_leftToRight(role);
//			urm.click_btn_MoveAllLeftRowsToRightSide();
//		}
		urm.check_AssignedRoles_FirstOne();
		urm.save_AddUser();
		urm.message_NewUserAdded_OK();
		// createdUsers.add(userInfo);
		log.info("User: " + loginName + " created");
		pendingPasswordChangeList.add(userInfo);
	}

	public void i_login_with_each_account_to_change_the_password() throws Throwable {
		List<Map<String, String>> pendingPasswordChangeList = TestDataSetup.getPendingPasswordChangeList();
		int numOfUsersNeedToChangePassword = pendingPasswordChangeList.size();
		log.info(numOfUsersNeedToChangePassword + " users need to change password");
		log.info("Password changing pending: " + Arrays.toString(pendingPasswordChangeList.toArray()));
		for (int i = 0; i < numOfUsersNeedToChangePassword; i++) {
			Map<String, String> userInfo = pendingPasswordChangeList.get(i);
			String loginName = userInfo.get("Login Name");
			// login
			loginPage.i_am_on_Login_Page();
			loginPage.i_enter_username_as_and_I_enter_password_as_and_I_click_the_Login_button(loginName,
					userInfo.get("Password"));
			// generate new password
			DataUtil.setRandomChars(5);
			DataUtil.setRandomNumber(4);
			String newPassword = "A" + DataUtil.getRandomChars() + DataUtil.getRandomNumber();
			// change password
			Utils.clearAndEnter(getDriver(), "//input[@name='oldPassword']", userInfo.get("Password"));
			Utils.clearAndEnter(getDriver(), "//input[@name='newPassword']", newPassword);
			Utils.clearAndEnter(getDriver(), "//input[@name='confirmPassword']", newPassword);
			Thread.sleep(1000); // for the save button not grayed-out
			Utils.clickByXpath(getDriver(), "//span[text()='Save']");
			Utils.clickByXpath(getDriver(), "//span[text()='OK']");
			// logout
			loginPage.i_logout_the_Strategist_Portal();
			log.info("Password changed for: " + userInfo.get("Login Name"));
			userList.addOrUpdateUser(loginName, newPassword);
			// we need to write the list to file immediately after a password
			// updated
			// because if we don't, when an incident happens while changing the
			// pw for the next user
			// we don't have the chance to write to file any more.
			userList.writeListToFile();
			// autoCreatedUsers.append(loginName + "|" + newPassword + "\n");
		}
		log.info("Final userList:\n" + userList);
		// Utils.writeToFile(ClientProvider.getAutoCreatedUsersFileName(),
		// autoCreatedUsers.toString());
	}

}
