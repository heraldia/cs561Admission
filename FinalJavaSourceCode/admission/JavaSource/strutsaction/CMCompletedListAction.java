package strutsaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.ApplicantDAO;

public class CMCompletedListAction extends BaseAction {
	
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
	
  
		ApplicantDAO dao = new ApplicantDAO();
		List applicants = dao.getApplicants();
		request.setAttribute( "completedApplicants", applicants );
		
		return mapping.findForward( "CMCompletedList" );
   
	
	}

}
