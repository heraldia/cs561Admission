package strutsaction;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import servletsession.AuthorityUtil;

import dao.ApplicantDAO;
import dao.CMApplicantListDAO;
import edu.utils.FinalConstant;
import model.Applicant;
import model.User;
import model.CommitteeRating;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CMCompletedListDispAction extends DispBaseAction {
	
	
	
	public ActionForward all(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
	
		int committeeID = AuthorityUtil.getUser(request).getUid();
		
		CMApplicantListDAO  dao = new CMApplicantListDAO ();
		List capplicants = dao.getCompletedApplicants(committeeID );
		
	
		
		
		
		
		
		request.setAttribute( "completedApplicants", capplicants );
		
		return mapping.findForward( "CMCompletedList" );
   
	
	}
	
	
	public ActionForward MS(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		int committeeID = AuthorityUtil.getUser(request).getUid();

		CMApplicantListDAO  dao = new CMApplicantListDAO ( );
	    List capplicants = dao.getMsCompletedApplicants(committeeID);
		request.setAttribute( "completedApplicants", capplicants );
			
			return mapping.findForward( "CMCompletedList" );
		}
	
	public ActionForward PHD(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		int committeeID = AuthorityUtil.getUser(request).getUid();

		CMApplicantListDAO  dao = new CMApplicantListDAO ();
	    List capplicants = dao.getPhdCompletedApplicants(committeeID );
		request.setAttribute( "completedApplicants", capplicants );
			
		return mapping.findForward( "CMCompletedList" );
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
			request.setAttribute( "completedApplicants", applicants );
			
			return mapping.findForward( "CMCompletedList" );
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
				request.setAttribute( "completedApplicants", applicants );
				
				return mapping.findForward( "CMCompletedList" );
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
				request.setAttribute( "completedApplicants", applicants );
				
				return mapping.findForward( "CMCompletedList" );
			}
		

}
