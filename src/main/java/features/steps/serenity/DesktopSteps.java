package features.steps.serenity;


import flextesting.strategistportal.DesktopPage;

public class  DesktopSteps extends DesktopPage{


	public void i_open_the_Decision_Tree_Manager() throws Throwable {
		desktopPage.click_DecisionTreeManager();
	}

	public void i_open_User_Role_Manager() throws Throwable {
		desktopPage.click_UserAndRoleManager();
	}

	public void i_have_opened_the_Workflow_manager() throws Throwable {
		desktopPage.click_WorkflowManager();
	}

	public void i_have_opened_the_Document_manager() throws Throwable {
		desktopPage.click_DocumentManager();
	}

	public void i_have_opened_the_Variable_Manager() throws Throwable {
		desktopPage.click_VariableManager();
	}

	public void i_have_opened_the_Test_Manager() throws Throwable {
		desktopPage.click_TestManager();
	}

	public void i_have_opened_the_Configuration_Manager() throws Throwable {
		desktopPage.click_ConfigurationManager();
	}
}
