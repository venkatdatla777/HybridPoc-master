package flextesting.associateportal;

import com.google.common.collect.Ordering;
import com.qa.base.TestBase;
import flextesting.utilities.DataUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static flextesting.utilities.Utils.*;
import static org.junit.Assert.*;

public class QueueSorterStepsPage extends TestBase {
	static Logger log = Logger.getLogger(QueueSorterStepsPage.class);
	private String sorterName = "Sorter_" + DataUtil.getRandomChars();
	private List<String> allSortOptions = new ArrayList<String>();
	private String chosenSortOption = null; 
	private	int indexOfChosenColumn = 0;
	private String xpathOfPortfolioIdOfTheSeletedQueue = "//div[starts-with(@id,'queuetreepanel')]//div[contains(text(),'Portfolio Id')]";
	private String nameOfThePortfolioOfTheSeletedQueue;
	private String idOfThePortfolioOfTheSeletedQueue;
	private List<String> columnBeforeSorting = new ArrayList<String>();
	private List<String> columnAfterSorting = new ArrayList<String>();
	private List<String> columnAfterReset = new ArrayList<String>();
	
	public void i_grap_the_portfolio_info_of_the_queue_selected() throws Throwable {
		String portfolioInfo = getDriver().findElement(By.xpath(xpathOfPortfolioIdOfTheSeletedQueue)).getText();
		log.info("Portfolio Info of the selected queue: " + portfolioInfo);
		String[] infoSplitted = portfolioInfo.split(" \\(Portfolio Id: ");
		log.info("Portfolio info splitted: " + Arrays.toString(infoSplitted));
		nameOfThePortfolioOfTheSeletedQueue = infoSplitted[0];
		idOfThePortfolioOfTheSeletedQueue = infoSplitted[1].replaceFirst("\\)$", "");
		log.info("portfolio name=>" + nameOfThePortfolioOfTheSeletedQueue);
		log.info("portfolio id=>" + idOfThePortfolioOfTheSeletedQueue + " (stripped the last char from "+infoSplitted[1]+"if it's )");
	}

	public void i_click_the_Manager_Sorter_icon() throws Throwable {
		clickByXpath(getDriver(), "(//label[text()='Sorter']//following::button[@class='x-btn-center'])[1]");
	}

	public void i_click_the_button_in_Manage_Sorter_window(String btnName) throws Throwable {
		clickByXpath(getDriver(), "//button//span[text()='" + btnName + "']");
	}
	
	public void i_select_the_portfolio_of_the_selected_queue_in_Add_Sorter_window() throws Throwable {
		//trigger drop down
		clickByXpath(getDriver(), "//input[contains(@id,'portfolioId')]");
		//select one
		String xpathOfThePortfolioOfSeletedQueue = "//*[(self::li or self::div) and "
				+ "(contains(@class,'x-boundlist-item') or @role='option' or contains(@class,'x-combo-list-item')) and "
				+ "contains(text(),'"+idOfThePortfolioOfTheSeletedQueue+"') "
				+ "and contains(text(),'"+nameOfThePortfolioOfTheSeletedQueue+"')]";
		clickByXpath(getDriver(), xpathOfThePortfolioOfSeletedQueue);
	}
	
	public void i_select_a_portfolio_in_Add_Sorter_window() throws Throwable {
		//trigger drop down
		clickByXpath(getDriver(), "//input[contains(@id,'portfolioId')]");
		//select one
		selectAPortfolioFromDropDown(getDriver());
	}

	public void i_enter_a_Sorter_Name() throws Throwable {
		clearAndEnter(getDriver(), "//input[contains(@name,'sorterName')]", sorterName);
	}

	public void i_choose_the_sort_option_for_sort_variable(int indexOfSortDropDown, int theNthSortVar)
			throws Throwable {
		// trigger drop down
		// there are 3 matches of
		// //div[contains(@id,'sorterform')]//input[@readonly='readonly']
		// 1: portfolio | 2: sort option of sort var 1 | 3: sort order of sort var 2
		// two matches added for every sort sort var added (by clicking the [+Add] button, so
		// 4: sort option of sort var 2 | 5: sort order of sort var 2
		// in general: to use //div[contains(@id,'sorterform')]//input[@readonly='readonly'] to trigger drop down menus
		// for sort options (like balance, reference #, etc...), the index is n*2, n means the nth sort variable
		// for sort orders (ascend or descend), the index is n*2 + 1
		clickByXpath(getDriver(),
				"(//div[contains(@id,'sorterform')]//input[@readonly='readonly'])[" + (theNthSortVar * 2) + "]");
		clickByXpath(getDriver(), "(//div[contains(@id,'boundlist')]//table//tr//td[1])[" + indexOfSortDropDown + "]");
	}

	public void i_choose_as_the_sort_order_for_sort_variable(String order, int theNthSortVar) throws Throwable {
		// trigger drop down
		clickByXpath(getDriver(),
				"(//div[contains(@id,'sorterform')]//input[@readonly='readonly'])[" + (theNthSortVar * 2 + 1) + "]");
		clickByXpath(getDriver(), "//li[@role='option' and text()='" + order + "']");
	}

	public void the_sorter_is_saved() throws Throwable {
		assertTrue(isElementDisplayed_clickIfNeeded(0, getDriver(), "//td//div[text()='" + sorterName + "']", true, false));
	}

	public void i_select_the_sorter_just_created() throws Throwable {
		isElementDisplayed_clickIfNeeded(0, getDriver(), "//td//div[text()='" + sorterName + "']", true, true);
	}

	public void i_click_the_Add_button_in_Update_Sorter_window() throws Throwable {
		clickByXpath(getDriver(), "//div[contains(@id,'sorterform')]//button//span[text()='Add']");
	}

