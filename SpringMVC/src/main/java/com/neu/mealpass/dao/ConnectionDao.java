package com.neu.mealpass.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.neu.mealpass.user.Account;

public class ConnectionDao {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/patient";// mysql://newton.neu.edu:3306/usersdb","student","p@sswOrd"
	static final String USER = "root";
	static final String PASS = "1234";
	private static ConnectionDao connectionDao;

	private ConnectionDao() {

	}

	public static ConnectionDao getConnectionDao() {
		if (connectionDao == null)
			connectionDao = new ConnectionDao();
		return connectionDao;
	}

	public static Connection getConnection() {
		Connection connection = null;
		// STEP 2: Register JDBC driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// STEP 3: Open a connection
		System.out.println("Connecting to database...");
		try {
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Success!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public static boolean isAccountValid(Account account){
		return true;
	}

}
