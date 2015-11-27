package com.yash.tmp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class UtilService
 */
@Singleton
@LocalBean
public class UtilService implements UtilServiceLocal {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/traineemanagement";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static Connection connection;
	private static PreparedStatement preparedStatement;

	public UtilService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Connection getConnection() {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}

	@Override
	public ResultSet select(String query) {

		try {
			preparedStatement = getConnection().prepareStatement(query);
			return preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public String update(String query) {
		try {
			preparedStatement = getConnection().prepareStatement(query);
			if (preparedStatement.executeUpdate() != 0)
				return "Success";
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return "Fail";
	}

	@Override
	public boolean closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				closeConnection();
			}
			return true;
		} else
			return false;
	}


	@Schedule(hour="*",second="*",minute="*")
	public String getTime(){
		 DateFormat df = new SimpleDateFormat("HH:mm:ss");
	       Date dateobj = new Date();
		return df.format(dateobj); 
	}
	
}
