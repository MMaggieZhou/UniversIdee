package entityBean;
import java.io.Serializable;

public class PostEntityId implements Serializable {
	int Id;
	String date;
	String time;
	public PostEntityId(){
		
	}
	public int hashCode(){
		return super.hashCode();
	}
	public boolean equals(Object other){

		PostEntityId celalalt = (PostEntityId)other;
		return(celalalt.Id ==Id&&celalalt.date ==date&&celalalt.time ==time);
		
	}
}
