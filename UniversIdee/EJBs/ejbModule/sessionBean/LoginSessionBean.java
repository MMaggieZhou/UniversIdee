package sessionBean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ejb.Stateless;

import entityBean.UserEntity;


@Stateless
public class LoginSessionBean {
	@PersistenceContext(unitName="primary")
	EntityManager em;
    
	@SuppressWarnings("unchecked")
	public List<String> login(String username, String password) {
		List<String> result=new ArrayList<String>();
		result.add("fail");
		
		// Create list to hold query results
		List<UserEntity> loginList;
		
		try {
			Query query = em.createNativeQuery("select * from USER where USERNAME like '" + username + "'" + " and PASSWORD like '" + password + "'", UserEntity.class);
			loginList = query.getResultList();
			// Check if any users were found in the database
			if (!loginList.isEmpty())
			{
				result.set(0, "success");
				UserEntity u = new UserEntity();
				u=loginList.get(0);
				result.add(u.getUsername());
				result.add(Integer.toString(u.getSID()));
				result.add(Long.toString(u.getUID()));
			}
		} catch(Exception e) {
			// Nothing; result is already set to fail.
		}
		
		// Return if a user matched.
		return result;
	}
}
