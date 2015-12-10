package com.yash.tmp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.sql.DataSource;

/**
 * Session Bean implementation class UtilService
 */
@Singleton
@LocalBean
public class UtilService implements UtilServiceLocal {
	
/*	@Resource(lookup="java:jboss/datasources/testDS")
	DataSource dataSource;*/

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/trainingmanagement";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static Connection connection;
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


	//@Schedule(hour="*",second="*",minute="*")
	public String getTime(){
		 DateFormat df = new SimpleDateFormat("HH:mm:ss");
	       Date dateobj = new Date();
		return df.format(dateobj); 
	}
	
	public Connection getDataSourceConnection() throws Exception{
		return null;
	}
}
