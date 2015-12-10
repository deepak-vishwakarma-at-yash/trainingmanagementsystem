package com.yash.tmp.bean;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;

import com.yash.tmp.model.User;
import com.yash.tmp.service.CoursesService;
import com.yash.tmp.service.CoursesServiceLocal;


@ManagedBean
@SessionScoped
public class TraineeBean {

	public TraineeBean() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	this.user = (User)session.getAttribute("user");
	}
	
	//@EJB
	CoursesServiceLocal coursesService = new CoursesService();
	
	private String message;

	private Part file;

	User user = new User();
	
	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String uploadFile() throws Exception {
		// -----------code to upload file--------------
		Part uploadedFile = getFile();

		File file = new java.io.File("C:/Users/Deepak.Vishwakarma/Downloads/tmpp/tmp/WebContent/resources/upload/");
		String abspath = file.getAbsolutePath();

		final Path destination = Paths.get(abspath + "/" + FilenameUtils.getName(getSubmittedFileName(uploadedFile)));
		InputStream bytes = null;

		if (null != uploadedFile) {
			String filename = FilenameUtils.getName(getSubmittedFileName(uploadedFile));
			coursesService.uploadFileName(filename , user);			
			bytes = uploadedFile.getInputStream(); //
			Files.copy(bytes, destination);
		}

		// ------------------code to upload end--------------
		return null;
	}
	// -----------------helper method for file upload---------------------

	public static String getSubmittedFileName(Part filePart) {
		String header = filePart.getHeader("content-disposition");
		if (header == null)
			return null;
		for (String headerPart : header.split(";")) {
			if (headerPart.trim().startsWith("filename")) {
				return headerPart.substring(headerPart.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
	// -----------------helper method for file upload end---------------------

}
