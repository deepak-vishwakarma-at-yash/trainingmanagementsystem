package com.yash.tmp.model;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.yash.tmp.bean.UserBean;

public class Courses implements Serializable {

	private static final long serialVersionUID = 1L;

	private int course_id;
	private String courseName;
	private String description;
	private String referenceCode;
	private User user = new User();
	private Status status = new Status();
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		
		this.user = user;
	}


	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReferenceCode() {
		return referenceCode;
	}

	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}

}