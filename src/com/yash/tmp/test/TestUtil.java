package com.yash.tmp.test;

import java.sql.ResultSet;

import javax.ejb.EJB;
import javax.inject.Inject;

import com.yash.tmp.log.LoggerProvider;
import com.yash.tmp.model.User;
import com.yash.tmp.util.UtilServiceLocal;

public class TestUtil {

	@EJB
	UtilServiceLocal utilService ;
	
	@Inject
	User user ;
	
	public void selectall() throws Exception {
		String selectall = "SELECT * FROM USER";
		ResultSet resultSet = utilService.select(selectall);
		while (resultSet.next()) {
			user.setUser_id(resultSet.getInt("user_id"));
			user.setFirstname(resultSet.getString("firstname"));
			user.setLastname(resultSet.getString("lastname"));
			user.setContact(resultSet.getString("contact"));
			user.setEmail(resultSet.getString("email"));
			user.getDesignation().setDesignation(resultSet.getInt("designation"));
			user.getStatus().setStatus(resultSet.getInt("status"));
			user.getRole().setRole(resultSet.getInt("role"));
			user.setUsername(resultSet.getString("username"));
			user.setPassword(resultSet.getString("password"));
			
			LoggerProvider.getLogger().info(user);
			
			/*LoggerProvider.getLogger().info(resultSet.getInt("user_id"));
			LoggerProvider.getLogger().info(resultSet.getString("firstname"));
			LoggerProvider.getLogger().info(resultSet.getString("lastname"));
			LoggerProvider.getLogger().info(resultSet.getString("contact"));
			LoggerProvider.getLogger().info(resultSet.getString("email"));
			LoggerProvider.getLogger().info(resultSet.getInt("designation"));
			LoggerProvider.getLogger().info(resultSet.getInt("status"));
			LoggerProvider.getLogger().info(resultSet.getInt("role"));
			LoggerProvider.getLogger().info(resultSet.getString("username"));
			LoggerProvider.getLogger().info(resultSet.getString("password"));*/
		}
	}

	public void selectone() throws Exception {
		String selectone = "SELECT * FROM USER WHERE USER_ID='1'";
		ResultSet resultSet = utilService.select(selectone);
		while (resultSet.next()) {
			user.setUser_id(resultSet.getInt("user_id"));
			user.setFirstname(resultSet.getString("firstname"));
			user.setLastname(resultSet.getString("lastname"));
			user.setContact(resultSet.getString("contact"));
			user.setEmail(resultSet.getString("email"));
			user.getDesignation().setDesignation(resultSet.getInt("designation"));
			user.getStatus().setStatus(resultSet.getInt("status"));
			user.getRole().setRole(resultSet.getInt("role"));
			user.setUsername(resultSet.getString("username"));
			user.setPassword(resultSet.getString("password"));
			
			LoggerProvider.getLogger().info(user);

		}
	}

	public void insert() throws Exception {
		String insert = "INSERT INTO USER VALUES(2,'kushagra','bhargava','9907617218','kush.bhargava@yash.com',3,0,3,'kush101','kush101')";
		LoggerProvider.getLogger().info(utilService.update(insert));
	}
	
	public void deleteone() throws Exception {
		String insert = "DELETE FROM USER WHERE `user_id`=2";
		LoggerProvider.getLogger().info(utilService.update(insert));
	}

	public static void main(String[] args) throws Exception {

		// LoggerProvider.getLogger().info("check log"); --->:check log working.

		//TestUtil test = new TestUtil();

		//test.selectall(); // get all user from db success

		//test.selectone(); // get user with id from db success

		//test.insert(); // insert single entry in db success
		
		//test.deleteone(); // delete selected user in db success
	}
}