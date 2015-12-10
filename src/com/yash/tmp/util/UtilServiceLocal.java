package com.yash.tmp.util;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.ejb.Local;

@Local
public interface UtilServiceLocal {

	public Connection getConnection();
	public boolean closeConnection();
	public String getTime();
	public Connection getDataSourceConnection() throws Exception;
	
}
