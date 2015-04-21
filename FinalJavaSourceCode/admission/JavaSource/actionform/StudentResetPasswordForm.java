/* done by Kim Ni Wang  */

package actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import exception.PasswordErrorException;

public class StudentResetPasswordForm extends ValidatorForm {

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

    /*
     * checks whether the new password matches with the confirm password
     * @return void
     */
	public void  validate() {
        if(!newPassword.equals(newRepassword)){
        	throw new PasswordErrorException("Confirm password error!");
        }
	}
}
