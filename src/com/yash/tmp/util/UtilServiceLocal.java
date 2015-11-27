package com.yash.tmp.util;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.ejb.Local;

@Local
public interface UtilServiceLocal {

	public Connection getConnection();
	public ResultSet select(String query)throws Exception;
	public String update(String query);
	public boolean closeConnection();
	public String getTime();
	
}
