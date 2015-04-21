package strutsaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentAccount;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import servletsession.AuthorityUtil;
import actionform.StudentRegisterForm;
import dao.StudentAccountDAO;

public class StudentRegisterAction extends BaseAction {

	/*
	 * validates the all the fields when student register for the first time
	 * @param mapping, form, request, response
	 * @return to its respective jsp
	 */

	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			StudentRegisterForm studenRegisterForm = (StudentRegisterForm) form;

			 if("".equals(studenRegisterForm.getUsername()))
		        {
		         addMessage( request, "isuid.empty" );
		         return mapping.getInputForward();
		        }
			 
		        if("".equals(studenRegisterForm.getPassword()))
		        {
		         addMessage( request, "password.empty" );
		         return mapping.getInputForward();
		        }
		        
		        if(!studenRegisterForm.getRepassword().equals(studenRegisterForm.getPassword()))
		        {
		         addMessage( request, "confirm.password.error" );
		         return mapping.getInputForward();
		        }
		        
		        /*if("".equals(studenRegisterForm.getEmail()))
		        {
		         addMessage( request, "email.empty" );
		         return mapping.getInputForward();
		        }*/
		        
		                
		                
			
			StudentAccount st = new StudentAccount();
			st.setUsername( studenRegisterForm.getUsername() );
			st.setPassword( studenRegisterForm.getPassword() );
			//st.setEmail( studenRegisterForm.getEmail() );
						
			StudentAccountDAO dao = new StudentAccountDAO();
			dao.saveStudentAccount( st );
			
			AuthorityUtil.saveStudentAccount( request, st );
			
			return mapping.findForward("studentlogin");
		}


			
			
		

}
