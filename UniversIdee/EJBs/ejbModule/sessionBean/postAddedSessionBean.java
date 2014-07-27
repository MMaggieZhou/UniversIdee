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
 * Session Bean implementation class postAddedSessionBean
 */
@Stateless
@LocalBean
public class postAddedSessionBean {
	@PersistenceContext(unitName = "primary")
	private  EntityManager em;
	public List<List<String>> posts(){
		List<List<String>> Posts = new ArrayList<List<String>>();
		String content;
    	int rating;
    	String time;
    	String date;
    	
    	List<PostEntity> posts;//obtain results from database
    	Query query = em.createNativeQuery("select * from Post where isComment like 'false' and rating > 3", PostEntity.class);    	       
    	posts = query.getResultList();
        int size = posts.size();
        for (int i=0; i<size; i++){
        	List<String> post= new ArrayList<String>();
        	PostEntity pe = new PostEntity();
        	pe = posts.get(i);
        	content = pe.returnContent();
        	rating = pe.returnRating();
        	time = pe.returnTime();
        	date = pe.returnDate();
        	post.add(content);
        	post.add(Integer.toString(rating));
        	post.add(time);
        	post.add(date);
        	Posts.add(post);
        }
        return Posts;
	}
    @SuppressWarnings("unchecked")
	public List<List<String>> postAdded(int UID) {
    	List<List<String>> postsAdded = new ArrayList<List<String>>();//to be passed to servlet
    	
    	String content;
    	int rating;
    	String time;
    	String date;
    	
    	List<PostEntity> posts;//obtain results from database
    	Query query = em.createNativeQuery("select * from Post where UID like '"+UID+"' and isComment like 'false'", PostEntity.class);
    	       
    	posts = query.getResultList();
        int size = posts.size();
        for (int i=0; i<size; i++){
        	List<String> post= new ArrayList<String>();
        	PostEntity pe = new PostEntity();
        	pe = posts.get(i);
        	content = pe.returnContent();
        	rating = pe.returnRating();
        	time = pe.returnTime();
        	date = pe.returnDate();
        	post.add(content);
        	post.add(Integer.toString(rating));
        	post.add(time);
        	post.add(date);
        	postsAdded.add(post);
        }
        /*    
    	if (size==0){
    		List<String> post= new ArrayList<String>();
    		post.add("not a tupple found");
    		post.add("n/a");
    		post.add("n/a");;
    		post.add("n/a");
    		postsAdded.add(post);
    		return postsAdded;
    	}else return postsAdded;
    	*/
        return postsAdded;
    }

}
