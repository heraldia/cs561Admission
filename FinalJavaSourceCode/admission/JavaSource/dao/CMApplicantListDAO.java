package dao;


import exception.DAOException;
import model.Applicant;
import model.CommitteeProgress;
import model.User;
import model.DutyAssign;
import model.CommitteeRating;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import paginate.PageModel;




public class CMApplicantListDAO extends HibernateDAO{
	
	
	public List getApplicants()
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
        
        List appList = session.createQuery("from  Applicant").list();
        
        return appList;
		
	}
	
	public List getApplicantsID()
	{
	
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
        
        List appID = session.createQuery("select applicantId from  Applicant").list();
        
        return appID;
	}
	
	public List getUserID()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
        
        List cmID = session.createQuery("select uid from  User").list();
        
        return cmID;

	}
	
	public String initDutyAssign(int[][] appCm)
	{
		Session session1 = HibernateUtil.getSessionFactory().openSession();

		session1.beginTransaction();
		
        int result = session1.createQuery("delete from DutyAssign").executeUpdate();
        
        session1.getTransaction().commit();
		
		for(int i=0; i< appCm.length; i++)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			int appId = appCm[i][0];
			int cmId = appCm[i][1];
			
			DutyAssign ds = new DutyAssign();
			ds.setApplicantId(appId);
			ds.setCommittee(cmId);
			
			session.save(ds);
			
			session.getTransaction().commit();
		}
		
		String msg="Assignment Successfully Completed!";
		
		return msg;

			
	}
	
	public String setCommitteeRatings(int committeeID, int applicantID, int score, String comment, String ta,String fe,Timestamp d,String done)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		String msg="Record Already Exists!";
		List appset = session.createQuery(" from CommitteeRating where committeeId= :ppi and applicantId= :aid")
			 		.setParameter("ppi",committeeID )
			 		.setParameter("aid",applicantID )
			 		.list();
		 
		
			if(appset.isEmpty())
			{
				if(score!=0)
				{
					CommitteeRating cmr = new CommitteeRating();
					cmr.setCommitteeId(committeeID);
					cmr.setApplicantId(applicantID);
					cmr.setTotalScore(score);
					cmr.setComments(comment);
					cmr.setTa(ta);
					cmr.setFellowship(fe);
					cmr.setDate(d);
					cmr.setDone(done);
		
					session.save(cmr);
					session.getTransaction().commit();
		
					setDutyAssign(applicantID,done,d);
		
					msg="Successfully Updated!";
				}
				else
				{
					msg="Check the values you Entered!!";
					
				}
		}
		
		
		return msg;

			
	}
	
	public void setDutyAssign(int applicantID,String done,Timestamp d)
	{
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
        int result = session.createQuery("update DutyAssign D set D.done = :status, D.date = :dateof where D.applicantId = :i").setParameter("status",done).setParameter("dateof",d).setParameter("i",applicantID).executeUpdate();
        
        session.getTransaction().commit();
	
		
	}
	
	public List getAssignedApplicants(int committeID)throws Exception
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
		
        List appset = session.createQuery("select applicantId from DutyAssign where committee = :ppi")
         		.setParameter("ppi",committeID )
         		.list();
		
        List applicantList = new ArrayList();
        
        for(int i=0;i<appset.size();i++)
   	   {

         
         List allapp=session.createQuery("from Applicant where applicantId= :api")
            .setParameter("api",appset.get(i))
             .list();
         
         if(!allapp.isEmpty())
         applicantList.add(allapp);
   	   }
        
        return applicantList;
	}
	
	public List getAssignedMSApplicants(int committeID)throws Exception
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
		
        List appset = session.createQuery("select applicantId from DutyAssign where committee = :ppi")
         		.setParameter("ppi",committeID )
         		.list();
		
        List applicantList = new ArrayList();
        
        for(int i=0;i<appset.size();i++)
   	   {

         
        List allapp=session.createQuery("from Applicant where applicantId= :api and degreeSought= :d")
        	      .setParameter("api",appset.get(i))
        	      .setParameter("d","MS")
        	      .list();
         
         if(!allapp.isEmpty())
         applicantList.add(allapp);
   	   }
        
        return applicantList;
	}
	
	public List getAssignedPHDApplicants(int committeID)throws Exception
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
		
        List appset = session.createQuery("select applicantId from DutyAssign where committee = :ppi")
         		.setParameter("ppi",committeID )
         		.list();
		
        List applicantList = new ArrayList();
        
        for(int i=0;i<appset.size();i++)
   	   {

         
         List allapp=session.createQuery("from Applicant where applicantId= :api and degreeSought= :d")
            .setParameter("api",appset.get(i))
            .setParameter("d","PHD")
             .list();
         
         if(!allapp.isEmpty())
         applicantList.add(allapp);
   	   }
        
        return applicantList;
        
	}
	
	public List getCompletedApplicantsID(int committeID) throws Exception
	{
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

       // String hsql ="Select applicantId from committeeratings where committeeId= committeID ";
        
        List appset = session.createQuery("select applicantId from CommitteeRating where committeeId = :ppi and done = :y")
 		.setParameter("ppi",committeID )
 		.setParameter("y","Y")
 		.list();
        
        return appset;
	}
	
	public List getApplicantsNote() throws Exception
	{
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

       // String hsql ="Select applicantId from committeeratings where committeeId= committeID ";
        
        List appNote = session.createQuery("from Note").list();
        
        return appNote;
	}
	
	public List getCompletedApplicants(int committeID) throws Exception
	{

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

       // String hsql ="Select applicantId from committeeratings where committeeId= committeID ";
        
        List appset = session.createQuery("select applicantId from CommitteeRating where committeeId = :ppi and done = :y")
 		.setParameter("ppi",committeID )
 		.setParameter("y","Y")
 		.list();
        
       List applicantList = new ArrayList();
       
        
        for(int i=0;i<appset.size();i++)
  	   {

        
        List allapp=session.createQuery("from Applicant where applicantId= :api")
           .setParameter("api",appset.get(i))
            .list();
        
        if(!allapp.isEmpty())
        applicantList.add(allapp);
  	   }
      //  return (session.createQuery("select u.username from User u order by u.username asc")).list();
	  // String hsql = "select applicantId, totalScore from CommitteeRating ";  working
     //  return super.getObjects(hsql);
		
        return applicantList;
   
	}
	
	public List getMsCompletedApplicants(int committeID)
	{
		Session session1 = HibernateUtil.getSessionFactory().openSession();

		session1.beginTransaction();

       // String hsql ="Select applicantId from committeeratings where committeeId= committeID ";
        
        List appset = session1.createQuery("select applicantId from CommitteeRating where committeeId = :ppi and done = :y")
 		.setParameter("ppi",committeID )
 		.setParameter("y","Y")
 		.list();
        
       List applicantList = new ArrayList();
       
        
        for(int i=0;i<appset.size();i++)
  	   {

        
        List allapp=session1.createQuery("from Applicant where applicantId= :api and degreeSought= :d" )
           .setParameter("api",appset.get(i))
           .setParameter("d","MS")
            .list();
        if(!allapp.isEmpty())
        applicantList.add(allapp);
  	   }
   
		
        return applicantList;
	}
	
	public List getPhdCompletedApplicants(int committeID)
	{
		Session session1 = HibernateUtil.getSessionFactory().openSession();

		session1.beginTransaction();

       // String hsql ="Select applicantId from committeeratings where committeeId= committeID ";
        
        List appset = session1.createQuery("select applicantId from CommitteeRating where committeeId = :ppi and done = :y")
 		.setParameter("ppi",committeID )
 		.setParameter("y","Y")
 		.list();
        
       List applicantList = new ArrayList();
       
        
        for(int i=0;i<appset.size();i++)
  	   {

        
        List allapp=session1.createQuery("from Applicant where applicantId= :api and degreeSought= :d" )
           .setParameter("api",appset.get(i))
           .setParameter("d","PHD")
            .list();
        if(!allapp.isEmpty())
        applicantList.add(allapp);
  	   }
		
        return applicantList;
	}
	
	public List evaluatePro()
	{
		Session session1 = HibernateUtil.getSessionFactory().openSession();

		session1.beginTransaction();

		List applicantScore = new ArrayList();
       	List appid = session1.createQuery("select applicantId from CommitteeRating").list();
	        
		
        for(int i=0;i<appid.size();i++)
  	   {

        List allapp=session1.createQuery("select C.applicantId, A.nameLast, A.nameFirst, A.degreeSought, A.email, C.totalScore, C.done from CommitteeRating C, Applicant A where  C.applicantId = A.applicantId and C.applicantId= :api")
           .setParameter("api",appid.get(i)).list();
        
        if(!allapp.isEmpty())
        	applicantScore.add(allapp);
        
  	   }
  	   
        return applicantScore;
		
	}
	
	
	public List evaluateMSPro()
	{
		Session session1 = HibernateUtil.getSessionFactory().openSession();

		session1.beginTransaction();

		List applicantScore = new ArrayList();
       	List appid = session1.createQuery("select applicantId from CommitteeRating").list();
	        
		
        for(int i=0;i<appid.size();i++)
  	   {

        List allapp=session1.createQuery("select C.applicantId, A.nameLast, A.nameFirst, A.degreeSought, A.email, C.totalScore, C.done from CommitteeRating C, Applicant A where  C.applicantId = A.applicantId and A.degreeSought= :d and C.applicantId= :api")
           .setParameter("api",appid.get(i))
           .setParameter("d","MS")
           .list();
        
        if(!allapp.isEmpty())
        	applicantScore.add(allapp);
        
  	   }
  	   
        return applicantScore;
		
	}
	
	
	public List evaluatePHDPro()
	{
		Session session1 = HibernateUtil.getSessionFactory().openSession();

		session1.beginTransaction();

		List applicantScore = new ArrayList();
       	List appid = session1.createQuery("select applicantId from CommitteeRating").list();
	        
		
        for(int i=0;i<appid.size();i++)
  	   {

        	List allapp=session1.createQuery("select C.applicantId, A.nameLast, A.nameFirst, A.degreeSought, A.email, C.totalScore, C.done from CommitteeRating C, Applicant A where  C.applicantId = A.applicantId and A.degreeSought= :d and C.applicantId= :api")
        	           .setParameter("api",appid.get(i))
        	           .setParameter("d","PHD")
        	           .list();
        
        if(!allapp.isEmpty())
        	applicantScore.add(allapp);
        
  	   }
  	   
        return applicantScore;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//page formattings
	public List getAllApplicantsPaging(int n, int m)
	{
		return super.cutPage("from Applicant", n ,m);
	}
	
	public List getPhdApplicantsPaging(int n, int m)
	{
		return super.cutPage("from Applicant a where a.degreeSought='PHD'", n ,m);
	}
	
	public List getMsApplicantsPaging(int n, int m)
	{
		return super.cutPage("from Applicant a where a.degreeSought='MS'", n ,m);
	}
	

}
