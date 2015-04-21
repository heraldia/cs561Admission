package dao;

import exception.DAOException;
import model.CommitteeRating;
import model.DutyAssign;
import model.User;
import model.Applicant;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.opensymphony.xwork2.util.ArrayUtils;

import paginate.PageModel;

public class DutyAssignDAO extends HibernateDAO {


	public void saveDutyAssign(DutyAssign dutyAssign)
	{
		super.saveObject(dutyAssign);
	}

	/**ps
	 * @param dutyAssign
	 */
	/*
	public void saveDutyAssign(DutyAssign dutyAssign)
	{
		if (dutyAssign == null)
			return;

		DutyAssign dutyAssign2 = getDutyAssign(String.valueOf(dutyAssign.getDutyAssignId()));
		if (dutyAssign2 != null)
			throw new DAOException("Duplicated dutyAssigns");

		super.saveObject(dutyAssign);
	}
*/
	public List getDutyAssigns()
	{
		String hsql = "from DutyAssign";
		return super.getObjects(hsql);
	}

/*
	public void deleteDutyAssign(String id, String userId)
	{
		User user = (User)getObject( User.class, userId );
		if( user==null ) {
			throw new DAOException( "Couldn't user!" );
		}
		
		DutyAssign m = null;
		
		Iterator it = user.getDutyAssign().iterator();
		while( it.hasNext() ) {
			DutyAssign dutyAssign = (DutyAssign)it.next();
			if( dutyAssign.getId().equals( id ) ) {
				m = dutyAssign;
			}
		}
		if( m!=null ) {
			deleteObject( m );
			user.getDutyAssigns().remove( m );
		}
	}
*/

	public DutyAssign getDutyAssign(Long id)
	{
		return (DutyAssign) getObject(DutyAssign.class, id);
	}


	public void updateDutyAssign(DutyAssign dutyAssign)
	{
		updateObject(dutyAssign);
	}

/*
	public void deleteReplyDutyAssign(String id, String userId) {
		ReplyDutyAssign reply = (ReplyDutyAssign)getObject( ReplyDutyAssign.class, id );
		if( reply==null ) {
			throw new DAOException("reply==null");
		}
		
		DutyAssign dutyAssign = reply.getDutyAssign();
		Iterator it = dutyAssign.getReplies().iterator();
		while( it.hasNext() ) {
			ReplyDutyAssign r = (ReplyDutyAssign)it.next();
			if( r.getId().equals( id ) ) {
				dutyAssign.getReplies().remove( r );
			}
		}
	}
*/
  /* public PageModel findAllDutyAssign(String queryString, int pageNo, int pageSize){
		List dutyAssignList = new ArrayList();
		if (queryString != null && !"".equals(queryString)) {
			dutyAssignList = getHibernateTemplate().executeFind(new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					return session.createQuery("from DutyAssign i where i.dutyAssignNo like ? or i.dutyAssignName like ? order by i.dutyAssignNo")
								.setParameter(0, "%" + queryString + "%")
								.setParameter(1, "%" + queryString + "%")
								.setFirstResult((pageNo-1) * pageSize)
								.setMaxResults(pageSize)
								.list();
				}
			});
			
		}else {
			dutyAssignList = getHibernateTemplate().executeFind(new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					return session.createQuery("from DutyAssign i join fetch i.dutyAssignCategory join fetch i.dutyAssignUnit order by i.dutyAssignNo")
								.setFirstResult((pageNo-1) * pageSize)
								.setMaxResults(pageSize)
								.list();
				}
			});
		}
		PageModel pageModel = new PageModel();
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		pageModel.setList(dutyAssignList);
		pageModel.setTotalRecords(getTotalRecords(queryString));
		return pageModel;
	}*/
   
	/**
	 * return the number of records
	 * @param conn
	 * @param queryStr
	 * @return
	 */
	/*public int getTotalRecords(String queryString){

		int count = 0;
		if (queryString != null && !"".equals(queryString)) {
			count = ((Long)getSession().createQuery("select count(*) from Item i where i.itemNo like ? or i.itemName like ?")
							.setParameter(0,  "%" + queryString + "%")
							.setParameter(1,  "%" + queryString + "%")
							.uniqueResult()).intValue();
		}else {
			count = ((Long)getSession().createQuery("select count(*) from Item i")
					.uniqueResult()).intValue();
		}
		return count;
	}*/
	
	public List getApplicants()
	{

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

       // String hsql ="Select applicantId from committeeratings where committeeId= committeID ";
        
        List appset = session.createQuery("select applicantId from Applicant").list();
        
     
        return appset;
   
	}
	
	public List getCommittee()
	{

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

       // String hsql ="Select applicantId from committeeratings where committeeId= committeID ";
        
        List commset = session.createQuery("select uid from User where category= :a or category= :b ")
        		.setParameter("a", 0)
        		.setParameter("b", 1)
        		.list();
        
     
        return commset;
   
	}
	
