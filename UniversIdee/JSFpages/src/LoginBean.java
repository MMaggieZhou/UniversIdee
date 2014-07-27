import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import sessionBean.LoginSessionBean;
import sessionBean.UniversitySessionBean;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

@ManagedBean (name = "login")
@SessionScoped
public class LoginBean implements Serializable {
	private static Logger logger = Logger.getLogger("com.univeridee.LoginBean");
	private static FileHandler fh;
	private String username;
	private String password;
	private String university;
	private int uid;
	private int sid;
	@EJB
	private LoginSessionBean loginSession;
	@EJB
	private UniversitySessionBean Univ;
	
	public String login() {
		String[] params = new String[2];
		params[0] = username;
		params[1] = password;
		List<String> result = new ArrayList<String>();
		
		// Log the login attempt to file
		try {
			if (fh == null) {
				fh = new FileHandler("UniversIdeeLog.txt");
				fh.setFormatter(new SimpleFormatter());
				logger.addHandler(fh);
				logger.setLevel(Level.ALL);
				logger.entering("LoginBean", "login", params);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Attempt to login
		result = loginSession.login(username, password);
		logger.exiting("LoginBean", "login", result);
		
		// Return true if successful, false otherwise
		String toReturn = "false";
		if (result.get(0).equalsIgnoreCase("success")) {
			toReturn = "true";
			this.username = result.get(1);
			this.sid =Integer.parseInt(result.get(2));
			this.university = Univ.getName(sid);
			this.uid = Integer.parseInt(result.get(3));
			
		}
		//instantiate university and uid is login is successful
		
		return toReturn;
	}
	public String getUniversity(){
		return university;
	}
	public void setUniversity(String university){
		this.university=university;
	}
	public void setUid(int uid){
		this.uid = uid;
	}
	public int getUid(){
		return uid;
	}
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public int getSid(){
		return sid;
	}
	public void setSid(int sid){
		this.sid = sid;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
