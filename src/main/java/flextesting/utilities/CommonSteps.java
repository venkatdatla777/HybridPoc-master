package flextesting.utilities;

import javax.swing.*;

/**
 * @author Shiyi Chen
 */
public class CommonSteps {

	public static void ask(String question) {
	      JOptionPane.showMessageDialog(
	        null, 
	        question, 
	        "Ask for response", 
	        JOptionPane.PLAIN_MESSAGE);
	}
	
}
