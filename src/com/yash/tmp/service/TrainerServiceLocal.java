package com.yash.tmp.service;

import java.util.List;

import javax.ejb.Local;

import com.yash.tmp.model.Courses;
import com.yash.tmp.model.Heading;
import com.yash.tmp.model.StatusCourse;

@Local
public interface TrainerServiceLocal {

	List<Courses> getCourses() throws Exception;

	List<Heading> getHeadings(int viewCourseId) throws Exception;

	Courses getCourse(int viewCourseId) throws Exception;

	List<StatusCourse> getAllStatus() throws Exception;

	void updateCourseStatus(int statusCoursesId, int i) throws Exception;

}
