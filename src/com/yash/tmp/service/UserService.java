package com.yash.tmp.service;

import java.sql.ResultSet;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.yash.tmp.bean.UserBean;
import com.yash.tmp.model.User;
import com.yash.tmp.util.UtilService;
import com.yash.tmp.util.UtilServiceLocal;

@Stateless
@LocalBean
public class UserService implements UserServiceLocal {

	// @EJB
	private UtilServiceLocal utilService = new UtilService();

	// @ManagedProperty("#{userBean}")
	private UserBean userbean = new UserBean();

	User user = new User();
	
	public UserService() {
	}

	@Override
	public String authenticateUser(String username, String password) throws Exception {
		String query = "SELECT * FROM USER WHERE `username`='" + username + "' AND PASSWORD='" + password + "'";
		ResultSet resultSet = utilService.select(query);
		if (resultSet.next()) {
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
			return "Valid User";
		} else {
			String checkusername = "SELECT username FROM USER WHERE `username`='" + username + "' ";
			String checkpassword = "SELECT password FROM USER WHERE `password`='" + password + "' ";
			ResultSet userset = utilService.select(checkusername);
			ResultSet passwordset = utilService.select(checkpassword);
			if (userset.next())
				return "invalid password";
			if (passwordset.next())
				return "invalid username";
			else {
				return "invalid username password";
			}
		}
	}
	@Override
	public String registeruser(User user) {
		String query = "INSERT INTO USER VALUES(" + user.getUser_id() + ",'" + user.getFirstname() + "','"
				+ user.getLastname() + "','" + user.getContact() + "','" + user.getEmail() + "',"
				+ user.getDesignation().getDesignation_id() + ",0,3,'" + user.getUsername() + "','" + user.getPassword()
				+ "')";
		return utilService.update(query);
	}

	@Override
	public User getUser(String username, String password) throws Exception {
		String query = "SELECT * FROM USER WHERE `username`='" + username + "' AND PASSWORD='" + password + "'";
		ResultSet resultSet = utilService.select(query);
		if (resultSet.next()) {
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
			return user;
		}
		return null;
	}

	@Override
	public String gettime() {
		return utilService.getTime();
	}
}