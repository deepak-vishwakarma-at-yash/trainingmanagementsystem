package com.yash.tmp.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.yash.tmp.service.HelperService;

public class Role implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int role_id;
	private String role;
	
	private static Map< Integer, String> ROLEMAP = new HashMap<>();

	public Role(){
		//ROLEMAP = HelperService.getDesignation();
		ROLEMAP.put(1, "ADMIN");
		ROLEMAP.put(2, "USER");
		ROLEMAP.put(3, "GUEST");
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role=" + role + "]";
	}
	
	public String setRole(int key) {
		 this.role = ROLEMAP.get(key);
		return role;
	}

}