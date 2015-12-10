package com.yash.tmp.service;

import java.util.List;

import javax.ejb.Local;

import com.yash.tmp.model.Courses;
import com.yash.tmp.model.Heading;
import com.yash.tmp.model.Subheading;
import com.yash.tmp.model.User;

@Local
public interface CoursesServiceLocal {

	public String saveCourse(Courses course) throws Exception;

	public List<String> getHeading() throws Exception;

	public List<String> getCourse() throws Exception;

	public String addMainCourse(String courseSelect, String headingSelect) throws Exception;

	String checkMethodCall() throws Exception;

	public String addMainCourse(Heading heading,User user) throws Exception;

	public String addSubCourse(Subheading subheading) throws Exception;

	List<String> getCourse(int userId) throws Exception;

	public List<Courses> getAllCourses(int user_id) throws Exception;

	public Courses getCourseDetail(int id) throws Exception;

	public List<String> getHeading(int i) throws Exception;

	public String deleteCourse(String action) throws Exception;

	public String updateStatus(String action , String statusid)throws Exception;

	public List<Heading> getHeadingDetail(int action) throws Exception;

	public int getCourseCount(int user_id) throws Exception;

	public int getCourseActiveCount(int user_id) throws Exception;

	public void uploadFileName(String filename, User user) throws Exception;

}
