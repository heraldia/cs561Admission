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
import model.Applicant;
import model.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import actionform.CMEvalApplicantForm;




public class CMApplicantListAction extends BaseAction {
	
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
	
  
		ApplicantDAO dao = new ApplicantDAO();
		List applicants = dao.getApplicants();
		request.setAttribute( "applicants", applicants );
		
		return mapping.findForward( "CMApplicantsList" );
   
	
	}
	
	
	

}
