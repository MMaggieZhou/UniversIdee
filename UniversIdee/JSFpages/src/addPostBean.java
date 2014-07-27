import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import sessionBean.AddPostSessionBean;
import sessionBean.LoginSessionBean;

@ManagedBean(name="addPostBean")
@SessionScoped
public class addPostBean implements Serializable{
	@ManagedProperty("#{login}")
	private LoginBean log;
	public LoginBean getLog(){
		return log;
	}
	public void setLog(LoginBean log){
		this.log = log;
	}
	@EJB
	private AddPostSessionBean addPostSessionBean;
	public String content;
	public int rating;
	public void setContent(final String content){
		this.content = content;
	}
	public void setRating (final int rating){
		this.rating = rating;
	}
	public String getContent(){
		return this.content;
	}
	public int getRating(){
		return this.rating;
	}
	public boolean add(){
		return addPostSessionBean.addPost(log.getUid(),log.getSid(), content,rating);
	}
	
}
 