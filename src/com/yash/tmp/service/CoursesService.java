package com.yash.tmp.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.yash.tmp.dao.DaoService;
import com.yash.tmp.dao.DaoServiceLocal;
import com.yash.tmp.model.Courses;
import com.yash.tmp.model.Heading;
import com.yash.tmp.model.Subheading;
import com.yash.tmp.model.User;

@Stateless
@LocalBean
public class CoursesService implements CoursesServiceLocal {

	private DaoServiceLocal daoService = new DaoService(); 

	public CoursesService() {

	}

	@Override
	public String saveCourse(Courses courses) throws Exception {
		String query = "INSERT INTO COURSES (COURSENAME,DESCRIPTION,STATUS_ID,REFERENCECODE,USER_ID) VALUES ('"
				+ courses.getCourseName() + "','" + courses.getDescription() + "',"+courses.getStatus().getStatus_id()+",'" + courses.getReferenceCode()+"',"+courses.getUser().getUser_id()+")";
		return daoService.update(query);
	}

	@Override
	public List<String> getHeading() throws Exception {
		List<String> headings = new ArrayList<>();
		String query = "SELECT  HEADING FROM HEADING";
		ResultSet resultSet = daoService.select(query);
		while (resultSet.next()) {
			headings.add(resultSet.getString("HEADING"));
		}
		return headings;
	}
	@Override
	public List<String> getCourse(int userId) throws Exception {
		List<String> courses = new ArrayList<>();
		String query = "SELECT  COURSENAME FROM COURSES WHERE USER_ID="+userId;
		ResultSet resultSet = daoService.select(query);
		while (resultSet.next()) {
			courses.add(resultSet.getString("COURSENAME"));
		}
		return courses;
	}

	@Override
	public String addMainCourse(String courseSelect, String headingSelect) throws Exception {
		String query = "INSERT INTO HEADING (HEADING,COURSE_ID) VALUES ('" + courseSelect + "','" + 2 + "')";
		return daoService.update(query);
	}

	@Override
	public String checkMethodCall() throws Exception {
		String query = "INSERT INTO HEADING (HEADING,COURSE_ID) VALUES ('" + "headingtest1" + "','" + 2 + "')";
		return daoService.update(query);
	}

	@Override
	public String addMainCourse(Heading heading, User user) throws Exception {
		String getCourseId = "SELECT  `course_id` FROM `courses` WHERE coursename='"
				+ heading.getCourse().getCourseName() + "' AND USER_ID="+user.getUser_id();
		ResultSet resultSet = daoService.select(getCourseId);
		int courseId = 0;
		if (resultSet.next()) {
			courseId = resultSet.getInt("course_id");
		}
		String query = "INSERT INTO HEADING (HEADING,COURSE_ID) VALUES ('" + heading.getHeading() + "','" + courseId
				+ "')";
		return daoService.update(query);
	}

	@Override
	public String addSubCourse(Subheading subheading) throws Exception {
		String getHeadingId = "SELECT `heading_id` FROM heading WHERE heading='"+subheading.getHeading().getHeading()+"'";
		ResultSet resultSet = daoService.select(getHeadingId);
		int headingId = 0;
		if (resultSet.next()) {
			headingId = resultSet.getInt("heading_id");
		}
		String query = "INSERT INTO SUBHEADING (SUBHEADING,HEADING_ID,STATUSCOURSE_ID) VALUES ('"+subheading.getSubheading()+"',"+headingId+","+subheading.getStatusCourse().getStatuscourse_id()+")";
		return daoService.update(query);
	}

	@Override
	public List<String> getCourse() throws Exception {
		List<String> courses = new ArrayList<>();
		String query = "SELECT  COURSENAME FROM COURSES ";
		ResultSet resultSet = daoService.select(query);
		while (resultSet.next()) {
			courses.add(resultSet.getString("COURSENAME"));
		}
		return courses;
	}

	@Override
	public List<Courses> getAllCourses(int user_id) throws Exception {
		List<Courses> courses = new ArrayList<>();
		String query = "SELECT  * FROM COURSES WHERE USER_ID="+user_id;
		ResultSet resultSet = daoService.select(query);
		while (resultSet.next()) {
			Courses courses2 = new Courses();
			courses2.setCourse_id(resultSet.getInt("COURSE_ID"));
			courses2.setCourseName(resultSet.getString("COURSENAME"));
			courses2.setDescription(resultSet.getString("DESCRIPTION"));
			courses2.getStatus().setStatus_id(resultSet.getInt("STATUS_ID"));
			courses2.getStatus().setStatus(resultSet.getInt("STATUS_ID"));
			courses2.setReferenceCode(resultSet.getString("REFERENCECODE"));
			courses2.getUser().setUser_id(resultSet.getInt("USER_ID"));
			courses.add(courses2);
		}
		return courses;
	}

