/* done by Kim Ni Wang */

package strutsaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Applicant;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.ApplicantDAO;
import actionform.ApplicationForm;

public class ApplicationFormAction extends BaseAction{
	
	/*
	 * access the database using objects
	 * @param mapping, form, request, response
	 * @return forward to its respective jsp.
	 */
	public ActionForward execute(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception {
	
	
	// extract the form here
	ApplicationForm applicationForm = (ApplicationForm)form;
	
	
	// database access object         
    ApplicantDAO dao = new ApplicantDAO();   
	  
    
    // gets the max id from the database and increments it by 1
    // reason we dont use rand , is for loss of efficiency in time
    int applicantId = dao.getLastId() + 1;
    
    // make a new instance of the applicant and populate the database
    Applicant st = new Applicant();   
    
	st.setApplicantId(applicantId);
	st.setNameLast( applicationForm.getLastname());
	st.setNameFirst( applicationForm.getFirstname());
	st.setNameMiddle( applicationForm.getMiddlename() );
	st.setEmail( applicationForm.getEmail() );
	st.setPermanentCountry( applicationForm.getCountry());
	st.setGender( applicationForm.getGender() );
	st.setCitizenCountry(applicationForm.getCitizen_country());
	st.setGreVerbalScore( applicationForm.getGre_verbal() );
	st.setGreQuantitativeScore( applicationForm.getGre_quantitative() );
	st.setGreWritingScore( applicationForm.getGre_analytical() );
	st.setToeflScore( applicationForm.getToefl() );
	st.setIeltsScore( applicationForm.getIelts() );
	st.setDegreeSought( applicationForm.getDegree() );
	st.setResearchInterest( applicationForm.getResearch_interest() );
	st.setStatement( applicationForm.getStmt_purpose());
	st.setReferenceName1( applicationForm.getReference1() );
	st.setReferenceName2( applicationForm.getReference2() );
	st.setReferenceName3( applicationForm.getReference3() );
	st.setEthnic( applicationForm.getEthnic() );
	
	dao.saveApplicant( st );
	
	return mapping.findForward("valueEnteredSuccessfully");  
	
	} 
	   
 
}
