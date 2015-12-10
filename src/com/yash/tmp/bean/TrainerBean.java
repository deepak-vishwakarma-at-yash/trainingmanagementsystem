package com.yash.tmp.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.yash.tmp.model.Courses;
import com.yash.tmp.model.Heading;
import com.yash.tmp.model.StatusCourse;
import com.yash.tmp.model.User;
import com.yash.tmp.service.TrainerService;
import com.yash.tmp.service.TrainerServiceLocal;

@ManagedBean
@SessionScoped
public class TrainerBean {

	private User user;

	private Courses courses;
	
	private int viewCourseId;
	
	private int statusCoursesId;
	
	public int getStatusCoursesId() {
		return statusCoursesId;
	}


	public void setStatusCoursesId(int statusCoursesId) {
		this.statusCoursesId = statusCoursesId;
	}

	List<Heading> headings = new ArrayList<>();
	
	List<StatusCourse> statusCourses = new ArrayList<>();
	
	
	private TrainerServiceLocal trainerService = new TrainerService();
	
	public List<StatusCourse> getStatusCourses() throws Exception {
		statusCourses = trainerService.getAllStatus();
		return statusCourses;
	}


	public void setStatusCourses(List<StatusCourse> statusCourses) {
		this.statusCourses = statusCourses;
	}


	public Courses getCourses() {
		return courses;
	}


	public void setCourses(Courses courses) {
		this.courses = courses;
	}

	List<Courses> activeCourses = new ArrayList<>();
	
	
	
	public List<Heading> getHeadings() throws Exception {
		this.headings = trainerService.getHeadings(this.viewCourseId);
		return headings;
	}


	public void setHeadings(List<Heading> headings) {
		this.headings = headings;
	}

	public int getViewCourseId() {
		return viewCourseId;
	}


	public void setViewCourseId(int viewCourseId) {
		this.viewCourseId = viewCourseId;
	}


	public List<Courses> getActiveCourses() {
		try {
			this.activeCourses = trainerService.getCourses();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return activeCourses;
	}


	public void setActiveCourses(List<Courses> activeCourses) {
		this.activeCourses = activeCourses;
	}


	public TrainerBean() {
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		this.user = (User)session.getAttribute("user");
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		this.user = (User)session.getAttribute("user");
	}
		
	public String showDetail() throws Exception{
		this.courses = trainerService.getCourse(this.viewCourseId);
		return null;
	}
	
	public String updateCourseStatus() throws Exception{
		Map<String,String> params =  (Map<String, String>)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		  String action = params.get("subheadingId");
		  int subheadingId = Integer.parseInt(action) ;
		  trainerService.updateCourseStatus(this.statusCoursesId, subheadingId);
		  return null;
	}
}
