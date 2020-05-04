package flextesting;

public class AutomatedTestConfig {
	public static final int SELECT_FIRST_N = 5;
	static boolean moreThanNFailed = false; //default: only accessible in the package
	public static boolean isMoreThanNFailed() {return moreThanNFailed;}
}