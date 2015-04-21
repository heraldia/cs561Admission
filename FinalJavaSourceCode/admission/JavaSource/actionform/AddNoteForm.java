// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.0/xslt/JavaClass.xsl

package actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/** 
 */
public class AddNoteForm extends IdForm {

	// --------------------------------------------------------- Instance Variables

	/** title property */
	private String note;
	private int   applicantId;

	// --------------------------------------------------------- Methods

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		this.note = null;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return the applicantId
	 */
	public int getApplicantId() {
		return applicantId;
	}

	/**
	 * @param applicantId the applicantId to set
	 */
	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

}

