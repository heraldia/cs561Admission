package strutsaction;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import servletsession.AuthorityUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *     this class is to execute the function of logout and remove all the information in the session
 */

public class StudentLogoutAction extends BaseAction {
    
/*
 * clears all the cache and session when applicant logout
 * @mapping, form, request, response
 * @return to its respective jsp
 */



    public ActionForward execute(ActionMapping mapping, ActionForm  form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {

        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Cache-Control","no-store");
        response.setDateHeader("Expires", 0);
        response.setHeader("Pragma","no-cache");

        AuthorityUtil.removeStudentAccount(request);
        return mapping.findForward("studentlogin");

    }
}
