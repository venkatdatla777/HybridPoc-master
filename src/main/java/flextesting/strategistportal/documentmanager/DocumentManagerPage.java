package flextesting.strategistportal.documentmanager;


import com.qa.base.TestBase;
import flextesting.pagefactories.CommonElementsFactory;
import flextesting.pagefactories.strategistportal.documentmanager.DocumentManagerFactory;
import flextesting.strategistportal.defaultdata.DocumentData;
import flextesting.utilities.Utils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;

import java.util.NoSuchElementException;

public class DocumentManagerPage extends TestBase {
	//static Logger log = LoggerFactory.getLogger(DocumentManagerPage.class.getName());
	//private DocumentManagerFactory documentManagerFactory;
	//private CommonElementsFactory commonElementsFactory;
	private String docType = null;
	public String docName = null;

	public boolean isDocumentCreated() {
		return documentManagerFactory.isDocumentCreated();
	}

	public void i_have_chosen_Responsible_as_Context_in_DM() throws Throwable {
		documentManagerFactory.choose_Context_Responsible();
	}

	public void i_click_the_Add_button_in_DM() throws Throwable {
		documentManagerFactory.click_Add();
	}

	public void i_enter_a_document_name(String docType) throws Throwable {
		//this.docType = docType;
		 docName=DocumentData.getName(docType);
		documentManagerFactory.enter_name(docName);
		LogThisStepInExtentReport("Enter :::"+docName+"::: document name");

	}

	public void i_enter_a_document_body() throws Throwable {
		documentManagerFactory.enter_body(DocumentData.letterBody);
	}

	public void i_click_the_Edit_button_of_Assigned_Portfolio() throws Throwable {
		documentManagerFactory.click_Edit_AssignedPortfolio();
	}

	public void i_assign_some_portfolios_to_the_document() throws Throwable {
//		documentManagerFactory.drag_AvailablePortfoliosToSelectedPortfolios(ClientInfo.getAvailablePortfolio());
//		documentManagerFactory.drag_FirstAvailablePortfoliosToSelectedPortfolios();
		documentManagerFactory.drag_AllAvailablePortfoliosToSelectedPortfolios();
		documentManagerFactory.click_close_AssignPortfolio();
		//click OK if this message shows up
		if (Utils.isElementDisplayed_clickIfNeeded(2000, getDriver(), "//div[contains(text(),'If more than one portfolio is assigned')]", false, false))
			commonElementsFactory.message_OK();
	}
	
	
	public void i_check_Enable_Delivery_via_Letter() throws Throwable {
		documentManagerFactory.check_EnableDeliveryViaLetter();
	}

	public void i_click_the_Save_as_Draft_button_in_the_Add_Document_window() throws Throwable {
		documentManagerFactory.click_SaveAsDraft();
		documentManagerFactory.message_DocumentSaved_OK();
	}

	public void the_document_is_saved() throws Throwable {
		//TODO
	}


	public void i_click_the_Publish_This_Version_button_in_the_Add_Document_window() throws Throwable {
		documentManagerFactory.click_PublishThisVersion();
		documentManagerFactory.message_DocumentPublished_OK();
	}

	public void the_document_is_published() throws Throwable {
		i_search_the_document_in_DM();
		the_document_is_in_the_search_result();
	}
	

	public void i_search_the_document_in_DM() throws Throwable {
		//documentManagerFactory.enter_Search(DocumentData.getName(docType));
		documentManagerFactory.enter_Search(docName);
		documentManagerFactory.click_Search();
	}

	
	public void the_document_is_in_the_search_result() throws Throwable {
		//documentManagerFactory.present_documentInSearchResult(DocumentData.getName(docType));
		documentManagerFactory.present_documentInSearchResult(docName);
	}

	
	public void i_select_the_document() throws Throwable {
		//documentManagerFactory.select_documentInSearchResult(DocumentData.getName(docType));
		documentManagerFactory.select_documentInSearchResult(docName);
	}

	
	public void i_click_the_Edit_button_in_DM() throws Throwable {
		documentManagerFactory.click_Edit();
	}

	
	public void i_check_Enable_Delivery_via_Email() throws Throwable {
		documentManagerFactory.check_EnableDeliveryViaEmail();
	}

	
	public void i_enter_an_email_address_in_the_Mail_From_field() throws Throwable {
		documentManagerFactory.enter_MailFrom(DocumentData.mailFrom);
	}

	
	public void i_enter_a_subject() throws Throwable {
		documentManagerFactory.enter_MailSubject(DocumentData.mailSubject);
	}

	
	public void i_click_Text_Body() throws Throwable {
		documentManagerFactory.click_TextBody();
	}

	public void i_enter_a_Email_html_body() throws Throwable {
		documentManagerFactory.enter_body(DocumentData.emailHtmlBody);
	}
	
	
	public void i_enter_a_Email_text_body() throws Throwable {
		documentManagerFactory.enter_EmailTextBody(DocumentData.emailTextBody);
	}
	
	
	public void i_check_Enable_Delivery_via_SMS() throws Throwable {
		documentManagerFactory.check_EnableDeliveryViaSMS();
	}

