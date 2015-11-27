package com.yash.tmp.service;

import javax.ejb.Local;

import com.yash.tmp.model.User;

@Local
public interface UserServiceLocal {
	public String authenticateUser(String username , String password) throws Exception;

	public String registeruser(User user);

	public User getUser(String username, String password) throws Exception;

	public String gettime();
}
