//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.0/xslt/JavaClass.xsl

package strutsaction;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import dao.ApplicantDAO;
import dao.NoteDAO;
import model.Applicant;
import model.CommitteeRating;
import model.Note;
import model.User;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionform.AddNoteForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * jsp:listNotes.jsp
 * action:listNotes.do
 * form:addNoteForm
 */
public class AddNoteAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		AddNoteForm addNoteForm = (AddNoteForm) form;

		Note note = new Note();
		note.setNote(addNoteForm.getNote());
		note.setDate(new Timestamp(System.currentTimeMillis()));

		ApplicantDAO applicantDAO = new ApplicantDAO();
		Applicant applicant = applicantDAO.getApplicant(addNoteForm.getApplicantId());
		NoteDAO noteDao = new NoteDAO();

		noteDao.saveNote(note);
		applicant.setNote(note);
		
		if(applicant.getRating()!=null){
			Iterator<CommitteeRating> itera = applicant.getRating().iterator();
			  while(itera.hasNext()){
			   itera.next().setUnDone();
			}
		}
//		applicant.getCommitteeRating().get(0).setUnDone();
//		applicant.getCommitteeRating().get(1).setUnDone();
		applicantDAO.updateApplicant(applicant);
		
		List applicants = applicantDAO.getApplicants();
		request.setAttribute("applicants", applicants);
		String nullString = null;
//		note.setNote(nullString);
		request.setAttribute("note", nullString);
		
		return mapping.findForward("listNote");
//		return mapping.findForward("login_success");
	}

}