	public int[][] prepareData()
	{
		
		List<Integer> appId = getApplicants();
		List<Integer> commId = getCommittee();
		
		int[] applicantsId=new int[appId.size()];
		int[] committeeId=new int[commId.size()];
		
		for (int i = 0; i < appId.size(); i++) {
			applicantsId[i] = appId.get(i);
		}
		
		for (int i = 0; i < commId.size(); i++) {
			committeeId[i] = commId.get(i);
		}
		
		
		

		
		
		//split applicants
		
		
		double a=(double)appId.size();
		double b=(double)commId.size();
		
		int upper_bound=(int)Math.ceil(a/b);
		
		int arr_Assigned[][]=new int[commId.size()][];//assigned
		
		  //number of groups = committee members
		  
		  int quotient = applicantsId.length / upper_bound;
		  boolean isRemainder = applicantsId.length % upper_bound == 0;
		  if(!isRemainder){
		   quotient ++;
		  }
		  int startPoint = 0;
		  for (int i = 0 ; i < quotient ; i ++ ) {
		   int arrayLength = ((startPoint + upper_bound) > applicantsId.length) ? applicantsId.length : (startPoint + upper_bound) ;
		   arr_Assigned[i] = Arrays.copyOfRange(applicantsId, startPoint, arrayLength);
		   for (int j : arr_Assigned[i]) {
		    System.out.println("Array " + i + " ::" + j);
		   }
		   startPoint = startPoint + upper_bound ;
		  }
		
		
		
		return arr_Assigned;
			
	}
	
	public int[][] assignment()
	{
		
		List<Integer> appId = getApplicants();
		List<Integer> commId = getCommittee();
		
		int[] applicantsId=new int[appId.size()];
		int[] committeeId=new int[commId.size()];
		
		int assigned[][]=new int[commId.size()][appId.size()];
		
		int i=0;
		int comid=0;
		System.out.print("*****************************************"+appId.size()+"************************************");
		while(true)
		{
			if(i<appId.size())
			{
				assigned[comid][i]=applicantsId[i];
				assigned[comid+1][i] =applicantsId[i];
			
				i++;
			}
			if(i==appId.size())
			{
				break;
			}
			
			
			if(comid<commId.size()-2)
			{
				comid++;
				
			}
			else
				comid=0;
			
			
		}
		
		
		return assigned;
		
		
	}
	
	public void inserttoDutyAssign()
	{
		
		 int[][] a= prepareData();
		 
		 List<Integer> commId = getCommittee();
		
		 Session session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();

			//First Assignment
			for(int i=0;i<commId.size();i++)
			{
				for(int j=0;j<a[i].length;j++)
				{
					DutyAssign da = new DutyAssign();
					da.setApplicantId(a[i][j]);
					da.setCommittee((int)commId.get(i));
				
					session.save(da);
					
				}
			}
			session.getTransaction().commit();
			
			Session session1 = HibernateUtil.getSessionFactory().openSession();

			session1.beginTransaction();

			
			int randomIndex=0;
			//Second Assignment
			for(int i=0;i<commId.size();i++)
			{
				System.out.println(commId.size());
				while(randomIndex==i) //select random set
				randomIndex= (int)(Math.random() * ((commId.size() - 1) + 1));
				
				for(int j=0;j<a[i].length;j++)
				{
					DutyAssign da = new DutyAssign();
					da.setApplicantId(a[randomIndex][j]);
					da.setCommittee((int)commId.get(i));
				
					session1.save(da);
					
				}
			}
			
			session1.getTransaction().commit();
	}
	
	
	
	public void inserttoDuty()
	{
		
		 int[][] a= assignment();
		 
		 List<Integer> commId = getCommittee();
		
		 Session session = HibernateUtil.getSessionFactory().openSession();

		 session.beginTransaction();

		 for(int i=0;i<commId.size();i++)
			{
				
				
				for(int j=0;j<a[i].length;j++)
				{
					DutyAssign da = new DutyAssign();
					da.setApplicantId(a[i][j]);
					da.setCommittee((int)commId.get(i));
				
					session.save(da);
					
				}
			}
			
			
			session.getTransaction().commit();
	}
	
	
	public String initDutyAssign(int[][] appCm)
	{
		Session session1 = HibernateUtil.getSessionFactory().openSession();

		session1.beginTransaction();
		
        int result = session1.createQuery("delete from DutyAssign").executeUpdate();
        
        session1.getTransaction().commit();
		
        Session session = HibernateUtil.getSessionFactory().openSession();
        
		for(int i=0; i< appCm.length; i++)
		{
			
			session.beginTransaction();
			
			int appId = appCm[i][0];
			int cmId = appCm[i][1];
			
			DutyAssign ds = new DutyAssign();
			ds.setApplicantId(appId);
			ds.setCommittee(cmId);
			
			session.save(ds);
			
			session.getTransaction().commit();
			System.out.println(appId + "," + cmId);
		}
		
		String msg="Assignment Successfully Completed!";
		
		return msg;

			
	}
}
