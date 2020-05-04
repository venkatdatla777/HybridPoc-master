package flextesting.pagefactories.associateportal.customerpage;

import com.qa.base.TestBase;
import flextesting.utilities.VerifyWithDB;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.SQLException;

import static flextesting.utilities.Utils.extractNumber;


public class VerifyDataFactory extends TestBase {
	@FindBy(xpath = "//div[@class='customer-box']//div[contains(@class,'mraCustomerAccountList')]//div[contains(@class,'x-grid3-row')]//td[1]//img[contains(@class,'table-ok')]//ancestor::tr//td[3]//div")
	private WebElement data_portfolioName_tab_CustomerAccounts;

	@FindBy(xpath = "//div[@class='customer-box']//div[contains(@class,'mraCustomerAccountList')]//div[contains(@class,'x-grid3-row')]//td[1]//img[contains(@class,'table-ok')]//ancestor::tr//td[6]//div")
	private WebElement data_firstName_tab_CustomerAccounts;

	@FindBy(xpath = "//div[@class='customer-box']//div[contains(@class,'mraCustomerAccountList')]//div[contains(@class,'x-grid3-row')]//td[1]//img[contains(@class,'table-ok')]//ancestor::tr//td[7]//div")
	private WebElement data_lastName_tab_CustomerAccounts;

	@FindBy(xpath = "//div[@id='textGerneralWidgetPanel']//div[@id='detailTabs']/div[2]/div/div[1]//td/div[text()='Balance']//following::div[1]")
	private WebElement data_balance_level_Account_tab_firstResponsible;
	private By locator_data_balance_level_Account_tab_firstResponsible = By.xpath(
			"//div[@id='textGerneralWidgetPanel']//div[@id='detailTabs']/div[2]/div/div[1]//td/div[text()='Balance']//following::div[1]");

	@FindBy(xpath = "//div[@id='textGerneralWidgetPanel']//div[@id='detailTabs']/div[2]/div/div[1]//td/div[text()='Days Past Due']//following::div[1]")
	private WebElement data_daysPastDue_level_Account_tab_firstResponsible;

	@FindBy(xpath = "//div[@id='textGerneralWidgetPanel']//div[@id='detailTabs']/div[2]/div/div[1]//td/div[text()='Current Due']//following::div[1]")
	private WebElement data_currentDue_level_Account_tab_firstResponsible;

	// NOTE the difference in the xpath between the first reponsible tab and the
	// second responsible tab is the index after the 5th div
	@FindBy(xpath = "//div[@id='textGerneralWidgetPanel']//div[@id='detailTabs']/div[2]/div/div[2]//td/div[text()='Current Due']//following::div[1]")
	private WebElement data_currentDue_level_Account_tab_secondResponsible;

	private VerifyWithDB verifyWithDB = null;

	public void verifyDataWithDatabase() throws SQLException, InterruptedException {
		String firstName = data_firstName_tab_CustomerAccounts.getText();
		String lastName = data_lastName_tab_CustomerAccounts.getText();
		String portfolioName = data_portfolioName_tab_CustomerAccounts.getText();

		// get value from UI
		Thread.sleep(2000);
		String balance = extractNumber(data_balance_level_Account_tab_firstResponsible.getText());
		String currentDue = extractNumber(data_currentDue_level_Account_tab_firstResponsible.getText());
		String daysPastDue = data_daysPastDue_level_Account_tab_firstResponsible.getText();
		String[] valueFromUI = { balance, currentDue, daysPastDue };

		// store value from DB in the hashmap of the verifyWithDB instance
		verifyWithDB = new VerifyWithDB();
		String query = "Select count(*),a.balance,a.currentDue,a.delinquencyDays as Dayspastdue "
				+ "from Account a, Responsible r, Portfolio p where a.accountNum=r.accountNum and a.active='Y' "
				+ "and a.portfolioId = p.portfolioId and r.firstName = '" + firstName + "' and r.lastName = '"
				+ lastName + "' " + "and p.description= '" + portfolioName + "'";
		String[] columnNameInDBTable = { "balance", "currentDue", "dayspastdue" };
		verifyWithDB.connectToDatabaseAndRetrieveData(query, columnNameInDBTable);

		// compare the values
		for (int i = 0; i < columnNameInDBTable.length; i++)
			verifyWithDB.verifyData(columnNameInDBTable[i], valueFromUI[i]);

	}

	public void dataVerificationResult() throws Exception {
		String report = verifyWithDB.generateReport();
		// if report is not null, then there is some data inconsistency found
		if (report != null)
			throw new Exception(report);
	}
}
