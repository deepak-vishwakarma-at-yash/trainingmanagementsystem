package com.yash.tmp.resource;





import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.yash.tmp.dao.DaoService;
import com.yash.tmp.dao.DaoServiceLocal;
import com.yash.tmp.model.User;

@Path("/heading")
public class HeadingCall {
	

	private DaoServiceLocal daoService = new DaoService();
	
	@GET
	@Path("/getvalue/{course}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getHeading(@PathParam("course") String course,@PathParam("id") int userId) throws Exception{
		String getCourseId = "SELECT COURSE_ID FROM COURSES WHERE COURSENAME='"+course+"' AND USER_ID="+userId;
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
		}
		return checklist;
	}
	
	@GET
	@Path("/getvalue/{heading}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getSubHeading(@PathParam("heading") String heading) throws Exception{
		String getHeadingId = "SELECT HEADING_ID FROM HEADING WHERE HEADING='"+heading+"'";
		ResultSet resultSet0 = daoService.select(getHeadingId);
		int hId = 0;
		if(resultSet0.next()){
			hId=resultSet0.getInt("HEADING_ID");
		}
		String query = "SELECT  SUBHEADING FROM SUBHEADING WHERE HEADING_ID="+hId;
		List<String> checklist = new ArrayList<>();
		ResultSet resultSet = daoService.select(query);
		while(resultSet.next()){
			checklist.add(resultSet.getString("SUBHEADING"));
		}
		return checklist;
	}

	
/*	@GET
	@Path("/get/{course}")
	public List<String> get(){
		return userService.gettime();
	}*/
}