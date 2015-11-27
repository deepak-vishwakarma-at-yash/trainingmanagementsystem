package com.yash.tmp.service;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.yash.tmp.util.UtilService;
import com.yash.tmp.util.UtilServiceLocal;

public class HelperService {
	
	private static UtilServiceLocal utilService = new UtilService();

	public static Map< Integer, String> getDesignation() {
		String query ="SELECT * FROM DESIGNATION";
		Map<Integer, String> designations= new HashMap<>();
		ResultSet resultSet;
		try {
			resultSet = utilService.select(query);
		
		while(resultSet.next()){
			designations.put(resultSet.getInt("designation_id"), resultSet.getString("designation"));
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return designations;
	}
	
	public static Map< Integer, String> getRole() {
		String query ="SELECT * FROM ROLE";
		Map<Integer, String> roles= new HashMap<>();
		ResultSet resultSet;
		try {
			resultSet = utilService.select(query);
		
		while(resultSet.next()){
			roles.put(resultSet.getInt("role_id"), resultSet.getString("role"));
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return roles;
	}
	
	public static Map< Integer, String> getStatus() {
		String query ="SELECT * FROM STATUS";
		Map<Integer, String> status= new HashMap<>();
		ResultSet resultSet;
		try {
			resultSet = utilService.select(query);
		
		while(resultSet.next()){
			status.put(resultSet.getInt("status_id"), resultSet.getString("status"));
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return status;
	}
	

}
