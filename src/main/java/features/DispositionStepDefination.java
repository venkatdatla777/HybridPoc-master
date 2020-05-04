package features;


import features.steps.serenity.DispositionStep;
import features.steps.serenity.QueueViewPageStep;

public class DispositionStepDefination {

	DispositionStep dispositionStep;

	QueueViewPageStep queueViewPageStep;

	public void i_disposition_an_account_using_Noncall_Documentation() throws Throwable {
		dispositionStep.i_disposition_an_account_using_Noncall_Documentation();
	}

	public void i_should_see_the_account_dispositioned() throws Throwable {
		dispositionStep.i_should_see_the_account_dispositioned();
	}
	
	public void i_disposition_the_account_using_Noncall_Documentation() throws Throwable {
		dispositionStep.i_disposition_the_account_using_Noncall_Documentation();
	}

	public void afterScenario() throws Throwable {
		dispositionStep.i_disposition_the_account_using_Noncall_Documentation();
	}

	public void afterScenario2(){
		queueViewPageStep.get_the_accountNumber_and_responsibleId_from_referenceNumber_and_update_the_DB_for_disposition_as_an_extra_step();

	}



}
