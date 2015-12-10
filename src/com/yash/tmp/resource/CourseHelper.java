package com.yash.tmp.resource;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.yash.tmp.dao.DaoService;
import com.yash.tmp.dao.DaoServiceLocal;

@Path("/courses")
public class CourseHelper {

	
	@GET
	@Path("/getvalue/{course}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getHeading(@PathParam("course") String course) throws Exception{
		/*String getCourseId = "SELECT COURSE_ID FROM COURSES WHERE COURSENAME='"+course+"' AND USER_ID="+userId;
		ResultSet resultSet0 = daoService.select(getCourseId);
		int cId = 0;
		if(resultSet0.next()){
			cId=resultSet0.getInt("COURSE_ID");
		}
		String query = "SELECT  `heading` FROM `heading` WHERE course_id="+cId;
		List<String> checklist = new ArrayList<>();
		ResultSet resultSet = daoService.select(query);
		while(resultSet.next()){
			checklist.add(resultSet.getString("heading"));
		}*/
		return "checklist"+course;
	}
}
