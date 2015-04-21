/* done by Kim Ni Wang */

package strutsaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentAccount;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import servletsession.AuthorityUtil;
import actionform.LogonStudentForm;
import dao.StudentAccountDAO;

public class LogonStudentAction extends BaseAction{

	/*
	 * validates the username and password of the applicants 
	 * @mapping, form, request, response
	 * @return to its respective jsp
	 */
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception{

			LogonStudentForm logonStudentForm = (LogonStudentForm)form;
			
			StudentAccountDAO dao = new StudentAccountDAO();
			StudentAccount st = dao.getStudentAccount(logonStudentForm.getUsername() );
			if( st!=null && st.getPassword().equals( logonStudentForm.getPassword() ) ) {
				
				AuthorityUtil.saveStudentAccount( request, st );
				
				System.out.println();
				return mapping.findForward( "login_success" );
			}
			addMessage( request, "logonStudent.failed" );
			
			return mapping.getInputForward();

		}

}
