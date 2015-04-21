package strutsaction;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.struts.action.Action;
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



import java.util.Date;
import java.sql.Timestamp;

public class CMApplicantEvaluationActionSubmit extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if(getErrors(request) == null ||getErrors(request).size() == 0)
		{
			CMEvalApplicantForm cme = (CMEvalApplicantForm) form;
			int committeeID = AuthorityUtil.getUser(request).getUid();
			int applicantID = AuthorityUtil.getEvalApplicant(request);
			int score = cme.getTotalScore();
			String comment = cme.getComments();
			String ta = cme.getTa();
			String fe = cme.getFe();
			
			Date date= new java.util.Date();
			Timestamp d = new Timestamp(date.getTime());
			String done = "Y";
			
			CMApplicantListDAO c = new CMApplicantListDAO();
			String result=c.setCommitteeRatings(committeeID,applicantID,score,comment,ta,fe,d,done);
			request.setAttribute( "ResultofQuery", result );
			
			return mapping.findForward("CMAEvaluationSuccess");
		}
			
		else
		{
			return mapping.getInputForward();
		}
	}
	
	
}
