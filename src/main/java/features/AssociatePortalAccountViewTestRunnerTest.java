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
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/AccountView/CustomerAndAccountsPage/note.feature",
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/AccountView/QueueViewPage/add_edit_delete_sorter.feature",
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/AccountView/CustomerAndAccountsPage/ContactInformation/email_level_account.feature",
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/AccountView/CustomerAndAccountsPage/ContactInformation/address_level_account.feature",
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/AccountView/CustomerAndAccountsPage/ContactInformation/phone_level_account.feature",
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/AccountView/QueueViewPage/apply_sorter.feature",
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/AccountView/QueueViewPage/load_account_by_get_next.feature",
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/AccountView/CustomerAndAccountsPage/payment_level_account.feature",
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/AccountView/CustomerAndAccountsPage/funding_account_bank.feature",
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/AccountView/CustomerAndAccountsPage/funding_account_card.feature",
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/AccountView/CustomerAndAccountsPage/program_offer.feature",
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/AccountView/CustomerAndAccountsPage/promise_to_pay.feature",
//		"src/test/resources/net/serenitybdd/cucumber/features/AssociatePortal/AccountView/CustomerAndAccountsPage/appointment.feature" })
//public class AssociatePortalAccountViewTestRunnerTest {
//
//	//QueryToChangeView queryToChangeView = new QueryToChangeView();
//
//	@BeforeClass
//	public static void updateAccountView() {
//		QueryToChangeView.getTheViewConfig();
//		QueryToChangeView.queryToAccountView();
//	}
//
//	@AfterClass
//	public static void updateOverAllView() {
//		if(TestDataSetup.hideCustomerContainer.equalsIgnoreCase("false") &&
//				TestDataSetup.overallViewWithoutIFrame.equalsIgnoreCase("true")){
//			QueryToChangeView.queryToOverAllView();
//		}
//	}
//
//}