package com.yash.tmp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yash.tmp.util.UtilService;

public class DaoService implements DaoServiceLocal{
	private static UtilService utilService = new UtilService();
	private static Connection connection = utilService.getConnection();
	private static PreparedStatement preparedStatement;

	@Override
	public ResultSet select(String query) {

		try {
			preparedStatement = connection.prepareStatement(query);
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
			preparedStatement = connection.prepareStatement(query);
			if (preparedStatement.executeUpdate() != 0)
				return "Success";
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return "Fail";
	}

	
	
}
