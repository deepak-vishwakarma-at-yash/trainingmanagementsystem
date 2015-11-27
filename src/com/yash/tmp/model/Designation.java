package com.yash.tmp.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.yash.tmp.service.HelperService;

public class Designation implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int designation_id;
	private String designation;
	private static Map< Integer, String> DESTINATIONMAP = new HashMap<>();

	public Designation() {
		//DESTINATIONMAP = HelperService.getDesignation();
		DESTINATIONMAP.put(1, "MANAGER");
		DESTINATIONMAP.put(2, "TRAINER");
		DESTINATIONMAP.put(3, "TRAINEE");
	}
	
	public int getDesignation_id() {
		return designation_id;
	}
	public void setDesignation_id(int designation_id) {
		this.designation_id = designation_id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Designation [designation_id=" + designation_id + ", designation=" + designation + "]";
	}
	public void setDesignation(int key) {
		this.designation =DESTINATIONMAP.get(key);
	}
}