	public void the_sorter_is_deleted() throws Throwable {
		assertFalse(
				isElementDisplayed_clickIfNeeded(2000, getDriver(), "//td//div[text()='" + sorterName + "']", false, false));
	}

	public void i_close_the_Manage_Sorter_window() throws Throwable {
		clickByXpath(getDriver(), "//img[@class='x-tool-close']");
	}

	public void i_get_all_avaliable_sorter_options() throws Throwable {
		clickByXpath(getDriver(), "(//div[contains(@id,'sorterform')]//input[@readonly='readonly'])[2]");
		List<WebElement> allSortOptions = getDriver().findElements(By.xpath("(//div[contains(@id,'boundlist')]//table//tr//td[1])"));
		//might want to exclude any "date" data because of later the order is checked in String order, 
		//	which works fine if the data type is String, Integer, Currency, etc...
		for (WebElement we: allSortOptions)
			this.allSortOptions.add(we.getText());
		log.info("All avaliable sort options: "+Arrays.toString(this.allSortOptions.toArray()));
	}
	
	public void i_get_back_to_the_Queue_View_by_escaping_all_sorter_windows() throws Throwable {
		//press escape multiple times (2 times of successful triggering is enough) to get back
		for (int i=0;i<4;i++) {
			pressEscapeKey(getDriver());
			Thread.sleep(1000);
		}
	}

	public void i_can_find_a_column_name_matches_a_sort_options() throws Throwable {

		List<WebElement> columnNamesWE = getDriver().findElements(By.xpath("//div[@id='showQueueViewAccountsGrid']//div[contains(@id,'headercontainer')]//div//span"));
		List<String> columnNames = new ArrayList<String>();
		for(WebElement we: columnNamesWE)
			columnNames.add(we.getText().replaceAll("#", "number").toLowerCase());
		indexOfChosenColumn = 0;
		columnNameLoop:
		for (int i = 0;i<columnNames.size();i++) {
			for (int j =0; j<allSortOptions.size();j++) {
				if (columnNames.get(i).equals(splitCamelCase(allSortOptions.get(j)).toLowerCase())) {
					indexOfChosenColumn = i;
					chosenSortOption = allSortOptions.get(j);
					log.info("column name [" +columnNames.get(i)+ "] matches a sort option: " + chosenSortOption);
					break columnNameLoop;
				}
			}
		}
		log.info(indexOfChosenColumn + " is the index of the chosen column");	
		log.info(chosenSortOption + " is the chosen sort option");
		assertNotNull(chosenSortOption);

	}

	public void i_get_the_data_for_the_column_before_sorter_applied() throws Throwable {
		columnBeforeSorting = getDataOfAColumn(indexOfChosenColumn);
		log.info("Column "+indexOfChosenColumn+" before sorting: " + Arrays.toString(columnBeforeSorting.toArray()));
	}
	
	private List<String> getDataOfAColumn(int columnIndex) {
		List<String> dataOfAColumn = new ArrayList<String>();
		List<WebElement> rows = getDriver()
				.findElements(By.xpath("//div[@id='showQueueViewAccountsGrid-body']//div//table//tr"));
		log.info("table size: " + rows.size() + " rows");
		List<WebElement> columnsOfARow = null;
		//index = 0 is the header row, no real data thus skipped
		for (int i = 1; i<rows.size(); i++) {
			// note the . Only with it can you find the child elements of an element
			columnsOfARow = rows.get(i).findElements(By.xpath(".//td//div"));
			dataOfAColumn.add(columnsOfARow.get(columnIndex).getText()); //note: when the cell has no data, then getText gives you a space
		}
		return dataOfAColumn;
	}

	
	public void i_choose_the_specific_sort_option_for_sort_variable(int theNthSortVar) throws Throwable {
		clickByXpath(getDriver(),
				"(//div[contains(@id,'sorterform')]//input[@readonly='readonly'])[" + (theNthSortVar * 2) + "]");
		clickByXpath(getDriver(), "//div[contains(@id,'boundlist')]//table//tr//td[1][text()='"+chosenSortOption+"']");
	}


	public void i_choose_the_sorter_for_the_queue() throws Throwable {
		clickByXpath(getDriver(), "//input[@placeholder='No Sorter']");
		clickByXpath(getDriver(), "//*[contains(@class,'x-boundlist-item') and text()='"+sorterName+"']");
	}


	public void i_click_Apply_Filter_Sorter() throws Throwable {
//		Thread.sleep(1000);
		clickByXpath(getDriver(), "//span[text()='Apply Filter/Sorter']");
	}


	public void i_get_the_data_for_the_column_after_sorter_applied() throws Throwable {
		//we don't know how much time needed to sort
		Thread.sleep(10000);
		columnAfterSorting = getDataOfAColumn(indexOfChosenColumn);
		log.info("Column "+indexOfChosenColumn+" after sorting: " + Arrays.toString(columnAfterSorting.toArray()));
	}


	public void i_find_that_the_column_is_sorted_according_to_the_sorter() throws Throwable {
		assertTrue(Ordering.natural().isOrdered(columnAfterSorting));
	}


	public void i_click_the_Reset_button_to_reset_the_order_of_the_queue() throws Throwable {
		clickByXpath(getDriver(), "//span[text()='Reset']");
	}
	

	public void i_get_the_data_for_the_column_after_reset() throws Throwable {
		Thread.sleep(10000);
		columnAfterReset = getDataOfAColumn(indexOfChosenColumn);
		log.info("Column "+indexOfChosenColumn+" after reset: " + Arrays.toString(columnAfterReset.toArray()));
	}

	
	public void i_find_that_the_column_is_in_the_original_order() throws Throwable {
		assertTrue(columnAfterReset.equals(columnBeforeSorting));
	}

}
