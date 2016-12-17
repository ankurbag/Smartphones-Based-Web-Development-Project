package com.neu.mealpass.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.neu.mealpass.user.Account;
import com.neu.mealpass.user.User;

public class ConnectionDao {

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
			connection = DriverManager.getConnection(DbConstants.DB_URL, DbConstants.USER, DbConstants.PASSWORD);
			System.out.println("Success!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * Signup Service
	 * 
	 * @param conn
	 * @param useraccount
	 * @return
	 */

	public static int createUserAccount(Connection conn, Account useraccount) {
		String varname1 = "INSERT INTO mealpaldb.account(Username,Password,token) values(?,?,?)";
		int row = -1;
		try {
			PreparedStatement pstmt = conn.prepareStatement(varname1);

			pstmt.setString(1, useraccount.getUserName());
			pstmt.setString(2, useraccount.getPassword());
			pstmt.setString(3, useraccount.getToken());
			row = pstmt.executeUpdate();
			System.out.println("inserted " + row);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return row;
	}

	/**
	 * Login Service
	 * 
	 * @param conn
	 * @param account
	 * @return
	 */
	public static boolean isAccountValid(Connection conn,Account account) {
		String query = "SELECT * from mealpaldb.account where username=? and token=?";
		ResultSet rs = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, account.getUserName());
			pstmt.setString(2, account.getToken());
			rs = pstmt.executeQuery();
			System.out.println("Resultset.. " + rs);
			if (rs != null && rs.next()) {
				
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static User getUser(Connection conn, String username){
		
		User user = new User();
		String query = "SELECT * from mealpaldb.account where username=? and password=?";
		ResultSet rs = null;
		
		return user;
	}

	public static Account loginUser(Connection conn, String username, String password) {
		String query = "SELECT * from mealpaldb.account where username=? and password=?";
		ResultSet rs = null;
		Account account = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			System.out.println("Resultset.. " + rs);
			if (rs != null && rs.next()) {
				account = new Account();
				account.setUserName(rs.getString(1));
				account.setPassword(rs.getString(2));
				account.setToken(rs.getString(3));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return account;
	}

}
