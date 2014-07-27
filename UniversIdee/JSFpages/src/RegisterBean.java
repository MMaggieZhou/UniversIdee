import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import sessionBean.RegisterSessionBean;

@ManagedBean (name = "register")
@RequestScoped

public class RegisterBean {
	private String firstname;
	private String lastname;
	private String email;
	private int university;
	private String username;
	private String password;
	
	@EJB
	private RegisterSessionBean registerSession;
	
	public boolean register() {
		return registerSession.register(firstname, lastname, email, username, password, university);
	}
	
	// Getters and setters
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String fname) {
		this.firstname = fname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lname) {
		this.lastname = lname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getUniversity() {
		return university;
	}
	
	public void setUniversity(int univ) {
		this.university = univ;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String user) {
		this.username = user;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String pass) {
		this.password = pass;
	}
}
