package com.yash.tmp.model;

import java.io.Serializable;


public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public User(){
		
	}
	
	private int user_id;
	private String firstname;
	private String lastname;
	private String contact;
	private String email;
	//@Inject
	private Designation designation = new Designation();
	//@Inject
	private Status status = new Status();
	//@Inject
	private Role role = new Role();
	private String username;
	private String password;

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Designation getDesignation() {
		return designation;
	}
	public void setDesignation(Designation designation) {
		this.designation = designation;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", firstname=" + firstname + ", lastname=" + lastname + ", contact="
				+ contact + ", email=" + email + ", designation=" + designation.getDesignation() + ", status=" + status.getStatus() + ", role="
				+ role.getRole() + ", username=" + username + ", password=" + password + "]";
	}
	
	
	

}
