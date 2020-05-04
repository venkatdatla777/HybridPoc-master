package flextesting.client;

import java.io.Serializable;

class User implements Serializable{
	String loginName;
	String password;
	
	User(String loginName, String password) {
		this.loginName = loginName;
		this.password = password;
	}

	@Override
	public String toString() {
		return loginName + " | " + password;
	}
}
