package sessionBean;

import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;

import entityBean.UserEntity;

/**
 * Session Bean implementation class RegisterSessionBean
 */
@Stateless
public class RegisterSessionBean {
	@PersistenceContext(unitName="primary")
	EntityManager em;
    
	public boolean register(String fname, String lname, String email, String username, String password, int university) {	
		boolean isSuccess = false;
		try {
			// Create a new entity
			UserEntity newUser = new UserEntity();
			newUser.setFirstname(fname);
			newUser.setLastname(lname);
			newUser.setEmail(email);
			newUser.setUsername(username);
			newUser.setPassword(password);
			newUser.setSID(university);

			// Persist the new entity
			em.persist(newUser);
			
			// Change boolean to success
			isSuccess = true;
		} catch(Exception e) {
			// Nothing; result is already set to false.
		}
		
		return isSuccess;
	}

}
