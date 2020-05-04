package features;


import features.steps.serenity.UserAndRoleManagerStep;

import java.util.List;
import java.util.Map;

//import org.apache.commons.lang3.StringUtils;

public class UserAndRoleManagerStepDefination {

	List<Map<String,String>> listdata ;

	UserAndRoleManagerStep userAndRoleManagerStep;

	public void i_add_a_new_user() throws Throwable {
		userAndRoleManagerStep.i_add_a_new_user();
	}

	public void the_new_user_should_be_added() throws Throwable {
		userAndRoleManagerStep.the_new_user_should_be_added();
	}
	
	public void i_update_the_user() throws Throwable {
		userAndRoleManagerStep.i_update_the_user();
	}

	public void i_lock_the_user() throws Throwable {
		userAndRoleManagerStep.i_lock_the_user();
	}

	public void the_user_should_be_locked() throws Throwable {
		userAndRoleManagerStep.the_user_should_be_locked();
	}

	public void i_disable_the_user() throws Throwable {
		userAndRoleManagerStep.i_disable_the_user();
	}

	public void the_user_should_be_disabled() throws Throwable {
		userAndRoleManagerStep.the_user_should_be_disabled();
	}	
	
	public void i_select_the_user() throws Throwable {
		userAndRoleManagerStep.i_select_the_user();
	}

	public void i_click_the_Change_Password_button() throws Throwable {
		userAndRoleManagerStep.i_click_the_Change_Password_button();
	}

	public void i_enter_a_New_Password() throws Throwable {
		userAndRoleManagerStep.i_enter_a_New_Password();
	}

	public void i_enter_a_Confirm_Password() throws Throwable {
		userAndRoleManagerStep.i_enter_a_Confirm_Password();
	}

	public void i_should_see_the_confirmation(String arg1) throws Throwable {
		userAndRoleManagerStep.i_should_see_the_confirmation(arg1);
	}
	
	/*public void i_create_the_following_autotester_accounts(DataTable data) throws Throwable {
	    listdata = new ArrayList<Map<String,String>>();
		listdata = data.asMaps(String.class,String.class);
		userAndRoleManagerStep.i_create_the_following_autotester_accounts(listdata);
	}*/

    /*public void i_Update_the_changePassword_to_N_in_Database() {
       String query = "update User set changePassword = 'N' where username in (";
       for (int i = 0;i<listdata.size();i++){
           query = query +"'"+ listdata.get(i).get("Login Name") + "',";
       }
        query = StringUtils.removeEnd(query,",").concat(");");
       //query = query + ")";
       int count = UpdateAndRetrieveDataFromDBForLogin.updateTheChangePasswordToN(query);
       Assert.assertEquals("All the records are not updated",listdata.size(),count);
    }*/

   /* public static void main(String[] args){
	    List<Map<String,String>> list = new ArrayList<>();
        HashMap<String,String> map = new HashMap<>();
        HashMap<String,String> map1 = new HashMap<>();
        HashMap<String,String> map2= new HashMap<>();
        HashMap<String,String> map3 = new HashMap<>();
        map.put("Login Name","Kalyan");
        map1.put("Login Name","Kalyan1");
        map2.put("Login Name","Kalyan2");
        map3.put("Login Name","Kalyan3");
	    list.add(0, map);
        list.add(1, map1);
        list.add(2, map2);
        list.add(3, map3);
        String query = "update User set changePassword = 'N' where username in (";
        for (int i = 0;i<list.size();i++){
            query = query + "'"+list.get(i).get("Login Name") + "',";
        }
        query = StringUtils.removeEnd(query,",").concat(");");
        System.out.println(query);
        //query = query + ")";
        int count = UpdateAndRetrieveDataFromDBForLogin.updateTheChangePasswordToN(query);
        Assert.assertEquals("All the records are not updated",list.size(),count);
    }
*/


	public void i_login_with_each_account_to_change_the_password() throws Throwable {
		userAndRoleManagerStep.i_login_with_each_account_to_change_the_password();
	}

}
