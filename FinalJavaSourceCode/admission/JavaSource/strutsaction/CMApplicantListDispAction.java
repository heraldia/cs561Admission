package strutsaction;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import servletsession.AuthorityUtil;

import dao.ApplicantDAO;
import dao.CMApplicantListDAO;
import dao.DutyAssignDAO;
import edu.utils.FinalConstant;
import model.Applicant;
import model.Note;
import model.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import actionform.CMEvalApplicantForm;


public class CMApplicantListDispAction extends DispBaseAction {
	
	public ActionForward all(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
	
		int committeeID = AuthorityUtil.getUser(request).getUid();
		
		CMApplicantListDAO dao = new CMApplicantListDAO();
		List applicants = dao.getAssignedApplicants(committeeID);
		List cmapplicantsI = dao.getCompletedApplicantsID(committeeID);
		List appNotes = dao.getApplicantsNote();
		List newresult = new ArrayList();
		
		for(int i=0; i<applicants.size(); i++ )
		{
			List<Applicant> a = (List<Applicant>)applicants.get(i);
			Applicant at = a.get(0);
			Integer id = (Integer)at.getApplicantId();
			String lname = (String)at.getNameLast();
			String fname = (String)at.getNameFirst();
			Integer tofel = (Integer)at.getToeflScore();
			Integer grev = (Integer)at.getGreVerbalScore();
			Integer greq = (Integer)at.getGreQuantitativeScore();
			Double grew = (Double)at.getGreWritingScore();
			Double ielts = (Double)at.getIeltsScore();
			String ds = (String)at.getDegreeSought();
			String ri = (String)at.getResearchInterest();
			String email = (String)at.getEmail();
			String country = (String)at.getCitizenCountry();
			String ref1 = (String)at.getReferenceName1();
			String ref2 = (String)at.getReferenceName2();
			String ref3 = (String)at.getReferenceName3();
			
			String done = "N";
			if(cmapplicantsI.contains(id))
			{
				done = "Y";
			}
			
			String note = "";
			Note n = (Note)at.getNote();
			if(n != null)
			{
				note = n.getNote();
			}
			
					
			List t = new ArrayList();
 			t.add(id);     	//0
 			t.add(lname);	//1
 			t.add(fname);	//2
 			t.add(tofel);	//3
 			t.add(grev);	//4
 			t.add(greq);	//5
 			t.add(grew);	//6
 			t.add(ielts);	//7
 			t.add(ds);		//8
 			t.add(ri);		//9
 			t.add(email);	//10
 			t.add(country);	//11
 			t.add(ref1);	//12
 			t.add(ref2);	//13
 			t.add(ref3);	//14
 			t.add(done);	//15
 			t.add(note);	//16
 			
 			
 			newresult.add(t);
		}
		
		
		
		request.setAttribute( "applicants", newresult );
		
		
		
		/* *************** Random Part Start****************** 
		 System.out.println("**********************Random Part Start*********************************");
		 DutyAssignDAO c = new DutyAssignDAO();
		List appIDList= c.getApplicants();
	     
	      for(int i =0; i< appIDList.size();i++)
	      {
	    	 // System.out.println(appIDList.get(i));
	      }
	     
	      List cmIdList = c.getCommittee();
	      
	      for(int i =0; i< cmIdList.size();i++)
	      {
	    	 // System.out.println(cmIdList.get(i));
	      }
	     
	      
	      // Define committee array
	      Integer[] cmArr = new  Integer[appIDList.size()*2];
	      int cm = 0;
	      for(int i=0; i<appIDList.size()*2; i++)
	      {
	    	  cmArr[i] = (Integer)cmIdList.get(cm);
	    	  cm ++;
	    	  if(cm >= cmIdList.size())
	    	  {
	    		  cm = 0;
	    	  }
	    	  
	      }
	      
	      System.out.println("Assigned numbers");
	      int[][] tempAssignArr = new int[appIDList.size()][3];
	      cm = 0;
	      for(int i=0; i<appIDList.size(); i++)
	      {
	    	  tempAssignArr[i][0] = (Integer)appIDList.get(i);
	    	  if(cm <= cmIdList.size()-2)
	    	  {
	    		  tempAssignArr[i][1] = (Integer)cmIdList.get(cm);
	    		  tempAssignArr[i][2] = (Integer)cmIdList.get(cm+1);
	    		  cm += 2;
	    	  }
	    	  else if (cm == cmIdList.size()-1)
	    	  {
	    		  tempAssignArr[i][1] = (Integer)cmIdList.get(cm);
	    		  cm = 0;
	    		  tempAssignArr[i][2] = (Integer)cmIdList.get(cm);
	    		  cm++;
	    	  }
	    	  else// (cm > cmIdList.size())
	    	  {
	    		  cm = 0;
	    		  tempAssignArr[i][1] = (Integer)cmIdList.get(cm);
	    		  tempAssignArr[i][2] = (Integer)cmIdList.get(cm+1);
	    		  cm += 2;
	    	  }
	    	//  System.out.println( tempAssignArr[i][0] + ","+tempAssignArr[i][1] + "," +tempAssignArr[i][2] );
	      }
	      
	     int[][] appCmAssignArr = new int[appIDList.size()*2][2];
	     int t = 0;
	     for(int i=0; i<appIDList.size(); i++)
	     {
	    	 //(ApplicantID,CommitteeID1)
	    	 appCmAssignArr[t][0] = tempAssignArr[i][0];
	    	 appCmAssignArr[t][1] = tempAssignArr[i][1];
	    	 
	    	 System.out.println( appCmAssignArr[t][0] + ","+appCmAssignArr[t][1]);
	    	 
	    	 t++;
	    	 
	    	//(ApplicantID,CommitteeID2)
	    	 appCmAssignArr[t][0] = tempAssignArr[i][0];
	    	 appCmAssignArr[t][1] = tempAssignArr[i][2];
	    	 
	    	 System.out.println( appCmAssignArr[t][0] + ","+appCmAssignArr[t][1]);
	    	 t++;
	     }
	     System.out.println("**********************XXXXXXX*********************************");
	      
	      String msg = c.initDutyAssign(appCmAssignArr);
	  //    System.out.println(msg);
	      System.out.println("**********************Random Part End*********************************");
	     *************** Random Part End****************** */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return mapping.findForward( "CMApplicantsList" );
   
	
	}
	
	

	
	public ActionForward MS(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {

			int committeeID = AuthorityUtil.getUser(request).getUid();
		
			CMApplicantListDAO dao = new CMApplicantListDAO();
			List applicants = dao.getAssignedMSApplicants(committeeID);
			List appNotes = dao.getApplicantsNote();
			List cmapplicantsI = dao.getCompletedApplicantsID(committeeID);
			List newresult = new ArrayList();
			
			for(int i=0; i<applicants.size(); i++ )
			{
				List<Applicant> a = (List<Applicant>)applicants.get(i);
				Applicant at = a.get(0);
				Integer id = (Integer)at.getApplicantId();
				String lname = (String)at.getNameLast();
				String fname = (String)at.getNameFirst();
				Integer tofel = (Integer)at.getToeflScore();
				Integer grev = (Integer)at.getGreVerbalScore();
				Integer greq = (Integer)at.getGreQuantitativeScore();
				Double grew = (Double)at.getGreWritingScore();
				Double ielts = (Double)at.getIeltsScore();
				String ds = (String)at.getDegreeSought();
				String ri = (String)at.getResearchInterest();
				String email = (String)at.getEmail();
				String country = (String)at.getCitizenCountry();
				String ref1 = (String)at.getReferenceName1();
				String ref2 = (String)at.getReferenceName2();
				String ref3 = (String)at.getReferenceName3();
				
				String done = "N";
				if(cmapplicantsI.contains(id))
				{
					done = "Y";
				}
				

				String note = "";
				Note n = (Note)at.getNote();
				if(n != null)
				{
					note = n.getNote();
				}
				
							
				List t = new ArrayList();
	 			t.add(id);     	//0
	 			t.add(lname);	//1
	 			t.add(fname);	//2
	 			t.add(tofel);	//3
	 			t.add(grev);	//4
	 			t.add(greq);	//5
	 			t.add(grew);	//6
	 			t.add(ielts);	//7
	 			t.add(ds);		//8
	 			t.add(ri);		//9
	 			t.add(email);	//10
	 			t.add(country);	//11
	 			t.add(ref1);	//12
	 			t.add(ref2);	//13
	 			t.add(ref3);	//14
	 			t.add(done);	//15
	 			t.add(note);	//16
	 			
	 			newresult.add(t);
			}
			
			
			
			request.setAttribute( "applicants", newresult );
			
		
			return mapping.findForward( "CMApplicantsList" );
		}
	
	public ActionForward PHD(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {

			int committeeID = AuthorityUtil.getUser(request).getUid();
		
			CMApplicantListDAO dao = new CMApplicantListDAO();
			List applicants = dao.getAssignedPHDApplicants(committeeID);
			List appNotes = dao.getApplicantsNote();
			List cmapplicantsI = dao.getCompletedApplicantsID(committeeID);
			List newresult = new ArrayList();
			
			for(int i=0; i<applicants.size(); i++ )
			{
				List<Applicant> a = (List<Applicant>)applicants.get(i);
				Applicant at = a.get(0);
				Integer id = (Integer)at.getApplicantId();
				String lname = (String)at.getNameLast();
				String fname = (String)at.getNameFirst();
				Integer tofel = (Integer)at.getToeflScore();
				Integer grev = (Integer)at.getGreVerbalScore();
				Integer greq = (Integer)at.getGreQuantitativeScore();
				Double grew = (Double)at.getGreWritingScore();
				Double ielts = (Double)at.getIeltsScore();
				String ds = (String)at.getDegreeSought();
				String ri = (String)at.getResearchInterest();
				String email = (String)at.getEmail();
				String country = (String)at.getCitizenCountry();
				String ref1 = (String)at.getReferenceName1();
				String ref2 = (String)at.getReferenceName2();
				String ref3 = (String)at.getReferenceName3();
				
				String done = "N";
				if(cmapplicantsI.contains(id))
				{
					done = "Y";
				}

				String note = "";
				Note n = (Note)at.getNote();
				if(n != null)
				{
					note = n.getNote();
				}
				
				
				List t = new ArrayList();
	 			t.add(id);     	//0
	 			t.add(lname);	//1
	 			t.add(fname);	//2
	 			t.add(tofel);	//3
	 			t.add(grev);	//4
	 			t.add(greq);	//5
	 			t.add(grew);	//6
	 			t.add(ielts);	//7
	 			t.add(ds);		//8
	 			t.add(ri);		//9
	 			t.add(email);	//10
	 			t.add(country);	//11
	 			t.add(ref1);	//12
	 			t.add(ref2);	//13
	 			t.add(ref3);	//14
	 			t.add(done);	//15
	 			t.add(note);	//16
	 			
	 			newresult.add(t);
			}
			
			
			
			request.setAttribute( "applicants", newresult );
			
			return mapping.findForward( "CMApplicantsList" );
		}
	
	
	public ActionForward allPaging(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		
		    int n = 0;
//		    		request.getAttribute(n);
			ApplicantDAO dao = new ApplicantDAO();
			List applicants = dao.getAllApplicantsPaging(n, FinalConstant.PAGINGSTEP);
			request.setAttribute( "applicants", applicants );
			
			return mapping.findForward( "CMApplicantsList" );
		}

		public ActionForward msPaging(
				ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response) throws Exception {

			 int n = 0;
//					 request.getAttribute(n);
				ApplicantDAO dao = new ApplicantDAO();
				List applicants = dao.getMsApplicantsPaging(n, FinalConstant.PAGINGSTEP);
				request.setAttribute( "applicants", applicants );
				
				return mapping.findForward( "CMApplicantsList" );
			}
		
		public ActionForward phdPaging(
				ActionMapping mapping,
				ActionForm form,
				HttpServletRequest request,
				HttpServletResponse response) throws Exception {

			    int n = 0;
//			    		Integer.parseInt(request.getParameter(String.valueOf(page)));
				ApplicantDAO dao = new ApplicantDAO();
				List applicants = dao.getPhdApplicantsPaging(n, FinalConstant.PAGINGSTEP);
				request.setAttribute( "applicants", applicants );
				
				return mapping.findForward( "CMApplicantsList" );
			}
		
	
	

}
