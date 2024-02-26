package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exception.CustomException;
import pojos.MySQLUserConfig;

public class JDBCTaskHelper {
	private static Connection connection = null;

	public static void enableConnection(String dbName) throws CustomException {
		MySQLUserConfig configs = MySQLUserConfig.getInstance();
		try {
			if (connection == null) {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(configs.getUrl() + "/" + dbName, configs.getUserName(),
						configs.getPassWord());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new CustomException(CustomException.SOME_ERROR_MESSAGE, e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CustomException(CustomException.SOME_ERROR_MESSAGE, e);
		}
	}

	public static Connection getSqlConnection() throws CustomException {
		if(connection == null) {
			enableConnection("IncubationDb");
		}
		return connection;
	}

	public static void disableConnection() throws CustomException {
		try {
			connection.close();
		} catch (SQLException e) {}
	}
}
