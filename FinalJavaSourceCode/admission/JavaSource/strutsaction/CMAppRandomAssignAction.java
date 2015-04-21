package strutsaction;
import java.sql.Timestamp;
import java.util.List;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionform.CMEvalApplicantForm;

import servletsession.AuthorityUtil;

import dao.ApplicantDAO;
import dao.CMApplicantListDAO;
import dao.DutyAssignDAO;
import edu.utils.FinalConstant;
import model.Applicant;
import model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class CMAppRandomAssignAction {
	
	public ActionForward all(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception
	
			{
      
		
		/* *************** Random Part Start****************** */
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
	    /* *************** Random Part End****************** */
		
		
				
			
			return mapping.findForward("RandomAssignList");
		   }
	
	

}
