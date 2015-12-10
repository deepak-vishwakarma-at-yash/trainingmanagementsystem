package com.yash.tmp.dao;

import java.sql.ResultSet;

import javax.ejb.Local;

@Local
public interface DaoServiceLocal {
	public ResultSet select(String query)throws Exception;
	public String update(String query);

}
