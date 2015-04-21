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

public class LogoutAction extends BaseAction {
    /**
     * this method is to execute the function of logout and remove all the information in the session
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return    forward to the page of login
     * @throws Exception
     */


    public ActionForward execute(ActionMapping mapping, ActionForm  form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {

        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Cache-Control","no-store");
        response.setDateHeader("Expires", 0);
        response.setHeader("Pragma","no-cache");


        AuthorityUtil.removeUser(request);
        return mapping.findForward("login");

    }
}