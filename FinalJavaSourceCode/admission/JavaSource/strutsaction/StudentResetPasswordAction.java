package strutsaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentAccount;
import model.User;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import servletsession.AuthorityUtil;
import servletsession.StudentInfo;
import servletsession.UserInfo;
import actionform.ResetPasswordForm;
import actionform.StudentResetPasswordForm;
import dao.StudentAccountDAO;
import dao.UserDAO;

public class StudentResetPasswordAction extends BaseAction {
    /**
     * this method is to reset the password
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return            return to the page of homepage
     * @throws Exception
     */
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	        throws Exception{


        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Cache-Control","no-store");
        response.setDateHeader("Expires", 0);
        response.setHeader("Pragma","no-cache");


        StudentInfo si = AuthorityUtil.getStudentAccount(request);
        if( si==null ) {
            addMessage( request, "error.login.first" );
            return mapping.findForward( "index" );
        }
        StudentAccountDAO dao = new StudentAccountDAO();
        StudentAccount st = dao.getStudentAccountById( si.getStudentId());
        StudentResetPasswordForm reset = (StudentResetPasswordForm) form;

        
        if("".equals(reset.getNewPassword()))
        {
         addMessage( request, "password.empty" );
         return mapping.getInputForward();
        }
        
        if(!reset.getNewPassword().equals(reset.getNewRepassword()))
        {
         addMessage( request, "confirm.password.error" );
         return mapping.getInputForward();
        }
        
        if(reset.getOriginalPassword().equals(st.getPassword()))
        {
         st.setPassword(reset.getNewPassword());
         dao.updateUser(st);
         return mapping.findForward("login_success");
        }
        else
        {
         addMessage( request, "reset.failed" );
         return mapping.getInputForward();
        }
        
     
        
	}


}
