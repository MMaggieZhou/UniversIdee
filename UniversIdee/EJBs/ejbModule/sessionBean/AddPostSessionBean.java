package sessionBean;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ejb.Remote;
import javax.ejb.Local;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.ejb.Stateless;

import entityBean.PostEntity;



@Stateless

public class AddPostSessionBean {
	
	@PersistenceContext(unitName="primary")
	EntityManager em;

	public boolean addPost(int UID, int SID,String content, int rating) {
		boolean IsComment = false;
		String Time = CurrentTime();
		String Date = CurrentDate();
		
	    try {
	    	PostEntity newEntity = new PostEntity();
	    	newEntity.setContent(content);
	    	newEntity.setSid(SID);
	    	newEntity.setDate(CurrentDate());
	    	newEntity.setIsComment(false);
	    	newEntity.setRating(rating);
	    	newEntity.setTime(CurrentTime());
	    	newEntity.setUID(UID);
	    	em.persist(newEntity);
	    	return true;
		}catch(Exception e){
            throw new EJBException(e);
		}
	}
	public String CurrentTime(){
		Calendar cal= Calendar.getInstance();
		//cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(cal.getTime());
	}
	public String CurrentDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}

}