	@Override
	public Courses getCourseDetail(int courseid) throws Exception {
		Courses courses = new Courses();
		String query = "SELECT * FROM COURSES WHERE COURSE_ID="+courseid;
		ResultSet resultSet = daoService.select(query);
		while (resultSet.next()) {
			courses.setCourse_id(resultSet.getInt("COURSE_ID"));
			courses.setCourseName(resultSet.getString("COURSENAME"));
			courses.setDescription(resultSet.getString("DESCRIPTION"));
			courses.getStatus().setStatus(resultSet.getInt("STATUS_ID"));
			courses.setReferenceCode(resultSet.getString("REFERENCECODE"));
			courses.getUser().setUser_id(resultSet.getInt("USER_ID"));
		}
		return courses;
	}

	@Override
	public List<String> getHeading(int id) throws Exception {
		List<String> headings = new ArrayList<>();
		String query = "SELECT  HEADING FROM HEADING WHERE COURSE_ID="+id;
		ResultSet resultSet = daoService.select(query);
		while (resultSet.next()) {
			headings.add(resultSet.getString("HEADING"));
		}
		return headings;
	}

	@Override
	public String deleteCourse(String action) throws Exception {
		String query = "DELETE FROM `courses` WHERE `course_id`="+action;
		return daoService.update(query);
	}

	@Override
	public String updateStatus(String action , String statusid) throws Exception {
		String query = "UPDATE `courses` SET `status_id`="+statusid+" WHERE `course_id`="+action;
		return daoService.update(query);
	}

	@Override
	public List<Heading> getHeadingDetail(int action) throws Exception {
		List<Heading> headings = new ArrayList<>();
		String query = "SELECT  * FROM HEADING WHERE COURSE_ID="+action;
		ResultSet resultSet = daoService.select(query);
		while (resultSet.next()) {
			Heading heading = new Heading();
			heading.setHeading_id(resultSet.getInt("HEADING_ID"));
			heading.setHeading(resultSet.getString("HEADING"));
			heading.getCourse().setCourse_id(resultSet.getInt("COURSE_ID"));
			headings.add(heading);
		}
		
		for (Heading heading : headings) {
			List<Subheading> subheadings = new ArrayList<>();
			String getCourse= "SELECT * FROM SUBHEADING WHERE HEADING_ID="+heading.getHeading_id();
			ResultSet resultSet2 = daoService.select(getCourse);
			while(resultSet2.next()){
				Subheading subheading = new Subheading();
				subheading.setSubheading_id(resultSet2.getInt("SUBHEADING_ID"));
				subheading.setSubheading(resultSet2.getString("SUBHEADING"));
				subheading.getStatusCourse().setStatuscourse_id(resultSet2.getInt("STATUSCOURSE_ID"));
				subheading.getStatusCourse().setStauscourse(resultSet2.getInt("STATUSCOURSE_ID"));
				subheading.getHeading().setHeading_id(resultSet2.getInt("HEADING_ID"));
				subheadings.add(subheading);
			}
			heading.setSubheadings(subheadings);
		}
		return headings;
	}

	@Override
	public int getCourseCount(int user_id) throws Exception {
		String query = "SELECT  COUNT(COURSENAME) AS COUNT FROM COURSES WHERE USER_ID="+user_id;
		ResultSet resultSet = daoService.select(query);
		int count=0;
		if(resultSet.next()){
			count=resultSet.getInt("COUNT");
		}
		return count;
	}

	@Override
	public int getCourseActiveCount(int user_id) throws Exception {
		String query = "SELECT  COUNT(COURSENAME) AS COUNT FROM COURSES WHERE USER_ID="+user_id+" AND STATUS_ID=1";
		ResultSet resultSet = daoService.select(query);
		int count=0;
		if(resultSet.next()){
			count=resultSet.getInt("COUNT");
		}
		return count;
	}

	@Override
	public void uploadFileName(String filename , User user) throws Exception {
		String query = "INSERT INTO FILE (FILENAME,USER_ID) VALUES ('"+filename+"',"+user.getUser_id()+")";
		daoService.update(query);
	}

	
}
