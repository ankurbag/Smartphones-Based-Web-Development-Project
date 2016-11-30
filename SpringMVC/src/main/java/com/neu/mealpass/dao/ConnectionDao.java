package com.neu.mealpass.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neu.mealpass.user.Account;

public class ConnectionDao {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/mealpaldb";// mysql://newton.neu.edu:3306/usersdb","student","p@sswOrd"
	static final String USER = "root";
	static final String PASS = "root1234";
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
	
	/**
	 * Signup Service
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
			System.out.println("inserted "+ row);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

		return row;
	}
	/**
	 * Login Service
	 * @param conn
	 * @param account
	 * @return
	 */
	public static boolean isAccountValid(Connection conn,Account account){
		String query = "SELECT * from mealpaldb.account where username=? and password=?";
		ResultSet rs = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, account.getUserName());
			pstmt.setString(2, account.getPassword());
			rs = pstmt.executeQuery();
			System.out.println("Resultset.. "+ rs);
			if(rs!=null && rs.next()){
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return false;
	}
	

}
