package com.yash.tmp.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.yash.tmp.model.User;
import com.yash.tmp.service.UserServiceLocal;

@ManagedBean
@SessionScoped
public class UserBean {

	// @Inject
	User user = new User();

	@EJB
	UserServiceLocal userService;

	private String message;

	private String greeting;

	private boolean rememberUser;

	private String timer;

	private String username;

	private String password;

	private List<String> menulist ;
	private List<String> userlist = new ArrayList<>();
	private List<String> adminlist = new ArrayList<>();
	private List<String> guestlist = new ArrayList<>();

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
				return "welcome.xhtml?faces-redirect=true";
			} else {
				HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
						.getSession(false);
				session.invalidate();
				this.greeting = null;
				return "index.xhtml?faces-redirect=true";
			}
		} else {
			this.greeting = null;
			this.message = "Please Enter All Value";
			return "index.xhtml?faces-redirect=true";
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
