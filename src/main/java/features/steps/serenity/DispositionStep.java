package features.steps.serenity;


import flextesting.associateportal.customerpage.DispositionStepsPage;

public class DispositionStep {

	DispositionStepsPage dispositionStepsPage;


	public void i_disposition_an_account_using_Noncall_Documentation() throws Throwable {
		dispositionStepsPage.i_disposition_an_account_using_Noncall_Documentation();
	}


	public void i_should_see_the_account_dispositioned() throws Throwable {
		dispositionStepsPage.i_should_see_the_account_dispositioned();
	}
	

	public void i_disposition_the_account_using_Noncall_Documentation() throws Throwable {
		dispositionStepsPage.tearDownAssociatePortal();
	}
}
