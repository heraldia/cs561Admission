//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.0/xslt/JavaClass.xsl

package strutsaction;

import java.sql.Timestamp;
import java.util.List;

import dao.ApplicantDAO;
import dao.NoteDAO;
import model.Applicant;
import model.Note;
import model.User;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionform.AddNoteForm;
import actionform.LikeStringSearchForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Search an applicant who contains the "like" String
 */
public class LikeStringSearchAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		LikeStringSearchForm likeStringSearchForm = (LikeStringSearchForm) form;

		String likeString =	"a";
		likeString =	likeStringSearchForm.getLikeString();
		System.out.println(likeString);
		ApplicantDAO applicantDAO = new ApplicantDAO();
		List<Applicant> applicants = applicantDAO.getApplicantsByLikeList(likeString);
		
		request.setAttribute("applicants", applicants);
		
		return mapping.findForward("listAllApplicants");
//		return mapping.getInputForward();
	}

}
