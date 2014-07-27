package sessionBean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entityBean.PostEntity;
import entityBean.UniversityEntity;

/**
 * Session Bean implementation class UniversitySessionBean
 */
@Stateless
public class UniversitySessionBean {
	@PersistenceContext(unitName = "primary")
	private  EntityManager em;
	
	public String getName(int uid){
		String name;
		List<UniversityEntity> univs;//obtain results from database
		UniversityEntity u = new UniversityEntity();
    	Query query = em.createNativeQuery("select * from University where SID like '"+uid+"'", UniversityEntity.class);    	       
    	univs = query.getResultList();
    	u = univs.get(0);
    	name = u.getUniversitname();
		return name;
	}
}
