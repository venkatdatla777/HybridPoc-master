package flextesting.pagefactories.strategistportal.workflowmanager;

import com.qa.base.TestBase;

import static flextesting.utilities.Utils.doubleClickNInTable;
import static flextesting.utilities.Utils.numberOfAllVisibleOnes;
import static org.junit.Assert.assertEquals;

public class AssignRoleAndUserFactory extends TestBase {
	

	public void assignTheFirstAvailableRole() throws InterruptedException {
		Thread.sleep(1500);
		doubleClickNInTable(getDriver(), "//fieldset[1]//div[starts-with(@id,'gridpanel') and string-length(@id)=14][1]//tr[contains(@class,'x-grid-row')]", 1);
		
	}

	public void checkAssignedRole() throws InterruptedException {
		//number of roles of right table should be 1 
		assertEquals(numberOfAllVisibleOnes(getDriver(), "//fieldset[1]//div[starts-with(@id,'gridpanel') and string-length(@id)=14][2]//tr[contains(@class,'x-grid-row')]"), 1);
	}

	public void assignTheFirstAvailableUser() {
		doubleClickNInTable(getDriver(), "//fieldset[2]//div[starts-with(@id,'gridpanel') and string-length(@id)=14][1]//tr[contains(@class,'x-grid-row')]", 1);
	}

	public void checkAssignedUser() throws InterruptedException {
		//number of users roles of right table should be 1 
		assertEquals(numberOfAllVisibleOnes(getDriver(), "//fieldset[2]//div[starts-with(@id,'gridpanel') and string-length(@id)=14][2]//tr[contains(@class,'x-grid-row')]"), 1);
	}
}