	public void i_enter_a_SMS_text_body() throws Throwable {
		documentManagerFactory.enter_SMSTextBody(DocumentData.smsBody);
	}
	
	public void i_click_the_Delete_button_in_DM() throws Throwable {
		if(isDocumentCreated()){
			documentManagerFactory.click_Delete();
			documentManagerFactory.confirmation_DeleteDocument_Yes();
		}
	}

	public void the_document_is_deleted() throws Throwable {
		i_search_the_document_in_DM();
	//	documentManagerFactory.notPresent_documentInSearchResult(DocumentData.getName(docType));
		documentManagerFactory.notPresent_documentInSearchResult(docName);
	}
	
	//Image steps
	
	public void i_click_the_add_image_icon() throws Throwable {
		Utils.clickByXpath(getDriver(), "//span[contains(@class,'cke_button__image_icon')]");
	}

	
	public void i_click_the_Browser_Server_button() throws Throwable {
		Utils.clickByXpath(getDriver(), "//span[text()='Browse Server']");
	}

	
	public void i_double_click_an_image() throws Throwable {
		//log.info("Before switchingwindow is : " + getDriver().getWindowHandle());
		//switch to new window
		Utils.switchWindow(getDriver(), false,null,null);
		// double click the first image
//		.get(.getCurrentUrl());
		//log.info(getDriver().getPageSource());
		try {
			Utils.clickByXpath(getDriver(), "//span[text()='Settings']");
			Utils.doubleClickElement(getDriver(), getDriver().findElement(By.xpath("//div[@id='files_view']//a")));
		} catch (NoSuchElementException ex) {
			ex.printStackTrace();
		} 
		//switch back
		Utils.switchWindow(getDriver(),false,null,null);
		
	}

	
	public void the_image_is_added() throws Throwable {
	    
	}
	
	//one sentence method
	
	public void i_create_an_Email_sample_if_not_already_existing() throws Throwable {
		String emailSampleName = DocumentData.getPermanentName("Email"); 
		documentManagerFactory.enter_Search(emailSampleName);
		documentManagerFactory.click_Search();
		//continue creating an email sample if not existing
		if (!documentManagerFactory.present_documentInSearchResult(emailSampleName)) {
			i_click_the_Add_button_in_DM();
			documentManagerFactory.enter_name(emailSampleName);
			i_click_the_Edit_button_of_Assigned_Portfolio();
			i_assign_some_portfolios_to_the_document();
			i_check_Enable_Delivery_via_Email();
			i_enter_an_email_address_in_the_Mail_From_field();
			i_enter_a_subject();
			i_enter_a_Email_html_body();
			i_click_Text_Body();
			i_enter_a_Email_text_body();
			i_click_the_Save_as_Draft_button_in_the_Add_Document_window();
			the_document_is_saved();
			i_click_the_Publish_This_Version_button_in_the_Add_Document_window();
		}
	}
	
	
	public void i_create_a_Letter_sample_if_not_already_existing() throws Throwable {
		String letterSampleName = DocumentData.getPermanentName("Letter"); 
		documentManagerFactory.enter_Search(letterSampleName);
		documentManagerFactory.click_Search();
		//continue creating a letter sample if not existing
		if (!documentManagerFactory.present_documentInSearchResult(letterSampleName)) {
			i_click_the_Add_button_in_DM();
			documentManagerFactory.enter_name(letterSampleName);
			i_enter_a_document_body();
			i_click_the_Edit_button_of_Assigned_Portfolio();
			i_assign_some_portfolios_to_the_document();
			i_check_Enable_Delivery_via_Letter();
			i_click_the_Save_as_Draft_button_in_the_Add_Document_window();
			the_document_is_saved();
			i_click_the_Publish_This_Version_button_in_the_Add_Document_window();
		}
	}

	public void i_create_a_SMS_sample_if_not_already_existing() throws Throwable {
		String smsSampleName = DocumentData.getPermanentName("SMS"); 
		documentManagerFactory.enter_Search(smsSampleName);
		documentManagerFactory.click_Search();
		//continue creating a SMS sample if not existing
		if (!documentManagerFactory.present_documentInSearchResult(smsSampleName)) {
			i_click_the_Add_button_in_DM();
			documentManagerFactory.enter_name(smsSampleName);
			i_click_the_Edit_button_of_Assigned_Portfolio();
			i_assign_some_portfolios_to_the_document();
			i_check_Enable_Delivery_via_SMS();
			i_enter_a_SMS_text_body();
			i_click_the_Save_as_Draft_button_in_the_Add_Document_window();
			the_document_is_saved();
			i_click_the_Publish_This_Version_button_in_the_Add_Document_window();
		}
	}
}
