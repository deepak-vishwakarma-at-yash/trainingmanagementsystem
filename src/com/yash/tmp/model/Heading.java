package com.yash.tmp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Heading implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int heading_id;
	private String heading;
	private Courses course = new Courses();
	private List<Subheading> subheadings = new ArrayList<>();
	
	public List<Subheading> getSubheadings() {
		return subheadings;
	}
	public void setSubheadings(List<Subheading> subheadings) {
		this.subheadings = subheadings;
	}
	public int getHeading_id() {
		return heading_id;
	}
	public void setHeading_id(int heading_id) {
		this.heading_id = heading_id;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public Courses getCourse() {
		return course;
	}
	public void setCourse(Courses course) {
		this.course = course;
	}

}
