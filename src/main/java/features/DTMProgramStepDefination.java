package features;


import features.steps.serenity.DTMProgramStep;
import flextesting.strategistportal.defaultdata.ProgramData;
import flextesting.utilities.DataUtil;

public class DTMProgramStepDefination {

	DTMProgramStep dTMProgramStep;


	public void i_create_a_new_program() throws Throwable {
		dTMProgramStep.i_create_a_new_program();
	}

	public void the_program_should_be_created() throws Throwable {
		dTMProgramStep.the_program_should_be_created();
	}

	public void i_delete_the_program() throws Throwable {
		dTMProgramStep.i_delete_the_program();
	}

	public void the_program_is_deleted() throws Throwable {
		dTMProgramStep.the_program_is_deleted();
	}

	public void i_create_a_sample_program_if_not_already_existing() throws Throwable {
		dTMProgramStep.i_create_a_sample_program_if_not_already_existing();
	}

	public void i_create_a_program_as_in_DTM(String arg1) throws Throwable {
		String programName = arg1 + "_" + DataUtil.getDateFormatTxt();
		ProgramData.setProgramName(programName);
		dTMProgramStep.i_create_a_program_as_in_DTM(programName);
	}

}
