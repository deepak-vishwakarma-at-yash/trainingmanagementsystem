package com.yash.tmp.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.yash.tmp.service.HelperService;

public class Status implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int status_id;
	private String status;
	private static Map< Integer, String> STATUSMAP = new HashMap<>();
	public Status(){
		//STATUSMAP =  HelperService.getStatus();
		STATUSMAP.put(0, "BLOCK");
		STATUSMAP.put(1, "ACTIVE");
	}
	
	
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Status [status_id=" + status_id + ", status=" + status + "]";
	}
	
	public String setStatus(int key) {
		status = STATUSMAP.get(key);
		return status;
	}


}