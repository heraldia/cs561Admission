/* done by Kim Ni Wang */

package strutsaction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import dao.CommitteeProgressDAO;
import model.CommitteeProgress;

public class CommitteeProgressAction extends DispatchAction {

	/*
	 * retrieves the list of total MS and PhD applicants, number of reviews completed for MS and PhD applicants, list of committee members names
	 * @param mapping,form,request,response
	 * @return forward to its respective jsp
	 */
	public ActionForward getCP( ActionMapping mapping, ActionForm form, 
							  HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		
		CommitteeProgressDAO dao = new CommitteeProgressDAO();
		List msTotal = dao.getCommitteeProgressMSTotal();
		List phdTotal = dao.getCommitteeProgressPHDTotal();
		
		List msDone = dao.getCommitteeProgressMSDone();
		List phdDone = dao.getCommitteeProgressPHDDone();
		
		List committeeUsernames = dao.getCommitteeMemberName();
		
		int totalNoOfReviews = 0;
		int totalNoOfReviewsDone = 0;
		
	
	
		ArrayList<CommitteeProgress> committeeProgressAL = new ArrayList<CommitteeProgress>();
		CommitteeProgress committeeProgress;
	
		for(int i = 0 , j = 0 , k = 0 ; i < committeeUsernames.size() ; i++){
		
			if(((Object[])committeeUsernames.get(i))[1].toString().trim().equals("2") || ((Object[])committeeUsernames.get(i))[1].toString().trim().equals("3"))
				continue;
			
			committeeProgress = new CommitteeProgress();
			committeeProgress.setCommitteeMemberName(((Object[])committeeUsernames.get(i))[0].toString().trim());
			committeeProgress.setTotalNoOfMastersStudentsAllotted(Integer.parseInt(((Object[])msTotal.get(i))[1].toString()));
			committeeProgress.setTotalNoOfPHDStudentsAllotted(Integer.parseInt(((Object[])phdTotal.get(i))[1].toString()));
			if(j < msDone.size() && ((Object[])msDone.get(j))[0].toString().equalsIgnoreCase(committeeProgress.getCommitteeMemberName())){
				committeeProgress.setTotalNoOfMastersStudentCompleted(Integer.parseInt(((Object[])msDone.get(j++))[1].toString()));
			}
			if(k < phdDone.size() && ((Object[])phdDone.get(k))[0].toString().equalsIgnoreCase(committeeProgress.getCommitteeMemberName())){
				committeeProgress.setTotalNoOfPHDStudentCompleted(Integer.parseInt(((Object[])phdDone.get(k++))[1].toString()));
			}
			committeeProgressAL.add(committeeProgress);
		}
		
		for(int i = 0 ; i < committeeProgressAL.size() ; i++){
			
			totalNoOfReviews += committeeProgressAL.get(i).getTotalNoOfMastersStudentsAllotted() + committeeProgressAL.get(i).getTotalNoOfPHDStudentsAllotted();
			totalNoOfReviewsDone += committeeProgressAL.get(i).getTotalNoOfMastersStudentCompleted() + committeeProgressAL.get(i).getTotalNoOfPHDStudentCompleted();
		}
		
		
		request.setAttribute("totalNoOfReviews", totalNoOfReviews);
		request.setAttribute("totalNoOfReviewsDone", totalNoOfReviewsDone);
		request.setAttribute("CommitteeReveiws", committeeProgressAL);
		
		return mapping.findForward("success");
		
		}
	
		
}


