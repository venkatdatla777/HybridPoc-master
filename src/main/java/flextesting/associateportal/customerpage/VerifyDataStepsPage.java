package flextesting.associateportal.customerpage;

import com.qa.base.TestBase;
import flextesting.pagefactories.associateportalAccountView.customerpage.VerifyDataFactoryAccountView;

public class VerifyDataStepsPage  extends TestBase {

	private VerifyDataFactoryAccountView verifyDataFactoryAccountView;
	

	public void i_verify_the_data_with_the_database() throws Throwable {
		verifyDataFactoryAccountView.verifyDataWithDatabase();
	}

	public void the_data_should_be_consistant_with_the_database() throws Throwable {
		verifyDataFactoryAccountView.dataVerificationResult();
	}
}
