package flextesting.strategistportal.defaultdata;


import flextesting.utilities.DataUtil;

public class DocumentData {
	public static String getName(String docType) {
		String name = "Sample ";
		switch(docType) {
			case "Letter": 
				name+= "30D Notice Letter_";
				break;
			case "Email": 
				name+= "15D Notice E-Mail_";
				break;
			case "SMS": 
				name+= "Generic SMS_";
				break;
			default:
				name+= "_";
				break;
		}
		name+= DataUtil.getRandomChars();
		return name;
	}
	
	public static String getPermanentName(String docType) {
		String name = "Auto ";
		switch(docType) {
			case "Letter": 
				name+= "30D Notice Letter_";
				break;
			case "Email": 
				name+= "15D Notice E-Mail_";
				break;
			case "SMS": 
				name+= "Generic SMS_";
				break;
			default:
				name+= "_";
				break;
		}
		return name;
	}

	/**
	 * body must start with \n to trigger the text editor iframe 
	 */
	public static String letterBody = "\nDear ${firstname} ${lastname},\n"
			+ "This is just a friendly reminder that your account is past due. According to our records your balance of $${pastdue} is currently 30 days past due.  We have emailed a detailed copy of your account statements. In the event you have not received these messages and documents, we have provided a summary of your account below.\n"
			+ "Amount: $${balance}\n"
			+ "Due Date: ${paymentduedate}\n"
			+ "Days Past Due: ${delinquencyDays}\n"
			+ "We would much appreciate if you could let us know the status of this payment. Please contact us or send your payment of $${pastdue} if you have not already done so, or submit your payment online by visiting us at URL\n\n"
			+ "If there is some error or you are unable to pay at this time, please contact us at PHONE so we can correct any errors or arrange for another payment plan. Thank you for your prompt response to this request and for your continued business.\n\n"
			+ "Sincerely,\n"
			+ "Customer Service\n"
			+ "© 2017\n";
	
	public static String emailHtmlBody = "\nDear ${firstname} ${lastname},\n"
			+ "We hope that everything is going well for you and that you are enjoying the products that we've helped to provide.  However, we have not yet received a payment for your latest invoice and are wondering if there is some sort of problem with can help you with.  Have you already put a check in the mail to us in the amount of $${pastdue}?\n"
			+ "If not, please give this matter your attention today, since we want to be able to extend you credit the next time you shop with us.  Please visit us at URL to make your payment in the amount of $${pastdue} online today.\n"
			+ "Of course, if there is some sort of problem, know that you can contact us at PHONE\n" 
			+ "Sincerely,\n"
			+ "Customer Service\n"
			+ "© 2017\n";
	
	//extra \n at the end of each long sentence/paragraph
	public static String emailTextBody = "\nDear ${firstname} ${lastname},\n\n"
			+ "We hope that everything is going well for you and that you are enjoying the products that we've helped to provide.  However, we have not yet received a payment for your latest invoice and are wondering if there is some sort of problem with can help you with.  Have you already put a check in the mail to us in the amount of $${pastdue}?\n\n"
			+ "If not, please give this matter your attention today, since we want to be able to extend you credit the next time you shop with us.  Please visit us at URL to make your payment in the amount of $${pastdue} online today.\n\n"
			+ "Of course, if there is some sort of problem, know that you can contact us at PHONE\n\n" 
			+ "Sincerely,\n"
			+ "Customer Service\n"
			+ "© 2017\n";
	
	public static String smsBody = "Dear ${firstName}, This is a friendly reminder that your COMPANY NAME account is currently $${pastDue} behind. Please contact us today at PHONE NUMBER 110";

	public static String mailFrom = "cmc@cmc.cmc";
	public static String mailSubject = "testSubject";

}
