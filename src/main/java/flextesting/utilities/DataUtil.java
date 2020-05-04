package flextesting.utilities;

import org.apache.log4j.Logger;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

public class DataUtil {
	static Logger log = Logger.getLogger(DataUtil.class);
	private static String randomChars = null;

	/**
	 * <p>Since randomChars is often used as a unique identifier to locate a newly created stuff,
	 * we call setRandomChars first before creating the stuff (called once in StartUp is sufficient), 
	 * then later we use getRandomChars() to get the chars to locate the newly created stuff.
	 * 
	 * <p>if you simply want to get some random chars and not use it as identifier, use getRandomCharsByLength
	 * @param length
	 */
	public static void setRandomChars(int length) {
		randomChars = getRandomCharsByLength(length);
		log.info("Random chars: " + getRandomChars());
	}

	public static String getRandomCharsByLength(int length) {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		return randomGenerator(chars, length);
	}

	/**
	 * Since randomChars is often used as a unique identifier to locate a newly created stuff,
	 * we call setRandomChars first before creating the stuff (called once in StartUp is sufficient), 
	 * then later we use getRandomChars() to get the chars to locate the newly created stuff.
	 * @return
	 */
	public static String getRandomChars() {
		if(randomChars == null){
			setRandomChars(5);
		}
		return randomChars;
	}
	
	private static String randomNumber = null;

	/**
	 * Since randomNumber is sometimes used as a unique identifier to locate a newly created stuff,
	 * we call setRandomNumber first before creating the stuff,
	 * then later we use getRandomNumber() to get the number to locate the newly created stuff.
	 * @param length
	 */
	public static void setRandomNumber(int length) {
		char[] chars = "0123456789".toCharArray();
		randomNumber = randomGenerator(chars, length);
		log.info("Random number: " + randomNumber);
	}
	/**
	 * Since randomNumber is sometimes used as a unique identifier to locate a newly created stuff,
	 * we call setRandomNumber first before creating the stuff,
	 * then later we use getRandomNumber() to get the number to locate the newly created stuff.
	 * @return
	 */
	public static String getRandomNumber() {
		return randomNumber;
	}
	
	public static String getRandomPhoneNumber(String fixedPart1, int lengthOfPart2) {
		setRandomNumber(lengthOfPart2);
		return fixedPart1 + getRandomNumber();
	}
	public static String getRandomNumberNotContainingZero(int length) {
		char[] chars = "123456789".toCharArray();
		return randomGenerator(chars, length);
	}
	

	public static String randomGenerator(char[] chars, int length) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}	
		return sb.toString();
	}
	
	/**
	 * ONLY integer amount accepted
	 * 
	 * Not accepted: 123.45
	 * @param amount of money
	 * @return formatted: 1234567 => 1,234,567
	 */
	public static String currencyFormatter(String amount) {
		NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US); 
		String s = n.format(Double.parseDouble(amount)/ 1.0);
//		log.info("Keep $ sign: " + s);
//		return s;
		//get rid of the $ sign. because some clients use other currencies.
		log.info("Returning amount without currency sign: " + s);
		return s.substring(1);
	}
	
	public static String getDateFormatTxt() {
		return new SimpleDateFormat("yyyyMMHHmmss").format(Calendar.getInstance().getTime());
	}
	
	public static void main(String[] args) {
		System.out.println(currencyFormatter("1234567"));
	}

}
