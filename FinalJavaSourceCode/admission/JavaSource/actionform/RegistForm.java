//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.0/xslt/JavaClass.xsl

package actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/** 
 * MyEclipse Struts
 * Creation date: 07-22-2006
 * 
 * XDoclet definition:
 * @struts.form name="registForm"
 */
public class RegistForm extends ValidatorForm {

	// --------------------------------------------------------- Instance Variables
    
	/** isuid property */
	private String username;
	
	/** password property */
	private String password;

	/** repassword property */
	private String repassword;
	private String email;
	private String firstname;
	private int category;

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
		this.email = null;
		this.firstname = null;
		this.category = -1;
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

