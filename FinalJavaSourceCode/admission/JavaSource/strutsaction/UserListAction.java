//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.0/xslt/JavaClass.xsl

package strutsaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import servletsession.UserInfo;
import servletsession.AuthorityUtil;
import dao.UserDAO;
import model.User;


/** 
 * 
 * XDoclet definition:
 * @struts.action input="/userlist.jsp"
 */
public class UserListAction extends BaseAction {

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
		HttpServletResponse response) throws Exception {

		UserDAO dao = new UserDAO();
		List users = dao.getUserByList();
		request.setAttribute( "users", users );
		
//		System.out.println(users);
		
		return mapping.findForward( "userlist" );
	}

}

