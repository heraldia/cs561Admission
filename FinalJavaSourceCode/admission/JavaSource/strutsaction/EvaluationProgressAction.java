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
import edu.utils.FinalConstant;
import model.Applicant;
import model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EvaluationProgressAction extends DispBaseAction{
	
	public ActionForward all(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception
	
			{
		     	int committeeID = AuthorityUtil.getUser(request).getUid();
			
		     	CMApplicantListDAO c = new CMApplicantListDAO();
		     	List result=c.evaluatePro();
		     	List newresult = new ArrayList();
		     	List availableID = new ArrayList();
		     
		     	for(int i = 0; i<result.size(); i++)
		     	{
		     		List<Object[]> objs = (List<Object[]>)result.get(i);
		     	 
		     		Integer id = 0;
		     		String lname = "";
		     		String fname = "";
		     		Integer score1 = 0;
		     		Integer score2 = 0;
		     		Integer totalScore = 0;
		     		String ds = "";
		     		String email = "";
		     		String done1 = "";
		     		String done2 = "";
		     	
		     		if(objs.size()>1)
		     		{
		     			Object[] o1 = objs.get(0);
		     			id = (Integer)o1[0];
		     			lname = (String)o1[1];
		     			fname = (String)o1[2];
		     			ds = (String)o1[3];
		     			email = (String)o1[4];
		     			score1 = (Integer)o1[5];
		     			done1 = (String)o1[6];
     			
		     			Object[] o2 = objs.get(1);
		     			score2 = (Integer)o2[5];
		     			done2 = (String)o2[6];
		     			totalScore = score1 + score2;
		     		}
		     	 
		     		else
		     		{
		     			Object[] o1 = objs.get(0);
		     			id = (Integer)o1[0];
		     			lname = (String)o1[1];
		     			fname = (String)o1[2];
		     			ds = (String)o1[3];
		     			email = (String)o1[4];
		     			score1 = (Integer)o1[5];
		     			done1 = (String)o1[6];
		     			
		     			score2 = 0;
		     			done2 = "N";
		     			
		     			totalScore = score1 + score2;
		     		}
		     	
		     		if(!availableID.contains(id))
		     		{
		     			availableID.add(id);
		     			List t = new ArrayList();
		     			t.add(id);		//0
		     			t.add(lname);	//1
		     			t.add(fname);	//2
		     			t.add(score1);	//3
		     			t.add(score2);	//4
		     			t.add(totalScore);	//5
		     			t.add(ds);			//6
		     			t.add(email);		//7
		     			t.add(done1);		//8
		     			t.add(done2);		//9
		     			
		     			newresult.add(t);
		        	
		     		}
		     	
		     	}
		     	
		     	     	
		     	
		     	request.setAttribute( "evalProgress", newresult );
		     	
			
			return mapping.findForward("EvaluatedList");
		   }
	
	
	
	
	public ActionForward MS(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception
	
			{
		     	int committeeID = AuthorityUtil.getUser(request).getUid();
			
		     	CMApplicantListDAO c = new CMApplicantListDAO();
		     	List result=c.evaluateMSPro();
		     	List newresult = new ArrayList();
		     	List availableID = new ArrayList();
		     
		     	for(int i = 0; i<result.size(); i++)
		     	{
		     		List<Object[]> objs = (List<Object[]>)result.get(i);
		     	 
		     		Integer id = 0;
		     		String lname = "";
		     		String fname = "";
		     		Integer score1 = 0;
		     		Integer score2 = 0;
		     		Integer totalScore = 0;
		     		String ds = "";
		     		String email = "";
		     		String done1 = "";
		     		String done2 = "";
		     	
		     		if(objs.size()>1)
		     		{
		     			Object[] o1 = objs.get(0);
		     			id = (Integer)o1[0];
		     			lname = (String)o1[1];
		     			fname = (String)o1[2];
		     			ds = (String)o1[3];
		     			email = (String)o1[4];
		     			score1 = (Integer)o1[5];
		     			done1 = (String)o1[6];
     			
		     			Object[] o2 = objs.get(1);
		     			score2 = (Integer)o2[5];
		     			done2 = (String)o2[6];
		     			totalScore = score1 + score2;
		     		}
		     	 
		     		else
		     		{
		     			Object[] o1 = objs.get(0);
		     			id = (Integer)o1[0];
		     			lname = (String)o1[1];
		     			fname = (String)o1[2];
		     			ds = (String)o1[3];
		     			email = (String)o1[4];
		     			score1 = (Integer)o1[5];
		     			done1 = (String)o1[6];
		     			
		     			score2 = 0;
		     			done2 = "N";
		     			
		     			totalScore = score1 + score2;
		     		}
		     	
		     		if(!availableID.contains(id))
		     		{
		     			availableID.add(id);
		     			List t = new ArrayList();
		     			t.add(id);		//0
		     			t.add(lname);	//1
		     			t.add(fname);	//2
		     			t.add(score1);	//3
		     			t.add(score2);	//4
		     			t.add(totalScore);	//5
		     			t.add(ds);			//6
		     			t.add(email);		//7
		     			t.add(done1);		//8
		     			t.add(done2);		//9
		     			
		     			newresult.add(t);
		        	
		     		}
		     	
		     	}
		     	
		     	     	
		     	
		     	request.setAttribute( "evalProgress", newresult );
		     	
			
			return mapping.findForward("EvaluatedList");
		   }
			

	public ActionForward PHD(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception
	
			{
		     	int committeeID = AuthorityUtil.getUser(request).getUid();
			
		     	CMApplicantListDAO c = new CMApplicantListDAO();
		     	List result=c.evaluatePHDPro();
		     	List newresult = new ArrayList();
		     	List availableID = new ArrayList();
		     
		     	for(int i = 0; i<result.size(); i++)
		     	{
		     		List<Object[]> objs = (List<Object[]>)result.get(i);
		     	 
		     		Integer id = 0;
		     		String lname = "";
		     		String fname = "";
		     		Integer score1 = 0;
		     		Integer score2 = 0;
		     		Integer totalScore = 0;
		     		String ds = "";
		     		String email = "";
		     		String done1 = "";
		     		String done2 = "";
		     	
		     		if(objs.size()>1)
		     		{
		     			Object[] o1 = objs.get(0);
		     			id = (Integer)o1[0];
		     			lname = (String)o1[1];
		     			fname = (String)o1[2];
		     			ds = (String)o1[3];
		     			email = (String)o1[4];
		     			score1 = (Integer)o1[5];
		     			done1 = (String)o1[6];
     			
		     			Object[] o2 = objs.get(1);
		     			score2 = (Integer)o2[5];
		     			done2 = (String)o2[6];
		     			totalScore = score1 + score2;
		     		}
		     	 
		     		else
		     		{
		     			Object[] o1 = objs.get(0);
		     			id = (Integer)o1[0];
		     			lname = (String)o1[1];
		     			fname = (String)o1[2];
		     			ds = (String)o1[3];
		     			email = (String)o1[4];
		     			score1 = (Integer)o1[5];
		     			done1 = (String)o1[6];
		     			
		     			score2 = 0;
		     			done2 = "N";
		     			
		     			totalScore = score1 + score2;
		     		}
		     	
		     		if(!availableID.contains(id))
		     		{
		     			availableID.add(id);
		     			List t = new ArrayList();
		     			t.add(id);		//0
		     			t.add(lname);	//1
		     			t.add(fname);	//2
		     			t.add(score1);	//3
		     			t.add(score2);	//4
		     			t.add(totalScore);	//5
		     			t.add(ds);			//6
		     			t.add(email);		//7
		     			t.add(done1);		//8
		     			t.add(done2);		//9
		     			
		     			newresult.add(t);
		        	
		     		}
		     	
		     	}
		     	
		     	     	
		     	
		     	request.setAttribute( "evalProgress", newresult );
		     	
			
			return mapping.findForward("EvaluatedList");
		   }
			
		
	}
	


