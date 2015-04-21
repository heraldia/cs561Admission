package actionform;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import exception.PasswordErrorException;

import javax.servlet.http.HttpServletRequest;


public class ResetPasswordForm extends ValidatorForm {

	private String originalPassword;
    private String newPassword;
    private String newRepassword;

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.originalPassword = null;
		this.newPassword = null;
        this.newRepassword= null;

	}


    public String getOriginalPassword() {
        return originalPassword;
    }

    public void setOriginalPassword(String originalPassword) {
        this.originalPassword = originalPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }


    public String getNewRepassword() {
        return newRepassword;
    }

    public void setNewRepassword(String newRepassword) {
        this.newRepassword = newRepassword;
    }


	public void  validate() {
        if(!newPassword.equals(newRepassword)){
        	throw new PasswordErrorException("Confirm password error!");
        }
	}
}