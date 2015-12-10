package com.yash.tmp.model;

import java.io.Serializable;

public class Subheading implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int subheading_id;
	private String subheading;
	private StatusCourse statusCourse = new StatusCourse();
	
	
	public StatusCourse getStatusCourse() {
		return statusCourse;
	}
	public void setStatusCourse(StatusCourse statusCourse) {
		this.statusCourse = statusCourse;
	}
	private Heading heading = new Heading();
	
	
	public Heading getHeading() {
		return heading;
	}
	public void setHeading(Heading heading) {
		this.heading = heading;
	}
	public int getSubheading_id() {
		return subheading_id;
	}
	public void setSubheading_id(int subheading_id) {
		this.subheading_id = subheading_id;
	}
	public String getSubheading() {
		return subheading;
	}
	public void setSubheading(String subheading) {
		this.subheading = subheading;
	}	

}
