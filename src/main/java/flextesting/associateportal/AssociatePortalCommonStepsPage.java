package flextesting.associateportal;


import com.qa.base.TestBase;
import flextesting.AppConfig;
import flextesting.utilities.Utils;

import static flextesting.utilities.Utils.clickByXpath;

public class AssociatePortalCommonStepsPage extends TestBase {
	
	public void i_click_the_tab_at_the_customer_level(String tabName, String level) throws Throwable {
		clickByXpath(getDriver(), "//div[@class='"+level+"-box' or @id='"+level+"View']//span[text()='"+tabName+"']");
	}


	public void i_click_the_button_at_the_customer_level(String btnName, String level) throws Throwable {
		clickByXpath(getDriver(), "//div[@class='"+level+"-box' or @id='"+level+"View']//button[text()='"+btnName+"']");
	}
	

	public void i_click_the_Update_button_in_the_X_propagation_window(String x) throws Throwable {
		//for unknown reason, we need to wait a bit
		Thread.sleep(2500);
		//if not hiding customer container, then propagate
		if (!AppConfig.isHideCustomerContainer())
			Utils.clickByXpath(getDriver(), "(//*[(self::div or self::span) and contains(text(),'The selected "+x+" has been successfully updated')]//following::button[text()='Update'])[1]");
	}
	
	
	public void i_click_the_Next_button_in_FlexStation() throws Throwable {
		Thread.sleep(1000);
		Utils.clickByXpath(getDriver(), "//button[text()='Next']");
	}

	
	public void i_click_the_Submit_button_in_FlexStation() throws Throwable {
		Thread.sleep(1000);
		Utils.clickByXpath(getDriver(), "//button[text()='Submit']");
	}
}
