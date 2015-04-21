// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.0/xslt/JavaClass.xsl

package actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/** 
 * MyEclipse Struts
 * 
 * XDoclet definition:
 * @struts.form name="idForm"
 */
public class IdForm extends ValidatorForm {

	// --------------------------------------------------------- Instance Variables

	/** id property */
	private Long id;

	// --------------------------------------------------------- Methods

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {

		// TODO Auto-generated method stub
	}

	/** 
	 * Returns the id.
	 * @return String
	 */
	public Long getId() {
		return id;
	}

	/** 
	 * Set the id.
	 * @param id The id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

}

