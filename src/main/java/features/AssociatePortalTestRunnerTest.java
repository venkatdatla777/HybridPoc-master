package features;//package features;
//
//import com.cmc.flextesting.utilities.QueryToChangeView;
//import com.cmc.flextesting.utilities.TestDataSetup;
//import cucumber.api.CucumberOptions;
//import net.serenitybdd.cucumber.CucumberWithSerenity;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.runner.RunWith;
//
//@RunWith(CucumberWithSerenity.class)
//@CucumberOptions(features = {
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/CustomerAndAccountsPage/note.feature",
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/QueueViewPage/add_edit_delete_sorter.feature",
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/CustomerAndAccountsPage/ContactInformation/email_level_account.feature",
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/CustomerAndAccountsPage/ContactInformation/email_level_customer.feature",
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/CustomerAndAccountsPage/ContactInformation/address_level_account.feature",
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/CustomerAndAccountsPage/ContactInformation/address_level_customer.feature",
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/CustomerAndAccountsPage/ContactInformation/phone_level_account.feature",
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/CustomerAndAccountsPage/ContactInformation/phone_level_customer.feature",
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/QueueViewPage/apply_sorter.feature",
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/QueueViewPage/load_account_by_get_next.feature",
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/CustomerAndAccountsPage/payment_level_account.feature",
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/CustomerAndAccountsPage/payment_level_customer.feature",
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/CustomerAndAccountsPage/funding_account_bank.feature",
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/CustomerAndAccountsPage/funding_account_card.feature",
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/CustomerAndAccountsPage/program_offer.feature",
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/CustomerAndAccountsPage/promise_to_pay.feature",
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/CustomerAndAccountsPage/appointment.feature" })
//public class AssociatePortalTestRunnerTest {
//
//	@BeforeClass
//	public static void updateOverAllView() {
//		QueryToChangeView.getTheViewConfig();
//		QueryToChangeView.queryToOverAllView();
//	}
//
//	@AfterClass
//	public static void updateToAccountView() {
//		if(TestDataSetup.hideCustomerContainer.equalsIgnoreCase("true") &&
//				TestDataSetup.overallViewWithoutIFrame.equalsIgnoreCase("false")){
//			QueryToChangeView.queryToAccountView();
//		}
//	}
//
//}
