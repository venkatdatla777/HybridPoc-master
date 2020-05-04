package features;


import features.steps.serenity.AppointmentStep;

public class AppointmentStepDefination {


	AppointmentStep appointmentStep;
	
	
	public void i_click_the_Appointments_icon() throws Throwable {
		appointmentStep.i_click_the_Appointments_icon();
	}

	public void i_click_the_button_in_Advisor_Appointments_window(String btnName) throws Throwable {
		appointmentStep.i_click_the_button_in_Advisor_Appointments_window(btnName);
	}

	public void i_select_a_Customer_Timezone() throws Throwable {
		appointmentStep.i_select_a_Customer_Timezone();
	}

	public void i_select_a_Customer_Appt_Date() throws Throwable {
		appointmentStep.i_select_a_Customer_Appt_Date();
	}

	public void i_select_a_Customer_Appt_Time() throws Throwable {
		appointmentStep.i_select_a_Customer_Appt_Time();
	}
	
	public void i_choose_a_phone_number_for_the_schedule() throws Throwable {
		appointmentStep.i_choose_a_phone_number_for_the_schedule();
	}


	public void i_check_the_Schedule_Appointment_Phone() throws Throwable {
		appointmentStep.i_check_the_Schedule_Appointment_Phone();
	}

	public void i_select_a_country_code_for_the_phone() throws Throwable {
		appointmentStep.i_select_a_country_code_for_the_phone();
	}

	public void i_enter_a_phone_number_after_the_country_code() throws Throwable {
		appointmentStep.i_enter_a_phone_number_after_the_country_code();
	}

	public void i_select_a_Language_for_the_appointment() throws Throwable {
		appointmentStep.i_select_a_Language_for_the_appointment();
	}

	public void i_enter_some_comments_about_the_appointment() throws Throwable {
		appointmentStep.i_enter_some_comments_about_the_appointment();
	}

	public void i_should_see_the_appointment_scheduled() throws Throwable {
		appointmentStep.i_should_see_the_appointment_scheduled();
	}

	public void i_select_the_appointment_just_scheduled() throws Throwable {
		appointmentStep.i_select_the_appointment_just_scheduled();
	}

	public void i_select_another_Customer_Appt_Time() throws Throwable {
		appointmentStep.i_select_another_Customer_Appt_Time();
	}

	public void i_should_see_the_appointment_cancelled() throws Throwable {
		appointmentStep.i_should_see_the_appointment_cancelled();
	}
	
	
}
