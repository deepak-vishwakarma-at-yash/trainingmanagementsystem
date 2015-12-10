package com.yash.tmp.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.yash.tmp.model.Courses;
import com.yash.tmp.model.Heading;
import com.yash.tmp.model.Subheading;
import com.yash.tmp.model.User;
import com.yash.tmp.service.CoursesService;
import com.yash.tmp.service.CoursesServiceLocal;


@ManagedBean
@SessionScoped
public class CoursesBean {

	public CoursesBean() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		course.setUser((User) session.getAttribute("user"));
	}

	Logger logger = Logger.getLogger(CoursesBean.class.getName());

	private CoursesServiceLocal coursesService = new CoursesService();

	private List<String> listcourse = new ArrayList<>();

	private List<String> listheading = new ArrayList<>();

	private String selectCourseTitle;

	private String selectHeading;

	private String courseSelect;

	private String headingSelect;

	private String subHeadinSelect;

	private Courses course = new Courses();

	private Heading heading = new Heading();

	private Subheading subheading = new Subheading();

	private String checkCallValue;

	private int coursesCount;

	private int activeCoursesCount;

	private boolean checkstatus;

	public boolean isCheckstatus() {
		this.checkstatus = true;
		return checkstatus;
	}

	public void setCheckstatus(boolean checkstatus) {
		this.checkstatus = checkstatus;
	}

	public int getActiveCoursesCount() throws Exception {
		activeCoursesCount = coursesService.getCourseActiveCount(course.getUser().getUser_id());
		return activeCoursesCount;
	}

	public void setActiveCoursesCount(int activeCoursesCount) {
		this.activeCoursesCount = activeCoursesCount;
	}

	public int getCoursesCount() throws Exception {
		coursesCount = coursesService.getCourseCount(course.getUser().getUser_id());
		return coursesCount;
	}

	public void setCoursesCount(int coursesCount) {
		this.coursesCount = coursesCount;
	}

	public String getCheckCallValue() {
		return checkCallValue;
	}

	public void setCheckCallValue(String checkCallValue) {
		this.checkCallValue = checkCallValue;
	}

	public Subheading getSubheading() {
		return subheading;
	}

	public void setSubheading(Subheading subheading) {
		this.subheading = subheading;
	}

	public Heading getHeading() {
		return heading;
	}

	public void setHeading(Heading heading) {
		this.heading = heading;
	}

	public String getSubHeadinSelect() {
		return subHeadinSelect;
	}

	public void setSubHeadinSelect(String subHeadinSelect) {
		this.subHeadinSelect = subHeadinSelect;
	}

	public String getCourseSelect() {
		return courseSelect;
	}

	public void setCourseSelect(String courseSelect) {
		this.courseSelect = courseSelect;
	}

	public String getHeadingSelect() {
		return headingSelect;
	}

	public void setHeadingSelect(String headingSelect) {
		this.headingSelect = headingSelect;
	}

	public String getSelectHeading() {
		return selectHeading;
	}

	public void setSelectHeading(String selectHeading) {
		this.selectHeading = selectHeading;
	}

	public String getSelectCourseTitle() {
		selectCourseTitle = course.getCourseName();
		return selectCourseTitle;
	}

	public void setSelectCourseTitle(String selectCourseTitle) {
		this.selectCourseTitle = selectCourseTitle;
	}

	public List<String> getListcourse() throws Exception {
		listcourse = coursesService.getCourse(course.getUser().getUser_id());
		return listcourse;
	}

	public void setListcourse(List<String> listcourse) {
		this.listcourse = listcourse;
	}

	public List<String> getListheading() throws Exception {
		listheading = coursesService.getHeading();
		return listheading;
	}

	public void setListheading(List<String> listheading) {
		this.listheading = listheading;
	}

	public Courses getCourse() {
		return course;
	}

	public void setCourse(Courses course) {
		this.course = course;
	}

	public String saveCourse() throws Exception {
		if (checkstatus)
			course.getStatus().setStatus_id(1);
		else
			course.getStatus().setStatus_id(0);
		
		coursesService.saveCourse(course);
		return "coursedetail?faces-redirect=true";
	}

	
	public String addMainCourse() throws Exception {
		String check = coursesService.addMainCourse(heading, course.getUser());
		if (check.equalsIgnoreCase("success"))
			return "welcome?faces-redirect=true";
		else
			return null;
	}

	public String addMainCourseAndMore() throws Exception {
		coursesService.addMainCourse(heading, course.getUser());
		return null;
	}

	public String addSubCourse() throws Exception {
		String check = coursesService.addSubCourse(subheading);
		if (check.equalsIgnoreCase("success"))
			return "welcome?faces-redirect=true";
		else
			return null;
	}

	public String addSubCourseAndMore() throws Exception {
		coursesService.addSubCourse(subheading);
		return null;
	}

}
