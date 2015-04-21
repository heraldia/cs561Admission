package model;

public class StudentAccount extends BaseModel{

private static final long serialVersionUID = -6892646236097552692L;
	
	public StudentAccount(String username, String password){
		super();
		this.username = username;
		this.password = password;
		//this.email = email;
	}

	public StudentAccount(){
		
	}
	
	private		int     applicantId;
	private 	String 	username;
	private 	String 	password;
	//private 	String 	email;
	
	
	
	/*public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	*/
	public int getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	/*public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}*/
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}


