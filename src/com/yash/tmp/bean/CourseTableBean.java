

package com.yash.tmp.bean;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.yash.tmp.dao.DaoService;
import com.yash.tmp.model.Courses;
import com.yash.tmp.model.Heading;
import com.yash.tmp.model.User;
import com.yash.tmp.service.CoursesService;
import com.yash.tmp.service.CoursesServiceLocal;

@ManagedBean
@SessionScoped
public class CourseTableBean {


	
	
	private Courses course = new Courses();

	private CoursesServiceLocal coursesService = new CoursesService();

	DaoService daoService = new DaoService();

	private List<Courses> coursesList = new ArrayList<>();

	private Courses coursesDetail = new Courses();
	
	private List<String> headingDetail = new ArrayList<>();

	private List<String> subheadingDetail = new ArrayList<>();

	private List<Heading> headingDetailList = new ArrayList<>();

	public List<Heading> getHeadingDetailList() {
		return headingDetailList;
	}

	public void setHeadingDetailList(List<Heading> headingDetailList) {
		this.headingDetailList = headingDetailList;
	}

	public List<String> getHeadingDetail() {
		return headingDetail;
	}

	public void setHeadingDetail(List<String> headingDetail) {
		this.headingDetail = headingDetail;
	}

	public List<String> getSubheadingDetail() {
		return subheadingDetail;
	}

	public void setSubheadingDetail(List<String> subheadingDetail) {
		this.subheadingDetail = subheadingDetail;
	}

	public Courses getCoursesDetail() {
		return coursesDetail;
	}

	public void setCoursesDetail(Courses coursesDetail) {
		this.coursesDetail = coursesDetail;
	}

	public CourseTableBean() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		course.setUser((User) session.getAttribute("user"));
	}

	public Courses getCourse() {
		return course;
	}

	public void setCourse(Courses course) {
		this.course = course;
	}

	public List<Courses> getCoursesList() throws Exception {
		coursesList = coursesService.getAllCourses(course.getUser().getUser_id());
		return coursesList;
	}

	public void setCoursesList(List<Courses> coursesList) {
		this.coursesList = coursesList;
	}
	
	public String getDetail() throws Exception{
		Map<String,String> params =  (Map<String, String>)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	  String action = params.get("courseid");
		coursesDetail = coursesService.getCourseDetail(Integer.parseInt(action));
		headingDetail = coursesService.getHeading(Integer.parseInt(action));
		headingDetailList = coursesService.getHeadingDetail(Integer.parseInt(action));
		return "courseview?faces-redirect=true";
	}
	
	public String deleteCourse() throws Exception{
		Map<String,String> params =  (Map<String, String>)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	  String action = params.get("courseid");
		coursesService.deleteCourse(action);
		return null;
	}
	
	public String updateStatus() throws Exception{
		Map<String,String> params =  (Map<String, String>)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	  String courseid = params.get("courseid");
	  String statusid = params.get("statusid");
	  if(statusid.equalsIgnoreCase("0"))statusid="1";else if(statusid.equalsIgnoreCase("1"))statusid="0";
		coursesService.updateStatus(courseid,statusid);
		return null;
	}

}
