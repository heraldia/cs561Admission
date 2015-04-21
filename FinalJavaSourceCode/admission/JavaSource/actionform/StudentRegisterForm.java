package actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import exception.PasswordErrorException;

public class StudentRegisterForm extends IdForm{

	private String username;
	private String password;
	private String repassword;
	//private String email;
	

	// --------------------------------------------------------- Methods

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {

		this.username = null;
		this.password = null;
		this.repassword = null;
		//this.email = null;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	/*public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
*/
		
	/*
	 * checks whether the password matches with the re-password
	 * @return void
     */
	public void  validate() {
        if(!password.equals(repassword)){
        	throw new PasswordErrorException("Confirm password error!");
        }
	}
}
