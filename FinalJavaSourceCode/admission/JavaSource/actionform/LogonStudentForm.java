package actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class LogonStudentForm extends ValidatorForm{
	
	private String password;
	private String username;
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {

		this.password = null;
		this.username = null;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}


	
}
