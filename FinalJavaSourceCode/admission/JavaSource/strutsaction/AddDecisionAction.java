//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.0/xslt/JavaClass.xsl

package strutsaction;

import java.sql.Timestamp;
import java.util.List;

import dao.ApplicantDAO;
import dao.DecisionDAO;
import model.Applicant;
import model.Decision;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionform.AddDecisionForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * jsp:listDecisions.jsp
 * action:listDecisions.do
 * form:addDecisionForm
 */
public class AddDecisionAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		AddDecisionForm decisionForm = (AddDecisionForm) form;

		Decision decision = new Decision();
		decision.setAdmit(decisionForm.getDecision());
		decision.setDate(new Timestamp(System.currentTimeMillis()));

		ApplicantDAO applicantDAO = new ApplicantDAO();
		Applicant applicant = applicantDAO.getApplicant(decisionForm.getApplicantId());
		DecisionDAO decisionDAO = new DecisionDAO();

		decisionDAO.saveDecision(decision);
		applicant.setDecision(decision);
//		applicant.getCommitteeRating().get(1).setUnDone();
//		applicantDAO.updateApplicant(applicant);
		
		List applicants = applicantDAO.getApplicants();
		request.setAttribute("applicants", applicants);
		String nullString = null;
		request.setAttribute("decision", nullString);
		
//		int totalScore = 0;
//		totalScore = applicant.getRating().get(0).getTotalScore()+applicant.getRating().get(1).getTotalScore()}
		
	    return mapping.findForward("listDecision");
//		return mapping.findForward("login_success");
//		return mapping.findForward("test");
	}

}
