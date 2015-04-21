//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.0/xslt/JavaClass.xsl

package strutsaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import servletsession.AuthorityUtil;

import dao.UserDAO;
import model.User;

import actionform.LogonForm;

/** 
 * jsp:index.jsp
 * action:logonForm
 * form:logonForm
 * @struts.action validate="true"
 */
public class LogonAction extends BaseAction {

	// --------------------------------------------------------- Instance Variables

	// --------------------------------------------------------- Methods

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) throws Exception{

		LogonForm logonForm = (LogonForm)form;
		
		UserDAO dao = new UserDAO();
		User user = dao.getUser( logonForm.getUsername() );
		if( user!=null && user.getPassword().equals( logonForm.getPassword() ) ) {
			
			AuthorityUtil.saveUser( request, user );
//			request.getSession().setAttribute("category", user.getCategory());
//			request.getSession().setAttribute("uid", user.getUid());
//			request.getSession().setAttribute("name", user.getUsername());
			
			
//			request.setAttribute("category", user.getCategory());
//			request.setAttribute("uid", user.getUid());
//			request.setAttribute("name", user.getUsername());
			
			return mapping.findForward( "login_success" );
		}
		addMessage( request, "logon.failed" );
		
		return mapping.getInputForward();
//		return mapping.findForward( "logon" );  //empty page ??
	}

}

