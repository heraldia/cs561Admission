
package actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/** 
 */
public class AddDecisionForm extends IdForm {

	// --------------------------------------------------------- Instance Variables

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** title property */
	private String decision;
	private int   applicantId;

	// --------------------------------------------------------- Methods

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		this.decision = null;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
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

