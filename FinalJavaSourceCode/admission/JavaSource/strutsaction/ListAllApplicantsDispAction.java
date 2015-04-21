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
import dao.ApplicantDAO;
import dao.UserDAO;
import edu.utils.FinalConstant;
import model.User;


/**
 * serve for all page using a list of applicants
 * extends DispBaseAction
 * jsp:listAllApplicants.jsp
 * action:listAllApplicantsP
 * form:
 */

public class ListAllApplicantsDispAction extends DispBaseAction {

	public ActionForward all(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) throws Exception {

		ApplicantDAO dao = new ApplicantDAO();
		List applicants = dao.getApplicants();
		request.setAttribute( "applicants", applicants );
		
		return mapping.findForward( "listAllApplicants" );
	}

	public ActionForward ms(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {

			ApplicantDAO dao = new ApplicantDAO();
			List applicants = dao.getMsApplicants();
			request.setAttribute( "applicants", applicants );
			
			return mapping.findForward( "listAllApplicants" );
		}
	
	public ActionForward phd(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {

			ApplicantDAO dao = new ApplicantDAO();
			List applicants = dao.getPhdApplicants();
			request.setAttribute( "applicants", applicants );
			
			return mapping.findForward( "listAllApplicants" );
		}
	
	public ActionForward allPaging(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		
		    int n = 0;
//		    		request.getAttribute(n);
			ApplicantDAO dao = new ApplicantDAO();
			List applicants = dao.getAllApplicantsPaging(n, FinalConstant.PAGINGSTEP);
			request.setAttribute( "applicants", applicants );
			
			return mapping.findForward( "listAllApplicants" );
		}

		public ActionForward msPaging(
				ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response) throws Exception {

			 int n = 0;
//					 request.getAttribute(n);
				ApplicantDAO dao = new ApplicantDAO();
				List applicants = dao.getMsApplicantsPaging(n, FinalConstant.PAGINGSTEP);
				request.setAttribute( "applicants", applicants );
				
				return mapping.findForward( "listAllApplicants" );
			}
		
		public ActionForward phdPaging(
				ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response) throws Exception {

			    int n = 0;
//			    		Integer.parseInt(request.getParameter(String.valueOf(page)));
				ApplicantDAO dao = new ApplicantDAO();
				List applicants = dao.getPhdApplicantsPaging(n, FinalConstant.PAGINGSTEP);
				request.setAttribute( "applicants", applicants );
				
				return mapping.findForward( "listAllApplicants" );
			}
		
		
}

