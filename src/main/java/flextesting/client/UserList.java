package flextesting.client;

import flextesting.utilities.Utils;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserList implements Serializable{
	static Logger log = Logger.getLogger(UserList.class);
	
	/**
	 * actions needed: 
	 * 1. get user in order (most often)
	 * 2. add or update a user (occasionally)
	 * 3. size
	 * 4. toString() 
	 * 5. delete user by loginName (rarely)
	 * 
	 * extra: 
	 * 1. restore userList from file (deserialization)
	 * 2. write userList to file (serialization)
	 */
	private List<User> userList = null;
//	private String testPath = "./accounts/PCIQAAutoCreatedUsers.ser";
	private String userListObjectFile = ClientProvider.getAutoCreatedUsersFileName() + ".ser";
	private String userListTxtFile = ClientProvider.getAutoCreatedUsersFileName() + ".txt";

	public UserList() throws ClassNotFoundException, IOException {
//		LoggerConfig.config();
		if (ifFileExist()) {
			restoreListFromFile();
			//if somehow the file is empty, meaning the userlist restored from it is null
			if (userList == null) {
				log.info("UserList restored from file is null (file is empty). Initialize it to new ArrayList");
				userList = new ArrayList<>();
			}
		}
		else {
//			log.info("Creating the userlist file...");
//			Utils.writeToFile(userListObjectFile, "");
			userList = new ArrayList<>();
			log.info("userList initialized to new ArrayList");
		}
	}
	
	public String getPasswordByUserName(String username) {
		for (User user: userList) {
			if (user.loginName.equals(username))
				return user.password;
		}
		return null;
	}
	
	public User getUserByIndex(int index) {
		return userList.get(index);
	}
	
	
	public void addOrUpdateUser(String loginName, String password) {
		if (!updatePasswordByLoginName(loginName, password)) {
			User newUser = new User(loginName, password); 
			userList.add(newUser);
			log.info("New user added: " + newUser.toString());
		}
	}
	
	public void deleteUserByLoginName(String loginName) {
		for (int i=0;i<userList.size();i++) {
			if (userList.get(i).loginName.equals(loginName)) {
				userList.remove(i);
				break;
			}
		}
	}
	
	private boolean updatePasswordByLoginName(String loginName, String newPassword) {
		boolean updated = false;
		for (User user: userList) {
			if (user.loginName.equals(loginName)) {
				user.password = newPassword;
				updated = true;
				log.info("User password updated: " + user.toString());
			}
		}
		return updated;
	}
	
	public int getSize() {
		return userList.size();
	}
	
	@Override
	public String toString() { 
		StringBuilder sb = new StringBuilder();
		for (User user: userList) {
			sb.append(user.toString() + "\n");
		}
		return sb.toString();
	}
	
	public void writeListToFile() throws IOException {
		try{
//			FileOutputStream fout = new FileOutputStream(testPath);
			FileOutputStream fout = new FileOutputStream(userListObjectFile);
			log.info("Writting to file:\n" + userList);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
		    oos.writeObject(userList);
		    oos.close();
		    fout.close();
		    log.info("Serialization done. Object written to file");
		    Utils.writeToFile(userListTxtFile, this.toString());
		} catch (FileNotFoundException e) {
			log.info("UserList file not found");
			throw e;
		} catch (IOException e) {
			log.info("Error initializing stream");
			throw e;
		} 
	}
	
	/**
	 * @return true if file exist, false if not
	 * @throws IOException NOTE: temporally using it as empty file check, which is not a good idea.//TODO
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 */
	private void restoreListFromFile() throws ClassNotFoundException, FileNotFoundException {
		try{
//			FileInputStream fi = new FileInputStream(new File(testPath));
			FileInputStream fi = new FileInputStream(new File(userListObjectFile));
			ObjectInputStream oi = new ObjectInputStream(fi);
			userList = (List<User>) oi.readObject();
		    oi.close();
		    fi.close();
		    log.info(userList.size() + " users restored from file:\n" + userList);
		    log.info("Deserialization done. Object restored from file");
		} catch (FileNotFoundException e) {
			log.info("Userlist file not found");
			throw e;
		} catch (IOException e) {
			log.info("Error initializing stream");
		} catch (ClassNotFoundException e) {
			log.info("Class not found");
			e.printStackTrace();
			throw e;
		}
	}
	
	private boolean ifFileExist() {
		try {
//			FileInputStream fi = new FileInputStream(new File(testPath));
			FileInputStream fi = new FileInputStream(new File(userListObjectFile));
			fi.close();
			return true;
		} catch (FileNotFoundException e) {
			log.info("UserList file not found");
			return false;
		} catch (IOException e) {
			log.info("Error initializing stream");
			return true;
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
//		UserList list = new UserList();
//		list.deleteUserByLoginName("A");
//		list.addOrUpdateUser("A", "Pa");
//		list.writeListToFile();
//		list.addOrUpdateUser("B", "Pb");
//		list.writeListToFile();
//		list.addOrUpdateUser("C", "Pc");
//		list.writeListToFile();
		
		UserList listB = new UserList();
		System.out.println(listB);
	}
}
