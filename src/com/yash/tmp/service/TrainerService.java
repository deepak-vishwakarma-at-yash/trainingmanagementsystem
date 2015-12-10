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
import com.yash.tmp.model.StatusCourse;

@Stateless
@LocalBean
public class TrainerService implements TrainerServiceLocal {

    DaoServiceLocal daoService = new DaoService();
	
	public TrainerService() {
    	
    }

	@Override
	public List<Courses> getCourses() {
		try {
			String query = "SELECT * FROM COURSES WHERE STATUS_ID=1";
			List<Courses> courses = new ArrayList<>();
			ResultSet resultSet = daoService.select(query);
			while(resultSet.next()){
				Courses course = new Courses();
				course.setCourse_id(resultSet.getInt("COURSE_ID"));
				course.setCourseName(resultSet.getString("COURSENAME"));
				course.setDescription(resultSet.getString("DESCRIPTION"));
				course.getStatus().setStatus_id(resultSet.getInt("STATUS_ID"));
				course.getStatus().setStatus(resultSet.getInt("STATUS_ID"));
				course.setReferenceCode(resultSet.getString("REFERENCECODE"));
				course.getUser().setUser_id(resultSet.getInt("USER_ID"));
				courses.add(course);
			}
			return courses;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Heading> getHeadings(int viewCourse) throws Exception {
		List<Heading> headings = new CoursesService().getHeadingDetail(viewCourse);
		return headings;
	}

	@Override
	public Courses getCourse(int viewCourseId) throws Exception {
		Courses courses = new CoursesService().getCourseDetail(viewCourseId);
		return courses;
	}

	@Override
	public List<StatusCourse> getAllStatus() throws Exception {
		String query = "SELECT * FROM STATUSCOURSE";
		ResultSet resultSet = daoService.select(query);
		List<StatusCourse> statusCourses = new ArrayList<>();
		while(resultSet.next()){
			StatusCourse statusCourse = new StatusCourse();
			statusCourse.setStatuscourse_id(resultSet.getInt("statuscourse_id"));
			statusCourse.setStauscourse(resultSet.getString("statuscourse"));
			statusCourses.add(statusCourse);
		}
		return statusCourses;
	}

	@Override
	public void updateCourseStatus(int statusId , int subheadingd) {
		String query ="UPDATE SUBHEADING SET STATUSCOURSE_ID="+statusId+" WHERE SUBHEADING_ID="+subheadingd;
		daoService.update(query);

	}

}
