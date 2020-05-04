package features;


import features.steps.serenity.NoteStep;

public class NoteStepDefination {

	NoteStep noteStep;

	public void i_double_click_the_note_area() throws Throwable {
		noteStep.i_double_click_the_note_area();
	}

	public void i_enter_a_note() throws Throwable {
		noteStep.i_enter_a_note();
	}

	public void i_click_elsewhere() throws Throwable {
		noteStep.i_click_elsewhere();
	}

	public void the_note_is_saved() throws Throwable {
		noteStep.the_note_is_saved();
	}

}
