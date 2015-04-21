//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.0/xslt/JavaClass.xsl

package strutsaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import servletsession.UserInfo;
import servletsession.AuthorityUtil;
import dao.ApplicantDAO;
import dao.UserDAO;
import model.User;


/**
 * serve for all page using a list of applicants
 * jsp:listAllApplicants.jsp
 * action:listAllApplicants
 * form:
 */

public class ListAllApplicantsAction extends BaseAction {

	// --------------------------------------------------------- Instance Variables

	// --------------------------------------------------------- Methods

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) throws Exception {

		ApplicantDAO dao = new ApplicantDAO();
		List applicants = dao.getApplicants();
		request.setAttribute( "applicants", applicants );
		
		return mapping.findForward( "listAllApplicants" );
	}

}

