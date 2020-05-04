package features.steps.serenity;


import flextesting.associateportal.customerpage.NoteStepsPage;

public class NoteStep {
	NoteStepsPage noteStepsPage;


	public void i_double_click_the_note_area() throws Throwable {
		noteStepsPage.i_double_click_the_note_area();
	}


	public void i_enter_a_note() throws Throwable {
		noteStepsPage.i_enter_a_note();
	}


	public void i_click_elsewhere() throws Throwable {
		noteStepsPage.i_click_elsewhere();
	}


	public void the_note_is_saved() throws Throwable {
		noteStepsPage.the_note_is_saved();
	}

}
