package entityBean;
import java.io.*;

import javax.persistence.*;

@Entity @IdClass(PostEntityId.class)
@Table (name = "POST")
public class PostEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column (name = "PID")
	private int Id;
	public int returnID() {		
		return this.Id;
	}
	public void setID(int id){
		this.Id = id;
	}
	
	@Column (name = "ISCOMMENT")
	private boolean isComment;
	public void setIsComment(boolean iscomment){
		this.isComment = iscomment;
	}
	public boolean getIsComment(){
		return this.isComment;
	}
	
	@Column (name = "RATING")
	private int rating;
	public int returnRating(){
		return this.rating;
	}
	public void setRating(int Rating){
		this.rating = Rating;
	}
	
	@Column (name = "CONTENT")
	private String content;
	public String returnContent(){
		return this.content;
	}
	public void setContent(String Content){
		this.content = Content;
	}
	
	@Column (name = "UID")
	private int uid;
	public void setUID(int UID){
		this.uid = UID;
	}
	
	@Column (name = "SID")
	private int sid=2;
	public int getSid(){
		return this.sid;
	}
	public void setSid(int sid){
		this.sid = sid;
	}
	
	@Id
	@Column (name = "TIME")
	private String time;
	public String returnTime(){
		return this.time;
	}
	public void setTime(String Time){
		this.time = Time;
	}
	
	@Id
	@Column (name = "DATE")
	private String date;
	public String returnDate(){
		return this.date;
	}
	public void setDate(String Date){
		this.date = Date;
	}


}
