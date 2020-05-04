package flextesting;

import com.google.common.collect.Ordering;
import flextesting.utilities.Utils;
import flextesting.utilities.Utils;

import java.io.IOException;
import java.util.Arrays;

import static flextesting.utilities.Utils.getTimeInFormat;
import static flextesting.utilities.Utils.writeToFile;
import static org.junit.Assert.*;

public class Test {				
	private String aString() {
		return "A String";
	}
	public Test() {
		System.out.println(this.aString());
	}
	public static void main(String[] args) throws InterruptedException, IOException {
		String[] arr = {" ","1","2","3"};
		System.out.println(Arrays.toString(arr));
//		System.out.println(arr[4]);//ArrayIndexoutOfBoundException(unchecked). Abort execution
		new Test();
		Ordering.natural().isOrdered(Arrays.asList(arr)); // space is before non-space
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		String str1 = new String("str");
		String str2 = new String("str");
		assertTrue(str1.equals(str2)); //equals checks content
		assertFalse(str1 == str2); // == checks location in memory
		String str3 = "str";
		assertTrue(str1.equals(str3));
		assertFalse(str1 == str3);
		String str4 = "str";
		assertTrue(str3.equals(str4));
		assertTrue(str3 == str4);
		String test = "abc";
		String test1 = "a(bc(";
		String test2 = "abc)";
		System.out.println(test+" remote the last char: " + test.replaceFirst(".$", ""));
		System.out.println(test1+" remote the last char: " + test1.replaceFirst(".$", ""));
		System.out.println(test1+" remote the last char if it's ( : " + test1.replaceFirst("\\($", ""));
		System.out.println(test1+" remote the first ( : " + test1.replaceFirst("\\(", ""));
		System.out.println(test2+" remote the last char if it's ( : " + test2.replaceFirst("\\($", ""));
		
		String portfolioInfo = "DK Vivus (Portfolio Id: 220207)";
		String[] infoSplitted = portfolioInfo.split(" \\(Portfolio Id: ");
		System.out.println("Array: " + Arrays.toString(infoSplitted));
		System.out.println("id: " + infoSplitted[1] + " stripped off the last char if it's ) =>" + infoSplitted[1].replaceFirst("\\)$", ""));
		
		String pattern = "^CMC.*|^Collections.*";
		String str10 = "Collectionsadada";
		if (str10.matches(pattern)) System.out.println("Match");
		
		String classes = "x-form-field-wrap x-form-field-trigger-wrap x-hide-display";
		System.out.println(Arrays.asList(classes.split(" ")).contains("x-hide-display"));
		
		String filePath = "re-rerun\\re-rerun.txt";
		String[] failed = Utils.readFromFile(filePath).get(0).split(" ");
		
		if (failed.length > 2) {
			String firstNinFailed = "";
			for (int i=0;i<2;i++) {
				firstNinFailed += failed[i] + " ";
			}
			writeToFile(filePath, firstNinFailed.substring(0, firstNinFailed.length()-1));
		}
		
		
		String[] dateAndTime = getTimeInFormat(null, null).split(" ");
		System.out.println(dateAndTime[0]);
		System.out.println(dateAndTime[1]);
    }		
}
