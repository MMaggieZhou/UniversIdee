package entityBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UNIVERSITY")
public class UniversityEntity {
	@Id
	@Column(name="SID")
	private int sid;
	public long getSid(){
		return this.sid;
	}
	
	public void setSid(int SID){
		this.sid = SID;
	}
	
	@Column(name="NAME")
	private String universityname;
	public String getUniversitname() {
		return universityname;
	}

	public void setUniversitname(String universityname) {
		this.universityname = universityname;
	}
	
	@Column(name="DOMAINADDRESS")
	private String address;
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
