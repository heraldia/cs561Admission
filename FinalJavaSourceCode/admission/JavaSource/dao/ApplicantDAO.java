package dao;

import exception.DAOException;
import model.Applicant;
import model.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import paginate.PageModel;

public class ApplicantDAO extends HibernateDAO {

	/**
	 * save Applicant
	 * @param applicant : an applicant object
	 * @return void
	 */
	public void saveApplicant(Applicant applicant)
	{
		super.saveObject(applicant);
	}
	
	/**
	 * save all the Applicants in an arraylist
	 * @param applicant : an arraylist of applicant objects
	 * @return void
	 */
	public void saveApplicants(ArrayList<Applicant> applicants){
		for(int i = 0 ; i < applicants.size() ; i++){
			super.saveObject(applicants.get(i));
		}
	}

	/**ps
	 * @param applicant
	 */
	/*
	public void saveApplicant(Applicant applicant)
	{
		if (applicant == null)
			return;

		Applicant applicant2 = getApplicant(String.valueOf(applicant.getApplicantId()));
		if (applicant2 != null)
			throw new DAOException("Duplicated applicants");

		super.saveObject(applicant);
	}
*/
	/**
	 * get all applicants
	 * @return List of all applicants
	 */
	public List getApplicants()
	{
		String hsql = "from Applicant";
		return super.getObjects(hsql);
	}
	
	/*
	 * This function returns true if email exits else returns false
	 * @param emailid
	 * @return boolean
	 */
	public boolean isEmailIdExists(String emailid){
		Applicant u = (Applicant) getObject("from Applicant u where u.email = '" + emailid
				+ "'");
		
		if (u != null){
			return true;	// email id was found , returning true
		}
		return false; // no email id found, returning false
	}
	
	/**
	 * return the number of applicants
	 * @return int
	 */
	public int getLastId(){
		
		long count = (Long)getObject("select count(*) from Applicant");
		if(count == 0)
			return 0;
		int u = (Integer) getObject("select max(applicantId) from Applicant");
		return u;

	}
/*
	public void deleteApplicant(String id, String userId)
	{
		User user = (User)getObject( User.class, userId );
		if( user==null ) {
			throw new DAOException( "Couldn't user!" );
		}
		
		Applicant m = null;
		
		Iterator it = user.getApplicant().iterator();
		while( it.hasNext() ) {
			Applicant applicant = (Applicant)it.next();
			if( applicant.getId().equals( id ) ) {
				m = applicant;
			}
		}
		if( m!=null ) {
			deleteObject( m );
			user.getApplicants().remove( m );
		}
	}
*/
	/**
	 * get an applicant via object id
	 * @return an applicant
	 */
	public Applicant getApplicant(Long id)
	{
		return (Applicant) getObject(Applicant.class, id);
	}

	/**
	 * get an applicant via applicantId
	 * @return an applicant
	 */
	public Applicant getApplicant(int applicantId)
	{
		Applicant u = (Applicant) getObject("from Applicant u where u.applicantId = '" + applicantId
				+ "'");
		return u;
	}
	/**
	 * update an applicant via object 
	 * @return void
	 */
	public void updateApplicant(Applicant applicant)
	{
		updateObject(applicant);
	}

	/**
	 * get all PHD applicant 
	 * @return List of applicants
	 */
	public List getPhdApplicants() {
		String hsql = "from Applicant a where a.degreeSought='PHD' ";
		return super.getObjects(hsql);
	}

	/**
	 * get all MS applicant 
	 * @return List of applicants
	 */
	public List getMsApplicants() {
		String hsql = "from Applicant a where a.degreeSought='MS'";
		return super.getObjects(hsql);
	}

	/**
	 * get all applicant 
	 * @return List of applicants
	 */
	public List getAllApplicantsPaging(int n, int m)
	{
		return super.cutPage("from Applicant", n ,m);
	}
	
	/**
	 * get all PHD applicant 
	 * @return List of applicants
	 */
	public List getPhdApplicantsPaging(int n, int m)
	{
		return super.cutPage("from Applicant a where a.degreeSought='PHD'", n ,m);
	}
	
	/**
	 * get all MS applicant 
	 * @return List of applicants
	 */
	public List getMsApplicantsPaging(int n, int m)
	{
		return super.cutPage("from Applicant a where a.degreeSought='MS'", n ,m);
	}
	
	/**
	 * get all PHD applicant  which has "like" word
	 * @return List of applicants
	 */
	public List getApplicantsByLikeList(String like) {
		String hsql = "from Applicant a where a.nameLast like '%" + like + "%' or  a.nameFirst like'%" + like + "%'";
		return super.getObjects(hsql);
	}
	
	public List getApplicantsByLikeListCriteria(String like) {
		String hsql = "from Applicant a where a.nameLast like '%" + like + "%' or  a.nameFirst like'%" + like + "%'";
//		Criteria criteria = 
//		return result;
		return null;
	}
/*
	public void deleteReplyApplicant(String id, String userId) {
		ReplyApplicant reply = (ReplyApplicant)getObject( ReplyApplicant.class, id );
		if( reply==null ) {
			throw new DAOException("reply==null");
		}
		
		Applicant applicant = reply.getApplicant();
		Iterator it = applicant.getReplies().iterator();
		while( it.hasNext() ) {
			ReplyApplicant r = (ReplyApplicant)it.next();
			if( r.getId().equals( id ) ) {
				applicant.getReplies().remove( r );
			}
		}
	}
*/
  /* public PageModel findAllApplicant(String queryString, int pageNo, int pageSize){
		List applicantList = new ArrayList();
		if (queryString != null && !"".equals(queryString)) {
			applicantList = getHibernateTemplate().executeFind(new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					return session.createQuery("from Applicant i where i.applicantNo like ? or i.applicantName like ? order by i.applicantNo")
								.setParameter(0, "%" + queryString + "%")
								.setParameter(1, "%" + queryString + "%")
								.setFirstResult((pageNo-1) * pageSize)
								.setMaxResults(pageSize)
								.list();
				}
			});
			
		}else {
			applicantList = getHibernateTemplate().executeFind(new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					return session.createQuery("from Applicant i join fetch i.applicantCategory join fetch i.applicantUnit order by i.applicantNo")
								.setFirstResult((pageNo-1) * pageSize)
								.setMaxResults(pageSize)
								.list();
				}
			});
		}
		PageModel pageModel = new PageModel();
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		pageModel.setList(applicantList);
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
}
