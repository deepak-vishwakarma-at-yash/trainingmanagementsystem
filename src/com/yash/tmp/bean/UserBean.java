package com.yash.tmp.bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.yash.tmp.log.LoggerProvider;
import com.yash.tmp.model.User;
import com.yash.tmp.service.UserService;
import com.yash.tmp.service.UserServiceLocal;

@ManagedBean
@SessionScoped
public class UserBean {

	User user = new User();

	UserServiceLocal userService = new UserService();

	private String message;

	private String greeting;

	private boolean rememberUser;

	private String timer;

	private String username;

	private String password;

	private String dashurl;

	private String courseurl;


	private static Logger LOGGER = Logger.getLogger(UserBean.class.getName());
	
	private List<String> menulist ;
	private List<String> userlist = new ArrayList<>();
	private List<String> adminlist = new ArrayList<>();
	private List<String> guestlist = new ArrayList<>();
	public String getCourseurl() {
		return courseurl;
	}
	
	public void setCourseurl(String courseurl) {
		this.courseurl = courseurl;
	}
	public String getDashurl() {
		return dashurl;
	}

	public void setDashurl(String dashurl) {
		this.dashurl = dashurl;
	}


	public List<String> getMenulist() {
		return menulist;
	}

	public void setMenulist(List<String> menulist) {
		this.menulist = menulist;
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

	public void showTimer() {
		this.timer = userService.gettime();

	}

	public String getTimer() {
		this.timer = userService.gettime();
		return timer;
	}

	public void setTimer(String timer) {
		this.timer = timer;
	}

	public boolean isRememberUser() {
		return rememberUser;
	}

	public void setRememberUser(boolean rememberUser) {
		this.rememberUser = rememberUser;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String getMessage() {
		
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String authenticate() throws Exception {
		if (!this.username.equalsIgnoreCase("") && this.username != null && !this.password.equalsIgnoreCase("")
				&& this.password != null) {
			this.message = userService.authenticateUser(this.username, this.password);
			if (this.message.equalsIgnoreCase("Valid User")) {
				this.user = userService.getUser(this.username, this.password);
				HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
				session.setAttribute("user", this.user);
				if (this.user.getRole().getRole().equalsIgnoreCase("ADMIN")) {
					this.menulist = this.adminlist;
				}else
				if (this.user.getRole().getRole().equalsIgnoreCase("USER")) {
					this.menulist = this.userlist;
				}else
				if (this.user.getRole().getRole().equalsIgnoreCase("GUEST")) {
					this.menulist = this.guestlist;
				}
				this.greeting = "Welcome";
				if(this.user.getDesignation().getDesignation().equalsIgnoreCase("MANAGER"))
				{	this.dashurl="welcomemanager.xhtml"; this.courseurl="coursetable.xhtml";
				return "welcomemanager.xhtml?faces-redirect=true";
				}
				else if(this.user.getDesignation().getDesignation().equalsIgnoreCase("TRAINER")){ this.dashurl="welcometrianer.xhtml"; this.courseurl=""; return "welcometrianer.xhtml?faces-redirect=true";}
 else {
					this.dashurl="welcometrainee.xhtml"; this.courseurl=""; return "welcometrainee.xhtml?faces-redirect=true";}
			} else {
				this.message = userService.authenticateUser(this.username, this.password);
				return null;
			}
		} else {
			this.message = "Please Enter All Value";
			return null;
		}
	}

	public String register() throws Exception {
		if (!user.getUsername().equalsIgnoreCase("") && user.getUsername() != null
				&& !user.getPassword().equalsIgnoreCase("") && user.getPassword() != null)
			this.message = userService.registeruser(user);
		else {
			this.message = "Please Enter All Value";
			user.setFirstname("");
			this.greeting = null;
		}
		return "index.xhtml?faces-redirect=true";
	}

	public String logout() throws Exception {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		return "index.xhtml?faces-redirect=true";
	}

	@PostConstruct
	public void init() {
		userlist = new ArrayList<>();
		userlist.add("userM1");
		userlist.add("userM2");
		userlist.add("userM3");
		adminlist = new ArrayList<>();
		adminlist.add("adminM1");
		adminlist.add("adminM2");
		adminlist.add("adminM3");
		guestlist = new ArrayList<>();
		guestlist.add("guestM1");
		guestlist.add("guestM2");
		guestlist.add("guestM3");
	}
}