//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.0/xslt/JavaClass.xsl

package strutsaction;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sun.org.apache.xerces.internal.impl.dv.ValidatedInfo;

import servletsession.AuthorityUtil;
import dao.UserDAO;

import model.User;
import actionform.RegistForm;

/** 
 * MyEclipse Struts
 * XDoclet definition:
 * @struts.action path="/regist" name="registForm" input="/regist.jsp" scope="request" validate="true"
 */
public class RegistAction extends BaseAction {

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
		RegistForm registForm = (RegistForm) form;

		 if("".equals(registForm.getUsername()))
	        {
	         addMessage( request, "isuid.empty" );
	         return mapping.getInputForward();
	        }
		 
	        if("".equals(registForm.getPassword()))
	        {
	         addMessage( request, "password.empty" );
	         return mapping.getInputForward();
	        }
	        
	        if(!registForm.getRepassword().equals(registForm.getPassword()))
	        {
	         addMessage( request, "confirm.password.error" );
	         return mapping.getInputForward();
	        }
	        
	        if("".equals(registForm.getEmail()))
	        {
	         addMessage( request, "email.empty" );
	         return mapping.getInputForward();
	        }
	        
	        if("".equals(registForm.getFirstname()))
	        {
	         addMessage( request, "first.empty" );
	         return mapping.getInputForward();
	        }
	        
	        if(registForm.getCategory()==-1)
	        {
	         addMessage( request, "category.empty" );
	         return mapping.getInputForward();
	        }	        
		
		User user = new User();
		user.setUsername( registForm.getUsername() );
		user.setPassword( registForm.getPassword() );
		user.setEmail( registForm.getEmail() );
		user.setFirstname( registForm.getFirstname());
		user.setCategory( registForm.getCategory() );
		
		UserDAO dao = new UserDAO();
		dao.saveUser( user );
		
		AuthorityUtil.saveUser( request, user );
		
		return mapping.findForward("index");
	}


		
		
	
}

