package flextesting.client;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Cycle through a list of users to alleviate the situation that an user can not load
 * more account when already locked three accounts (happens when an user unable to
 * disposition due to failed scenarios in flexstation. If this happens to three accounts
 * then this user can on longer load more accounts to do more tests.)
 * 
 * The idea is to divide these failed dispositions among many users (so the more user in queue/pool the better)
 * (or at least try to divide, because we don't know when a failed disposition will happen)
 * 
 * Usage: call pollFromQueue in @ Before method, and addToQueue in @ After method 
 * @author Shiyi Chen
 *
 */
public class UserMaster {
	static Logger log = Logger.getLogger(UserMaster.class);
	private static UserMaster instance = null;
	public static UserMaster getInstance() throws ClassNotFoundException, IOException {
		if (instance==null) {
			instance = new UserMaster();
		}
		return instance;
	}
	private UserList userList;
	private UserMaster() throws ClassNotFoundException, IOException {
		userList = new UserList();
	}
	public ArrayList<String[]> userInfo = new ArrayList<>();
	private int forkNumber = -1;
	private int userIndex = -1; //-1 is an error code
	{
//		userInfo.add(new String[] {"schen", "Test123&"});
//		userInfo.add(new String[] {"schen2", "Test123$"});
//		userInfo.add(new String[] {"schen3", "Test123%"});
		userInfo.add(new String[] {"autotester", "Test123!!"});
		userInfo.add(new String[] {"autotester2", "Test123@@"});
		userInfo.add(new String[] {"autotester3", "Test123##"});
		userInfo.add(new String[] {"autotester4", "Test123$$"});
		userInfo.add(new String[] {"autotester5", "Test123%%"});
		userInfo.add(new String[] {"autotester6", "Test123^^"});
	}
	/**
	 * if forkCount > 1, assign different user to different jvm * 
	 * if running in Eclipse (meaning no forkCount is set)
	 * or when forkCount = 1, we randomly pick a user from the list
	 * 
	 * The reason we are doing this: suppose there is a failure in flexstation and no disposition
	 * is done for the account. For one agent, usually there can be at most three un-dispositioned
	 * accounts. So randomly pick an agent can alleviate this problem.
	 * @return user index of the user list
	 */
	private void setUserIndex() {
		String forkCount = System.getProperty("forkCount");
		log.info("Parallel level: " + forkCount);
		//if forkCount is not specified or 1
		//then we randomly pick an user
		if (forkCount == null || forkCount.equals("1")) {
			log.info("forkCount is null or 1, randomly pick an user from userList");
			userIndex = (new Random()).nextInt(userList.getSize());
		} 
		//if forkCount > 1
		//then assigning different user to different jvm (fork)
		else {
			if (Integer.parseInt(forkCount) > userList.getSize())
				throw new RuntimeException("Fork count CANNOT be bigger than number of users available");
			String forkNumberString = System.getProperty("forkNumber");
			log.info("forkNumber: " + forkNumberString);
			forkNumber = Integer.parseInt(forkNumberString);	
			userIndex = forkNumber - 1;
		}
		log.info("userIndex: " + userIndex);	
	}

	public String getUsername() {
		setUserIndex();
		String userName = userList.getUserByIndex(userIndex).loginName;
		log.info("username: " + userName);
		return userName;
	}
	
	public String getPassword() {
		String password = userList.getUserByIndex(userIndex).password;
		log.info("password: " + password);
		return password;
	}
	
	public String getPassword(String username) {
		return userList.getPasswordByUserName(username);
	}
	
}
