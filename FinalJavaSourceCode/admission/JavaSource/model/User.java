package model;

import java.util.Set;



public class User extends BaseModel {

	/**
	 * The Generated SerialVersionUID
	 */
	private static final long serialVersionUID = -6892646236097552692L;
	
	private 	int 	uid;
	private 	String 	username;
	private 	String 	password;
	private 	String 	email;
	private 	String 	firstname;
	private 	int 	category;

	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	

}
