package pojos;

import exception.CustomException;

public class MySQLUserConfig implements Cloneable {
	private static volatile MySQLUserConfig myConfig;

	private String userName = "root";
	private String password = "Surya@131419@sS";
	private String url = "jdbc:mysql://localhost:3306";

	private MySQLUserConfig() throws CustomException {
		if (myConfig == null) {
			myConfig = this;
		} else {
			throw new CustomException("Instance Already Created");
		}
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Clone cannot be created");
	}

	public static MySQLUserConfig getInstance() throws CustomException {
		if (myConfig == null) {
			synchronized (MySQLUserConfig.class) {
				if (myConfig == null) {
					new MySQLUserConfig();
				}
			}
		}
		return myConfig;
	}

	public String getUserName() {
		return this.userName;
	}

	public String getPassWord() {
		return this.password;
	}

	public MySQLUserConfig readObject() {
		return myConfig;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}

//Bill Pugh Singleton Implementation
class UserConfig {
	private UserConfig() {

	}

	private static class SingletonInstanceGetter {
		private static final UserConfig INSTANCE = new UserConfig();
	}

	public static UserConfig getInstance() {
		return SingletonInstanceGetter.INSTANCE;
	}
}
