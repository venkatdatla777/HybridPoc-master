package features.steps.serenity;


import flextesting.strategistportal.decisiontreemanager.DTMProgramStepsPage;

public class DTMProgramStep {
	DTMProgramStepsPage dTMProgramStepsPage;


	public void i_create_a_new_program() throws Throwable {
		dTMProgramStepsPage.i_create_a_new_program();
	}


	public void the_program_should_be_created() throws Throwable {
		dTMProgramStepsPage.the_program_should_be_created();
	}


	public void i_delete_the_program() throws Throwable {
		dTMProgramStepsPage.i_delete_the_program();
	}


	public void the_program_is_deleted() throws Throwable {
		dTMProgramStepsPage.the_program_is_deleted();
	}


	public void i_create_a_sample_program_if_not_already_existing() throws Throwable {
		dTMProgramStepsPage.i_create_a_sample_program_if_not_already_existing();
	}
	

	public void i_create_a_program_as_in_DTM(String programName) throws Throwable {
		dTMProgramStepsPage.i_create_a_program_as_in_DTM(programName);
	}

}
