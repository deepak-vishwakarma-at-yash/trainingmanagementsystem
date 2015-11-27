package com.yash.tmp.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.yash.tmp.service.UserService;

@Path("/timer")
public class Timer {

	UserService userService = new UserService();
	
	@GET
	@Path("/getvalue")
	public String getTimer(){
		return "check rest";
	}
	
	@GET
	@Path("/get")
	public String get(){
		return userService.gettime();
	}
}
