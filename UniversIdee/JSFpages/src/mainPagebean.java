import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import sessionBean.postAddedSessionBean;

@ManagedBean
@RequestScoped
public class mainPagebean {
	@EJB
	private postAddedSessionBean PostAddedSessionBean;
	
	public List<List<String>> Post(){
		return PostAddedSessionBean.posts();
	}
}
