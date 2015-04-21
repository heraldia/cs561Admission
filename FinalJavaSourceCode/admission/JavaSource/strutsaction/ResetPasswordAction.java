package strutsaction;


import model.User;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionform.ResetPasswordForm;

import dao.UserDAO;

import servletsession.AuthorityUtil;
import servletsession.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *   this class is to reset the password
 */
public class ResetPasswordAction extends BaseAction {
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


        UserInfo ui = AuthorityUtil.getUser(request);
        if( ui==null ) {
            addMessage( request, "error.login.first" );
            return mapping.findForward( "index" );
        }
        UserDAO dao = new UserDAO();
        User user = dao.getUserById( ui.getUserId());
        ResetPasswordForm reset = (ResetPasswordForm) form;
//        reset.validate(); //phil
        
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
        
        if(reset.getOriginalPassword().equals(user.getPassword()))
        {
         user.setPassword(reset.getNewPassword());
         dao.updateUser(user);
         return mapping.findForward("login_success");
        }
        else
        {
         addMessage( request, "reset.failed" );
         return mapping.getInputForward();
        }
        
     
        
	}


}
