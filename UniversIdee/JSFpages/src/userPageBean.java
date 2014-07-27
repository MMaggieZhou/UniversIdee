import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import sessionBean.commentAddedSessionBean;
import sessionBean.postAddedSessionBean;

@ManagedBean
@SessionScoped
public class userPageBean {
	private List<List<String>> posts;
	private List<List<String>> comments;
	//private LoginBean lb;
	//private int uid = lb.getUid();

	@ManagedProperty("#{login}")
	private LoginBean log;
	public LoginBean getLog(){
		return log;
	}
	public void setLog(LoginBean log){
		this.log = log;
	}
	@EJB
	private postAddedSessionBean PostAddedSessionBean;
	@EJB
	private commentAddedSessionBean CommentAddedSessionBean;
	
	public List<List<String>> Posts(){
		return PostAddedSessionBean.postAdded(log.getUid());
	}
	public List<List<String>> Comments(){
		return CommentAddedSessionBean.commentAdded(log.getUid());
	}
	
}
