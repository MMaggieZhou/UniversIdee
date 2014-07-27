package sessionBean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ejb.Stateless;

import entityBean.PostEntity;

/**
 * Session Bean implementation class commentAddedSessionBean
 */
@Stateless
@LocalBean
public class commentAddedSessionBean {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
    public List<List<String>> commentAdded(int UID) {
    	List<List<String>> commentsAdded = new ArrayList<List<String>>();
    	
    	String content;
    	String comment;
    	String time;
    	String date;
    	int postID;
    	
    	List<PostEntity> posts;
    	Query query = em.createNativeQuery
    				("select * from Post where UID like '"+UID+"' and isComment like 'true'", PostEntity.class );

        posts = query.getResultList();
      
        int size = posts.size();
        for (int i=0; i<size; i++){

        	List<String> ct= new ArrayList<String>();
        	PostEntity pe = new PostEntity();
        	PostEntity pt = new PostEntity();
        	pe = posts.get(i);
        	//postID = pe.returnID();
        	//Query findPost = em.createNativeQuery
        			//("select * from Post where pid like '"+postID+"' and isComment like 'false'", PostEntity.class);
        	//pt = (PostEntity) findPost.getResultList().get(0);
        	//comment = pt.returnContent();
        	content = pe.returnContent();
        	time = pe.returnTime();
        	date = pe.returnDate();
        	comment = content;

        	ct.add(comment);
        	ct.add(time);
        	ct.add(date);
        	ct.add(content);
        	
        	commentsAdded.add(ct);
        }
        
        return commentsAdded;
    	

    }


}
