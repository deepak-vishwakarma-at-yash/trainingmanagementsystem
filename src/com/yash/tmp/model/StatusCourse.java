package com.yash.tmp.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class StatusCourse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int statuscourse_id;
	private String stauscourse;
	private static Map< Integer, String> StatusCourseMap = new HashMap<>();

	public StatusCourse() {
		//DESTINATIONMAP = HelperService.getDesignation();
		StatusCourseMap.put(0, "NOT STARTED");
		StatusCourseMap.put(1, "PENDING");
		StatusCourseMap.put(2, "COMPLETED");
	}
	
	public int getStatuscourse_id() {
		return statuscourse_id;
	}
	public void setStatuscourse_id(int statuscourse_id) {
		this.statuscourse_id = statuscourse_id;
	}
	public String getStauscourse() {
		return stauscourse;
	}
	public void setStauscourse(String stauscourse) {
		this.stauscourse = stauscourse;
	}
	public void setStauscourse(int key) {
		this.stauscourse=StatusCourseMap.get(key);
	}
	

}
