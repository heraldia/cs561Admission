/* done by Kim Ni Wang */

package strutsaction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Applicant;
import model.RangeEval;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.ReportDAO;

/*
 * retrieves the number of applicants, female applicants, score distribution
 * @param mapping, form, response, request
 * @return to its respective jsp
 */
public class ReportAction extends DispBaseAction {
	public ActionForward getData( ActionMapping mapping, ActionForm form, 
			  HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		ReportDAO dao =  new  ReportDAO();
		
		long noOfApplicants 					= dao.getNumOfApplicants();
		List<Applicant> applicantList 			= dao.getAllApplicants();
		long noOfMinorApplicants 				= dao.getNumOfMinorCitizens();
		List<Applicant> minorApplicants			= dao.getAllMinorCitizens();
		long noOfUsCitizenApplicants 			= dao.getNumOfUSCitizen();
		List<Applicant> applicantUsCitizen		= dao.getAllUSCitizen();
		long noOfWomenApplicants 			 	= dao.getNumOfWomen();
		List<Applicant> applicantWomen 			= dao.getAllOfWomen();
		double avgGreVerbalScore 				= dao.getAvgGreVerbalScore();
		double avgGreQuantScore					= dao.getAvgGreQuantScore();
		List rangeEval 							= dao.getRangeEvalScores();
		
		
		ArrayList<RangeEval> rangeEvalList 		= new ArrayList<RangeEval>() ;
		RangeEval rangeEvalObj;
		for(int i = 0 , j = 0 ; i < 10 ; i ++){
			rangeEvalObj = new RangeEval();
			rangeEvalObj.range = "" + (i * 10) + "-" + (i* 10 + 9);
			rangeEvalObj.count = 0;
			while(j < rangeEval.size() && Integer.parseInt(((Object[])rangeEval.get(j))[0].toString().split("-")[0]) == i*10){
				rangeEvalObj.count++;
				j++;
			}
			rangeEvalList.add(rangeEvalObj);
		}
		
		
		request.setAttribute("roundStatistics", "set");
		request.setAttribute("noOfApplicants", noOfApplicants);
		request.setAttribute("applicantList", applicantList);
		request.setAttribute("noOfMinorApplicants", noOfMinorApplicants);
		request.setAttribute("minorApplicants", minorApplicants);
		request.setAttribute("noOfUsCitizenApplicants", noOfUsCitizenApplicants);
		request.setAttribute("applicantUsCitizen", applicantUsCitizen);
		request.setAttribute("noOfWomenApplicants", noOfWomenApplicants);
		request.setAttribute("applicantWomen", applicantWomen);
		request.setAttribute("avgGreVerbalScore", avgGreVerbalScore);
		request.setAttribute("avgGreQuantScore", avgGreQuantScore);
		request.setAttribute("rangeEval", rangeEvalList);
		
		

		return mapping.findForward("success");
		
			
	}
}
