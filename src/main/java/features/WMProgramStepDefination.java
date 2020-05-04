package features;


import features.steps.serenity.WMProgramStep;

public class WMProgramStepDefination {

	WMProgramStep wMProgramStep;

	public void i_create_a_new_program_in_Workflow_Manager() throws Throwable {
		wMProgramStep.i_create_a_new_program_in_Workflow_Manager();
	}

	public void the_program_should_be_created_in_Workflow_Manager() throws Throwable {
		wMProgramStep.the_program_should_be_created_in_Workflow_Manager();
	}

	public void i_delete_the_program_in_Workflow_Manager() throws Throwable {
		wMProgramStep.i_delete_the_program_in_Workflow_Manager();
	}

	public void the_program_is_deleted_in_Workflow_Manager() throws Throwable {
		wMProgramStep.the_program_is_deleted_in_Workflow_Manager();
	}

	// =========================NEW===========================
	public void i_select_the_program_just_created() throws Throwable {
		wMProgramStep.i_select_the_program_just_created();
	}

	public void i_click_the_button_in_the_Workflow_Repository_panel(String arg1) throws Throwable {
		wMProgramStep.i_click_the_button_in_the_Workflow_Repository_panel(arg1);
	}

	public void the_program_copy_is_saved() throws Throwable {
		wMProgramStep.the_program_copy_is_saved();
	}

	public void i_delete_the_program_copy_in_Workflow_Manager() throws Throwable {
		wMProgramStep.i_delete_the_program_copy_in_Workflow_Manager();
	}

	public void the_program_copy_is_deleted_in_Workflow_Manager() throws Throwable {
		wMProgramStep.the_program_copy_is_deleted_in_Workflow_Manager();
	}
}